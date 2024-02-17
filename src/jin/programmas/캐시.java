package jin.programmas;

// 2018 KAKAO BLIND RECRUITMENT [1차] 캐시

import java.util.*;

public class 캐시 {
    // 캐시저장 -> Map<String, Node>
    // String.toLowerCase()
    // 추가조건
    // 1. 있으면(containsKey) -> addHeadNode() -> return 캐시 히트
    // 2. 없으면 -> addHeadNode() -> return 캐시 미스
    // 2-1. 캐시공간이 꽉찼다면 -> removeTail() -> addHeadNode() -> return 캐시 미스
    // 2-2. 캐시공간 여유 있다면 -> addHeadNode() -> return 캐시 미스
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        LRUCache cache = new LRUCache(cacheSize);

        for (String city : cities) {
            answer += cache.getTime(city) ;
        }

        return answer;
    }

    static class LRUCache {

        final int CACHE_HIT = 1;
        final int CACHE_MISS = 5;
        int cacheSize;
        Map<String, Node> map;
        Node head;
        Node tail;

        public LRUCache (int cacheSize) {
            this.cacheSize = cacheSize;
            map = new HashMap<>();
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        static class Node {
            Node next, prev;
            String key;
        }

        public int getTime(String key) {
            if (cacheSize == 0) return CACHE_MISS;
            key = key.toLowerCase();

            if (map.containsKey(key)) {
                Node node = map.get(key);
                removeNode(node);
                addHead(node);

                return CACHE_HIT;
            }

            if (map.size() == cacheSize) {
                Node node = tail.prev;
                map.remove(node.key);
                removeNode(node);
            }

            Node node = new Node();
            node.key = key;
            map.put(key, node);
            addHead(node);

            return CACHE_MISS;
        }

        private void addHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
}
