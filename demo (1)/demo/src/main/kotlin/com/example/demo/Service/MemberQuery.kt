package com.example.demo.Service


import com.example.demo.Domain.DTO.CreateDemoDTO
import com.example.demo.Repository.DemoRepository
//import graphql.kickstart.tools.GraphQLQueryResolver;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service

public class MemberQuery @Autowired constructor(val demoRepository: DemoRepository ){


     fun findName(name:String):String{

        println(name)
//        var memberId:Long?=0
//        demoRepository.findByName(name).let {
//            if(it!=null){
//                memberId=it.id
//            }
//        }
//        println(memberId)
//        return memberId.toString()


        return demoRepository.findAll()[0].id.toString()
    }
}