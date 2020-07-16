import java.util.HashMap;
import java.util.Map;

public class _146_Solution {
    public class LRUCache {
        private class Node {
            int key, value;
            Node pre, next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }

            Node() {
                this(0, 0);
            }
        }

        int capacity, count;
        Map<Integer, Node> map;
        Node head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.count = 0;
            map = new HashMap<Integer, Node>();
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            Node node = map.get(key);
            update(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);

            if (node == null) {
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                add(newNode);
                count++;
            } else {
                node.value = value;
                update(node);
            }

            if (count > capacity) {
                Node delNode = tail.pre;
                remove(delNode);
                map.remove(delNode.key);
                --count;
            }
        }

        public void update(Node node) {
            remove(node);
            add(node);
        }

        public void remove(Node node) {
            Node preNode = node.pre;
            Node nextNode = node.next;
            preNode.next = nextNode;
            nextNode.pre = preNode;
        }

        public void add(Node node) {
            Node after = head.next;
            head.next = node;
            node.pre = head;
            node.next = after;
            after.pre = node;
        }
    }
}
