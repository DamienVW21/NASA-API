package org.example;

import org.example.model.Neo;
import org.example.model.NeoFeedResponse;
import org.example.service.NASAService;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Welcome to my Near Earth Object Tracker!");
        System.out.println("Enter start date (YYYY-MM-DD): ");
        String sDate = userInput.nextLine();

        // might have to turn into local date object, to pass to API?
        NASAService service = new NASAService();
        NeoFeedResponse response = service.getAllNeos(sDate, sDate);

        // for each loop to loop through the keys(dates)

        for ( String key: response.getNearEarthObjects().keySet()){
            // grab list (values) based on the key (date)
            List<Neo> neoList = response.getNearEarthObjects().get(key);
            int count = neoList.size();
            System.out.println("For date: " + key + " there are " + count + " near earth objects");

            String code = "\\x1b[0m";
            for (Neo n: neoList){
                if(n.isIspotentiallyHazardousAsteroid()){
                    code = "\u001B[31m";
                }
                else{
                    code = "\u001B[0m";
                }
                System.out.println(code + "Id: " + n.getId());
                System.out.println("name: " + n.getName());
                System.out.println("Potentially Hazardous? " + n.isIspotentiallyHazardousAsteroid());
                System.out.println("Estimated Diameter : ");
                System.out.println("\tMin in Miles: " +
                        n.getEstimatedDiameter().getMiles().getEstimatedDiameterMin());
                System.out.println("\tMax in Miles: " +
                        n.getEstimatedDiameter().getMiles().getEstimatedDiameterMax());
                System.out.println("\tMin in Feet: " +
                        n.getEstimatedDiameter().getFeet().getEstimatedDiameterMin());
                System.out.println("\tMax in Feet: " +
                        n.getEstimatedDiameter().getFeet().getEstimatedDiameterMax());
                System.out.println("\n***********************");

            }
        }

    }
}