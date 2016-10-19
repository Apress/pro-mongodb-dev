package mongodb;

import java.util.Map;
import java.util.Set;
import java.io.Serializable;
import org.bson.BSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Catalog extends BasicDBObject implements Serializable {

	public static final long serialVersionUID = 1L;

	public String catalogId;
	public String journal;
	public String publisher;
	public String edition;
	public String title;
	public String author;

	public Catalog() {
		super();
	}

	public Catalog(String catalogId, String journal, String publisher,
			String edition, String title, String author) {
		this.catalogId = catalogId;
		this.journal = journal;
		this.publisher = publisher;
		this.edition = edition;
		this.title = title;
		this.author = author;
	}
}
