package entities.assets;

/**
 * This is the Data Access Interface. Dependency Inversion is achieved through this interface when passing real-time
 * asset price data into asset classes. All asset data sources must implement this interface.
 *
 * Author Andrew Zhang
 * Date: Nov 25 2021
 * Version: 1.0
 */

public interface DataAccessInterface {
    /**
     * Updates asset price data given asset symbol.
     */
    double update(String symbol);
}
