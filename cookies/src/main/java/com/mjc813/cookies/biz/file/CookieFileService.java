package com.mjc813.cookies.biz.file;

import com.mjc813.cookies.models.attach.AttachDto;
import com.mjc813.cookies.models.attach.AttachService;
import com.mjc813.cookies.models.cookie.CookieDto;
import com.mjc813.cookies.models.cookie.CookieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CookieFileService {
    @Value("${cookie.save-folder}")
    private String path;

    @Autowired
    private CookieService cookieService;

    @Autowired
    private AttachService attachService;

    @Autowired
    private FileUtil fileUtil;

    /**
     * List<MultipartFile> 첨부파일들을 AttachService insert를 한다.
     * 중간에 에러 발생 시에 전체 롤백할 것인지, 에러난 파일은 건너뛰고 남은 거 계속 저장할 것인지 정책으로 결정
     * @param cookieDto
     * @param files
     * @return
     */
    @Transactional(rollbackFor = {IOException.class}) // 메소드에서 RuntimeException이 발생하면 롤백 처리함, 그냥 Exception은 롤백 안함
    public List<AttachDto> insert(CookieDto cookieDto, List<MultipartFile> files) throws IOException {
        if (cookieDto == null || files == null || files.isEmpty()) {
            return null;
        }
        if (this.cookieService.findById(cookieDto.getId()) == null) {
            return null;
        }
        List<AttachDto> result = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
//        files.stream().forEach(file -> {
//            String ext = this.fileUtil.getExtension(file.getOriginalFilename());
//            String storeName = this.fileUtil.getRandomStoreFileName(50);
//            AttachDto attachDto = AttachDto.builder().id(null)
//                    .fileName(file.getOriginalFilename())
//                    .ext(ext)
//                    .size((int) file.getSize())
//                    .cookieId(cookieDto.getId())
//                    .path(this.path)
//                    .storeName(storeName)
//                    .build();
//            try {
//                AttachDto insert = this.attachService.insert(attachDto);
//                this.fileUtil.copyFile(file, attachDto.getPath(), attachDto.getStoreName());
//                result.add(insert);
//            } catch (IOException e) {
//                log.error("File : {}, {}", attachDto.getFileName(), e.getMessage());
//            }
//        });
        try {
            for (MultipartFile file : files) {
                String ext = this.fileUtil.getExtension(file.getOriginalFilename());
                String storeName = this.fileUtil.getRandomStoreFileName(50);
                AttachDto attachDto = AttachDto.builder().id(null)
                        .fileName(file.getOriginalFilename())
                        .ext(ext)
                        .size((int) file.getSize())
                        .cookieId(cookieDto.getId())
                        .path(this.path + "/" + now.getYear())
                        .storeName(storeName)
                        .build();
                AttachDto insert = this.attachService.insert(attachDto);
                this.fileUtil.copyFile(file, attachDto.getPath(), attachDto.getStoreName());
                result.add(insert);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            result.forEach(
                    attach -> this.fileUtil.deleteFile(attach.getPath() + "/" + attach.getStoreName())
            );
            throw e;
        }

        return result;
    }
}
