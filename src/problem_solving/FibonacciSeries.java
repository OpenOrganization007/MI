package problem_solving;

public class FibonacciSeries
{
    
    public static void printFirstnFibonacciNumber(int n){
	int f1 = 1;int f2 = 1;
	if(n <1) return;
	System.out.print(" "+f1);
	for(int i = 3;i<=n+1;i++){
	    System.out.print(" "+f2);
	    f2 = f1+f2;
	   
	}
    }
    
    private static void calculateAreaofCircle(int radious){
	System.out.println("area is "+ Math.PI*radious*radious);
    }
    
    private static void calculateAreaOftrangle(double a,double b,double c){
          double s = (a+b+c)/2;
          System.out.println("area of trangle is"+ Math.sqrt(s*(s-a)*(s-b)*(s-c)));
    }
    private static boolean aresame(int[][]a,int b[][]){
	for(int i=0;i<a.length;i++){
	    for(int j=0;j<a.length;j++){
		if(a[i][j] != b[i][j]){
		    return false;
		}
	    }
	}
	return true;
    }
    
    public static int[][]multMatrix(int[][]a,int[][]b){
	int c[][] = new int[a.length][b.length];
	for(int i=0;i<a.length;i++){
	    for(int j=0;j<b.length;j++){
		for(int k=0;k<a.length;k++){
		    c[i][j] = a[i][k]*b[k][j];
		}
	    }
	}
	return c;
    }
    
    public static int[][] rotate(int[][] matrix) {

	    int N = matrix.length;

	    for(int i = 0; i < N/2; ++i) {

	        for(int j = 0; j < (N+1)/2; ++j) {

	            int temp = matrix[i][j];  // save the top element;

	            matrix[i][j] = matrix[N-1-j][i];  // right -> top;

	            matrix[N-1-j][i] = matrix[N-1-i][N-1-j]; // bottom -> right;

	            matrix[N-1-i][N-1-j] = matrix[j][N-1-i];// left -> bottom;

	            matrix[j][N-1-i] = temp;                // top -> left;

	        }

	    }
	    return matrix;

	}
    
    public static void printMatrix(int[][]arr){
	for(int i=0;i<arr.length;i++){
	    for(int j=0;j<arr.length;j++){
		System.out.print(" "+arr[i][j]);
	    }
	    System.out.println();
	}
    }

    public static void main(String[] args)
    {
	//printFirstnFibonacciNumber(10);
	calculateAreaofCircle(5);
	calculateAreaOftrangle(3, 4,5 );
	int[][]a = {{1,2,3},{4,5,6},{7,8,9}};
	int[][]b = {{1,2,3},{4,5,6},{7,5,9}};
	int [][]result = multMatrix(a, b);
	for(int i=0;i<result.length;i++){
	    for(int j=0;j<result.length;j++){
		System.out.print(" "+result[i][j]);
	    }
	    System.out.println();
	}
	
	printMatrix(rotate(a));
	
	
    }

}
