package model;

public abstract class Person {
    private String name;
    private String id;
    Department department;

    public Person(String departmentName,String name, String id) {
        department = new Department();
        department.setDepartmentName(departmentName);
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }


}
