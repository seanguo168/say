package com.baoying.say.domain;



import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="book")
public class Book implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="sid")
    private Long sid;

    @Column
    private String name;

    @Column
    private String content;


}
