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

    @RequestMapping(value = "/catalog", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String showCatalog(ModelMap model) {
        ProductDAO db =  new ProductDAOHibernateImpl();
        List<Product> list = db.getAllProducts();
        model.addAttribute("products", list);
        return "catalog";
    }

    @RequestMapping(value = "/basket", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String showBasket(ModelMap model) {
        return "basket";
    }

    @RequestMapping(value = "/cabinet", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String showCabinet(ModelMap model) {
        return "cabinet";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String printWelcome(ModelMap model) {
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String printAdmin(ModelMap model) {
        ProductDAO db =  new ProductDAOHibernateImpl();
        List<Product> list = db.getAllProducts();
        model.addAttribute("products", list);
        return "admin";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute Product product, ModelMap model){
        ProductDAO db =  new ProductDAOHibernateImpl();
        db.insertProduct(product);
        List<Product> list = db.getAllProducts();
        model.addAttribute("products", list);
        return "showAddProductForm";
    }

    @RequestMapping(value = "/catalog/{id:.+}", method = RequestMethod.GET)
    public ModelAndView showProductInfo(@PathVariable("id") int id) {
        ProductDAO db =  new ProductDAOHibernateImpl();
        Product product = db.getProduct(id);
        ModelAndView model = new ModelAndView();
        model.setViewName("product");
        model.addObject("product", product);
        return model;
    }
}