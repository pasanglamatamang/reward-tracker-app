package reward.traker.app.util;

public class RewardCalculator {
    public static Integer calculateReward(Long amount) {
        int rewardPoint = 0 ;
        if (amount > 100) {
            rewardPoint = (int) ((((amount - 100) * 2) + 50));
        } else if (amount > 50 && amount < 100) {
            rewardPoint = (int) (amount - 50);
        }
        return rewardPoint;
    }
}
