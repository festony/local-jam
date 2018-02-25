package com.codejamlocalcopy.localjam.board.controller;

import com.codejamlocalcopy.localjam.storage.service.IContestAccessingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * A test controller serving requests.
 */
@Controller
public class TestController {

    private final static Logger LOG = LoggerFactory.getLogger(TestController.class);

    private final IContestAccessingService contestAccessingService;

    @Autowired
    public TestController(IContestAccessingService contestAccessingService) {
        this.contestAccessingService = contestAccessingService;
    }

    @RequestMapping("/")
    public String index() {
        try {
            contestAccessingService.readContestRoot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }
}

