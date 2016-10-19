package kundera;

import java.io.Serializable;
 

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Catalog
 * 
 */
@Entity
@Table(name = "catalog", schema = "local@kundera")
public class Catalog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "_id")
	private String catalogId;

	public Catalog() {
		super();
	}

	@Column(name = "journal")
	private String journal;

	@Column(name = "publisher")
	private String publisher;

	@Column(name = "edition")
	private String edition;

	@Column(name = "title")
	private String title;

	@Column(name = "author")
	private String author;

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}

