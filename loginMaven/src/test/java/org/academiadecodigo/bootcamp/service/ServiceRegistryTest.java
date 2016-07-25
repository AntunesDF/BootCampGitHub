package org.academiadecodigo.bootcamp.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by codecadet on 04/07/16.
 */
public class ServiceRegistryTest {

    private String testName1 = "testName1";
    private String testName2 = "testName2";
    private Service mockedService1;
    private Service mockedService2;
    private ServiceRegistry serviceRegistry;


    @Before
    public void setUp() {
        serviceRegistry = ServiceRegistry.getInstance();
        mockedService1 = Mockito.mock(Service.class);
    }

    @Test
    public void testServiceRegistryInstantiation() {
        ServiceRegistry r = ServiceRegistry.getInstance();
        assertNotNull(r);
        assertNotNull(serviceRegistry);
        assertEquals(r, serviceRegistry);
    }

    @Test
    public void testRegisterService(){

        assertFalse(serviceRegistry.getServiceMap().containsKey(testName1));
        serviceRegistry.setService(testName1, mockedService1);
        assertTrue(serviceRegistry.getServiceMap().containsKey(testName1));

        assertFalse(serviceRegistry.getServiceMap().containsKey(testName2));
        serviceRegistry.setService(testName2, mockedService2);
        assertTrue(serviceRegistry.getServiceMap().containsKey(testName2));

    }

    @Test
    public void testLoadService(){

        serviceRegistry.setService(testName1, mockedService1);
        serviceRegistry.setService(testName2, mockedService2);

        Service service1 = serviceRegistry.getService(testName1);
        assertEquals(mockedService1, service1);

        Service service2 = serviceRegistry.getService(testName2);
        assertEquals(mockedService2, service2);

    }

    @After
    public void cleanUp(){
        serviceRegistry.getServiceMap().clear();
    }
}
