#include<iostream>
using namespace std;

int run( int n) {
    static int r =0 ;
    
  
    if(n>=3) {
        cout<<n<<" ";
        run(n-3);
    }
    
    if(n>=2) {
        cout<<n<<" ";
        run(n-2);
    }
    
    if(n>=1) {
         cout<<n<<" ";
        run(n-1);
    }
    
    if(n<1)
    {
         cout<<"\n";
    
        r++;
    }
    return r;
}
int main() {
    
    int a = run(3);
    cout<<"number of paths"<<a;
    return 0;
}