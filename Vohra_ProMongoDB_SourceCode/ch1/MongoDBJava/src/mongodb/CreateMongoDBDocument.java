package mongodb;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class CreateMongoDBDocument {

	public static void main(String[] args) {

		MongoClient mongoClient = new MongoClient(
				Arrays.asList(new ServerAddress("localhost", 27017)));
		for (String s : mongoClient.listDatabaseNames()) {
			System.out.println(s);
		}
		MongoDatabase db = mongoClient.getDatabase("local");
		MongoIterable<String> colls = db.listCollectionNames();
		System.out.println("MongoDB Collection Names: ");
		for (String s : colls) {
			System.out.println(s);
		}
		MongoCollection<Document> coll = db.getCollection("catalog");
		Document catalog = new Document("journal", "Oracle Magazine")
				.append("publisher", "Oracle Publishing")
				.append("edition", "November December 2013")
				.append("title", "Engineering as a Service")
				.append("author", "David A. Kelly");
		coll.insertOne(catalog);
		Document dbObj = coll.find().first();
		System.out.println(dbObj);
		Set<String> set = catalog.keySet();
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			Object obj = iter.next();
			System.out.println(obj);
			System.out.println(dbObj.get(obj.toString()));
		}
		mongoClient.close();

	}

}
