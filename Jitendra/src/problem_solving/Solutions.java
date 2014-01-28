package problem_solving;


public class Solutions {
    
    public static int missingNumber(int[]arr){
        int[]commonDiff = new int[arr.length-1];
        int missingTerm=0;
        int k=0;
        for(int i=1;i<arr.length;i++){
            for(int j=i-1; j < i ;j++){
            commonDiff[k] = arr[i]-arr[j];
             k++;
            }
        }
        
        int firstDiff = commonDiff[0];
        for(int i=1;i<commonDiff.length;i++){
            if(firstDiff == commonDiff[i]){
                continue;
            }else{
               missingTerm = (arr[i]+arr[i+1])/2;
              break;
            }
        }
        return missingTerm;
    }
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        int []arr ={51, 11, 31, 41, 51 };
            System.out.println(missingNumber(arr));
            
    }
}