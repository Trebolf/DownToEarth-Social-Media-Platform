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

    @Column(nullable = false)
    private Integer l_postId_fk;

    @Column(nullable = false)
    private Integer l_userId_fk;
}
