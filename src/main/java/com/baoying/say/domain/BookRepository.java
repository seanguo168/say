package com.baoying.say.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {

    /*
    *
    *
    * */

    Book findByContentAndAndName(String content,String name);
}
