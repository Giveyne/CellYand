package util;

import java.util.Arrays;

public class Utils {

    public static String arrayToString(int[][] arr) {
        final String lineSeparator = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        for (int[] anArr : arr) {
            sb.append(Arrays.toString(anArr)).append(lineSeparator);
        }
        return sb.toString();
    }
}
