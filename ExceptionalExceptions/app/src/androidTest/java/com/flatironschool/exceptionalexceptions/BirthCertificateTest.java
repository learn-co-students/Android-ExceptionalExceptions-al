package com.flatironschool.exceptionalexceptions;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class BirthCertificateTest extends ApplicationTestCase<Application> {
    public BirthCertificateTest() {
        super(Application.class);
    }

    @Override
    protected void setUp(){

    }

    public void testValidateProperString(){
        Exception firstCharException = null;
        Exception otherCharException = null;
        Exception digitException = null;
        Exception validException = null;

        try {
            BirthCertificate.validateProperString("james");
        }catch (Exception e){
            firstCharException = e;
        }
        assertTrue(firstCharException instanceof Exception);
        assertTrue(firstCharException.getMessage() == "First character must be uppercase");

        try {
            BirthCertificate.validateProperString("JAMES");
        } catch (Exception e){
            otherCharException = e;
        }
        assertTrue(otherCharException instanceof Exception);
        assertTrue(otherCharException.getMessage() == "Only the first character can be uppercase");

        try {
            BirthCertificate.validateProperString("7ames");
        } catch (Exception e){
            digitException = e;
        }
        assertTrue(digitException instanceof Exception);
        assertTrue(digitException.getMessage() == "Cannot contain digits");

        try {
            BirthCertificate.validateProperString("James");
        }catch (Exception e){
            validException = e;
        }
        assertNull(validException);
    }

    public void testValidateBirthString() {
        Exception lengthException = null;
        Exception nonDigitException = null;
        Exception monthRangeException = null;
        Exception dayRangeException = null;
        Exception yearRangeException = null;
        Exception validDateException = null;

        try{
            BirthCertificate.validateBirthDateString("091219876");
        } catch(Exception e){
            lengthException = e;
        }
        assertTrue(lengthException instanceof Exception);
        assertTrue(lengthException.getMessage() == "birthString must be 8 characters");

        try{
            BirthCertificate.validateBirthDateString("d0123456");
        } catch (Exception e) {
            nonDigitException = e;
        }
        assertTrue(nonDigitException instanceof Exception);
        assertTrue(nonDigitException.getMessage() == "birthString can only contain digits");

        try{
            BirthCertificate.validateBirthDateString("13121984");
        } catch(Exception e){
            monthRangeException = e;
        }
        assertTrue(monthRangeException instanceof Exception);
        assertTrue(monthRangeException.getMessage() == "birth month is out of range");

        try {
            BirthCertificate.validateBirthDateString("12321986");
        } catch (Exception e){
            dayRangeException = e;
        }
        assertTrue(dayRangeException instanceof Exception);
        assertTrue(dayRangeException.getMessage() == "birth day is out of range");

        try {
            BirthCertificate.validateBirthDateString("01312015"); //this test must be updated in 2015
        } catch (Exception e) {
            yearRangeException = e;
        }
        assertTrue(yearRangeException instanceof Exception);
        assertTrue(yearRangeException.getMessage() == "birth year is out of range");

        try {
            BirthCertificate.validateBirthDateString("02121987");
        } catch (Exception e){
            assertNull(validDateException);
        }
    }

    public void testValidateBirthWeight(){
        Exception overweightException = null;
        Exception underweightException = null;
        Exception validWeightException = null;

        try {
            BirthCertificate.validateBirthWeight(289.0);
        } catch (Exception e) {
            overweightException = e;
        }
        assertTrue(overweightException instanceof Exception);
        assertTrue(overweightException.getMessage() == "Birth weight is above all known birth weights in the history of humanity");

        try {
            BirthCertificate.validateBirthWeight(47.0);
        } catch (Exception e){
            underweightException = e;
        }
        assertTrue(underweightException instanceof Exception);
        assertTrue(underweightException.getMessage() == "Birth weight is below all known birth weights in the history of humanity");

        try {
            BirthCertificate.validateBirthWeight(100.0);
        } catch (Exception e) {
            assertNull(validWeightException);
        }
    }

    public void testInitializerSetsDefaultValues() {

        //BirthCertificate alCert = new BirthCertificate("al", "tyus", "070419878", 30.0);
        //Exception invalidFirstNameException = null;

        BirthCertificate alCert = new BirthCertificate("al", "tyus", "070419878", 30.0);
        BirthCertificate validCert = new BirthCertificate("James", "Thomas", "07042008", 60.0);

        assertTrue(alCert.getFirstName() == "John");
        assertTrue(alCert.getLastName() == "Smith");
        assertTrue(alCert.getBirthString() == "07041987");
        assertTrue(alCert.getWeightOunces() == 128.0);

        assertTrue(validCert.getFirstName() == "James");
        assertTrue(validCert.getLastName() == "Thomas");
        assertTrue(validCert.getBirthString() == "07042008");
        assertTrue(validCert.getWeightOunces() == 60.0);

    }


    @Override
    protected void tearDown(){

    }
}