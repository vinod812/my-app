package javatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class stream{
	public static void main(String[] args){
		List<Integer> listdata= Arrays.asList(100,35,11,90,3);
		System.out.println(listdata);
		
		
		Stream<Integer> abc= (Stream<Integer>) listdata.stream()
				                     .filter(n->n%2==0) 
				                     .map(n->n*2)
				                     .collect(Collectors.toList());
		
	
		
		System.out.println(abc);
	}
}
