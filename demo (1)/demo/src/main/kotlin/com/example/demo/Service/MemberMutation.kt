package com.example.demo.Service

import com.example.demo.Domain.DTO.CreateDemoDTO
import com.example.demo.Repository.DemoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional
class MemberMutation{
    @Autowired
    lateinit var demoRepository: DemoRepository

    @MutationMapping
    @Transactional
    fun createMember(memberName: CreateDemoDTO):String{
        demoRepository.save(memberName.toEntity())

        return "saved"
    }

}