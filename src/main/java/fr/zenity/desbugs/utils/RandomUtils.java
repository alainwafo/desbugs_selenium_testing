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
        byte[] array = new byte[charNumber]; // length is bounded by charNumber
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }

    public static String generateId(int len){
        StringBuffer bf = new StringBuffer();

        while(bf.toString().length()<len){
            bf.append(randomString(9));
        }

        return bf.toString();
    }

    public static String createParameter(String randomParameter){
        String patternString = "String<(\\d*)>";
        String patternInt = "Int<(\\d*),(\\d*)>";

        // Create a Pattern object for string
        Pattern pattern = Pattern.compile(patternString);

        // Now create matcher object for string
        Matcher m = pattern.matcher(randomParameter);

        if (m.find())
        {
            return randomString(Integer.valueOf(m.group(0)));
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
