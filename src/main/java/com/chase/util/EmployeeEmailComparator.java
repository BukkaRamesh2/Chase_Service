package com.chase.util;
import java.util.Comparator;
import com.chase.entity.Employee;

public class EmployeeEmailComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getEmail().compareToIgnoreCase(e2.getEmail());
    }
}
