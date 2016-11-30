package com.company;

import javax.persistence.*;

@Entity
@Table(name = "products", schema = "public")
public class Product {
    private int id;
    private String name;
    private String author;

    public Product(){
        id = 0;
        name = "";
        author = "";
    }

    public Product(String name, String author){
        this.id = 0;                   //"id = 0" is mean, that product hasn't been added to the database
        this.name = name;
        this.author = author;
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

    public  int getId() {
        return id;
    }

    public  String getName() {
        return  name;
    }

    public  String getAuthor() {
        return author;
    }

    public String toString() {
        return "Product{id='" + id +'\'' + ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

//    Product product = new Product("Колобок", "Народная сказка");
//    Product product1 = new Product("Метель", "Александр Пушкин");
//    Product product2 =  new Product("Три мушкетера", "Александр Дюма");
}
