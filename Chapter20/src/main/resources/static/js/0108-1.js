class NintendoGame {
  #gameList = [
    {
      id: 1,
      name: "마리오카트",
      genre: "C",
      grade: "ALL",
      price: 20000,
      imgUrl:
        "https://pimg.mk.co.kr/news/cms/202504/06/news-p.v1.20250404.ad221f845db2489a86c2ff50f32c53fa_P1.png",
    },
    {
      id: 2,
      name: "젤다의전설",
      genre: "R",
      grade: "15",
      price: 20000,
      imgUrl:
        "https://i.namu.wiki/i/S66iBPwJwpp_sPdmF1vdHUTmAVawerAHCmH0vps93PCZg986ttafD3tUfT-vUHxlwUa1sy29MDuD5W8Vp6c6EQ.webp",
    },
    {
      id: 3,
      name: "마리오 원더",
      genre: "V",
      grade: "7",
      price: 69000,
      imgUrl:
        "https://i.namu.wiki/i/WkZpZ6b7ueO_hpJW8qkuA0iY4ONOxjBhzr1BM0wKvEa9TaLKKgmWPiibbwPT-lpHh7QgRCnlFwUvZenTnVO2Fw.webp"
    },
    {
      id: 4,
      name: "수박게임",
      genre: "A",
      grade: "12",
      price: 5000,
      imgUrl:
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQALfRWbpwQj36q0jFM5teH_fNSxiTH03LroQ&s"
    }
  ];
  #selectedId = -1;

  printList() {
    $(".listDataBlock").empty();
    this.#gameList.forEach((item) => {
      // 배열을 순환하면서 item 을 class="frame-2" 태그 안의 자식 태그로 추가한다.
      $(".listDataBlock").append(this.printRow(item));
    });
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
    this.#selectedId = -1;
  }

  setData2InputBox(index) {
    $("#name").val(this.#gameList[index].name);
    $("#genre")
      .val(this.#gameList[index].genre)
      .prop("selected", true);
    $("#grade")
      .val(this.#gameList[index].grade)
      .prop("selected", true);
    $("#price").val(this.#gameList[index].price);
    $("#imgUrl").val(this.#gameList[index].imgUrl);
    this.#selectedId = this.#gameList[index].id;
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

    if (mode !== "add" && this.#selectedId === -1) {
      (mode === "edit") ? alert("먼저 수정할 게임을 목록에서 선택해주세요.") : alert("먼저 삭제할 게임을 목록에서 선택해주세요.");
      return false;
    }

    return true;
  }

  addGame() {
    const setGame = {
      id: this.#gameList.reduce((acc, item) => (acc < item.id ? item.id : acc), 0) + 1,
      name: $("#name").val(),
      genre: $("#genre").val(),
      grade: $("#grade").val(),
      price: parseInt($("#price").val()),
      imgUrl: $("#imgUrl").val(),
    };

    if (this.checkGame("add")) {
      this.#gameList.push(setGame);
      this.insertData(setGame);
      this.printList();
      this.clearInputData();
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
        })
        .fail(function(jqXHR, textStatus, errorThrown) {
          alert("실패", textStatus);
        });
  }

  editGame() { 
    if (this.checkGame("edit")) {
      const targetGame = this.#gameList.find(item => this.#selectedId === item.id);
      targetGame.name = $("#name").val();
      targetGame.genre = $("#genre").val();
      targetGame.grade = $("#grade").val();
      targetGame.price = parseInt($("#price").val());
      targetGame.imgUrl = $("#imgUrl").val();
      this.printList();
      this.updateGame(targetGame);
      this.clearInputData();
    }
  }

  updateGame(updateData) {
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
        })
        .fail(function(jqXHR, textStatus, errorThrown) {
          alert("실패", textStatus);
        });

  }

  delGame() {
    if (this.checkGame("del")) {
      const targetGame = this.#gameList.find(item => this.#selectedId === item.id);
      this.#gameList.splice(this.#gameList.indexOf(targetGame) ,1);
      this.printList();
      this.clearInputData();
    }
  }

  imgChange() {
    $("#imgPreview").attr("src", $("#imgUrl").val());
  }
}

$(() => {
  // jquery 실행
  let nint = new NintendoGame();
  nint.printList();

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
    nint.setData2InputBox($(this).index());
    nint.imgChange();
  });
});
