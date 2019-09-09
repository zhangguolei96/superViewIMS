package com.crud.bean;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

public class Employee {
    private Integer empId;
    @Pattern(regexp="(^[A-Za-z0-9]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5}$)"
    		,message="名字必须是2-5个中文或者6-16位英文数字组合")
    private String empName;

    private String gender;
    @Email(message="邮箱格式不正确")
    private String email;

    private Integer dId;

    private String phone;

    private String tel;

    private Integer gId;
    //用于查询员工的时候根据员工的d_id查询显示出部门名称
    private Department department;

    //用于查询员工的时候根据员工的g_id查询显示出组别名称
    private Group group;



    public Employee() {
		super();
	}



    public Employee(Integer empId, String empName, String gender, String email, String phone, String tel, Integer dId, Integer gId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
		this.email = email;
		this.phone = phone;

		this.tel = tel;
		this.dId = dId;
		this.gId = gId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dId=" + dId +
                ", phone='" + phone + '\'' +
                ", tel='" + tel + '\'' +
                ", gId=" + gId +
                ", department=" + department +
                ", group=" + group +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

}