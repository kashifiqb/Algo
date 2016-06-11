import java.util.*;
import java.math.*;

class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: Cosine similarity.
     */
    public double cosineSimilarity(int[] A, int[] B) {
        // write your code here
        long sumA = 1l, sumB = 1l, sumC =1l;

        for(int i=0; i<A.length; i++) {
            sumA += (A[i] * A[i]);
            sumB += (B[i] * B[i]);
            sumC += (A[i] * B[i]);
        }

        if(sumA == 0 || sumB == 0) return 2.0000;

        double d = Math.sqrt(sumA) * Math.sqrt(sumB);

        return new BigDecimal(sumC/d).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().cosineSimilarity(new int[]{1,4,0}, new int[]{1,2,3}));
    }
}
