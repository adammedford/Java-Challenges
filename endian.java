import java.nio.ByteOrder;

//Write a program which prints the endianness of the system.
//Print to stdout the endianness, wheather it is LittleEndian or BigEndian.
public class Main
{
    
    public static void main (String[] args)
    {
        if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN)) {
            System.out.println("BigEndian");
        } else {
            System.out.println("LittleEndian");
        }
    }
}