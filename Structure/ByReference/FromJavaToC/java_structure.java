import java.util.Arrays;
import java.util.List;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;

interface CLibrary extends Library{

    public class SampleStruct extends Structure{

        public int val;
        protected List getFieldOrder(){

            return Arrays.asList( new String[] {"val"} );

        }
        public static class ByReference extends SampleStruct implements Structure.ByReference {}
        
    }
    public void setStruct(SampleStruct.ByReference sval);

}

public class java_structure {

    private static CLibrary clib;
    
    static{

        clib = (CLibrary)Native.loadLibrary("c_structure", CLibrary.class);

    }

    public static void execute(){

        CLibrary.SampleStruct.ByReference obj = new CLibrary.SampleStruct.ByReference();
        obj.val=7;
        clib.setStruct(obj);

    }
    
    public static void main(String args[]){

        execute();

    }

}
