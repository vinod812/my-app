package javatest;

public interface FunctionalInterface {
	void action();

	default void method1(){
		System.out.println("dDefault method");
	}
}
