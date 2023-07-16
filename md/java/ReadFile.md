# File 읽기
아래 예시 코드는 첫 번째 파일을 열어서 그 안에 있는 두 번째 파일의 이름을 얻고, 두 번째 파일을 여는 코드입니다. 콘솔로 첫 번째 파일의 이름을 입력받고, 입력한 파일을 열어서 그 안에 있는 두 번째 파일의 이름을 읽습니다. 그리고 두 번째 파일을 열어서 작업을 수행합니다.
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // 첫 번째 파일 이름 입력
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("첫 번째 파일 이름을 입력하세요: ");
            String firstFileName = consoleReader.readLine();

            // 첫 번째 파일 열기
            BufferedReader firstFileReader = new BufferedReader(new FileReader(firstFileName));
            String secondFileName = firstFileReader.readLine(); // 두 번째 파일 이름 읽기

            // 두 번째 파일 열기
            BufferedReader secondFileReader = new BufferedReader(new FileReader(secondFileName));

            // 두 번째 파일에서 작업 수행
            // TODO: 필요한 작업을 수행하는 코드를 작성하세요.

            // 파일 닫기
            secondFileReader.close();
            firstFileReader.close();
            consoleReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## 여러 줄 읽기
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("파일명.txt"));
            String line;
            
            while ((line = reader.readLine()) != null) {
                // 읽은 줄에 대한 작업 수행
                System.out.println(line);
            }
            
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
