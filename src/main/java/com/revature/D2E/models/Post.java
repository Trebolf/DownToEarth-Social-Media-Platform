package com.revature.D2E.models;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(insertable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date timePosted;

    @Column(nullable = false)
    private String postBody;

    @Column(nullable = true)
    private String postMedia;

    @Column(insertable = false,
            columnDefinition = "INT DEFAULT 0")
    private Integer commentCount;

    @Column(insertable = false,
            columnDefinition = "INT DEFAULT 0")
    private Integer likesCount;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="p_userId_fk",
            referencedColumnName = "userId",
            nullable = false)
    private User user;
}