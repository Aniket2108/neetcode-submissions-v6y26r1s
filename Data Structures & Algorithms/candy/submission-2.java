class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int i = 1;
        int sum = 1;

        while(i < n){
            if(ratings[i] == ratings[i-1]){
                i++;
                sum = sum + 1;
                continue;
            }

            int up = 1;
            while(i < n && ratings[i] > ratings[i-1]){
                up++;
                sum += up;
                i++;
            }

            int down = 0;
            while(i < n && ratings[i] < ratings[i-1]){
                down++;
                sum += down;
                i++;
            }

            if(down >= up){
                sum += (down - up + 1);
            }
        }
        return sum;
    }
}