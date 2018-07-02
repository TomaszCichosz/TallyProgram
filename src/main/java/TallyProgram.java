import java.util.*;

public class TallyProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        char[] gameCourse = scanner.nextLine().toCharArray();

        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("a", 0);
        treeMap.put("b", 0);
        treeMap.put("c", 0);
        treeMap.put("d", 0);
        treeMap.put("e", 0);

        for (char score : gameCourse) {
            if (Character.isLowerCase(score)) {
                treeMap.put(String.valueOf(score), treeMap.get(String.valueOf(score)) + 1);
            } else
                treeMap.put(String.valueOf(score).toLowerCase(), treeMap.get(String.valueOf(score).toLowerCase()) - 1);
        }

        Set<Player> sortedSet = new TreeSet<>(new ScoreComparator());
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            sortedSet.add(new Player(entry.getKey(), entry.getValue()));
        }
        for (Player player : sortedSet) {
            stringBuilder.append(player.getName()).append(":").append(player.getScore()).append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder);

        /*for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            stringBuilder.append(entry.getKey()).append(":").append(entry.getValue()).append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder);*/
    }

    static class ScoreComparator implements Comparator<Player> {

        @Override
        public int compare(Player firstPlayer, Player secondPlayer) {
            //return Integer.compare(firstPlayer.getScore(), secondPlayer.getScore()); to nie działa, bo znikają równe sobie elementy
            switch (Integer.compare(firstPlayer.getScore(), secondPlayer.getScore())) {
                case 1:
                    return -1;
                case -1:
                    return 1;
            }
            return 1;
        }
    }
}

