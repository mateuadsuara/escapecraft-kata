import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FileOutputStream os = new FileOutputStream("data.bin");
        os.write(new byte[] {0x00, 0x01, 0x02});
    }
}
