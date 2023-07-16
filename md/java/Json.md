# JSON
## 예시
```json
{
  "name": "John",
  "age": 30,
  "contacts": {
    "email": "john@example.com",
    "phone": "123-456-7890"
  }
}
```

## Java에서 JSON 데이터를 파싱하는 방법
```java
import com.google.gson.Gson;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String jsonString = "{\"name\":\"John\",\"age\":30,\"contacts\":{\"email\":\"john@example.com\",\"phone\":\"123-456-7890\"}}";
        Gson gson = new Gson();
        Map<String, Object> data = gson.fromJson(jsonString, Map.class);

        String name = (String) data.get("name");
        int age = (int) data.get("age");
        Map<String, Object> contacts = (Map<String, Object>) data.get("contacts");
        String email = (String) contacts.get("email");
        String phone = (String) contacts.get("phone");

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
    }
}
```

## Java Class 정의 (바로 Class로 매핑)
```java
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

public class MyClass {
    private String name;
    private int age;
    private Map<String, String> contacts;

    // Getter 및 Setter 메서드

    // ...

    public static void main(String[] args) {
        String jsonString = "{\"name\":\"John\",\"age\":30,\"contacts\":{\"email\":\"john@example.com\",\"phone\":\"123-456-7890\"}}";
        Gson gson = new Gson();
        Type type = new TypeToken<MyClass>(){}.getType();
        MyClass myClass = gson.fromJson(jsonString, type);

        System.out.println("Name: " + myClass.getName());
        System.out.println("Age: " + myClass.getAge());
        System.out.println("Contacts: " + myClass.getContacts());
    }
}
```

### JSON 파일을 읽어 객체로 변환
```java
try {
    File jsonFile = new File("path/to/json/file.json");
    FileReader fileReader = new FileReader(jsonFile);
    MyClass myClass = gson.fromJson(fileReader, MyClass.class);
    fileReader.close();
    // 변환된 객체 사용
    System.out.println("Name: " + myClass.getName());
    System.out.println("Age: " + myClass.getAge());
    System.out.println("Contacts: " + myClass.getContacts());
} catch (IOException e) {
    e.printStackTrace();
}
```

## Class 안 Class 파싱
```java
public class MyClass {
    private String name;
    private int age;
    private InnerClass[] innerClasses;

    // Getter 및 Setter 메서드

    public static class InnerClass {
        private String innerName;

        // Getter 및 Setter 메서드
    }
}
```

## JSON 데이터를 읽고 객체로 변환
```java
try {
    File jsonFile = new File("path/to/json/file.json");
    MyClass myClass = gson.fromJson(new FileReader(jsonFile), MyClass.class);

    System.out.println("Name: " + myClass.getName());
    System.out.println("Age: " + myClass.getAge());

    InnerClass[] innerClasses = myClass.getInnerClasses();
    for (InnerClass innerClass : innerClasses) {
        System.out.println("Inner Name: " + innerClass.getInnerName());
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

## Inner class 예시
```json
{
  "name": "John",
  "age": 30,
  "innerClasses": [
    {
      "innerName": "Inner1"
    },
    {
      "innerName": "Inner2"
    }
  ]
}
```

## java class 정의
```java
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class MyClass {
    private String name;
    private int age;
    private List<InnerClass> innerClasses;

    // Getter 및 Setter 메서드

    public static class InnerClass {
        private String innerName;

        // Getter 및 Setter 메서드
    }

    public static void main(String[] args) {
        String jsonString = "{\"name\":\"John\",\"age\":30,\"innerClasses\":[{\"innerName\":\"Inner1\"},{\"innerName\":\"Inner2\"}]}";
        Gson gson = new Gson();
        Type type = new TypeToken<MyClass>(){}.getType();
        MyClass myClass = gson.fromJson(jsonString, type);

        System.out.println("Name: " + myClass.getName());
        System.out.println("Age: " + myClass.getAge());
        List<InnerClass> innerClasses = myClass.getInnerClasses();
        for (InnerClass innerClass : innerClasses) {
            System.out.println("Inner Name: " + innerClass.getInnerName());
        }
    }
}
```
