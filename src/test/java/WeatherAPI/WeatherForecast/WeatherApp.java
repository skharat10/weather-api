package WeatherAPI.WeatherForecast;

import java.util.Scanner;

public class WeatherApp {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Get weather");
            System.out.println("2. Get Wind Speed");
            System.out.println("3. Get Pressure");
            System.out.println("0. Exit");
            System.out.print("Enter your option: ");
            int option = scanner.nextInt();

            if (option == 0) {
                System.out.println("Exiting the program...");
                break;
            }

            System.out.print("Enter the date (yyyy-MM-dd): ");
            String date = scanner.next();

            switch (option) {
                case 1:
                    float temperature = weatherService.getWeatherForDate(date);
                    System.out.println("Temperature on " + date + ": " + temperature);
                    break;
                case 2:
                    float windSpeed = weatherService.getWindSpeedForDate(date);
                    System.out.println("Wind Speed on " + date + ": " + windSpeed);
                    break;
                case 3:
                    float pressure = weatherService.getPressureForDate(date);
                    System.out.println("Pressure on " + date + ": " + pressure);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}


