package org.thezerobytehunter.springbootzeroultimate.module.user.repository;

import org.springframework.stereotype.Repository;
import org.thezerobytehunter.springbootzeroultimate.base.repository.AbstractRepository;
import org.thezerobytehunter.springbootzeroultimate.module.user.entity.User;

@Repository
public interface UserRepository extends AbstractRepository< User > {
}