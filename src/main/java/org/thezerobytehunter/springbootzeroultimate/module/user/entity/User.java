package org.thezerobytehunter.springbootzeroultimate.module.user.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.thezerobytehunter.springbootzeroultimate.base.entity.BaseEntity;
import org.thezerobytehunter.springbootzeroultimate.module.role.entity.Role;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString( callSuper = true )
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table( name = "users" )
@SequenceGenerator( name = "user_seq", sequenceName = "user_seq", allocationSize = 100 )
public class User extends BaseEntity {
    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String phone;

    private String password;

    @ToString.Exclude
    @ManyToMany(
            cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH },
            fetch = FetchType.LAZY
    )
    @JoinTable( name = "users_roles",
            joinColumns = @JoinColumn( name = "user_id" ),
            inverseJoinColumns = @JoinColumn( name = "roles_id" ) )
    private Set< Role > roles = new HashSet<>( );

    public void addRole( Role role ) {
        roles.add( role );
        role.addUser( this );
    }

    public void removeRole( Role role ) {
        roles.remove( role );
        role.removeUser( this );
    }
}