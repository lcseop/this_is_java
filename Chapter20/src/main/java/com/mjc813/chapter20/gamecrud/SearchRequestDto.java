package com.mjc813.chapter20.gamecrud;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SearchRequestDto {
    private String searchName;
    private String searchGrade;
    private String searchGenre;
    private Integer curPage;
    private Integer rowsPerPage;

    public void calculate() {
        this.curPage = (this.curPage - 1) * this.rowsPerPage;
    }
}
