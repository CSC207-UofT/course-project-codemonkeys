package Identification;

import java.util.Objects;
import java.util.UUID;

/**
 * This is a tagging class that provides the ability for implemented instances
 * to be uniquely identified and compared using UUID's. The UUID is automatically
 * assigned upon calling the constructor.
 *
 * Author: Langson Zhang
 * Date: Nov 21 2021
 * Version: 2.0
 */

public abstract class Identifiable {

    public final UUID id;

    /**
     * Default Constructor
     */
    public Identifiable() {
        this.id = UUID.randomUUID();
    }

    /**
     * Compares this Object's UUID with another Object's UUID.
     * If [other] is not an Identifiable Object, return false.
     * @param other is the Object to compare to
     * @return whether this is equal to [other]
     */
    @Override
    public boolean equals(Object other) {
        if(other instanceof Identifiable)
            return this.id.equals(((Identifiable) other).id);
        return false;
    }

    /**
     * Getter for UUID.
     * @return the UUID of the object.
     */
    public UUID getId(){
        return this.id;
    }

    /**
     * Hashes the UUID instead so that we can use Identifiable Objects as
     * keys in a HashMap without worrying about mutability.
     * @return the hashed this.id
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

}
