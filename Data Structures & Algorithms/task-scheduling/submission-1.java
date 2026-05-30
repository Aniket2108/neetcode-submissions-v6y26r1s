class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(int i=0;i<tasks.length;i++){
            freq[tasks[i] - 'A']++;
        }

        PriorityQueue<Task> pq = new PriorityQueue<>((a,b) -> b.count - a.count);

        for(int i=0;i<26;i++){
            if(freq[i] > 0)
            pq.offer(new Task(freq[i],0));
        }

        Queue<Task> q = new LinkedList<>();
        int time = 0;

        while(!pq.isEmpty() || !q.isEmpty()){
            while(!q.isEmpty() && time-q.peek().time > n){
                pq.offer(q.poll());
            }
            if(!pq.isEmpty()){
                Task t = pq.poll();
                t.count--;
                t.time = time;
                if(t.count > 0){
                    q.offer(t);
                }
            }
            time++;
        }
        return time;
    }

    class Task{
        int count;
        int time;

        public Task(int count,int time){
            this.count = count;
            this.time = time;
        }
    }
}
