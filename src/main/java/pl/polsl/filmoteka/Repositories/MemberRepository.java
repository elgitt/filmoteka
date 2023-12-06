package pl.polsl.filmoteka.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.filmoteka.Models.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}