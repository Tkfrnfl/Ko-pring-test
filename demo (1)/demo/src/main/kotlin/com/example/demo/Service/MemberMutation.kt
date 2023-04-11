package com.example.demo.Service

import com.example.demo.Domain.DTO.CreateDemoDTO
import com.example.demo.Repository.DemoRepository
//import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class MemberMutation :GraphQLQueryResolver{
    @Autowired
    lateinit var demoRepository: DemoRepository

    @Transactional
    fun createMember(memberName: CreateDemoDTO):String{
        demoRepository.save(memberName.toEntity())

        return "saved"
    }

}