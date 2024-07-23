package javatest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ComparableTest implements Comparable<ComparableTest>{
	private String name;
	private int age;
	
	public ComparableTest(String name, int age){
		this.name=name;
		this.age=age;		
	}

	@Override
	public int compareTo(ComparableTest other) {
		return Integer.compare(this.age, other.age);
	}
	public String getName(){
		return this.name;
	}

	public int getAge(){
		return this.age1;
	}
	

    @Override
    public String toString() {
        return namehere + " (" + age1 + ")";
    }
	
	public static void main(String[] args) {
		
		//ComparableTest ComparableTest=new ComparableTest(); 
		List<ComparableTest> comparableTest=new ArrayList();
		comparableTest.add(new ComparableTest("Vinod",43));
		comparableTest.add(new ComparableTest("Arjun", 10));
		comparableTest.add(new ComparableTest("Panchhi",13));
        comparableTest.add(new ComparableTest("Sarita",33));
		
		Collections.sort(comparableTest);
		
		for(ComparableTest person: comparableTest){
			System.out.println(person);
		}
		
		
	}
}
