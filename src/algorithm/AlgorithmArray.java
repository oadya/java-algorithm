package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AlgorithmArray {

	public static void main(String[] args) {

		findMinMax();

		avarage();

		System.out.println("sorAsctArrays = " + Arrays.toString(sorAsctArrays(new int[] { 5, 3, 8, 20, 6 })));

		findPairWhosSumIsCloseToZeroe();

		findNumberOccuringOddNumberOfTime();

		findLargestAndSeecondLargestNumber();

		findMissingNumber();

		rechercheDichotomique();

		findTheFirstRepeatedElement();

		sumPiarAndCarreImair();

		operation();

		// predicate();

	}

	private static void findMinMax() {

		int[] arrays = { 1, 3, -5, 7, 8, 20, -40, 6 };

		int min = arrays[0];
		int max = arrays[0];

		for (int i : arrays) {

			if (i < min) {
				min = i;
			} else if (i > max) {
				max = i;
			}
		}

		System.out.println(" Max = " + max + " and Min = " + min);
	}

	private static int[] sorAsctArrays(int[] array) {

		for (int i = 0; i < array.length; i++) {

			for (int j = i + 1; j < array.length; j++) {

				if (array[i] > array[j]) {
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}

		return array;

	}

	private static void avarage() {

		int[] arrays = { 1, 3, 6 };

		int moy, sum = 0, prod = 1;

		for (int i = 0; i < arrays.length; i++) {
			sum += arrays[i];
			prod *= arrays[i];
		}

		moy = sum / arrays.length;

		System.out.println(" Avaage = " + moy + " Produit = " + prod);
	}

	private static void findPairWhosSumIsCloseToZeroe() {

		int[] arrays = { 1, 3, -5, 7, 8, 20, -40, 6 };

		int a = arrays[0];
		int b = arrays[1];

		int sumCloseTozero = a + b;

		for (int i = 0; i < arrays.length; i++) {

			for (int j = i + 1; j < arrays.length; j++) {

				int sum = arrays[i] + arrays[j];

				if (Math.abs(sum) < Math.abs(sumCloseTozero)) {
					a = arrays[i];
					b = arrays[j];
					sumCloseTozero = a + b;
				}

			}
		}

		System.out.println("Pair whose som close to zero is : " + a + " and " + b);
	}

	private static void findNumberOccuringOddNumberOfTime() {

		int[] arrays = new int[] { 20, 40, 50, 40, 50, 20, 30, 30, 50, 20, 40, 40, 20 };

		Map<Integer, Integer> map = new HashMap<>();

		for (int elt : arrays) {

			if (!map.containsKey(elt)) {
				map.put(elt, 1);
			} else {
				map.put(elt, map.get(elt) + 1);
			}
		}

		map.forEach((k, v) -> {
			if (v % 2 == 1) {
				System.out.println(" Odd element : " + k + " Occuring " + v);
			}
		});
	}

	private static void findLargestAndSeecondLargestNumber() {

		int[] arrays = new int[] { 7, 5, 6, 1, 4, 2 };

		int largestNumber = Integer.MIN_VALUE;
		int secondLargesttNumber = Integer.MIN_VALUE;

		for (int elt : arrays) {

			if (elt > largestNumber) {
				secondLargesttNumber = largestNumber;
				largestNumber = elt;
			}
			if (elt > secondLargesttNumber && elt != largestNumber) {
				secondLargesttNumber = elt;
			}
		}

		System.out.println(" largestNumber : " + largestNumber + " , secondLargesttNumber : " + secondLargesttNumber);
	}

	private static void findMissingNumber() {

		int[] arrays = new int[] { 7, 5, 6, 1, 4, 2 };

		int n = arrays.length + 1;
		int sum = n * (n + 1) / 2;

		int restSum = 0;

		for (int elt : arrays) {
			restSum += elt;
		}

		int missingNumber = sum - restSum;
		System.out.println(" Missing number : : " + missingNumber);
	}

	private static void rechercheDichotomique() {

		int arr[] = { 16, 19, 21, 25, 3, 5, 8, 10 };

		int inf = 0, sup = arr.length - 1, pos = -1, mil;

		int searchElement = 10;

		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {

			mil = (inf + sup) / 2;

			if (searchElement < arr[mil]) {
				sup = mil - 1;
			} else if (searchElement > arr[mil]) {
				inf = mil + 1;
			} else {
				pos = mil;
			}
		}

		if (pos == -1) {
			System.out.println(" Element non trouvé ");
		} else {
			System.out.println(" Element non trouvé à la position : " + pos);
		}
	}

	private static void findTheFirstRepeatedElement() {

		int[] arrays = new int[] { 10, 7, 8, 1, 5, 7, 6, 8 };

		HashSet set = new HashSet<>();

		for (int elt : arrays) {

			if (!set.add(elt)) {
				System.out.println(" The first repeate element  : " + elt);
				break;
			}
		}

	}

	private static void sumPiarAndCarreImair() {

		int[] arrays = new int[] { 10, 7, 8, 5 };

		int sumPair = 0;
		int sumImpair = 0;

		for (int elt : arrays) {

			if (elt % 2 == 0) {
				sumPair += elt;
			} else {
				sumImpair += Math.pow(elt, 2);
			}
		}

		System.out.println(" sumPair = " + sumPair + " sumImpair = " + sumImpair);

	}

	private static void m() {
		Integer[] primes = { 2, 3, 5, 7, 11 };

		List<Integer> listOfInts = new ArrayList<>(Arrays.asList(primes));

		Integer[] array = listOfInts.stream().toArray(Integer[]::new);

		List<Integer> list = listOfInts.stream().collect(Collectors.toCollection(ArrayList::new));

		Integer[] iArray = list.toArray(new Integer[list.size()]);

		Stream<String> numbers = Stream.of("1", "2", "3", "4", "5");
		int[] ints = numbers.mapToInt(Integer::parseInt).toArray();

	}

	private static void operation() {

		int arr_sample1[] = { 11, 2, 3, 42, 5, 6, 17, 8, 9, 10, 11, 12, 13, 24, 55, 16, 47, 18, 19, 20 };
		System.out.println("These method returns Optional");

		// forEach()
		// It iterates through the entire streams
		System.out.println("Printing array elements : ");
		Arrays.stream(arr_sample1).forEach(e -> System.out.print(e + " "));

		// average()
		// This method returns a average of an array
		System.out.println("Example of average() : ");
		System.out.println((Arrays.stream(arr_sample1).average()));

		// findAny()
		// It can return any value from the stream
		// Most of the time it returns the first value
		// but it is not assured it can return any value
		System.out.println("Example of findAny() : ");
		System.out.println(Arrays.stream(arr_sample1).findAny());

		// findFirst()
		// It returns the first element of the stream
		System.out.println("Example of findFirst() :");
		System.out.println(Arrays.stream(arr_sample1).findFirst());

		// max()
		// It returns the max element in an array
		System.out.println("Example of max() :");
		System.out.println(Arrays.stream(arr_sample1).max());

		// min()
		// It returns the min element in an array
		System.out.println("Example of min() :");
		System.out.println(Arrays.stream(arr_sample1).min());

		// reduce()
		// It reduces the array by certain operation
		// Here it performs addition of array elements
		System.out.println("Example of reduce() :");
		System.out.println(Arrays.stream(arr_sample1).reduce((x, y) -> x + y));

		int sum = Arrays.stream(arr_sample1) // Step 1
				.sum(); // Step 2
	}

	private static void predicate() {

		int arr_sample1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

		// asDoubleStream()
		// It converts the original array to double
		System.out.println("Example of asDoubleStream(): ");
		Arrays.stream(arr_sample1).asDoubleStream().forEach(e -> System.out.print(e + " "));

		// asLongStream()
		// It converts the original array to Long
		System.out.println("\nExample of asLongStream");
		Arrays.stream(arr_sample1).asLongStream().forEach(e -> System.out.print(e + " "));

		int arr_sample2[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 23, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

		// anyMatch()
		// This method find whether the given predicate
		// is in the array or not
		System.out.println("\nExample of anyMatch");

		// Test whether any of the element in array is
		// divisible by 11 or not
		IntPredicate predicate = e -> e % 11 == 0;
		System.out.println(Arrays.stream(arr_sample2).anyMatch(predicate));

		// You can directly write the lambda expression
		// which computes to IntPredicate
		// Uncomment to test
		// System.out.println(Arrays.stream(arr)
		// .anyMatch(e -> e % 11 == 0));

		int arr_sample3[] = { 2, 4, 6, 8, 10 };
		int arr_sample4[] = { 1, 3, 5, 7, 11 };

		// allMatch()
		// This method finds whether the given predicate
		// matches the entire array or not
		System.out.println("Example of allMatch :");

		// Returns true as all the elements of arr_sample3
		// is even
		System.out.println(Arrays.stream(arr_sample3).allMatch(e -> e % 2 == 0));

		// Returns false as all the elements of arr_sammple4
		// is odd
		System.out.println(Arrays.stream(arr_sample4).allMatch(e -> e % 2 == 0));

		// noneMatch()
		System.out.println("Example of noneMatch");
		System.out.println(Arrays.stream(arr_sample4).noneMatch(e -> e % 2 == 0));
	}
	/*
	 * private static String insertElementInsSortedArrays(int x) {
	 * 
	 * int[] arrays = new int[4]; arrays[0] = 5; arrays[1] = 3; arrays[2] = 1;
	 * 
	 * int[] sortArrays = sorAsctArrays(arrays);
	 * 
	 * System.out.println(" Sorted Array = " + Arrays.toString(sortArrays));
	 * 
	 * int pos = 0;
	 * 
	 * // found position while (x > sortArrays[pos]) { pos += 1; }
	 * System.out.println("pos = " + pos); // decallage for (int i =
	 * sortArrays.length - 1; i > pos; i--) { arrays[i + 1] = arrays[i]; }
	 * 
	 * arrays[pos] = x;
	 * 
	 * return Arrays.toString(arrays);
	 * 
	 * }
	 */

}
