package com.nadee.trappist.cucumber.stepdefs;

import com.nadee.trappist.TrappistApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = TrappistApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
