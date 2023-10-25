package Assignments;

//Voter class definition
public class Voter {
 private String name;
 private int age;

 // Parameterized constructor to initialize properties
 public Voter(String name, int age) {
     this.name = name;
     this.age = age;
 }

 // Getter and Setter methods
 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public int getAge() {
     return age;
 }

 public void setAge(int age) {
     this.age = age;
 }

 // Returns Voter details in a formatted String
 @Override
 public String toString() {
     return "Name: " + name + ", Age: " + age;
 }

 // Returns the age criteria of voter based on the criteria provided
 public String getAgeCriteria() {
     if (age >= 18) {
         return "ADULT";
     } else {
         return "UNDERAGE";
     }
 }
}

