package person.prashant.questions.portal.leetcode;

import person.prashant.utility.DoubleInputSolutionTester;

import java.util.Arrays;
import java.util.stream.Collectors;

/*

242. Valid Anagram

https://leetcode.com/problems/valid-anagram/description/

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

        DoubleInputSolutionTester.<String, String, Boolean>startTest("Example 1")
                .callMethod(Q242ValidAnagram::isAnagram)
                .withInput("anagram", "nagaram")
                .andExpect(true);

        DoubleInputSolutionTester.<String, String, Boolean>startTest("Example 2")
                .callMethod(Q242ValidAnagram::isAnagram)
                .withInput("rat", "car")
                .andExpect(false);

        DoubleInputSolutionTester.<String, String, Boolean>startTest("Example 3")
                .callMethod(Q242ValidAnagram::isAnagram)
                .withInput("peek", "keep")
                .andExpect(true);
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
