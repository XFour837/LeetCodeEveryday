import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Create with LeetCodeEveryday
 * User: 许清远
 * Date: 2020/4/5
 * Time: 14:04
 * Description:
 */
class LFUCache {

    private int capacity;
    private int version;
    private Map<Integer,Node> cache;
    private PriorityQueue<Node> queue;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.version = 0;
        if (capacity > 0) {
            this.cache = new HashMap<>(capacity);
            this.queue = new PriorityQueue<>(capacity);
        }
    }

    public int get(int key) {
        if (capacity <= 0) {
            return -1;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.visitedNumber++;
            node.version = version++;
            queue.remove(node);
            queue.offer(node);
            return node.v;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.visitedNumber++;
            node.version = version++;
            node.v = value;
            queue.remove(node);
            queue.offer(node);
        } else {
            Node node = new Node();
            node.k = key;
            node.v = value;
            node.version = version++;
            node.visitedNumber = 1;
            if (queue.size() == capacity) {
                Node poll = queue.poll();
                cache.remove(poll.k);
            }
            queue.offer(node);
            cache.put(key, node);
        }
    }
}

class Node implements Comparable<Node>{

    int k;
    int v;
    int version;
    int visitedNumber;

    @Override
    public int compareTo(Node node) {
        int diff = this.visitedNumber - node.visitedNumber;
        return diff != 0 ? diff : this.version - node.version;
    }
}
