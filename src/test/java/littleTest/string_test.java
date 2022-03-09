package littleTest;

import org.junit.Test;

/**
 * @author lixu
 * @create 2022-03-03-19:29
 */
public class string_test {
    @Test
    public void replaceATest(){
        String s = "we are fff";
        String s1 = s.replaceAll(" ", "asdd");
        System.out.println(s1);
    }
}
