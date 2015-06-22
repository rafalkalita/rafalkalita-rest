package com.rafalkalita.rest;

import com.rafalkalita.domain.Article;
import com.rafalkalita.exceptions.ArticleNotFoundException;
import com.rafalkalita.repository.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ArticleControllerTest {

    public static final Long ID_1 = 1L;
    public static final String USER_ID = "userId";
    public static final String CONTENT = "content";

    @InjectMocks
    private ArticleController articleController = new ArticleController();

    @Mock
    private ArticleRepository articleRepository;

    @Test
    public void shouldDelegateToArticleProvider() {
        given(articleRepository.findOne(ID_1)).willReturn(mock(Article.class));

        articleController.getArticle(ID_1);

        verify(articleRepository).findOne(ID_1);
    }

    @Test(expected = ArticleNotFoundException.class)
    public void shouldThrowArticleNotFoundExceptionWhenArticleNotFound() {
        articleController.getArticle(ID_1);
    }

    @Test
    public void shouldFindAnArticleByUserId() {

        articleController.getArticles(USER_ID);

        verify(articleRepository).findByUserId(USER_ID);
    }

    @Test
    public void shouldCreateAnArticle() {

        ResponseEntity<Article> result = articleController.createArticle(USER_ID, CONTENT);

        verify(articleRepository).save(isA(Article.class));
        assertThat(result.getStatusCode(), is(equalTo(HttpStatus.CREATED)));
    }
}