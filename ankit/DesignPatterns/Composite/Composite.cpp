#include <vector>
#include <iostream> // std::cout
#include <memory> // std::auto_ptr
#include <algorithm> // std::for_each
#include <functional> // std::mem_fun
using namespace std;

class Graphic {
    public:
    virtual void print() const = 0;
    virtual ~Graphic();
};

    
class Ellipse : public Graphic {
    public:
    void print() {
        cout<<"Ellipse  \n";
    }
};

class CompositeGraphic : public Graphic 
{
    private:
        vector<Graphic*> cmpG;
    public:
        void addGraphic(Graphic *g) {
            cmpG.push_back(g);
        }
        void print() {
            for_each(cmpG.begin(),cmpG.end(),mem_fun(&Graphic::print));
        }
}

int main()
{
   auto_ptr<Ellipse > a1(new Ellipse());
   auto_ptr<Ellipse > a2(new Ellipse());
   auto_ptr<Ellipse > a3(new Ellipse());

   // Initialize three composite graphics
   const auto_ptr<CompositeGraphic> graphic(new CompositeGraphic());
   const auto_ptr<CompositeGraphic> graphic1(new CompositeGraphic());
   const auto_ptr<CompositeGraphic> graphic2(new CompositeGraphic());
 
   // Composes the graphics
   graphic1->add(a1.get());
   graphic1->add(a2.get());
   graphic1->add(a3.get());
 
   
 
   graphic->add(graphic1.get());
   graphic->add(graphic2.get());
 
   // Prints the complete graphic (four times the string "Ellipse")
   graphic->print();
   return 0;
}
 

