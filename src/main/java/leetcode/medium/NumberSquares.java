package leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class NumberSquares {
    
    public int numSquares(int n) {
        Queue<Integer> queue=new LinkedList<>();
        HashSet<Integer> visited=new HashSet<>();
        queue.offer(n);
        visited.add(n);
        int level=0;
        
        while(!queue.isEmpty()){
            level++;
            int len=queue.size();
            
            for(int i=0;i<len;i++){
                int cur=queue.poll();
                
                for(int j=1;j*j<=cur;j++){
                    int tmp=cur-j*j;
                    if(tmp==0)
                        return level;
                    if(!visited.contains(tmp))
                        queue.offer(tmp);
                    visited.add(tmp);
                }
            }
        }
        return level;
    }

    @Test
    public void t1() {
        System.out.println(numSquares(12));
    }
}