package com.company.web.controller;

import com.company.dao.OrderDAO;
import com.company.dao.OrderDetailDAO;
import com.company.dao.ProductDAO;
import com.company.dao.impl.OrderDAOHibernateImpl;
import com.company.dao.impl.OrderDetailDAOHibernateImpl;
import com.company.dao.impl.ProductDAOHibernateImpl;
import com.company.model.Order;
import com.company.model.OrderDetail;
import com.company.model.Product;
import javafx.util.Pair;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@SessionAttributes("card")

public class OrderController {

    @Autowired
    @Resource(name = "orderDAO")
    private OrderDAO orderDAO;

    @Autowired
    @Resource(name = "productDAO")
    private ProductDAO productDAO;

    @Autowired
    @Resource(name = "orderDetailDAO")
    private OrderDetailDAO orderDetailDAO;


    @RequestMapping(value = "/addToCard/{id:.+}", method = RequestMethod.POST)
    public String addToCard(@PathVariable("id") int id, ModelMap model) {
        Product product = productDAO.getProduct(id);

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
        Map<Integer, Integer> card = (Map<Integer, Integer>)model.get("card");

        if (card != null){
            Map<Integer, Integer> map = (Map<Integer, Integer>)model.get("card");
            List<Pair<Product,Integer>> cardProducts =  new ArrayList<Pair<Product,Integer>>();
            BigDecimal coast = new BigDecimal(0);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                cardProducts.add(new Pair<Product, Integer>(
                        productDAO.getProduct(entry.getKey()),
                        entry.getValue()));
                coast = coast.add(productDAO.getProduct(entry.getKey())
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

            //Add new order to data base
            Order order = new Order();
            order.setCustomerId(100);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            order.setDate(dateFormat.format(date));
            order.setPayment(false);
            order.setStatus("INIT");
            orderDAO.addOrder(order);
            System.out.println("New id = " + String.valueOf(order.getOrderId()));
            //Add order details to data base
            Map<Integer, Integer> map = (Map<Integer, Integer>)model.get("card");
            List<Pair<Product,Integer>> orderDetails =  new ArrayList<Pair<Product,Integer>>();

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                OrderDetail detail = new OrderDetail();
                detail.setOrderId(100); //get id of last order
                detail.setProductId(entry.getKey());
                detail.setCount(entry.getValue());
                orderDetailDAO.addOrderDetail(detail);
            }

            model.addAttribute("card", card);
            System.out.println("Выполнено добавление в корзину");
            return "customer/payment"; //здесь должен быть redirect на платежный сервис
        }return "customer/card";
    }
}
