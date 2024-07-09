package com.mavenproject;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AddtionTest {
	@Test
 public void addtest() {
		Addtion a =new Addtion();
	 assertEquals(25, a.add(10, 15)); 
 }
	@SuppressWarnings("deprecation")
	@Test
 public void areatest() {
		Addtion a =new Addtion();
	 assertEquals(78.5, a.area(5)); 
	
 }
}
