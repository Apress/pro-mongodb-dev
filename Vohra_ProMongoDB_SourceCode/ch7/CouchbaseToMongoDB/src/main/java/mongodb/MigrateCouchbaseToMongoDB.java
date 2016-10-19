package mongodb;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.bson.Document;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.view.ViewQuery;
import com.couchbase.client.java.view.ViewResult;
import com.couchbase.client.java.view.ViewRow;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MigrateCouchbaseToMongoDB {

	private static Bucket defaultBucket;

	private static MongoClient mongoClient;

	public static void main(String[] args) {
		Cluster cluster = CouchbaseCluster.create();

		defaultBucket = cluster.openBucket();
		 
		migrate();

	}

	public static void migrate() {

		mongoClient = new MongoClient(Arrays.asList(new ServerAddress(
				"localhost", 27017)));

		MongoDatabase db = mongoClient.getDatabase("local");

		MongoCollection<Document> coll = db.getCollection("catalog");

		ViewResult result = defaultBucket.query(ViewQuery.from("catalog",
				"catalog_view"));

		for (ViewRow viewRow : result) {

			Document catalog = new Document();

			JsonDocument json = viewRow.document();
			JsonObject jsonObj = json.content();

			Set<java.lang.String> fieldNames = jsonObj.getNames();
			Iterator<String> iter = fieldNames.iterator();

			while (iter.hasNext()) {

				String fieldName = iter.next();
				String fieldValue = jsonObj.getString(fieldName);

				catalog = catalog.append(fieldName, fieldValue);
			}

			coll.insertOne(catalog);

		}

	}

}
