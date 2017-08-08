/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayAlgorithms;

import java.util.Arrays;
/**
 *
 * @author Dhanasit
 */
public class PairCheck {

    int[] _array;
	int[] _sortedArray;
	
	public PairCheck() {
		
	}
	
	/**Generate an array of a specific size, 
	 *containing random integers from min to max
     * @param size
     * @param minValue
     * @param maxValue
     * @return  */
	public int[] generateArray(int size, int minValue, int maxValue) {
		
		int[] array = new int[size];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = (int) ((maxValue - minValue) * Math.random() + minValue);
		}
		
		_array = array;
		return array;
	}
	/**Generate a sorted array of a specific size, 
	 * containing random integers from min to max
     * @param size
     * @param minValue
     * @param maxValue
     * @return  */
	public int[] generateSortedArray(int size, int minValue, int maxValue) {
		int [] sortedArray = generateArray(size, minValue, maxValue);
		Arrays.sort(sortedArray);
		_sortedArray = sortedArray;
		return sortedArray;
	}
	
	/**Returns a boolean indicating whether there exists a pair a, b such that 
	 * their sums correspond to the target sum.
     * @param data
     * @param sumTarget
     * @return  */
	public static boolean pairCheck(int[] data, int sumTarget) {
		
		int indexLow = 0; //initial starting low
		int indexHigh = data.length - 1; //initial starting high
		
		
		
		while(indexLow < indexHigh){
			int sum = data[indexLow] + data[indexHigh];
			if(sum == sumTarget) {
				return true;
			} else if(sum < sumTarget) {
				indexLow++;
			} else if(sum > sumTarget) {
				indexHigh--;
			}
		}
		
		return false;
		
		
	}
	/**More advanced algorithm of the pairCheck method.
	 * Significantly faster if the sorted array is somewhat evenly distributed.
     * @param data
     * @param sumTarget
     * @return  */
	public static boolean advancedPairCheck(int[] data, int sumTarget) {
		
		int indexLow = 0; //initial starting low
		int indexHigh = data.length - 1; //initial starting high
		
		//average increment per element of the data array.
		int averageIncrement = (data[data.length - 1] - data[0])/data.length;
		int diff;
		
		

		while(indexLow < indexHigh){
			int sum = data[indexLow] + data[indexHigh];
			diff = sumTarget - sum;
			if(sum == sumTarget) {
				return true;
			} else if(sum < sumTarget) {
				if(0.5*diff/averageIncrement + indexLow >= indexHigh) {
					indexLow ++;
					continue;
				}
				indexLow = (int) (indexLow + 0.5*diff/averageIncrement);

				indexLow++;
			} else if(sum > sumTarget) {
				if(0.5*diff/averageIncrement + indexHigh <= indexLow) {
					indexHigh--;
					continue;
				}
				
				indexHigh = (int) (indexHigh + 0.5 *diff/averageIncrement);

			}
		}

		return false;
	}
    
}
