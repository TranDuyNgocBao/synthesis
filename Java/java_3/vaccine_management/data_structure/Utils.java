/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structure;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ADMIN
 */
public class Utils {

    static Scanner sc = new Scanner(System.in);
    public static boolean duplicate;
    public static String fileInjection = "injection.txt";
    public static String encryptInjection = "injection_encrypt.txt";

    public static ArrayList<String> ijt_id = new ArrayList<>();
    public static ArrayList<String> st_id = new ArrayList<>();

    public static int getNumber(String str) {
        int result = 0;
        boolean check = true;
        do {
            try {
                System.out.print(str);
                result = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Re-enter a number");
            }
        } while (check);
        return result;
    }

    public static String getString(String str) {
        System.out.print(str);
        String result;
        try {
            result = sc.nextLine();
            if (result.isEmpty()) {
                throw new Exception();
            }
        } catch (Exception e) {
            return "Unwritten";
        }
        return result;
    }

    public static String getFirstString(String str) {
        String result;
        str += ' ';
        int i;
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                break;
            }
        }
        result = str.substring(0, i);
        return result;
    }

    private static boolean checkYearOdd(int yy) {
        if (yy % 4 != 0) {
            return false;
        }
        if (yy % 100 == 0) {
            if (yy % 400 == 0) {
                return true;
            } else {
                return false;
            }
        }
        if (yy % 4 == 0) {
            return true;
        }
        return false;
    }

    private static boolean checkDate(int dd, int mm, int yyyy) {
        if (yyyy < 2019) {
            return false;
        }
        if (yyyy < 0 || dd < 1 || mm < 1 || mm > 12) {
            return false;
        }
        switch (mm) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (dd > 31) {
                    return false;
                }
                break;
            case 2:
                if (!checkYearOdd(yyyy) && dd > 28) {
                    return false;
                }
                if (checkYearOdd(yyyy) && dd > 29) {
                    return false;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (dd > 30) {
                    return false;
                }
                break;
        }
        return true;
    }

    private static boolean dateFormat(String inputDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            formatter.parse(inputDate);
        } catch (ParseException e) {
            return false;
        }
        String tmp = "";
        int day = 0, month = 0, year, count = 0;
        for (int i = 0; i < inputDate.length(); i++) {
            if (inputDate.charAt(i) != '/') {
                tmp += inputDate.charAt(i);
            } else {
                if (count == 0) {
                    day = Integer.parseInt(tmp);
                } else {
                    month = Integer.parseInt(tmp);
                }
                count++;
                tmp = "";
            }
        }
        year = Integer.parseInt(tmp);
        if (!checkDate(day, month, year)) {
            return false;
        }
        return true;
    }

    public static int compareDate(String str1, String str2) {
        String tmp1 = "", tmp2 = "";
        int day1 = 0, month1 = 0, year1, count = 0;
        int day2 = 0, month2 = 0, year2;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != '/') {
                tmp1 += str1.charAt(i);
                tmp2 += str2.charAt(i);
            } else {
                if (count == 0) {
                    day1 = Integer.parseInt(tmp1);
                    day2 = Integer.parseInt(tmp2);
                } else {
                    month1 = Integer.parseInt(tmp1);
                    month2 = Integer.parseInt(tmp2);
                }
                count++;
                tmp1 = "";
                tmp2 = "";
            }
        }
        year1 = Integer.parseInt(tmp1);
        year2 = Integer.parseInt(tmp2);
        if (year1 < year2) {
            return -1;
        } else if (year1 > year2) {
            return 1;
        }
        if (month1 < month2) {
            return -1;
        } else if (month1 > month2) {
            return 1;
        }
        if (day1 < day2) {
            return -1;
        } else if (day1 > day2) {
            return 1;
        }
        return 0;
    }

    public static int countDays(String date1, String date2) throws ParseException {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
        date1 = date1.trim();
        date1 = date1.replaceAll("/", " ");
        date2 = date2.trim();
        date2 = date2.replaceAll("/", " ");

        Date firstDate = myFormat.parse(date1);
        Date secondDate = myFormat.parse(date2);
        long diff = secondDate.getTime() - firstDate.getTime();
        float days;
        days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        days = (diff / (24 * 60 * 60 * 1000));
        int result = (int) days;
        return result;
    }

    public static String getDate(String str) {
        String result = "";
        boolean check = true;
        do {
            System.out.print(str);
            try {
                result = sc.nextLine();
                if (result.isEmpty()) {
                    throw new Exception();
                }
            } catch (Exception e) {
                return "Unwritten";
            }
            if (dateFormat(result) == true) {
                check = false;
            } else {
                System.out.println("Wrong date and format try again (covid over 2019)");
            }
        } while (check);
        return result;
    }

    public static boolean repeatQuiz(String str) {
        //System.out.println("");
        System.out.println(str);
        int choice = 0;
        while (choice != 1 && choice != 2) {
            choice = getNumber("Choose(1 or 2): ");
        }
        if (choice == 1) {
            return true;
        }
        return false;
    }

    public static String updateStr(String str, String oldStr) {
        String result = oldStr;
        String tmp = Utils.getString(str);
        if (!tmp.equalsIgnoreCase("Unwritten")) {
            result = tmp;
        }
        return result;
    }

    public static void deleteFile(String url) throws IOException {
        File file = new File(url);
        OutputStream out = new FileOutputStream(file, false);
        try {
            // write to file
        } finally {
            out.close();
        }
        // now stream is definitely closed, so delete the file"
        if (!file.delete()) {
            System.out.println("Unable to delete file: " + file.getAbsolutePath());
        }
    }
    
    public static final Charset UTF_8 = StandardCharsets.UTF_8;
    public static final String OUTPUT_FORMAT = "%s";

    public static byte[] digest(byte[] input) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(input);
        return result;
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
