package com.ttn.aem.mockito.demo.assignment;

import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Created by ttn on 7/6/17.
 */
public class AccountClass {

    public int balance=0;

    public int credit(int amount){
        if(amount > 50000){
            throw new IllegalArgumentException("You can credit maximum 50000 in a day");
        }else {
            return balance = balance + amount;
        }
    }

    public int debit(int amount){
        if(balance < amount){
            throw new IllegalArgumentException("Not sufficient balance");
        }else if(amount > 25000){
            throw new IllegalArgumentException("Reached your daily limit");
        }
        else {
            return balance = balance - amount;
        }
    }
}
