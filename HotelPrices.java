package com.javainuse;

import java.util.HashMap;
import java.util.Map;

public class HotelPrices {
    private Map<String, Double> unitPrices = new HashMap<>();

    public HotelPrices() {
        // Initialize the map with default unit prices
        unitPrices.put("standard/LPD/single/child", 40.0);
        unitPrices.put("standard/LPD/double/child", 30.0);
        unitPrices.put("standard/DPD/single/child", 60.0);
        unitPrices.put("standard/DPD/double/child", 50.0);
        unitPrices.put("standard/PC/single/child", 80.0);
        unitPrices.put("standard/PC/double/child", 70.0);
        unitPrices.put("standard/ALL INCLUSIVE/single/child", 100.0);
        unitPrices.put("standard/ALL INCLUSIVE/double/child", 90.0);
        unitPrices.put("suite/LPD/single/child", 70.0);
        unitPrices.put("suite/LPD/double/child", 60.0);
        unitPrices.put("suite/DPD/single/child", 90.0);
        unitPrices.put("suite/DPD/double/child", 80.0);
        unitPrices.put("suite/PC/single/child", 110.0);
        unitPrices.put("suite/PC/double/child", 100.0);
        unitPrices.put("suite/ALL INCLUSIVE/single/child", 150.0);
        unitPrices.put("suite/ALL INCLUSIVE/double/child", 140.0);
        unitPrices.put("standard/PC/single/adult", 120.0);
        unitPrices.put("standard/PC/double/adult", 100.0);
        unitPrices.put("standard/ALL INCLUSIVE/single/adult", 250.0);
        unitPrices.put("standard/ALL INCLUSIVE/double/adult", 230.0);
        unitPrices.put("standard/LPD/single/adult", 90.0);
        unitPrices.put("standard/LPD/double/adult", 80.0);
        unitPrices.put("standard/DPD/single/adult", 110.0);
        unitPrices.put("standard/DPD/double/adult", 100.0);
        unitPrices.put("suite/PC/single/adult", 120.0);
        unitPrices.put("suite/PC/double/adult", 100.0);
        unitPrices.put("suite/ALL INCLUSIVE/single/adult", 300.0);
        unitPrices.put("suite/ALL INCLUSIVE/double/adult", 270.0);
        unitPrices.put("suite/LPD/single/adult", 150.0);
        unitPrices.put("suite/LPD/double/adult", 130.0);
        unitPrices.put("suite/DPD/single/adult", 200.0);
        unitPrices.put("suite/DPD/double/adult", 180.0);
        
      
    }
    public Map getUnitPrices () {
    	return unitPrices;
    }
    public double getUnitPrice(String roomType) {
        return unitPrices.getOrDefault(roomType, 0.0);
    }

    public void setUnitPrice(String roomType, double price) {
        unitPrices.put(roomType, price);
    }
}
