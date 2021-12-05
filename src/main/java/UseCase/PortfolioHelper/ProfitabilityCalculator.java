package UseCase.PortfolioHelper;

import Entities.Containers.Processor;

public class ProfitabilityCalculator extends Processor {
    private double profitability;

    public ProfitabilityCalculator(){
        this.profitability = 0.0;
    }

    // Getter and Setter for profitability
    public double getProfitability() {
        return this.calculate();
    }

    public void setProfitability(double profitability) {
        this.profitability = profitability;
    }

    public double calculate(){
        // can insert algorithm for calculating profitability in the future
        return profitability;
    }
}
