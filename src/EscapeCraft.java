import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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

  public static byte[] removeEvery3Bytes(byte[] content) {
    ArrayList<Byte> bytes = new ArrayList<>();
    for (int i = 0; i < content.length; i++) {
      if (i % 3 == 2) {
        continue;
      }
      bytes.add(content[i]);
    }
    byte[] ret = new byte[bytes.size()];
    for (int i = 0; i < ret.length; i++) {
      ret[i] = bytes.get(i);
    }
    return ret;
  }
}
