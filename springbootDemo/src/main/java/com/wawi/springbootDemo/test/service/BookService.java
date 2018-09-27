package com.wawi.springbootDemo.test.service;

import com.wawi.springbootDemo.test.pojo.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    List<Book> getUserList();
    List<Book> getUserList1(Long id);
    List<Book> nativeQuery1();
    Page<Book> nativeQuery2(Pageable pageable);
}