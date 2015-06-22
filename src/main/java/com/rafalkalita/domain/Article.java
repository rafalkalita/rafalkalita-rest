package com.rafalkalita.domain;


import com.rafalkalita.converters.LocalDateTimePersistenceConverter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Article domain object
 */
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // TODO: check if conversion is working
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    private LocalDateTime datetime;

    private String userId;
    private String content;

    protected Article() {
    }

    public Article(LocalDateTime datetime, String userId, String content) {
        this.datetime = datetime;
        this.userId = userId;
        this.content = content;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public String getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }
}
