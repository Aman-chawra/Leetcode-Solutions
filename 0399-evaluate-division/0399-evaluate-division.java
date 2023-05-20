class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        double[] res = new double[queries.size()];
        for(int i = 0; i < equations.size(); i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if(!map.containsKey(a)){
                map.put(a, new HashMap<>());
            }
            if(!map.containsKey(b)){
                map.put(b, new HashMap<>());
            }
            map.get(a).put(b, values[i]);
            map.get(b).put(a, (double) 1 / values[i]);
        }

        for(int i = 0; i < queries.size(); i++){
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            Set<String> visited = new HashSet<>();
            res[i] = dfs(a, b, visited, map);
        }
        return res;
    }

    public double dfs(String curr, String target, Set<String> visited, Map<String, Map<String, Double>> map){
        if(map.get(curr) == null){
            return -1;
        }
        if(map.get(curr).containsKey(target)){
            return map.get(curr).get(target);
        }
        visited.add(curr);
        for(String neighbor : map.get(curr).keySet()){
            if(visited.contains(neighbor)){
                continue;
            }
            double res = dfs(neighbor, target, visited, map);
            if(res > 0){
                return map.get(curr).get(neighbor) * res;
            }
        }
        return -1;
    }
}