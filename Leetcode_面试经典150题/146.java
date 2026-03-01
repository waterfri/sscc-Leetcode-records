// #146 LRU 缓存机制
// 

import java.util.HashMap;
import java.util.Map;

class LRUCache{

    private static class Node{
        Node prev;
        Node next;
        int key;
        int value;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        };
    }
    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node dummy_head;
    private final Node dummy_tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dummy_head = new Node(0, 0);
        this.dummy_tail = new Node(0, 0);
        dummy_head.next = dummy_tail; // 哑结点链接 防止 null
        dummy_tail.prev = dummy_head;
    }

    public int get(int key){

        Node node = map.get(key);
        if(node == null){
            return -1;
        }

        movetoHead(node);

        return node.value;

    }

    public void put(int key, int value){
        Node node = map.get(key);

        if(node == null){
            Node newnode = new Node(key, value);
            map.put(key, newnode);
            addtoHead(newnode);
        }
        else{
            node.value = value;
            movetoHead(node);
            return;
        }

        if(map.size() > capacity){
            Node tailnode = removeTail();
            map.remove(tailnode.key);
        }

    }

    // ===== 双向链表基本操作 =====
    public void addtoHead(Node node){
        node.prev = dummy_head;
        node.next = dummy_head.next;
        dummy_head.next.prev = node;
        dummy_head.next = node;
    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void movetoHead(Node node){
        removeNode(node);
        addtoHead(node);
    }

    public Node removeTail(){
        Node node = dummy_tail.prev;
        removeNode(node);
        return node;
    }
}