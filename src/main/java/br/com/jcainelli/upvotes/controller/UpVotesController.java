package br.com.jcainelli.upvotes.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.jcainelli.upvotes.model.entity.UpVote;
import br.com.jcainelli.upvotes.service.UpVoteService;
import br.com.jcainelli.upvotes.uteis.UpVotesConstants;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = UpVotesConstants.REST_UP_VOTE)
public class UpVotesController {

    @Autowired
    private UpVoteService service;

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON)
    private List<UpVote> findAll(){
        return service.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON)
    private UpVote findAll(@PathVariable("id") Long upVoteId){
        return service.findById(upVoteId);
    }

    @PutMapping(path = "/like/{id}", produces = MediaType.APPLICATION_JSON)
    private Boolean computeVote(@PathVariable("id") final Long upVoteId){
        return service.computeVote(upVoteId);
    }

    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON)
    private UpVote save(@Valid @RequestBody final UpVote upVote){
        return service.save(upVote);
    }

}
