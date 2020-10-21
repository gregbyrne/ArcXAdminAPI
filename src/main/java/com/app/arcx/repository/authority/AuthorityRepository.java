package com.app.arcx.repository.authority;

import java.util.Optional;

import com.app.arcx.domain.Authority;
import com.app.arcx.domain.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	Optional<Authority> findByName(ERole name);
}
