package yelim.solvedac.class4;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_Leetcode {
    static List<List<Integer>> answer = new ArrayList<>();
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<java.util.List<Integer>> combinationSum(int[] candidates, int target) {
        for(int i=0;i < candidates.length;i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(candidates[i]);
            backtracking(candidates, i, target - candidates[i], tmp);
        }
        return answer;

    }

    public static void backtracking(int[] candidates, int index, int target, List<Integer> tmp) {
        if(target == 0) { // 백 트래킹을 통해 입력받은 원소를 뺐을 때, 0이 된다면 (정답이라면)
            answer.add(new ArrayList(tmp)); // 정답 리스트에 넣기
            return;
        }

        for(int i=index;i < candidates.length;i++) { // index부터 원소를 빼주기 위해
            if(candidates[i] <= target) { // target보다 작다면
                tmp.add(candidates[i]); // 정답 가능성이 있으므로 tmp에 넣기
                backtracking(candidates, i, target - candidates[i], tmp); // target이 0이 되는 리스트를 찾기 위한 재귀함수
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
