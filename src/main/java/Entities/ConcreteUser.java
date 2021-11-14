package Entities;

import java.util.UUID;

public class ConcreteUser implements User {
    private String name;
    private UUID id;
    private boolean banned;
    private UserPortfolio portfolio;

    public ConcreteUser(String name, UUID id) {
        this.name = name;
        this.id = id;
        this.portfolio = new UserPortfolio();
        this.banned = false;
    }

    public ConcreteUser(String name) {
        this.name = name;
        this.id = UUID.randomUUID();
        this.portfolio = new UserPortfolio();
        this.banned = false;
    }

    public ConcreteUser(String name, UUID id, UserPortfolio portfolio) {
        this.name = name;
        this.id = id;
        this.portfolio = new UserPortfolio();
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

    public UserPortfolio getPortfolio() {
        return this.portfolio;
    }

    public void setPortfolio(UserPortfolio portfolio) {
        this.portfolio = portfolio;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
