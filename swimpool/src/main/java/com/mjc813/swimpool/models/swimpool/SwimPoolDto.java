package com.mjc813.swimpool.models.swimpool;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SwimPoolDto implements SwimPoolInterface {
    private Integer id;
    private String name;
    private String tel;
    private String addr1;
    private String addr2;
    private String lanes;
    private Integer size;
}
