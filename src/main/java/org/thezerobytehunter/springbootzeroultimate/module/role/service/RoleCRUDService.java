package org.thezerobytehunter.springbootzeroultimate.module.role.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thezerobytehunter.springbootzeroultimate.base.repository.AbstractRepository;
import org.thezerobytehunter.springbootzeroultimate.base.service.AbstractCRUDService;
import org.thezerobytehunter.springbootzeroultimate.module.role.entity.Role;
import org.thezerobytehunter.springbootzeroultimate.module.role.payload.requests.RoleRequest;
import org.thezerobytehunter.springbootzeroultimate.module.role.payload.responses.RoleResponse;

import java.util.Map;
import java.util.Set;

@Service
public class RoleCRUDService extends AbstractCRUDService< Role, RoleRequest, RoleResponse > {
    @Value( "${SpringBootZeroUltimate.Config.IsSoftDelete}" )
    private Boolean isSoftDeleteEnabled = false;

    public RoleCRUDService( AbstractRepository< Role > repository ) {
        super( repository );
    }

    @Override
    public void validateRequestData( RoleRequest request, Role entity, Map< String, Set< String > > errorMessages ) {
    }

    @Override
    public Role convertToEntity( RoleRequest request ) {
        return updateEntity( request, new Role( ) );
    }

    @Override
    public Role updateEntity( RoleRequest request, Role entity ) {
        entity.setName( request.getName( ) );

        return entity;
    }

    @Override
    public RoleResponse convertToResponse( Role entity ) {
        RoleResponse.RoleResponseBuilder roleResponseBuilder = RoleResponse
                .builder( )
                .id( entity.getId( ) )
                .name( entity.getName( ) )
                .createdAt( entity.getCreatedAt( ) )
                .createdBy( entity.getCreatedBy( ) )
                .updatedAt( entity.getUpdatedAt( ) )
                .updatedBy( entity.getUpdatedBy( ) );

        if ( isSoftDeleteEnabled ) {
            roleResponseBuilder.isDeleted( entity.getIsDeleted( ) );
        }

        return roleResponseBuilder.build( );
    }
}