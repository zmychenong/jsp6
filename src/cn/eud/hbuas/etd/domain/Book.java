package cn.eud.hbuas.etd.domain;

import java.util.Date;

/**
 * @PackageName cn.eud.hbuas.etd.domain
 * @Classname Book
 * @Description TODO
 * @Date 2021/7/2 16:36
 * @Created by ChenLong
 */
public class Book {

    private String id;
    private String bookTitle;
    private String authorName;
    private Date publishDate;
    private Double price;

    public Book() {
    }

    public Book(String id, String bookTitle, String authorName, Date publishDate, Double price) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.publishDate = publishDate;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
