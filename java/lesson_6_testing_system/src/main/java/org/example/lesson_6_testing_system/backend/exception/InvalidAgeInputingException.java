package org.example.lesson_6_testing_system.backend.exception;

public class InvalidAgeInputingException extends Exception{
    public InvalidAgeInputingException(String mesage){
        super(mesage);
    }
}
