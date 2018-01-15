package kr.ac.hansung.aspstudy.Problem;

import java.util.Vector;

/**
 * Created by Owner on 2018-01-08.
 */

public class Problem02_BoardCover implements Problems {
    private int[][][] coverType = {
            {{0,0},{1,0},{0,1}},
            {{0,0},{0,1},{1,1}},
            {{0,0},{1,0},{1,1}},
            {{0,0},{1,0},{1,-1}}
    };

    @Override
    public String setProvlem() {
        String text = "";
        text = "HxW크기의 게임판에 있다. 검은 칸과 흰 칸으로 구성된 게임판에서\n" +
                "3칸까리 L 블록으로 흰 칸을 덮고 싶을때 이를 덮는 방법의 수를 계산하라.\n" +
                "입력되는 예제 : \n" +
                "테스트 케이스 수 (C <= 50) \n" +
                "게임판의 H,W \n" +
                "게임판의 모양 (흑:#, 백:. )\n" +
                "출력되는 예제 : \n" +
                "가능한 방법의 수\n";
        return text;
    }

    @Override
    public void solvingProblem() {

    }

    public boolean setBoard(Vector<Vector<Integer>> board, int y, int x, int type, int delta){
        boolean ok = true;
        for(int i=0;i<3; ++i){
            int ny = y + coverType[type][i][0];
            int nx = x + coverType[type][i][1];
            if(ny < 0 || ny >= board.size() || nx < 0 || nx >= board.get(0).size())
                ok = false;
            else if((board.get(ny).get(nx) + delta) > 1)
                ok = false;
        }
        return ok;
    }

    public int cover(Vector<Vector<Integer>> board){
        int y = -1;
        int x = -1;
        for(int i = 0; i< board.size();++i){
            for(int j=0; j<board.get(i).size();++j){
                if(board.get(i).get(j) == 0){
                    y = i;
                    x = j;
                    break;
                }
            }
            if(y != -1) break;
        }
        //모든 칸을 채웠으면 1을 반환
        if(y == -1) return 1;
        int ret = 0;
        for(int type = 0; type < 4; ++type){
            if(setBoard(board,y,x,type,1))
                ret += cover(board);
            setBoard(board,y,x,type,-1);
        }
        return ret;
    }
}