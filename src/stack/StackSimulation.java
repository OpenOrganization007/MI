
import java.util.Stack;

public class StackSimulation
{
    public static final int MAX = 10;
    int arr[] = new int[MAX];
    Stack<Integer> min = new Stack<Integer>();
    int top = -1;

    public void push(int item)
    {

	if (isEmpty())
	{
	    arr[++top] = item;
	    min.push(item);

	}
	else
	{
	    arr[++top] = item;
	    int x = min.peek();
	    if (item <= x)
		min.push(item);
	    else
		min.push(x);
	}

    }

    public int pop()
    {
	if (isEmpty())
	{
	    System.out.println("Stack is Empty..");
	}
	min.pop();
	return arr[top--];

    }

    public int getMin()
    {
	int x = min.pop();
	min.push(x);
	return x;
    }

    public boolean isEmpty()
    {
	if (top == -1)
	{
	    return true;
	}
	return false;
    }

    public boolean isFull()
    {
	if (top == MAX - 1)
	{
	    return true;
	}
	return false;
    }

    public static void main(String[] args)
    {
	Stack1 s = new Stack1();
	s.push(4);
	s.push(10);
	s.push(1);
	s.push(76);

	System.out.println("minimum of stack " + s.getMin());
	System.out.println("pop element " + s.pop());
	s.push(22);
	System.out.println("next min is " + s.getMin());

    }

}
