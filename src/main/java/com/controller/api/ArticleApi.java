package com.controller.api;

import com.dto.ArticleDto;
import com.entity.article.Language;
import com.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = ("api/articles"))
public class ArticleApi {
    private final ArticleService articleService;

    @Autowired
    public ArticleApi(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping("/")
    public List<ArticleDto> findByLanguage(@RequestParam(value = "lang") String language) {
        return articleService.findByLanguage(Language.find(language));
    }
}
