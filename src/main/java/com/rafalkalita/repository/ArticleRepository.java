package com.rafalkalita.repository;

import com.rafalkalita.domain.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Repository that serves the Article objects.
 */
public interface ArticleRepository extends CrudRepository<Article, Long> {
    List<Article> findByUserId(String userId);
}
