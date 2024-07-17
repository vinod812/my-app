package javatest;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
/*
1-Input array
2-Store in hash map the duplicate entry
3-create string of duplicate entry and count to find the exact count
4-For loop to array to find the exact min and max count and charactor

*/

public class DuplicateCharactorNumber {
	public static void main(String[] args){
		
		//Input data
		String inputdata="bananahaikhanamangohilana";
		
		//input data to char array conversion
		char[] listdata= inputdata.toCharArray();
		
		//new has map to add the duplicate entry
		Map<Character,Integer> mapdata=new HashMap();	
		for(int i=0;i<listdata.length;i++){
				if(!mapdata.containsKey(listdata[i])){
				mapdata.put(listdata[i], 1);
			}else{
				int currentvalue= mapdata.get(listdata[i]);
				mapdata.put(listdata[i], currentvalue+1);
			}			
		}
	
		//Find the duplicate char and count
		String diuplicateChar="";
		String DuplocateCharCount="";
		for(Entry<Character, Integer> entry : mapdata.entrySet()){		
			if(entry.getValue()>1){
				diuplicateChar=diuplicateChar+"#"+entry.getKey();
				DuplocateCharCount=DuplocateCharCount+"#"+entry.getValue();
			}
		}
		
		//Conver into the array to find the exact count
		String[] charinput =diuplicateChar.split("#");
		String[] occurinput =DuplocateCharCount.split("#");
    	int min=Integer.parseInt(occurinput[1]);
		int max=Integer.parseInt(occurinput[1]);
		String minchar=charinput[1];
		String maxchar=charinput[1];
		
		for(int i=1;i<occurinput.length;i++){
			if(min>Integer.parseInt(occurinput[i])){
				min=Integer.parseInt(occurinput[i]);
				minchar=charinput[i];
			}
			if(max<Integer.parseInt(occurinput[i])){
				max=Integer.parseInt(occurinput[i]);
				maxchar=charinput[i];
			}
		}
	
    System.out.println("Min:"+minchar+":"+min);
    System.out.println("max:"+maxchar+":"+max);
		
	}
}
