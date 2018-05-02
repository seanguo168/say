package com.baoying.say.web;


import com.baoying.say.controller.BookService;
import com.baoying.say.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class WebApp {


    @Autowired
    private BookService bookService;


    @GetMapping("/book")
    public List<Book> getAll() {


        return bookService.getAll();
    }


    @GetMapping("/book/{sId}")
    public Object getOne(@PathVariable Long sId) {

//        bookService.getOne(sId);

        Book book = bookService.getOne(sId);

        Map<String, String> map = new HashMap<>();

//        map.put("sId",(String)book.getSId());
        map.put("content", book.getContent());

        map.put("name", book.getName());


        return map;
    }

    @PostMapping("/book")
    public Object saveOne(@RequestParam String content,
                          @RequestParam String name) {

        Book book = new Book();

        book.setName(name);
        book.setContent(content);

        bookService.saveOne(book);

        return null;


    }

    @DeleteMapping("/book/{sId}")
    public void deleteOne(@PathVariable Long sId) {

        bookService.delOne(sId);
    }


    @PostMapping("/book/update")
    public Object saveOne(@RequestParam Long sId,
                          @RequestParam String content,
                          @RequestParam String name
    ) {


        Book book = new Book();

        book.setSid(sId);
        book.setContent(content);
        book.setName(name);


        System.out.println(book);
        return bookService.saveOne(book);
    }

    @PostMapping("/book/findby")
    public Object findBy(@RequestParam String content,
                         @RequestParam String name
    ) {


        return bookService.findByContentAndAndName(content, name);


    }

    public int sum(int a, int b) {


        return a + b;
    }
}
