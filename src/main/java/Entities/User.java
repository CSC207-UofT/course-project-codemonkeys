package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.lang.Double.NaN;
public abstract class User{      // Apply the decoration design pattern.
    private UUID id;
    private Portfolio portfolio;


    public double getLiquidAssetValue() {
        return this.portfolio.CalculateLiquidValue();
    }


    public boolean hasAssetValue(String fromType, double value) {
        return this.portfolio.TypeAssetValue(fromType) >= value;
    }

    public Asset getAsset(String Type) {
        return this.portfolio.GetAsset(Type);
    }

    public void addAsset(String Type) {
        this.portfolio.AddAssetType(Type);
    }


}


