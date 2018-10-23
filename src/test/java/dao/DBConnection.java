package dao;

import static com.mongodb.client.model.Filters.eq;

import java.util.Date;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DBConnection {
	
	private static MongoClient mongoClient;
		
	public static MongoClient getConnection() {
        return new MongoClient( "localhost" , 27017 ); 
    }
	
	public static MongoDatabase accessDatabse(String dataBase) {
		return mongoClient.getDatabase(dataBase);
	}
	
	public static void cleanUpCollection(String collection) {
		mongoClient = getConnection();
		// Accessing the database 
        MongoDatabase database = accessDatabse("blogs");
        
        MongoCollection<Document> col = database.getCollection(collection);

        col.drop();
        
        //col.find(eq("username", "asdf.asdf")).forEach(printBlock);
        
        mongoClient.close();

	}

	public static void createPost(String collection) {
		mongoClient = getConnection();
		// Accessing the database 
        MongoDatabase database = accessDatabse("blogs");
        
        MongoCollection<Document> col = database.getCollection(collection);
        
        
        Document postDoc = col.find(eq("title", "some title")).first();
        if(postDoc!=null) {
            System.out.println("*********************** Post already present *********************** ");
        } 
        else {
            Date date = new Date();
            Document document = new Document("author", "asdf.asdf@example.com")
    				            .append("title", "some title")
    				            .append("description", "some description")
    				            .append("body", "some body")
    				            .append("createdAt", date)
    				            .append("updatedAt", date);
            col.insertOne(document);
        }
        
        mongoClient.close();
		 
	}
	
	public static void createUser(String collection) {
		mongoClient = getConnection();
		// Accessing the database 
        MongoDatabase database = accessDatabse("blogs");
        
        MongoCollection<Document> col = database.getCollection(collection);
        
        Document userDoc = col.find(eq("username", "asdf.asdf")).first();
        if(userDoc!=null) {
            System.out.println("*********************** User already present *********************** ");
        } 
        else {
            Date date = new Date();            
            Document document = new Document("username", "asdf.asdf")
    				            .append("email", "asdf.asdf@example.com")
    				            .append("profile", new Document("firstname", "")
    			            						.append("lastname", "")
    			            						.append("address", "")
    			            						.append("website", "")
    			            						)
    				            .append("passwordHash", "$2a$12$ZSTdg5Wke4hSnSE8ZXQYjOr0AEqMMsqxvHfWJyVvJD7Bu5tLFbQLa")
    				            .append("createdAt", date)
    				            .append("updatedAt", date);
            col.insertOne(document);
        }
        
        mongoClient.close();

	}

	public static void main(String[] args) {
		// cleanUpCollection("users");
		// createUser("users");
	}
	
	static Block<Document> printBlock = new Block<Document>() {
	       @Override
	       public void apply(final Document document) {
	           System.out.println(document.toJson());
	       }
	};
}
