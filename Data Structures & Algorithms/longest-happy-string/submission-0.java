class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> y.freq - x.freq);
        if(a != 0) pq.offer(new Pair('a',a));
        if(b != 0) pq.offer(new Pair('b',b));
        if(c != 0) pq.offer(new Pair('c',c));
        StringBuilder res = new StringBuilder();

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int len = res.length();
            if(len >= 2 && res.charAt(len-1) == p.ch && res.charAt(len-2) == p.ch){
                if(pq.isEmpty()) break;
                Pair p2 = pq.poll();
                res.append(p2.ch);
                p2.freq--;
                if(p2.freq > 0) pq.offer(p2);
                pq.offer(p);
            }
            else{
                res.append(p.ch);
                p.freq--;
                if(p.freq > 0){
                    pq.offer(p);
                }
            }
        }
        return res.toString();
    }


    class Pair{
        char ch;
        int freq;

        public Pair(char ch,int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
}