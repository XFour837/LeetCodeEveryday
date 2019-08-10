import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 许清远
 * @date 2019/8/1
 */
class LRUCache {

    private int capacity;
    private Cache cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new Cache(capacity);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        return cache.get(key);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    class Cache extends LinkedHashMap<Integer, Integer> {

        private Cache(int capacity) {
            super(capacity, 0.75f, true);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

}
