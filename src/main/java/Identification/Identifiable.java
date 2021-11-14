package Identification;


import java.util.Objects;
import java.util.UUID;

public abstract class Identifiable<T> {

    private UUID id; // unique id
    private T type; // user defined type for the object


    public Identifiable(){
        this.id = UUID.randomUUID();
    }

    public Identifiable(T type){
        this.type = type;
        this.id = UUID.randomUUID();
    }


    /**
     * Checks for equivalency between the UUIDs
     * @param other is the other object
     * @returns whether the two objects are equal
     */
    @Override
    public boolean equals(Object other) {
        if(other instanceof Identifiable)
            return this.getId().equals(((Identifiable) other).getId());
        return false;
    }

    /**
     * Hash the id instead
     * @returns the hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public T getType(){
        return this.type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
