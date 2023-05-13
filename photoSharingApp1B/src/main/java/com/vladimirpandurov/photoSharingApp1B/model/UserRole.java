package com.vladimirpandurov.photoSharingApp1B.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long userRoleId;
    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private AppUser appUser;
    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;
}
