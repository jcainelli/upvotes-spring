package br.com.jcainelli.upvotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jcainelli.upvotes.model.entity.UpVote;

@Repository
public interface UpVoteRepository extends JpaRepository<UpVote, Long> {

}
