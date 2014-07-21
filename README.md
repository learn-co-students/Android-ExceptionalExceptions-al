---
tags: OOP, properties, methods, exceptions, error handling
language: java
---

Android-ExceptionalExceptions
=============================

## Learning Goals
  1. Learn how to handle Exceptions with Try, Catch, Finally
  2. Create another Object Oriented Model 
  3. Set Default member variable values when exceptions are handled

## Requirements
  1. Create a new class `BirthCertificate.java`
  2. In it's constructor, BirthCertificate should validate each variable using standard Exception objects.  
  3. If a field is invalid that field should be set to a default value defined in the test suite.  

  The required methods are as follows: 

  ```Java
  
  public BirthCertificate(String firstName, String lastName, String birthString, Double weightOunces)

  public static Boolean validateProperString(String properString) throws Exception // see test spec 

  public static Boolean validateBirthDateString(String birthString) throws Exception // see test spec

  public static Boolean validateBirthWeight(Double birthWeight) throws Exception // see test spec

   public String getFirstName() // getter for first name 

   public String getLastName() // getter for last name 

   public String getBirthString() // getter for string defining birth date as a string ex. July 4th 1987 would be "07041987"

   public Double getWeightOunces() // getter for weight in ounces 

  ```

  ## Resources 

  	- [The Try Block](http://docs.oracle.com/javase/tutorial/essential/exceptions/try.html)
  	- [The Catch Blocks](http://docs.oracle.com/javase/tutorial/essential/exceptions/catch.html)
  	- [Try Catch for dummies](http://www.dummies.com/how-to/content/try-statements-in-java.html)
