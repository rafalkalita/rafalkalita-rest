package com.rafalkalita.rest;

import com.rafalkalita.domain.Article;
import com.rafalkalita.service.ArticleProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ArticleControllerTest {

    public static final String CONTENT_1 = "content1";
    public static final int ID_1 = 1;

    @InjectMocks
    private ArticleController articleController = new ArticleController();

    @Mock
    private ArticleProvider articleProvider;

    @Test
    public void shoudDisplayTheArticleForGetOperation() throws Exception {

        // given
        Article result = new Article(ID_1, CONTENT_1);
        BDDMockito.given(articleController.getArticle(ID_1)).willReturn(result);

        // when
        Article article = articleController.getArticle(ID_1);

        // then
        Assert.assertEquals(ID_1, article.getId());
        Assert.assertEquals(CONTENT_1, article.getContent());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForNonExistingIndex() throws Exception {

        Long id = 999L;
        BDDMockito.given(articleController.getArticle(id)).willThrow(new IllegalArgumentException("Error"));

        articleController.getArticle(id);
    }
}