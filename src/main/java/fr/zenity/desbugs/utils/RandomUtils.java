package fr.zenity.desbugs.utils;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RandomUtils {

    // see https://www.baeldung.com/java-random-string to improve this code

    public static Integer randomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(max)+min;
    }

    public static String randomString(int charNumber){
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(charNumber)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String generateId(int len){
        StringBuffer bf = new StringBuffer();

        while(bf.toString().length()<len){
            bf.append(randomString(9));
        }

        return bf.toString();
    }

    public static String createParameter(String randomParameter){

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
            return randomString(Integer.valueOf(m.group(1)));
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
