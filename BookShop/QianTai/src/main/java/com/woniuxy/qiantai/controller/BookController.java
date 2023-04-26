package com.woniuxy.qiantai.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.dal.entity.Book;
import com.woniuxy.servicelayer.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniumrwang
 * @since 2023-04-26 11:40:03
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("queryBooksByTypeId")
    public List<Book> queryBooksByTypeId(Integer typeId, Integer currentPage, Integer pageSize) {
        Page<Book> page = new Page<>(currentPage, pageSize);
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("typeId", typeId);
        Page<Book> pageResult = bookService.page(page, queryWrapper);

        return pageResult.getRecords();
    }

//    @RequestMapping()  //接收任意方式的请求
//    @GetMapping //仅接受get请求
    @PostMapping("topN")  //仅接受Post请求
    public List<Book> topN(Integer N){

        return bookService.topN(N);
    }
    @PostMapping("getBookByType")
    public List<Book> getBookByType(Integer typeId){
        return bookService.getBookByType(typeId);
    }


    @PostMapping("detail")
    public Book detail(Long bookId){

        //获取图书详情,并增加阅读量
        Book currentBook = bookService.getById(bookId);
        currentBook.setReadcount( currentBook.getReadcount()+1 );

        //修改数据库中书籍的阅读量
        Book echoBook = new Book();
        echoBook.setId(currentBook.getId());
        echoBook.setReadcount(currentBook.getReadcount());
        bookService.updateById(echoBook);

        return currentBook;
    }



}

