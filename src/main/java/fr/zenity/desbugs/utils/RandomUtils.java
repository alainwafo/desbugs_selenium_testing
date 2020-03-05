package fr.zenity.desbugs.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static Integer random(int min, int max){
        return ThreadLocalRandom.current().nextInt(max)+min;
    }

    public static String randomString(int min, int max){
        return random(min,max).toString();
    }

    public static String generateId(int len){
        StringBuffer bf = new StringBuffer();

        while(bf.toString().length()<len){
            bf.append(randomString(0,9));
        }

        return bf.toString();
    }

}
