package com.tianxia.leetcode;

/**
 * @author xinzhongtianxia 2017/04/28
 */

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}
		char[] array = s.toCharArray();
		int max = 1;
		int start = 0;

		for (int i = 1; i < array.length; i++) {
			for (int j = start; j < i; j++) {
				if (array[j] == array[i]) {
					start = j + 1;
					break;
				}
			}
			int length = i - start + 1;
			if (max < length) {
				max = length;
			}
		}

		return max;
	}
}
