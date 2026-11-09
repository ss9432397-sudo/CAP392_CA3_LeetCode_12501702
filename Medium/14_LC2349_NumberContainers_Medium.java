import java.util.*;

class NumberContainers {
    Map<Integer, Integer> indexMap = new HashMap<>();
    Map<Integer, TreeSet<Integer>> numberMap = new HashMap<>();

    public void change(int index, int number) {
        if (indexMap.containsKey(index)) {
            int old = indexMap.get(index);
            numberMap.get(old).remove(index);
        }

        indexMap.put(index, number);
        numberMap.putIfAbsent(number, new TreeSet<>());
        numberMap.get(number).add(index);
    }

    public int find(int number) {
        if (!numberMap.containsKey(number) ||
            numberMap.get(number).isEmpty())
            return -1;

        return numberMap.get(number).first();
    }
}
