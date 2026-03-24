class users {
    addData() {
        const newUser = {
            userid: $("#userId").val(),
            name: $("#userName").val(),
            password: $("#userPw").val(),
            age: $("#userAge").val(),
            email: $("#userEmail").val()
        };

        this.inputData(newUser);
        this.emptyData();
    }

    inputData(inputUser) {
        $.ajax({
            url: "/api/users"
            ,method: "POST"
            ,dataType: "json"
            ,data: JSON.stringify(inputUser)
            ,contentType: "application/json"
        })
            .done((data, textStatus, jqXHR) => {
                console.log("성공");
            });
    }

    emptyData() {
        $("#userId").val("");
        $("#userName").val("");
        $("#userPw").val("");
        $("#userAge").val("");
        $("#userEmail").val("");
    }
}



$(() => {
    users = new users();

    $("#dataAdd").click((e) => {
        users.addData();
    })

    $("#dataEmpty").click((e) => {
        users.emptyData();
    })
})