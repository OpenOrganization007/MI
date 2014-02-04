#!/usr/local/bin/python2.7
    
def findkthNum(k):
  cnt=0;
  adder=105;
  i=0;
  while(cnt!=k):
    cnt+=1;
    i+=adder;
  return i;

n=findkthNum(3);
print "3rd number is %d" %n;
