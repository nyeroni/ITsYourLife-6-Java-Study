package org.scoula.app;

import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.scoula.app.domain.Todo;

public class App {
    public static void main(String[] args) {
        MongoCollection<Todo> collection = Database.getCollection("todo", Todo.class);
        Todo newtodo = new Todo(null, "POJO", "POJO 테스트 확인", false);
        collection.insertOne(newtodo);

        List<Todo> newTodos = Arrays.asList(
                new Todo(null, "POJO2", "POJO2 테스트 확인", false),
                new Todo(null, "POJO3", "POJO3 테스트 확인", true),
                new Todo(null, "POJO4", "POJO4 테스트 확인", false)
        );

        collection.insertMany(newTodos);

        List<Todo> todos = new ArrayList<>();
        collection.find().into(todos
        )
        ;

        for(Todo todo : todos) {
            System.out.println
                    (todo);

        }

        String id = "666a6296f4fe57189cd03eea";
        Bson query = eq("_id", new ObjectId(id));

        Todo todo = collection.find(query).first();
        System.out.println("==> findByIdResult : " + todo);

        Database.close();
    }
}
