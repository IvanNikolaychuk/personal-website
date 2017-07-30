package com.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String content;
    private String preview;
    private AtomicInteger likesCounter;
    private AtomicInteger watchesCounter;
    private Calendar creationDate;

    // for hibernate needs
    Article() {}

    public Article(String content, String preview) {
        this.content = content;
        this.preview = preview;
        this.likesCounter = new AtomicInteger();
        this.watchesCounter = new AtomicInteger();
        this.creationDate = Calendar.getInstance();
    }
}
