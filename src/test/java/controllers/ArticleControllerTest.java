package controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import service.ArticleService;
import web.API.Article;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = ArticleController.class)
@WebMvcTest(ArticleController.class)
public class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

    @Test
    public void fetchArticles() throws Exception {
        Article article1 = new Article(1L, "Bread", false, null);
        Article article2 = new Article(2L, "Milk", false, null);
        List<Article> articles = Arrays.asList(article1, article2);
        when(articleService.findAll()).thenReturn(articles);

        String expected = "[{\"id\":1,\"name\":\"Bread\",\"empty\":false,\"category\":null}," +
                "{\"id\":2,\"name\":\"Milk\",\"empty\":false,\"category\":null}]";

        this.mockMvc.perform(get("/api/v1/article")
                        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)) // Set the Accept header only once
                //.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected))
                .andReturn();
    }

}
