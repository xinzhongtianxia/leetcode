package com.tianxia.leetcode;

/**
 * @author xinzhongtianxia 2017/04/28
 */

public class StringToIntegerAtoi {
	public int myAtoi(String str) {
		if (str == null) {
			return 0;
		}
		// whether to break from the loop if next char is not a digit
		boolean isSafe = true;
		int flag = 1;
		int result = 0;
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (isSafe) {
				if (arr[i] == ' ') {
					continue;
				}
				if (arr[i] == '-') {
					flag = -1;
					isSafe = false;
					continue;
				}
				if (arr[i] == '+') {
					isSafe = false;
					continue;
				}

				if (arr[i] > '9' || arr[i] < 0) {
					return 0;
				}
				result = result * 10 + (int) (arr[i] - '0');
				isSafe = false;
			} else {
				if (arr[i] > '9' || arr[i] < '0') {
					break;
				}
				// overflow
				if (result > 2147483647 / 10
						|| ((result == 2147483647 / 10) && (arr[i] - '0') > 7)) {
					return flag == 1 ? 2147483647 : -2147483648;
				}
				result = result * 10 + (int) (arr[i] - '0');
			}
		}
		return result * flag;
	}
}
