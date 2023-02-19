package com.example.demo.Service

import com.example.demo.Domain.DTO.CreateDemoDTO
import com.example.demo.Domain.DTO.GetDemoDTO
import com.example.demo.Domain.DemoModel
import com.example.demo.Repository.DemoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DemoService {
    @Autowired
    lateinit var demoRepository: DemoRepository

    @Transactional
    fun createMember(member:CreateDemoDTO):String{
        val name:String=member.name


        demoRepository.findByName(name).let {
            if(it !=null){
                throw IllegalArgumentException("Member is already exist")

            }
            else{
                demoRepository.save(member.toEntity())
            }
        }
        print("????")
        return "saved"
    }

    fun getMember():List<DemoModel>{
       // return demoRepository.findById(id).get()
        var list=demoRepository.findAll()
        print(list[0].id)
        return list
    }
}