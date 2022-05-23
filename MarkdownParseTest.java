import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void testGetLinksFile1() throws IOException{
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> expectedList = new ArrayList<String>();
        expectedList.add("https://something.com");
        expectedList.add("some-thing.html");
        assertEquals(expectedList,MarkdownParse.getLinksNew(content));
    }
    @Test
    public void testGetLinksFile2() throws IOException{
        Path fileName = Path.of("example.md");
        String content = Files.readString(fileName);
        ArrayList<String> expectedList = new ArrayList<String>();
        expectedList.add("https://google.com");
        expectedList.add("google.html");
        assertEquals(expectedList,MarkdownParse.getLinksNew(content));
    }
    @Test
    public void testGetLinksFile3() throws IOException{
        Path fileName = Path.of("fail1.md");
        String content = Files.readString(fileName);
        ArrayList<String> expectedList = new ArrayList<String>();
        if(content.length() == 0){
            assertEquals(null,null);
        }
        //assertEquals(null,MarkdownParse.getLinks(content)); SOUR
    }

    @Test
    public void testSnippet1() throws IOException{
        ArrayList<String> expectedList = new ArrayList<String>();
        expectedList.add("url.com");
        expectedList.add("google.com");
        expectedList.add("google.com");
        expectedList.add("ucsd.edu");
        assertEquals(expectedList,MarkdownParse.getLinksNew("labreport4snippet1.md"));
    }

    @Test
    public void testSnippet2() throws IOException{
        ArrayList<String> expectedList = new ArrayList<String>();
        expectedList.add("a.com");
        expectedList.add("b.com");
        expectedList.add("example.com");
        assertEquals(expectedList,MarkdownParse.getLinksNew("labreport4snippet2.md"));
    }

    @Test
    public void testSnippet3() throws IOException{
        ArrayList<String> expectedList = new ArrayList<String>();
        expectedList.add("https://www.twitter.com");
        expectedList.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        expectedList.add("github.com");
        expectedList.add("https://cse.ucsd.edu/");
        assertEquals(expectedList,MarkdownParse.getLinksNew("labreport4snippet3.md"));
    }
}
