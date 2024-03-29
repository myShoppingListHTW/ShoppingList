package HTWBerlin.ShoppingList.service;

import HTWBerlin.ShoppingList.Repos.ArticleRepository;
import HTWBerlin.ShoppingList.Entities.ArticleEntity;
import HTWBerlin.ShoppingList.web.API.Article;
import HTWBerlin.ShoppingList.web.API.ArticleManipulationRequest;
import HTWBerlin.ShoppingList.web.ArticleTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {


    private final ArticleRepository articleRepository;
    private final ArticleTransformer articleTransformer;
    public ArticleService(ArticleRepository articleRepository, ArticleTransformer articleTransformer) {
        this.articleRepository = articleRepository;
        this.articleTransformer = articleTransformer;
    }

    public List<Article> findAll() {
        List<ArticleEntity> articles = (List<ArticleEntity>) articleRepository.findAll();
        return articles.stream()
                .map(articleTransformer::transformEntity)
                .collect(Collectors.toList());
    }
    public List<Article> findByOwner(String owner) {
        List<ArticleEntity> articles = (List<ArticleEntity>) articleRepository.findAll();
        return articles.stream()
                .filter(article -> article.getOwner().equals(owner))
                .map(articleTransformer::transformEntity)
                .collect(Collectors.toList());
    }

    public Article findById(Long id) {
        var personEntity = articleRepository.findById(id);
        return personEntity.map(articleTransformer::transformEntity).orElse(null);
    }


    public Article create(ArticleManipulationRequest request) {
        var articleEntity = new ArticleEntity(request.getName(), request.isEmpty(), request.getCategory(), request.getOwner());
        articleEntity  = articleRepository.save(articleEntity);
        return articleTransformer.transformEntity(articleEntity);
    }

    public Article update(Long id, ArticleManipulationRequest request) {
        var articleEntityOptional = articleRepository.findById(id);
        if (articleEntityOptional.isEmpty()) {
            return null;
        }
        var articleEntity = articleEntityOptional.get();
        articleEntity.setName(request.getName());
        articleEntity.setEmpty(request.isEmpty());
        articleEntity.setCategory(request.getCategory());
        articleEntity.setOwner(request.getOwner());
        articleEntity = articleRepository.save(articleEntity);
        return articleTransformer.transformEntity(articleEntity);
    }

    public boolean deleteById(Long id) {
        if (!articleRepository.existsById(id)) {
            return false;
        }
        articleRepository.deleteById(id);
        return true;
    }

}