import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Variables: Primitive Types, Reference Types

        // Primitive Types: byte, short, int, long, float, double, char, boolean
        int age = 100;
        byte count = 10;
        long youtubeViews = 7_123_456_789L;
        float price = 12.99F;
        char grade = 'A';
        boolean isEligible = true;

        System.out.println("You are " + age + " years old!");
        System.out.println("Counter count is " + count);
        System.out.println("You got " + youtubeViews);
        System.out.println("Price is " + price);
        System.out.println("You got " + grade);
        System.out.println("You are " + isEligible + " !!");


        String message = "Hello, World";
        System.out.println(message);


        // Reference Types: class, array ...
        Date today = new Date();
        System.out.println("Today is " + today);

        // Array
        int[] numbers = {8, 9, 4, 2, 5};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        // 2D Array/Matrix
        int[][] matrix = {{1, 2, 3}, {2, 4, 5}};
        System.out.println(Arrays.deepToString(matrix));

        // Constant
        final float PI = 3.1416F;
        System.out.println(PI);

        // Arithmetic: +, -, *, /, %

        // Casting
        // Implicit casting: byte > short > int > long > float > double
        short x = 1;
        int y = x + 2;
        System.out.println(y);

        // Explicit casting:
        double a = 1.1;
        int b = (int) a + 2;
        System.out.println(b);

        // Get input from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("You name " + name);

        // Mortgage Calculator

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner mortgageScanner = new Scanner(System.in);

        // System.out.print("Principal: ");
        int principle = mortgageScanner.nextInt();

        // System.out.print("Annual Interest Rate: ");
        float annualInterest = mortgageScanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        // System.out.print("Period (in Years): ");
        byte years = mortgageScanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principle
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + formattedMortgage);


        // Control Flow
        // Comparison operator: >, <, >=, <=, ==, !=
        int x2 = 10;
        int x3 = 12;
        System.out.println(x2 == x3);

        // Logical operator: &&, ||, !
        boolean hasHighIncome = true;
        boolean isAdult = false;
        boolean isLoanEligible = hasHighIncome && isAdult;
        boolean isNotLoanEligible = hasHighIncome || isAdult;

        // If statement
        int temperature = 45;
        if (temperature > 40) {
            System.out.println("Today is too hot!");
        } else {
            System.out.println("Enjoy the sun!");
        }

        // Ternary
        int income = 228_000;
        String airClass = income > 100_000 ? "First Class" : "Economy Class";
        System.out.println(airClass);

        // Switch Case
        String role = "admin";
        switch (role) {
            case "admin":
                System.out.println("You're admin!");
                break;
            case "moderator":
                System.out.println("Moderator!");
            default:
                System.out.println("Guest user");
        }

        // Fizz Buzz
        Scanner fizzBuzzScanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        int fizzBuzzNumber = fizzBuzzScanner.nextInt();

        if (fizzBuzzNumber % 5 == 0 && fizzBuzzNumber % 3 == 0) {
            System.out.println("FizzBuzz");
        } else if (fizzBuzzNumber % 5 == 0) {
            System.out.println("Fizz");
        } else if (fizzBuzzNumber % 3 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(fizzBuzzNumber);
        }


        // Loops

        // For loop
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        // While loop
        String userInput = "";
        Scanner userInputScanner = new Scanner(System.in);
        while (userInput.equals("quit")) {
            System.out.println("Input: ");
            userInput = userInputScanner.next().toLowerCase();
            System.out.println(userInput);
        }

        // Do while
        do {
            System.out.println("Input: ");
            userInput = userInputScanner.next().toLowerCase();
            System.out.println(userInput);
        } while (!userInput.equals("quit"));

        // break: terminate the loop
        // continue: moves control to the beginning of the loop
        while (true) {
            System.out.println("Input: ");
            userInput = userInputScanner.next().toLowerCase();
            if (userInput == "pass")
                continue;
            if (userInput.equals("quit"))
                break;
            System.out.println(userInput);
        }

        // For each loop
        String[] products = {"MacBook Pro", "iPhone 14", "Samsung Flip 4"};
        for (String product : products) {
            System.out.println(product);
        }
    }

}
