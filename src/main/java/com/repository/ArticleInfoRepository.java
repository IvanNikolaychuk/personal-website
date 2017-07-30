package com.repository;

import com.entity.article.ArticleInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface ArticleInfoRepository extends CrudRepository<ArticleInfo, String> {
}
