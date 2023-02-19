package com.example.demo.Domain

import com.example.demo.Domain.DTO.CreateDemoDTO
import com.example.demo.Domain.DTO.GetDemoDTO
import jakarta.persistence.*;


@Entity
@Table(name = "newtable", schema = "public")
data class DemoModel (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long?=null,

    @Column(name="name", nullable = false)
    var name:String,


    ){
/*    fun getDemoDTO(): GetDemoDTO {
        return  GetDemoDTO(
                id=id,
                name=name
        )
    }
    fun createDemoDTO():CreateDemoDTO{
        return  CreateDemoDTO(
                name=name
        )
    }*/
}