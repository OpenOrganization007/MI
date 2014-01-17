#include<iostream>
#include<string>
#include<vector>
using namespace std;

class Wheel;
class Engine;
class Body;
class Car;

class CarElementVisitor {
    public:
    virtual void visit(Wheel*)=0;
    virtual void visit(Engine*)=0;
    virtual void visit(Body*)=0;
    virtual ~CarElementVisitor();
};

class CarElement {
    public:
    virtual void accept(CarElementVisitor*)=0;
    virtual ~CarElement();
};

// wheel element, there are four wheels with unique names
class Wheel : public CarElement
{
public:
  Wheel(string n):name(n){}
  void print() {
      cout<<"name"<<name<<"\n";
  }
  void accept(CarElementVisitor *visitor)  
  {
    visitor->visit(*this);
  }
private:
    string name;
};
 
// engine
class Engine : public CarElement
{
public:
  Engine(string n):name(n){}
  void print() {
      cout<<"name"<<name<<"\n";
  }
  void accept(CarElementVisitor *visitor) 
  {
    visitor->visit(*this);
  }
  private:
    string name;
};
 
// body
class Body : public CarElement
{
public:
  Body(string n):name(n){}
  void print() {
      cout<<"name"<<name<<"\n";
  }
  void accept(CarElementVisitor *visitor) 
  {
    visitor->visit(*this);
  }
private:
    string name;
};
 
class Car 
{
public:
  vector<CarElement*>& getElements()
  {
    return elements_;
  }
  Car() 
  {
    // assume that neither push_back nor Wheel(const string&) may throw
    elements_.push_back( new Wheel("front left") );
    elements_.push_back( new Wheel("front right") );
    elements_.push_back( new Wheel("back left") );
    elements_.push_back( new Wheel("back right") );
    elements_.push_back( new Body() );
    elements_.push_back( new Engine() );
  }
  ~Car()
  {
    for(vector<CarElement*>::iterator it = elements_.begin(); 
      it != elements_.end(); ++it)
    {
      delete *it;
    }
  }
private:
  vector<CarElement*> elements_;
};

class CarElementPrintVisitor : public CarElementVisitor 
{
public:
  void visit(Wheel *wheel) const
  { 
    cout << "Visiting " << wheel->getName() << " wheel" << endl;
  }
  void visit(Engine  *engine) const
  {
    cout << "Visiting engine" << endl;
  }
  void visit(Body * body) const
  {
    cout << "Visiting body" << endl;
  }
  void visitCar(Car * car) const
  {
    cout << endl << "Visiting car" << endl;
    vector<CarElement*>& elems = car.getElements();
    for(vector<CarElement*>::iterator it = elems.begin();
      it != elems.end(); ++it )
    {
      (*it)->accept(*this);    // this issues the callback i.e. to this from the element  
    }
    cout << "Visited car" << endl;
  }
};

class CarElementPrintVisitor:public CarElementVisitor {
    
};


int main()
{
  Car car;
  CarElementPrintVisitor printVisitor;
  CarElementDoVisitor doVisitor;
 
  printVisitor.visitCar(car);
  doVisitor.visitCar(car);
 
  return 0;
}
