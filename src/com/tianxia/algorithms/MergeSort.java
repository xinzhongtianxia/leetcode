package com.tianxia.algorithms;

import java.util.Arrays;

public class MergeSort {
	private static int[] aux;

	public static void sort(int[] a) {
		aux = new int[a.length];
		sort(a, 0, a.length - 1);
		
	}

	private static void sort(int[] a, int lo, int hi) {
		
		if (lo >= hi) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
	}

	public static void merge(int[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		for (int k = 0; k <= hi; k++) {
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = a[j];
				j++;
			} else if (j > hi) {
				a[k] = a[i];
				i++;
			} else if (a[i] < a[j]) {
				a[k] = a[i];
				i++;
			} else {
				a[k] = a[j];
				j++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{1,2,5,3,2,1,7,44,23,21,21,11,2,22,1};
		sort(a);
		for (int i =0;i<a.length;i++) {
			System.out.print(a[i] + ",");
		}
	}
}
