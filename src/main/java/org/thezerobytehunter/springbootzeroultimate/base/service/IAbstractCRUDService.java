package org.thezerobytehunter.springbootzeroultimate.base.service;

import org.thezerobytehunter.springbootzeroultimate.base.entity.BaseEntity;
import org.thezerobytehunter.springbootzeroultimate.base.payload.requests.IRequest;
import org.thezerobytehunter.springbootzeroultimate.base.payload.responses.IResponse;

import java.util.Set;

public interface IAbstractCRUDService<
        Entity extends BaseEntity,
        Request extends IRequest,
        Response extends IResponse
        > {
    Entity create( Request request );

    Set< Entity > batchCreate( Set< Request > requests );

//    Entity readOne( Long id );
//
//    Set< Entity > readAll( );
//
//    Entity update( Request request );
//
//    Set< Entity > batchUpdate( Set< Request > requests );
//
//    void deleteOne( Long id );
//
//    void batchDelete( Set< Long > id );
}