package com.flatironschool.exceptionalexceptions;


import android.util.Log;

import java.util.Calendar;

/**
 * Created by altyus on 7/21/14.
 */
public class BirthCertificate {
    private final  static String TAG = "BirthCertificate";
    private String mFirstName, mLastName, mBirthString;
    private Double mWeightOunces;

    public BirthCertificate(String firstName, String lastName, String birthString, Double weightOunces) {
        try {
            validateProperString(firstName);
            mFirstName = firstName;
        } catch (Exception e){
            Log.d(TAG, "Exception, First Name:", e);
            mFirstName = "John";
        } try{
            validateProperString(lastName);
            mLastName = lastName;

        } catch (Exception e) {
            Log.d(TAG, "Exception, Last Name:", e);
            mLastName = "Smith";
        } try {
            validateBirthDateString(birthString);
            mBirthString = birthString;
        } catch (Exception e){
            Log.d(TAG, "Exception, birthString", e);
            mBirthString = "07041987";
        } try {
            validateBirthWeight(weightOunces);
            mWeightOunces = weightOunces;
        } catch (Exception e){
            Log.d(TAG, "Exception, birthWeight", e);
            mWeightOunces = 128.0;
        }
        finally {
//            mFirstName = firstName;
//            mLastName = lastName;
//            mBirthString = birthString;
//            mWeightOunces = weightOunces;
        }

    }

    public static Boolean validateProperString(String properString) throws Exception {
        for (Integer x = 0; x < properString.length(); x++) {
            if (Character.isDigit(properString.charAt(x))){
                throw new Exception("Cannot contain digits");
            }
            if (x == 0) {
                if (!Character.isUpperCase(properString.charAt(0))) {
                    throw new Exception("First character must be uppercase");
                }
            }else {
                if (Character.isUpperCase(properString.charAt(x))){
                    throw new Exception("Only the first character can be uppercase");
                }
            }
        }

        return true;
    }

    public static Boolean validateBirthDateString(String birthString) throws Exception {
        if (birthString.length() != 8){
            throw new Exception("birthString must be 8 characters");
        }
        for (Integer x = 0; x < birthString.length(); x++){
            if (!Character.isDigit(birthString.charAt(x))){
                throw new Exception("birthString can only contain digits");
            }
        }

        Integer month = Integer.parseInt(birthString.substring(0, 2));
        Integer day = Integer.parseInt(birthString.substring(2, 4));
        Integer year = Integer.parseInt(birthString.substring(4, 8));

        Calendar calendar = Calendar.getInstance();

        if (month < 1 || month > 12){
            throw new Exception("birth month is out of range");
        }
        if (day < 1 || day > 31){
            throw new Exception("birth day is out of range");
        }
        if (year < 1900 || year > calendar.get(Calendar.YEAR)){
            throw new Exception("birth year is out of range");
        }

        return true;
    }

    public static Boolean validateBirthWeight(Double birthWeight) throws Exception {
        if (birthWeight > 288) {
            throw new Exception("Birth weight is above all known birth weights in the history of humanity");
        }
        else if (birthWeight < 48) {
            throw new Exception("Birth weight is below all known birth weights in the history of humanity");
        }
        return true;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getBirthString() {
        return mBirthString;
    }

    public void setBirthString(String birthString) {
        mBirthString = birthString;
    }

    public Double getWeightOunces() {
        return mWeightOunces;
    }

    public void setWeightOunces(Double weightOunces) {
        mWeightOunces = weightOunces;
    }
}
