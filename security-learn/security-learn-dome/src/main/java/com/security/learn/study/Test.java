package com.security.learn.study;

public class Test {
	Person person = new Person("Test");
	static {
		System.out.println("test static");
	}

	public Test() {
		System.out.println("test constructor");
	}

	public static void main(String[] args) {
		System.err.println("main方法");
		new MyClass();
		new Study();
	}
}

//public class Person{
//  static{
//      System.out.println("person static");
//  }
//  public Person(String str) {
//      System.out.println("person "+str);
//  }
//}

//public class MyClass extends Test {
//	Person person = new Person("MyClass");
//	static {
//		System.out.println("myclass static");
//	}
//
//	public MyClass() {
//		System.out.println("myclass constructor");
//	}
//}

