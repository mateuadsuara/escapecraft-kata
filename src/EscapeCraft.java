import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class EscapeCraft {
  public static byte[] readFile(String filePath) throws IOException {
    return Files.readAllBytes(Paths.get(filePath));
  }

  public static byte[] removeFirstBytes(byte[] content, int amount) {
    return Arrays.copyOfRange(content, amount, content.length);
  }

  public static byte[] removeLastBytes(byte[] content, int amount) {
    return Arrays.copyOfRange(content, 0, content.length - amount);
  }
}
