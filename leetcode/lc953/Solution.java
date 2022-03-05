package leetcode.lc953;

/**
 * @author anztim
 */

class Solution {
    private static class Order {
        int[] orderNum;

        public Order(String order) {
            int len = order.length();
            orderNum = new int[26];
            for (int i = 0; i < len; i++) {
                orderNum[order.charAt(i) - 'a'] = i + 1;
            }
        }

        public int get(char c) {
            return orderNum[c - 'a'];
        }
    }

    public boolean isAlienSorted(String[] words, String orderStr) {
        int len = words.length;
        Order order = new Order(orderStr);
        for (int i = 1; i < len; i++) {
            if (compare(order, words[i - 1], words[i]) > 0) return false;
        }
        return true;
    }

    private int compare(Order order, String a, String b) {
        if (a.equals(b)) return 0;
        int lena = a.length();
        int lenb = b.length();
        int t = Math.min(lena, lenb);

        int oa, ob;
        int i;
        for (i = 0; i < t; i++) {
            oa = order.get(a.charAt(i));
            ob = order.get(b.charAt(i));
            if (oa != ob) {
                return oa - ob;
            }
        }
        oa = i < lena ? order.get(a.charAt(i)) : 0;
        ob = i < lenb ? order.get(b.charAt(i)) : 0;
        return oa - ob;
    }
}
