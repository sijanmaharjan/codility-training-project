package codility.l3_time_complexity;

/**
 * <h1>FrogJmp</h1>
 * Count minimal number of jumps from position X to Y.
 * @see <a href="https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/">Problem Detail</a>
 * @see <a href="https://app.codility.com/demo/results/trainingWFXPF9-G57/">Codility report</a>
 * @author Sijan Maharjan
 * @since 2020-11-08
 */
public class FrogJmp {
    public static int solution(int X, int Y, int D){
        int totalJmp = (Y - X) / D;
        return  (X + totalJmp * D == Y)? totalJmp : totalJmp+1;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 999111321, 7));
    }
}
