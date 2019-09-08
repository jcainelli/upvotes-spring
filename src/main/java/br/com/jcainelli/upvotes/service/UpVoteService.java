package br.com.jcainelli.upvotes.service;

import java.util.List;

import br.com.jcainelli.upvotes.model.entity.UpVote;

public interface UpVoteService {

    Boolean computeVote(Long postId);

    UpVote findById(Long id);

    List<UpVote> findAll();

    UpVote save(UpVote upvote);

}
