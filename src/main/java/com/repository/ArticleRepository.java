package com.repository;

import com.entity.article.Article;
import com.entity.article.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleRepository extends CrudRepository<Article, Long> {
    List<Article> findByLanguage(Language language);
}
