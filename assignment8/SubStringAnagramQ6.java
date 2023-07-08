package in.ineuron.assignment8;

import java.util.*;

public class SubStringAnagramQ6 {
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> indices = new ArrayList<>();

		int[] targetFreq = new int[26];
		int[] windowFreq = new int[26];

		int pLen = p.length();
		int sLen = s.length();

		if (sLen < pLen) {
			return indices;
		}

		for (char ch : p.toCharArray()) {
			targetFreq[ch - 'a']++;
		}

		for (int i = 0; i < sLen; i++) {
			windowFreq[s.charAt(i) - 'a']++;

			if (i >= pLen) {
				windowFreq[s.charAt(i - pLen) - 'a']--;
			}

			if (isAnagram(targetFreq, windowFreq)) {
				indices.add(i - pLen + 1);
			}
		}

		return indices;
	}

	private static boolean isAnagram(int[] targetFreq, int[] windowFreq) {
		for (int i = 0; i < 26; i++) {
			if (targetFreq[i] != windowFreq[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// Q.6
		String s = "cbaebabacd";
		String p = "abc";

		List<Integer> anagramIndices = findAnagrams(s, p);
		System.out.println(anagramIndices);

	}

}
