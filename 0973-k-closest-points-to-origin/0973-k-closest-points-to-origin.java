class Solution {
        class Point {
            int x;
            int y;
            int d;

            public Point(int x, int y, int d) {
                this.x = x;
                this.y = y;
                this.d = d;
            }
        }
        public int[][] kClosest(int[][] points, int k) {
            List<Point> points_str = new ArrayList<>();
            for (int[] pt : points) {
                int d = pt[0]*pt[0] + pt[1]*pt[1]; 
                points_str.add(new Point(pt[0], pt[1], d));
            }
            
            int[][] result = new int[k][2];
            points_str.sort(Comparator.comparingInt(c -> c.d));
            
            for (int i = 0; i < k; i++) {
                result[i][0] = points_str.get(i).x;                
                result[i][1] = points_str.get(i).y;
            }
            return result;
        }
}