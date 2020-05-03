import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Memory;
import com.sun.jna.Library;

interface CLibrary extends Library{

    public void sum(Pointer pt, int size);

}

public class java_array{

    private static CLibrary clib;

    static{

        clib=(CLibrary)Native.loadLibrary("c_array",CLibrary.class);

    }

    public static void execute(){

        int size=101;
        Pointer pt=new Memory(size*Native.getNativeSize(Integer.TYPE));
        for(int i=0;i<101;i++){
            pt.setInt(i*Native.getNativeSize(Integer.TYPE), i);
        }
        clib.sum(pt, size);

    }

    public static void main(String args[]){

        execute();

    }

}
