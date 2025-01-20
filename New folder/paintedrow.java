class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int rowLength = mat.length;
        int colLength = mat[0].length;
        int[] rowCount = new int[rowLength];
        int[] colCount = new int[colLength];
        Map<Integer, int[]> map = new HashMap<>();

        
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                int val = mat[i][j];
                map.put(val, new int[]{i, j}); 
            }
        }

        
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int[] pos = map.get(val);
            int row = pos[0];
            int col = pos[1];

            rowCount[row]++;
            colCount[col]++;

            if (rowCount[row] == colLength || colCount[col] == rowLength) {
                return i; 
            }
        }
        return -1;
    }
}
