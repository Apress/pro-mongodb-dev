package mongodb;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
 

public class MongoDBClient {

	public static void main(String[] args) {

		MongoClient mongoClient = new MongoClient(
				Arrays.asList(new ServerAddress("localhost", 27017)));

		MongoDatabase db = mongoClient.getDatabase("local");

		MongoCollection<Document> coll = db.getCollection("catalogColl");
		
		
		Document catalog = new Document("journal", "Oracle Magazine")
				.append("publisher", "Oracle Publishing")
				.append("edition", "November December 2013")
				.append("title", "Engineering as a Service")
				.append("author", "David A. Kelly");
		coll.insertOne(catalog);

		catalog = new Document("journal", "Oracle Magazine")
				.append("publisher", "Oracle Publishing")
				.append("edition", "November December 2013")
				.append("title", "Quintessential and Collaborative")
				.append("author", "Tom Haunert");
		coll.insertOne(catalog);

		FindIterable<Document> iterable = coll.find();

		String documentKey = null;

		for (Document document : iterable) {
			Set<String> keySet = document.keySet();
			Iterator<String> iter = keySet.iterator();
			while (iter.hasNext()) {
				documentKey = iter.next();
				System.out.println(documentKey);
				System.out.println(document.get(documentKey));

			}
		}

	}

}
