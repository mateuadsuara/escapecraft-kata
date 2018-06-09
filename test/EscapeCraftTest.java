import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class EscapeCraftTest {
  @Test
  public void readsTheFileContent() throws IOException {
    byte[] content = EscapeCraft.readFile("/Users/m/Documents/Projects/escapecraft-kata/test/data/sample.bin");
    assertThat(content, is(new byte[]{0x00, 0x01, 0x02}));
  }

  @Test
  public void removesTheFirstBytes() {
    byte[] bytes = EscapeCraft.removeFirstBytes(new byte[]{0x01, 0x02, 0x03}, 1);
    assertThat(bytes, is(new byte[]{0x02, 0x03}));
  }

  @Test
  public void removesTheLastBytes() {
    byte[] bytes = EscapeCraft.removeLastBytes(new byte[]{0x01, 0x02, 0x03}, 1);
    assertThat(bytes, is(new byte[]{0x01, 0x02}));
  }

  @Test
  public void removesEvery3Bytes() {
    byte[] bytes = EscapeCraft.removeEvery3Bytes(new byte[]{0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07});
    assertThat(bytes, is(new byte[]{0x01, 0x02, 0x04, 0x05, 0x07}));
  }
}
