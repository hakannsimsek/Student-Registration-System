package model;

import java.util.LinkedList;

public class Teacher extends Person{


    public Teacher(String departmentName,String name, String id) {
        super(departmentName,name, id);
    }

    LinkedList<Student> adviseeList = new LinkedList<Student>();

    @Override
    public String toString(){
        return "[Id:" + this.getId() + " Name:" + this.getName() + " DepName:" + this.department.getDepartmentName() + "]";
    }
}
