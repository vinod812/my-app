package javatest;

public class singleton{
	private static singleton instance;
	//private construction that can not be accessed out side the class
	private singleton(){}
	public static singleton getinstance(){
		if(instance==null){instance = new singleton();}
		return instance;	
	}
	public void testmethod(){
		System.out.println("Method here");
	}
	public static void main(String[] args){
		singleton st=	singleton.getinstance();
		st.testmethod();
	}
	
}
