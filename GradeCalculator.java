import java.util.Scanner;
/**
 * It's a grade calculator that takes in the number of weighted categories, the name of the weighted
 * categories, the weighted value of the categories, and the grade of the categories. It then
 * calculates the total grade and displays it
 *
 * @author Zhi Wang
 * @version 1.0
 */
public class GradeCalculator {
    //Declaring the variables that will be used in the program
    static Scanner promptInput = new Scanner(System.in);
    static String[] weightedCategories;
    static double[] weightedValues;
    static double[] grades;
    static double totalWeight = 0;
    static double totalGrade = 0;
    static int numOfWeightedCounter = 0;

    /**
     * Prompts the user to input the number of weighted categories, the name of each category, the
     * weighted value of each category, and the grade of each category
     */
    public static void UserPrompter(){
        System.out.print("Welcome to GradeCalculator!\n\nPlease input the number of weighted categories: ");
        weightedCategories = new String[promptInput.nextInt()];
        promptInput.nextLine();

        while(numOfWeightedCounter < weightedCategories.length){
            System.out.printf("Please input the name of weighted catergorie %d: ", (numOfWeightedCounter + 1));
            weightedCategories[numOfWeightedCounter] = promptInput.nextLine();
            numOfWeightedCounter++;
        }

        numOfWeightedCounter = 0;
        weightedValues = new double[weightedCategories.length];
        while(numOfWeightedCounter < weightedCategories.length){
            System.out.printf("Please input the weighted value of %s: ", weightedCategories[numOfWeightedCounter]);
            weightedValues[numOfWeightedCounter] = promptInput.nextDouble();
            numOfWeightedCounter++;
        }
        
        numOfWeightedCounter = 0;
        grades = new double[weightedCategories.length];
        while(numOfWeightedCounter < weightedCategories.length){
            System.out.printf("Please input the grade of %s: ", weightedCategories[numOfWeightedCounter]);
            grades[numOfWeightedCounter] = promptInput.nextDouble();
            numOfWeightedCounter++;
        }
    }
    /**
     * Converts weighted percentage to fractions
     */
    public static void weightedConvertor(){
        for(int i = 0; i < weightedValues.length; i++){
            weightedValues[i] = (weightedValues[i] / 100);
        }
    }

    /**
     * Takes the values from the weightedValues array and adds them to the totalWeight variable
     */
    public static void TotalWeight(){
        weightedConvertor();
        for(int i = 0; i < weightedCategories.length; i++){
            totalWeight += weightedValues[i];
        }
    }

    /**
     * Calculates the total grade by multiplying the grade in each category by the weight of that
     * category, then dividing the sum of those products by the total weight of all categories
     *
     * @return The total grade
     */
    public static double calculateTotalGrade(){
        TotalWeight();
        for(int i = 0; i < weightedCategories.length; i++){
            totalGrade += (grades[i] * weightedValues[i]);
        }
        totalGrade = totalGrade/(totalWeight);
        return totalGrade;
    }

    /**
     * Formats the string that display the total grade
     * 
     * @return The summary of total grade
     */
    public static String displayGrade(){
        calculateTotalGrade();
        String summary = String.format("Your total grade is %.2f%%", totalGrade);
        return summary;
    }

    /**
     * Executes the methods necessary to calculate total grade 
     */
    public static void main(String[] args){
        UserPrompter();
        System.out.print(displayGrade());
    }

}
