package com.mavenproject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class EvenOddTest {
	String ans="";
    public String evenOdd(int num) {
        if(num%2==0) {
//            ans="even";
        return "even";
        }else {
//            ans="odd";
        return "odd";
        }
        }
    @Test
public void Even() {
	 assertEquals("even",evenOdd(4));
}
}
