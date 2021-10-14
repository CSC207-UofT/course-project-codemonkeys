package Client;

import Identification.StringIdentifier;

public class Asset {
    //____________________ Variables ___________________________________________________________________________________
    private final StringIdentifier identifier;  // identifier for the string
    private Double value; // value of the asset in USD

    //____________________ Constructors ________________________________________________________________________________

    /**
     * Basic constructor for an Clients.Asset
     * @param id is the identifier of the Clients.Asset
     * @param value is the value of the asset in USD
     */
    public Asset(String id, Double value){
        this.identifier = new StringIdentifier(id);
        this.value = value;
    }

    //____________________ Methods _____________________________________________________________________________________


    //____________________ Generic Overrides ___________________________________________________________________________


    //____________________ Getters and Setters__________________________________________________________________________

    public StringIdentifier getIdentifier() {
        return identifier;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}