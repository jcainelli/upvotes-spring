package br.com.jcainelli.upvotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcainelli.upvotes.service.impl.UpVoteServiceImpl;
import br.com.jcainelli.upvotes.uteis.UpVotesConstants;

@RestController
@RequestMapping(value = UpVotesConstants.REST_ROOT)
public class RootController {

    @Autowired
    private UpVoteServiceImpl service;

    @GetMapping(path = "/")
    public String hello(){
        return "OI ";
    }

}