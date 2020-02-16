package com.jetbrains;

import java.text.*;
import java.util.Date;

public class GetTime {

    private static final DateFormat sdf = new SimpleDateFormat("MM");

    int daysInMonth() {
        int month = getMonth();

        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        }
        else if(month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        else {
            return 28;
        }
    }

    int apple() {
        return 5;
    }

    int getMonth() {
        Date date = new Date();

        return Integer.valueOf(sdf.format(date));
    }

}
