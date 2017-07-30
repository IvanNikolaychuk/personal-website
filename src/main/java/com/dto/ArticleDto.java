package com.dto;

import com.entity.article.Article;
import com.entity.article.ArticleInfo;

public class ArticleDto {
    public String preview;
    public String content;
    public String header;

    public String articleId;
    public int likesCounter;
    public int watchesCounter;
    public String creationDate;

    public ArticleDto(Article article) {
        this.preview = article.getPreview();
        this.content = article.getContent();
        this.header = article.getHeader();


        final ArticleInfo articleInfo = article.getArticleInfo();
        this.articleId = articleInfo.getId();
        this.likesCounter = articleInfo.getLikesCounter().get();
        this.watchesCounter = articleInfo.getWatchesCounter().get();
    }
}
