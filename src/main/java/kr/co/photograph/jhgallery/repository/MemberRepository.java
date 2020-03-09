package kr.co.photograph.jhgallery.repository;


import kr.co.photograph.jhgallery.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByID(String userID);
}
