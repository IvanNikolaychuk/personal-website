package com.service;

import com.dto.ArticleDto;
import com.entity.article.Language;
import com.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<ArticleDto> findByLanguage(Language language) {
        return articleRepository.findByLanguage(language)
                .stream()
                .map(ArticleDto::new)
                .collect(Collectors.toList());
    }
}
