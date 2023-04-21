import java.util.ArrayList;
import java.util.List;

public class ThreadTest {

    private static final List<String> store = new ArrayList<>();

    public static void main(String[] args) {
        Hello helloA = Hello.getInstance();
        Hello helloB = Hello.getInstance();
        Thread threadA = new Thread(() -> helloA.service("DataA"));
        Thread threadB = new Thread(() -> helloB.service("DataB"));

        threadA.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        threadB.start();
    }
}

class Hello {

    private static final Hello instance = new Hello();

    private final List<String> store = new ArrayList<>();

    private Hello() {
    }

    public static Hello getInstance() {
        return instance;
    }

    public void service(String data) {
        store.add(data);
        System.out.println("store에 데이터 " + data + " 저장");
        sleep();
        String readData = store.get(store.size() - 1);
        System.out.println("readData = " + readData);
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
