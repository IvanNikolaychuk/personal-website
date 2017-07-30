package com.entity.article;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

@Entity(name = "article_info")
@Data
public class ArticleInfo {
    @Id
    private String id;

    @Column(name = "likes_counter")
    private AtomicInteger likesCounter;

    @Column(name = "watches_counter")
    private AtomicInteger watchesCounter;

    @Column(name = "creation_date")
    private Calendar creationDate;

    public ArticleInfo(String id) {
        this.id = id;
        likesCounter = new AtomicInteger();
        watchesCounter = new AtomicInteger();
        creationDate = Calendar.getInstance();
    }

    // for hibernate needs
    ArticleInfo() {
    }
}
