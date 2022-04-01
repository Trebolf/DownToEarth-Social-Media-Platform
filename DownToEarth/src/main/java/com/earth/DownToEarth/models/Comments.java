package com.earth.DownToEarth.models;


import lombok.*;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name="_comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @Column(nullable = false)
    private String commentBody;

    @Column(insertable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date timeCommented;

    @Column(nullable = false)
    private Integer c_postId_fk;

    @Column(nullable = false)
    private Integer c_userId_fk;
}
