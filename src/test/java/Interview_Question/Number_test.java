package Interview_Question;

import Reusable_Libraries.Abstract_Class;
import org.testng.annotations.Test;

public class Number_test extends Abstract_Class {

    @Test
    public void Number_counts() {

        for (int i = 0; i <= 100; i++) {
            if (i % 5 == 0) {
            }else {
                System.out.println(i);
            }
        }
    }
}
