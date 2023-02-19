package com.example.demo.Controller

import com.example.demo.Domain.DTO.CreateDemoDTO
import com.example.demo.Domain.DemoModel
import com.example.demo.Service.DemoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/demo")
class DemoController @Autowired constructor(private  val demoService: DemoService) {

    @PostMapping("/save")
    fun save(@RequestBody member:CreateDemoDTO): ResponseEntity<Any> {
        val save= demoService.createMember(member)
        return ResponseEntity.ok().body(save)
    }

/*    @GetMapping("/get")
    fun get(@RequestParam id:Long): ResponseEntity<Any> {
        val get=demoService.getMember(id)
        return ResponseEntity.ok().body(get)
    }*/
@GetMapping("/get")
fun get(): ResponseEntity<Any> {
    val get=demoService.getMember()

    return ResponseEntity.ok().body(get)
}
}