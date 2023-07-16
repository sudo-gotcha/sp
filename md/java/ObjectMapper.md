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

## MyClass 객체를 Json 문자열로 변환
```java
ObjectMapper objectMapper = new ObjectMapper();
MyClass myClass = new MyClass("John", 30, new String[]{"contact1", "contact2"}, new Subject[]{
        new Subject("Math", 3),
        new Subject("Science", 4)
});
try {
    String json = objectMapper.writeValueAsString(myClass);
    System.out.println(json);
} catch (JsonProcessingException e) {
    e.printStackTrace();
}
```

## Json 문자열을 MyClass 객체로 변환
```java
String json = "{\"name\":\"John\", \"age\":30, \"contacts\":[\"contact1\", \"contact2\"], \"subjects\":[{\"name\":\"Math\", \"credit\":3}, {\"name\":\"Science\", \"credit\":4}]}";
try {
    MyClass myClass = objectMapper.readValue(json, MyClass.class);
    System.out.println("Name: " + myClass.getName());
    System.out.println("Age: " + myClass.getAge());
    System.out.println("Contacts: " + Arrays.toString(myClass.getContacts()));
    System.out.println("Subjects: ");
    for (Subject subject : myClass.getSubjects()) {
        System.out.println("- Name: " + subject.getName() + ", Credit: " + subject.getCredit());
    }
} catch (JsonProcessingException e) {
    e.printStackTrace();
}
```

## Json 데이터가 파일로부터 읽혀오는 경우
```
ObjectMapper objectMapper = new ObjectMapper();

try {
    File jsonFile = new File("path/to/json/file.json");
    
    // 파일을 읽어와 Json 문자열로 변환
    String jsonString = FileUtils.readFileToString(jsonFile, StandardCharsets.UTF_8);
    
    // Json 문자열을 해당 클래스의 객체로 변환
    MyClass myClass = objectMapper.readValue(jsonString, MyClass.class);
    
    // 변환된 객체 사용
    System.out.println("Name: " + myClass.getName());
    System.out.println("Age: " + myClass.getAge());
    System.out.println("Contacts: " + Arrays.toString(myClass.getContacts()));
    System.out.println("Subjects: ");
    for (Subject subject : myClass.getSubjects()) {
        System.out.println("- Name: " + subject.getName() + ", Credit: " + subject.getCredit());
    }
} catch (IOException e) {
    e.printStackTrace();
}
```
