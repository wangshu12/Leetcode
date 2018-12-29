package Algo;

public class FibonacciMatrix {


    public static int[][] UNIT = {{1,1},{1,0}};

    public static void main(String[] args){
        System.out.println(fibonacci(7));
    }

    public static int fibonacci(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[][] result = power(n-1); // if we count 0 as our first fibonacci element.
        return result[0][1];
    }

    public static int[][] power(int n){
        if(n == 1){
            return UNIT;
        }
        int[][] fb = power(n/2);
        if(n%2 == 0){
            return matrixMultiply(fb, fb);
        }else{
            return matrixMultiply(UNIT, matrixMultiply(fb, fb));
        }
    }


    public static int[][] matrixMultiply(int[][] matrix1, int[][]matrix2){
        if(matrix1 == null || matrix2 == null || matrix1.length == 0 || matrix2[0].length == 0) return null;
        int[][] ret = new int[matrix1.length][matrix2[0].length];

        for(int i = 0; i < matrix1.length; i++){
            for(int j = 0; j < matrix2[0].length; j++){
                int sum = 0;
                for(int k = 0; k < matrix1[0].length; k++){
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                ret[i][j] = sum;
            }
        }
        return ret;
    }
}
