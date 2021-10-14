package Identification;

public abstract class Identifier<T> {
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
    public T getId(){
        return this.identifier;
    }
}
