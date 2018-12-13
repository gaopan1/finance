package TestScript.ADemo;

public class TicketDemo implements Runnable{
	
	private int tickets = 100;
	
	int x = 1;
	
	public void run(){
		
		while(true){
			synchronized(TicketDemo.class){
				if(x<=tickets){
		
						try{
							Thread.sleep(200);
						}catch(Exception e){
							e.printStackTrace();
						}
						
						System.out.println("线程：" + Thread.currentThread().getName()+"x is :::::::" + x);
						
						x++;
				
				}else{
					break;
				}
				
			}
		}
		
	}
	
	
	
	
	

}
