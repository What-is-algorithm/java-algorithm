# 39 Combination Sum

```java
class Solution {
    private void backtracking(
        int start,
        int[] candidates,
        int target,
        List<List<Integer>> result,
        LinkedList<Integer> combination
    ) {
        if (target == 0) {
            result.add(new LinkedList<>(combination));
            return;
        } else if (target < 0) {
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            combination.offer(candidate);
            backtracking(i, candidates, target - candidate, result, combination);
            combination.pollLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        
        backtracking(0, candidates, target, result, combination);

        return result;
    }
}
```

