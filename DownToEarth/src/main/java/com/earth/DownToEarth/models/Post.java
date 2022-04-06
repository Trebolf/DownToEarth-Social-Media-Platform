package com.earth.DownToEarth.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name="_posts")
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
    //postMedia could represent a link to youtube/picture
    @Column
    private String postMedia;
    @Column(insertable = false,
            columnDefinition = "INT DEFAULT 0")
    private Integer commentCount;

    @Column(insertable = false,
            columnDefinition = "INT DEFAULT 0")
    private Integer likesCount;
    //todo images

    @ManyToOne
    @JoinColumn(name="p_userId_fk",
            referencedColumnName = "userId",
            nullable = false)
    private User user;
}
