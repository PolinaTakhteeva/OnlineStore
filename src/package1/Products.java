package package1;

import javax.persistence.*;

/**
 * Created by ahtyamovdanil on 26.11.2016.
 */
@Entity
public class Products {
    private int id;
    private String name;
    private String author;
    private Integer year;
    private String publishingHouse;
    private Integer price;
    private Integer quantityInStock;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "author", nullable = true, length = 100)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "year", nullable = true)
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Basic
    @Column(name = "publishing_house", nullable = true, length = 100)
    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    @Basic
    @Column(name = "price", nullable = true)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "quantity_in_stock", nullable = true)
    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void setProduct(String name,String author,Integer year,String publishingHouse,Integer price,Integer quantityInStock){
        this.setName(name);
        this.setAuthor(author);
        this.setYear(year);
        this.setPublishingHouse(publishingHouse);
        this.setPrice(price);
        this.setQuantityInStock(quantityInStock);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        if (id != products.id) return false;
        if (name != null ? !name.equals(products.name) : products.name != null) return false;
        if (author != null ? !author.equals(products.author) : products.author != null) return false;
        if (year != null ? !year.equals(products.year) : products.year != null) return false;
        if (publishingHouse != null ? !publishingHouse.equals(products.publishingHouse) : products.publishingHouse != null)
            return false;
        if (price != null ? !price.equals(products.price) : products.price != null) return false;
        if (quantityInStock != null ? !quantityInStock.equals(products.quantityInStock) : products.quantityInStock != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (publishingHouse != null ? publishingHouse.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (quantityInStock != null ? quantityInStock.hashCode() : 0);
        return result;
    }

    //@Override
    public String toString() {
        String str=('\t'+"id "+id+'\t'+" | author "+author+'\t'+"| name "+name+'\t'+" | year "+ year+'\n');
        return str;
    }
}
