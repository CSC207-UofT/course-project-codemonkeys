package UseCase.PortfolioHelper;

import Entities.Containers.Processor;

/**
 * This is the concrete class for calculating profitabilities
 * It includes getters, add and calculate methods
 *
 * Author Zixin (Charlie) Guo
 * Date: Dec 05 2021
 * Version: 1.0
 */

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
