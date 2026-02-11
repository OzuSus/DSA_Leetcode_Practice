public class Leetcode_70_ClimbingStairs {
    public int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int firstStep = 1;
        int seconStep = 2;
        int currentStep;
        for (int i=3; i<=n; i++){
            currentStep = firstStep +seconStep;
            firstStep = seconStep;
            seconStep = currentStep;
        }
        return seconStep;
    }
}
