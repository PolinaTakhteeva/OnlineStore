package com.company.service;

import static org.junit.Assert.*;
import com.company.service.*;
import junit.framework.TestCase;
import org.hibernate.jdbc.Expectation;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PaymentServiceTest extends TestCase {
    PaymentService paymentService;
    ProductService productService;
    IntegrationPaymentService mockito;

    protected void setUp() throws Exception {
        paymentService = new PaymentService();
        productService = new ProductService();
        mockito = mock(IntegrationPaymentService.class);
    }

    protected void tearDown() throws Exception {
        // reset state
        System.out.println("reset state");
    }

    public void testPayOrderFunction() throws Exception {
        PaymentServiceTest paymentServiceTest = new PaymentServiceTest();
        paymentServiceTest.setUp();
        when(mockito.payOrder("123")).thenReturn(true);
    }

    public void testSomefuncitons() {
        // do some test?
        System.out.println("test_1");
        assertEquals(1, 2);
    }
    public void testAnotherTest() {
        System.out.println("test_2");
        assertEquals(1, 1);
    }
}