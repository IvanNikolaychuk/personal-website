package com.entity.article;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "article")
@Data
public class Article {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private ArticleInfo articleInfo;

    @Enumerated(EnumType.STRING)
    private Language language;

    private String preview;

    private String content;

    private String header;

    public Article(ArticleInfo articleInfo, Language language, String preview, String content, String header) {
        this.articleInfo = articleInfo;
        this.language = language;
        this.preview = preview;
        this.content = content;
        this.header = header;
    }

    // for hibernate needs
    Article() {
    }


}
