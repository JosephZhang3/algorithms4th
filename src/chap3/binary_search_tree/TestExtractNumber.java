package chap3.binary_search_tree;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestExtractNumber {

    private static String extractNumberFromString(String str) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(str);
        StringBuilder numInStr = new StringBuilder();
        while (m.find()) {
            numInStr.append(m.group());
        }
        return numInStr.toString();
    }

    public static void main(String[] args) {
        String result = extractNumberFromString("flds32l&*(435(45*3%4fflds");
        System.out.println("Result is " + result);
    }
}
