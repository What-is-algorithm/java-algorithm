# ✏️ Review
## 시간 복잡도 (feat. 이코테)
> 특정한 크기의 입력에 대하여 알고리즘이 얼마나 오래 걸리는지

![image](https://github.com/What-is-algorithm/java-algorithm/assets/103405457/ad97c8c8-d964-4dc4-92c7-db2095759199)

### 정확히 O(log n)은 얼마나 빠른 걸까?
> O(log 2n) = O(log n) = 10,000,000,000 = 33
> log n이라는 시간 복잡도는 100을 넘기가 어려움, 실제로는 O(n)보다 훨씬 빠름 

기본적으로 동일한 기능을 수행하는 알고리즘이 있다면 일반적으로 복잡도가 낮을수록 좋은 알고리즘

특히, 시간 복잡도는 알고리즘을 위해 필요한 **연산의 횟수**를 의미

## 시간 복잡도 표기
### 빅-오 표기법(Big-o)
> 가장 빠르게 증가하는 항만을 고려하는 표기법

**기본적으로** 가장 최악의 경우를 기반으로 알고리즘의 성능을 파악하는 표기법

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
```
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));
        
        br.close();
    }

    private static int solution(int n) {
        int sum = 0; // 대입 연산 1회

        for (int i = 0; i < n; i ++) { // 대입 연산 1회 및 n + 1번 실행
            sum += i; // 덧셈 연산 n번
        }

        for (int i = 0; i < n; i ++) { // 대입 연산 1회 및 n + 1번 실행
            sum += i; // 덧셈 연산 n번
        }

        return sum; // 리턴 연산 1회
    }
}
```
> 1 + 1 + (n + 1) + n + 1 + (n + 1) + n + 1 = 4n + 6 -> O(n)

## 주요 자료구조 및 알고리즘의 시간 복잡도
![image](https://github.com/What-is-algorithm/java-algorithm/assets/103405457/5d889513-87d6-402d-b904-6654834f2d13)

### 시간 복잡도는 빅-오 표기법을 기반으로 한다던데..

#### 예시
이진 탐색 트리의 평균적인 시간 복잡도 : (탐색 ~ 삭제) O(log n)
이진 탐색 트리의 최악의 시간 복잡도 : (탐색 ~ 삭제) O(n)

해시 테이블의 평균적인 시간 복잡도 : (탐색 ~ 삭제) O(1)
해시 테이블의 최악의 시간 복잡도 : (탐색 ~ 삭제) O(n)

### 왜 명시된 최악의 시간 복잡도와 다르게 일반적으로 두 자료구조가 빠르다고 이야기하는 걸까?
1. 이진 탐색 트리 : 균형 이진 탐색 트리와 비균형 이진 탐색 트리로 나뉘기 때문
- 균형 이진 탐색 트리
- 비균형 이진 탐색 트리
2. 해시 테이블 : 아래의 여러 이유 때문

### 참고 자료
#### 개념
- https://www.bigocheatsheet.com/
- https://yoongrammer.tistory.com/79
#### 실전
- https://www.geeksforgeeks.org/practice-questions-time-complexity-analysis/
