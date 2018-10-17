package com.neuedu.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GDate {
    public static Date get(String dateStr){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date d=sdf.parse(dateStr);
            return new Date(d.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
