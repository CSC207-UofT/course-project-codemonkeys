package Client;

import Identification.Identifiable;
import Identification.Identifier;

import java.util.HashMap;

public class Portfolio extends Identifiable {
    //____________________ Variables ___________________________________________________________________________________
    HashMap<Identifier, Asset> assetList;

    //____________________ Constructors ________________________________________________________________________________
    public Portfolio(){
        super(null);
        assetList = new HashMap<>();
    }

    //____________________ Methods _____________________________________________________________________________________

    public void add(Asset asset){
        assetList.put(asset.getId(), asset);
    }

    //____________________ Generic Overrides ___________________________________________________________________________


    //____________________ Getters and Setters__________________________________________________________________________

}
