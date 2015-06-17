package com.rafalkalita.rest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles errors.
 */
@RestController
public class ArticleErrorController implements ErrorController {

    private static final String PATH = "/error";

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(value = PATH)
    public com.rafalkalita.domain.Error handleError() {
        return new com.rafalkalita.domain.Error("This operation is not supported");
    }
}
