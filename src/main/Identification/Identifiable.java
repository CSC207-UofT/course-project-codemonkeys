package Identification;

import java.awt.dnd.InvalidDnDOperationException;

public abstract class Identifiable {
    public Identifier id;

    public Identifiable(Object id){
        setId(id);
    }


    public Identifier getId(){
        return id;
    }

    /**
     * Sets the identifier of the object
     * @param id is an Identifier, or something that will be used to create an Identifier
     */
    public void setId(Object id){
        if(id == null)
            this.id = new Identifier(this);
        if (id instanceof Identifier)
            this.id = (Identifier) id;
        else
            this.id = new Identifier(id);
    }
}
