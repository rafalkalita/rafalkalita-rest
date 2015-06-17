package com.rafalkalita.rest;

import com.rafalkalita.domain.Article;
import com.rafalkalita.service.ArticleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Processes Article requests.
 */
@RestController
public class ArticleController {

    @Autowired
    private ArticleProvider articleProvider;

    @RequestMapping(name = "/article", method = RequestMethod.GET)
    public Article getArticle(@RequestParam(value = "id") long id) throws Exception {
        return articleProvider.getArticle(id);
    }
}
