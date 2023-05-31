class Pair{
    String st;
    int in;

    Pair(String st, int in){
        this.st = st;
        this.in = in;
    }
}
class UndergroundSystem {
    HashMap<Integer, Pair> checkTime = new HashMap<>();
    HashMap<String, Integer> totalTime = new HashMap<>();
    HashMap<String, Integer> map = new HashMap<>();
    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkTime.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        int time = t - checkTime.get(id).in;
        String a = checkTime.get(id).st + "_" + stationName;
        totalTime.put(a, totalTime.getOrDefault(a, 0) + time);
        map.put(a, map.getOrDefault(a, 0) + 1);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return (double)totalTime.get(startStation + "_" + endStation) / map.get(startStation + "_" + endStation);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */