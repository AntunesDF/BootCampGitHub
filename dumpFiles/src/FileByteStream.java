import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by codecadet on 01/06/16.
 */
public class FileByteStream {

    public byte[] fileByteContent = new byte[1024];


    public void readContents(String path) throws IOException {

        FileInputStream stream = new FileInputStream(path);

        stream.read(fileByteContent);

        stream.close();
    }


    public byte[] getFileByteContent() {
        return fileByteContent;
    }

}
