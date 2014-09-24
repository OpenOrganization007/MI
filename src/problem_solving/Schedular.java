package problem_solving;


public class Schedular{

			static final int COUNT =3;
		    static final int SLEEP = 100;


	public static void main(String[] args) {
		 SimpleThread[ ]thread = new SimpleThread[COUNT];
		 for(int i =0;i<COUNT;++i){
			 thread[i] = new SimpleThread(i+1);
		 }
	int index =0;
	while(true){
		synchronized (thread[index]) {
			thread[index].notify();
		}
		try{
			Thread.sleep(SLEEP);
		}catch(InterruptedException e){
			throw new RuntimeException(e);
		}
		index = (++index)%COUNT;
	}

        }
}

