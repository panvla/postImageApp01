package com.vladimirpandurov.photoSharingApp1B.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(unique = true)
    private String username;
    private String password;
    private String email;
    @Column(columnDefinition = "text")
    private String bio;
    private Date createdDate;
    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserRole> userRoles = new HashSet<>();
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "appUser_id")
    private List<Post> post;
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "likedPostappUser_id")
    private List<Post> likedPost;


}
