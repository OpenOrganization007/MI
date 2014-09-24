package problem_solving;


public class Main {
	
	public static int rev(int n){

	int   right =0; 
	while(n>0){
		right = right*10+n%10;
		n = n/10;
	}
		return right;
	}

	public static void main(String[] args) {
//		System.out.println(rev(4568));
		 int x = 10;
        for (int y=0; y<5; y++, x--)
            System.out.print(x + ", ");
		
	}

}
