/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringmanipulation;

/**
 *
 * @author Yuantao Xie
 */
public class palindrome {
    private String str;
    public int len, start, maxLen, count;
    
    
    palindrome(String s){
        str=s;
        len=str.length();
        count=0;
    }
    public String longestPalindrome(){
        
        if(len<2) return str;
        for(int i=0; i<len-1; i++){
            extendPalindrome(i, i); // odd length
            extendPalindrome( i, i+1); //even length
        }
        return str.substring(start, start+maxLen);
    }
    public void extendPalindrome( int left, int right){
        while(left>=0 && right<str.length() && str.charAt(left)==str.charAt(right)){
            left--; right++; count++;
        } 
        if(maxLen<right-left-1){
            start=left+1; 
            maxLen=right-left-1;
        }
    }
    
    public boolean validPalindrome(){
        int left=0, right=len-1; 
        while(left <right && str.charAt(left++)==str.charAt(right--)) {
        }
        return left<right;    
    }
    
   
}
