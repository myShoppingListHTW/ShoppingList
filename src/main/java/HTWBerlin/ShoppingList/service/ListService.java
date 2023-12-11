package HTWBerlin.ShoppingList.service;

import HTWBerlin.ShoppingList.Entities.ListEntity;
import HTWBerlin.ShoppingList.Objects.ShoppingList;
import HTWBerlin.ShoppingList.Repos.ListRepository;
import HTWBerlin.ShoppingList.web.ListTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListService {


    private final ListRepository listRepository;
    private final ListTransformer listTransformer;

public ListService(ListRepository listRepository, ListTransformer listTransformer) {
        this.listRepository = listRepository;
        this.listTransformer = listTransformer;
    }

    @Autowired
    ListRepository repo;


}
