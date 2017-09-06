import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionTest1 {
 /*
 * Complete the function below.
 */

    static int substrings(String input) {

        int ret=0;
        String remSpaces = input.replaceAll("\\s+","");

        ArrayList<String> stringsArray= new ArrayList <>();
        for (int i=0; i<remSpaces.length()-3;i++) {
            String tempString = remSpaces.substring(i,i+4).toLowerCase();
            stringsArray.add(tempString);
        }

        Set<String> setToCompare = new HashSet <>();
        ArrayList<String> listToCompare= new ArrayList <>();
        setToCompare.addAll(stringsArray);
        listToCompare.addAll(setToCompare);

        for(int i=0;i<listToCompare.size();i++) {
            String toCompare = listToCompare.get(i);
            int freq = Collections.frequency(stringsArray,toCompare);
            if(freq==2){
                ret++;
            }

        }

        return ret;
    }


    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        //final String fileName = System.getenv("OUTPUT_PATH");
       // BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        res = substrings(_input);

        System.out.println(res);

    }

}



