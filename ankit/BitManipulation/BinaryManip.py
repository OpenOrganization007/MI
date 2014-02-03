#!/usr/local/bin/python2.7
    
def countManipRequired(num1,num2):
  i=0;
  count=0;
  while(i<31):
    bit1=((num1 & (1<<i))!=0);
    bit2=((num2 & (1<<i))!=0);
    if(bit1!=bit2):
      count=count+1;
    i=i+1;  
  
  return count;
  
n1=7;
n2=8;
cnt=countManipRequired(n1,n2);
print "number of manipulations required to convert %d to %d is %d" %(n1,n2,cnt);