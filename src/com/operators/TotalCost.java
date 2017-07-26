package com.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;

public class TotalCost {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        double mealCost = scan.nextDouble(); // original meal price
        int tip = scan.nextInt(); // tip percentage
        int tax = scan.nextInt(); // tax percentage
        scan.close();
        
        /*Here first value in Map will be overriden by second value
         * as both the values are same. So List is better approach*/
        /*Map<Double,Integer> map = new HashMap<>();
        map.put(mealCost, tipPercent);
        map.put(mealCost, taxPercent);*/
        
        List<Double> costs = new ArrayList<>();
        costs.add((double)tip);
        costs.add((double)tax);
        
        BinaryOperator<Double>  opPercent = (t1,t2) -> (t1*t2)/100;
        
        List<Double> percents = calculation(opPercent,costs,mealCost);
        
        /*Please have a look*/
        /*https://www.leveluplunch.com/java/examples/sum-first-n-numbers-in-arraylist/*/
        /*To find the sum of values inside list*/
        double total = percents.stream().mapToDouble(Double::doubleValue).sum();
        
        /*BiFunction<Double, Double,Double>  opSum = (t1,t2) -> (t1+t2);
        BinaryOperator<Double> opPercent = (t1,t2) -> (t1*t2)/100;
        BinaryOperator<Double> opSum = (t1,t2) -> (t1+t2);*/
        
                
	}

	public static List<Double> calculation(BinaryOperator opPercent , List<Double> costs, Double mealCost) {
		List<Double> biList = new ArrayList<>();
		costs.forEach(c-> biList.add((Double) opPercent.apply(mealCost, c)));
		return biList;
	}
	
}
