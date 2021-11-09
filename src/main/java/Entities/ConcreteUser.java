package Entities;

import java.util.List;
import java.util.UUID;

public class ConcreteUser implements User {
    private String name;
    private UUID id;
    private boolean banned;
    private Portfolio portfolio;

    public ConcreteUser(String name, UUID id) {
        this.name = name;
        this.id = id;
        this.portfolio = new Portfolio();
        this.banned = false;
    }
    public ConcreteUser(String name, UUID id, Portfolio portfolio){
        this.name = name;
        this.id = id;
        this.portfolio = new Portfolio();
        this.banned = false;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }
    public Portfolio getPortfolio() {
        return this.portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}