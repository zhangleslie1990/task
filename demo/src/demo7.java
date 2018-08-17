public class demo7 {
    public static void main(String[] args) {
        for (int i = -1; i < 10; i++) {
            try {
                int a = 1 / i;
                System.out.println("di  a=" + a + "   **********" + i + "    ci");
            } catch (Exception e) {
                System.out.println("err" + i);
            }
        }
    }
}
