class NintendoGame {
  // #gameList = [
  // ];
  // #selectedId = -1;

  printList(resultList) {
    $(".listDataBlock").empty();
    resultList.forEach((item) => {
      $(".listDataBlock").append(this.printRow(item));
    })
  }

  searchList(page) {
    let that = this;
    let searchData = {
      "searchName" : $("#searchName").val()
      ,"searchGrade" : $("#searchGrade").val()
      ,"searchGenre" : $("#searchGenre").val()
      ,"curPage" : page
      ,"rowsPerPage" : $("#rowsPerPage").val()
    };

    $.ajax({
      url: `/api/search-list?searchName=${searchData.searchName}&searchGrade=${searchData.searchGrade}&searchGenre=${searchData.searchGenre}&curPage=${searchData.curPage}&rowsPerPage=${searchData.rowsPerPage}` // 요청 URL
      ,type: "GET"           // 전송 방식
    })
        .done(function(data, textStatus, jqXHR) {
          that.printButtons(data.resultData.count);
          that.printList(data.resultData.list);
        })
        .fail(function(jqXHR, textStatus, errorThrown) {
          alert("실패", textStatus);
        });
  }

  printButtons(count) {

  }

  printGenre(genre) {
    switch (genre) {
      case "A":
        return "액션";
      case "S":
        return "스포츠";
      case "R":
        return "RPG";
      case "C":
        return "레이싱";
      case "V":
        return "어드벤쳐";
    }
    return "-";
  }

  printGrade(grade) {
    switch (grade) {
      case "ALL":
        return "전체이용가";
      case "7":
        return "7세 이상";
      case "12":
        return "12세 이상";
      case "15":
        return "15세 이상";
      case "18":
        return "18세 이상";
    }
    return "-";
  }

  printRow(item) {
    let html = `
<div class="listDataRow">
  <div class="listItem">
  <input type="hidden" class="idClass" value="${item.id}"/>
    <div class="itemData text-wrapper">${this.printGenre(
      item.genre
    )}</div>
  </div>
  <div class="listItem">
    <div class="itemData text-wrapper">${this.printGrade(
      item.grade
    )}</div>
  </div>
  <div class="listItem">
    <div class="itemData text-wrapper">${item.name}</div>
  </div>
</div>`;
    return html;
  }

  clearInputData() {
    $("#name").val("");
    $("#genre").val("A");
    $("#grade").val("ALL");
    $("#price").val(0);
    $("#imgUrl").val("");
    this.imgChange();
    // this.#selectedId = -1;
  }

  setData2InputBox(index) {
    $("#id").val(index.id);
    $("#name").val(index.name);
    $("#genre")
      .val(index.genre)
      .prop("selected", true);
    $("#grade")
      .val(index.grade)
      .prop("selected", true);
    $("#price").val(index.price);
    $("#imgUrl").val(index.imgUrl);
  }

  checkGame(mode) {
    if (mode !== "del" && $("#name").val().length <= 1) {
      alert("제목을 입력해주세요.");
      return false;
    }

    if (mode !== "del" && $("#name").val().length > 30) {
      alert("제목은 최대 30자까지 입력할 수 있습니다.");
      return false;
    }

    if (mode !== "del" && $("#price").val().length <= 1) {
      alert("가격을 입력해주세요.");
      return false;
    }

    if (mode !== "del" && (parseInt($("#price").val()) > 999999 || parseInt($("#price").val()) <= 0)) {
      alert("가격은 1원부터 999,999원까지 입력할 수 있습니다.");
      return false;
    }

    if (mode !== "del" && $("#imgUrl").val().indexOf("http")) {
      alert("이미지 주소는 http를 포함시켜야합니다.");
      return false;
    }

    if (mode !== "del" && $("#imgPreview").attr("src") === "./img/nonimage.png") {
      alert("이미지가 올바르지 않은 형식입니다.");
      return false;
    }

    // if (mode !== "add" && this.#selectedId === -1) {
    //   (mode === "edit") ? alert("먼저 수정할 게임을 목록에서 선택해주세요.") : alert("먼저 삭제할 게임을 목록에서 선택해주세요.");
    //   return false;
    // }

    return true;
  }

  addGame() {
    const setGame = {
      id: 0,
      name: $("#name").val(),
      genre: $("#genre").val(),
      grade: $("#grade").val(),
      price: parseInt($("#price").val()),
      imgUrl: $("#imgUrl").val(),
    };

    if (this.checkGame("add")) {
      // this.#gameList.push(setGame);
      this.insertData(setGame);
      this.searchList(1);
      // this.clearInputData();
    }
  }

  insertData(insertData) {
    // 1. 화면에서는 JSON 데이터를 서버 URL과 Method POST로 전송하는 JQUERY AJAX를 구현해야 한다.
    // 2. 웹 서버에서는 서버 URL과 Method POST와 JSON 데이터를 받아들이는 컨트롤러를 구현해야 한다.
    // 3. 웹서버 컨트롤러는 DataBase Service에 insert 하는 동작을 실행해야 한다.
    // 4. Data Service는 insert 하는 mybatis 메소드를 실행해야 한다.
    // 5. mybatis insert 메소드는 SQL INSERT 쿼리를 데이터베이스 연결한 Connection Pool에서 실행해야 한다.
    // 6. 실행할 결과를 역순으로 화면까지 리턴해야 한다.
    $.ajax({
      url: "/api/insert-data" // 요청 URL
      ,type: "POST"           // 전송 방식
      ,dataType: "json"       // 응답 데이터 타입
      ,data: JSON.stringify(insertData)
      ,contentType: "application/json"
    })
        .done(function(data, textStatus, jqXHR) {
          alert("성공", data);
          that.searchList(1);
        })
        .fail(function(jqXHR, textStatus, errorThrown) {
          alert("실패", textStatus);
        });
  }

  editGame() { 
    if (this.checkGame("edit")) {
      const targetGame = {
        id: $("#id").val()
        ,name: $("#name").val()
        ,genre: $("#genre").val()
        ,grade: $("#grade").val()
        ,price: parseInt($("#price").val())
        ,imgUrl: $("#imgUrl").val()
      }
      // this.printList();
      this.updateGame(targetGame);
      this.clearInputData();
    }
  }

  updateGame(updateData) {
    let that = this;
    if (updateData == null) {
      return;
    }

    $.ajax({
      url: "/api/update-data" // 요청 URL
      ,type: "PATCH"           // 전송 방식
      ,dataType: "json"       // 응답 데이터 타입
      ,data: JSON.stringify(updateData)
      ,contentType: "application/json"
    })
        .done(function(data, textStatus, jqXHR) {
          alert("성공", data);
          that.clearInputData();
          that.searchList(1);
        })
        .fail(function(jqXHR, textStatus, errorThrown) {
          alert("실패", textStatus);
        });

  }

  delGame() {
    if (this.checkGame("del")) {
      // const targetGame = this.#gameList.find(item => this.#selectedId === item.id);
      // this.#gameList.splice(this.#gameList.indexOf(targetGame) ,1);
      // this.printList();
      this.deleteGame($("#id").val());
      // this.clearInputData();
    }
  }

  deleteGame(id) {
    let that = this;
    $.ajax({
      url: "/api/delete-data"
      ,type: "DELETE"
      ,dataType: "json"
      ,data: JSON.stringify({id : id})
      ,contentType: "application/json"
    })
        .done(function(data, textStatus, jqXHR) {
          alert("성공", data);
          that.clearInputData();
          that.searchList(1);
        })
        .fail(function(jqXHR, textStatus, errorThrown) {
          alert("실패", textStatus);
        });
  }

  imgChange() {
    $("#imgPreview").attr("src", $("#imgUrl").val());
  }

  findId() {
    this.findById($("#id").val());
  }

  findById(id) {
    let that = this;
    $.ajax({
      url: "/api/getdata?id=" + id
      , type: "GET"
    }).done(function(data, textStatus, jqXHR) {
      that.setData2InputBox(data.resultData);
      that.imgChange();
    }).fail(function(data, textStatus, errorThrown) {
      alert("실패");
    })
  }

  printOneGame(e) {
    // 화면의 id 값으로 gameList배열에서 찾는다. let id값 = $("#id").val();, let 찾은원소 = this.#gameList.find(() => {});
    let selectId = $(e.currentTarget).find(".idClass").val() * 1;
    console.log(`selectId = ${selectId}`);
//    let findGame = this.#gameList.find((item) => {
//      return item.id === selectId;
//    });
    this.findById(selectId);
//    if ( findGame == undefined ) {
//      return;
//    }
//    // this.setData2InputBox(찾은원소);
//    this.setData2InputBox(findGame)
  }
}

$(() => {
  // jquery 실행
  let nint = new NintendoGame();
  // nint.getList();
  nint.searchList(1);

  $("#btnAdd").click(function (e) {
    nint.addGame();
  });

  $("#btnEdit").click((e) => {
    nint.editGame();
  });

  $("#btnDel").click((e) => {
    nint.delGame();
  });

  $(document).on("change", "#imgUrl", function (e) {
    nint.imgChange();
  });

  $(document).on("click", ".listDataRow", function (e) {
    nint.printOneGame(e);
  });

  $(document).on("click", "#btnSearch", function (e) {
    nint.searchList(1);
  })

  $(document).on("click", "#btnFindId", function (e) {
    nint.findId();
  })

  $(document).on("click", ".btnPage", function (e) {
    nint.searchList($(e.target).text());
  })
});
