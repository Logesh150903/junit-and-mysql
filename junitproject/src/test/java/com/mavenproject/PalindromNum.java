package com.mavenproject;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class PalindromNum {
    String checkPalindrome(int n) {
        int r,sum=0,temp;    
          
          temp=n;    
          while(n>0){    
           r=n%10; 
           sum=(sum*10)+r;    
           n=n/10;    
          }    
          if(temp==sum)    
           return "palindrome number";    
          else    
           return "not palindrome";     
        }  
    @Test
    public void palindromeTest() {
        assertEquals("palindrome number", checkPalindrome(121));
    }
}
