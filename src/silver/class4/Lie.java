package silver.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// TODO "어떤 사람이 어떤 파티에서는 진실을 듣고, 또 다른 파티에서는 과장된 이야기를 들었을 때도 지민이는 거짓말쟁이로 알려지게 된다."
// TODO "지민이는 모든 파티에 참가해야 한다."
// TODO 두 포인트를 종합해본다면?
//  -> (1) "원래 진실을 알고 있는 사람"을 만난다면, 지민이는 과장해서 말할 수 없다.
//  -> (2) "원래 진실을 알고 있는 사람"과 "만난 적이 있는 사람"을 만난다면, 지민이는 과장해서 말할 수 없다.
// TODO 따라서, "진실을 알고 있는 사람"들을 묶어 한 그룹(= 파티 ?)으로 보내버린다면, 그 외의 모든 파티에서 지민이는 과장해서 말할 수 있다.
// TODO 또는, "진실을 아는 사람"들의 집단을 만들어서 파티에 참여하는 사람들이 진실을 알고 있는 집단에 속해있는지 확인.

// 그냥 리스트와 같은 컬렉션에 보관을 해두고, .contains() 해서 people 순회하면서 체크하면 되는거 아니야?
// -> 예제 5, 6, 7번이 기댓값이랑 결과값이 다르긴 하네, 특이한 것 같다.
// ->
public class Lie {
    static int n;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 사람의 수
        int m = Integer.parseInt(st.nextToken()); // 파티의 수

        st = new StringTokenizer(br.readLine(), " ");
        int truthPerson = Integer.parseInt(st.nextToken()); // 진실을 아는 사람

        int[] people = new int[truthPerson];
        for (int i = 0; i < people.length; i++) {
            people[i] = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 번호
        }

        List<Integer>[] party = new ArrayList[m]; // 각각의 파티
        for (int i = 0; i < m; i++) { // 각 파티마다 오는 사람의 번호
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            int partySize = Integer.parseInt(st.nextToken());

            for (int j = 0; j < partySize; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        // TODO (1) "노드가 어떤 부모 노드에 속해있는지"를 위해 자기 자신을 가리키도록 초기화
        parent = new int[n + 1];
        unionFindInitilize();

        // TODO (2)
        for (int i = 0; i < m; i ++) {
            int firstPerson = party[i].get(0); // 각 파티의 첫 번째 사람

            for (int j = 1; j < party[i].size(); j ++) {
                union(firstPerson, party[i].get(j)); // 유니온 파인드 수행
            }
        }

        int maxParty = 0;
        for (int i = 0; i < m; i ++) {
            int firstPerson = party[i].get(0);
            boolean flag = true; //

            for (int j = 0; j < truthPerson; j ++) {
                if (isSameGroup(firstPerson, people[j])) {
                    flag = false; //
                }
            }
        }

        br.close();
    }

    private static void unionFindInitilize() {
        for (int i = 0; i <= n; i ++) {
            parent[i] = i;
        }
    }

    private static void // ..
}
