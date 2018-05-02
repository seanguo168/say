package com.baoying.say.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//@Controller
@RestController
@RequestMapping("/first")
public class Say {


    @PostMapping(value = "/show")
    public Object show(@RequestParam String author,
                       @RequestParam String time,
                       @RequestParam Long bsn
                       ){

        Map<String,Object> book = new HashMap<>();

        book.put("author",author);
        book.put("time",time);
        book.put("bsn",bsn);



        System.out.println("---------new out");

        return book;
    }

    @PostMapping(value = "/getlist")
    public Object getList(@RequestParam int page,
                          @RequestParam(defaultValue = "10",value = "size") int size
                          ){


        Map<String,Object> book = new HashMap<>();

        book.put("author","sean");
        book.put("time","20181111");
        book.put("bsn","1321423");

        Map<String,Object> book2 = new HashMap<>();

        book2.put("author","sean");
        book2.put("time","20181111");
        book2.put("bsn","1321423");

        List<Map> content = new ArrayList<>();

        content.add(book);
        content.add(book2);



        Map<String,Object> ret = new HashMap<>();

        ret.put("page",page);
        ret.put("size",size);

        ret.put("content",content);



        return ret;

    }


//    @GetMapping("/show")
//
//    public String getAll(){
//
//        return "getMapping";
//    }


    @GetMapping("/show/{id}/{numbers}")
    @ResponseBody
    public Object getLimit(@PathVariable int id,
                           @PathVariable int numbers
                           ){

        Map<String,Object> mp = new HashMap<>();

        mp.put("username","seanguo");
        mp.put("pass","asdfas");
        mp.put("id",id);
        mp.put("numbers",numbers);

        return mp;
    }
}
