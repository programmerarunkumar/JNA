import com.sun.jna.Native;
import com.sun.jna.Library;
import com.sun.jna.ptr.DoubleByReference;

interface CLibrary extends Library{

    public DoubleByReference getDouble();
    
}

public class java_double{

    private static CLibrary clib=null;

    static{

        clib=(CLibrary)Native.loadLibrary("c_double",CLibrary.class);

    }

    public static void execute(){

        DoubleByReference obj=clib.getDouble();
        System.out.println("-----Value Passed From C(Printed In Java)-----");
        System.out.println("Value : "+obj.getValue());

    }

    public static void main(String args[]){

        execute();

    }

}
