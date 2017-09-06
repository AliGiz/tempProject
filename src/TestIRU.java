/**
 * Created by aligizakis on 7/7/2017.
 */
public class TestIRU {


    private static final int CARNET_LIMIT = 25000000;

    private static final int IRU_10LENGTH = 10;
    private static final int IRU_11LENGTH = 11;

    /**
     * Returns boolean if document reference value (DocRefDC23) follows the IRU
     * algorithm.
     *
     * @param docReference
     *            parameter
     * @return boolean
     */

    public  static boolean followsIRUAlgorithm(String docReference) {
        boolean ret = true;
        if (docReference == null) {
            return false;
        }
        int length = docReference.length();
        if (length != IRU_10LENGTH || length != IRU_10LENGTH) {
            return false;
        }
        String iru = docReference.substring(0, 2);
        String carnet = docReference.substring(2);
        int carnetNumber = -1;
        try {
            carnetNumber = Integer.parseInt(carnet);
        } catch (NumberFormatException e) {
            return false;
        }
        String calculatedIru = getIruCheckDigits(carnetNumber);
        if (!calculatedIru.equals(iru)) {
            ret = false;
        }
        return ret;
    }
    /**
     * Returns the IRU conformity control characters for a specific TIR .
     *
     * @param number
     *            the TIR number
     * @return a possibly empty <code>String</code> containing the IRU
     *         conformity control characters.
     */
    private static String getIruCheckDigits(int number) {
        String ret = "";
        if (number >= CARNET_LIMIT) {
            final int param1 = 23;
            final int param2 = 3;
            final int param3 = 17;
            final int param4 = 12;
            final int param5 = 26;
            int mod = number % param1;
            int letter = 'A' + (param2 * mod + param3) % param5;
            if (mod < param4) {
                ret = ((char) letter) + "X";
            } else {
                ret = "X" + ((char) letter);
            }
        }
        return ret;
    }

    public static void main(String... args) {
//
//        int arrS[] = new int[]{"ARMANI".hashCode(), "armani".hashCode()};
//
//        System.out.println(arrS[0]);
//        System.out.println(arrS[1]);

        int aLetter = 'A';
        System.out.println("M =" + aLetter);

       System.out.println("followsIRUAlgorithm : " + followsIRUAlgorithm("XNA250000"));
    }
}
