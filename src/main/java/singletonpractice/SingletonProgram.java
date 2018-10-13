package singletonpractice;

public class SingletonProgram {
	
	private static SingletonProgram instance_Variable=null;
	
	public String str;
	
	private SingletonProgram() {
		 str="Hi, i am working on singleton program";
	} 
	
	public static SingletonProgram getInstance() {
		if (instance_Variable==null)
			instance_Variable =new SingletonProgram();
		return instance_Variable;
	}
	
	public static void main(String args[]) {
		SingletonProgram a=SingletonProgram.getInstance();
		SingletonProgram b=SingletonProgram.getInstance();
		SingletonProgram c=SingletonProgram.getInstance();
		
		(a.str)=(a.str).toUpperCase();
		
		System.out.println(a.str);
		System.out.println(b.str);
		System.out.println(c.str);
	}
	

}
