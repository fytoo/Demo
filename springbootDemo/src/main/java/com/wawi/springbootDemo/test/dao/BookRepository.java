package com.wawi.springbootDemo.test.dao;

import com.wawi.springbootDemo.test.pojo.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    /**
     * 自定义方法查询
     */
    @Query(value = "select  * from  t_book where  book_id>?1",nativeQuery = true)
    public List  nativeQuery(Long id);
    /**
     * 自定义方法查询  面向对象查询
     */
    @Query(value = "select  new Book(bookId,bookName) FROM Book")
    public List  nativeQuery1();
    /**
     * 自定义方法查询  自定义分页查询
     */
    @Query(value = "select new Book(u.bookId,u.bookName) from Book u")
    public Page nativeQuery2(Pageable pageable);

}
