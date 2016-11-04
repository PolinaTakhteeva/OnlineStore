package org.company;

public class Product {
    private int id;
    private String name;
    private String author;

    Product(){
        id = 0;
        name = "";
        author = "";
    }

    Product(String name, String author){
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
}
