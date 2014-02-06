#!/usr/local/bin/python2.7


def countones(num):
  i=0;
  count=0;
  while(i<31):
    bit=((num & (1<<i))!=0);
    if(bit):
      count=count+1;
    i=i+1;
  return count;


n=6;
i=0;
large=n+1;
large_found=0;
count_n=countones(n);
count_large=0;

while(large_found==0):
  count_large=countones(large);
  if(count_large==count_n):
    large_found=1;
  else:
    large=large+1;

print "larger element with same no of ones is %d" %large;


small=n-1;
small_found=0;
count_n=countones(n);
count_small=0;

while(small_found==0):
  count_small=countones(small);
  if(count_small==count_n):
    small_found=1;
  else:
    small=small-1;

print "smaller element with same no of ones is %d" %small;