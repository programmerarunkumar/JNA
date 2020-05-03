import com.sun.jna.Native;
import com.sun.jna.Library;

interface CLibrary extends Library{

    public void sum(int a[], int size);

}

public class java_array{

    private static CLibrary clib=null;

    static{

        clib=(CLibrary)Native.loadLibrary("c_array",CLibrary.class);

    }

    public static void execute(){

        int size=101;
        int a[]=new int[size];
        for(int i=0;i<size;i++){
            a[i]=i;
        }
        clib.sum(a,size);

    }

    public static void main(String args[]){

        execute();

    }
    
}
