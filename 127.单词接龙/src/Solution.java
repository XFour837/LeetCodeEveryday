import java.util.*;
import java.util.stream.Collectors;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/16
 * Time: 14:06
 * Description:
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        Map<String, List<String>> graph = buildGraph(wordList);
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (str.equals(endWord)) return res;
                List<String> list = graph.get(str);
                for (String item : list) {
                    if (!visited.contains(item)) {
                        visited.add(item);
                        queue.add(item);
                    }
                }
            }
        }
        return 0;
    }

    private Map<String, List<String>> buildGraph(List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        wordList.forEach(word -> map.put(word, couldLadder(word, wordList)));
        return map;
    }

    private List<String> couldLadder(String word1, List<String> wordList) {
        return wordList.stream()
                .filter(word2 -> {
                    int diff = 0;
                    int length = word1.length();
                    for (int i = 0; i < length; i++) {
                        if (word1.charAt(i) != word2.charAt(i)) diff++;
                    }
                    return diff == 1;
                }).collect(Collectors.toList());
    }
}
