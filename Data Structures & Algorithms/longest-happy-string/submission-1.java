class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y) -> y.freq - x.freq);
        StringBuilder res = new StringBuilder();

        if(a != 0) pq.offer(new Tuple('a',a));
        if(b != 0) pq.offer(new Tuple('b',b));
        if(c != 0) pq.offer(new Tuple('c',c));

        while(!pq.isEmpty()){
            Tuple t1 = pq.poll();
            int len = res.length();
            if(len > 1 && res.charAt(len-1) == t1.ch && res.charAt(len-2) == t1.ch){
                if(pq.isEmpty()) break;
                Tuple t2 = pq.poll();
                res.append(t2.ch);
                t2.freq--;
                pq.offer(t1);
                if(t2.freq > 0){
                    pq.offer(t2);
                }
            }
            else{
                res.append(t1.ch);
                t1.freq--;
                if(t1.freq > 0){
                    pq.offer(t1);
                }
            }
        }
        return res.toString();
    }

    class Tuple{
        char ch;
        int freq;
    public Tuple(char ch,int freq){
        this.ch = ch;
        this.freq = freq;
    }
    }

}