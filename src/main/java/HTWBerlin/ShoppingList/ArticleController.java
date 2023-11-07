package HTWBerlin.ShoppingList;

import HTWBerlin.ShoppingList.web.API.Article;
import HTWBerlin.ShoppingList.web.API.ArticleManipulationRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@Validated
public class ArticleController {

    @Autowired
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping(path = "/api/v1/article")
    public ResponseEntity<List<Article>> fetchArticles() {
        return ResponseEntity.ok(articleService.findAll());
    }

    @GetMapping(path = "/api/v1/article/{id}")
    public ResponseEntity<Article> fetchArticleById(@PathVariable Long id) {
        var article = articleService.findById(id);
        return article != null? ResponseEntity.ok(article) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/article")
    public ResponseEntity<Void> createArticle(@Valid @RequestBody ArticleManipulationRequest request) throws URISyntaxException {
        var article = articleService.create(request);
        URI uri = new URI("/api/v1/article/" + article.getId());
        return ResponseEntity
                .created(uri)
                .header("Access-Control-Expose-Headers", "Location")
                .build();
    }

    @PutMapping(path = "/api/v1/article/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody ArticleManipulationRequest request) {
        var article = articleService.update(id, request);
        return article != null? ResponseEntity.ok(article) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/article/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        boolean successful = articleService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}