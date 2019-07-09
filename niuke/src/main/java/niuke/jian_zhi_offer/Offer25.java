package niuke.jian_zhi_offer;


/**
 * @author CheNbXxx
 * @description 复杂链表的复制，说实话一开始我没看懂这道题目。。。
 * 后面才看懂，一个链表的复制简单，主要就是random的复制
 * @email chenbxxx@gmail.con
 * @date 2019/2/13 10:42
 */
public class Offer25 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public class Solution {
        public RandomListNode Clone(RandomListNode pHead) {
            if (pHead == null) {
                return null;
            }
            RandomListNode head = new RandomListNode(pHead.label),
                    srcIndex = pHead,
                    index = head;
            // 首先先复制原始链表，不考虑random
            while (srcIndex.next != null) {
                index = index.next = new RandomListNode((srcIndex = srcIndex.next).label);
            }
            // 以上都没问题，主要就是random节点的复制
            // 复原遍历标记
            index = head;
            srcIndex = pHead;
            // 根据random节点和头节点的间隔复制
            while (srcIndex != null) {
                if (srcIndex.random == null) {
                    index.random = null;
                } else {
                    // 获取原节点random到head的距离,并根据距离获取在复制后的链表中的位置
                    index.random = getIndexNode(getIntervalBehindHead(pHead, srcIndex.random), head);
                }
                srcIndex = srcIndex.next;
                index = index.next;
            }
            return head;
        }

        private RandomListNode getIndexNode(int interval, RandomListNode head) {
            while (interval-- > 0) {
                head = head.next;
                if (head == null) {
                    return null;
                }
            }
            return head;
        }

        private int getIntervalBehindHead(RandomListNode head, RandomListNode src) {
            int i = 0;
            while (head != null) {
                if (head == src) {
                    return i;
                }
                i++;
                head = head.next;
            }
            return -1;
        }
    }
}
