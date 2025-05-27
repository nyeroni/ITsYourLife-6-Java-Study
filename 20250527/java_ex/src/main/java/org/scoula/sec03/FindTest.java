package org.scoula.sec03;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import java.util.Iterator;
import org.bson.Document;
import org.scoula.app.Database;

public class FindTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");
        FindIterable<Document> doc = collection.find();

        Iterator itr = doc.iterator();

        while(itr.hasNext()) {
            System.out.println("==> findResultRow : "+itr.next());
        }
        Database.close();
    }
}
