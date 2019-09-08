package br.com.jcainelli.upvotes.uteis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jcainelli.upvotes.model.entity.UpVote;
import br.com.jcainelli.upvotes.repository.UpVoteRepository;

@Component
public class InitializeDataBaseDesenv {

    @Autowired
    private UpVoteRepository upVoteRepository;

    public void instantiateDatabase() {
        UpVote upv1 = new UpVote();
        upv1.setTitle("What is Lorem Ipsum?");
        upv1.setDescription("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.");
        upv1.setUpVotes(0L);
        upVoteRepository.save(upv1);

        UpVote upv2 = new UpVote();
        upv2.setTitle("Where does it come from?");
        upv2.setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum");
        upv2.setUpVotes(0L);
        upVoteRepository.save(upv2);
    }

}
