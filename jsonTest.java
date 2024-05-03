import org.example.FileJson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.example.FileJson.isValidBrackets;

public class jsonTest {

//    @Test
//    public void testFail() throws Exception {
//
//        String FileName2 = "filenotfound.json";
//        System.out.println(isValidBrackets(FileName2));
//
//        String FileName3 = "";
//        System.out.println(isValidBrackets(FileName3));
//
//        String FileName4 = "file2.json";
//        System.out.println(isValidBrackets(FileName4));
//    }
//
//    @Test
//    public void test() throws Exception {
//        String FileName1 = "file.json";
//        System.out.println(isValidBrackets(FileName1));
//
//    }

    @Test
    public void ExceptionTest(){
        Assertions.assertThrows(Exception.class, () -> FileJson.isValidBrackets("file2.json"));
    }

    @Test
    public void nullPointerExceptionTest(){
        Assertions.assertThrows(NullPointerException.class, () -> FileJson.isValidBrackets(""));
    }

    @Test
    public void FileNotFoundExceptionTest(){
        Assertions.assertThrows(FileNotFoundException.class, () -> FileJson.isValidBrackets("filenotfound.json"));
    }

    @Test
    public void Test() throws Exception {
        Assertions.assertEquals(0, FileJson.isValidBrackets("/Users/kseniataryskina/IdeaProjects/ClassWorkInf/file.json"));
    }

}