package com.itechart.warehouse.controller;

import com.itechart.warehouse.dao.exception.GenericDAOException;
import com.itechart.warehouse.dto.PriceListDTO;
import com.itechart.warehouse.entity.PriceList;
import com.itechart.warehouse.service.exception.DataAccessException;
import com.itechart.warehouse.service.exception.IllegalParametersException;
import com.itechart.warehouse.service.services.FinanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/finance")
@Validated
public class FinanceController {
    private FinanceService financeService;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public void setUserService(FinanceService financeService) {
        this.financeService = financeService;
    }

    @RequestMapping(value = "/priceList", method = RequestMethod.GET)
    public ResponseEntity<List<PriceList>> getAllPrices(){
        logger.info("getAllPrices");
        List<PriceList> priceList;
        try{
            priceList = financeService.findAllPrices(0, 0);
        } catch (DataAccessException e){
            logger.error("Error while retrieving all prices: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(priceList, HttpStatus.OK);
    }

    @RequestMapping(value = "/price/{storageType}", method = RequestMethod.GET)
    public ResponseEntity<List<PriceList>> getPricesForStorageSpaceType(@PathVariable(value = "storageType") Long id){
        logger.info("getPricesForStorageSpaceType");
        List<PriceList> priceList;
        try{
            priceList = financeService.findPricesForStorageSpaceType(id, 0, 0);
        } catch (DataAccessException e){
            logger.error("Error while retrieving prices: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(priceList, HttpStatus.OK);
    }

    @RequestMapping(value = "/date_price", method = RequestMethod.GET)
    public ResponseEntity<List<PriceList>> getPricesByDate(@Valid @RequestBody PriceListDTO priceDTO){
        logger.info("getPricesByDate: {}", priceDTO);
        List<PriceList> priceList;
        try{
            priceList = financeService.findPricesByDate(priceDTO, 0, 0);
        } catch (DataAccessException e){
            logger.error("Error while retrieving prices: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (IllegalParametersException e) {
            logger.error("Illegal parameters: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(priceList, HttpStatus.OK);
    }

    @RequestMapping(value = "/newPrice", method = RequestMethod.POST)
    public ResponseEntity<Void> updateUser(@Valid @RequestBody PriceListDTO priceDTO) {
        logger.info("Handling request for creating/updating price: {}", priceDTO);
        try {
            financeService.newPrice(priceDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (GenericDAOException e) {
            logger.error("Error during creating/updating price {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}