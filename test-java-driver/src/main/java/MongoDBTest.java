import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDBTest {
    public static void main(String[] args) {
        String uri = "mongodb://35.200.142.209:27017/?socketTimeoutMS=60000&connectTimeoutMS=60000";
        
        try (MongoClient mongoClient = new MongoClient(new MongoClientURI(uri))) {
            System.out.println("Connected to MongoDB!");

            MongoCursor<String> dbNames = mongoClient.listDatabaseNames().iterator();
            System.out.println("Databases:");
            while (dbNames.hasNext()) {
                System.out.println(dbNames.next());
            }
        } catch (Exception e) {
            System.err.println("An error occurred:");
            e.printStackTrace();
        }
    }
}
