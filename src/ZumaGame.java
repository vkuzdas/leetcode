import java.util.*;

// 488. Zuma Game, HARD
// https://leetcode.com/problems/zuma-game/description/

public class ZumaGame {

    // speed things up by ommitting hand balls that are not on board

    public static void main(String[] args) {
//        System.out.println("hello".substring(0,2) + "hello".substring(3));
        Solution s = new Solution();
//        System.out.println(s.findMinStep("WRRBBW", "RB"));
//        System.out.println(s.findMinStep("WWRRBBWW", "WRBRW"));
//        System.out.println(findMinStep("G", "GGGGG"));

//        System.out.println(s.findMinStep("WWGWGW", "GWBWR")); // 3
//        System.out.println(s.findMinStep("WWGWGW", "GWBWR")); // 3
//        System.out.println(s.findMinStep("RRWWRRBBRR", "WB")); // 2
        System.out.println(s.findMinStep("RRGGBBYYWWRRGGBB", "RGBYW")); // 2
//        System.out.println(s.findMinStep("WWRRBBWW", "WRBRW")); // 2

//        System.out.println(s.collapseBoard("ABBBAACCC"));
//        System.out.println(s.collapseBoard("WWWW"));
    }


}


class Solution {

    private class GameState {
        String board;
        String hand;
        int depth;

        public GameState(String board, String hand, int depth) {
            this.board = board;
            this.hand = hand;
            this.depth = depth;
        }
        public GameState(String board, String hand) {
            this.board = board;
            this.hand = hand;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GameState gameState = (GameState) o;
            return Objects.equals(board, gameState.board) && Objects.equals(hand, gameState.hand);
        }

        @Override
        public int hashCode() {
            return Objects.hash(board, hand);
        }
    }




    public int findMinStep(String board, String hand) {
        board = collapseBoard(board);

        HashMap<Integer, GameState> stateMap = new HashMap<>();
        HashSet<GameState> allStates = new HashSet<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>()); // root nbrs

        char[] chars = hand.toCharArray();
        Arrays.sort(chars);
        GameState root = new GameState(board, new String(chars));
        root.depth = 0;
        stateMap.put(0, root);
        allStates.add(root);

        // start BFS
        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(0);
        while (!Q.isEmpty()) {
            Integer curr = Q.poll();

            genAllNeighbors(curr, graph, stateMap, allStates);
            ArrayList<Integer> nbrs = graph.get(curr);

            for(Integer n : nbrs) {
                if (stateMap.get(n).board.isEmpty()) {
                    return stateMap.get(n).depth;
                }
            }
            Q.addAll(nbrs);
        }

        return -1;

    }

    /**
     * Generate all neighbors by placing every char from hand on each possible position on the board
     */
    private void genAllNeighbors(Integer curr, ArrayList<ArrayList<Integer>> graph, HashMap<Integer, GameState> stateMap, HashSet<GameState> allStates) {
        GameState s = stateMap.get(curr);
        int prevLen = s.board.length()+1;
        char[] charArray = s.hand.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            // char from hand can be inserted ANYWHERE on the board (board.len + 1 positions)
            for (int j = 0; j < s.board.length() + 1; j++) {
                String newBoard = collapseBoard(new StringBuilder(s.board).insert(j, c).toString());
                if (prevLen > newBoard.length()) {
                    // i've reached   W^BBW, therefore its the same state as WB^BW and WBB^W therefore i skip 2 indicis
                    j = j + 2;
                }
                String newHand = new StringBuilder(s.hand).deleteCharAt(i).toString();
                GameState newState = new GameState(newBoard, newHand, s.depth+1);

                // state "caching"
                if(!allStates.contains(newState)) {
                    allStates.add(newState);
                    int id = stateMap.size();
                    stateMap.put(id, newState);
                    graph.add(new ArrayList<>()); // new source for the given id
                    graph.get(curr).add(id); // adding neighbor to graph
//                    System.out.println("added " + id + "->["+newBoard+","+newHand+"]");
                }
                prevLen = newBoard.length();
            }
        }// RRGGBBYYWWRRGGBB
    }

    /**
     * Removes sequence of same consecutive characters of len 3+
     */
    public String collapseBoard(String board) {
        String result;
        while (true) {
            int prevLen = board.length();
            result = removeConsecutive(board);
            int newLen = result.length();
            if (newLen == prevLen) break;
            board = result;
        }
        return result;
    }

    private String removeConsecutive(String board) {
        String boardCpy = board + "#";
        StringBuilder sb = new StringBuilder();
        Stack<Character> S = new Stack<>();
        for (char c : boardCpy.toCharArray()) {
            if (S.empty()) {
                S.push(c);
            } else {
                if (S.peek() != c) { // top is diff
                    if (S.size() >= 3) {
                        S = new Stack<>(); // dont pop, just init anew
                        S.push(c);
                    }
                    else { // top is diff and short
                        while (!S.empty()) {
                            sb.append(S.pop());
                        }
                        S.push(c);
                    }
                }
                else { // top is same
                    S.push(c);
                }
            }
        }
        while (!S.empty()) {
            if (S.peek() == '#') {
                S.pop();
            }
            else {
                sb.append(S.pop());
            }
        }
        return sb.toString();
    }
}
