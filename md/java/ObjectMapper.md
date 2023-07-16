# ObjectMapper 객체 생성
```java
ObjectMapper objectMapper = new ObjectMapper();
```

# Json 문자열을 객체로 파싱
```java
String json = "{\"name\":\"John\", \"age\":30}";
try {
    // Json 문자열을 해당 클래스의 객체로 파싱
    MyClass obj = objectMapper.readValue(json, MyClass.class);
    System.out.println("Name: " + obj.getName());
    System.out.println("Age: " + obj.getAge());
} catch (JsonProcessingException e) {
    e.printStackTrace();
}
```

# 객체를 Json 문자열로 반환
```java
MyClass obj = new MyClass("John", 30);
try {
    // 객체를 Json 문자열로 변환
    String json = objectMapper.writeValueAsString(obj);
    System.out.println(json);
} catch (JsonProcessingException e) {
    e.printStackTrace();
}
```

# MyClass
```java
public class MyClass {
    private String name;
    private int age;
    private String[] contacts;

    public MyClass() {
        // 기본 생성자
    }

    public MyClass(String name, int age, String[] contacts) {
        this.name = name;
        this.age = age;
        this.contacts = contacts;
    }

    // Getter 및 Setter 메서드
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getContacts() {
        return contacts;
    }

    public void setContacts(String[] contacts) {
        this.contacts = contacts;
    }
}
```

# Class 안 Class
```java
public class MyClass {
    private String name;
    private int age;
    private String[] contacts;
    private Subject[] subjects;

    public MyClass() {
        // 기본 생성자
    }

    public MyClass(String name, int age, String[] contacts, Subject[] subjects) {
        this.name = name;
        this.age = age;
        this.contacts = contacts;
        this.subjects = subjects;
    }

    // Getter 및 Setter 메서드

    // ...

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }
}
```

```java
public class Subject {
    private String name;
    private int credit;

    public Subject() {
        // 기본 생성자
    }

    public Subject(String name, int credit) {
        this.name = name;
        this.credit = credit;
    }

    // Getter 및 Setter 메서드

    // ...
}
```

