package top.chenqwwq.leetcode.daily;

/**
 * @author chen
 * @date 2020/11/9
 **/
public class Test {
    public static void main(String[] args) {
        B b = new B();
        b.test();
    }
}


interface C {
    default void test() {
        System.out.println("干你娘");
    }


}

class B implements C {

}
