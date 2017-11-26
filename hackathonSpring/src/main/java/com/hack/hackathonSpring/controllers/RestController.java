package com.hack.hackathonSpring.controllers;

import com.hack.hackathonSpring.dto.TestDataDto;
import com.hack.hackathonSpring.dto.TestDataSendDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path = "/services")
public interface RestController {

    @RequestMapping(value = "/getClusters", method = RequestMethod.GET )
    public @ResponseBody HashMap<Long,List<TestDataSendDto>> getClusters() throws IOException;

    @RequestMapping(value = "/addBenefit", method = RequestMethod.GET )
    public @ResponseBody String addBenefit(@RequestParam("username") String username);
}
