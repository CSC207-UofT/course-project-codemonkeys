package Entities;

import java.util.List;
import java.util.UUID;

public class ConcreteUser implements User{
    private String name;
    private UUID id;
    private Portfolio portfolio;

    public ConcreteUser(String name){
        this.name = name;
        this.portfolio = new Portfolio();
    }

    public String getName() {
        return this.name;
    }


    public Portfolio getPorfolio() {
        return this.portfolio;
    }
}
