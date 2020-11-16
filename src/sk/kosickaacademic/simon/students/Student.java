package sk.kosickaacademic.simon.students;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String firstName;
    private String lastName;
    private String id;
    private int age;
    private double height;
    private int weight;

    public Student(String firstName, String lastName, String id, double height, int weight){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.height = height;
        this.weight = weight;
        age=setAge();
    }

    private int setAge(){
        Date currentDate = new Date();
        DateFormat y = new SimpleDateFormat("yyyy");
        DateFormat m = new SimpleDateFormat("MM");
        DateFormat d = new SimpleDateFormat("dd");
        int currentYear=Integer.parseInt(y.format(currentDate));
        int currentMonth=Integer.parseInt(m.format(currentDate));
        int currentDay=Integer.parseInt(d.format(currentDate));
        int year=Integer.parseInt(id.substring(0, 2));
        int month=Integer.parseInt(id.substring(2, 4));
        int day=Integer.parseInt(id.substring(4, 6));
        if(year>70) year=1900+year; else year=2000+year;
        if(id.charAt(2)>1) month-=50;

        int age=currentYear-year;
        if(currentMonth<month || (currentMonth==month && currentDay<day)) age--;
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender(){
        return id.charAt(2)<'2' ? Gender.MALE:Gender.FEMALE;
    }

    public double getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

}
