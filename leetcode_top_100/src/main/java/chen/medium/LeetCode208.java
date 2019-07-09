package chen.medium;

/**
 * 208. 字典树,前缀树
 *
 * @author chen
 * @date 19-5-4
 */
public class LeetCode208 {

    public static void main(String[] args) {
        final Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    static class Trie {
        static final char startChar = 'a';

        private TreeNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TreeNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            final char[] chars = word.toCharArray();
            final int length = chars.length;
            // 从根节点开始遍历
            TreeNode sign = root;
            int i = 0;
            // 循环遍历到节点不存在的时候
            while (i < length && sign.child[chars[i] - startChar] != null) {
                sign = sign.child[chars[i++] - startChar];
            }

            while (i < length) {
                sign.child[chars[i] - startChar] = new TreeNode();
                sign = sign.child[chars[i++] - startChar];
            }
            sign.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            // 查找
            final char[] chars = word.toCharArray();
            int i = 0, length = chars.length;
            TreeNode sign = root;
            while (i < length && sign.child[chars[i] - startChar] != null) {
                sign = sign.child[chars[i++] - startChar];
            }

            return i == length && sign.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            // 查找
            final char[] chars = prefix.toCharArray();
            int i = 0, length = chars.length;
            TreeNode sign = root;
            while (i < length && sign.child[chars[i] - startChar] != null) {
                sign = sign.child[chars[i++] - startChar];
            }
            return i == length;
        }

        class TreeNode {

            TreeNode[] child;
            Boolean isWord = false;

            TreeNode() {
                child = new TreeNode[26];
            }
        }
    }
}
