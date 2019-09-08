package br.com.jcainelli.upvotes.service;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.jcainelli.upvotes.UpvotesApplication;
import br.com.jcainelli.upvotes.model.entity.UpVote;
import br.com.jcainelli.upvotes.repository.UpVoteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = UpvotesApplication.class)
@AutoConfigureMockMvc
@AutoConfigureCache
public class UpVoteServiceIntegratedTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UpVoteRepository repo;

    @Before
    public void init() {
        List<UpVote> list = new ArrayList<>();
        UpVote upVote = new UpVote();
        upVote.setId(10l);
        list.add(upVote);

        BDDMockito.given(repo.findAll()).willReturn(list);
    }

    @Test
    public void whenFindPost_ThenResultPost() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/upvote/"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(Matchers.greaterThanOrEqualTo(1))))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value("10"));

    }

}
