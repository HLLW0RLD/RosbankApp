package com.example.rosbankapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rosbankapp.model.Employer
import com.example.rosbankapp.model.repository.EmployerRepository

class EmployerViewModel(private val repository : EmployerRepository) : ViewModel() {

    private val employerLiveData = MutableLiveData<Employer>()

    fun getLiveData() = employerLiveData

    fun getEmployee(employer: Employer){
        val result = repository.getEmployee(employer.id)

        employerLiveData.value = result
    }
}