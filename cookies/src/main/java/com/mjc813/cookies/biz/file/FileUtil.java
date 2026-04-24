package com.mjc813.cookies.biz.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Locale;
import java.util.Random;

@Component
@Slf4j
public class FileUtil {
    /**
     * 디렉토리가 존재하면 true를 리턴한다.
     * @param dir 디렉토리 존재 여부를 체크할 디렉토리 path 문자열
     * @return
     */
    public boolean checkDirectory(String dir) {
            if (dir == null) return false;
            File f = new File(dir);
            return f.exists();
    }

    /**
     * 디렉토리를 재귀적으로 생성해준다.
     * @param dir "d:/temp/a/b/c"
     * @return
     */
    public boolean makeRecursiveDirectory(String dir) throws IOException {
        if (dir == null) return false;

        Path path = Paths.get(dir);

        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        return true;
    }

    public boolean deleteRecursiveDirectory(String dir) throws IOException {
        if (dir == null) return false;
        Path path = Paths.get(dir);
        return true;
    }

    public String getRandomStoreFileName(int length) {
        String arrs = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rnd = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int index = rnd.nextInt(arrs.length());
            sb.append(arrs.charAt(index));
        }
        return sb.toString();
    }

    public String getExtension(String fileName) {
        if (fileName == null) {
            return "";
        }
        int lastIndex = fileName.lastIndexOf('.');
        if (lastIndex == -1)
            return "";
        return fileName.substring(lastIndex + 1).toLowerCase();
    }

    public boolean deleteFile(String fileName) {
        if (!this.checkDirectory(fileName)) {
            return false;
        }
//      File file = new File(fileName);
        try {
            Path path = Paths.get(fileName);
            Files.delete(path);
        } catch (IOException e) {
            log.error(e.getMessage());
            return false;
        }
            return true;
    }

    /**
     * 첨부파일을 path/dest 경로로 파일 복사르 한다. 결과는 복사된 바이트 수를 리턴한다.
     * @param src 첨부파일 객체인 MultipartFile
     * @param path 저장될 디렉토리
     * @param dest 저장될 파일명
     * @return 저장된 바이트 수
     * @throws IOException
     */
    public boolean copyFile(MultipartFile src, String path, String dest) throws IOException {
        if (src == null || path == null || dest == null) {
            return false;
        }
        if (!this.checkDirectory(path)) {
            this.makeRecursiveDirectory(path);
        }
        Path destPath = Paths.get(path + "/" + dest);
        long lResult = Files.copy(src.getInputStream(), destPath, StandardCopyOption.REPLACE_EXISTING);
        return lResult > 0;
    }
}
