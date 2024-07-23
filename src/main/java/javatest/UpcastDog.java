package javatest;
public class UpcastDog extends Upcasting {
	@Override
	public void makeSound() {
		System.out.println("Dog bark");
	}
	public static void main(String[] args) {
		UpcastDog updog=new UpcastDog();		
		//Upcasting
		Upcasting Upcasting=updog;// upcasting
		//Upcasting.makeSound();
		
		//Downcasting
		updog=(UpcastDog) Upcasting;
		updog.makeSound();
		
	}
}
