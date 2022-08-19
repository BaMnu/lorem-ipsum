import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        String loremIpsumNoSpace = loremIpsum.replace(" ", "").toLowerCase();

        for (int i = 0; i < loremIpsumNoSpace.length(); i++) {
            Character c = loremIpsumNoSpace.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, ++count);
            } else {
                map.put(c, 1);
            }
        }

        int max = -1;
        char maxChar = ' ';

        for (Map.Entry<Character, Integer> i : map.entrySet()) {
            if (Integer.parseInt(i.getValue().toString()) > max) {
                max = Integer.parseInt(i.getValue().toString());
                if (map.containsValue(max)) {
                    maxChar = i.getKey();
                }
            }
        }

        System.out.println("The most common character: [" + maxChar + "] - repeats: "
                + Collections.max(map.values()) + " times");

        int min = Integer.MAX_VALUE;
        char minChar = ' ';

        for (Map.Entry<Character, Integer> j : map.entrySet()) {
            if (Integer.parseInt(j.getValue().toString()) < min) {
                min = Integer.parseInt(j.getValue().toString());
                if (map.containsValue(min)) {
                    minChar = j.getKey();
                }
            }
        }

        System.out.println("The least common character: [" + minChar + "] - repeats: "
                + Collections.min(map.values()) + " times");
    }

    static String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim " +
            "ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
            "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate " +
            "velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat " +
            "cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

}