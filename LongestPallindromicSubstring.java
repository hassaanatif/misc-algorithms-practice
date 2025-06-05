import java.util.Scanner; 

public class LongestPallindromicSubstring {

    public static void main (String args []) {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Please enter a String : ");
        String st = myObj.nextLine();
        //test cases : babad  , blank a blank b, blank
       String longestPallindrome =  getLongestPallindromicSubstring(st);
       System.out.println("Longest pallindrome is : " +  longestPallindrome);
    }

    public static String getLongestPallindromicSubstring (String s) {
        if (s.isBlank())
            return s;

        int [][] dpMatrix;
        dpMatrix = new int [s.length()][s.length()];
        
        int end_index = 0;

        int longest_start = 0; 
        int longest_end = 0; 

        for (int i = 0; i<=s.length(); ++i) {
 
            for (int j = 0; j<s.length(); ++j) {
                 boolean isPallindrome = false;

                end_index = j + i; 
                if (end_index >= s.length())
                   break;

                if (j == end_index) {
                    isPallindrome = true;

                }
                else if (s.charAt(j) == s.charAt(end_index)) {
                   if ((j + 1) == end_index) {
                       isPallindrome = true;
                   }  
                   else if ((dpMatrix[j + 1][end_index -1] > 0)){             
                      isPallindrome = true;
                   }
                }

                dpMatrix[j][end_index] = isPallindrome? 1 : 0;

                if (isPallindrome) {
                 if (((end_index - j) + 1) > ((longest_end - longest_start) + 1)) {
                        longest_start = j;
                        longest_end = end_index;
                    }
                }
               
            }
        }
        return s.substring(longest_start, longest_end + 1);
    }
    /******************  In case you want to index the lengths of the every pair in the dp matrix ************************ */
    
//     public static String getLongestPallindromicSubstringWithLengths(String s) { 
//   if (s.isBlank())
//             return s;

//         int [][] dpMatrix;
//         dpMatrix = new int [s.length()][s.length()];
        
//         int end_index = 0;
//         int val = 0;

//         int longest_start = 0; 
//         int longest_end = 0; 

//         for (int i = 0; i<=s.length(); ++i) {
//             System.out.println("Pass " + i + " :");
 
//             for (int j = 0; j<s.length(); ++j) {
//                // System.out.println(j + " , " + (j + i));
//                  boolean isPallindrome = false;

//                 end_index = j + i; 
//                 if (end_index >= s.length())
//                    break;

//                 val = (end_index - j) + 1; 
//                 if (j == end_index) {
//                     dpMatrix[j][end_index] = val;
//                     isPallindrome = true;

//                 }
//                 else if (s.charAt(j) == s.charAt(end_index)) {
//                    if ((j + 1) == end_index) {
//                        dpMatrix[j][end_index] = val; 
//                        isPallindrome = true;
//                    }  
//                    else {
//                     if (dpMatrix[j + 1][end_index -1] > 0)  {
//                        dpMatrix[j][end_index] = val;
//                        isPallindrome = true;
//                     } 
//                    }
//                 }
//                 else { 
//                     dpMatrix[j][end_index] = 0;
//                 }

//                 if (isPallindrome) {
//                  if (val > ((longest_end - longest_start) + 1)) {
//                         longest_start = j;
//                         longest_end = end_index;
//                     }
//                 }
               
//             }
//         }

//         for (int i = 0; i<s.length(); ++i) {
//             for (int j = 0; j<s.length(); ++j) {
//                 System.out.print(dpMatrix[i][j] + "\t") ;
//             }
//             System.out.println();
//         }

//         System.out.println("\nLongest pallindrome is from " + longest_start + " to " + longest_end);
//         return s.substring(longest_start, longest_end + 1);
//     }

    
}
