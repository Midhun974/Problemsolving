class Solution {
    Set<Integer> visited = new HashSet<>();
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap();
        for(int[] edge : edges)
        {
            int u=edge[0];
            int v=edge[1];
            if(!graph.containsKey(u)) graph.put(u,new ArrayList<>());
            if(!graph.containsKey(v)) graph.put(v,new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return dfs(graph, source, destination);
        
    }
    public boolean dfs(Map<Integer, List<Integer>> graph,int source,int destination)
    {
        if(source==destination) return true;
        if(!graph.containsKey(source)) return false;
        if(visited.contains(source)) return false;
        visited.add(source);
        boolean isReachable = false;
        for(int node : graph.get(source))
        {
            isReachable = isReachable || dfs(graph, node, destination);
        }
        return isReachable;
    }
}