class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count frequency of each word
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        
        // Step 2: Use a priority queue (min-heap)
        PriorityQueue<String> minHeap = new PriorityQueue<>((w1, w2) -> {
            int freq1 = countMap.get(w1);
            int freq2 = countMap.get(w2);
            if (freq1 != freq2) {
                return freq1 - freq2; // Smaller frequency has higher priority to be removed
            }
            return w2.compareTo(w1); // Lexicographically larger comes first to be removed (so smaller stays)
        });
        
        // Step 3: Keep top k elements in the heap
        for (String word : countMap.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // Step 4: Extract from heap and reverse to get highest frequency first
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.reverse(result);
        
        return result;
    }
}