import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LengthConverter implements UnitConverter {

    ArrayList<String> unitList = new ArrayList<>(Arrays.asList(
            "Kilometer (KM)",
            "Meter (M)",
            "Decimeter (DM)",
            "Centimeter (CM)",
            "Milimeter (MM)"));

    @Override
    public void run() {
        int fromUnit;
        int toUnit;
        double value;
        int change;
        Scanner unitChanger = new Scanner(System.in);

        System.out.println("- - Legth converter - -");
        System.out.println("Write a number bigger than 5 to end the program!");
        System.out.print("Write value: ");
        value = unitChanger.nextDouble();
        showOptions();

        do {

            System.out.println("Select from which unit do you want to convert: ");
            System.out.print("fromUnit = ");
            fromUnit = unitChanger.nextInt();

            System.out.println("Select to which unit do you want to convert: ");
            System.out.print("toUnit = ");
            toUnit = unitChanger.nextInt();

            System.out.println("----------------------RESULT----------------------");
            System.out.println(value + " " + unitList.get(fromUnit - 1) + " = " +
                    convertValue(value, unitList.get(fromUnit - 1), unitList.get(toUnit - 1)) + " " +
                    unitList.get(toUnit - 1));
            System.out.println("----------------------RESULT----------------------");

            System.out.println();
            System.out.print("Change value? (1/0): ");
            if (unitChanger.nextInt() == 1) {
                System.out.println("Write a brand new value: ");
                value = unitChanger.nextDouble();
            }

        }
        while (fromUnit <= 5 || toUnit <= 5);
    }

    @Override
    public double convertValue(double value, String fromUnit, String toUnit) {

        if (fromUnit.equals(toUnit)) {
            return value;
        }

        switch (fromUnit) {
            case "Kilometer (KM)":
                switch (toUnit) {
                    case "Meter (M)":
                        value = value * 1000;
                        break;
                    case "Decimeter (DM)":
                        value = value * 10000;
                        break;
                    case "Centimeter (CM)":
                        value = value * 100000;
                        break;
                    case "Milimeter (MM)":
                        value = value * 1000000;
                        break;
                }
                break;
            case "Meter (M)":
                switch (toUnit) {
                    case "Kilometer (KM)":
                        value = value / 1000;
                        break;
                    case "Decimeter (DM)":
                        value = value * 10;
                        break;
                    case "Centimeter (CM)":
                        value = value * 100;
                        break;
                    case "Milimeter (MM)":
                        value = value * 1000;
                        break;
                }
                break;
            case "Decimeter (DM)":
                switch (toUnit) {
                    case "Kilometer (KM)":
                        value = value / 10000;
                        break;
                    case "Meter (M)":
                        value = value / 10;
                        break;
                    case "Centimeter (CM)":
                        value = value * 10;
                        break;
                    case "Milimeter (MM)":
                        value = value * 100;
                        break;
                }
                break;
            case "Centimeter (CM)":
                switch (toUnit) {
                    case "Kilometer (KM)":
                        value = value / 100000;
                        break;
                    case "Meter (M)":
                        value = value / 100;
                        break;
                    case "Decimeter (DM)":
                        value = value / 10;
                        break;
                    case "Milimeter (MM)":
                        value = value * 10;
                        break;
                }
                break;
            case "Milimeter (MM)":
                switch (toUnit) {
                    case "Kilometer (KM)":
                        value = value / 1000000;
                        break;
                    case "Meter (M)":
                        value = value / 1000;
                        break;
                    case "Decimeter (DM)":
                        value = value / 100;
                        break;
                    case "Centimeter (CM)":
                        value = value / 10;
                        break;
                }
                break;
            default:
                return value;
        }
        return value;
    }

    public void showOptions() {
        for (int i = 0; i < unitList.size(); i++) {
            System.out.println((i + 1) + ". " + unitList.get(i));
        }
    }
}
