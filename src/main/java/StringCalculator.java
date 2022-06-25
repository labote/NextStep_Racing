import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int splitAndSum(String str) {

        //splitAndSum_null_또는_빈문자
        if (isBlank(str)) {
            return 0;
        }

        //splitAndSum_쉼표구분자, splitAndSum_쉼표_또는_콜론_구분자, splitAndSum_custom_구분자, splitAndSum_negative
        return add(StrToInt(split(str)));
    }

    private static boolean isBlank(String str){
        return str == null || str.trim().isEmpty();
    }

    public static String[] split(String str){
        // java.util.regex 패키지의 Matcher, Pattern import
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return str.split(",|:");
    }

    private static int add(int[] tokens) {
        int sum = 0;
        for (int i = 0; i < tokens.length; i++) {
            Error(negative(tokens[i]));
            sum += (tokens[i]);
        }

        return sum;
    }

    private static int[] StrToInt(String[] str){
        int length = str.length;
        int[] temp = new int[length];

        for(int i=0; i<length; i++){
            temp[i] = Integer.parseInt(str[i]);
        }

        return temp;
    }

    private static boolean negative(int number){
        if(number < 0){
            return false;
        }
        return true;
    }

    private static void Error(boolean bool){
        if(!bool){
            throw new RuntimeException();
        }
    }
}
