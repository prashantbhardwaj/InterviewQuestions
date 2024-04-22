package person.prashant.questions.portal.leetcode;


import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *  Longest Substring Without Repeating Characters
 Given a string s, find the length of the longest
 substring
 without repeating characters.


 Example 1:

 Input: s = "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.

 Example 2:

 Input: s = "bbbbb"
 Output: 1
 Explanation: The answer is "b", with the length of 1.

 Example 3:

 Input: s = "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
 Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 Example 4:

 Input: s = "abcadcef"
 Output: 5
 Explanation: The answer is "adcef", with the length of 5.

 Example 5:

 Input: s = "abcadefg"
 Output: 7
 Explanation: The answer is "bcadefg", with the length of 7.

 Example 6:

 Input: s = "abcbdef"
 Output: 5
 Explanation: The answer is "cbdef", with the length of 5.


 Constraints:

 0 <= s.length <= 5 * 104
 s consists of English letters, digits, symbols and spaces.


 */
public class Q3LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println("I: abcabcbb");
        lengthOfLongestSubstring("abcabcbb");
        System.out.println();

        System.out.println("I: bbbbb");
        lengthOfLongestSubstring("bbbbb");
        System.out.println();

        System.out.println("I: pwwkew");
        lengthOfLongestSubstring("pwwkew");
        System.out.println();

        System.out.println("I: abcadcef");
        lengthOfLongestSubstring("abcadcef");
        System.out.println();

        System.out.println("I: abcadefg");
        lengthOfLongestSubstring("abcadefg");
        System.out.println();

        System.out.println("I: abcbdef");
        lengthOfLongestSubstring("abcbdef");
        System.out.println();

    }

    public static int lengthOfLongestSubstring(String s) {
        List<Character> nonRepeatingChars = new ArrayList<>();
        List<Character> charsAfterRepeatedChar = new ArrayList<>();
        String res = null;

        for (char val : s.toCharArray()){
            if (nonRepeatingChars.contains(val)){
                String newSubString = nonRepeatingChars.stream().map(String::valueOf).collect(Collectors.joining());
                if(res == null || res.length() < nonRepeatingChars.size()){
                    res = newSubString;
                }
                List<Character> copyChars = new ArrayList<>(nonRepeatingChars);
                for(int i = 0; i < copyChars.size(); i++) {
                    if (!copyChars.get(i).equals(val)) {
                        nonRepeatingChars.remove(copyChars.get(i));
                    } else {
                        nonRepeatingChars.remove(copyChars.get(i));
                        break;
                    }
                }
            }
            nonRepeatingChars.add(val);
        }
        String remainingChars = nonRepeatingChars.stream().map(String::valueOf).collect(Collectors.joining());
        if(res == null || res.length() < nonRepeatingChars.size()){
            res = remainingChars;
        }

        System.out.println(res);
        return res == null ? 0 : res.length();
    }

    public static int lengthOfLongestSubstringV1(String s) {
        List<Character> individualChars = new ArrayList<>();
        HashMap<String, Integer> substringMap = new HashMap();

        for (char val : s.toCharArray()){
            if (individualChars.contains(val)){
                substringMap.put(individualChars.stream().map(String::valueOf).collect(Collectors.joining()), individualChars.size());
                List<Character> copyChars = new ArrayList<>(individualChars);
                for(int i = 0; i < copyChars.size(); i++) {
                    if (!copyChars.get(i).equals(val)) {
                        individualChars.remove(copyChars.get(i));
                    } else {
                        individualChars.remove(copyChars.get(i));
                        break;
                    }
                }
            }
            individualChars.add(val);
        }
        substringMap.put(individualChars.stream().map(String::valueOf).collect(Collectors.joining()), individualChars.size());
        Map.Entry<String, Integer> res = substringMap.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue() - entry1.getValue())
                .findFirst()
                .orElse(new AbstractMap.SimpleEntry<>("", 0));
        System.out.println(res);
        return res.getValue();
    }
}
