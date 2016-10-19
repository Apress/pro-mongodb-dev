package com.mongo.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.mongo.config.SpringMongoApplicationConfig;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import com.mongo.model.Catalog;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public class App {

	static MongoOperations ops;
	static Catalog catalog1;
	static Catalog catalog2;

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(
				SpringMongoApplicationConfig.class);
		ops = context.getBean("mongoTemplate", MongoOperations.class);

		// createCollection();
		// createCatalogInstances();
		// addDocument();
		// updateFirst();
		// updateMulti();
		// findById();
		// findOne();
		// findAll();
		 find();
		// addDocumentBatch();

		//remove();

	}

	private static void createCollection() {
		if (!ops.collectionExists("catalog")) {
			ops.createCollection("catalog");
		} else {
			ops.dropCollection("catalog");
			ops.createCollection("catalog");
		}

	}

	private static void createCatalogInstances() {
		catalog1 = new Catalog("catalog1", "Oracle Magazine",
				"Oracle Publishing", "November-December 2013",
				"Engineering as a Service", "David A. Kelly");

		catalog2 = new Catalog("catalog2", "Oracle Magazine",
				"Oracle Publishing", "November-December 2013",
				"Quintessential and Collaborative", "Tom Haunert");
	}

	private static void addDocument() {

		catalog1 = new Catalog("catalog1", "Oracle Magazine",
				"Oracle Publishing", "November-December 2013",
				"Engineering as a Service", "David A. Kelly");
		// ops.save(catalog1, "catalog");//collection created implicitly
		ops.save(catalog1);// collection created implicitly by same name as
							// object class
		System.out.println("MongoDB generated Id: " + catalog1.getId());

		catalog2 = new Catalog("catalog2", "Oracle Magazine",
				"Oracle Publishing", "November-December 2013",
				"Quintessential and Collaborative", "Tom Haunert");
		ops.save(catalog2, "catalog");
		System.out.println("MongoDB generated Id: " + catalog2.getId());

	}

	private static void addDocumentBatch() {

		catalog1 = new Catalog("catalog1", "Oracle Magazine",
				"Oracle Publishing", "November-December 2013",
				"Engineering as a Service", "David A. Kelly");
		catalog2 = new Catalog("catalog2", "Oracle Magazine",
				"Oracle Publishing", "November-December 2013",
				"Quintessential and Collaborative", "Tom Haunert");

		ArrayList arrayList = new ArrayList();
		arrayList.add(catalog1);
		arrayList.add(catalog2);
		ops.insert(arrayList, "catalog");

		// ops.insert(arrayList,Catalog.class);

		// ops.insertAll(arrayList);

	}

	private static void findById() {

		catalog1 = new Catalog("catalog1", "Oracle Magazine",
				"Oracle Publishing", "November-December 2013",
				"Engineering as a Service", "David A. Kelly");

		ops.save(catalog1);

		// Catalog catalog = ops.findById(catalog1.getId(),
		// Catalog.class,"catalog");

		Catalog catalog = ops.findById(catalog1.getId(), Catalog.class);
		System.out.println("Id in Catalog instance: " + catalog1.getId());
		System.out.println("Journal : " + catalog.getJournal());
		System.out.println("Publisher : " + catalog.getPublisher());
		System.out.println("Edition : " + catalog.getEdition());
		System.out.println("Title : " + catalog.getTitle());
		System.out.println("Author : " + catalog.getAuthor());
	}

	private static void findOne() {
		createCatalogInstances();
		ops.save(catalog1);
		ops.save(catalog2);

		/*
		 * String _id = catalog2.getId(); Catalog catalog = ops.findOne(new
		 * Query(Criteria.where("_id").is(_id)), Catalog.class);
		 * System.out.println("Id in Catalog instance: " + catalog2.getId());
		 * System.out.println("Journal : " + catalog.getJournal());
		 * System.out.println("Publisher : " + catalog.getPublisher());
		 * System.out.println("Edition : " + catalog.getEdition());
		 * System.out.println("Title : " + catalog.getTitle());
		 * System.out.println("Author : " + catalog.getAuthor());
		 */

		DBObject dbObject = new BasicDBObject("id", new ObjectId(
				catalog1.getId()));
		BasicQuery query = new BasicQuery(dbObject);

		Catalog catalog = ops.findOne(query, Catalog.class);
		catalog = ops.findOne(query, Catalog.class, "catalog");
		System.out.println("Id in Catalog instance: " + catalog1.getId());
		System.out.println("Journal : " + catalog.getJournal());
		System.out.println("Publisher : " + catalog.getPublisher());
		System.out.println("Edition : " + catalog.getEdition());
		System.out.println("Title : " + catalog.getTitle());
		System.out.println("Author : " + catalog.getAuthor());

	}

	private static void findAll() {
		createCatalogInstances();
		ops.save(catalog1);
		ops.save(catalog2);
		List<Catalog> list = ops.findAll(Catalog.class);
		Iterator<Catalog> iter = list.iterator();
		while (iter.hasNext()) {
			Catalog catalog = iter.next();
			System.out.println("Journal : " + catalog.getJournal());
			System.out.println("Publisher : " + catalog.getPublisher());
			System.out.println("Edition : " + catalog.getEdition());
			System.out.println("Title : " + catalog.getTitle());
			System.out.println("Author : " + catalog.getAuthor());
		}
	}

	private static void find() {
		createCatalogInstances();
		ops.save(catalog1);
		ops.save(catalog2);
		
		/*DBObject dbObject = new BasicDBObject("publisher", "Oracle Publishing");
		BasicQuery query = new BasicQuery(dbObject);
		List<Catalog> list = ops.find(query, Catalog.class, "catalog");*/

		List<Catalog> list = ops.find(
				new Query(Criteria.where("journal").is("Oracle Magazine")),
				Catalog.class);
		Iterator<Catalog> iter = list.iterator();
		while (iter.hasNext()) {
			Catalog catalog = iter.next();
			System.out.println("Journal : " + catalog.getJournal());
			System.out.println("Publisher : " + catalog.getPublisher());
			System.out.println("Edition : " + catalog.getEdition());
			System.out.println("Title : " + catalog.getTitle());
			System.out.println("Author : " + catalog.getAuthor());
		}

	}

	private static void updateFirst() {
		createCatalogInstances();
		ops.save(catalog1);
		ops.save(catalog2);

		WriteResult result = ops.updateFirst(new Query(Criteria
				.where("edition").is("November-December 2013")), Update.update(
				"edition", "11-12-2013"), Catalog.class);
		System.out.println(result);

		List<Catalog> list = ops.findAll(Catalog.class);
		Iterator<Catalog> iter = list.iterator();
		while (iter.hasNext()) {
			Catalog catalog = iter.next();
			System.out.println("Journal : " + catalog.getJournal());
			System.out.println("Publisher : " + catalog.getPublisher());
			System.out.println("Edition : " + catalog.getEdition());
			System.out.println("Title : " + catalog.getTitle());
			System.out.println("Author : " + catalog.getAuthor());
		}

		/*
		 * DBObject dbObject = new BasicDBObject("edition",
		 * "November-December 2013"); BasicQuery query = new
		 * BasicQuery(dbObject); WriteResult result = ops.updateFirst(query,
		 * Update.update("edition", "11-12-2013"), Catalog.class);
		 * System.out.println(result);
		 * 
		 * List<Catalog> list = ops.findAll(Catalog.class); Iterator<Catalog>
		 * iter = list.iterator(); while (iter.hasNext()) { Catalog catalog =
		 * iter.next(); System.out.println("Journal : " + catalog.getJournal());
		 * System.out.println("Publisher : " + catalog.getPublisher());
		 * System.out.println("Edition : " + catalog.getEdition());
		 * System.out.println("Title : " + catalog.getTitle());
		 * System.out.println("Author : " + catalog.getAuthor()); }
		 */

	}

	private static void updateMulti() {
		createCatalogInstances();
		ops.save(catalog1);
		ops.save(catalog2);
		DBObject dbObject = new BasicDBObject("edition",
				"November-December 2013");
		BasicQuery query = new BasicQuery(dbObject);
		WriteResult result = ops.updateMulti(query,
				Update.update("edition", "11-12-2013"), Catalog.class);
		System.out.println(result);
		List<Catalog> list = ops.findAll(Catalog.class);
		Iterator<Catalog> iter = list.iterator();
		while (iter.hasNext()) {
			Catalog catalog = iter.next();
			System.out.println("Journal : " + catalog.getJournal());
			System.out.println("Publisher : " + catalog.getPublisher());
			System.out.println("Edition : " + catalog.getEdition());
			System.out.println("Title : " + catalog.getTitle());
			System.out.println("Author : " + catalog.getAuthor());
		}
		/*
		 * WriteResult result = ops.updateMulti(new Query(Criteria
		 * .where("edition").is("November-December 2013")), Update.update(
		 * "edition", "11-12-2013"), Catalog.class); System.out.println(result);
		 * findAll();
		 */
	}

	private static void remove() {

		createCatalogInstances();
		ops.save(catalog1);
		ops.save(catalog2);

		DBObject dbObject = new BasicDBObject("_id", catalog1.getId());
		BasicQuery query = new BasicQuery(dbObject);
		Catalog catalog = ops.findAndRemove(query, Catalog.class);
	//	Catalog catalog = ops.findAndRemove(query, Catalog.class, "catalog");
		System.out.println("Journal : " + catalog.getJournal());
		System.out.println("Publisher : " + catalog.getPublisher());
		System.out.println("Edition : " + catalog.getEdition());
		System.out.println("Title : " + catalog.getTitle());
		System.out.println("Author : " + catalog.getAuthor());
		
		
		

		/*
		 * DBObject dbObject = new
		 * BasicDBObject("edition","November-December 2013"); //DBObject
		 * dbObject = new BasicDBObject("_id", catalog1.getId()); BasicQuery
		 * query = new BasicQuery(dbObject); // WriteResult result =
		 * ops.remove(query,Catalog.class); WriteResult result =
		 * ops.remove(query, "catalog"); System.out.println(result);
		 */

		/*List<Catalog> list = ops.findAll(Catalog.class);
		Iterator<Catalog> iter = list.iterator();
		while (iter.hasNext()) {
			catalog = iter.next();
			System.out.println("Journal : " + catalog.getJournal());
			System.out.println("Publisher : " + catalog.getPublisher());
			System.out.println("Edition : " + catalog.getEdition());
			System.out.println("Title : " + catalog.getTitle());
			System.out.println("Author : " + catalog.getAuthor());
		}*/

	}

}
