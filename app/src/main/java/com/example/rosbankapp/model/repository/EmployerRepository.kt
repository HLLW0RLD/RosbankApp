package com.example.rosbankapp.model.repository

import com.example.rosbankapp.model.Employer

class EmployerRepository {

    var employerList : MutableList<Employer> = mutableListOf(
        Employer("Иванов Андрей Петрович"),
        Employer("Николаев Петр Олегович"),
        Employer("Сидоров Иван Сергеевич"),
        Employer("Петров Игорь Николаевич"),
        Employer("Сорокин Григорий Дмитриевич")
    )

    fun getEmployers(): MutableList<Employer> {
        return employerList
    }

}