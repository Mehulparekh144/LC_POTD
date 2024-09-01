class Node {
    int key;
    int val;
    Node prev;
    Node next;
    int freq;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
    }
}

class DLL {
    Node head;
    Node tail;
    int size;

    public DLL() {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.size = 0;
    }

    public void insertAtHead(Node node) {
        node.next = this.head.next;
        node.prev = this.head;

        this.head.next.prev = node;
        this.head.next = node;
        size++;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public Node removeAtTail() {
        if (size == 0) return null;
        Node node = tail.prev;
        removeNode(node);
        return node;
    }
}

class LFUCache {
    // Frequency vs DLL of nodes with that frequency
    Map<Integer, DLL> freqMap;
    // Key vs Node
    Map<Integer, Node> map;
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        freqMap = new HashMap<>();
        map = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        updateCache(node, node.val); // Updates frequency and cache
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (map.containsKey(key)) {
            updateCache(map.get(key), value);
        } else {
            if (map.size() == capacity) {
                // Remove the least frequent node
                Node nodeToRemove = freqMap.get(minFreq).removeAtTail();
                map.remove(nodeToRemove.key);
            }

            Node newNode = new Node(key, value);
            freqMap.computeIfAbsent(1, k -> new DLL()).insertAtHead(newNode);
            map.put(key, newNode);
            minFreq = 1; // Reset minFreq to 1 since we added a new node with freq 1
        }
    }

    private void updateCache(Node node, int val) {
        int prevFreq = node.freq;
        node.freq++;
        node.val = val; // Update value

        // Remove node from the current frequency list
        freqMap.get(prevFreq).removeNode(node);
        if (freqMap.get(prevFreq).size == 0) {
            freqMap.remove(prevFreq);
            if (prevFreq == minFreq) {
                minFreq++;
            }
        }

        // Add node to the new frequency list
        freqMap.computeIfAbsent(node.freq, k -> new DLL()).insertAtHead(node);
    }
}
