import java.util.HashMap;

class LRUCache {

    private final int MAX_SIZE;
    private int currSize;
    private HashMap<Integer, ListNode> map;
    /**
     * Most Recent Used
     */
    private ListNode mru;
    /**
     * Least Recently Used
     */
    private ListNode lru;

    private class ListNode {
        public ListNode prev;
        public ListNode next;
        public int value;
        public int key;
    }

    public static void main(String[] args) {
//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 1); // cache is {1=1}
//        lRUCache.put(2, 2); // cache is {1=1, 2=2}
//        System.out.println(lRUCache.get(1));    // return 1
//        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//        System.out.println(lRUCache.get(2));    // returns -1 (not found)
//        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//        System.out.println(lRUCache.get(1));    // return -1 (not found)
//        System.out.println(lRUCache.get(3));    // return 3
//        System.out.println(lRUCache.get(4));    // return 4

        // ["LRUCache","get","get","put","get","put","put","put","put","get","put"]
        // [[1],[6],[8],[12,1],[2],[15,11],[5,2],[1,15],[4,2],[4],[15,15]]
//        LRUCache lruCache = new LRUCache(1);
//        lruCache.get(1);
//        lruCache.get(6);
//        lruCache.get(8);
//        lruCache.put(12,1);
//        lruCache.get(2);
//        lruCache.put(15,11);
//        lruCache.put(5,2);
//        lruCache.put(1,15);
//        lruCache.put(4,2);
//        lruCache.get(4);
//        lruCache.put(15,15);

//        ["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
//        [[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
//        LRUCache lruCache = new LRUCache(3);
//        lruCache.put(1,1);
//        lruCache.put(2,2);
//        lruCache.put(3,3);
//        lruCache.put(4,4);
//        lruCache.get(4);
//        lruCache.get(3);
//        lruCache.get(2);
//        lruCache.get(1);
//        lruCache.put(5,5);
//        lruCache.get(1);
//        lruCache.get(2);
//        lruCache.get(3);
//        lruCache.get(4);
//        lruCache.get(5);


        // ["LRUCache","put","get","put","get","get"]
        // [[1],[2,1],[2],[3,2],[2],[3]]
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2,1);
        lruCache.get(2);
        lruCache.put(3,2);
        lruCache.get(2);
        lruCache.get(3);


    }

    public LRUCache(int capacity) {
        MAX_SIZE = capacity;
        currSize = 0;
        map = new HashMap<>();
    }

    public int get(int key) {
        // given Int, lookup map and return Node
        // update the Node to MR

        if (map.containsKey(key)) {
            // key is mru (Beg of LL)
            if (map.get(key).equals(mru)) {
                return map.get(key).value;
            }
            // key is lru (End of LL)
            else if (map.get(key).equals(lru)) {
                ListNode temp = new ListNode();
                temp.key = key;
                temp.value = map.get(key).value;

                // drop current LRU
                lru.prev.next = null;
                lru = lru.prev;
                if (lru != null) {
                    lru.next = null;
                }

                // create new MRU
                mru.prev = temp;
                temp.next = mru;
                mru = temp;

                // update map
                map.remove(key);
                map.put(key, temp);

                return temp.value;
            }

            // node is in middle of the list
            else {
                ListNode temp = new ListNode();
                temp.key = key;
                temp.value = map.get(key).value;

                // reroute prev pointer to next el
                ListNode prev = map.get(key).prev;
                prev.next = map.get(key).next;

                // reroute pointer of next to previous of current
                ListNode next = map.get(key).next;
                next.prev = map.get(key).prev;

                // create new MRU
                mru.prev = temp;
                temp.next = mru;
                mru = temp;

                // update map
                map.remove(key);
                map.put(key, temp);
                return temp.value;
            }
        }
        return -1;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            // key is mru (Beg of LL)
            if (map.get(key).equals(mru)) {
                mru.value = value;
                return;
            }

            // key is lru (End of LL)
            else if (map.get(key).equals(lru)) {
                // drop current LRU
                lru = lru.prev;
                if (lru != null) {
                    lru.next = null;
                }

                // create new MRU
                ListNode temp = new ListNode();
                temp.key = key;
                temp.value = value;
                mru.prev = temp;
                temp.next = mru;
                mru = temp;

                // update map
                map.remove(key);
                map.put(key, temp);
                return;
            }

            // key node is in middle of the list
            else {
                // reroute prev pointer to next el
                ListNode prev = map.get(key).prev;
                prev.next = map.get(key).next;

                // create new MRU
                ListNode temp = new ListNode();
                temp.key = key;
                temp.value = value;
                mru.prev = temp;
                temp.next = mru;
                mru = temp;

                // update map
                map.remove(key);
                map.put(key, temp);
                return;
            }
        }
        else {
            // key is new
            if(currSize == MAX_SIZE) {
                // drop LRU
                map.remove(lru.key);
                lru = lru.prev;
                if (lru != null) {
                    lru.next = null;
                }

                // create new MRU
                ListNode temp = new ListNode();
                temp.key = key;
                temp.value = value;
                mru.prev = temp;
                temp.next = mru;
                mru = temp;
                map.put(key, temp);
                if (map.size() == 1) {
                    lru = mru;
                }
            }
            else {
                // create new MRU
                ListNode temp = new ListNode();
                temp.key = key;
                temp.value = value;
                if (mru != null)
                    mru.prev = temp;
                temp.next = mru;
                mru = temp;
                map.put(key, temp);

                if (currSize == 0) {
                    lru = mru;
                }
                currSize++;
            }
        }


    }
}