class Solution {
        public boolean canFinish(int numCourses, int[][] edges) {
            int[] indegree = new int[numCourses];
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>(numCourses);
            for (int i = 0; i < numCourses; i++) {
                adj.add(new ArrayList<>());
            }

            // construct adj
            for (int i = 0; i < edges.length; i++) {
                adj.get(edges[i][1]).add(edges[i][0]); // from/prerequirement is [1]
                indegree[edges[i][0]]++;
            }

            // start search from all 0 indegrees
            Queue<Integer> Q = new ArrayDeque<>();
            boolean[] visited = new boolean[numCourses];
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    Q.add(i);
                    visited[i] = true;
                }
            }

            ArrayList<Integer> topsort = new ArrayList<>();
            while (!Q.isEmpty()) {
                int curr = Q.poll();
                topsort.add(curr);
                for(int nbr : adj.get(curr)) {
                    if (visited[nbr]) continue;
                    indegree[nbr] --;
                    if (indegree[nbr] == 0) {
                        Q.add(nbr);
                        visited[nbr] = true;
                    }
                }
            }

            return topsort.size() == numCourses;
        }
}