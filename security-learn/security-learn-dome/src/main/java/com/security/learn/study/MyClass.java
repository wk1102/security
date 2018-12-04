package com.security.learn.study;

public  class MyClass extends Test {
   Person person = new Person("MyClass");
   static{
       System.out.println("myclass static");
   }
    
   public MyClass() {
       System.out.println("myclass constructor");
   }
}