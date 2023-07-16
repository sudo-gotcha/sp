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
    // BufferedReader reader = new BufferedReader(new FileReader(jsonFile));
    // MyClass myClass = gson.fromJson(fileReader, MyClass.class);
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

## Json 만들기
```java
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        // JSON 형식에 맞게 데이터 구성
        String name = "John";
        int age = 30;
        String email = "john@example.com";

        // JSON 생성
        Person person = new Person(name, age, email);
        Gson gson = new Gson();
        String json = gson.toJson(person);

        // 생성된 JSON 출력
        System.out.println(json);
    }

    // 예시로 사용할 클래스 정의
    static class Person {
        private String name;
        private int age;
        private String email;

        public Person(String name, int age, String email) {
            this.name = name;
            this.age = age;
            this.email = email;
        }

        // Getter 및 Setter 메서드
        // ...
    }
}
```

### 중첩된 클래스의 경우 
```java
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        // JSON 형식에 맞게 데이터 구성
        String name = "John";
        int age = 30;
        Address address = new Address("123 Main St", "City", "12345");

        // Person 객체 생성
        Person person = new Person(name, age, address);

        // Gson을 사용하여 JSON 생성
        Gson gson = new Gson();
        String json = gson.toJson(person);

        // 생성된 JSON 출력
        System.out.println(json);
    }

    // Person 클래스 내부에 중첩된 Address 클래스 정의
    static class Person {
        private String name;
        private int age;
        private Address address;

        public Person(String name, int age, Address address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        // Getter 및 Setter 메서드
        // ...
    }

    // 중첩된 Address 클래스 정의
    static class Address {
        private String street;
        private String city;
        private String zipCode;

        public Address(String street, String city, String zipCode) {
            this.street = street;
            this.city = city;
            this.zipCode = zipCode;
        }

        // Getter 및 Setter 메서드
        // ...
    }
}
```
