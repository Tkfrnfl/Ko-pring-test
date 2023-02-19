package com.example.demo.Domain.DTO

import com.example.demo.Domain.DemoModel

data class GetDemoDTO(
        var id:Long?,
        val name:String,
){
    fun toEntity(): DemoModel {
        return  DemoModel(
                id=id,
                name = name
        )
    }
}
