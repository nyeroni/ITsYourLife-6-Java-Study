package org.scoula.sec04;

import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.scoula.app.Database;

public class UpdateOneTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("users");
        String id = "666a6b65a25a4c74fddfedc2";

        Bson query = eq("_id", new ObjectId(id));
        Bson updates = Updates.combine(
                Updates.set("name", "modify name"),
                Updates.currentTimestamp("last_updated")
        );

        UpdateResult result = collection.updateOne(query, updates);
        System.out.println("==> UpdateResult : " + result.getModifiedCount());
        Database.close();
    }
}
