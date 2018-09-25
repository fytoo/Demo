package com.wawi.springbootDemo.test.service.impl;

import com.wawi.springbootDemo.test.dao.BookRepository;
import com.wawi.springbootDemo.test.pojo.Book;
import com.wawi.springbootDemo.test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Book> getUserList() {

        List<Book> userList=new ArrayList<Book>();
        userList=bookRepository.findAll();
        return userList;
    }

    @Override
    public List<Book> getUserList1(Long id) {
        return bookRepository.nativeQuery(id);
    }

    @Override
    public List<Book> nativeQuery1() {
        return bookRepository.nativeQuery1();
    }
}