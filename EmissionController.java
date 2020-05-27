package com.vehicle_emission;

import java.util.ArrayList;

//emission controller class
public class EmissionController {

    //arraylist for storing transportation mode CO2 data
    ArrayList<Emission> eTransportationList = new ArrayList<Emission>();

    //Constructor with predefined CO2 emission data
    public EmissionController() {
        this.eTransportationList.add(new Emission("small-diesel-car", 142));
        this.eTransportationList.add(1, new Emission("small-petrol-car", 154));
        this.eTransportationList.add(2, new Emission("small-plugin-hybrid-car", 73));
        this.eTransportationList.add(3, new Emission("small-electric-car", 50));
        this.eTransportationList.add(4, new Emission("medium-diesel-car", 171));
        this.eTransportationList.add(5, new Emission("medium-petrol-car", 192));
        this.eTransportationList.add(6, new Emission("medium-plugin-hybrid-car", 110));
        this.eTransportationList.add(7, new Emission("medium-electric-car", 58));
        this.eTransportationList.add(8, new Emission("large-diesel-car", 209));
        this.eTransportationList.add(9, new Emission("large-petrol-car", 282));
        this.eTransportationList.add(10, new Emission("large-plugin-hybrid-car", 126));
        this.eTransportationList.add(11, new Emission("large-electric-car", 73));
        this.eTransportationList.add(12, new Emission("bus", 27));
        this.eTransportationList.add(13, new Emission("train", 6));

    }

    //retrieve CO2 relative to Transport mode
    private double findCOEmission(String transMode) {
        for (int i = 0; i < this.eTransportationList.size(); i++) {
            Emission emission = this.eTransportationList.get(i);
            if (emission.getTransportMode().equals(transMode)) {
                return emission.getCo2Emission();
            }
        }
        return -1;
    }

    //CO2 emission calculation relative to distance
    public double calculateEmission(String transMode, double distance) {
        double equilant = findCOEmission(transMode) * distance;
        return equilant;

    }

    //Printing method for given CO2 emission relative to Transport mode
    public void printTransportList() {
        System.out.println("Transportation methods in CO2e per passenger per km:");
        for (int i = 0; i < this.eTransportationList.size(); i++) {
            System.out.println((i + 1) + "." +
                    this.eTransportationList.get(i).getTransportMode() + " -> " +
                    this.eTransportationList.get(i).getCo2Emission());
        }
    }
    
}
