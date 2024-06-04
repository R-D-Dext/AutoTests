import org.junit.jupiter.api.*;

public class JunitTests {

    @BeforeEach
    public void be() {
        System.out.println("BeforeEach");
    }

    @BeforeAll
    public static void ba() {
        System.out.println("BeforeAll");
    }

    @AfterEach
    public void ae() {
        System.out.println("AfterEach");
    }

    @AfterAll
    public static void aa() {
        System.out.println("AfterAll");

    }

    @Test
    public void ft() {
        System.out.println("ft");
        Assertions.assertEquals(1, 2, "Не равны");
    }

    @Test
    public void st() {
        System.out.println("st");
        Assertions.assertEquals(1, 1, "Не равны");
    }
}
