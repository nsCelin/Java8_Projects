package com.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {

	public static void main(String[] args) {
		
		/*Storing the integers into an Integer array*/
		List<Integer> list = Arrays.asList(10,20,30,40,50);
		
		/*This is equivalent to creating a function to perform unaryOperation
		 * with return type UnaryOperator, which is a Java 8 function.
		 * What operation to be performed is defined here*/
		UnaryOperator<Integer> unaryOpt = i ->i*i;
		
		/*The result from unaryOperatorFun is applied a forEach operation*/
		unaryOperatorFun(unaryOpt,list).forEach(w->System.out.println(w));
	}
	
	private static List<Integer> unaryOperatorFun(UnaryOperator<Integer> unaryOpt,List<Integer> list){
		
		/*The ArrayList doesnot define the type*/
		List<Integer> uniList = new ArrayList<>();
		/*Java 8's UnaryOperator might be having apply method
		 * Processing Step 1
		 * Here i is the variable which iterates through the list
		 * and unaryOpt is applied to this variable i
		 * list.forEach(i->unaryOpt.apply(i)); 
		 * Processing Step 2
		 * Here the output of list is added to the uniList,
		 * Output is stored inside uniList and not inside list
		 * list.forEach(i->uniList.add(unaryOpt.apply(i)));
		 * */
		list.forEach(i->uniList.add(unaryOpt.apply(i)));
		
        return uniList;
	}
}
