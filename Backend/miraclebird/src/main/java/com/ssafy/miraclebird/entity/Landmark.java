package com.ssafy.miraclebird.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Landmark")
public class Landmark {

    @Id
    @Column(name = "landmark_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long landmarkIdx;

    @Column(nullable = true, name = "token_id")
    private String tokenId;

    @Column(nullable = true)
    private String title;

    @Column(nullable = true)
    private String content;

    @Column(nullable = true, name = "star_force")
    private int starForce;

    @Column(nullable = true)
    private Boolean selling;

    /* 연관관계 매핑 */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User user;

    @OneToMany(mappedBy = "landmark")
    List<Price> price = new ArrayList<>();

}