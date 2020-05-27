package com.vehicle_emission;

import java.util.*;
import java.lang.*;


public class Main {
    ///static variables
    private static Scanner scanner = new Scanner(System.in);
    private static double traversedDistance;
    private static EmissionController controller = new EmissionController();
    private static String method = null;
    private static String distance = null;
    private static String str = null;

    public static void main(String[] args) {
        //
        ///Prints transportation co2 emission list
        controller.printTransportList();

        boolean testQuery = false;/// for looping test query
        boolean quit = false;//// for looping program

        while (!quit) {


            while (!testQuery) {

                //Enter emission query
                System.out.println("Enter any query as given in the functional requirements");
                str = scanner.nextLine();
                // checks emission query for parse string
                method = splitingEmissionQuery(str, "--transportation-method");

                // checks emission query for parse string
                distance = splitingEmissionQuery(str, "--distance");


                // check if the entered query matches the functional requirements
                if (isNullOrEmpty(method) || isNullOrEmpty(distance)) {
                    System.out.println("Compulsory to enter Transportation method and Distance as in the Functional Requirements");
                } else {
                    testQuery = true;
                }

            }

            //converting distance string to double
            traversedDistance = Double.parseDouble(distance);

            // checks emission query for parse string
            String unit = splitingEmissionQuery(str, "--unit-of-distance");

            // checks emission query for parse string
            String output = splitingEmissionQuery(str, "--output");

            //calls co2 calculator function
            co2Calculator(method, traversedDistance, unit, output);

            ///to loop back to test query
            System.out.println("press 1 to try again or any other no to end");
            int end = scanner.nextInt();
            if (end != 1) {
                quit = true;
                System.out.println("Thank You! :)");
            } else {
                testQuery = false;
            }


        }


    }


    // method for parsing the query string and returning desired string data
    private static String splitingEmissionQuery(String requirement, String query) {
        ///parse the string
        String limit = "[= ]+";
        String[] tokens = requirement.split(limit);

        //return desired value matching to query
        for (int x = 0; x < tokens.length; x++) {

            if (tokens[x].equals(query)) {
                return tokens[x + 1];
            }

        }
        return null;
    }

    //Co2 emission callculator calling EmissionController class for matching query to emission list and calculating results
    private static void co2Calculator(String method, double distances, String unit, String output) {
        double kmValue = distances;

        //check if the given unit is null or given
        if (isNullOrEmpty(unit)) {

            System.out.println("Default or selected distance unit set to 'Km'");
        } else if (unit.equals("m")) {
            kmValue = kmValue / 1000;
            System.out.println("selected distance unit set to 'm' (meter)");
        }


        ///calculate the result
        double result = controller.calculateEmission(method, kmValue);


        //check if the given output is given or null
        if (isNullOrEmpty(output)) {

            System.out.println("Your trip caused " + result / 1000 + "kg of CO2-equivalent.");
        } else if (output.equals("kg")) {
            result = result / 1000;
            System.out.println("Selected output unit is 'kg'(gram)");
            System.out.print("Your trip caused ");
            System.out.format("%.1f", result);
            System.out.println("kg of CO2-equivalent.");
        } else {
            System.out.println("Your trip caused " + result + "g of CO2-equivalent.");
        }

    }

    //method for checking if retrieved string is empty or not
    private static boolean isNullOrEmpty(String str) {
        if (str != null && !str.trim().isEmpty())
            return false;
        return true;
    }


}
