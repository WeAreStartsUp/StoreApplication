package com.startsup.main.repositories;

import com.startsup.main.models.Store;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface StoreRepository extends MongoRepository<Store, String> {
    @Query("{name:'?0'}")
    Store findItemByName(String name);

//    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
//    List<Store> findAll(String category);

    public long count();
}
