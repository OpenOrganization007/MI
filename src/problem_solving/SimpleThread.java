package problem_solving;

public class SimpleThread extends Thread {
	private int value;
	public SimpleThread(int num) {
		this.value= num;
		start();
	}
	@Override
	public void run() {
		while(true){
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print(value +"\t");
				
			}
		}
	}
}