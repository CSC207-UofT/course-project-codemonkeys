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


    public double getLiquidAssetValue() {
        return this.portfolio.CalculateLiquidValue();
    }


    public boolean hasAssetValue(String fromType, double value) {
        return this.portfolio.TypeAssetValue(fromType) >= value;
    }

// Not exactly sure about what the following two methods mean
    public Asset getAsset(String Type) {
        return this.portfolio.GetAsset(Type);
    }


    public void addAsset(String toType) {

    }
}