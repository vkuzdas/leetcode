


     class TSV {
        ArrayList<String> values;
        ArrayList<Integer> timestamps;
        public TSV() {
            values = new ArrayList<>();
            timestamps = new ArrayList<>();
        }
    }

     class TimeMap {
        HashMap<String, TSV> map;
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                TSV tsv = new TSV();
                tsv.values.add(value);
                tsv.timestamps.add(timestamp);
                map.put(key, tsv);
            }
            else {
                TSV tsv = map.get(key);
                tsv.values.add(value);
                tsv.timestamps.add(timestamp);
                map.put(key, tsv);
            }
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";
            
            TSV tsv = map.get(key);
            int l = 0;
            int r = tsv.timestamps.size()-1;
            String res = "";
            while (l<=r) {
                int m = l+(r-l)/2;
                if(tsv.timestamps.get(m) <= timestamp) {
                    res = tsv.values.get(m);
                    l = m+1;
                }
                else {
                    r = m-1;
                }
            }
            return res;
        }

    }