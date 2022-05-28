package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class temp {

    public static void main(String[] args) {
        Map<String, String[]> paramMap = new HashMap<>();
        paramMap.put("A", new String[] { "A", "AA", "AAA" });
        paramMap.put("B", new String[] { "B", "BB", "BBB" });
        paramMap.put("C", new String[] { "C", "CC", "CCC" });
        paramMap.put("D", new String[] { "D", "DD", "DDD" });

        for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
            List<String> values = new ArrayList<>();
            for (String value : entry.getValue()) {
                // value = StringEscapeUtils.escapeSql(value);
                values.add(value + "_");
            }
            paramMap.put(entry.getKey(), values.toArray(new String[0]));
        }

        System.out.println(paramMap);

    }

}
