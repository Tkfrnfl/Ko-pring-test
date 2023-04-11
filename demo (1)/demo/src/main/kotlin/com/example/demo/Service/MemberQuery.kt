package com.example.demo.Service


import com.example.demo.Domain.DTO.CreateDemoDTO
import com.example.demo.Repository.DemoRepository
//import graphql.kickstart.tools.GraphQLQueryResolver;
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
public class MemberQuery:Query{

    @Autowired
    lateinit var demoRepository: DemoRepository

    @Transactional
    fun findName(name:String):Long?{

        var memberId:Long?=0
        demoRepository.findByName(name).let {
            if(it!=null){
                memberId=it.id
            }
        }

        return memberId
    }
}