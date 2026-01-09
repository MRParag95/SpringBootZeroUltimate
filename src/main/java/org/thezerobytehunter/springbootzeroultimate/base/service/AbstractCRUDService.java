package org.thezerobytehunter.springbootzeroultimate.base.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thezerobytehunter.springbootzeroultimate.base.entity.BaseEntity;
import org.thezerobytehunter.springbootzeroultimate.base.payload.requests.IRequest;
import org.thezerobytehunter.springbootzeroultimate.base.payload.responses.IResponse;
import org.thezerobytehunter.springbootzeroultimate.base.repository.AbstractRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public abstract class AbstractCRUDService<
        Entity extends BaseEntity,
        Request extends IRequest,
        Response extends IResponse
        > implements IAbstractCRUDService< Entity, Request, Response > {
    protected final AbstractRepository< Entity > repository;

    @Transactional
    @Override
    public Entity create( Request request ) {
        Map< String, Set< String > > errorMessages = new HashMap<>( );
        validateRequestData( request, null, errorMessages );

        if ( !errorMessages.isEmpty( ) ) {
            StringBuilder errorMessage = new StringBuilder( );
            errorMessages.forEach( ( key, value ) -> errorMessage.append( key ).append( ": " ).append( value ).append( "\n" ) );

            throw new RuntimeException( errorMessage.toString( ) );
        }

        Entity entity = convertToEntity( request );
        return repository.save( entity );
    }

    @Transactional
    @Override
    public Set< Entity > batchCreate( Set< Request > requests ) {
        Map< String, Set< String > > errorMessages = new HashMap<>( );
        requests.forEach( request -> validateRequestData( request, null, errorMessages ) );

        if ( !errorMessages.isEmpty( ) ) {
            StringBuilder errorMessage = new StringBuilder( );
            errorMessages.forEach( ( key, value ) -> errorMessage.append( key ).append( ": " ).append( value ).append( "\n" ) );

            throw new RuntimeException( errorMessage.toString( ) );
        }

        Set< Entity > entities = requests.stream( ).map( this::convertToEntity ).collect( Collectors.toSet( ) );

        return new HashSet<>( repository.saveAll( entities ) );
    }

    public abstract void validateRequestData( Request request, Entity entity, Map< String, Set< String > > errorMessages );

    public abstract Entity convertToEntity( Request request );

    public abstract Entity updateEntity( Request request, Entity entity );

    public abstract Response convertToResponse( Entity entity );
}