class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        int len = wordList.size();
        q.offer(new Pair(beginWord,1));
        
        for(int i=0;i<len;i++){
            set.add(wordList.get(i));
        }

        while(!q.isEmpty()){
            String word = q.peek().word;
            int step = q.peek().step;
            q.poll();

            if(word.equals(endWord)) return step;

            for(int i=0;i<word.length();i++){
                for(char c='a';c<='z';c++){
                    char[] replacedArray = word.toCharArray();
                    replacedArray[i] = c;
                    String replacedString = new String(replacedArray);
                    if(set.contains(replacedString)){
                        set.remove(replacedString);
                        q.offer(new Pair(replacedString,step+1));
                    }
                }
            }
        }
        return 0;
    }

    public class Pair{
        String word;
        int step;

        public Pair(String word,int step){
            this.word = word;
            this.step = step;
        }
    }
}