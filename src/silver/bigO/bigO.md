# ✏️ Review
## 시간 복잡도 (feat. 이코테)
> 특정한 크기의 입력에 대하여 알고리즘이 얼마나 오래 걸리는지

![image](https://github.com/What-is-algorithm/java-algorithm/assets/103405457/ad97c8c8-d964-4dc4-92c7-db2095759199)

### 정확히 O(log n)은 얼마나 빠른 걸까?

기본적으로 동일한 기능을 수행하는 알고리즘이 있다면 일반적으로 복잡도가 낮을수록 좋은 알고리즘

특히, 시간 복잡도는 알고리즘을 위해 필요한 **연산의 횟수**를 의미

## 시간 복잡도 표기
### 빅-오 표기법(Big-o)
> 가장 빠르게 증가하는 항만을 고려하는 표기법

가장 최악의 경우를 기반으로 알고리즘의 성능을 파악하는 표기법

### 예시

기본적으로 연산 횟수가 다항식으로 표현될 경우, 최고차항을 제외한 모든 항과 최고차항의 계수를 제외시켜 나타냄
> 일반적으로 상수는 무시하고, 최고차항을 기준으로 계산

#### 다항식
- 입력 크기 : n
```
f(x) = n^2 + 2n + 1 = O(n^2)
f(x) = 2n = O(n)
```

#### 코드
- 입력 크기 : n


### 참고 자료
#### 개념
- https://www.bigocheatsheet.com/
- https://yoongrammer.tistory.com/79
#### 실전
- https://www.geeksforgeeks.org/practice-questions-time-complexity-analysis/
