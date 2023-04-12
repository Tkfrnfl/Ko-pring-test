package com.example.demo.Controller

import com.example.demo.Repository.DemoRepository
import com.example.demo.Service.MemberQuery
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class DemoGraphqlController {
    @Autowired
    lateinit var demoRepository: DemoRepository

    @QueryMapping
    fun findName(@Argument name:String):String=MemberQuery(demoRepository).findName(name)

}