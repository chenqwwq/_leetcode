package top.chenqwwq;

public class Solution {
    public boolean isMatch(String s, String p) {
        // s 是真实串，p 是模式串
        return isMatch(s.toCharArray(), p.toCharArray(), 0, 0);

    }

    public boolean isMatch(char[] s, char[] p, int a, int b) {
        if (isEmpty(p, b)) {
            return isEmpty(s, a);
        }

        // 首字母是否匹配
        final boolean match = isEmpty(s, a) && (s[a] == p[b] || p[a] == '.');
        if (match) {
            if (p.length == b + 1) {
                return s.length == a + 1;
            }
            if (p[a + 1] != '*') {
                return isMatch(s, p, a + 1, b + 1);
            }
            // 考虑后面是*  aaa a*a
            return isMatch(s, p, a + 1, b) || isMatch(s, p, a, b + 2);
        } else if (p.length - b > 1 && p[b + 1] == '*') {
            return isMatch(s, p, a, b + 2);
        }
        return false;
    }

    public boolean isEmpty(char[] c, int l) {
        return c.length == l;
    }
}
