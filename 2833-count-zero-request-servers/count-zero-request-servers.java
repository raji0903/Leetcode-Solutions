
import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        // Sort logs based on time
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int m = queries.length;

        // Store query and original index
        int[][] q = new int[m][2];

        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        // Sort queries based on time
        Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[m];

        // Track frequency of each server
        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        for (int[] query : q) {

            int time = query[0];
            int index = query[1];

            int start = time - x;

            // Add logs within the right boundary
            while (right < logs.length &&
                   logs[right][1] <= time) {

                int server = logs[right][0];

                map.put(server, map.getOrDefault(server, 0) + 1);

                right++;
            }

            // Remove logs outside the left boundary
            while (left < right &&
                   logs[left][1] < start) {

                int server = logs[left][0];

                map.put(server, map.get(server) - 1);

                if (map.get(server) == 0) {
                    map.remove(server);
                }

                left++;
            }

            // Servers without requests
            ans[index] = n - map.size();
        }

        return ans;
    }
}
