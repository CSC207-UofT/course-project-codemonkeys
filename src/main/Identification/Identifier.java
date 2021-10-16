package Identification;

public class Identifier<T> {
    T identifier; // the identifier

    /**
     * Basic constructor for an Identifier
     * @param identifier explains itself
     */
    public Identifier(T identifier) {
        this.identifier = identifier;
    }

    /**
     * return the identity of desired object
     */
    public boolean equals(Object other){
        return identifier.equals(other);
    }

    @Override
    public String toString() {
        return identifier.toString();
    }
}
