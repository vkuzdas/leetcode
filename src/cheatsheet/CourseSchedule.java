package cheatsheet;

import java.util.ArrayList;
import java.util.Stack;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(numCourses);
        int [] indeg = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites) {
            adj.get(edge[0]).add(edge[1]);
            indeg[edge[1]]++;
        }

        Stack<Integer> S = new Stack<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                S.push(i);
            }
        }

        ArrayList<Integer> ordering = new ArrayList<>();
        while (!S.empty()) {
            int top = S.pop();
            ordering.add(top);
            for (int i = 0; i < adj.get(top).size(); i++) {
                int nbr = adj.get(top).get(i);
                indeg[nbr]--;
                if(indeg[nbr] == 0) {
                    S.push(nbr);
                }
            }
        }
        return ordering.size() == numCourses;
    }
}
