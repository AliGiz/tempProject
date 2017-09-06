/**
 * Created by aligizakis on 11/7/2017.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TIRCarnetUtils {

    private static final long LAST_TIR_CARNET_NUMBER_WITHOUT_CONTROL_CHARS = 25000000L;
    private static final Pattern TIR_CARNET_NUMBER_PATTERN = Pattern.compile("^([A-Z]{2})?(\\d+)$");

    public final static String getCheckedTIRCarnetNumber(long tirCarnetNumber) {
        if (tirCarnetNumber <= LAST_TIR_CARNET_NUMBER_WITHOUT_CONTROL_CHARS)
            return Long.toString(tirCarnetNumber);

        long carnetModulo23 = tirCarnetNumber % 23;
        int checkCharacter = ((int) 'A') + new Long((3 * carnetModulo23 + 17) % 26).intValue();

        if (carnetModulo23 < 12) {
            return String.copyValueOf(Character.toChars(checkCharacter)) + "X" + Long.toString(tirCarnetNumber);
        }
        return "X" + String.copyValueOf(Character.toChars(checkCharacter)) + Long.toString(tirCarnetNumber);
    }

    public final static Long getNumericTIRCarnetNumber(String checkedTirCarnetNumber) throws NumberFormatException {
        if (checkedTirCarnetNumber == null || "".equals(checkedTirCarnetNumber)) {
            return null;
        }
        String tirCarnetNumber = checkedTirCarnetNumber.toUpperCase(Locale.ENGLISH).replaceAll("/\\s/g", "");
        Matcher m = TIR_CARNET_NUMBER_PATTERN.matcher(tirCarnetNumber);
        if (m.matches()) {
            String cd = m.group(1);
            long num = Long.parseLong(m.group(2));
            if (num > 25000000L) {
                String checkedTirNumber = getCheckedTIRCarnetNumber(num);
                if (cd != null && cd.equals(checkedTirNumber.substring(0, 2)))
                    return num;
            } else {
                if (cd == null)
                    return num;
            }
        }
        throw new NumberFormatException("Wrong Checked TIR Carnet Number: " + checkedTirCarnetNumber);
    }

    public final static List <Integer> getNumericTIRCarnetNumber(List <String> checkedTirCarnetNumbers) {
        List <Integer> result = new ArrayList <Integer>(checkedTirCarnetNumbers.size());
        for (String cn : checkedTirCarnetNumbers) {
            result.add(getNumericTIRCarnetNumber(cn).intValue());
        }
        return result;
    }


    public static void main(String... args) {
//
//        int arrS[] = new int[]{"ARMANI".hashCode(), "armani".hashCode()};
//
//        System.out.println(arrS[0]);
//        System.out.println(arrS[1]);

        int aLetter = 'A';
        System.out.println("M =" + aLetter);

        System.out.println("followsIRUAlgorithm : " + getNumericTIRCarnetNumber("DX2500000000"));
    }
}