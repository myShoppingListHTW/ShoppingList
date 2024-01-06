import HTWBerlin.ShoppingList.controllers.ArticleController;
import HTWBerlin.ShoppingList.web.API.ArticleManipulationRequest;
import HTWBerlin.ShoppingList.service.ArticleService;
import HTWBerlin.ShoppingList.web.API.Article;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import HTWBerlin.ShoppingList.Exceptions.*;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit tests for the {@link ArticleController} class.
 */
@ContextConfiguration(classes = ArticleController.class)
@WebMvcTest(ArticleController.class)
public class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

    /**
     * Test to verify that all articles are fetched successfully.
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void fetchArticles() throws Exception {
        Article article1 = new Article(1L, "Bread", false, null);
        Article article2 = new Article(2L, "Milk", false, null);
        List<Article> articles = Arrays.asList(article1, article2);
        when(articleService.findAll()).thenReturn(articles);

        String expected = "[{\"id\":1,\"name\":\"Bread\",\"empty\":false,\"category\":null}," +
                "{\"id\":2,\"name\":\"Milk\",\"empty\":false,\"category\":null}]";

        this.mockMvc.perform(get("/api/v1/article")
                        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected))
                .andReturn();
    }

    /**
     * Test to verify that a specific article is fetched successfully by ID.
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void fetchArticleById() throws Exception {
        Article article = new Article(1L, "Bread", false, null);
        when(articleService.findById(1L)).thenReturn(article);

        String expected = "{\"id\":1,\"name\":\"Bread\",\"empty\":false,\"category\":null}";

        this.mockMvc.perform(get("/api/v1/article/1")
                        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected))
                .andReturn();
    }

    /**
     * Test to verify that an article is successfully deleted.
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void deleteArticle() throws Exception {
        when(articleService.deleteById(1L)).thenReturn(true);

        this.mockMvc.perform(delete("/api/v1/article/1"))
                .andExpect(status().isOk())
                .andReturn();
    }

    /**
     * Test to verify that a new article is successfully created.
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void createArticle() throws Exception {
        when(articleService.create(any())).thenReturn(new Article(1L, "Bread", false, null));

        this.mockMvc.perform(post("/api/v1/article")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Bread\",\"empty\":false,\"category\":null}"))
                .andExpect(status().isCreated());
    }

    /**
     * Test to make sure, the name must be between 2 and 20 chars long.
     * @throws ItemException
     */
    @Test
    public void createArticleNameTooShort() throws Exception {
        when(articleService.create(any())).thenReturn(new Article(1L, "B", false, null));

        this.mockMvc.perform(post("/api/v1/article")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"B\",\"empty\":false,\"category\":null}"))
                .andExpect(status().isBadRequest());
    }

    /**
     * Test to make sure, the name must be between 2 and 20 chars long.
     * @throws ItemException
     */
    @Test
    public void createArticleNameTooLong() throws Exception {
        when(articleService.create(any())).thenReturn(new Article(1L, "b1234567891011121314151617181920", false, null));

        this.mockMvc.perform(post("/api/v1/article")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"B\",\"empty\":false,\"category\":null}"))
                .andExpect(status().isBadRequest());
    }
}
