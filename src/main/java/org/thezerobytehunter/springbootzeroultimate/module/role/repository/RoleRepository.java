package org.thezerobytehunter.springbootzeroultimate.module.role.repository;

import org.springframework.stereotype.Repository;
import org.thezerobytehunter.springbootzeroultimate.base.repository.AbstractRepository;
import org.thezerobytehunter.springbootzeroultimate.module.role.entity.Role;

@Repository
public interface RoleRepository extends AbstractRepository< Role > {
}