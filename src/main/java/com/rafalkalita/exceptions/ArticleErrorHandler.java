package com.rafalkalita.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Generic error handler
 */
@ControllerAdvice
public class ArticleErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleErrorHandler.class);

    @ExceptionHandler(ArticleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleArticleNotFoundException(ArticleNotFoundException ex) {
        LOGGER.debug("Article not found " + ex.getMessage());
    }
}
