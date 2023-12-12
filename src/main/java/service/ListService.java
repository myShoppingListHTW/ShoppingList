package service;

import Repos.ListRepository;
import web.Transformers.ListTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
