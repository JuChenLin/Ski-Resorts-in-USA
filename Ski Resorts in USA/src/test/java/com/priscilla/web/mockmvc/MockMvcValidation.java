package com.priscilla.web.mockmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Component
public abstract class MockMvcValidation {
    @Autowired
    MockMvc mockMvc;

    public void validateCreateStatus(RequestBuilder requestBuilder) throws Exception {
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Content-Type", "application/json"))
                .andReturn();;

        String content = mvcResult.getResponse().getContentAsString();
//        System.out.println("Content: " + content);

        System.out.println("MockMvc isCreated Status Checked");
    }

    public void validateOkStatus(RequestBuilder requestBuilder) throws Exception {
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk()).andReturn();

        String content = mvcResult.getResponse().getContentAsString();
//        System.out.println("Content: " + content);

        System.out.println("MockMvc isOk Status Checked");
    }

    public void validateNoContent(RequestBuilder requestBuilder) throws  Exception {
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isNoContent()).andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("Content: " + content);

        System.out.println("MockMvc isNoContent Status Checked");
    }

    public abstract void validateBodySkiResort(RequestBuilder requestBuilder, Object object) throws Exception;

    public abstract void validateBodySkiResort(RequestBuilder requestBuilder, Object object, Object jsonObject) throws Exception;

    public abstract void validateBodyMountainStat(RequestBuilder requestBuilder, Object object) throws Exception;

    public abstract void validateBodyMountainStat(RequestBuilder requestBuilder, Object object, Object jsonObject) throws Exception;

    public abstract void validateBodyAddresses(RequestBuilder requestBuilder, Object object) throws Exception;

    public abstract void validateBodyAddresses(RequestBuilder requestBuilder, Object object, Object jsonObject) throws Exception;
}
