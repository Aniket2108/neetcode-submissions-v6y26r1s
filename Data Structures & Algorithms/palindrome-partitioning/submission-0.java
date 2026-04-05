class Solution {
    List<List<String>> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(0,s,new ArrayList<>());
        return list;
    }

    public void dfs(int start,String s,List<String> tmp){
        if(start == s.length()){
            list.add(new ArrayList<>(tmp));
            return;
        }

        for(int end = start; end<s.length();end++){
            if(isPalindrome(s,start,end)){
                tmp.add(s.substring(start,end+1));
                dfs(end+1,s,tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s,int start,int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
