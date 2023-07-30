package org.example.pos.service;

import org.example.pos.service.impl.CustomerServiceImpl;
import org.example.pos.service.impl.ItemServiceImpl;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    public enum ServiceType {
        ITEM, CUSTOMER
    }


   public static ServiceFactory getInstance() {
       return serviceFactory==null?serviceFactory=new ServiceFactory():serviceFactory;
   }
   public <T extends SuperService>T getService(ServiceType type) {
        switch (type) {
            case ITEM:
                return (T) new ItemServiceImpl();
            case CUSTOMER:
                return (T) new CustomerServiceImpl();
        }
        return null;
   }

}
