//package test

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class RunManager {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String fileName = scanner.nextLine();
    
    //파일 경로 설정
    String filePath = "./";
    //파일 객체 생성
    File file = new File(filePath, fileName);
    
    //파일 존재 여부 확인
    if (file.exists()) {
      try {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        String service = "";
        while ((line = reader.readLine()) != null) {
          service = line; 
        }
        reader.close();
        
        File serviceFile = new File("./", service);
        if (serviceFile.exists()) {
          BufferedReader serviceReader = new BufferedReader(new FileReader(serviceFile));
          while ((line = serviceReader.readLine()) != null) {
            System.out.print(line); 
          }
          serviceReader.close();
        }
      } catch (IOException e) {
        System.out.println("파일을 읽는 도중 오류가 발생했습니다"); 
      }
    } else {
       System.out.println("파일이 존재하지 않습니다."); 
    }
    
    scanner.close();
  }
  
}
