package com.crud.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "tbl_community")
public class Community{

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "community_seq")
    @SequenceGenerator(name = "community_seq", sequenceName = "COMMUNITY_SEQ")
    private Long b_idx; // 글번호

    @Column(nullable = false)
    private String b_title; // 글 제목

    @Column(nullable = false)
    @Lob
    private String b_content; // 글 내용

    private String b_file; // 글 첨부파일

    private LocalDateTime created_at; // 글 작성일자

    @Column(columnDefinition = "number(18,0) default 0")
    private Long b_views; // 글 조회수

    @Column(columnDefinition = "number(18,0) default 0")
    private Long b_likes; // 글 좋아요 수

    @ManyToOne
    @JoinColumn(name = "mb_id")
    private Member member; // 회원 엔터티 참조

    @OneToMany(mappedBy = "community")
    private Set<Comment> comments = new HashSet<>(); // 댓글 목록

    
    // Builder패턴 생성자
    @Builder
    public Community(Long b_idx, String b_title, String b_content, String b_file, LocalDateTime created_at,
            Long b_views, Long b_likes, Member member) {
        this.b_idx = b_idx;
        this.b_title = b_title;
        this.b_content = b_content;
        this.b_file = b_file;
        this.created_at = created_at;
        this.b_views = b_views;
        this.b_likes = b_likes;
        this.member = member;
    }
}
