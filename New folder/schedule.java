class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean mat[][]=new boolean[numCourses][numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int s=prerequisites[i][0];
            int d=prerequisites[i][1];
            mat[s][d]=true;
        }
        for(int k=0;k<numCourses;k++){
            for(int d=0;d<numCourses;d++){
                for(int s=0;s<numCourses;s++){
                    mat[s][d]=mat[s][d] || (mat[s][k] && mat[k][d]);
                }
            }
        }
        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            int s=queries[i][0];
            int d=queries[i][1];
            ans.add(mat[s][d]);
        }
        return ans;
    }
}