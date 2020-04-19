package top.chenqwwq.currently.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chen
 * @date 2020/4/18 下午5:38
 */
public class ListUtils {

    public static <E> List<List<E>> getList(E[][] arr) {
        ArrayList<List<E>> lists = new ArrayList<>();
        for (E[] ar : arr) {
            ArrayList<E> list = new ArrayList<>();
            Collections.addAll(list, ar);
            lists.add(list);
        }
        return lists;
    }

}
