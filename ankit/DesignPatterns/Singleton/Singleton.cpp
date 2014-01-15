#include<iostream>
using namespace std;

class Singleton {
    
    private:
        static Singleton *instance;
        Singleton(){};
        Singleton(const Singleton &copy){};
        const Singleton &operator=(const Singleton &copy){};
    public:
      
        static Singleton *getInstance() {
            if(instance==NULL){
                instance = new Singleton();
            }
            return instance;
        }
        
};

Singleton* Singleton::instance=NULL;

int main(){
    
    Singleton *S= Singleton::getInstance();
    delete S;
    return 0;
}
