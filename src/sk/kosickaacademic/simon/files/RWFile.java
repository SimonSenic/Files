package sk.kosickaacademic.simon.files;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RWFile {
    public void copyFileWithCapital(String fileName){
        BufferedReader reader;
        BufferedWriter writer;
        try{
            reader = new BufferedReader(new FileReader(fileName));
            File file = new File(createFile());
            writer = new BufferedWriter(new FileWriter(file));
            String line = reader.readLine();
            while(line!=null){
                line=checkChar(line);
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

    public String checkChar(String a){
        String result="";
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)=='i' || a.charAt(i)=='y' || a.charAt(i)=='I' || a.charAt(i)=='Y')
                result+='_';
            else
                result+=a.charAt(i);
        }
        return result;
    }

}
