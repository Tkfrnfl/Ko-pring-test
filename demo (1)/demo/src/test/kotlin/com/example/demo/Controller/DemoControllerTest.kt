package com.example.demo.Controller

import com.example.demo.Domain.DemoModel
import com.example.demo.Repository.DemoRepository
import com.ninjasquad.springmockk.MockkBean
import io.kotest.assertions.print.print
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.ResultHandler
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
open class MockTestBase(@Autowired val mockMvc: MockMvc){
    @MockkBean
    lateinit var demoRepository: DemoRepository
}

@WebMvcTest
@AutoConfigureMockMvc
class MockMvcTest
        @Autowired constructor(val mockMvc: MockMvc ,
                               val demoRepository: DemoRepository ) {

    @Test
    fun memberTest() {
        val member = DemoModel(1,"ddd");
        demoRepository.save(member)

        mockMvc.perform(
//            MockMvcRequestBuilders.get("/test/v1/hello")  // MockMvcRequestBuilders를 써야함 주의
                get("/demo/get?id=1")

        )
               .andExpect(
                status().isOk
        )
                .andExpect(MockMvcResultMatchers.content().string("hello"))

    }
}
/*@MockkBean(JpaMetamodelMappingContext::class)   //////kotest 사용한 방법
class DemoControllerTest (@Autowired val mockMvc: MockMvc):DescribeSpec({
    describe("start"){
        context("??"){
            it("mid"){
                mockMvc.perform((MockMvcRequestBuilders
                        .get("/demo/get?id=1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        ))  .andExpect(MockMvcResultMatchers.content().string("{}"))

            }
        }

    }

})*/

