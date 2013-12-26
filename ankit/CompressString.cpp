#include <iostream>
#include <string>
#include <conio.h>
#include <stdlib.h>
using namespace std;

void compress(string s);

int main()
{
   cout << "Hello World" << endl; 
   string s = "aabbbbcccdddd";   
   compress(s);
   
   return 0;
}

void compress(string s)
{
    string compressed="";

    char curr;
    char old='&';
    int cnt=0;
    int x=0;

    for(string::iterator i=s.begin();i!=s.end();i++)
    {
        curr=s.at(x);
        
        if(old==curr)
        {
           
           ++cnt;
        }   
        else
        {
           if(old!='&')
           {
              cout<<old<<cnt;    
           }
           
           cnt=1;
        }
        x++;
        
        old=curr;
        
    }
    cout<<old<<cnt;
    getch();
    //cout <<"compressed string is "<<compressed;
}
