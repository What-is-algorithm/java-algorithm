package jin.leetcode;

import java.util.*;
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 숫자 중복 가능
        // 값을 넣으면서 sum > target || idx = candidates.length -> return
        // sum == target -> add
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int sum, int start, List<Integer> temp, List<List<Integer>> result) {
        if (sum > target || start == candidates.length) return;
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            temp.add(num);
            backtrack(candidates, target, sum + num, i, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
