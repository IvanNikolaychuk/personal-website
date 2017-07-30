package com.service;

import com.dto.ArticleDto;
import com.entity.article.Article;
import com.entity.article.Language;
import com.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    private static SimpleDateFormat ARTICLE_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<ArticleDto> findByLanguage(Language language) {
        return articleRepository.findByLanguage(language)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private ArticleDto toDto(Article article) {
        ArticleDto articleDto = new ArticleDto(article);
        articleDto.creationDate = ARTICLE_DATE_FORMAT.format(article.getArticleInfo().getCreationDate());
        return articleDto;
    }
}
