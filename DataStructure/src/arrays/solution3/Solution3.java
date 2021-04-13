package arrays.solution3;

/**
 * @author Ozzy Yang
 * Finished Time：2021-04-0
 */
public class Solution3 {
    public int findRepeatNumber(int[] nums) {
        return this.solution3(nums);
    }

    //运行时间为n级，且空间复杂度为常数级
    public int solution3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                } else {
                    int cacheNum = nums[i];
                    nums[i] = nums[nums[i]];
                    nums[cacheNum] = cacheNum;
                }
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return 0;
    }
}
