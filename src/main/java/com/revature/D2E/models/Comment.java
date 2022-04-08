package com.revature.D2E.models;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @Column(nullable = false)
    private String commentBody;

    @Column(insertable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date timeCommented;

    @ManyToOne
    @JoinColumn(name="c_postId_fk",
            referencedColumnName = "postId",
            nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name="c_userId_fk",
            referencedColumnName = "userId",
            nullable = false)
    private User user;
}
