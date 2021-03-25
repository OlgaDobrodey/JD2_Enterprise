package by.it_academy.jd2.utils;

import org.apache.commons.lang3.StringUtils;
/**
 * Home work №1
 * Mk-JD2-78-21-4
 * @author Olga Dobrodey
 */
public class ApacheCommonsLang3 {
    /**
     * Method сhecks if the CharSequence contains only lowercase characters.
     * @param cs - CharSequence contains ;
     * @return boolean
     */

    public static boolean isAllLowerCase(CharSequence cs){
        return StringUtils.isAllLowerCase(cs);
    }
}