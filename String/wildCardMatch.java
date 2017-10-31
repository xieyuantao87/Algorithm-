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
public class wildCardMatch {
    String str, pattern; 
    int lens, lenp;
    wildCardMatch(String s, String p){
        str=s; 
        pattern=p;
        lens=str.length(); 
        lenp=pattern.length();
    }
    
   //'.' Matches any single character.
   // '*' Matches any sequence of characters (including the empty sequence).
    public boolean isMatch(){
        boolean[][] match=new boolean[lens+1][lenp+1];
        match[lens][lenp]=true;
      
        for(int i=lenp-1;i>=0;i--){
            if(pattern.charAt(i)!='*')
                break;
            else
                match[lens][i]=true;
        }
        for(int i=lens-1;i>=0;i--){
            for(int j=lenp-1;j>=0;j--){
                if(str.charAt(i)==pattern.charAt(j)||pattern.charAt(j)=='.')
                        match[i][j]=match[i+1][j+1];
                else if(pattern.charAt(j)=='*')
                        match[i][j]=match[i+1][j]||match[i][j+1];
                else
                    match[i][j]=false;
            }
        }
        return match[0][0];
    }
    //'.' Matches any single character.
   // Matches zero or more of the preceding element.
    public boolean isMatch2(){
        if(str==null ||pattern==null) return false; 
        boolean[][] match=new boolean[lens+1][lenp+1];
        match[0][0]=true; 
        for (int i = 0; i <lenp; i++) {
            if (pattern.charAt(i) == '*' && match[0][i-1]) 
                match[0][i+1] = true;    
        }
        for (int i = 0 ; i < lens; i++) {
        for (int j = 0; j < lenp; j++) {
            if (pattern.charAt(j) == '.') {
                match[i+1][j+1] = match[i][j];
            }
            if (pattern.charAt(j) == str.charAt(i)) {
                match[i+1][j+1] = match[i][j];
            }
            if (pattern.charAt(j) == '*') {
                if (pattern.charAt(j-1) != str.charAt(i) && pattern.charAt(j-1) != '.') {
                    match[i+1][j+1] = match[i+1][j-1];
                } else {
                    match[i+1][j+1] = (match[i+1][j] || match[i][j+1] || match[i+1][j-1]);
                }
            }
        }
    }
    return  match[lens][lenp];
    }
}
