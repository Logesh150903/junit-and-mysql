package com.mavenproject;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

class CircleTest {

	   @BeforeClass
	   static void setUpBeforeClass() throws Exception {}

	   @AfterClass
	   static void tearDownAfterClass() throws Exception {}

	   @Before
	   void setUp() throws Exception {}

	   @After
	   void tearDown() throws Exception {}

	   @Test
//	   @DisplayName("Test Get Area")
	   void testGetArea() {
	      Circle c1 = new Circle(1.2);
	      assertEquals(4.5239, c1.getArea(), 0.01);
	          // expected, actual, delta (pass)
	      //assertEquals(4.523893421169302, c1.getArea());
	          // expected, actual (pass)
	      //assertEquals(4.523893421169303, c1.getArea());
	          // expected, actual (fail)
	   }

//	   @Test
//	   @DisplayName("Test Always Fail")
//	   void testFail() {
//	      fail("Not yet implemented");
//	   }
	   
	   @Test
//	   @DisplayName("Test expecting Exception")
	   void TestExceptionExpected() {
	      assertThrows(IllegalArgumentException.class, () -> new Circle(-0.5));
	          // expectedType, executable
	      //assertThrows(IllegalStateException.class, () -> new Circle(-0.5));
	   }

	   @Test
//	   @DisplayName("Test catching Exception")
	   void TestExceptionCaught() {
	      // catch the exception
	      Throwable throwable = assertThrows(IllegalArgumentException.class, () -> {
	         new Circle(-0.5);
	      });
	      assertEquals("radius must be positive: -0.5", throwable.getMessage());      
	   }
	}