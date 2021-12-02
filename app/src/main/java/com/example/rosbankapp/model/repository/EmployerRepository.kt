package com.example.rosbankapp.model.repository

import com.example.rosbankapp.model.Employer

class EmployerRepository {

    var employerList : MutableList<Employer> = mutableListOf(
        Employer(1,"Иванов Андрей Петрович"),
        Employer(2,"Николаев Петр Олегович"),
        Employer(3,"Сидоров Иван Сергеевич"),
        Employer(4,"Петров Игорь Николаевич"),
        Employer(5,"Сорокин Григорий Дмитриевич")
    )

    fun getEmployers(): MutableList<Employer> {
        return employerList
    }

    fun getEmployee(id : Int) : Employer{
        return employerList.get(id)
    }

}