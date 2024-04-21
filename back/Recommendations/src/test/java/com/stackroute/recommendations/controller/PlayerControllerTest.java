package com.stackroute.recommendations.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.stackroute.recommendations.config.PlayerTask;
import com.stackroute.recommendations.service.PlayerService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PlayerController.class})
@ExtendWith(SpringExtension.class)
class PlayerControllerTest {
    @Autowired
    private PlayerController playerController;

    @MockBean
    private PlayerService playerService;

    @MockBean
    private PlayerTask playerTask;

    /**
     * Method under test: {@link PlayerController#recommend(Integer)}
     */
    @Test
    void testRecommend() throws Exception {
        when(playerService.recommend((Integer) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/player/recommend/{size}", 3);
        MockMvcBuilders.standaloneSetup(playerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PlayerController#recommend(Integer)}
     */
    @Test
    void testRecommend2() throws Exception {
        when(playerService.recommend((Integer) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/player/recommend/{size}", 3);
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(playerController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PlayerController#sync()}
     */
    @Test
    void testSync() throws Exception {
        doNothing().when(playerTask).execute();
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/player/sync");
        MockMvcBuilders.standaloneSetup(playerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link PlayerController#sync()}
     */
    @Test
    void testSync2() throws Exception {
        doNothing().when(playerTask).execute();
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/v1/player/sync");
        postResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(playerController)
                .build()
                .perform(postResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

