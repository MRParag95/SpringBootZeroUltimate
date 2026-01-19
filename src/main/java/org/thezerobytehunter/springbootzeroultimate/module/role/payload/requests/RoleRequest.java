package org.thezerobytehunter.springbootzeroultimate.module.role.payload.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.uuid.Generators;
import lombok.*;
import org.thezerobytehunter.springbootzeroultimate.base.payload.requests.IRequest;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleRequest implements IRequest {
    private Long id;

    @JsonIgnore
    @Builder.Default
    private String requestTraceUID = Generators.timeBasedEpochGenerator( ).generate( ).toString( );

    private String name;
}