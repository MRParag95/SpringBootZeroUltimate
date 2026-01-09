package org.thezerobytehunter.springbootzeroultimate.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.thezerobytehunter.springbootzeroultimate.base.entity.BaseEntity;

@NoRepositoryBean
public interface AbstractRepository< Entity extends BaseEntity > extends
        JpaRepository< Entity, Long >,
        JpaSpecificationExecutor< Entity >,
        QueryByExampleExecutor< Entity > {
}