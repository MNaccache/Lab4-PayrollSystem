package Lab4;

public class Date {

    private final int month;
    private final int day;
    private final int year;
    
    public Date (int month, int day, int year) {// constructor: confirm proper value for month and day given the year
        this.month = month;
        this.day = day;
        this.year = year;

        //boolean monthCheck = checkMonth();
        //boolean dayCheck = checkDay();
    }

    private boolean checkMonth () {// check if month in range
        int month = getMonth();
        if (month >= 1 || month <= 12) {
            return true;
        }

        return false;
    }

    private boolean checkDay () {// check if day in range for month
        int day = getDay();
        int month = getMonth();
        
        switch (month) {
            case 1: //Jan
            case 3: //March
            case 5: //May
            case 7: //July
            case 8: //Aug
            case 10: //Oct
            case 12: //Dec
                if (day >= 1 && day <= 31) {
                    return true;
                } else {
                    return false;
                }
            case 4: //April
            case 6: //June
            case 9: //Sept
            case 11: //Nov
                if (day >= 1 && day <= 30) {
                    return true;
                } else {
                    return false;
                }
            case 2: //Feb
                if (day == 29) {
                    return leapYear();
                }
                if (day >= 1 && day <= 28) {
                    return true;
                } else {
                    return false;
                }
        }
        return false;

    }

    private boolean leapYear () {// check for leap year if month is 2 and day is 29
        int year = getYear();
        if ((year % 4) == 0) { //normally, if a year divided by 4 is an int than it's a leap year
            if ((year % 100) == 0) { //BUT, if it can be divided by 100 into an int than it's NOT a leap year
                if ((year % 400) == 0) { //EXCEPT if it can be divided by 400 into an int
                    return true;
                } else {
                    return false;
                } //if 400 end
            } else {
                return true;
            } //if 100 end
        } else {
            return false;
        } //if 4 end
    }

    public int getDay () {// return day
        return day;
    }

    public int getMonth () {// return month
        return month;
    }

    public int getYear () {// return year
        return year;
    }
    
    public String toString () {// return a String of the form month/day/year
        return String.format("%s/%s/%s", getMonth(), getDay(), getYear());
    }
}
