package TestScript.Fanshe;

public class CurrentLine {

	/**
	  * @param args
	  */
	  public static void main(String[] args) {
		  
		  
		  
		  try {
			  
			  Student.play();
			  
		} catch (Exception e) {
			StackTraceElement[] stes = e.getStackTrace();
			
			System.out.println(stes.length);
			
			for(StackTraceElement ste : stes){
				System.out.println(ste.getFileName() + ":::::" + ste.getLineNumber());
			}
			
		}
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
//	    StackTraceElement ste1 = null;
//	    // get current thread and its related stack trace
//	    StackTraceElement[] steArray = Thread.currentThread().getStackTrace();
//	    int steArrayLength = steArray.length;
//	    String s = null;
//	    // output all related info of the existing stack traces
//	    if(steArrayLength==0) {
//	      System.err.println("No Stack Trace.");
//	    } else {
//	      for (int i=0; i<steArrayLength; i++) {
//	        System.out.println("Stack Trace-" + i);
//	        ste1 = steArray[i];
//	        s = ste1.getFileName() + ": Line " + ste1.getLineNumber();
//	        System.out.println(s);
//	      }
//	    }
//	    // the following code segment will output the line number of the "new " clause
//	    // that's to say the line number of "StackTraceElement ste2 = new Throwable().getStackTrace()[0];"
//	    StackTraceElement ste2 = new Throwable().getStackTrace()[0];
//	    System.out.println(ste2.getFileName() + ": Line " + ste2.getLineNumber());
//	    // the following clause will output the line number in the external method "getLineInfo()"
//	    System.out.println(getLineInfo());
//	    // the following clause will output its current line number
//	    
//	    StackTraceElement[] element = new Throwable().getStackTrace();
//	    System.out.println(getLineInfo(element[0]));
//	    System.out.println(element.length);
	   
	    
	  }
	  /**
	  * return current java file name and code line number
	  * @return String
	  */
	  public static String getLineInfo() {
	    StackTraceElement ste3 = new Throwable().getStackTrace()[0];
	    return (ste3.getFileName() + ": Line " + ste3.getLineNumber());
	  }
	  /**
	  * return current java file name and code line name
	  * @return String
	  */
	  /*public static String getLineInfo(StackTraceElement ste4) {
	    return (ste4.getFileName() + ": Line " + (ste4.getLineNumber()));
	  }*/
	
	  
	  
	  public static String getLineInfo(StackTraceElement ste5){
		  return (ste5.getFileName() + ": Line is :" + ste5.getLineNumber() + " method is :" + ste5.getMethodName());
	  }
	
	
	
}
