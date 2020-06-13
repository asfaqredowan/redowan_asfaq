package Day4_04192020;

public class split_command {
    public static void main(String[] args) {

        //create a string message first and store it as a single variable

        String message = "welcome to_Selenium automation class";

        //i want to only pro=int the keyword "Selenium" from my message variable
        //we need to define String array variable in order to split the message

        String[] arrayResult = message.split(" ");

        //print the result

        System.out.println("my final message is " + arrayResult[2]);

        //if there is _ between line

        String[] array2 = arrayResult[1].split("_");
        System.out.println("my new message is " + array2[1]);

        //if you want to print out to and class
        System.out.println("My keyword is " + arrayResult[0] + " my class keyword is " + arrayResult[3]);


    }//end of main method
}//end of java class
