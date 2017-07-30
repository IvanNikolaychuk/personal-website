package com.controller.api;

import com.dto.ArticleDto;
import com.entity.article.Language;
import com.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.controller.filter.LocalizationFilter.LANGUAGE_ATTRIBUTE;

@RestController
@RequestMapping(value = ("api/articles"))
public class ArticleApi {
    private final ArticleService articleService;

    @Autowired
    public ArticleApi(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping("/")
    public List<ArticleDto> findByLanguage(@RequestAttribute(value = LANGUAGE_ATTRIBUTE) String language) {
        return articleService.findByLanguage(Language.find(language));
    }
}
