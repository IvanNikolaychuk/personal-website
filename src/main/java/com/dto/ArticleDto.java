package com.dto;

import com.entity.article.Article;
import com.entity.article.ArticleInfo;

import java.util.Calendar;

import static java.util.Calendar.*;

public class ArticleDto {
    public String preview;
    public String content;
    public String articleId;
    public int likesCounter;
    public int watchesCounter;
    public String creationDate;

    public ArticleDto(Article article) {
        this.preview = article.getPreview();
        this.content = article.getContent();

        final ArticleInfo articleInfo = article.getArticleInfo();
        this.articleId = articleInfo.getId();
        this.likesCounter = articleInfo.getLikesCounter().get();
        this.watchesCounter = articleInfo.getWatchesCounter().get();
        this.creationDate = constructCreationDate(articleInfo.getCreationDate());
    }

    private String constructCreationDate(Calendar creationDate) {
        return creationDate.get(DAY_OF_MONTH) + "." + creationDate.get(MONTH) + "." + creationDate.get(YEAR);
    }
}
