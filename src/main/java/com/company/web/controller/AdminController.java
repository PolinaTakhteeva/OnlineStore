package com.company.web.controller;


import com.company.dao.ProductDAO;
import com.company.dao.impl.ProductDAOHibernateImpl;
import com.company.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Controller
@SessionAttributes("somefield")
public class AdminController {
    @Autowired
    @Resource(name = "productDAO")
    private ProductDAO productDAO;

    @RequestMapping(value = "/admind", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String printAdmind(ModelMap model) {
        List<Product> list = productDAO.getAllProducts();
        model.addAttribute("products", list);
        String res = ((String)model.get("somefield")) + "_addAnotherSuffix";
        model.addAttribute("somefield", res);
        return "admin/admin";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String printAdmin(ModelMap model) {
        List<Product> list = productDAO.getAllProducts();
        model.addAttribute("products", list);
        return "admin/admin";
    }

    @RequestMapping(value = "/admin/{id:.+}", method = RequestMethod.GET)
    public ModelAndView showAdminInfo(@PathVariable("id") int id) {
        Product product = productDAO.getProduct(id);
        ModelAndView model = new ModelAndView();
        model.setViewName("admin/adminShowInfo");
        model.addObject("product", product);
        return model;
    }

    @RequestMapping(value = "/admin/{id:.+}/delete", method = RequestMethod.GET)
    public ModelAndView deleteProduct(@PathVariable("id") int id) throws IOException {
        Product product = productDAO.getProduct(id);
        productDAO.deleteProduct(product);
        List<Product> list = productDAO.getAllProducts();
        ModelAndView model = new ModelAndView();
        model.setViewName("admin/admin");
        model.addObject("products", list);
        return model;
    }

//    @RequestMapping(value = "/admin/update", method = RequestMethod.GET)
//    public ModelAndView updateProduct(@PathVariable("id") int id) {
////        ProductDAO db =  new ProductDAOHibernateImpl();
////        Product product = db.getProduct(id);
//        ModelAndView model = new ModelAndView();
//        model.setViewName("updateProduct");
////        model.addObject("product", product);
//        return model;
//    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String update(ModelMap model) {
        return "updateProduct";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute Product product, ModelMap model){
        productDAO.insertProduct(product);
        List<Product> list = productDAO.getAllProducts();
        model.addAttribute("products", list);
        return "showAddProductForm";
    }
}
