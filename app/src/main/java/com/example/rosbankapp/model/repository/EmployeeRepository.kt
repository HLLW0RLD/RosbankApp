package com.example.rosbankapp.model.repository

import com.example.rosbankapp.model.Employee

class EmployeeRepository {

    var employerList : MutableList<Employee> = mutableListOf(
        Employee(1,"Иванов Андрей Петрович"),
        Employee(2,"Николаев Петр Олегович"),
        Employee(3,"Сидоров Иван Сергеевич"),
        Employee(4,"Петров Игорь Николаевич"),
        Employee(5,"Сорокин Григорий Дмитриевич")
    )

    fun getEmployees(): MutableList<Employee> {
        return employerList
    }

    fun getEmployee(id : Int) : Employee{
        return employerList.get(id)
    }

}