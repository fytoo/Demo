package com.wawi.springbootDemo.test.Controller;

import com.wawi.springbootDemo.test.pojo.Book;
import com.wawi.springbootDemo.test.service.BookService;
import com.wawi.springbootDemo.util.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/MyTest")
public class testController {
    @Resource
    private BookService bookService;
    @Autowired
    private RedisOperator redisOperator;
    @Autowired
    @Qualifier("userRedisTemplete")
    private RedisTemplate redisTemplate;

    @RequestMapping("/hello")
    public List hello() throws InterruptedException {
        System.out.println(redisOperator.ttl("xuchangle"));

        return bookService.getUserList();
    }

    @RequestMapping("/hello1")
    public List hello1() {
        return bookService.getUserList1(1l);
    }

    @RequestMapping("/hello2")
    public List hello2() {
        return bookService.nativeQuery1();
    }

    /**
     * 返回分页数据
     *
     * @return
     */
    @RequestMapping("/hello3")
    public List hello3() {
        Pageable pageable = new PageRequest(0, 1);
        Page<Book> misakaPage = bookService.nativeQuery2(pageable);
        List<Book> ls = misakaPage.getContent();
        /*System.out.println(misakaPage.getTotalPages()+"==");
        System.out.print(misakaPage.getTotalElements());*/
        return ls;
    }
    /**
     * 返回分页数据
     *
     * @return
     */
    @RequestMapping("/hello4")
    public void hello4() {
        Book book=new Book();
        book.setBookId(1l);
        book.setBookName("xuchangle");
        redisTemplate.opsForValue().set("book",book);
    }
}


