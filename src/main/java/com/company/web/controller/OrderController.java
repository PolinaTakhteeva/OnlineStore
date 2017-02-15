package com.company.web.controller;

import com.company.dao.OrderDAO;
import com.company.dao.ProductDAO;
import com.company.dao.impl.OrderDAOHibernateImpl;
import com.company.dao.impl.ProductDAOHibernateImpl;
import com.company.model.Order;
import com.company.model.Product;
import javafx.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@SessionAttributes("card")
public class OrderController {
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
        return "redirect:/card";
    }

    @RequestMapping(value = "/card", method = RequestMethod.GET)
    public String showCard(ModelMap model) {
        ProductDAO db =  new ProductDAOHibernateImpl();
        Map<Integer, Integer> card = (Map<Integer, Integer>)model.get("card");

        if (card != null){
            Map<Integer, Integer> map = (Map<Integer, Integer>)model.get("card");
            List<Pair<Product,Integer>> cardProducts =  new ArrayList<Pair<Product,Integer>>();
            BigDecimal coast = new BigDecimal(0);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                cardProducts.add(new Pair<Product, Integer>(
                        db.getProduct(entry.getKey()),
                        entry.getValue()));
                coast = coast.add(db.getProduct(entry.getKey())
                        .getPrice()
                        .multiply(new BigDecimal(entry.getValue())));
            }
            model.addAttribute("coast", coast);
            model.addAttribute("cardProducts", cardProducts);
        }
        return "customer/card";
    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public String createOrder(ModelMap model) {
        Map<Integer, Integer> card = (Map<Integer, Integer>)model.get("card");
        System.err.println("1");
        if (card != null) {
            OrderDAO orderDAO = new OrderDAOHibernateImpl();
            ProductDAO productDAO = new ProductDAOHibernateImpl();

            //Add new order to data base
            Order order = new Order();
            order.setCustomerId(1);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            order.setDate(dateFormat.format(date));
            order.setPayment(false);
            order.setStatus("INIT");
            System.out.println("3");

            orderDAO.addOrder(order);

            //Add order details to data base
            Map<Integer, Integer> map = (Map<Integer, Integer>)model.get("card");
            List<Pair<Product,Integer>> orderDetails =  new ArrayList<Pair<Product,Integer>>();
            BigDecimal coast = new BigDecimal(0);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                orderDetails.add(new Pair<Product, Integer>(
                        productDAO.getProduct(entry.getKey()),
                        entry.getValue()));
                coast = coast.add(productDAO.getProduct(entry.getKey())
                        .getPrice()
                        .multiply(new BigDecimal(entry.getValue())));
            }

            model.addAttribute("card", card);
            System.out.println("Выполнено добавление в корзину");
            return "redirect:/card";
        }return "customer/card";
    }
}
