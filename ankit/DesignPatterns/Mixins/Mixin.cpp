#include <iostream>
using namespace std;


class ITask {
    public:
    virtual void Execute()=0;
};

template<class T>
class LogTask: public T
{
    public:
    void Execute() {
        cout<<"Logging task start\n";
        T::Execute();
        cout<<"Logging task end\n";
    } 
};

template<class T>
class TimeTask: public T 
{
    public:
    void Execute() {
        cout<<"TimeTask task start\n";
        T::Execute();
        cout<<"TimeTask task end\n";
    }
    
};

class MyTask {
    public:
    void Execute() {
        cout<<"My Task is executing\n";
    }
};

template<class T>
class TaskAdapter :  public T 
{
    public:
    void EXecute() {
        T::Execute();
    }
};
    


int main()
{
    TaskAdapter<LogTask<TimeTask< MyTask > > > t1;
    
  
   t1.Execute();
   
   return 0;
}
