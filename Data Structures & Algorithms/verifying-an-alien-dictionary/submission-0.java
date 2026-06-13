class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];

        for(int i=0;i<order.length();i++){
            rank[order.charAt(i) - 'a'] = i;
        }

        for(int i=0;i<words.length-1;i++){
            if(!isOrder(words[i],words[i+1],rank)){
                return false;
            }
        }
        return true;
    }

    private boolean isOrder(String first,String second,int[] rank){
        int len = Math.min(first.length(),second.length());

        for (int i = 0; i < len; i++) {

            char c1 = first.charAt(i);
            char c2 = second.charAt(i);

            if (c1 != c2) {
                return rank[c1 - 'a'] < rank[c2 - 'a'];
            }
        }
        return second.length() >= first.length();
    }
}