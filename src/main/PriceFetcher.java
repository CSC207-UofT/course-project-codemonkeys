public class PriceFetcher implements Fetcher<Transaction, Integer> {
    //____________________ Variables ___________________________________________________________________________________


    //____________________ Constructors ________________________________________________________________________________
    public PriceFetcher(){

    }

    //____________________ Methods _____________________________________________________________________________________

    /**
     * Fetches the price of the transaction
     * @param transaction holds the all the necessary information for an API fetch
     * @return the total value of the transaction
     */
    @Override
    public Integer fetch(Transaction transaction) {
        return 10;
    }
    //____________________ Generic Overrides ___________________________________________________________________________


    //____________________ Getters and Setters__________________________________________________________________________

}
