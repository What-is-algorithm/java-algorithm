# [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)

n번째 계단으로 도달하는 모든 경우의 수를 최소 단위로 쪼개고 최소 단위에서 부터 구할 수 있는 모든 경우의 수를 전부 합한다. 

결과적으로 n번째 계단으로 도달하는 모든 경우의 수를 구할 수 있게된다.

```java
class Solution {
    private Map<Integer, Integer> dp = new HashMap<>(Map.of(1, 1, 2, 2));

    public int climbStairs(int n) {
        if (dp.containsKey(n)) return dp.get(n);
        dp.put(n, climbStairs(n - 2) + climbStairs(n - 1));
        return dp.get(n);
    }
}
```

