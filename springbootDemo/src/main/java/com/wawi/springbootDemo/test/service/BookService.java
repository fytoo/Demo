package com.wawi.springbootDemo.test.service;

import com.wawi.springbootDemo.test.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> getUserList();
    List<Book> getUserList1(Long id);
    List<Book> nativeQuery1();
}