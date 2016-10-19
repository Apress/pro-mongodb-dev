package mongodb;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;

public class CreateCouchbaseDocument {

	public static void main(String args[]) {
		Cluster cluster = CouchbaseCluster.create();

		Bucket defaultBucket = cluster.openBucket();

		JsonObject catalogObj = JsonObject.empty()
				.put("journal", "Oracle Magazine")
				.put("publisher", "Oracle Publishing")
				.put("edition", "March April 2013")
				.put("title", "Engineering as a Service")
				.put("author", "David A. Kelly");

		defaultBucket.insert(JsonDocument.create("catalog1", catalogObj));
		
		  catalogObj = JsonObject.empty()
				.put("journal", "Oracle Magazine")
				.put("publisher", "Oracle Publishing")
				.put("edition", "March April 2013")
				.put("title", "Quintessential and Collaborative")
				.put("author", "Tom Haunert");

		defaultBucket.insert(JsonDocument.create("catalog2", catalogObj));

		cluster.disconnect();
	}

}
