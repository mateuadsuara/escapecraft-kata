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
}
