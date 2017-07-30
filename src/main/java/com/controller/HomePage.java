package com.controller;

import com.entity.Article;
import com.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.Action;

@Controller
public class HomePage {
    private final ArticleRepository articleRepository;

    @Autowired
    public HomePage(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @RequestMapping("/")
    public String process2() {
        return "index.html";
    }
}
