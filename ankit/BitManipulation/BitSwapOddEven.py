#!/usr/local/bin/python2.7

def update(num,ithPos,upBit):
  mask=~(1<<ithPos);
  return (num & mask)|(upBit<<ithPos);


def swapOddEven(num):
  i=0;
  odd=0;
  even=0;
  while(i<32):
    odd=(num & (1<<(i+1)));
    even=(num & (1<<(i)));
    if(odd!=even):
      # swap odd and even bits odd will have even n even odd
      num=update(num,i+1,even);
      num=update(num,i,odd);
    i=i+2;
  return num;  


n=10;
newn=swapOddEven(n);
print "number after swap is %d" %newn;