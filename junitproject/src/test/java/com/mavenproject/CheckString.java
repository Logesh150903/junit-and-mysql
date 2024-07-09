package com.mavenproject;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class CheckString {
    String obj1="Junit";
    String obj2="Junit";
    int a[]= {1,2,3};
    int b[]= {1,2,3};
    String s=null;
    String s1="EduBridge";
    @Test
    public void chkStrin() {
        assertEquals(obj1,obj2); 
    }
    @Test
    public void chkStrin1() {
    	 assertSame(obj2, obj1);
    }
    @Test
    public void chkStrin2() {
    	assertArrayEquals(a, b);
    }
    @Test
    public void chkStrin3() {
    	 assertNull(s);
    }
    @Test
    public void chkStrin4() {
    	assertNotNull(s1);
    }
}
