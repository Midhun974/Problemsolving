public class Solution {  
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        
        
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        
        int[] bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE);
        findBobPath(bob, bobTime, tree);

        
        return dfs(0, -1, 0, 0, tree, bobTime, amount);
    }

    private void findBobPath(int bob, int[] bobTime, List<Integer>[] tree) {
        Map<Integer, Integer> parent = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        parent.put(0, -1);

        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : tree[node]) {
                if (!parent.containsKey(neighbor)) {
                    parent.put(neighbor, node);
                    queue.add(neighbor);
                }
            }
        }

        
        int time = 0;
        while (bob != -1) {
            bobTime[bob] = time++;
            bob = parent.get(bob);
        }
    }

    private int dfs(int node, int parent, int time, int income, List<Integer>[] tree, int[] bobTime, int[] amount) {
        // Determine Alice's share at this node
        if (time < bobTime[node]) {
            income += amount[node]; // Alice takes full amount
        } else if (time == bobTime[node]) {
            income += amount[node] / 2; // Alice and Bob share the amount
        }

        int maxIncome = Integer.MIN_VALUE;
        boolean isLeaf = true;

        for (int neighbor : tree[node]) {
            if (neighbor == parent) continue;
            isLeaf = false;
            maxIncome = Math.max(maxIncome, dfs(neighbor, node, time + 1, income, tree, bobTime, amount));
        }

        return isLeaf ? income : maxIncome;
    }
}
