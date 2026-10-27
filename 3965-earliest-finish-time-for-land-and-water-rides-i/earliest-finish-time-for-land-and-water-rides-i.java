class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int minFinishTime = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Case 1: Land ride -> Water ride
                int landFinish1 = landStartTime[i] + landDuration[i];
                int waterStart1 = Math.max(waterStartTime[j], landFinish1);
                int waterFinish1 = waterStart1 + waterDuration[j];
                minFinishTime = Math.min(minFinishTime, waterFinish1);

                // Case 2: Water ride -> Land ride
                int waterFinish2 = waterStartTime[j] + waterDuration[j];
                int landStart2 = Math.max(landStartTime[i], waterFinish2);
                int landFinish2 = landStart2 + landDuration[i];
                minFinishTime = Math.min(minFinishTime, landFinish2);
            }
        }

        return minFinishTime;
    }
}