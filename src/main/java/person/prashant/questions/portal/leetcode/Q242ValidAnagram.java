package person.prashant.questions.portal.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false



Constraints:

    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.



Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

 */
public class Q242ValidAnagram {


    public static void main(String[] args) {
        System.out.println("I: anagram, nagaram");
        boolean result1 = isAnagram("anagram", "nagaram");
        System.out.println(result1);

        System.out.println("I: rat, car");
        boolean result2 = isAnagram("rat", "car");
        System.out.println(result2);

        System.out.println("I: peek, keep");
        boolean result3 = isAnagram("peek", "keep");
        System.out.println(result3);
    }

    public static boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    public static boolean isAnagramV1(String s, String t) {
        String s1 = getSortedRestructuredString(s);
        String t1 = getSortedRestructuredString(t);
        return s1.equals(t1);
    }

    private static String getSortedRestructuredString(String input){
        return Arrays.stream(input.split(""))
                .sorted()
                .collect(Collectors.joining());
    }
}
