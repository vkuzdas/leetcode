import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

// 488. Zuma Game, HARD
// https://leetcode.com/problems/zuma-game/description/

public class ZumaGame {

    // speed things up by ommitting hand balls that are not on board

    public static void main(String[] args) {
//        System.out.println("hello".substring(0,2) + "hello".substring(3));
//        System.out.println(findMinStep("WRRBBW", "RB"));
//        System.out.println(findMinStep("WWRRBBWW", "WRBRW"));
//        System.out.println(findMinStep("G", "GGGGG"));
        Solution s = new Solution();

//        System.out.println(s.findMinStep("WWGWGW", "GWBWR")); // 3
//        System.out.println(s.findMinStep("WWGWGW", "GWBWR")); // 3
        System.out.println(s.findMinStep("RRWWRRBBRR", "WB")); // 2
    }


}


class Solution {

    private class GameState {
        String board;
        String hand;
        int depth;

        public GameState(String board, String hand) {
            this.board = board;
            this.hand = hand;
        }
    }




    public int findMinStep(String board, String hand) {
        // Collapse the root state
        board = collapseBoard(board);
        HashMap<Integer, GameState> stateMap = new HashMap<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>()); // root nbrs

        GameState root = new GameState(board, hand);
        root.depth = 0;
        stateMap.put(0, root);

        // start BFS
        Queue<Integer> Q = new ArrayDeque<>();


        Q.add(0); // add root
        while (!Q.isEmpty()) {
            Integer curr = Q.poll();
            ArrayList<Integer> nbrs = initNeighbors(curr, graph, stateMap);
            for(Integer n : nbrs) {
                if (stateMap.get(n).board.isEmpty()) {
                    return stateMap.get(n).depth;
                }
            }
            Q.addAll(nbrs);
        }

        return -1;

    }

    private String collapseBoard(String board) {

        while (true) {
            int prevLen = board.length();
            board = board.replaceAll("RRR+", "");
            board = board.replaceAll("YYY+", "");
            board = board.replaceAll("BBB+", "");
            board = board.replaceAll("GGG+", "");
            board = board.replaceAll("WWW+", "");
            int newLen = board.length();

            if (newLen == prevLen) break;
        }

        return board;
    }

    // given current, graph and map
    // analyze board and hand, based on that generate new states, put them into graph and map
    // TODO: sort hand and add states to hashSet, then you wont have duplicates
    private ArrayList<Integer> initNeighbors(Integer curr, ArrayList<ArrayList<Integer>> graph, HashMap<Integer, GameState> stateMap) {
        GameState s = stateMap.get(curr);
        ArrayList<Integer> nbrs = new ArrayList<>();

        // pro kazdej char v ruce najdi kazdej vyskyt dvou po sobe jdoucich techto charu
        // a taky jeden char
        for (int i = 0; i < s.hand.length(); i++) {
            int addLen;
            char c = s.hand.charAt(i);
            String newHand = s.hand.substring(0,i) + s.hand.substring(i+1);
            ArrayList<Integer> positions = findAllPositionsOf("" + c + c, s.board); // "__CC__"
            positions.addAll(findAllPositionsOf(""+c, s.board)); // "__C__"


            // pro vsechny tyhle pozice, vygeneruj board
            for(int p : positions) {
                String newBoard = new StringBuilder(s.board).insert(p, c).toString();
                newBoard = collapseBoard(newBoard);
                GameState newState = new GameState(newBoard, newHand);
                graph.add(new ArrayList<>());
                newState.depth = s.depth+1;
                int statNum = stateMap.size();
                stateMap.put(statNum, newState);
                graph.get(curr).add(statNum); // nbr added to current
                nbrs.add(statNum);
            }
        }
        return nbrs;
    }

    private ArrayList<Integer> findAllPositionsOf(String rgx, String board) {
        ArrayList<Integer> positions = new ArrayList<>();
        int i = 0;

        // if there is an occurence, add it to the positions, move fromIndex
        while(board.indexOf(rgx, i) != -1) {
            int pos = board.indexOf(rgx, i);
            positions.add(pos);
            i = pos + 2;
        }

        return positions;
    }

}
