package com.example.rosbankapp.model.repository

import com.example.rosbankapp.model.Employee

class EmployeeRepository {

    var employerList : MutableList<Employee> = mutableListOf(
        Employee(0,"Иванов Андрей Петрович"),
        Employee(1,"Николаев Петр Олегович"),
        Employee(2,"Сидоров Иван Сергеевич"),
        Employee(3,"Петров Игорь Николаевич"),
        Employee(4,"Сорокин Григорий Дмитриевич")
    )

    fun getEmployees(): MutableList<Employee> {
        return employerList
    }

    fun getEmployee(id : Int) : Employee{
        return employerList.get(id)
    }

}