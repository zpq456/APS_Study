package kr.ac.hansung.aspstudy.Problem;

/**
 * Created by Owner on 2018-01-04.
 */

public class Problem01_Picnic implements Problems {
    private int n;
    private boolean[][] areFriends;

    @Override
    public String setProvlem() {
        String text="";
        text = "각 학생들의 쌍에 대해 이들이 서로 친구인지 여부가 주어질 때,\n" +
                "학생들을 짝지을 수 있는 방법의 수를 계산하는 프로그램을 작성하세요.\n" +
                "입력되는 예제 : \n" +
                "테스트 케이스 수 (C <= 50) \n" +
                "학생의 수, 친구 쌍의 수 \n" +
                "서로 친구인 두 학색의 번호 \n" +
                "출력되는 예제 : \n" +
                "모든 학생을 친구끼리만 짝지어줄 수 있는 방법의 수\n";
        return text;
    }

    @Override
    public void solvingProblem() {

    }

    private int countPairings(boolean[] taken) {
        int firstFree = -1;
        for(int i=0;i<n;i++){
            if(!taken[i]){
                firstFree = i;
                break;
            }
        }
        if(firstFree==1) return 1; // 모든 학생이 짝을 찾았으면 종료

        int ret = 0;
        //이 학생과 짝지을 학생을 결정
        for(int pairWith = firstFree+1; pairWith < n; ++pairWith){
            if(!taken[firstFree] && areFriends[firstFree][pairWith]){
                taken[firstFree] = taken[pairWith] = true;
                ret += countPairings(taken);
                taken[firstFree] = taken[pairWith] = false;
            }
        }
        return ret;
    }
}
