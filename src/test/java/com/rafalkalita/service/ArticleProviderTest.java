package com.rafalkalita.service;

import org.junit.Assert;
import org.junit.Test;

public class ArticleProviderTest {

    private ArticleProvider provider = new ArticleProvider();

    @Test
    public void shouldRetrieveAnArticle() throws Exception {
        Assert.assertNotNull(provider.getArticle(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException() throws Exception {
        provider.getArticle(999);
    }
}