package org.thezerobytehunter.springbootzeroultimate.module.role.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thezerobytehunter.springbootzeroultimate.base.controller.AbstractCRUDController;
import org.thezerobytehunter.springbootzeroultimate.base.service.AbstractCRUDService;
import org.thezerobytehunter.springbootzeroultimate.module.role.entity.Role;
import org.thezerobytehunter.springbootzeroultimate.module.role.payload.requests.RoleRequest;
import org.thezerobytehunter.springbootzeroultimate.module.role.payload.responses.RoleResponse;

@RestController
@RequestMapping( "/api/v1/role" )
@Tag( name = "Role", description = "CRUD Operations for Role" )
public class RoleCRUDController extends AbstractCRUDController< Role, RoleRequest, RoleResponse > {
    public RoleCRUDController( AbstractCRUDService< Role, RoleRequest, RoleResponse > service ) {
        super( service );
    }
}