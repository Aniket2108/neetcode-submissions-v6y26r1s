class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return res;
        StringBuilder sb = new StringBuilder();
        letterCombinations(0,sb,digits,getMap());
        return res;
    }

    private void letterCombinations(int idx,StringBuilder sb,String digits,Map<Character,String> map){
        if(idx == digits.length()){
            res.add(new String(sb.toString()));
            return ;
        }

        for(char ch:map.get(digits.charAt(idx)).toCharArray()){
            StringBuilder tmp = new StringBuilder(sb.toString());
            tmp.append(ch);
            letterCombinations(idx + 1,tmp,digits,map);
        }
    }

    private Map<Character,String> getMap(){
        Map<Character,String> map = new HashMap<>();

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        return map;
    }
}
