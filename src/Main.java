import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        byte[] decoded = EscapeCraft.decode("/Users/m/Documents/Projects/escapecraft-kata/CPE1704TKS.txt");
        Files.write(Paths.get("image.png"), decoded);

    }
}
