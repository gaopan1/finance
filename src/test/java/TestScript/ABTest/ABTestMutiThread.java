package TestScript.ABTest;

public class ABTestMutiThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		ABTestThread thread1 = new ABTestThread();
		
		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread1);
		Thread t3 = new Thread(thread1);
		Thread t4 = new Thread(thread1);
		Thread t5 = new Thread(thread1);
		Thread t6 = new Thread(thread1);
		Thread t7 = new Thread(thread1);
		Thread t8 = new Thread(thread1);
		Thread t9 = new Thread(thread1);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		
		
		
		

	}
	
	
	

}
