
import java.util.ArrayList;
import java.util.Iterator;

class student{
    String name;
    String usn;
    String dept;
    String section;
    double cgpa;
    student(String name,
            String usn,
            String dept,
            String section,
            double cgpa){
        this.cgpa = cgpa;
        this.dept = dept;
        this.usn = usn;
        this.name = name;
        this.section = section;

    }
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", usn='" + usn + '\'' +
                ", dept='" + dept + '\'' +
                ", section='" + section + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }
}
public class student2 {
    public static void main(String args[]){
        ArrayList<student> arr = new ArrayList<>();
        arr.add(new student("aftaab","1ms21is012","ISE","C",9.8));
        arr.add(new student("fahi","1ms21is012","ISE","C",6.4));
        arr.add(new student("yas","1ms21is012","ISE","C",8.7));
        arr.add(new student("kas","1ms21is012","ISE","C",5.3));
        for(student val : arr){
            System.out.println(val.name + " " + val.dept + " " + val.usn + " " + val.cgpa + " " + val.section);
        }
        Iterator<student> itr = arr.iterator();
        while(itr.hasNext()){
            student std = itr.next();
            if(std.cgpa > 8.5){
                System.out.println(std.name + " " + std.dept + " " + std.usn + " " + std.cgpa + " " + std.section);
            }
        }


    }
}