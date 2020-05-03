import java.util.Arrays;
import java.util.List;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;

interface CLibrary extends Library{

    public class SampleStruct extends Structure{

        public int val;
        protected List getFieldOrder(){

            return Arrays.asList( new String[] {"val"});
            
        }
        public static class ByReference extends SampleStruct implements Structure.ByReference {}
        
    }
    public SampleStruct.ByReference getStruct();
    
}

public class java_structure{

    private static CLibrary clib=null;

    static{

        clib = (CLibrary)Native.loadLibrary("c_structure", CLibrary.class);
        
    }

    public static void execute(){

        CLibrary.SampleStruct.ByReference obj = clib.getStruct();
        System.out.println("-----Value Passed From C(Printed In Java)-----");
        System.out.println("Value : "+obj.val);
        
    }

    public static void main(String args[]){

        execute();

    }
    
}
