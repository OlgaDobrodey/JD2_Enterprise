package by.it_academy.jd2.core.utils;

public class CheckString {
    public static boolean isNullOrEmptyOrBlank(String string){
        return string == null || string.isEmpty() || string.isBlank();
    }
}
