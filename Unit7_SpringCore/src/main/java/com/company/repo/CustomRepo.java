package com.company.repo;

import com.company.domain.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface CustomRepo<T, ID> extends JpaRepository<T, ID> {

    List<Hero> findWithOffsetAndLimit(int offset, int limit);
}
