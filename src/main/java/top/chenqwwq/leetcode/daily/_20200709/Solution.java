package top.chenqwwq.leetcode.daily._20200709;

/**
 * 面试题 17.13. 恢复空格
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"
 * 已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。
 * 当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 * <p>
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 * <p>
 * 提示：
 * <p>
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 *
 * @author chen
 * @date 2020-07-09
 **/
public class Solution {
    public int respace(String[] dictionary, String sentence) {
        // 异常情况
        if (dictionary == null || dictionary.length == 0) {
            return sentence.length();
        }
        if (sentence == null || sentence.length() == 0) {
            return 0;
        }

        // 因为涉及到搜索,直接采用前缀树
        // 构造前缀树
        Trie root = new Trie();
        for (String s : dictionary) {
            root.insert(s);
        }

        // dp[i]表示0~i最少的空闲字符
        // dp[i]可以往前遍历
        int[] dp = new int[sentence.length() + 1];
        dp[0] = 0;


        for (int i = 1; i <= sentence.length(); i++) {
            dp[i] = dp[i - 1] + 1;
            Trie curr = root;
            for (int j = i; j >= 1; j--) {
                int idx = sentence.charAt(j - 1) - 'a';
                // 遍历字典树
                if (curr.child[idx] == null) {
                    break;
                }
                if (curr.child[idx].isEnd) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                // 完全匹配的时候直接退出
                if (dp[i] == 0) {
                    break;
                }
                curr = curr.child[idx];
            }
        }
        return dp[sentence.length()];
    }

    class Trie {
        Trie[] child;

        boolean isEnd;

        public Trie() {
            this.child = new Trie[26];
            this.isEnd = false;
        }

        public Trie(boolean isEnd) {
            this.child = new Trie[26];
            this.isEnd = isEnd;
        }

        public void insert(String s) {
            if (s == null || s.length() == 0) {
                return;
            }
            Trie trie = this;
            final char[] chars = s.toCharArray();
            for (char aChar : chars) {
                int index = aChar - 'a';
                if (trie.child[index] == null) {
                    trie.child[index] = new Trie();
                }
                trie = trie.child[index];
            }
            trie.isEnd = true;
        }
    }
}
