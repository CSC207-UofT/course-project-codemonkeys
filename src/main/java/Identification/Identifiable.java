package Identification;

import java.util.Objects;
import java.util.UUID;

// A class that represents an identifiable object.
// Identification is done via UUID. If no cloning object is specified, the class will create a random UUID.
// The identifier is immutable.
public abstract class Identifiable {

    public final UUID id;

    // Create a random UUID
    public Identifiable() {
        this.id = UUID.randomUUID();
    }

    // Create an UUID from String
    public Identifiable(String str) {
        this.id = UUID.fromString("IDENTIFIABLE:" + str);
    }

    // Clone another identifiable object
    public Identifiable(Identifiable clonee) {
        this.id = clonee.id;
    }

    /*
    public UUID getId() {
        return this.id;
    }
     */
    @Override
    public boolean equals(Object other) {
        if(other instanceof Identifiable)
            return this.id.equals(((Identifiable) other).id);
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
