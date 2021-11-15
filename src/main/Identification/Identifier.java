package Identification;

public class Identifier<T> {
    private T id; // the identifier

    /**
     * Basic constructor for an Identifier
     * @param identifier explains itself
     */
    public Identifier(T identifier) {
        this.id = identifier;
    }

    /**
     * Compares two
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other){
        if (other instanceof Identifier){
            return this.id.equals(((Identifier) other).getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return id.toString();
    }

    public T getId() {
        return id;
    }
}
