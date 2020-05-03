import java.io.*;
import java.util.*;
import java.lang.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Function;

interface LibraryMapping extends Library{

	int addition(int Number1,int Number2);

}

public class MultiThread extends Thread{

	private int number1;
	private int number2;
	private static NativeLibrary nativeLibrary;
	private static Function function;

	static{

		nativeLibrary.addSearchPath("add", "/home/local/ZOHOCORP/arun-pttk3561/JavaNativeAccess/LoadLibrary/");
		nativeLibrary=NativeLibrary.getInstance("add");
		function=nativeLibrary.getFunction("addition");
		System.out.println("Instance Loaded");

	}

	MultiThread(int Number1 , int Number2){

		this.number1=Number1;
		this.number2=Number2;

	}

	public void run(){

        	try{  
				System.out.println( "Thread : "+Thread.currentThread().getName()
				+" with the value  "+this.number1+" , "+this.number2
				+" and their sum is --->"+function.invokeInt(new Object[] {this.number1,this.number2}));   	          
        	} 
        	catch (Exception e) 
        	{ 
            		e.printStackTrace(); 
		}
		 
    	}
 
	public static void execute(){

		String line;
		String array[];
		BufferedReader br=null;
		try{
			br=new BufferedReader(new FileReader("/home/local/ZOHOCORP/arun-pttk3561/JavaNativeAccess/LoadLibrary/values.txt"));
			while( (line=br.readLine()) != null ){
				if( line.length() == 0 ){
					break;
				}
				array=line.split(" ");
				MultiThread threads=new MultiThread(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
				threads.start();
			}
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}finally{
			if( br!=null ){
				try{
					br.close();
				}catch(IOException e){
					e.printStackTrace();
				}
				
			}
		}

	}

	public static void main(String arg[]){

		execute();
		
	}

}
