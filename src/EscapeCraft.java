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

  public static byte[] reverse(byte[] bytes) {
    byte[] ret = new byte[bytes.length];
    for (int i = 0; i < bytes.length; i++) {
      ret[bytes.length - (i + 1)] = bytes[i];
    }
    return ret;
  }

  public static byte[] decode(String path) throws IOException {
    byte[] content = readFile(path);
    content = removeFirstBytes(content, 100);
    content = removeLastBytes(content, 100);
    content = removeEvery3Bytes(content);
    content = reverse(content);
    return content;
  }

}
