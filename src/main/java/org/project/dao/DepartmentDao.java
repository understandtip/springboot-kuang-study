package org.project.dao;

import org.project.domain.Department;
import org.project.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jackqiu
 * 部门Dao
 */
@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departments = null;

    static {//模拟数据库的取值
        departments = new HashMap<Integer, Department>();

        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"市场部"));
        departments.put(103,new Department(103,"教研部"));
        departments.put(104,new Department(104,"运营部"));
        departments.put(105,new Department(105,"后勤部"));
    }

    public Collection<Department> getDepartments() {//获取全部部门信息
        return departments.values();
    }

    public Department getDepartmentById(Integer id){//获取单个部门信息
        return departments.get(id);
    }
}
