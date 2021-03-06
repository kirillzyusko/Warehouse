package com.itechart.warehouse.service.services;


import com.itechart.warehouse.dao.exception.GenericDAOException;
import com.itechart.warehouse.dto.IncomingInvoiceDTO;
import com.itechart.warehouse.dto.InvoicesCountDTO;
import com.itechart.warehouse.dto.OutgoingInvoiceDTO;
import com.itechart.warehouse.entity.Invoice;
import com.itechart.warehouse.entity.User;
import com.itechart.warehouse.entity.Warehouse;
import com.itechart.warehouse.security.WarehouseCompanyUserDetails;
import com.itechart.warehouse.service.exception.DataAccessException;
import com.itechart.warehouse.service.exception.IllegalParametersException;
import com.itechart.warehouse.service.exception.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InvoiceService {
    List<Invoice> findAllInvoices() throws DataAccessException;

    List<IncomingInvoiceDTO> findAllIncomingInvoices(int page, int count, WarehouseCompanyUserDetails principal) throws IllegalParametersException, DataAccessException, ResourceNotFoundException;

    List<OutgoingInvoiceDTO> findAllOutgoingInvoices(int page, int count, WarehouseCompanyUserDetails principal) throws IllegalParametersException, ResourceNotFoundException, DataAccessException;

    InvoicesCountDTO findInvoicesCount(WarehouseCompanyUserDetails principal) throws DataAccessException;

    Invoice findInvoiceById(Long id) throws DataAccessException;

    IncomingInvoiceDTO findIncomingInvoiceForCompanyById(Long id, Long companyId) throws DataAccessException, ResourceNotFoundException, IllegalParametersException, GenericDAOException;

    OutgoingInvoiceDTO findOutgoingInvoiceForCompanyById(Long id, Long idWarehouseCompany) throws GenericDAOException, DataAccessException, IllegalParametersException, ResourceNotFoundException;

    Invoice saveInvoice(Invoice invoice) throws DataAccessException;

    Invoice saveIncomingInvoice(WarehouseCompanyUserDetails principal, IncomingInvoiceDTO invoice)
            throws DataAccessException, IllegalParametersException, ResourceNotFoundException;

    Invoice saveOutgoingInvoice(WarehouseCompanyUserDetails principal, OutgoingInvoiceDTO invoice)
            throws DataAccessException, IllegalParametersException, ResourceNotFoundException;

    void updateIncomingInvoice(Long id, IncomingInvoiceDTO invoice, Long idWarehouse) throws DataAccessException, ResourceNotFoundException, IllegalParametersException;

    void updateOutgoingInvoice(Long id, OutgoingInvoiceDTO invoice, Long idWarehouse) throws DataAccessException, ResourceNotFoundException, IllegalParametersException;

    Invoice updateInvoice(Invoice invoice) throws DataAccessException;

    Invoice updateInvoiceStatus(Long invoiceId, String status, User user)
            throws DataAccessException, IllegalParametersException, ResourceNotFoundException;

    void deleteInvoice(String id)
            throws DataAccessException, IllegalParametersException, ResourceNotFoundException;

    boolean invoiceExists(Invoice invoice) throws DataAccessException;

    @Transactional(readOnly = true)
    Boolean invoiceExistsByNumber(String number) throws DataAccessException;

    Warehouse findWarehouseByInvoiceId(Long invoiceId) throws IllegalParametersException, DataAccessException, ResourceNotFoundException;
}
