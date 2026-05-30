class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        int n = s.length();

        for(int i=0;i<n;i++){
            freq[s.charAt(i) - 'a']++;
        }

        int maxFreq = Integer.MIN_VALUE;

        for(int i:freq){
            maxFreq = Math.max(maxFreq,i);
        }

        if(maxFreq > (n+1)/2) return "";

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);

        for(int i=0;i<26;i++){
            if(freq[i] > 0){
                pq.offer(new Tuple(freq[i],(char)('a' + i)));
            }
        }

        StringBuilder sb = new StringBuilder();

        while(pq.size() > 1){
            Tuple first = pq.poll();
            Tuple second = pq.poll();
            sb.append(first.ch);
            sb.append(second.ch);
            first.freq--;
            second.freq--;
            if(first.freq > 0) pq.offer(first);
            if(second.freq > 0) pq.offer(second);
        }

        if(!pq.isEmpty()){
            sb.append(pq.poll().ch);
        }
        return sb.toString();
    }

    class Tuple{
        int freq;
        char ch;

        public Tuple(int freq,char ch){
            this.freq = freq;
            this.ch = ch;
        }
    }
}