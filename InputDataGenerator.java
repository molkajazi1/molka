package com.javainuse;

public class InputDataGenerator {
    private int eventCount=2;
    private final int totalEvents = 10; // Adjust this as needed

    InputData generate() {
       // if (eventCount < totalEvents) {
            int numberOfAdults = (eventCount % 4) + 1;
            int numberOfChildren = (eventCount % 2);
            String[] roomTypes = {"suite", "standard"};
            String[] roomCapacities = {"single", "double"};
            String[] boardTypes = {"LPD", "DPD", "PC", "ALL INCLUSIVE"};
            String[] personTypes = {"adult","child"};

            String roomType = roomTypes[eventCount % roomTypes.length];
            String roomCapacity = roomCapacities[eventCount % roomCapacities.length];
            String boardType = boardTypes[eventCount % boardTypes.length];
            String personType = personTypes[eventCount % personTypes.length];

            eventCount++;
            return new InputData(numberOfAdults, numberOfChildren, roomType, roomCapacity, boardType,personType);
        //}
       // return null;
    }
  
}