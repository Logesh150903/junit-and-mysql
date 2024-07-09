package com.mavenproject;


public class Addtion {
 int add(int a,int b) {
	 return a+b;
 }
 float area(int r) {
	 return (float) (3.14*r*r);
 }
 public static void main(String[] args) {
	Addtion a= new Addtion();
	System.err.println(a.area(5));
}
}
