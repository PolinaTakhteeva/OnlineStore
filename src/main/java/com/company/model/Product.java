package com.company.model;

import javax.persistence.*;

@Entity
@Table(name = "welcome.jsp", schema = "public")
public class Product {
    private int id;
    private String name;
    private String author;
    private  int supplierId;
    private double price;
    private String image;
    private String description;

    public Product(){
        id = 0;
        name = "";
        author = "";
        supplierId = 0;
        price = 0;
        image = "";
        description ="";
    }

    public Product(String name, String author, int supplierId, double price, String image, String description){
        this.id = 0;                   //"id = 0" is mean, that product hasn't been added to the database
        this.name = name;
        this.author = author;
        this.supplierId = supplierId;
        this.price = price;
        this.image = image;
        this.description = description;
    }

    public void  setId(int id){
        this.id =  id;
    }

    public  void setName(String name){
        this.name = name;
    }

    public void  setAuthor(String author){
        this.author = author;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public  int getId() {
        return id;
    }

    public  String getName() {
        return  name;
    }

    public  String getAuthor() {
        return author;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", supplierId=" + supplierId +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

//    Product product = new Product("Колобок", "Народная сказка");
//    Product product1 = new Product("Метель", "Александр Пушкин");
//    Product product2 =  new Product("Три мушкетера", "Александр Дюма");
}
