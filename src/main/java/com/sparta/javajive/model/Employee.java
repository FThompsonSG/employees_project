package com.sparta.javajive.model;

public class Employee {
    //Emp ID, Name Prefix,First Name,Middle Initial,Last Name,Gender,E Mail,Date of Birth,Date of Joining,Salary
    private Integer empId;
    private String namePrefix;
    private String firstName;
    private Character midInit;
    private String lastName;
    private String gender;
    private String email;
    private String dateOfBirth;
    private String dateOfJoining;
    private Integer salary;

    public Employee(Integer empId, String namePrefix, String firstName, Character midInit, String lastName, String gender, String email, String dateOfBirth, String dateOfJoining, Integer salary) {
        this.empId = empId;
        this.namePrefix = namePrefix;
        this.firstName = firstName;
        this.midInit = midInit;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder employeeStringBuilder = new StringBuilder();
        employeeStringBuilder.append("EmpID: ").append(empId);
        employeeStringBuilder.append("\n");
        String employeeName = "Employee name: " + " " + namePrefix + " " + firstName + " " + midInit + " " + lastName;
        employeeStringBuilder.append(employeeName);
        employeeStringBuilder.append("\n");
        employeeStringBuilder.append("Gender: ").append(gender);
        employeeStringBuilder.append("\n");
        employeeStringBuilder.append("Email address: ").append(email);
        employeeStringBuilder.append("\n");
        employeeStringBuilder.append("Date of Birth: ").append(dateOfBirth);
        employeeStringBuilder.append("\n");
        employeeStringBuilder.append("Date of Joining: ").append(dateOfJoining);
        employeeStringBuilder.append("\n");
        employeeStringBuilder.append("Salary: ").append("$").append(salary);
        employeeStringBuilder.append("\n");
        return employeeStringBuilder.toString();

    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Character getMidInit() {
        return midInit;
    }

    public void setMidInit(Character midInit) {
        this.midInit = midInit;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
