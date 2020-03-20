package fr.zenity.desbugs.utils;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RandomUtils {

    // see https://www.baeldung.com/java-random-string to improve this code

    public static Integer randomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(max)+min;
    }

    public static String randomString(int charNumber, boolean withSpecificCharacter){
        int leftLimit = 32; // asci space
        int rightLimit = 126; // asci character '~'
        Random random = new Random();

        //filter the asci specific characters, leave only the lower and upper case letters and numbers
        IntPredicate func = withSpecificCharacter
                ? (int i) -> true
                : (int i) -> (i >= 48 && i <= 57) || (i >= 65 && i <= 90) || (i >= 97 && i <= 122);

        return random.ints(leftLimit, rightLimit + 1)
                .filter(func)
                .limit(charNumber)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String generateId(int len){
        StringBuffer bf = new StringBuffer();

        while(bf.toString().length()<len){
            bf.append(randomString(9, false));
        }

        return bf.toString();
    }

    public static String createParameter(String randomParameter, boolean withSpecificCaracter){

        if (randomParameter.equals("none") || randomParameter.equals("null")){
            return null;
        }

        String patternString = "String<(\\d*)>";
        String patternInt = "Int<(\\d*),(\\d*)>";

        // Create a Pattern object for string
        Pattern pattern = Pattern.compile(patternString);

        // Now create matcher object for string
        Matcher m = pattern.matcher(randomParameter);

        if (m.find())
        {
            return randomString(Integer.valueOf(m.group(1)), withSpecificCaracter);
        }

        // Create a Pattern object for int
        pattern = Pattern.compile(patternInt);

        // Now create matcher object for int
        m = pattern.matcher(randomParameter);

        if (m.find())
        {
            return randomInt(Integer.valueOf(m.group(0)), Integer.valueOf(m.group(1))).toString();
        }

        return randomParameter;
    }

}
