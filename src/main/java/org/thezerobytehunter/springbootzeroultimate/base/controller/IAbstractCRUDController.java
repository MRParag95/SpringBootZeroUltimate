package org.thezerobytehunter.springbootzeroultimate.base.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.thezerobytehunter.springbootzeroultimate.base.entity.BaseEntity;
import org.thezerobytehunter.springbootzeroultimate.base.payload.requests.IRequest;
import org.thezerobytehunter.springbootzeroultimate.base.payload.responses.IResponse;
import org.thezerobytehunter.springbootzeroultimate.base.payload.responses.MessageResponse;

import java.util.Set;

public interface IAbstractCRUDController<
        Entity extends BaseEntity,
        Request extends IRequest,
        Response extends IResponse
        > {
    ResponseEntity< MessageResponse< String > > create( @Valid @RequestBody Request request );

    ResponseEntity< MessageResponse< String > > batchCreate( @Valid @RequestBody Set< Request > requests );
}