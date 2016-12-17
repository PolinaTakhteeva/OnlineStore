package com.company.web.controller;

import com.company.dao.impl.ProductDAOHibernateImpl;
import com.company.dao.ProductDAO;
import com.company.model.Product;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String printWelcome(ModelMap model) {
        ProductDAO db =  new ProductDAOHibernateImpl();
        List<Product> list = db.getAllProducts();
        model.addAttribute("products", list);
        return "index";
    }
    @RequestMapping(value = "/addProductForm", method = RequestMethod.GET)
    public String addProductForm(ModelMap model) {
//        model.addAttribute("allProducts", "123");
        return "showAddProductForm";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute Product product, ModelMap model){
        ProductDAO db =  new ProductDAOHibernateImpl();
        db.insertProduct(product);
        List<Product> list = db.getAllProducts();
        model.addAttribute("products", list);
        return "index";
    }

    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {
		System.err.println("Some call me!");
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        model.addObject("name", "awesome " + name);

        return model;

    }

}