import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

interface CLibrary extends Library{
 
    void sum(int a[], int row, int col);
}

public class java_array{

    private static CLibrary clib;
    
    static{

        clib=(CLibrary)Native.loadLibrary("c_array",CLibrary.class);

    }

    public static void execute(){

        int row=3;
        int col=3;
        int index=0;
        int a[]=new int[row*col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                index=i*col+j;
                a[index]=index;
            }
        }
        clib.sum(a,row,col);

    }

    public static void main(String args[]){

        execute();
                
    }
    
}
