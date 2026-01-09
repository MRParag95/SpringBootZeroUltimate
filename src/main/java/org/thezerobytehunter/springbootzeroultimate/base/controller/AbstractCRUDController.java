package org.thezerobytehunter.springbootzeroultimate.base.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thezerobytehunter.springbootzeroultimate.base.entity.BaseEntity;
import org.thezerobytehunter.springbootzeroultimate.base.payload.requests.IRequest;
import org.thezerobytehunter.springbootzeroultimate.base.payload.responses.IResponse;
import org.thezerobytehunter.springbootzeroultimate.base.payload.responses.MessageResponse;
import org.thezerobytehunter.springbootzeroultimate.base.service.AbstractCRUDService;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public abstract class AbstractCRUDController<
        Entity extends BaseEntity,
        Request extends IRequest,
        Response extends IResponse
        > implements IAbstractCRUDController< Entity, Request, Response > {
    public final AbstractCRUDService< Entity, Request, Response > service;

    @PostMapping
    @Override
    public ResponseEntity< MessageResponse< String > > create( @Valid @RequestBody Request request ) {
        Entity savedEntity = service.create( request );

        return ResponseEntity.ok( MessageResponse.success( "%s Successfully created".formatted( savedEntity.getClass( ).getSimpleName( ) ) ) );
    }

    @PostMapping( "/batch" )
    @Override
    public ResponseEntity< MessageResponse< String > > batchCreate( @Valid @RequestBody Set< Request > requests ) {
        Set< Entity > savedEntities = service.batchCreate( requests );

        String entityName = savedEntities.isEmpty( ) ? "Records" : savedEntities.iterator( ).next( ).getClass( ).getSimpleName( );
        return ResponseEntity.ok( MessageResponse.success( "%s %s created successfully".formatted( savedEntities.size( ), entityName ) ) );
    }
}