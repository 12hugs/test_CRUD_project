package com.crud.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "tbl_deep")
public class Deep {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deep_seq")
    @SequenceGenerator(name = "deep_seq", sequenceName = "DEEP_SEQ")
    private Long deep_idx; // 번호

    @Column(nullable = false)
    private String product_img; // 분석할 이미지

    @Column(nullable = false)
    private Long prediction_accuracy; // 정확도

    @Column(nullable = false)
    private String prediction_jdm; // 판정결과

    private LocalDateTime created_at; // 판정시간

    @ManyToOne
    @JoinColumn(name = "mb_id")
    private Member member; // 회원 엔터티 참조

    
    // Builder패턴 생성자
    @Builder
    public Deep(Long deep_idx, String product_img, Long prediction_accuracy, String prediction_jdm,
            LocalDateTime created_at, Member member) {
        this.deep_idx = deep_idx;
        this.product_img = product_img;
        this.prediction_accuracy = prediction_accuracy;
        this.prediction_jdm = prediction_jdm;
        this.created_at = created_at;
        this.member = member;
    }
}
