package day3_04182020;

public class if_else_with_operators {

    public static void main(String[] args) {
        //scenario if students grade is 90 to 100 than it's A
        //if students grade is 80 to below 90 than it's B
        //if students grade is 70 to below 80 than it's C
        //if anything else below C is failure (F)

        //define variable which will represent grade number
        int grade = 75;
        //&& represents adr operator in java
        //&& and operator all condition has to be true
        //or operator of the condition has to be true
        if (grade >= 90 && grade <= 100) {
            System.out.println("students grade is A");
        } else if (grade >= 80 && grade < 90) {
            System.out.println("students grade is B");
        } else if (grade >= 70 && grade < 80) {
            System.out.println("students grade is C");
        } else {
            System.out.println("students grade is F");
        }//end of conditional statement


    }//end of main method
}//end of java class
