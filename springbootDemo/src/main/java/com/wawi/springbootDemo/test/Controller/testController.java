package com.wawi.springbootDemo.test.Controller;

import com.wawi.springbootDemo.test.pojo.Book;
import com.wawi.springbootDemo.test.pojo.EntityUtils;
import com.wawi.springbootDemo.test.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/MyTest")
public class testController {
    @Resource
     private BookService bookService;

    @RequestMapping("/hello")
    public List hello(){
        return  bookService.getUserList();
    }
    @RequestMapping("/hello1")
    public List hello1(){
        return  bookService.getUserList1(1l);
    }
    @RequestMapping("/hello2")
    public List hello2(){
        return  bookService.nativeQuery1();
    }
}
