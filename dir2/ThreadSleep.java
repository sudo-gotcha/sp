public class Main {
    public static void main(String[] args) {
        // 새로운 스레드 생성
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread is running.");
                try {
                    // 2초 동안 스레드를 멈춤
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread has awakened.");
            }
        });

        // 스레드 시작
        myThread.start();

        // 메인 스레드에서 다른 작업 수행
        System.out.println("Main thread is running.");
    }
}
