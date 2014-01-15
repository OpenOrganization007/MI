#include <iostream>
using namespace std;
class DrawAPI {
    public:
    virtual void drawCircle(double x, double y , double r)=0;
    ~DrawAPI();
};

class DrawAPI1 :public DrawAPI {
    public: 
    DrawAPI1() {};
    void drawCircle(double x, double y , double r) {
        cout<<"draw circle"<<x<<y<<r;
    }
    ~DrawAPI1(){};
};

class DrawAPI2:public DrawAPI {
    public:
     DrawAPI2() {};
     void drawCircle(double x, double y , double r) {
        cout<<"draw circle"<<x<<y<<r;
    }
     ~DrawAPI2(){};
};


class Shape {
    public:
     virtual ~Shape() {}
     virtual void draw() = 0;
};

/* Refined Abstraction*/
class CircleShape : public Shape {
  public:
   CircleShape(double x, double y,double radius, DrawAPI *drawingAPI) :
       m_x(x), m_y(y), m_radius(radius), m_drawingAPI(drawingAPI)
   {}
   void draw() {
      m_drawingAPI->drawCircle(m_x, m_y, m_radius);
   }
   ~CircleShape() {};
  private:
   double m_x, m_y, m_radius;
   DrawAPI *m_drawingAPI;
};

int main()
{
   DrawAPI* d1 =  new DrawAPI1();
   DrawAPI* d2 =  new DrawAPI2();
   CircleShape circle1(1,2,3,d1);
   CircleShape circle2(5,7,11,d2);
   
   
   circle1.draw();
   circle2.draw();
   return 0;
}
