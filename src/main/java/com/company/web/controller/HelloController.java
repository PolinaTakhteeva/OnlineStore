package com.company.web.controller;

import com.company.dao.OrderDAO;
import com.company.dao.impl.ProductDAOHibernateImpl;
import com.company.dao.ProductDAO;
import com.company.model.Product;
import javafx.util.Pair;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;

@Controller
@SessionAttributes("card")

public class HelloController {
    @Autowired
    @Resource(name = "productDAO")
    private ProductDAO productDAO;

    //user - product

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String showCatalog(ModelMap model) {
        List<Product> list = productDAO.getAllProducts();
        model.addAttribute("products", list);
        String res = ((String)model.get("somefield")) + "_addSomeSuffix";
//        model.addAttribute("somefield", res);
        return "customer/catalog";
    }

    @RequestMapping(value = "/catalog/{id:.+}", method = RequestMethod.GET)
    public ModelAndView showProductInfo(@PathVariable("id") int id) {
        Product product = productDAO.getProduct(id);
        ModelAndView model = new ModelAndView();
        model.setViewName("customer/product");
        model.addObject("product", product);
//        model.addObject("somefield", new Date().toString());
        return model;
    }



    @RequestMapping(value = "/cabinet", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String showCabinet(ModelMap model) {
        return "customer/cabinet";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String printWelcome(ModelMap model) {
        return "welcome";
    }

}