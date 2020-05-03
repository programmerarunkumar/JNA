import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Memory;
import com.sun.jna.Library;

interface CLibrary extends Library{

    public void sum(Pointer pt, int row, int col);

}

public class java_array{

    private static CLibrary clib;

    static{

        clib=(CLibrary)Native.loadLibrary("c_array",CLibrary.class);

    }

    public static void execute(){

        int row,col,size;
        row=3;
        col=3;
        size=row*col;
        Pointer pt=new Memory(size*Native.getNativeSize(Integer.TYPE));
        for(int i=0;i<size;i++){
            pt.setInt(i*Native.getNativeSize(Integer.TYPE), i);
        }
        clib.sum(pt, row, col);

    }

    public static void main(String args[]){

        execute();

    }
    
}
