package com.example.demo.Domain.DTO

import com.example.demo.Domain.DemoModel

data class CreateDemoDTO(
        val name:String,
){
/*    fun toEntity():DemoModel= DemoModel(
            name = name
    )*/
    constructor():this("")
    fun toEntity():DemoModel= DemoModel(
            name = name)
}


