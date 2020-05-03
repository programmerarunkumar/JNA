import java.io.*;
import java.util.*;
import java.lang.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

interface LibraryMapping extends Library{

	int addition(int Number1,int Number2);

}

public class MultiThread extends Thread {

	private int number1;
	private int number2;
	private int sum;
	private static LibraryMapping instance;

	static{

		//Mapping the Method in libadd.so with LibraryMapping
		instance=(LibraryMapping)Native.loadLibrary("/home/local/ZOHOCORP/arun-pttk3561/JavaNativeAccess/LoadLibrary/libadd.so", LibraryMapping.class);
		System.out.println("Instance Loaded");

	}

	MultiThread(int Number1 , int Number2){

		this.number1=Number1;
		this.number2=Number2;
		
	}

	public void run(){

        	try
        	{  
				this.sum=instance.addition(this.number1, this.number2);
				System.out.println( "Thread : "+Thread.currentThread().getName()
				+" with the value  "+this.number1+" , "+this.number2+" and their sum is --->"+this.sum);   	          
        	} 
        	catch(Exception e) 
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
