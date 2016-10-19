package mongodb;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
 
public class CreateCassandraDatabase {
    private static Cluster cluster;
    private static Session session;
    public static void main(String[] argv) {
        cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        session = cluster.connect();
        createKeyspace();
        createTable();
        insert();
        select();
    }
    private static void createKeyspace() {
        session.execute("CREATE KEYSPACE IF NOT EXISTS datastax WITH replication "
                + "= {'class':'SimpleStrategy', 'replication_factor':1};");
    }
    private static void createTable() {
        session.execute("CREATE TABLE IF NOT EXISTS datastax.catalog (catalog_id text,journal text,publisher text, edition text,title text,author text,PRIMARY KEY (catalog_id, journal))");
    }
    private static void insert() {
        session.execute("INSERT INTO datastax.catalog (catalog_id, journal, publisher, edition,title,author) VALUES ('catalog1','Oracle Magazine', 'Oracle Publishing', 'November-December 2013', 'Engineering as a Service','David A.  Kelly') IF NOT EXISTS");
        session.execute("INSERT INTO datastax.catalog (catalog_id, journal, publisher, edition,title,author) VALUES ('catalog2','Oracle Magazine', 'Oracle Publishing', 'November-December 2013', 'Quintessential and Collaborative','Tom Haunert') IF NOT EXISTS");
    }
    private static void select() {
        ResultSet results = session.execute("select * from datastax.catalog");
        for (Row row : results) {
            System.out.println("Catalog Id: " + row.getString("catalog_id"));
            System.out.println("\n");
            System.out.println("Journal: " + row.getString("journal"));
            System.out.println("\n");
            System.out.println("Publisher: " + row.getString("publisher"));
            System.out.println("\n");
            System.out.println("Edition: " + row.getString("edition"));
            System.out.println("\n");
            System.out.println("Title: " + row.getString("title"));
            System.out.println("\n");
            System.out.println("Author: " + row.getString("author"));
            System.out.println("\n");
        }
    }
}
