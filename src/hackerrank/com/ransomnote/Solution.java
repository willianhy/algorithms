package hackerrank.com.ransomnote;

import java.util.*;

public class Solution {
    Map<String, Integer> magazineMap = new HashMap<String, Integer>();
    Map<String, Integer> noteMap = new HashMap<String, Integer>();
    String magazineStrings;
    String noteStrings;
    
    public Solution(String magazine, String note) {
        magazineStrings = magazine;
        noteStrings = note;
    }
    
    public boolean solve() {
        for(String magazine: magazineStrings.split(" "))
            magazineMap.put(magazine, magazineMap.get(magazine) != null ? magazineMap.get(magazine) + 1 : 1);
            
        for(String note: noteStrings.split(" "))
            noteMap.put(note, noteMap.get(note) != null ? noteMap.get(note) + 1 : 1);
        
        for(String key: noteMap.keySet())
            if (!(magazineMap.containsKey(key) && magazineMap.get(key) == noteMap.get(key)))
                return false;
                
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
