package chen.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * DFS+回溯 类似于全排列
 *
 * @author bingxin.chen
 * @date 2019/4/26 13:08
 */
public class LeetCode17 {

    public static void main(String[] args) {
        new Solution().letterCombinations("23");
    }
    static class Solution {
        /**
         * 数字到字母的映射
         */
        private static final HashMap<Character, Character[]> numberAndLetterMap = new HashMap<>(8);

        static {
                numberAndLetterMap.put('2', new Character[]{'a', 'b', 'c'});
                numberAndLetterMap.put('3', new Character[]{'d', 'e', 'f'});
                numberAndLetterMap.put('4', new Character[]{'g', 'h', 'i'});
                numberAndLetterMap.put('5', new Character[]{'j', 'k', 'l'});
                numberAndLetterMap.put('6', new Character[]{'m', 'n', 'o'});
                numberAndLetterMap.put('7', new Character[]{'p', 'q', 'r', 's'});
                numberAndLetterMap.put('8', new Character[]{'t', 'u', 'v'});
                numberAndLetterMap.put('9', new Character[]{'w', 'x', 'y', 'z'});
        }

        /**
         * 运行结果
         */
        private List<String> res = new ArrayList<>(16);

        public List<String> letterCombinations(String digits) {
            if(digits == null || digits.length() == 0){
                return res;
            }
            dfs(new ArrayList<>(),digits.toCharArray(),0);
            return res;
        }

        public void dfs(List<Character> curr, char[] digitChar, int i) {
            if (curr.size() == digitChar.length) {
                res.add(list2String(curr));
                return;
            }

            for (; i < digitChar.length; i++) {
                final Character[] characters = numberAndLetterMap.get(digitChar[i]);
                for (int j = 0; j < characters.length; j++) {
                    curr.add(characters[j]);
                    dfs(curr, digitChar, i + 1);
                    curr.remove(curr.size() - 1);
                }
            }
        }

        public String list2String(List<Character> list) {
            StringBuilder string = new StringBuilder();
            for (Character c : list) {
                string.append(c);
            }
            return string.toString();
        }
    }
}
