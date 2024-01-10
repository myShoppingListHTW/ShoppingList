import HTWBerlin.ShoppingList.Entities.Category;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
    Article article1 = new Article(1L, "Bread", false, Category.BAKERY, "testOwner");
    Article article2 = new Article(2L, "Milk", false, Category.DAIRY, "testOwner");

    String jsonA1 = "{\"id\":1,\"name\":\"Bread\",\"empty\":false,\"category\":\"BAKERY\",\"owner\":\"testOwner\"}";
    String jsonA2 = "{\"id\":2,\"name\":\"Milk\",\"empty\":false,\"category\":\"DAIRY\",\"owner\":\"testOwner\"}";
    String jsonA1_A2 = "[" + jsonA1 + "," + jsonA2 + "]";

    /**
     * Test to verify that all articles are fetched successfully when no owner is specified.
     *
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void fetchAllArticles() throws Exception {
        List<Article> articles = Arrays.asList(article1, article2);
        when(articleService.findAll()).thenReturn(articles);

        this.mockMvc.perform(get("/api/v1/article/")
                        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(jsonA1_A2))
                .andReturn();
    }
    /**
     * Test to verify that a specific article is fetched successfully by ID.
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void fetchArticleById() throws Exception {
        when(articleService.findById(1L)).thenReturn(article1);

        String expected = jsonA1;

        this.mockMvc.perform(get("/api/v1/article/1")
                        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected))
                .andReturn();
    }


    /**
     * Test to verify that creating a new article returns a valid URI.
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void createArticle() throws Exception {
        ArticleManipulationRequest request = new ArticleManipulationRequest("Eggs", false, Category.DAIRY, "testOwner");
        when(articleService.create(any(ArticleManipulationRequest.class))).thenReturn(new Article(3L, "Eggs", false, Category.DAIRY, "testOwner"));

        this.mockMvc.perform(post("/api/v1/article/")
                        .content("{\"name\":\"Eggs\",\"empty\":false,\"category\":\"DAIRY\",\"owner\":\"testOwner\"}")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated())
                .andExpect(content().string(""))
                .andExpect(header().exists(HttpHeaders.LOCATION))
                .andReturn();
    }
    /**
     * Test to verify that updating an existing article returns the updated article.
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void updateArticle() throws Exception {
        // Mocking articleService.update to return a non-null value
        when(articleService.update(any(Long.class), any(ArticleManipulationRequest.class)))
                .thenReturn(new Article(2L, "Updated Milk", true, Category.DAIRY, "testOwner"));

        // Performing the PUT request
        this.mockMvc.perform(put("/api/v1/article/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Updated Milk\",\"empty\":true,\"category\":\"DAIRY\",\"owner\":\"testOwner\"}"))
                .andExpect(status().isOk())
                .andReturn();
    }
    /**
     * Test to verify that fetching articles by owner returns the correct list of articles.
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void fetchArticlesByOwner() throws Exception {
        when(articleService.findByOwner("testOwner")).thenReturn(Arrays.asList(article1, article2));

        String expected = jsonA1_A2;

        this.mockMvc.perform(get("/api/v1/article/")
                        .param("owner", "testOwner")
                        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected))
                .andReturn();
    }

    /**
     * Test to verify that attempting to delete a non-existent article returns a not found status.
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void deleteNonExistentArticle() throws Exception {
        when(articleService.deleteById(3L)).thenReturn(false);

        this.mockMvc.perform(delete("/api/v1/article/3"))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    /**
     * Test to verify that creating an article with invalid data returns a bad request status.
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void createArticleWithInvalidData() throws Exception {
        ArticleManipulationRequest invalidRequest = new ArticleManipulationRequest("", false, Category.DAIRY, "testOwner");

        this.mockMvc.perform(post("/api/v1/article/")
                        .content("{\"name\":\"\",\"empty\":false,\"category\":\"DAIRY\",\"owner\":\"testOwner\"}")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    /**
     * Test to verify that fetching a non-existent article returns a not found status.
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void fetchNonExistentArticleById() throws Exception {
        when(articleService.findById(3L)).thenReturn(null);

        this.mockMvc.perform(get("/api/v1/article/3")
                        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound())
                .andReturn();
    }

}
