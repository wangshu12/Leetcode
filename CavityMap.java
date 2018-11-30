static String[] cavityMap(String[] grid) {
        String[] ret = new String[0];
        List<Integer> list = new ArrayList<>();
        if(grid == null) return ret;
        if(grid.length < 1 || grid[0].length() < 1) return ret;

        for(int i = 1; i < grid.length - 1; i++){
            for(int j = 1; j < grid[0].length() - 1; j++){
                if(grid[i].charAt(j) > grid[i - 1].charAt(j) &&
                grid[i].charAt(j) > grid[i].charAt(j - 1) &&
                grid[i].charAt(j) > grid[i + 1].charAt(j) &&
                grid[i].charAt(j) > grid[i].charAt(j + 1)){
                    list.add(i);
                    list.add(j);
                }
            }
        }
        for(int i = 0; i < list.size(); i++){
            int index1 = list.get(i++);
            int index2 = list.get(i);
            char[] arr = grid[index1].toCharArray();
            arr[index2] = 'X';
            grid[index1] = String.valueOf(arr);
        }
        return grid;
}