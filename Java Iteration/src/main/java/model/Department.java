package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Department {
    private String departmentName;

    public  Department() {

    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void writeDepartmentOutput( LinkedList<NonTechnicalElective> nonTechnicalList, LinkedList<TechnicalElective>[] technicalList,int isFall)  {
        String fileName = "department.json";
        try {
            FileWriter file = new FileWriter(fileName);
            for(int i = 0 ;  nonTechnicalList.size() < i ; i++ ) {
                //We can write any JSONArray or JSONObject instance to the file
                if(nonTechnicalList.get(i).getCouldNotRegisteredQuotaProblem().size()==0) continue;
                file.write(nonTechnicalList.get(i).getCouldNotRegisteredQuotaProblem().size() + " number of students could not registered for " + nonTechnicalList.get(i).getName() + "\n");
            }
            for(int i = 0 ;  technicalList[isFall].size() < i ; i++ ) {
                //We can write any JSONArray or JSONObject instance to the file
                if(technicalList[isFall].get(i).getCouldNotRegisteredQuotaProblem().size()==0) continue;
                file.write(technicalList[isFall].get(i).getCouldNotRegisteredQuotaProblem().size() + " number of students could not registered for " + nonTechnicalList.get(i).getName() + "\n");
            }
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
