package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="owners")
public class Owner {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="age")
    private int age;

    @Column(name="salary")
    private int salary;

    public Owner(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Owner() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
