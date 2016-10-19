package mongodb;


import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import org.bson.Document;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ColumnDefinitions;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MigrateCassandraToMongoDB {

	private static Cluster cluster;

	private static Session session;

	private static MongoClient mongoClient;

	public static void main(String[] args) {

		cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		session = cluster.connect();

		session = cluster.connect();
		migrate();
		mongoClient.close();
		session.close();
		cluster.close();

	}

	public static void migrate() {

		mongoClient = new MongoClient(Arrays.asList(new ServerAddress(
				"localhost", 27017)));

		MongoDatabase db = mongoClient.getDatabase("local");

		MongoCollection<Document> coll = db.getCollection("catalog");

		ResultSet results = session.execute("select * from datastax.catalog");

		for (Row row : results) {

			ColumnDefinitions columnDefinitions = row.getColumnDefinitions();

			Iterator<ColumnDefinitions.Definition> iter = columnDefinitions
					.iterator();

			Document catalog = new Document();
			while (iter.hasNext()) {
				ColumnDefinitions.Definition column = iter.next();
				String columnName = column.getName();
				String columnValue = row.getString(columnName);

				catalog = catalog.append(columnName, columnValue);

			}

			coll.insertOne(catalog);

		}

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
