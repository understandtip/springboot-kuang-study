package org.project.dao;

import org.project.domain.Department;
import org.project.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jackqiu
 * 员工Dao
 */
@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;
    private static Integer InitId = 1006;

    @Autowired
    private DepartmentDao departmentDao;

    static {//模拟数据库的取值
        employees = new HashMap<Integer, Employee>();

        employees.put(1001,new Employee(1001,"AA","A2787123@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","B2787123@qq.com",1,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"CC","C2787123@qq.com",0,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"DD","D2787123@qq.com",1,new Department(104,"运营部")));
        employees.put(1005,new Employee(1005,"EE","E2787123@qq.com",0,new Department(105,"后勤部")));
    }

    //获取全部员工信息
    public Collection<Employee> getEmployees() {
        return employees.values();
    }

    //获取单个员工的信息
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    //增加员工信息
    public void InsertEmployee(Employee employee){
        if(employee.getId() == null){
            employee.setId(InitId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    //修改员工的信息
    public void DeleteEmployee(Integer id){
        employees.remove(id);
    }
}
