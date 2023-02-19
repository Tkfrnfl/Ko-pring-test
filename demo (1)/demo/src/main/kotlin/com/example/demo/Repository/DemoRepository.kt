package com.example.demo.Repository

import com.example.demo.Domain.DemoModel
import org.springframework.data.jpa.repository.JpaRepository

interface DemoRepository:JpaRepository<DemoModel,Long> {
    fun findByName(name:String):DemoModel?

}