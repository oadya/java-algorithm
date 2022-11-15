package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Algorithm {

	public static void main(String[] args) {

		System.out.println("reverseStringUsingForLoop : " + reverseStringUsingForLoop("java2blog"));

		System.out.println("factorielle of N : " + factorielle(5));

		System.out.println("factorielleRecursion of N :" + factorielleRecursion(5));

		System.out.println("power  : " + power(5, 2));

		System.out.println("reverseStringUsingRecursion : " + reverseStringUsingRecursion("java2blog"));

		System.out.println("reverseStringUsingStringBuffer : " + reverseStringUsingStringBuffer("java2blog"));

		System.out.println("checkIfTwoStringAreAnagram : " + checkIfTwoStringAreAnagram("Angel", "Angle"));

		System.out.println("sortString : " + sortString("cba"));

		System.out.println("checkIfStringHasAllUniqueCaracter : " + checkIfStringHasAllUniqueCaracter("java2blog"));

		System.out.println("checkIfStringHasAllUniqueCaracterBis : " + checkIfStringHasAllUniqueCaracterBis("world"));

		System.out.println("findDuplicateCaracterInString : ");
		findDuplicateCaracterInString("java2blog.com");

		System.out.println("findTheFirtNonRepeatCaracter : " + findTheFirtNonRepeatCaracter("analogy"));

		System.out.println("duodigit : " + duodigitThree(110));

		System.out.println("air : " + findSumPair(4));

	}

	private static String reverseStringUsingForLoop(String input) {

		String resp = "";

		for (int i = input.length() - 1; i >= 0; i--) {
			resp += input.charAt(i);
		}

		return resp;

	}

	private static int factorielle(int fact) {

		int resp = 1;

		for (int i = 1; i <= fact; i++) {
			resp *= i;
		}

		return resp;
	}

	private static int factorielleRecursion(int fact) {

		if (fact == 1) {
			return 1;
		} else {
			return fact * factorielleRecursion(fact - 1);
		}
	}

	private static int power(int number, int power) {

		int resp = 1;

		for (int i = 0; i < power; i++) {
			resp *= number;
		}

		return resp;
	}

	private static String reverseStringUsingRecursion(String input) {

		if (input.length() == 1) {
			return input;
		} else {
			return input.charAt(input.length() - 1)
					+ reverseStringUsingRecursion(input.substring(0, input.length() - 1));
		}

	}

	private static String reverseStringUsingStringBuffer(String input) {

		return new StringBuffer().append(input).reverse().toString();

	}

	private static boolean checkIfTwoStringAreAnagram(String str1, String str2) {

		if (str1.length() != str2.length()) {
			return false;
		}

		for (int i = 0; i < str1.length(); i++) {

			char c = str1.charAt(i);
			int index = str2.indexOf(c);

			if (index != -1) {
				str2 = str2.substring(0, index) + str2.substring(index + 1, str2.length());
			} else {
				return false;
			}

		}

		return str2.isEmpty();
	}

	private static String sortString(String str1) {

		char[] arrays = str1.toCharArray();

		Arrays.sort(arrays);

		return String.valueOf(arrays);

	}

	private static boolean checkIfStringHasAllUniqueCaracter(String str1) {

		HashSet set = new HashSet<>();

		for (int i = 0; i < str1.length(); i++) {

			if (!set.add(str1.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	private static boolean checkIfStringHasAllUniqueCaracterBis(String str) {

		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);

			if (str.indexOf(c) != str.lastIndexOf(c)) {
				return false;
			}
		}

		return true;
	}

	private static void findDuplicateCaracterInString(String str) {

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);

			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}

		map.forEach((k, v) -> {
			if (v > 1) {
				System.out.println(" Letter " + k + " has count of " + v);
			}
			;
		});

		map.entrySet().stream().forEach(e -> {
			if (e.getValue() > 1) {
				System.out.println(" Letter " + e.getKey() + " has count of " + e.getValue());
			}
		});

		for (Map.Entry<Character, Integer> e : map.entrySet()) {

			if (e.getValue() > 1) {
				System.out.println(" Letter " + e.getKey() + " has count of " + e.getValue());
			}
		}

	}

	private static String findTheFirtNonRepeatCaracter(String str) {

		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);

			int index = str.indexOf(c);
			int lastIndex = str.lastIndexOf(c);

			if (index == lastIndex) {
				return String.valueOf(c);
			}
		}

		return null;
	}

	private static boolean duodigitOne(int number) {

		HashSet<Character> set = new HashSet<>();

		char[] arr = String.valueOf(Math.abs(number)).toCharArray();

		for (int i = 0; i < arr.length; i++) {

			set.add(arr[i]);
		}

		return set.size() > 2 ? false : true;

	}

	private static boolean duodigitTwo(int number) {

		HashSet<Character> set = new HashSet<>();

		String str = String.valueOf(Math.abs(number));

		for (int i = 0; i < str.length(); i++) {

			set.add(str.charAt(i));
		}

		return set.size() > 2 ? false : true;

	}

	private static boolean duodigitThree(int number) {

		long isduoDigit = Integer.toString(number).chars().distinct().count();

		return isduoDigit > 2 ? false : true;

	}

	private static int findSumPair(int num) {

		int sumPair = 0;

		for (int i = 0; i < num; i++) {

			for (int j = i + 1; j < num; j++) {

				sumPair += 1;
			}
		}

		return sumPair;

	}

}
