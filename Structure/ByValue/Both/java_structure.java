import java.util.Arrays;
import java.util.List;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;

interface CLibrary extends Library{

    class Point extends Structure{

        public int x, y;
        protected List getFieldOrder() {
            return Arrays.asList( new String[] {"x","y"});
        }
        public static class ByValue extends Point implements Structure.ByValue {}

    }
    public Point.ByValue ExchangeData(Point.ByValue pt);

}

public class java_structure {

    private static CLibrary cLibrary=null;
    
    static{

        cLibrary=(CLibrary)Native.loadLibrary("c_structure",CLibrary.class);

    }

    public static void execute(){

        CLibrary.Point.ByValue pt=new CLibrary.Point.ByValue();
        pt.x=100;
        pt.y=100;
        CLibrary.Point result=cLibrary.ExchangeData(pt);
        System.out.println("-----Value Passed From C(Printed In Java)-----");
        System.out.println("x="+result.x+" y="+result.y);

    }

    public static void main(String args[]){

        execute();

    }

}
