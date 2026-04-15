class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int num = n;
        while(num != 1){
            if(set.contains(num)) return false;
            set.add(num);
            num = sum(num);
        }
        return true;
    }

    public int sum(int n){
        int sum = 0;

        while(n > 0){
            int digit = n%10;
            sum = sum + (digit*digit);
            n = n/10;
        }
        return sum;
    }
}
