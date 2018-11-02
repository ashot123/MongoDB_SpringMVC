package com.jcg.springmvc.mongo.factory;

import org.apache.log4j.Logger;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

@SuppressWarnings("deprecation")
public class MongoFactory {

    private static Logger log = Logger.getLogger(MongoFactory.class);

    private static Mongo mongo;

    private MongoFactory() {
    }

    // Returns a mongo instance.
    public static Mongo getMongo() {
        int portNo = 27017;
        String hostname = "localhost";
        if (mongo == null) {
            try {
                mongo = new Mongo(hostname, portNo);
            } catch (MongoException ex) {
                log.error(ex);
            }
        }
        return mongo;
    }

    // Fetches the mongo database.
    public static DB getDB(String dbName) {
        return getMongo().getDB(dbName);
    }

    // Fetches the collection from the mongo database.
    public static DBCollection getCollection(String dbName, String db_collection) {
        return getDB(dbName).getCollection(db_collection);
    }
}