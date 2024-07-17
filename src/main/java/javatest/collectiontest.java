package javatest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class collectiontest {
	public static void main(String[] args){
		
		//Array
		int[] arraydata=new int[3];
		int[] arraydata1={22,1,9};
		for(int i=0;i<arraydata1.length;i++){
			System.out.println(arraydata1[i]);
		}
				
		//List
		List<Integer> listdata=new ArrayList();
		listdata.add(1);
		listdata.add(11);
		listdata.add(10000);
		for(Integer list:listdata){
			System.out.println(list);			
		}
		
				
		//Set
		Set <String> stringdata= new HashSet();
		stringdata.add("dsdasda");
		stringdata.add("Raviiii");
		for(String xyz:stringdata){
			System.out.println(xyz);
		}
		
		//Map
		Map <String, Integer> mapdata=new HashMap();
		mapdata.put("dd", 1);
		mapdata.put("ddd", 99);
		
        for(Map.Entry<String, Integer> map: mapdata.entrySet()){
        	System.out.println(map.getKey());
        	System.out.println(map.getValue());
        	
        }
		
		//Iterator
		Iterator<Integer> itr=listdata.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
			System.out.println(itr.hasNext());
			
		}
        
		
		//Iterator for set
		Iterator<String> setdata=stringdata.iterator();
		while(setdata.hasNext()){
			System.out.println(setdata.next());
			setdata.remove();
			
		}
        
		
        
	}	

}
