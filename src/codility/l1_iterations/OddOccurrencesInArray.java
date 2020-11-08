package codility.l1_iterations;

import java.util.Arrays;

/**
 * <h1>OddOccurrencesInArray</h1>
 * Find value that occurs in odd number of elements.
 * @see <a href="https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/">Problem Detail</a>
 * @see <a href="https://app.codility.com/demo/results/training8H2PJK-5Z6/">Codility report</a>
 * @author Sijan Maharjan
 * @since 2020-11-02
 */
public class OddOccurrencesInArray {
    public static int solution(int[] A) {
        Arrays.sort(A);
        for(int i=0; i<A.length; i+=2){
            if(i+1 == A.length) return A[i];
            else if(A[i] - A[i+1] != 0) return A[i];
        }
        throw new RuntimeException("No Odd Occurrence");
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{6,4,3,4,3,6,4}));
    }
}
