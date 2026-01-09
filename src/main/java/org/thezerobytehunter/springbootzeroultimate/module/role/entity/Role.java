package org.thezerobytehunter.springbootzeroultimate.module.role.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.thezerobytehunter.springbootzeroultimate.base.entity.BaseEntity;
import org.thezerobytehunter.springbootzeroultimate.module.user.entity.User;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString( callSuper = true )
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table( name = "role" )
@SequenceGenerator( name = "role_seq", sequenceName = "role_seq", allocationSize = 100 )
public class Role extends BaseEntity {
    private String name;

    @ManyToMany(
            mappedBy = "roles",
            cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH },
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    private Set< User > users = new HashSet<>( );

    public void addUser( User user ) {
        users.add( user );
        user.getRoles( ).add( this );
    }

    public void removeUser( User user ) {
        users.remove( user );
        user.getRoles( ).remove( this );
    }
}