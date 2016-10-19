package com.mongo.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.mongo.config.SpringMongoApplicationConfig;
import com.mongo.model.Catalog;
import com.mongo.repositories.CatalogRepository;

public class CatalogService {

	public static CatalogRepository repository;
	public static ArrayList<Catalog> entities;
	public static Catalog catalog1;
	public static Catalog catalog2;

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(
				SpringMongoApplicationConfig.class);
		repository = context.getBean(CatalogRepository.class);
		// saveBatch();
		// count();
		// findAll();
		// saveBatch();
		// deleteAll();
		// deleteById();

		/*
		 * if (repository.exists("55cb4f50db9499f5a242ad93")) {
		 * findOne("55cb4f50db9499f5a242ad93"); }
		 */
		// save();

		// saveBatch();

		// deleteById();

		deleteAll();
	}

	public static void deleteAll() {
		catalog1 = new Catalog("", "Oracle Magazine", "Oracle Publishing",
				"11-12-2013", "Engineering as a Service", "Kelly, David");

		catalog2 = new Catalog("", "Oracle Magazine", "Oracle Publishing",
				"11-12-2013", "Quintessential and Collaborative",
				"Haunert, Tom");
		entities = new ArrayList<Catalog>();
		entities.add(catalog1);
		entities.add(catalog2);
		repository.save(entities);
		repository.deleteAll();
		findAll();
	}

	public static void deleteById() {
		catalog1 = new Catalog("", "Oracle Magazine", "Oracle Publishing",
				"11-12-2013", "Engineering as a Service", "Kelly, David");

		catalog2 = new Catalog("", "Oracle Magazine", "Oracle Publishing",
				"11-12-2013", "Quintessential and Collaborative",
				"Haunert, Tom");
		entities = new ArrayList<Catalog>();
		entities.add(catalog1);
		entities.add(catalog2);
		repository.save(entities);
		repository.delete(catalog1.getId());
		findAll();
	}

	public static void saveBatch() {

		catalog1 = new Catalog("", "Oracle Magazine", "Oracle Publishing",
				"11-12-2013", "Engineering as a Service", "Kelly, David");

		catalog2 = new Catalog("", "Oracle Magazine", "Oracle Publishing",
				"11-12-2013", "Quintessential and Collaborative",
				"Haunert, Tom");
		entities = new ArrayList<Catalog>();
		entities.add(catalog1);
		entities.add(catalog2);
		repository.save(entities);
		findAll();

	}

	public static void save() {

		Catalog catalog = new Catalog("", "Oracle Magazine",
				"Oracle Publishing", "11-12-2013", "Engineering as a Service",
				"Kelly, David");
		repository.save(catalog);
		findAll();

	}

	public static void findOne(String id) {

		Catalog catalog = repository.findOne(id);
		System.out.println("Journal: " + catalog.getJournal());
		System.out.println("Publisher: " + catalog.getPublisher());
		System.out.println("Edition: " + catalog.getEdition());
		System.out.println("Title: " + catalog.getTitle());
		System.out.println("Author: " + catalog.getAuthor());

	}

	public static void count() {
		System.out.println("Number of documents: " + repository.count());

	}

	public static void findAll() {

		Iterable<Catalog> iterable = repository.findAll();

		Iterator<Catalog> iter = iterable.iterator();
		while (iter.hasNext()) {
			Catalog catalog = iter.next();

			System.out.println("Journal: " + catalog.getJournal());
			System.out.println("Publisher: " + catalog.getPublisher());
			System.out.println("Edition: " + catalog.getEdition());
			System.out.println("Title: " + catalog.getTitle());
			System.out.println("Author: " + catalog.getAuthor());
		}
	}

}
