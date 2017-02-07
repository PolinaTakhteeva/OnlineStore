package com.company.web.controller;

import com.company.dao.impl.ProductDAOHibernateImpl;
import com.company.dao.ProductDAO;
import com.company.model.Product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.omg.PortableInterceptor.Interceptor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.SessionAttributes;
import java.util.Date;
import java.util.Map;

@Controller
@SessionAttributes("card")

public class HelloController {

    //user - product

    @RequestMapping(value = "/catalog", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String showCatalog(ModelMap model) {
        ProductDAO db = new ProductDAOHibernateImpl();
        List<Product> list = db.getAllProducts();
        model.addAttribute("products", list);
        String res = ((String)model.get("somefield")) + "_addSomeSuffix";
//        model.addAttribute("somefield", res);
        return "customer/catalog";
    }

    @RequestMapping(value = "/catalog/{id:.+}", method = RequestMethod.GET)
    public ModelAndView showProductInfo(@PathVariable("id") int id) {
        ProductDAO db =  new ProductDAOHibernateImpl();
        Product product = db.getProduct(id);
        ModelAndView model = new ModelAndView();
        model.setViewName("customer/product");
        model.addObject("product", product);
//        model.addObject("somefield", new Date().toString());
        return model;
    }

    @RequestMapping(value = "/addToCard/{id:.+}", method = RequestMethod.POST)
    public String addToCard(@PathVariable("id") int id, ModelMap model) {
        ProductDAO db =  new ProductDAOHibernateImpl();
        Product product = db.getProduct(id);

        Map<Integer, Integer> card = (Map<Integer, Integer>)model.get("card");
        if (card == null) {
            card = new HashMap<Integer, Integer>();
        }
        card.put(id, (card.get(id) == null ? 0 : card.get(id)) + 1);
        model.addAttribute("card", card);
        System.out.println("Выполнено добавление в корзину");
        return "redirect:/card";
    }

    @RequestMapping(value = "/card", method = RequestMethod.GET)
    public String showCard(ModelMap model) {
//        ProductDAO db =  new ProductDAOHibernateImpl();
//        Product product = db.getProduct(id);
        Map<Integer, Integer> card = (Map<Integer, Integer>)model.get("card");
        if (card == null) {
            model.addAttribute("header", "Корзина пока пуста");
        }
        model.addAttribute("header", "Ваш заказ:");
        return "customer/card";
    }

    @RequestMapping(value = "/card", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String showBasket(ModelMap model) {
        return "customer/card";
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