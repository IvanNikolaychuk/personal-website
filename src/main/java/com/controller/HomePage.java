package com.controller;

import com.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePage {
    private final ArticleRepository articleRepository;

    @Autowired
    public HomePage(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @RequestMapping("/")
    public String process2(@RequestAttribute("lang") String language) {
        return "index.html";
    }
}
