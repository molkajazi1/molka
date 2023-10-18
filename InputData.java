package com.javainuse;

import java.util.Map;
import java.util.Map.Entry;

public class InputData {
    private int numberOfAdults;
    private int numberOfChildren;
    private String roomType;
    private String roomCapacity;
    private String boardType;
    private String personType;
    private long timestamp; // Add this field


    public InputData(int numberOfAdults, int numberOfChildren, String roomType, String roomCapacity, String boardType, String personType) {
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
        this.roomType = roomType;
        this.roomCapacity = roomCapacity;
        this.boardType = boardType;
        this.personType = personType;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getRoomCapacity() {
        return roomCapacity;
    }

    public String getBoardType() {
        return boardType;
    }
    public String getPersonType() {
    	return personType;
    }
    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    // Add your logic for calculating the package price based on the input data
    public double calculatePackagePrice() {
        HotelPrices hotelPrices = new HotelPrices();
        double pricePerAdult = 0.0;  // Initialize with a default value
        double pricePerChild = 0.0;  // Initialize with a default value
        String hotelPricesKey = null ;
        Map<String, Double> map = hotelPrices.getUnitPrices();
        // Retrieve the key from the hotelPrices map
        String key = String.format("%s/%s/%s/%s", roomType, boardType, roomCapacity, personType);
        
        if ("adult".equals(personType)) {  // Use equals for string comparison
            pricePerAdult = hotelPrices.getUnitPrice(key);
            key = String.format("%s/%s/%s/%s", roomType, boardType, roomCapacity,"child");
            pricePerChild = hotelPrices.getUnitPrice(key);
            
        } else {
            pricePerChild = hotelPrices.getUnitPrice(key);
            key = String.format("%s/%s/%s/%s", roomType, boardType, roomCapacity,"adult");
            pricePerAdult = hotelPrices.getUnitPrice(key);
        }
       /* for (Entry<String, Double> entry : map.entrySet()) {
           hotelPricesKey = entry.getKey(); // Get the key of the current 
           if (key.equals(hotelPricesKey)) {
               if ("adult".equals(personType)) {  // Use equals for string comparison
                   pricePerAdult = hotelPrices.getUnitPrice(key);
                   
               } else {
                   pricePerChild = hotelPrices.getUnitPrice(key);
               }
               break;
           }
           
        }*/    
        double totalPrice = pricePerAdult * numberOfAdults + pricePerChild * numberOfChildren;
        System.out.println("key "+key + " "+totalPrice+"numberOfAdults"+numberOfAdults+"numberOfChildren"+numberOfChildren);
        return totalPrice;
    }

}