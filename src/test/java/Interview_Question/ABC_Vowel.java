package Interview_Question;

import Reusable_Libraries.Abstract_Class;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ABC_Vowel extends Abstract_Class {

    @Test
    public void ABC_Vowel() {
        String[] List = new String[5];
        List[0] = "a";
        List[1] = "b";
        List[2] = "c";
        List[3] = "d";
        List[4] = "e";
        for (int i = 0; i < List.length; i++) {
            if (List[i].equals("a")||List[i].equals("e")){
                System.out.println(" Vowel");
            }else {
                System.out.println(" Non-Vowel");
            }//end of if else
        }//end of for loop

    }
}
