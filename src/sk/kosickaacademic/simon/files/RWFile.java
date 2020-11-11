package sk.kosickaacademic.simon.files;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RWFile {
    public void copyFile(String fileName){
        BufferedReader reader;
        BufferedWriter writer;
        try{
            reader = new BufferedReader(new FileReader(fileName));
            File file = new File(createFile());
            writer = new BufferedWriter(new FileWriter(file));
            String line = reader.readLine();
            while(line!=null){
                //line=checkChar(line);
                line=encryptChar(line);
                writer.write(line +'\n');
                line=reader.readLine();
            }
            reader.close();
            writer.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public String createFile(){
        String name="output/b_";
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HHmmss");
        String timeX = time.format(timeFormat);

        return name=name+timeX;
    }

    public String checkChar(String txt){
        String result="";
        for(int i=0; i<txt.length(); i++){
            if(txt.charAt(i)=='i' || txt.charAt(i)=='y' || txt.charAt(i)=='I' || txt.charAt(i)=='Y')
                result+='_';
            else
                result+=txt.charAt(i);
        }
        return result;
    }

    public String encryptChar(String txt){
        String result="";
        System.out.println("Enter crypt addend: ");
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0; i<txt.length(); i++){
            char a=txt.charAt(i);
            if(a>='A' && a<='Z') {
                a=(char)(a+n);
                if(a>'Z') a=(char)(a-26);
            }
            else if(a>='a' && a<='z') {
                a=(char)(a+n);
                if(a>'z') a=(char)(a-26);
            }
            else if(a>='0' && a<='9') {
                a=(char)(a+n);
                if(a>'9') a=(char)(a-8);
            }
            result+=a;
        }
        return result;
    }

}
