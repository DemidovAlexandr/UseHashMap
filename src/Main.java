import java.util.*;

public class Main {
    /*
    Напишите метод сортировки массива строк, при котором анаграммы группируются друг за другом
    */

    public static void main(String[] args) {
        String[] strings = {"acre", "keen", "race", "care", "heart", "part", "earth", "trap", "knee"};
        Arrays.sort(strings, new AnagramComparator()); // O(n log(n))
        System.out.println(Arrays.toString(strings));
    }

    public static class AnagramComparator implements Comparator<String> {
        public String sortChars(String s) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }

        @Override
        public int compare(String s1, String s2) {
            return sortChars(s1).compareTo(sortChars(s2));
        }
    }
}