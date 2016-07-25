package org.academiadecodigo.bootcamp.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by codecadet on 29/06/16.
 */
public class ServiceRegistry {

    private Map<String, Service> services = new HashMap<String, Service>();

    private static ServiceRegistry instance = null;

    private ServiceRegistry() {
    }

    public static synchronized ServiceRegistry getInstance() {

        if (instance == null) {
            instance = new ServiceRegistry();
        }

        return instance;
    }

    public void setService(String name, Service service) {
        services.put(name, service);
    }

    public Service getService(String name) {
        return services.get(name);
    }

    public Map<String, Service> getServiceMap() {
        return services;
    }

}
