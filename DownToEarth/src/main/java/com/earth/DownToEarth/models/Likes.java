package com.earth.DownToEarth.models;


import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name="_likes")
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer likesId;

    @ManyToOne
    @JoinColumn(name="l_postId_fk",
            referencedColumnName = "postId",
            nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name="l_userId_fk",
            referencedColumnName = "userId",
            nullable = false)
    private User user;
}
