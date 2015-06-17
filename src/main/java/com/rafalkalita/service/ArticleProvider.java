package com.rafalkalita.service;

import com.rafalkalita.domain.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Service to provide articles.
 */
@Service
public class ArticleProvider {
    private static final ArrayList<Article> articles = new ArrayList<>();

    static {
        articles.add(new Article(1L, "Article content 1"));
        articles.add(new Article(2L, "Article content 2"));
        articles.add(new Article(3L, "Article content 3"));
    }

    public Article getArticle(long id) throws Exception {
        for (Article a : articles) {
            if (a.getId() == id) {
                return a;
            }
        }
        throw new IllegalArgumentException("Article with a given id does not exists.");
    }
}
