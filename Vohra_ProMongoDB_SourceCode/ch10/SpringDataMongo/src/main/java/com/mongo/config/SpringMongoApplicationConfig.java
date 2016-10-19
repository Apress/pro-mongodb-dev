package com.mongo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.context.annotation.Bean;

import com.mongo.service.CatalogService;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import java.util.Arrays;

@Configuration
@EnableMongoRepositories("com.mongo.repositories")
@ComponentScan(basePackageClasses = { CatalogService.class })
public class SpringMongoApplicationConfig extends AbstractMongoConfiguration {

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient(Arrays.asList(new ServerAddress("localhost",
				27017)));
	}

	@Override
	protected String getDatabaseName() {
		return "local";
	}

	@Override
	protected String getMappingBasePackage() {
		return "com.mongo.model";
	}
}
