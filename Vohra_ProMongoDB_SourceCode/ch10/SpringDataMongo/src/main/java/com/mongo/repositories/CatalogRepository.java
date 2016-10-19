package com.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.model.Catalog;

public interface CatalogRepository extends MongoRepository<Catalog, String> {

}
