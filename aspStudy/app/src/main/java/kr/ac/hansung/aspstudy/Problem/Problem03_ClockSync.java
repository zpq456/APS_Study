package kr.ac.hansung.aspstudy.Problem;

import java.util.ArrayList;
import java.util.Vector;

import static java.lang.Math.min;

/**
 * Created by Owner on 2018-01-08.
 */

public class Problem03_ClockSync implements Problems {
    private static int INF = 9999;
    private static int SWITCHES = 10;
    private static int CLOCKS = 16;
    private char[][] linked = {
            {'x','x','x','.','.','.','.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','x','.','.','.','x','.','x','.','x','.','.','.','.'},
            {'.','.','.','.','x','.','.','.','.','.','x','.','.','.','x','x'},
            {'x','.','.','.','x','x','x','x','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','x','x','x','.','x','.','x','.','.','.'},
            {'x','.','x','.','.','.','.','.','.','.','.','.','.','.','x','x'},
            {'.','.','.','x','.','.','.','.','.','.','.','.','.','.','x','x'},
            {'.','.','.','.','x','x','.','x','.','.','.','.','.','.','x','x'},
            {'.','x','x','x','x','x','.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','x','x','x','.','.','.','x','.','.','.','x','.','.'},
    };


    @Override
    public String setProvlem() {
        String text = "";
        text = "4x4의 격자 형태로 배치된 열여섯 개의 시계가 있다. 이 시계들은 모두\n" +
                "12시,3시,6시,9시를 가리키고 있다. 이 시계들을 모두 12시를 가리키게 만들고 싶다.\n" +
                "10개의 스위키를 눌러서 각각 연결된 시계들의 시간이 3시간 앞으로 움직일 때 최소한\n" +
                "스위치를 몇 번 눌러야 할지 계산하라\n" +
                "스위치와 연결된 시계 목록 : \n" +
                "0번 : 0,1,2 / 1번 : 3,7,9,11 / 2번 : 4,10,14,15 \n" +
                "3번 : 0.4.5.6.7 / 4번 : 6,7,8,10,12 / 5번 : 0,2,14,15\n" +
                "6번 : 3,14,15 / 7번 : 4,5,7,14,15 / 8번 : 1,2,3,4,5\n" +
                "9번 : 3,4,5,9,13\n" +
                "출력되는 예제 : \n" +
                "스위치를 눌러야하는 최소의 수\n";
        return text;
    }

    @Override
    public void solvingProblem() {

    }

    private boolean areAligned(Vector<Integer> clocks){

        return true;
    }

    private void push(Vector<Integer> clocks, int swtch){
        for(int clock = 0; clock < CLOCKS; ++clock){
            if(linked[swtch][clock] == 'x'){
                clocks.get(clock) += 3;
                if(clocks.get(clock) == 15) clocks.get(clock) = 3;
            }
        }
    }

    private int solve(Vector<Integer> clocks, int swtch){
        if(swtch==SWITCHES) return areAligned(clocks) ? 0 : INF;
        int ret = INF;
        for(int cnt=0; cnt < 4; ++cnt){
            ret = min(ret, cnt + solve(clocks, swtch+1));
            push(clocks, swtch);
        }
        return ret;
    }

}