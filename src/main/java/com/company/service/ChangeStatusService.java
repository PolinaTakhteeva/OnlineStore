package com.company.service;

import com.company.model.Order;

public class ChangeStatusService {
    public void changeStatusToFORMED(Order order){
        order.setStatus("FORMED");
    }

    public void changeStatusToPAYED(Order order){
        order.setStatus("PAYED");
    }

    public void changeStatusToIN_DELIVERY(Order order){

    }

    public void changeStatusToDELIVERED(Order order){

    }

    public void changeStatusToRETURNED(Order order){

    }

    public void changeStatusToREADY(Order order){

    }
}
