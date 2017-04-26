package com.itechart.warehouse.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Class for getting transport company details for implementing digest authentication.
 */
@Service
public class TransportCompanyDetailsService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(TransportCompanyDetailsService.class);
//    private TransportCompanyService transportCompanyService;
//
//    @Autowired
//    public void setUserService(TransportCompanyService transportCompanyService) {
//        this.transportCompanyService = transportCompanyService;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        logger.info("Loading transport company by login name: {}", username);
//        try {
//            TransportCompany transportCompany = transportCompanyService.findCompanyByLogin(username);
//            if (transportCompany.getTrusted()) {
//                return new TransportCompanyDetails(transportCompany);
//                //todo return null if not trusted
//            } else return null;
//        } catch (DataAccessException e) {
//            throw new UsernameNotFoundException("Exception during retrieving user details from the database", e);
//        }

        return null;
    }

}
