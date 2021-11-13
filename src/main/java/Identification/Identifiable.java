package Identification;


import java.util.Objects;
import java.util.UUID;

public abstract class Identifiable<T> {

    private UUID id;
    private T type;


    public Identifiable(){
        this.id = UUID.randomUUID();
    }

    public Identifiable(T type){
        this.type = type;
        this.id = UUID.randomUUID();
    }


    @Override
    public boolean equals(Object other) {
        if(other instanceof Identifiable)
            return this.type.equals(((Identifiable) other).getId());
        return false;
    }


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
