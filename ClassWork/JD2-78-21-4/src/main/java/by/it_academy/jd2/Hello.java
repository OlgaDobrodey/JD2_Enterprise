package by.it_academy.jd2;


import by.it_academy.jd2.utils.ApacheCommonsLang3;
/**
 * Home work №1
 * Mk-JD2-78-21-4
 * @author Olga Dobrodey
 */
public class Hello {
    /**
     * method main is program entry point;
     * @param args - String [] array
     * Uses link {@link ApacheCommonsLang3#isAllLowerCase(CharSequence)}
     */
    public static void main(String[] args) {
        for (String arg : args) {
            if (ApacheCommonsLang3.isAllLowerCase(arg)) {
                System.out.println(arg);
            }
        }
    }
}

