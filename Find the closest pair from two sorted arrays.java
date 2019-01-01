public int[] find closestPair(int[] array1, int[] array2, int target){
	if(array1 == null || array2 == null) return null;
	int[] ret = new int[2];
	if(array1.length == 0 ||array2.length == 0) return ret;
	int index1 = 0;
	int index2 =array2.length - 1;
	int ret_idx1 = -1;
	int ret_idx2 = -1;
	int min_diff = Integer.MAX_VALUE;
	while(index1 < array1.length && index2 >= 0){
		int sum = array1[index1] + array2[index2];
		if(sum == target){
			return new int[]{index1, index2};
		}
		if(Math.abs(sum - target) < min_diff){
			min_diff = Math.abs(sum - min_diff);
			ret_idx1 = index1;
			ret_idx2 = index2;
		}
		if(sum < target){
			index1++
		}else{
			index2--;
		}
	}
	return new int[]{ret_idx1, ret_idx2};
}