package leetcode.lc49;

import java.util.*;

/**
 * @author anztim
 */
public class Lc49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = new Solution().groupAnagrams(strs);
        for (List<String> list : res) {
            for (String str : list) {
                System.out.print("\"" + str + "\" ");
            }
            System.out.println();
        }
    }
}

class Solution {
    static class Status {
        int[] count;
        int code;
        boolean hashed;

        Status(String str) {
            count = new int[26];
            int len = str.length();
            for (int i = 0; i < len; i++) {
                count[str.charAt(i) - 'a']++;
            }
            code = hashCode();
            hashed = true;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Status)) return false;
            Status s = (Status) o;
            return Arrays.equals(this.count, s.count);
        }

        public int hashCode() {
            if (hashed) return code;
            hashed = true;
            return Arrays.hashCode(count);
        }
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();
        Map<Status, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Status s = new Status(str);
            if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                resultList.add(newList);
                map.put(s, newList);
            }
        }
        return resultList;
    }
}