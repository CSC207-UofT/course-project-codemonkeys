package Entities;


public class GlobalPortfolio extends UserPortfolio{

    private static GlobalPortfolio instance = null;

    public static GlobalPortfolio getInstance() {
        if(GlobalPortfolio.instance == null) {
            GlobalPortfolio.instance = new GlobalPortfolio();
        }
        return GlobalPortfolio.instance;  // GlobalPortfolio only initiated for once
    }

    public double CalculateAssetValue(String type){
        // Calculate the total asset value of a specific type of asset in the portfolio.
        double result = 0;
        for(Asset a: this.assets){
            if(a.getType().equals(type)){
                result += a.getTotalPriceOwned();
            }
        }
        return result;
    }

    public double CalculateLiquidValue(){
        double result = 0;
        for(Asset a: this.assets){
            if(a.getType().equals("USD")){
                result += a.getTotalPriceOwned();
            }
        }
        return result;
    }
}
