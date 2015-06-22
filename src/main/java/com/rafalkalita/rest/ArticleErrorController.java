package com.rafalkalita.rest;

import com.rafalkalita.exceptions.NotSupportedOperationException;
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
    public NotSupportedOperationException handleError() {
        return new NotSupportedOperationException("This operation is not supported");
    }
}
