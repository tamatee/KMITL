public class example {
    public static void main(String[] args) {
        basicNasted obj = new basicNasted() {
            public void method1() {
                System.out.println("method1");
            }
        };
        obj.method1();
        obj.method2();
    }

}

abstract class basicNasted {
    public abstract void method1();

    public void method2() {
        System.out.println("method2");
    }
}
