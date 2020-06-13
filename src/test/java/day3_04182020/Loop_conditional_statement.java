package day3_04182020;

public class Loop_conditional_statement {
    //only print out city when its brooklyn or queens


    public static void main(String[] args) {
        String[] city = new String[4];
        city[0] = "brooklyn";
        city[1] = "manhattan";
        city[2] = "queens";
        city[3] = "bronx";


        for (int i = 0; i < city.length; i++){
            //using if else if condition
            //string can have equal() command or == but integer must have ==
            //equal command when the expected value is matching the array value
            //equalIgnoreCase command will ignore case sensitivity as long as the array value
            //spelling is correct


            /*if (city[i] == "brooklyn"){
                System.out.println("my city is + city[i]");
            }else if(city[i] == "queens"){
                System.out.println("my city is" + city[i]);
            }//end of if else condition
            */

            //using or || operators to meet the same conditions as above
            if(city[i].equals("brooklyn") || city[i] == "queens"){
                System.out.println("my city is " + city[i]);
            }//end of operator condition

        }//end of for loop




    }//end of main method
}//end of java class
