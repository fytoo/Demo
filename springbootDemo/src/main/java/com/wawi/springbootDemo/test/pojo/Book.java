package com.wawi.springbootDemo.test.pojo;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_book")
public class Book implements Serializable {


    @Id
    @Column(name="book_id")
    @GeneratedValue(strategy = GenerationType.TABLE,generator="customer_gen")
// 用的市table策略
    @TableGenerator(
            name = "customer_gen",
            table = "APP_SEQ_STORE",
            pkColumnName = "APP_SEQ_NAME",
            pkColumnValue = "LISTENER_PK",
            valueColumnName = "APP_SEQ_VALUE",
            initialValue = 10000,
            allocationSize = 1
    )
    private Long bookId;
    public  Book(Long id,String name){
     this.bookId=id;
     this.bookName=name;
    }
    public  Book(){

    }
    @Column(name="book_name")
    private String bookName;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
