/*
 * Created on 2023-08-25 ( Date ISO 2023-08-25 - Time 16:42:25 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.startsup.merchant.database.repository;


import com.startsup.merchant.entities.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring data Jpa repository for "Items" <br>
 * @author Telosys (http://www.telosys.org/) version 3.3.0
 */
@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer>, JpaSpecificationExecutor<Items> {
}