package codility.l3_time_complexity;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * <h1>TapeEquilibrium</h1>
 * minimize the absolute difference between the sum of the first part and the sum of the second part of a tape
 * ie Minimize the value |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.
 * @see <a href="https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/">Problem Detail</a>
 * @see <a href="https://app.codility.com/demo/results/trainingCSDBVR-JTY/">Codility report</a>
 * @author Sijan Maharjan
 * @since 2021-01-31
 */
public class TapeEquilibrium {

    /**
     * N is an integer within the range [2..100,000];
     * each element of array A is an integer within the range [−1,000..1,000].
     * @param A
     * @return
     */
    public int solution(int [] A){
        int s = Arrays.stream(A).sum();
        int t = A.length-1;
        int l=0, r=0, x, a1, a2, min = Integer.MAX_VALUE;
        for(int i=0; i< Math.ceil((float)t/2.0); i++){
            l += A[i];
            r += A[t-i];
            x = s - l;
            a1 = abs(l-x);
            x = s - r;
            a2 = abs(x-r);
            min = Math.min(min, Math.min(a1, a2));
        }
        return min;
    }

    public int abs(int val){
        return Math.abs(val);
    }

//    int s = 0;
//    public int solution2(int [] A){
//        int t = A.length-1;
//        return calculate(A, t, 0, (int) Math.ceil((float)(t+1)/2.0), 0, 0);
//    }
//
//    public int calculate(int[] A, int t, int i, int f, int l, int r){
//        int min;
//        if(i < f){
//            l += A[i];
//            r += A[t-i];
//            s += A[i];
//            s += i != t-i ? A[t-i] : 0;
//            min = calculate(A, t,i+1, f, l, r);
//            int x = s - l;
//            int a1 = abs(l-x);
//            x = s - r;
//            int a2 = abs(x-r);
//            min = Math.min(min, Math.min(a1, a2));
//        }else{
//            min = Integer.MAX_VALUE;
//        }
//        return min;
//    }

    @Test
    public void test1() {
        Assert.assertEquals(1, solution(new int[]{3,1,2,4,3}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, solution(new int[]{-3,1,2,4,3}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, solution(new int[]{3,1,2,-4,3}));
    }

    @Test
    public void test4() {
        Assert.assertEquals(0, solution(new int[]{-5,-5}));
    }

    @Test
    public void test5() {
        Assert.assertEquals(0, solution(new int[]{-1000, 900, 700, -800, 500, 300, -1000}));
    }

    @Test
    public void test6() {
        Assert.assertEquals(2, solution(new int[]{-3, 5, 6, 10, -20, 10, 5, 1}));
    }

    @Test
    public void test7() {
        Assert.assertEquals(5, solution(new int[]{-1, -3, -6, -5}));
    }
}
