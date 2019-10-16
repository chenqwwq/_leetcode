package top.chenbxxx.by_topics.array;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bingxin.chen
 * @date 2019/10/16 09:57
 */
public class Test {

    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws ParseException {
        System.out.println(format.format(new Date(Long.parseLong("1571055956000"))));
    }
}
