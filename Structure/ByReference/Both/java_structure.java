import java.util.Arrays;
import java.util.List;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;

interface CLibrary extends Library{

    public class Point extends Structure {

        public int x, y;
        protected List getFieldOrder() {

            return Arrays.asList( new String[] {"x","y"});

        }
        public static class ByReference extends Point implements Structure.ByReference {}

    }
    public Point.ByReference ExchangeData(Point.ByReference pt);

}

public class java_structure {

    private static CLibrary cLibrary;

    static{

        cLibrary=(CLibrary)Native.loadLibrary("c_structure",CLibrary.class);
        
    }

    public static void execute(){

        CLibrary.Point.ByReference pt =new CLibrary.Point.ByReference();
        pt.x=100;
        pt.y=100;
        CLibrary.Point.ByReference result=cLibrary.ExchangeData(pt);
        System.out.println("-----Value Passed From C(Printed In Java)-----");
        System.out.println("x="+result.x+" y="+result.y);

    }

    public static void main(String args[]){

        execute();

    }

}
