import java.util.Scanner;

/**
 * It's a grade calculator that takes in the number of weighted categories, the
 * name of the weighted
 * categories, the weighted value of the categories, and the grade of the
 * categories. It then
 * calculates the total grade and displays it
 *
 * @author Zhi Wang
 * @version 1.1 
 * 1.1 Patch Notes: Cleaned up the terminal, added letter grades, and enabled the user to keep calculating grade
 */

public class GradeCalculator {
    // Declaring the variables that will be used in the program
    private static Scanner promptInput = new Scanner(System.in);
    private static String[] weightedCategories; // String array that would hold all the names of the categories
    private static double[] weightedValues; // Double array that would hold all the weighted values of each categories
    private static double[] grades; // Double array that would hold all the grades of each catergories
    private static double totalWeight = 0; // Double variable to hold total weight
    private static double totalGrade = 0; // Double variable to hold total grade

    /**
     * Prompts the user to input the number of weighted categories, the name of each
     * category, the
     * weighted value of each category, and the grade of each category
     */
    public static void userPrompter() {
        System.out.print("\n\nPlease input the number of weighted categories: ");
        weightedCategories = new String[promptInput.nextInt()];
        weightedValues = new double[weightedCategories.length];
        grades = new double[weightedCategories.length];
        System.out.println("\n"); // Tidy up the terminal

        for (int i = 0; i < weightedCategories.length && weightedCategories.length != 0; i++) {
            System.out.printf("Please input the name of weighted catergorie %d: ", (i + 1));
            promptInput.nextLine(); // Gets rid of the \n from input
            weightedCategories[i] = promptInput.nextLine();
            System.out.printf("Please input the weighted value of %s: ", weightedCategories[i]);
            weightedValues[i] = promptInput.nextDouble();
            System.out.printf("Please input the grade of %s: ", weightedCategories[i]);
            grades[i] = promptInput.nextDouble();
            System.out.println(); // Tidy up the terminal
        }
    }

    /**
     * Converts weighted percentage to fractions
     */
    public static void weightedConvertor() {
        for (int i = 0; i < weightedValues.length; i++) {
            weightedValues[i] = (weightedValues[i] / 100);
        }
    }

    /**
     * Takes the values from the weightedValues array and adds them to the
     * totalWeight variable
     */
    public static void totalWeight() {
        weightedConvertor();
        for (int i = 0; i < weightedCategories.length; i++) {
            totalWeight += weightedValues[i];
        }
    }

    /**
     * Calculates the total grade by multiplying the grade in each category by the
     * weight of that
     * category, then dividing the sum of those products by the total weight of all
     * categories
     *
     * @return The total grade
     */
    public static double calculateTotalGrade() {
        totalWeight();
        for (int i = 0; i < weightedCategories.length; i++) {
            totalGrade += (grades[i] * weightedValues[i]);
        }
        totalGrade = totalGrade / (totalWeight);
        return totalGrade;
    }

    /**
     * Formats the string that display the total grade and letter grade
     *
     * @return The summary of the student's grade
     */
    public static String displayGrade() {
        calculateTotalGrade();
        String summary = String.format("Your total grade is %.2f%% which is %s", totalGrade, letterGrade());
        return summary;
    }

    /**
     * Using the total grade to see the letter grade (this method uses the + and - scale)
     *
     * @return The letter grade
     */
    public static String letterGrade() {
        if (totalGrade >= 97) {
            return "a A+";
        } else if (totalGrade < 97 && totalGrade > 92) {
            return "a A";
        } else if (totalGrade < 93 && totalGrade > 89) {
            return "a A-";
        } else if (totalGrade < 90 && totalGrade > 86) {
            return "a B+";
        } else if (totalGrade < 87 && totalGrade > 82) {
            return "a B";
        } else if (totalGrade < 83 && totalGrade > 79) {
            return "a B-";
        } else if (totalGrade < 80 && totalGrade > 78) {
            return "a C+";
        } else if (totalGrade < 77 && totalGrade > 72) {
            return "a C";
        } else if (totalGrade < 73 && totalGrade > 69) {
            return "a C-";
        } else if (totalGrade < 70 && totalGrade > 59) {
            return "a D";
        } else if (totalGrade < 60){
            return "a F";
        } else {
            return "unavailable";
        }
    }

    /**
     * Executes the methods necessary to calculate total grade
     */
    public static void main(String[] args) {
        String continueProgram;
        System.out.println("Welcome to GradeCalculator!"); // Welcome message
        do {
            userPrompter();
            System.out.println(displayGrade());
            System.out.print("\n\nWould you like to calculate grade for another class? Enter \"no\" if you would like to quit: ");
            promptInput.nextLine(); // Gets rid of the \n from input
            continueProgram = promptInput.nextLine();
            totalWeight = 0; // Resets total weight
            totalGrade = 0; // Resets total grade
        } while(!continueProgram.equalsIgnoreCase("no"));
        promptInput.close(); // Closes scanner
    }

}