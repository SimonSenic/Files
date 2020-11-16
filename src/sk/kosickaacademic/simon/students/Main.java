package sk.kosickaacademic.simon.students;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Student[] array=null;
        Contact[] array2=null;
        array=readStudentsFromFile(array);
        array2=readContacts(array2, array);
        printStudents(array, array2);
        //printWomen(array);
    }

    private static Student[] readStudentsFromFile(Student[] array) {
        BufferedReader read;
        try{
            FileReader fr = new FileReader("resources/students.dat");
            read = new BufferedReader(fr);
            String line = read.readLine();
            int num = Integer.parseInt(line);
            array = new Student[num];
            for(int i=0; i<num; i++){
                line=read.readLine();
                String[] temp = line.split(" ");
                double height=Double.parseDouble(temp[3]);
                int weight=Integer.parseInt(temp[4]);
                Student s = new Student(temp[0], temp[1], temp[2], height, weight);
                array[i]=s;
            }
            fr.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return array;
    }

    public static Contact[] readContacts(Contact[] array, Student[] arr){
        BufferedReader read;
        BufferedReader readX;
        Contact ca = new Contact();
        try{
            FileReader fr = new FileReader("resources/contacts.dat");
            FileReader frX = new FileReader("resources/students.dat");
            read = new BufferedReader(fr);
            readX = new BufferedReader(frX);
            String line = read.readLine();
            String lineX = readX.readLine();
            int num = Integer.parseInt(line);
            int numX = Integer.parseInt(lineX);
            array = new Contact[num];
            for(int i=0; i<num; i++){
                line = read.readLine();
                String[] temp = line.split(" ");
                for(int k=0; k<numX; k++){
                    if(temp[0]==arr[k].getFirstName() && temp[1]==arr[k].getLastName()){
                        for(int j=2; j<5; j++){
                            if(temp[j].substring(0, 4)=="phone") ca.setPhone(temp[j]);
                            if(temp[j].substring(0, 4)=="email") ca.setEmail(temp[j]);
                            if(temp[j].substring(0, 4)=="skype") ca.setSkype(temp[j]);
                            else ca.setPhone(temp[j]);
                        }
                    }
                }
            }
            fr.close();
            frX.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return array;
    }

    public static void printStudents(Student[] arr, Contact[] arre){
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i].getFirstName() +" " +arr[i].getLastName() +" " +arr[i].getAge() +" " +arr[i].getHeight() +" " +arr[i].getWeight() +" " +arre[i].getPhone() +" " +arre[i].getEmail() +" " +arre[i].getSkype());
        }
    }

    public static void printWomen(Student[] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[i].getId().charAt(2)>'1')
                System.out.println(arr[i].getFirstName() +" " +arr[i].getLastName());
        }
    }

}
