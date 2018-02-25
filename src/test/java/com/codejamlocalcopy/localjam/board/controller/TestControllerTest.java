package com.codejamlocalcopy.localjam.board.controller;

import com.codejamlocalcopy.localjam.config.AppConfiguration;
import com.codejamlocalcopy.localjam.storage.service.IContestAccessingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Tests {@link TestController}
 */
@RunWith(MockitoJUnitRunner.class)
//@ContextConfiguration(classes = {AppConfiguration.class})
//@WebAppConfiguration
public class TestControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IContestAccessingService contestAccessingService;

    private TestController testController;

    //Add WebApplicationContext field here

    @Before
    public void setUp(){
        testController = new TestController(contestAccessingService);
        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
    }

    @Test
    public void indexShouldUseViewIndex() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
//        verifyZeroInteractions(contestAccessingService);
        verify(contestAccessingService, times(1)).readContestRoot();
    }
}
