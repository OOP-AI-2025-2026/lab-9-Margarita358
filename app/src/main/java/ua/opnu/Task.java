package ua.opnu;

import java.util.*;

public class Task {

    public static void main(String[] args) {
    }

    // 1
    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            String a = list.get(i);
            String b = list.get(i + 1);

            if (a.length() <= b.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
            i--;
        }
    }

    // 2
    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            list.add(i, list.get(i));
        }
    }

    // 3
    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    // 4
    public void removeDuplicates(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i);
                i--;
            }
        }
    }

    // 5
    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    // 6
    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue.isEmpty()) return true;

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int value = queue.remove();
            stack.push(value);
            queue.add(value);
        }

        boolean result = true;

        for (int i = 0; i < size; i++) {
            int value = queue.remove();
            if (value != stack.pop()) {
                result = false;
            }
            queue.add(value);
        }

        return result;
    }

    // 7 (исправленная версия)
    public void reorder(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int value = queue.remove();
            if (value < 0) {
                stack.push(value);
            } else {
                queue.add(value);
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    // 8
    public void rearrange(Queue<Integer> queue) {
        ArrayDeque<Integer> odds = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int value = queue.remove();
            if (value % 2 == 0) {
                queue.add(value);
            } else {
                odds.add(value);
            }
        }

        while (!odds.isEmpty()) {
            queue.add(odds.remove());
        }
    }

    // 9
    public int maxLength(Set<String> set) {
        int max = 0;
        for (String s : set) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    // 10
    public void removeEvenLength(Set<String> set) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (it.next().length() % 2 == 0) {
                it.remove();
            }
        }
    }

    // 11
    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set = new HashSet<>(list1);
        set.retainAll(new HashSet<>(list2));
        return set.size();
    }

    // 12
    public boolean isUnique(Map<String, String> map) {
        Set<String> values = new HashSet<>(map.values());
        return values.size() == map.size();
    }
    // 13
    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        for (String key : map1.keySet()) {
            if (map2.containsKey(key) && map1.get(key).equals(map2.get(key))) {
                result.put(key, map1.get(key));
            }
        }
        return result;
    }

    // 14
    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }

    // 15
    public int rarest(Map<String, Integer> map) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int value : map.values()) {
            freq.put(value, freq.getOrDefault(value, 0) + 1);
        }

        int minCount = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();

            if (count < minCount || (count == minCount && value < result)) {
                minCount = count;
                result = value;
            }
        }

        return result;
    }

    // 16
    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) return 0;

        Map<Integer, Integer> freq = new HashMap<>();
        int max = 0;

        for (int value : list) {
            int count = freq.getOrDefault(value, 0) + 1;
            freq.put(value, count);
            if (count > max) {
                max = count;
            }
        }

        return max;
    }
}