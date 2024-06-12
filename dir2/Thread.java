class MyRunnable implements Runnable {
    private int threadNumber;

    public MyRunnable(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    public void run() {
        System.out.println("Thread " + threadNumber + " is running");
        // 스레드가 실행할 코드
    }
}

public class Main {
    public static void main(String[] args) {
        int numberOfThreads = 5;
        for (int i = 1; i <= numberOfThreads; i++) {
            Thread thread = new Thread(new MyRunnable(i));
            thread.start();  // 각 스레드 시작
        }
    }
}
