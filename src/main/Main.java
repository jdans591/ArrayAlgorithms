/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import arrayAlgorithms.PairCheck;

/**
 *
 * @author Dhanasit
 */
public class Main {
    
    public static void main(String[] args) {
        PairCheck pairCheck = new PairCheck();
		
		int size = 1000000;
		int minValue = 0;
		int maxValue = 10000000;
		int sumTarget = 5000000;
		
		int[] array = pairCheck.generateSortedArray(size, minValue, maxValue);
		long startTime = System.nanoTime();
		boolean pairExists = PairCheck.advancedPairCheck(array, sumTarget);
		long endTime = System.nanoTime();
		
		System.out.println("Execution time : " + (endTime - startTime) + " nanoseconds");
		System.out.println(pairExists);
        
        
        
    }
    
}
