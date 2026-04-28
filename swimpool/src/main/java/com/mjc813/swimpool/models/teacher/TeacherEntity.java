package com.mjc813.swimpool.models.teacher;

import com.mjc813.swimpool.models.swimpool.SwimPoolEntity;
import com.mjc813.swimpool.models.swimpool.SwimPoolInterface;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="teacher")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherEntity implements TeacherInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length=50, nullable=false)
    private String name;

    @Column(length=20, nullable=false)
    private String main;

    @Column(name="birth_year", nullable=false)
    private Integer birthYear;

    @Transient
    private Integer swimPoolId;

    @JoinColumn(name="swim_pool_id", nullable=false)
    @ManyToOne(fetch=FetchType.LAZY)
    private SwimPoolEntity swimPool;

    @Override
    public Integer getSwimPoolId() {
        if (this.swimPool == null) {
            this.swimPool = new SwimPoolEntity();
        }
        if (this.swimPool.getId() != null) {
            this.swimPoolId = this.swimPool.getId();
        }
        return this.swimPool.getId();
    }

    @Override
    public void setSwimPoolId(Integer swimPoolId) {
        if (this.swimPool == null) {
            this.swimPool = new SwimPoolEntity();
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
            this.swimPool = new SwimPoolEntity();
        }
        this.swimPool.copyMembers(swimPool, true);
        this.swimPoolId = swimPool.getId();
    }
}
