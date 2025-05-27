package org.scoula.sec03;

import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.scoula.app.Database;

public class FindOneTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");
        String id = "666a6296f4fe57189cd03eea";
        Bson query = eq("_id", new ObjectId(id));
        Document doc = collection.find(query).first();
        System.out.println("==> findByIdResult : " + doc);
        Database.close();    }
}
