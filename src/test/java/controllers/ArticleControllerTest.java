package controllers;

import static org.junit.jupiter.api.Assertions.*;
import controllers.ArticleController;
import service.ArticleService;
import Objects.Article;
import web.API.ArticleManipulationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

    @SpringBootTest
    @AutoConfigureMockMvc
    public class ArticleControllerTest {
/**
        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private ArticleService articleService;

        private Article article;

        @BeforeEach
        public void setUp() {
            article = new Article();
            article.setArticleId(1L);
            article.setName("Test Article");
        }

        @Test
        public void fetchArticlesReturnsListOfArticles() throws Exception {
            List<Article> articles = Arrays.asList(article);
            given(articleService.findAll()).willReturn(articles);

            mockMvc.perform(get("/api/v1/article"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(1)))
                    .andExpect(jsonPath("$[0].title", is(article.getName())));
        }

        @Test
        public void fetchArticleByIdReturnsArticle() throws Exception {
            given(articleService.findById(1L)).willReturn(article);

            mockMvc.perform(get("/api/v1/article/1"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.title", is(article.getName())));
        }

        @Test
        public void fetchArticleByIdReturnsNotFoundForInvalidId() throws Exception {
            given(articleService.findById(1L)).willReturn(null);

            mockMvc.perform(get("/api/v1/article/1"))
                    .andExpect(status().isNotFound());
        }
     **/
    }