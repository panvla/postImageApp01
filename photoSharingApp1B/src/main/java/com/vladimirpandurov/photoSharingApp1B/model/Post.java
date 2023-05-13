package com.vladimirpandurov.photoSharingApp1B.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Integer id;
    private String name;
    @Column(columnDefinition = "text")
    private String caption;
    private String location;
    private int likes;
    private Date postedDate;
    private Integer userImageId;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name= "post_id")
    private List<Comment> commentList;
}
