package br.com.jcainelli.upvotes.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.jcainelli.upvotes.model.entity.UpVote;
import br.com.jcainelli.upvotes.repository.UpVoteRepository;
import br.com.jcainelli.upvotes.service.impl.UpVoteServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UpVoteServiceUnitTest {

    @Mock
    private UpVoteServiceImpl service;

    @Mock
    private UpVoteRepository repository;

    @Before
    public void init(){
        service = new UpVoteServiceImpl(repository);
    }

    @Test
    public void whenUpVote_ThenIncreaseOneUnit(){
        Long expected = 11l;
        UpVote post = createMockPost();

        service.calculateVote(post);

        Assert.assertEquals(expected, post.getUpVotes());
    }

    @Test
    public void whenFindById_thenResultEntity(){
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(createMockPost()));

        UpVote upVote = service.findById(1L);

        Assert.assertEquals(1L, upVote.getId().longValue());
    }

    private UpVote createMockPost(){
        UpVote post = new UpVote();
        post.setId(1L);
        post.setUpVotes(10l);
        return post;
    }

}
