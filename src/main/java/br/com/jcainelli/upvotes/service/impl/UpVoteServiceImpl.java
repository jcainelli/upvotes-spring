package br.com.jcainelli.upvotes.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jcainelli.upvotes.model.entity.UpVote;
import br.com.jcainelli.upvotes.repository.UpVoteRepository;
import br.com.jcainelli.upvotes.service.UpVoteService;

@Service
public class UpVoteServiceImpl implements UpVoteService {

    @Autowired
    private UpVoteRepository repository;

    public UpVoteServiceImpl(final UpVoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Boolean computeVote(final Long upVoteId) {
        UpVote upVote = findById(upVoteId);
        if (upVote != null) {
            calculateVote(upVote);
            repository.save(upVote);
            return true;
        }
        return false;
    }

    @Override
    public UpVote findById(final Long id) {
        Optional<UpVote> optionalPost = repository.findById(id);
        return (optionalPost.isPresent() ? optionalPost.get() : null);
    }

    @Override
    public List<UpVote> findAll() {
        return repository.findAll();
    }

    @Override
    public UpVote save(final UpVote upvote) {
        return repository.save(upvote);
    }

    public void calculateVote(final UpVote post) {
        post.setUpVotes(post.getUpVotes() + 1);

    }
}