class Twitter {

    private static int timeStamp = 0;
    private Map<Integer,List<Tweet>> tweets;
    private Map<Integer,Set<Integer>> follows;

    public Twitter() {
        tweets = new HashMap<>();
        follows = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId,new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId,timeStamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b) -> b.time - a.time);
        if(tweets.containsKey(userId)){
            pq.addAll(tweets.get(userId));
        }

        if (follows.containsKey(userId)) {
            for (int followee : follows.get(userId)) {
                if (tweets.containsKey(followee)) {
                    pq.addAll(tweets.get(followee));
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        int count = 0;

        while(!pq.isEmpty() && count < 10){
            res.add(pq.poll().id);
            count++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        follows.putIfAbsent(followerId,new HashSet<>());
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follows.containsKey(followerId))
        follows.get(followerId).remove(followeeId);
    }

    class Tweet{
        int id;
        int time;

        public Tweet(int id,int time){
            this.id = id;
            this.time = time;
        }
    }
}
