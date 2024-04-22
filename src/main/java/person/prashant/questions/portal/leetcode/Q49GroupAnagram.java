package person.prashant.questions.portal.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/*
49. Group Anagrams
https://leetcode.com/problems/group-anagrams/

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:

Input: strs = [""]
Output: [[""]]

Example 3:

Input: strs = ["a"]
Output: [["a"]]

 */
public class Q49GroupAnagram {



    public static void main(String[] args) {
        System.out.println("I: \"eat\",\"tea\",\"tan\",\"ate\",\"nat\",\"bat\"");
        List<List<String>> result1 = groupAnagrams("eat","tea","tan","ate","nat","bat");
        System.out.println(result1);

        System.out.println("I: \"\"");
        List<List<String>> result2 = groupAnagrams("");
        System.out.println(result2);

        System.out.println("I: a");
        List<List<String>> result3 = groupAnagrams("a");
        System.out.println(result3);
    }

    public static List<List<String>> groupAnagrams(String... strs) {
        return
        Arrays.stream(strs)
                //.map(Q49GroupAnagram::getSortedRestructuredString)
                .collect(Collectors.groupingBy(t -> getSortedRestructuredString(t)))
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    private static String getSortedRestructuredString(String input){
        return Arrays.stream(input.split(""))
                .sorted()
                .collect(Collectors.joining());
    }
}
