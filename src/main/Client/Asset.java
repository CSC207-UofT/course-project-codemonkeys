package Client;

import Identification.Identifiable;
import Identification.Identifier;

public class Asset extends Identifiable {

    //____________________ Variables ___________________________________________________________________________________
    private Double value; // value of the asset in USD

    //____________________ Constructors ________________________________________________________________________________

    /**
     * Basic constructor for an Clients.Asset
     * @param id is the identifier of the Clients.Asset
     * @param value is the value of the asset in USD
     */
    public Asset(String id, Double value){
        super(id);
        this.value = value;
    }

    //____________________ Methods _____________________________________________________________________________________


    //____________________ Generic Overrides ___________________________________________________________________________


    //____________________ Getters and Setters__________________________________________________________________________

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}