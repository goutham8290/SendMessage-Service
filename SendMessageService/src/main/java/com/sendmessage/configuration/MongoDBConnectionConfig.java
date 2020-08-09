package com.sendmessage.configuration;

import java.util.List;
import java.util.Objects;

public class MongoDBConnectionConfig {

    /**
     * The credentials user and password.
     */
    private Credentials credentials;

    /**
     * The lis of seeds.
     */
    private List<Seed> seeds;

    /**
     * The db.
     */
    private String database;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MongoDBConnectionConfig that = (MongoDBConnectionConfig) o;
        return Objects.equals(credentials, that.credentials) &&
                Objects.equals(seeds, that.seeds) &&
                Objects.equals(database, that.database);
    }

    @Override
    public int hashCode() {
        return Objects.hash(credentials, seeds, database);
    }


    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public List<Seed> getSeeds() {
        return seeds;
    }

    public void setSeeds(List<Seed> seeds) {
        this.seeds = seeds;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}


