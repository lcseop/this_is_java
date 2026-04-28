package com.mjc813.swimpool.models.teacher;

import com.mjc813.swimpool.models.swimpool.SwimPoolDto;
import com.mjc813.swimpool.models.swimpool.SwimPoolInterface;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TeacherDto implements TeacherInterface {
    private Integer id;
    private String name;
    private String main;
    private Integer birthYear;
    private Integer swimPoolId;
    private SwimPoolDto swimPool;

    @Override
    public Integer getSwimPoolId() {
        if (this.swimPool == null) {
            this.swimPool = new SwimPoolDto();
        }
        this.swimPool.setId(this.swimPoolId);
        return this.swimPool.getId();
    }

    @Override
    public void setSwimPoolId(Integer swimPoolId) {
        if (this.swimPool == null) {
            this.swimPool = new SwimPoolDto();
        }
        this.swimPool.setId(swimPoolId);
        this.swimPoolId = swimPoolId;
    }

    @Override
    public void setSwimPool(SwimPoolInterface swimPool) {
        if (swimPool == null)  {
            return;
        }
        if (this.swimPool == null) {
            this.swimPool = new SwimPoolDto();
        }
        this.swimPool.copyMembers(swimPool, true);
        this.swimPoolId = swimPool.getId();
    }
}
