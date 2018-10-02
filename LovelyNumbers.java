
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <pre>
 * A number is called a lovely number if it is made of non-repeating digits. e.g. 81 is a lovely number where as 88 is not.
 * 
 * Given list of range of integers [a, b]( inclusive of both a and b ), find the number of lovely numbers for each range.
 * 
 * e.g. for list [[80, 120], [1, 20], [9, 19]] --> output should be 27, 19, and 10 because out of the 41 integers in the range [80, 120],
 * there are 27 lovely integers. Similarly, out of 20 integers in the range [1, 20], there are 19 lovely numbers
 * </pre>
 * @author Satish Thulva
 */
public class LovelyNumbers {

	/**
	 * Each entry at index `i' maintains count of number of lovely integers in the range [1, i]
	 */
	private static List<Integer> lovelyTillNumber = new ArrayList<>();
	
	public static void countNumbers(List<List<Integer>> allNumbers) {
		
		List<Integer> minMax = findMinMax(allNumbers);
		fillLovelyNumbers(minMax.get(1), lovelyTillNumber);
		
		for(List<Integer> pair : allNumbers) {
			int tillMinMinusOne = lovelyTillNumber.get(pair.get(0) - 1);
			int tillMax = lovelyTillNumber.get(pair.get(1));
			
			System.out.println(tillMax - tillMinMinusOne);
		}
	}
	
	/**
	 * Fill lovely integers for all ranges [0, i] where 1 <= i <= max in the list lovelyNumbersCountArr
	 * @param max						Maximum range to find the lovely numbers count till
	 * @param lovelyNumbersCountArr		List to fill the lovely number count
	 */
	private static void fillLovelyNumbers(int max, List<Integer> lovelyNumbersCountArr) {
		lovelyNumbersCountArr.clear();
		
		// lovely integers till 0 are 0, assuming 0 is never coming in the range
		lovelyNumbersCountArr.add(0);
		
		// start from 1 and fill till the max
		for(int i = 1; i <= max; i+=1) {
			boolean isLovelyNumber = isLovelyNumber(i);
			lovelyNumbersCountArr.add(lovelyNumbersCountArr.get(i - 1) + (isLovelyNumber ? 1 : 0));
		}
	}
	
	/**
	 * Is the given number a lovely number ?
	 * @param number	number under test
	 * @return	<code>true</code>, if given number is lovely number. <code>false</code>, otherwise
	 */
	private static boolean isLovelyNumber(int number) {
		Set<Integer> digits = new HashSet<>();
		
		while(number > 0) {
			int digit = number % 10;
			
			if(digits.contains(digit))
				return false;
			digits.add(digit);
			
			number/=10;
		}
		
		return true;
	}
	
	/**
	 * Find the min and max integer from given list of list of integers
	 * 
	 * @param allNumbers	list of list of integers
	 * @return	min and max from all the lists. The min value is returned as the first element in the list 
	 * and the max value is returned as second element
	 */
	private static List<Integer> findMinMax(List<List<Integer>> allNumbers) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(List<Integer> pair : allNumbers)
		{
			for(Integer pairParticipant : pair) {
				if(min > pairParticipant) {
					min = pairParticipant;
				}
				
				if(max < pairParticipant) {
					max = pairParticipant;
				}
			}
		}
		
		List<Integer> minMax = new ArrayList<>();
		minMax.add(min);
		minMax.add(max);
		
		return minMax;
	}
	
	
	public static void main(String[] args) {
		List<List<Integer>> pairs = new ArrayList<>();
		
		List<Integer> firstPair = new ArrayList<>();
		firstPair.add(1);
		firstPair.add(20);
		pairs.add(firstPair);
		
		List<Integer> secondPair = new ArrayList<>();
		secondPair.add(9);
		secondPair.add(19);
		pairs.add(secondPair);
		
		List<Integer> thirdPair = new ArrayList<>();
		thirdPair.add(80);
		thirdPair.add(120);
		pairs.add(thirdPair);
		
		countNumbers(pairs);
	}
	
}
