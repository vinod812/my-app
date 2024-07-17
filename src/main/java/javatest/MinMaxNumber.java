package javatest;

public class MinMaxNumber {

	public static void main(String[] args){
		int[] arraydata= new int[5];
		int[] arraydatainitialization={1,4,2,1000,55,4};
		int min=arraydatainitialization[0];
		int max=arraydatainitialization[0];
		for(int i=0;i< arraydatainitialization.length;i++){
			if(min>arraydatainitialization[i])
				min=arraydatainitialization[i];		
			if(max<arraydatainitialization[i])
				max=arraydatainitialization[i];
		}		
		System.out.println("min:"+min);
		System.out.println("max:"+max);	
	}

}
