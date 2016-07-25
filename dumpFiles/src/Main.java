import java.io.IOException;

/**
 * Created by codecadet on 01/06/16.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        FileByteStream cenas = new FileByteStream();

        cenas.readContents("/Users/codecadet/Downloads/teste.txt");

        HexDump dump = new HexDump(cenas.getFileByteContent());
    }
}
