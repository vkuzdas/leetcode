class Solution {
        class Point {
            int x;
            int y;
            int dist;

            public Point(int x, int y, int dist) {
                this.x = x;
                this.y = y;
                this.dist = dist;
            }
        }
        public int[][] kClosest(int[][] points, int k) {
            List<Point> pts = new ArrayList<>();
            for (int i = 0; i < points.length; i++) {
                pts.add(new Point(points[i][0], points[i][1], (int) (Math.pow(points[i][0],2) + Math.pow(points[i][1],2))));
            }
            List<Point> newpts = pts.stream().sorted(Comparator.comparingInt(value -> value.dist)).limit(k).toList();
            int[][] ret = new int[k][2];
            for(int i = 0; i < newpts.size(); i++) {
                ret[i][0] = newpts.get(i).x;
                ret[i][1] = newpts.get(i).y;
            }
            return ret;
//            HashMap<Integer, int[]> pt_dist = new HashMap<>();
//            for (int i = 0; i < points.length; i++) {
//                int[] pt = points[i];
//                int dist = pt[0]^2 + pt[1]^2;
//                pt_dist.put(dist, pt);
//            }
//            List<Integer> keys = pt_dist.keySet().stream().sorted().limit(k).toList();
//            int[][] kClosest = new int[keys.size()][];
//            for (int i = 0; i < keys.size(); i++) {
//                kClosest[i] = pt_dist.get(keys.get(i));
//            }
//            return kClosest;
        }
}