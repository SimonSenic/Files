package sk.kosickaacademic.simon.students;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader;
        try{
            FileReader fr = new FileReader("resources/students.dat");
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            int num = Integer.parseInt(line);
            Student[] array = new Student[num];
            for(int i=0; i<num; i++){
                line=reader.readLine();
                String[] temp = line.split(" ");
                double height=Double.parseDouble(temp[3]);
                int weight=Integer.parseInt(temp[4]);
                Student s = new Student(temp[0], temp[1], temp[2], height, weight);
                array[i]=s;
            }
            printStudents(array);
            //printWomen(array);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void printStudents(Student[] arr){
        for(int i=0; i<arr.length; i++)
            System.out.println(arr[i].getFirstName() +" " +arr[i].getLastName() +" " +arr[i].getAge() +" " +arr[i].getHeight() +" " +arr[i].getWeight());

    }

    public static void printWomen(Student[] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[i].getId().charAt(2)>'1')
                System.out.println(arr[i].getFirstName() +" " +arr[i].getLastName());
        }
    }

}
