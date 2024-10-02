class TimeMap {

    class Pair {
        String value;
        int time;

        public Pair(String value, int time) {
            this.value = value;
            this.time = time;
        }
    }

    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";

        List<Pair> values = map.get(key);

        int low = 0;
        int high = values.size() - 1;
        String res = "";

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            int time = values.get(mid).time;

            if (time <= timestamp) {
                res = values.get(mid).value;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res;
    }
}
