#include <iostream>
#include <algorithm>
#include <list>
using namespace std;

class ObserverBoardInterface {
    public:
    virtual void update(int a,int b,int c)=0;
};

class DisplayBoardInteface {
    public:
    virtual void show()=0;
};

class WeatherDataInterface {
    public:
    virtual void registerOb(ObserverBoardInterface*)=0;
    virtual void removeOb(ObserverBoardInterface*)=0;
    virtual void notifyOb()=0;
};

class ParaWeatherData : public WeatherDataInterface {
    private:
    int humidity;
    int temperature;
    int pressure;
    list <ObserverBoardInterface*> obs;
    
    public:
    
    void sensorDataChange(int a,int b,int c) {
        humidity=a;
        temperature=b;
        pressure=c;
        notifyOb();
    }
    
     void registerOb(ObserverBoardInterface* ob)
    {
        obs.push_back(ob);
    }
 
    void removeOb(ObserverBoardInterface* ob)
    {
        obs.remove(ob);
    }
    
    
    void notifyOb() {
        list<ObserverBoardInterface*>::iterator pos = obs.begin();
        while(pos!=obs.end()) {
            (*pos)->update(humidity,temperature,pressure);
            //(dynamic_cast<DisplayBoardInterface*>(*pos))->show();
            ++pos;
        }
    }

    
};

class CurrentConditionBoard :public ObserverBoardInterface,public DisplayBoardInterface
{
  private:
  int t,h,p;
  ParaWeatherData* pdata;
  public:
  CurrentConditionBoard(ParaWeatherData* d) {
      pdata=d;
      pdata->registerOb(this);
  }
  
  void update(int a ,int b , int c) {
      t=a;
      h=b;
      p=c;
  }
  
  void show() {
      cout<<"humidity"<<h<<"\n";
      cout<<"pressure"<<p<<"\n";
      cout<<"temperature"<<t<<"\n";
  }
  
  
        
};


int main()
{
   ParaWeatherData* pdata = new ParaWeatherData;
   CurrentConditionBoard *brd = new CurrentConditionBoard(pdata);
   pdata->sensorDataChange(3,4,6);
   pdata->sensorDataChange(7,8,9);
   return 0;
}
