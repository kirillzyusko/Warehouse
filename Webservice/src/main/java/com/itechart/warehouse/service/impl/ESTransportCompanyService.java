package com.itechart.warehouse.service.impl;

import com.itechart.warehouse.dao.DriverDAO;
import com.itechart.warehouse.entity.Driver;
import com.itechart.warehouse.entity.TransportCompany;
import com.itechart.warehouse.service.elasticsearch.ElasticSearchDriver;
import com.itechart.warehouse.service.elasticsearch.ElasticSearchTransportCompany;
import com.itechart.warehouse.service.elasticsearch.SimilarityWrapper;
import com.itechart.warehouse.service.exception.DataAccessException;
import com.itechart.warehouse.service.exception.IllegalParametersException;
import com.itechart.warehouse.service.exception.ResourceNotFoundException;
import com.itechart.warehouse.service.services.ElasticSearchService;
import com.itechart.warehouse.service.services.TransportCompanyService;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Lenovo on 25.05.2017.
 */
@Service
public class ESTransportCompanyService implements ElasticSearchService{
    private final static Logger logger = LoggerFactory.getLogger(ESTransportCompanyService.class);
    private ElasticSearchTransportCompany elasticSearchTransportCompany = new ElasticSearchTransportCompany();
    private ElasticSearchDriver elasticSearchDriver = new ElasticSearchDriver();
    private DriverDAO driverDAO;
    private TransportCompanyService transportCompanyService;

    @Autowired
    public void setDriverDAO(DriverDAO driverDAO) {
        this.driverDAO = driverDAO;
    }

    @Autowired
    public void setTransportCompanyService(TransportCompanyService transportCompanyService) {
        this.transportCompanyService = transportCompanyService;
    }

    @PostConstruct
    public void initElasticSearchTransportCompany() throws Exception {
        logger.info("Start init action for es and transport company");
        List<TransportCompany> list = transportCompanyService.findAllTransportCompanies(-1, -1);
        for(TransportCompany tr : list){
            elasticSearchTransportCompany.delete(tr);
            elasticSearchTransportCompany.save(tr);
        }
        logger.info("Complete init for transport comapny (elastic search)");
    }

    @PostConstruct
    public void initElasticSearchDriver() throws Exception {
        logger.info("Start init action for es and driver");
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Driver.class);
        List<Driver> list = driverDAO.findAll(detachedCriteria, -1, -1);
        for(Driver dr : list){
            Long id_company = transportCompanyService.findWarehouseCompanyByTransportId(dr.getId()).getIdWarehouseCompany();
            elasticSearchDriver.delete(dr, id_company);
            elasticSearchDriver.save(dr, id_company);
        }
        System.out.println(list);
        logger.info("Complete init for driver (elastic search)");
    }

    @Override
    public List<SimilarityWrapper<TransportCompany>> searchTransportCompany(TransportCompany transportCompany){
        return elasticSearchTransportCompany.search(transportCompany);//todo если надо, то здесь можно нагрузить бизнес-логику и возвращать нормальный список
    }

    @Override
    @Transactional(readOnly = true)
    public List<SimilarityWrapper<Driver>> searchDriver(Driver driver)throws DataAccessException, IllegalParametersException, ResourceNotFoundException {
        Long id_company = transportCompanyService.findWarehouseCompanyByTransportId(driver.getId()).getIdWarehouseCompany();
        return elasticSearchDriver.search(driver, id_company);//todo если надо, то здесь можно нагрузить бизнес-логику и возвращать нормальный список
    }
}
