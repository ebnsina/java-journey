import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        int principle = (int) readNumber("Principle: ", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest: ", 1, 30);
        byte years = (byte) readNumber("Period (Years): ", 1, 30);

        printMortgage(principle, annualInterest, years);
        printPaymentSchedule(principle, annualInterest, years);
    }

    private static void printMortgage(int principle, float annualInterest, byte years) {
        double mortgage = calculateMortgage(principle, annualInterest, years);
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("---------");
        System.out.println("Monthly Payments: " + formattedMortgage);
    }

    private static void printPaymentSchedule(int principle, float annualInterest, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-----------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principle, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;

        while (true) {
            System.out.println(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a valid value between " + min + " & " + max);
        }

        return value;
    }

    public static double calculateBalance(
            int principle,
            float annualInterest,
            byte years,
            short numberOfPaymentsMade) {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);

        return principle * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }


    public static double calculateMortgage(
            int principle,
            float annualInterest,
            byte years) {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);

        return principle
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }
}
