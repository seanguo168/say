package com.baoying.say.controller;


import com.baoying.say.domain.Book;
import com.baoying.say.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAll(){

        return  bookRepository.findAll();

    }

    public Book getOne(Long sId){

        return bookRepository.getOne(sId);
    }

    public Object saveOne(Book book){


        return bookRepository.save(book);

    }

    public void delOne(Long sId){

         bookRepository.deleteById(sId);
    }

    public Book findByContentAndAndName(String content,String name){

        return bookRepository.findByContentAndAndName(content,name);
    }
}
