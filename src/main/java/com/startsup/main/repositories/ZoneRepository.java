package com.startsup.main.repositories;

import com.startsup.main.models.Store;
import com.startsup.main.models.Zone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ZoneRepository extends MongoRepository<Zone, String> {
    @Query("{name:'?0'}")
    Zone findItemByName(String name);

    public long count();
}
