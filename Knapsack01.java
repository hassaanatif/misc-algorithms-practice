//Problem : Knapsack01 
//Solution : Dynamic Programming 
//Complexity : O(C (capacity) * N (items))

public class Knapsack01 {
    public static void main(String[] args) {
        //axcvabxbacbl
       // System.out.println(longestPalindrome("axcvabxbacbl"));
       /*int [] weights = new int[] {2,3,5};
       int [] prices = new int [] {3,4,6};*/
        int [] weights = new int[] {2,3,5};
        int [] prices = new int [] {3,4,6};
        Knapsack01(weights, prices, 8);
    }


    public static void Knapsack01(int [] item_weights, int [] prices, int capacity) {
        //weights : [2, 3, 5]
        //price : [3, 4, 6]
        //goal : maximize price within the given capcity
        int [] [] dpMatrix = new int[item_weights.length + 1][capacity + 1];

        for (int i = 0; i<capacity  +1; ++i) {
            dpMatrix[0][i] = 0;
        }
        for (int j = 0; j<item_weights.length + 1; ++j) {
            dpMatrix[j][0] = 0;
        }

        for (int k = 1; k<item_weights.length + 1; ++k) {

            int w = item_weights[k-1];
            for (int z = 1; z<capacity + 1; ++z) {
                int diff = z - w;
                if ((diff) < 0) {
                    dpMatrix[k][z] = dpMatrix[k-1][z];
                }
                else {
                    int taken_price = prices[k-1] + dpMatrix[k-1][diff];
                    int not_taken_price = dpMatrix[k-1][z];
                    dpMatrix[k][z] = Math.max(taken_price, not_taken_price);
                }
            }
        }

        System.out.println("Printing DP MATRIX!! \n");
        for (int i =0; i <item_weights.length + 1; ++i) {
            for (int j = 0; j<capacity + 1; ++j) {
                System.out.print(dpMatrix[i][j] + "\t");
            }
            System.out.println("");
        }
    }

}