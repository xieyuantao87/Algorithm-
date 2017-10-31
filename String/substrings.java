/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringmanipulation;

import java.util.HashMap;

/**
 *
 * @author Yuantao Xie
 */
public class substrings {
    private final String str; 
    public int len;
    substrings(String s){
        str=s;
        len=str.length();
    }
    // longest substring without repeating character;
    
    public String longestSubstring(){
        if(len<2) return str;
        
        HashMap<Character, Integer> map=new HashMap<>(); 
        int max=0, start=0, startm=0; 
        for(int i=0; i<len; i++){
            if(map.containsKey(str.charAt(i))){
                if(max<i-start){
                    max=i-start; 
                    startm= start;
                }
                start=map.get(str.charAt(i))+1;
                
            }
            map.put(str.charAt(i), i);
        }
        return str.substring(startm, startm+max);
    }
}
