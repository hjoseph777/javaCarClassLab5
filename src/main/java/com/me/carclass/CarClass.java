package com.me.carclass;
import java.util.Scanner;

public class CarClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        // Create car instances
        Car myCar = new Car("Honda", "Civic", "red");
        Car davidsCar = new Car("Benz", "GLA", "black");
      
        // Get year and acceleration for myCar
        System.out.print("Enter the year for myCar: ");
        int yearForMyCar = scanner.nextInt();
        System.out.print("Enter the acceleration/brake force for myCar: ");
        int speedChangeMyCar = scanner.nextInt();
        
        System.out.println("\n--- My Car Details ---");
        displayCarInfo(yearForMyCar, speedChangeMyCar, myCar);
        
        // Get year and acceleration for davidsCar
        System.out.print("\nEnter the year for davidsCar: ");
        int yearForDavidsCar = scanner.nextInt();
        System.out.print("Enter the acceleration/brake force for davidsCar: ");
        int speedChangeDavidsCar = scanner.nextInt();
        
        System.out.println("\n--- David's Car Details ---");
        displayCarInfo(yearForDavidsCar, speedChangeDavidsCar, davidsCar);

        scanner.close();
    }

    private static void displayCarInfo(int year, int speedChange, Car car) {
        car.displayCarInfo(); 
        
        System.out.printf("Year: %d%n", year);
        System.out.println("Color: " + car.getColor());
        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Status: " + car.getStatus());
        System.out.println("Initial Speed: " + car.getSpeed());

        car.start();
        System.out.printf("Status after starting: %s%n", car.getStatus());
        System.out.printf("Speed after starting: %d%n", car.getSpeed());

        System.out.printf("\nApplying acceleration force of: %d%n", speedChange);
        car.accelerate(speedChange);
        System.out.printf("Speed after acceleration: %d%n", car.getSpeed());



        System.out.printf("\nApplying brake force of: %d%n", speedChange);
        // Validate brake force before applying
        int validBrakeForce = SpeedValidator.validateBrakeForce(car.getSpeed(), speedChange);
        car.brake(validBrakeForce);
        System.out.printf("Speed after braking: %d%n", car.getSpeed());



        car.stop();
        System.out.printf("\nStatus after stopping: %s%n", car.getStatus());
        System.out.printf("Final speed: %d%n", car.getSpeed());

        car.honk();
    }
}


class SpeedValidator {
    
    public static int validateBrakeForce(int currentSpeed, int brakeForce) {
        if (currentSpeed - brakeForce < 0) {
            System.out.println("Warning: Brake force would reduce speed below 0.");
            System.out.println("Adjusting brake force to reach 0.");
            return currentSpeed;
        }
        return brakeForce;
    }
}