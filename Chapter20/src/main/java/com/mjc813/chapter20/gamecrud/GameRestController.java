package com.mjc813.chapter20.gamecrud;

import com.mjc813.chapter20.CommonResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameRestController {
    // 서비스를 멤버변수로 등록함
    @Autowired
    private GameService gameService;

    @PostMapping("/api/insert-data")
    public ResponseEntity<CommonResponse> insertData(@RequestBody GameDto gameDto) {
        try {
            System.out.println("insertData " + gameDto.toString());
            this.gameService.insertData(gameDto); // 서비스의 insertData를 실행함
            return ResponseEntity.ok().body(new CommonResponse(0, "ok"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonResponse(-999, "Server Error"));
        }
    }

    @PatchMapping("/api/update-data")
    public ResponseEntity<CommonResponse> updateData(@RequestBody GameDto gameDto) {
        try {
            System.out.println("updateData " + gameDto.toString());
            this.gameService.updateData(gameDto);
            return ResponseEntity.ok().body(new CommonResponse(0, "ok"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonResponse(-999, "Server Error"));
        }
    }

    @ResponseBody
    @DeleteMapping("/api/delete-data")
    public ResponseEntity<CommonResponse> deleteData(@RequestBody GameDto gameDto) {
        try {
            System.out.println("deleteData: " + gameDto.getId());
            this.gameService.deleteData(gameDto.getId());
            return ResponseEntity.ok().body(new CommonResponse(0, "ok"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonResponse(-999, "Server Error"));
        }
    }

    @ResponseBody
    @GetMapping("/api/getdata")
    public ResponseEntity<CommonResponse> getData(@RequestParam("id") Integer id) {
        try {
            System.out.println("getData: " + id);
            GameDto find = this.gameService.findById(id);
            return ResponseEntity.ok().body(new CommonResponse(0, "ok", find));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonResponse(-999, "Server Error"));
        }
    }
}
