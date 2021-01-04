package day05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 有下列字符串:
 * 销售:张三;财务:李四;销售:王五;财务:赵六;程序:mike;程序:jerry;美工:jackson;前端:green;前端:nick;程序:钱七;销售:alice
 * 分析上述字符串然后统计每个职位总共多少人?
 * 使用Map保存统计的结果，其中key:职位,value为该职位人数
 * 然后分别输出各职位的名称(keySet),各职位人数(entrySet)
 *
 * @author Bonnie
 */
public class Test05 {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>(20);
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        String[] strs = string.split(";");
        for (int i = 0; i < strs.length; i++) {
            String[] strings = strs[i].split(":");
            if (!hashMap.containsKey(strings[0])) {
                hashMap.put(strings[0], 1);
            } else {
                hashMap.replace(strings[0],hashMap.get(strings[0])+1);
            }
        }
        for (String str:hashMap.keySet()){
            System.out.println(str);
        }
        for (Map.Entry<String,Integer> entry : hashMap.entrySet()){
            System.out.println(entry);
        }
    }
}
