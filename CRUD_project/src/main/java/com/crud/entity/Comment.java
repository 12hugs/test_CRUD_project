package com.crud.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "tbl_comment")
public class Comment {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
    @SequenceGenerator(name = "comment_seq", sequenceName = "COMMENT_SEQ")
    private Long cmt_idx; // 댓글 번호

    @ManyToOne
    @JoinColumn(name = "b_idx")
    private Community community; // 원글 번호 (Community 엔터티 참조)

    @Column(nullable = false)
    @Lob
    private String cmt_content; // 댓글 내용

    private LocalDateTime created_at; // 댓글 작성일자

    @ManyToOne
    @JoinColumn(name = "mb_id")
    private Member member; // 댓글 작성자 (Member 엔터티 참조)

    @Column(columnDefinition = "number(18,0) default 0")
    private Long cmt_likes; // 댓글 좋아요 수

    
    // Builder패턴 생성자
	@Builder
    public Comment(Long cmt_idx, Community community, String cmt_content, LocalDateTime created_at, Member member,
			Long cmt_likes) {
		this.cmt_idx = cmt_idx;
		this.community = community;
		this.cmt_content = cmt_content;
		this.created_at = created_at;
		this.member = member;
		this.cmt_likes = cmt_likes;
	}
    

}