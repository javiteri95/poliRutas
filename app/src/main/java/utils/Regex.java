package utils;

import java.util.regex.Pattern;

/**
 * Created by joset on 21/11/2016.
 */

public class Regex {


    public static boolean testPassword(String pass){
        return  Pattern.matches("(?=.*[a-z])(?=.*[0-9]).{6,}",pass);
    }

    public static boolean testUser(String us){
        return Pattern.matches("[a-z]{1,12}@espol.edu.ec", us);
    }

}
