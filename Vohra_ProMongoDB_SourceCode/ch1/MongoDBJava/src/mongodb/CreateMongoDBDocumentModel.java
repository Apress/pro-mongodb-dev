package mongodb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class CreateMongoDBDocumentModel {

	public static void main(String[] args) {

		MongoClient mongoClient = new MongoClient(
				Arrays.asList(new ServerAddress("localhost", 27017)));

		MongoDatabase db = mongoClient.getDatabase("local");

		MongoCollection<Document> coll = db.getCollection("catalog-collection");

		Catalog catalog1 = new Catalog();
		catalog1.put("catalogId", "catalog1");
		catalog1.put("journal", "Oracle Magazine");
		catalog1.put("publisher", "Oracle Publishing");
		catalog1.put("edition", "November December 2013");
		catalog1.put("title", "Engineering as a Service");
		catalog1.put("author", "David A. Kelly");

		Catalog catalog2 = new Catalog();
		catalog2.put("catalogId", "catalog2");
		catalog2.put("journal", "Oracle Magazine");
		catalog2.put("publisher", "Oracle Publishing");
		catalog2.put("edition", "November December 2013");
		catalog2.put("title", "Quintessential and Collaborative");
		catalog2.put("author", "Tom Haunert");

		Document documentSet = new Document();
		documentSet.append("catalog1", catalog1);
		documentSet.append("catalog2", catalog2);

		ArrayList<Document> arrayList = new ArrayList<Document>();
		arrayList.add(documentSet);

		coll.insertMany(arrayList);

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

		mongoClient.close();

	}
}
