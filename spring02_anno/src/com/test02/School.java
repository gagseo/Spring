package com.test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class School {
   private int grade;
   
   @Autowired
   @Qualifier("hong")
   private Student person;
   
   public School() {
      
   }

   public School(int grade, Student person) {
      super();
      this.grade = grade;
      this.person = person;
   }

   public int getGrade() {
      return grade;
   }

   public void setGrade(int grade) {
      this.grade = grade;
   }

   public Student getPerson() {
      return person;
   }

   public void setPerson(Student person) {
      this.person = person;
   }

   @Override
   public String toString() {
      return "School [grade=" + grade + ", person=" + person + "]";
   }
   
   
}