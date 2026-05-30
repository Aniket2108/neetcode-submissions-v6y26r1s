class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(int i=0;i<tasks.length;i++){
            freq[tasks[i] - 'A']++;
        }

        int maxFreq = -1;

        for(int i:freq){
            maxFreq = Math.max(i,maxFreq);
        }

        int countMax = 0;

        
        for(int i:freq){
            if(i == maxFreq) countMax++;
        }

        return Math.max(tasks.length,((maxFreq - 1) * (n + 1) + countMax));
    }
}
