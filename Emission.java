package com.vehicle_emission;

//emission class to hold transport mode and co2 value
public class Emission {

    private String transportMode;
    private double co2Emission;

    //emission class constructor
    public Emission(String transportMode, double co2Emission) {
        this.transportMode = transportMode;
        this.co2Emission = co2Emission;
    }

    //emission class getter
    public String getTransportMode() {
        return transportMode;
    }

    public double getCo2Emission() {
        return co2Emission;
    }

    //calling emission class variable as combined string
    @Override
    public String toString() {
        return "Emisssion{" +
                "transportMode of " + transportMode + '\'' +
                ", produces co2Emission of " + co2Emission +
                '}';
    }

}
