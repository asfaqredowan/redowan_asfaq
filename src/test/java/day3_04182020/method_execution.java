package day3_04182020;

public class method_execution {
    public static void main(String[] args) {
        //call the method to be executed
        custom_methods.voidAdd(100, 200);
        //call the return add method
        int c = custom_methods.returnAdd( 200 , 300);
        //add the value with the result below
        System.out.println("new result is " + (c-25));

    }//end of main method
}//end of java class
