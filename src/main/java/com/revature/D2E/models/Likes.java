package com.revature.D2E.models;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name="likes")
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer likesId;

    /*@ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="l_postId_fk",
            referencedColumnName = "postId",
            nullable = false)
    private Post post;*/

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="l_postId_fk",
            referencedColumnName = "postId",
            nullable = false)
    private Post post;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="l_userId_fk",
            referencedColumnName = "userId",
            nullable = false)
    private User user;
}