package org.thezerobytehunter.springbootzeroultimate.module.role.payload.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.thezerobytehunter.springbootzeroultimate.base.payload.responses.IResponse;

import java.time.Instant;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude( JsonInclude.Include.NON_NULL )
public class RoleResponse implements IResponse {
    private Long id;

    private String name;

    private Instant createdAt;

    private String createdBy;

    private Instant updatedAt;

    private String updatedBy;

    private Boolean isDeleted;
}