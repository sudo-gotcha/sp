import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);
        
        // 사용자에게 안내 메시지 출력
        System.out.println("Enter your name: ");
        
        // 콘솔로부터 문자열 입력 받기
        String name = scanner.nextLine();
        
        // 입력받은 문자열 출력
        System.out.println("Hello, " + name + "!");
        
        // 다른 예제: 정수 입력 받기
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        
        // 입력받은 정수 출력
        System.out.println("You are " + age + " years old.");
        
        // Scanner 객체 닫기
        scanner.close();
    }
}
