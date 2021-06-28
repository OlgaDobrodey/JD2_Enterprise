package by.it_academy.jd2;

import by.it_academy.jd2.core.utils.Constants;



import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class EXE {
    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat(Constants.FORMAT_DATE);
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.FORMAT_DATE);
        String date = dateTime.format(formatter);
        System.out.println( dateTime);
        System.out.println( formatter);
        System.out.println( date);
        try {
            final Timestamp timestamp = new Timestamp(DATE_TIME_FORMAT.parse(date).getTime());
            System.out.println(timestamp);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);}



    }}
