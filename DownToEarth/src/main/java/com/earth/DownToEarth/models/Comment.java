package com.earth.DownToEarth.models;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
=======

import lombok.*;

import javax.persistence.*;
import java.util.Date;

>>>>>>> 99742ad7e2cbb88404d80854f7480aa8e0031860

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
<<<<<<< HEAD
@Entity
@Table(name = "comments")
=======

@Entity
@Table(name="_comments")
>>>>>>> 99742ad7e2cbb88404d80854f7480aa8e0031860
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private Integer CommentId;

    @Column(nullable = false)
    private String commentText;

    @ManyToOne
    @JsonIgnoreProperties({"comments"})
    private Post post;
=======
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
>>>>>>> 99742ad7e2cbb88404d80854f7480aa8e0031860
}
