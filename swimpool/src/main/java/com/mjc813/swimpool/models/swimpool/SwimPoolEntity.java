package com.mjc813.swimpool.models.swimpool;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="swimpool")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SwimPoolEntity implements SwimPoolInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length=50, nullable=false)
    private String name;

    @Column(length=15, nullable=false)
    private String tel;

    @Column(length=100, nullable=false)
    private String addr1;

    @Column(length=100, nullable=false)
    private String addr2;

    @Column(length=100, nullable=false)
    private String lanes;

    @Column(nullable=false)
    private Integer size;
}
