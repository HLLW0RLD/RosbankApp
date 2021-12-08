package com.example.rosbankapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rosbankapp.model.Employee
import com.example.rosbankapp.model.repository.EmployeeRepository

class EmployeeViewModel(private val repository: EmployeeRepository) : ViewModel() {

    private val employeeLiveData = MutableLiveData<Employee>()

    private val employeesLiveData = MutableLiveData<List<Employee>>()

    fun getLiveData() = employeeLiveData

    fun getEmployee(employee: Employee) {
        val result = repository.getEmployee(employee.id)

        employeeLiveData.value = result
    }

    fun getEmployees() {
        val result = repository.getEmployees()

        employeesLiveData.value = result
    }
}