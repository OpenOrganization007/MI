#include <iostream>
#include <vector>
#include <utility>
using namespace std;

#define M 4 
#define N 4

int main()
{
   int arr [M][N] = {  { 4,4,4,4 } ,
                     { 4,0,4,4 } ,
                     { 4,4,0,4 } ,
                     { 4,4,4,4 }
                  };
                  
    for(int i=0;i<M;i++)
    {
        for(int j=0;j<N;j++)
        {
            cout<<arr[i][j]<<" ";
        }
        cout<<"\n";
    }     
    
    pair<int,int> p;
    vector<pair<int,int>> loc_of_zero;
    
    for(int i=0;i<M;i++)
    {
        for(int j=0;j<N;j++)
        {
            if(arr[i][j]==0)
            {
                p=make_pair(i,j);
                cout <<"zero at "<<i<<" "<<j<<"\n";
                loc_of_zero.push_back(p);
            }
        }
    }
    
    int x,y;
    std::vector<std::pair<int, int> >::iterator it;
    for(it=loc_of_zero.begin();it!=loc_of_zero.end();it++)
    {
        
        p= *it;
        x= p.first;
        y= p.second;
        
        for(int i=0;i<M;i++)
        {
            arr[i][y]=0;
        }
        for(int j=0;j<N;j++)
        {
            arr[x][j]=0;
            
        }
        
    }
    
    for(int i=0;i<M;i++)
    {
        for(int j=0;j<N;j++)
        {
            cout<<arr[i][j]<<" ";
        }
        cout<<"\n";
    }           
       
                  
   
   return 0;
}
