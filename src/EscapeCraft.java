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
    return getPrimitive(bytes);
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

  public static byte[] keepFirstBytes(byte[] content, int amount) {
    return Arrays.copyOfRange(content, 0, amount);
  }

  public static byte[] keepsEvery3Bytes(byte[] content) {
    ArrayList<Byte> bytes = new ArrayList<>();
    for (int i = 0; i < content.length; i++) {
      if (i % 3 == 2) {
        bytes.add(content[i]);
      }
    }
    return getPrimitive(bytes);
  }

  private static byte[] getPrimitive(ArrayList<Byte> bytes) {
    byte[] ret = new byte[bytes.size()];
    for (int i = 0; i < ret.length; i++) {
      ret[i] = bytes.get(i);
    }
    return ret;
  }

  public static byte[] keepLastBytes(byte[] content, int amount) {
    return Arrays.copyOfRange(content, content.length - amount, content.length);
  }

  public static byte[] decode2(String path) throws IOException {
    byte[] content = readFile(path);
    byte[] firstBytes = keepFirstBytes(content, 100);
    byte[] remainingEvery3Bytes = keepsEvery3Bytes(removeLastBytes(removeFirstBytes(content, 100), 100));
    byte[] lastBytes = keepLastBytes(content, 100);
    content = removeEvery3Bytes(content);
    content = reverse(content);
    return content;
  }

  public static byte[] concat(byte[] a, byte[] b, byte[] c) {
    byte[] ret = new byte[a.length + b.length + c.length];

    System.arraycopy(a, 0, ret, 0, a.length);

    System.arraycopy(b, 0, ret, a.length, b.length);

    System.arraycopy(c, 0, ret, a.length + b.length, c.length);

    return ret;
  }
}
