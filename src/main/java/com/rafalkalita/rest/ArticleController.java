package com.rafalkalita.rest;

import com.rafalkalita.domain.Article;
import com.rafalkalita.exceptions.ArticleNotFoundException;
import com.rafalkalita.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static java.lang.String.format;

/**
 * Processes Article requests.
 */
@RestController
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public Article getArticle(@RequestParam(value = "id") Long id) {
        Article result = articleRepository.findOne(id);
        if (result == null) {
            throw new ArticleNotFoundException(format("Article with id %s cannot be found", id));
        }
        return result;
    }

    @RequestMapping(value = "/article", method = RequestMethod.PUT)
    public ResponseEntity<Article> createArticle(@RequestParam(value = "user") String user,
                                                 @RequestParam(value = "content") String content) {
        Article response = articleRepository.save(new Article(LocalDateTime.now(), user, content));
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public List<Article> getArticles(@RequestParam(value = "user") String user) {
        return articleRepository.findByUserId(user);
    }
}
