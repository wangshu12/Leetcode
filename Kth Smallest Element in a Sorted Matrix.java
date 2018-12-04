

class Solution {
    private int countLessEqual(int[][] matrix, int val){
        int count = 0;
        int i = matrix.length - 1;
        int j = 0;
        while(i >= 0 && j < matrix[0].length){
            if(matrix[i][j] > val){
                i--;
            }else{
                count += i + 1;
                j++;
            }
        }
        return count;
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0 || k == 0) return -1;
        int min = matrix[0][0];
        int max = matrix[matrix.length - 1][matrix[0].length - 1] + 1;
        while(min < max){
            int mid = min + (max - min) / 2;
            int count = countLessEqual(matrix, mid);
            if(count < k) min = mid + 1;
            else max = mid;
        }
        return min;
    }
    
    
    
// 1. Build a minHeap of elements from the first row.
// 2. Do the following operations k-1 times :
// Every time when you poll out the root(Top Element in Heap), you need to know the row number and column number of that element(so we can create a tuple class here), replace that root with the next element from the same column.    
    public int kthSmallest2(int[][] matrix, int k){
        int ret = -1;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0 || k == 0) return ret;
        Comparator<int[]> comp = new Comparator<int[]>(){
            public int compare(int[] i1, int[] i2){
                return matrix[i1[0]][i1[1]] - matrix[i2[0]][i2[1]];
            }
        };
        PriorityQueue<int[]> queue = new PriorityQueue<>(comp);
        for(int i = 0; i < matrix[0].length; i++){
            queue.add(new int[]{0, i});
        }
        
        while(k > 0 && !queue.isEmpty()){
            k--;
            int[] coor = queue.poll();
            if(k == 0){
                return matrix[coor[0]][coor[1]];
            }
            if(coor[0] == matrix.length - 1) continue;
            queue.add(new int[]{coor[0]+1, coor[1]});
        }
        return ret;
    }
}