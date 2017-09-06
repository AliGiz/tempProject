import java.io.IOException;
import java.util.*;

public class Solution {
 /*
 * Complete the function below.
 */

    static String reproduceString(String input) {

        String remSpaces = input.replaceAll("\\s+","");
        remSpaces = remSpaces.replaceAll("A","");
        remSpaces = remSpaces.replaceAll("a","");
        remSpaces = remSpaces.replaceAll("E","");
        remSpaces = remSpaces.replaceAll("e","");
        remSpaces = remSpaces.replaceAll("I","");
        remSpaces = remSpaces.replaceAll("i","");
        remSpaces = remSpaces.replaceAll("O","");
        remSpaces = remSpaces.replaceAll("o","");
        remSpaces = remSpaces.replaceAll("U","");
        remSpaces = remSpaces.replaceAll("u","");



        return remSpaces;
    }


    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        //final String fileName = System.getenv("OUTPUT_PATH");
       // BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String  res;
        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        res = reproduceString(_input);

        System.out.println(res);

    }

}



