package L5_Feb15;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 15-Feb-2020
 *
 */

public class ArrayOps {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// int[] arr = takeInput() ;
		// int[] arr = { 50, 60, 30, 40 };
		// display(arr);

		// System.out.println(maximum(arr));
		// System.out.println(linearSearch(arr, 80));
		// System.out.println(binarySearch(arr, 80));

		// subarray(arr);
		// subarraySum2Loops(arr);
		// subarraySum3Loops(arr);

		// barGraph(arr);

		// reverse(arr);
		// rotate(arr, -40);
		// int[] inv = inverse(arr);
		// display(inv);

		// display(inverse(arr));
		// insertionSort(arr);
		// display(arr);

		// int[] arr = new int[100000];
		// for (int i = 0; i < arr.length; i++) {
		// arr[i] = i;
		// }

		// long start = System.currentTimeMillis();
		// bubbleSort(arr);
		// long end = System.currentTimeMillis();

		int[] arr = { 2, 3, -6, 1, 2, 3, -4, 5, -8 };
		System.out.println(kadanes(arr));

		// System.out.println(end - start);
	}

	public static int[] takeInput() {

		System.out.println("Size ?");
		int n = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		return arr;
	}

	public static void display(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static int maximum(int[] arr) {

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > max) {
				max = arr[i];
			}
		}

		return max;
	}

	public static int linearSearch(int[] arr, int item) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == item) {
				return i;
			}
		}

		return -1;

	}

	public static int binarySearch(int[] arr, int item) {

		int lo = 0;
		int hi = arr.length - 1;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (item > arr[mid]) {
				lo = mid + 1;
			} else if (item < arr[mid]) {
				hi = mid - 1;
			} else {
				return mid;
			}
		}

		return -1;
	}

	public static void subarray(int[] arr) {

		for (int si = 0; si < arr.length; si++) {

			for (int ei = si; ei < arr.length; ei++) {

				System.out.print(si + " " + ei + " : ");

				for (int k = si; k <= ei; k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println();
			}
		}

	}

	public static void subarraySum3Loops(int[] arr) {

		for (int si = 0; si < arr.length; si++) {

			for (int ei = si; ei < arr.length; ei++) {

				System.out.print(si + " " + ei + " : ");

				int sum = 0;
				for (int k = si; k <= ei; k++) {
					sum += arr[k];
				}
				System.out.println(sum);
			}
		}
	}

	public static void subarraySum2Loops(int[] arr) {

		for (int si = 0; si < arr.length; si++) {

			int sum = 0;

			for (int ei = si; ei < arr.length; ei++) {

				sum += arr[ei];
				System.out.println(si + "-" + ei + " : " + sum);

			}
		}

	}

	public static void maxSubarraySum2Loops(int[] arr) {

		int max = Integer.MIN_VALUE;

		for (int si = 0; si < arr.length; si++) {

			int sum = 0;

			for (int ei = si; ei < arr.length; ei++) {

				sum += arr[ei];

				if (sum > max) {
					max = sum;
				}

			}
		}

		System.out.println(max);

	}

	public static int kadanes(int[] arr) {

		int sum = arr[0];
		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {

			// max sum which you can obtain when ur subarray ends at arr[i] value
			sum = Math.max(sum + arr[i], arr[i]);

			// you need to find max of all sum
			if (sum > max) {
				max = sum;
			}
		}

		return max;
	}

	public static void barGraph(int[] arr) {

		int max = maximum(arr);

		for (int r = 1; r <= max; r++) {

			for (int c = 0; c < arr.length; c++) {

				if (r <= max - arr[c]) {
					System.out.print("   ");
				} else {
					System.out.print("*  ");
				}
			}

			System.out.println();
		}
	}

	public static void reverse(int[] arr) {

		int i = 0;
		int j = arr.length - 1;

		while (i <= j) {

			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;

			i++;
			j--;
		}

	}

	public static void rotate(int[] arr, int rot) {

		rot = rot % arr.length;

		if (rot < 0) {
			rot = rot + arr.length;
		}

		for (int r = 1; r <= rot; r++) {
			int temp = arr[arr.length - 1]; // last value store

			for (int i = arr.length - 1; i >= 1; i--) { // shift
				arr[i] = arr[i - 1];
			}

			arr[0] = temp; // 0th index correct value place
		}
	}

	public static int[] inverse(int[] arr) {

		int[] inv = new int[arr.length];

		for (int i = 0; i < inv.length; i++) {

			inv[arr[i]] = i;
		}

		return inv;
	}

	public static void insertionSort(int[] arr) {

		for (int count = 1; count <= arr.length - 1; count++) {

			int item = arr[count];

			int j = count - 1;

			while (j >= 0 && arr[j] > item) {
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = item;
		}

	}

	public static void bubbleSort(int[] arr) {

		boolean flag = true;

		for (int count = 0; count <= arr.length - 2; count++) {

			for (int j = 0; j <= arr.length - count - 2; j++) {

				if (arr[j] > arr[j + 1]) {

					flag = false;

					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}

			if (flag)
				break;

			// display(arr);
		}
	}

	public static void selectionSort(int[] arr) {

		for (int count = 0; count <= arr.length - 2; count++) {

			int min = count;

			for (int j = count + 1; j <= arr.length - 1; j++) {

				if (arr[j] < arr[min]) {
					min = j;
				}
			}

			// smallest value index
			int temp = arr[min];
			arr[min] = arr[count];
			arr[count] = temp;

			display(arr);
		}

	}

}
