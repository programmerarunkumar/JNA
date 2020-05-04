import com.sun.jna.Native;
import com.sun.jna.Library;
import com.sun.jna.ptr.DoubleByReference;

interface CLibrary extends Library{

    public void setDouble(DoubleByReference val);

}

public class java_double{

    private static CLibrary clib;

    static{

        clib=(CLibrary)Native.loadLibrary("c_double",CLibrary.class);

    }

    public static void execute(){

        double value = 5.9;
        DoubleByReference obj = new DoubleByReference(value);
        clib.setDouble(obj);

    }

    public static void main(String args[]){

        execute();

    }
}
