package edu.cmu.optimisticStrivers.math;

public class CXY_9_palindromeNumber_easy {
    public boolean isPalindrome(int x) {
        //转string
        String reserveStr = new StringBuilder(x + "").reverse().toString();
        if((x + "").equals(reserveStr)){
            return true;
        }
        return false;
    }

    public boolean isPalindromeI(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int revertNum = 0;
        while(x > revertNum){
            revertNum = revertNum*10 + x%10;
            x /= 10;
        }
        return x == revertNum || x == revertNum/10;
    }

    public boolean isPalindromeII(int x) {
        if(x < 0){
            return false;
        }
        int div = 1;
        while(x/div >= 10){
            div *= 10;
        }
        while(x > 0){
            int left = x / div;
            int right = x % 10;
            if(left != right){
                return false;
            }
            x = (x%div)/10;
            div /= 100;
        }
        return true;
    }

    public boolean isPalindromeIII(int x) {
        if(x < 0){
            return false;
        }
        //用long，否则可能溢出
        long revertNum = 0;
        int temp = x;
        while(temp > 0){
            revertNum = revertNum*10 + temp%10;
            temp /= 10;
        }
        if(revertNum == x){
            return true;
        }
        return false;
    }

}
