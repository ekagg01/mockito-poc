package com.ttn.aem.mockito.demo.components;

import com.ttn.aem.mockito.demo.assignment.AccountClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ttn on 7/6/17.
 */
public class AccountClassTest {

    AccountClass acc = new AccountClass();
    @Test(expected = IllegalArgumentException.class)
    public void debitZeroBalanceTest(){
        assertEquals(acc.balance, 0);
        assertEquals(acc.debit(100), -100);
        assertEquals(acc.debit(1000),1100);
    }

    @Test
    public void debitTest(){
        acc.balance = 1100;
        assertEquals(acc.debit(500), 600);
        assertNotNull(acc.debit(500));
    }

    @Test (expected = IllegalArgumentException.class)
    public void debitMaxLimitTest(){
        acc.balance = 30000;
        assertEquals(acc.debit(26000), 400);
    }


    @Test
    public void creditTest(){
        acc.balance = 3000;
        assertEquals(acc.credit(300), 3300);
    }

    @Test (expected = IllegalArgumentException.class)
    public void creditMaxLimitTest(){
        acc.balance = 1000;
        acc.credit(550000);
    }
}
