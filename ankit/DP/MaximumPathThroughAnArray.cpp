#include <iostream>
using namespace std;

struct route{
    int x;
    int y;
};

typedef route route;
int max(int a,int b) {
    
    return ((a>=b)?a:b);
    
}

int main()
{


    int arr[4][4] = {
                        {1,2,34,5},
                        {5,6,8,33},
                        {8,7,9,12},
                        {1,2,3,4}
                        
                    };
                    
    route ro[4][4];                
    int m[4][4];
    
    m[0][0] = arr[0][0];
    ro[0][0].x=0;
    ro[0][0].y=0;    
    int i,j;
    
    for(i=1;i<4;++i) {
        m[0][i]= m[0][i-1]+arr[0][i];
        ro[0][i].x=0;
        ro[0][i].y=i-1;
    }
    
    for(j=1;j<4;++j) {
        m[j][0] = m[j-1][0]+arr[j-1][0];
        ro[j][0].x=j-1;
        ro[j][0].y=0;
    }
    
    for(i=1;i<4;++i) {
        for(j=1;j<4;++j) {
            if(m[i][j-1]>=m[i-1][j])
            {
                m[i][j]= m[i][j-1]+arr[i][j];
                 ro[i][j].x=i;
                 ro[i][j].y=j-1;
            }
            else
            {
                m[i][j]= m[i-1][j]+arr[i][j];
                ro[i][j].x=i-1;
                ro[i][j].y=j;
            }
        }
    }
    
    cout<<"sum is "<<m[3][3]<<"\n";
        
    cout<<"the route taken is \n";
    int r ;
    i=3;j=3;
    int a,b;
    r=arr[i][j];
    while(r!=arr[0][0])
    {
        cout<<r<<" ";
        a=ro[i][j].x;
        b=ro[i][j].y;
        
        r=arr[a][b];
        i=a;
        j=b;
    }
    
    cout<<arr[0][0];
    
   
   return 0;
}
