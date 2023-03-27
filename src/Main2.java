import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main2 {
    /*
    Напишите метод сортировки массива строк, при котором анаграммы группируются друг за другом
    */

    public static void main(String[] args) {
        String[] strings = {"acre", "keen", "race", "care", "heart", "part", "earth", "trap", "knee"};
        sort(strings);
        System.out.println(Arrays.toString(strings));
    }

    public static void sort(String[] strings) {
        HashMap<String, ArrayList<String>> hashmap = new HashMap<>();
        for (String s : strings) { // O(n)
            String sorted = sortChars(s);
            var list = hashmap.getOrDefault(sorted, new ArrayList<>()); // O(1)
            list.add(s);
            hashmap.put(sorted, list);
        }

        int index = 0;
        for (String key: hashmap.keySet()) {
            var list = hashmap.get(key);
            for (String s: list) {
                strings[index] = s;
                index++;
            }
        }
    }

    public static String sortChars(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
