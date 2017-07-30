package com.service;

import com.entity.article.Article;
import com.entity.article.ArticleInfo;
import com.entity.article.Language;
import com.repository.ArticleInfoRepository;
import com.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: remove this when production
@Service
public class DummyContentGenerator {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleInfoRepository articleInfoRepository;

    //    @PostConstruct
    public void init() {
        ArticleInfo articleInfo = new ArticleInfo("foot-locker");
        articleInfoRepository.save(articleInfo);

        Article enArticle = new Article(articleInfoRepository.findOne("foot-locker"), Language.EN, "English preview", "English text", "Go long with FL");
        articleRepository.save(enArticle);

        Article ruArticle = new Article(articleInfoRepository.findOne("foot-locker"), Language.RU, "Русский preview", "Русский текст", "Длинная позиция по FL");
        articleRepository.save(ruArticle);
    }
}
