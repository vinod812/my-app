package javatest;

public class TypecastWide {

	public static void main(String[] args) {
		
		//Widening is done automaticallu
		int data=4;
		System.out.println(data);
		long longdata=data;
		System.out.println(longdata);
		
		//Narrowing code change is required
		long dataLong=199;
		int dataint=(int) dataLong;
		System.out.println(dataLong);
		System.out.println(dataint);
		
	}
}
