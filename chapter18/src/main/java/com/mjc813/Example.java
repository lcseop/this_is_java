package com.mjc813;

import javax.xml.crypto.Data;
import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Example {
    public void writeExample() {
        OutputStream os = null;
        try {
            os = new FileOutputStream("test1.db");

            byte a = 10;
            byte b = 20;
            byte c = 30;

            os.write(a);
            os.write(b);
            os.write(c);

            os.flush();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                os.close();
            } catch (Exception e) {}
        }
    }

    public void writeByteArrayExample() {
        OutputStream os = null;
        try {
            os = new FileOutputStream("test2.db");

            byte[] array = { 10, 20, 30 };

            os.write(array);

            os.flush();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                os.close();
            } catch (Exception e) {}
        }
    }

    public void readExample() {
        InputStream is = null;
        try {
            is = new FileInputStream("test1.db");

            while (true) {
                int data = is.read();
                if (data == -1) break;
                System.out.println(data);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                is.close();
            } catch (Exception e) {}
        }
    }

    public void readByteArrayExample() {
        InputStream is = null;
        try {
            is = new FileInputStream("test2.db");

            byte[] data = new byte[100];

            while (true) {
                int num = is.read(data);
                if (num == -1) break;

                for (int i = 0; i < num; i++) {
                    System.out.println(data[i]);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                is.close();
            } catch (Exception e) {}
        }
    }

    public void copyExample() {
        String originalFileName = "test.jpg";
        String targetFileName = "test2.jpg";

        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(originalFileName);
            os = new FileOutputStream(targetFileName);

            is.transferTo(os);
            os.flush();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                os.close();
            } catch (Exception e) {}
            try {
                is.close();
            } catch (Exception e) {}
        }
    }

    public void stringWriteExample() {
        Writer writer = null;
        try {
            writer = new FileWriter("test.txt");

            char a = 'A';
            writer.write(a);
            char b = 'B';
            writer.write(b);

            char[] arr = { 'C', 'D', 'E' };
            writer.write(arr);

            writer.write("FGH");

            writer.flush();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                writer.close();
            } catch (Exception e) {}
        }
    }

    public void stringReadExample() {
        Reader reader = null;
        try {
            reader = new FileReader("test.txt");
            while (true) {
                int data = reader.read();
                if (data == -1) break;
                System.out.println((char) data);
            }
            System.out.println();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                reader.close();
            } catch (Exception e) {}
        }

        try {
            reader = new FileReader("test.txt");
            char[] data = new char[100];
            while (true) {
                int num = reader.read(data);
                if (num == -1) break;
                for (int i = 0; i < num; i++) {
                    System.out.println(data[i]);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                reader.close();
            } catch (Exception e) {}
        }
    }

    public void characterConvertStreamExample() {
        OutputStream os = null;
        Writer writer = null;
        try {
            os = new FileOutputStream("test2.txt");
            writer = new OutputStreamWriter(os, StandardCharsets.UTF_8);
            writer.write("문자 변환 스트림을 사용합니다.");
            writer.flush();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                writer.close();
            } catch (Exception e) {}
            try {
                os.close();
            } catch (Exception e) {}
        }

        InputStream is = null;
        Reader reader = null;
        try {
            is = new FileInputStream("test2.txt");
            reader = new InputStreamReader(is, StandardCharsets.UTF_8);
            char[] data = new char[100];
            int num = reader.read(data);
            String str = new String(data, 0, num);
            System.out.println(str);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                reader.close();
            } catch (Exception e) {}
            try {
                is.close();
            } catch (Exception e) {}
        }
    }

    public void bufferExample() {
        String originalFilePath1 = Example.class.getResource("originalFile1.jpg").getPath();
        String targetFilePath1 = "targetFile1.jpg";
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(originalFilePath1);
            fos = new FileOutputStream(targetFilePath1);

            long nonBufferTime = copy(fis, fos);
            System.out.println("버퍼 미사용:\t" + nonBufferTime + " ns");
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                fos.close();
            } catch (Exception e) {}
            try {
                fis.close();
            } catch (Exception e) {}
        }


        String originalFilePath2 = Example.class.getResource("originalFile2.jpg").getPath();
        String targetFilePath2 = "targetFile2.jpg";
        FileInputStream fis2 = null;
        FileOutputStream fos2 = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            fis2 = new FileInputStream(originalFilePath2);
            fos2 = new FileOutputStream(targetFilePath2);
            bis = new BufferedInputStream(fis2);
            bos = new BufferedOutputStream(fos2);

            long bufferTime = copy(bis, bos);
            System.out.println("버퍼 사용:\t" + bufferTime + " ns");
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                fos2.close();
            } catch (Exception e) {}
            try {
                fis2.close();
            } catch (Exception e) {}
            try {
                bos.close();
            } catch (Exception e) {}
            try {
                bis.close();
            } catch (Exception e) {}
        }
    }

    public long copy (InputStream is, OutputStream os) throws Exception {
        long start = System.nanoTime();
        while(true) {
            int data = is.read();
            if (data == -1) break;
            os.write(data);
        }
        os.flush();
        long end = System.nanoTime();
        return (end - start);
    }

    public void readLineExample() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/main/java/com/mjc813/Main.java"));

            int lineNo = 1;
            String str = null;
            while((str = br.readLine()) != null) {
                System.out.println(lineNo + "\t" + str);
                lineNo++;
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                br.close();
            } catch (Exception e) {}
        }
    }

    public void dataInputOutputStreamExample() {
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        FileInputStream fis = null;
        DataInputStream dis = null;
        try {
            fos = new FileOutputStream("primitive.db");
            dos = new DataOutputStream(fos);

            dos.writeUTF("홍길동");
            dos.writeDouble(95.5);
            dos.writeInt(1);

            dos.writeUTF("감자바");
            dos.writeDouble(90.3);
            dos.writeInt(2);

            dos.flush();

            fis = new FileInputStream("primitive.db");
            dis = new DataInputStream(fis);

            for (int i = 0; i < 2; i++) {
                String name = dis.readUTF();
                double score = dis.readDouble();
                int order = dis.readInt();
                System.out.println(name + " : " + score + " : " + order);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                dis.close();
            } catch (Exception e) {}
            try {
                fis.close();
            } catch (Exception e) {}
            try {
                dos.close();
            } catch (Exception e) {}
            try {
                fos.close();
            } catch (Exception e) {}
        }
    }

    public void printStreamExample() {
        FileOutputStream fos = null;
        PrintStream ps = null;
        try {
            fos = new FileOutputStream("printStream.txt");
            ps = new PrintStream(fos);

            ps.print("마치 ");
            ps.println("프린터가 출력하는 것처럼");
            ps.println("데이터를 출력합니다.");
            ps.printf("| %6d | %-10s | %10s | \n", 1, "홍길동", "도적");
            ps.printf("| %6d | %-10s | %10s | \n", 2, "감자바", "학생");

            ps.flush();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                ps.close();
            } catch (Exception e) {}
            try {
                fos.close();
            } catch (Exception e) {}
        }
    }

    public void objectInputOutputStreamExample() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fos = new FileOutputStream("object.dat");
            oos = new ObjectOutputStream(fos);

            Member m1 = new Member("fall", "단풍이");
            Product p1 = new Product("노트북", 1500000);
            int[] arr1 = { 1, 2, 3 };

            oos.writeObject(m1);
            oos.writeObject(p1);
            oos.writeObject(arr1);

            oos.flush();

            fis = new FileInputStream("object.dat");
            ois = new ObjectInputStream(fis);

            Member m2 = (Member) ois.readObject();
            Product p2 = (Product) ois.readObject();
            int[] arr2 = (int[]) ois.readObject();

            System.out.println(m2);
            System.out.println(p2);
            System.out.println(Arrays.toString(arr2));
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                ois.close();
            } catch (Exception e) {}
            try {
                fis.close();
            } catch (Exception e) {}
            try {
                oos.close();
            } catch (Exception e) {}
            try {
                fos.close();
            } catch (Exception e) {}
        }
    }

    public void fileExample() {
        try {
            File dir = new File("Temp/images");
            File file1 = new File("Temp/file1.txt");
            File file2 = new File("Temp/file2.txt");
            File file3 = new File("Temp/file3.txt");
            if (dir.exists() == false) {dir.mkdirs();}
            if (file1.exists() == false) {file1.createNewFile();}
            if (file2.exists() == false) {file2.createNewFile();}
            if (file3.exists() == false) {file3.createNewFile();}

            File temp = new File("Temp");
            File[] contents = temp.listFiles();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
            for (File file : contents) {
                System.out.printf("%-25s", sdf.format(new Date(file.lastModified())));
                if (file.isDirectory()) {
                    System.out.printf("%-10s%-20s", "<DIR>", file.getName());
                } else {
                    System.out.printf("%-10s%-20s", file.length(), file.getName());
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public void filesExample() {
        try {
            String data = "" +
                    "id: winter\n" +
                    "email: winter@mycompany.com\n" +
                    "tel: 010-123-1234";

            Path path = Paths.get("Temp/user.txt");

            Files.writeString(Paths.get("Temp/user.txt"), data, Charset.forName("UTF-8"));

            System.out.println("파일 유형: " + Files.probeContentType(path));
            System.out.println("파일 크기: " + Files.size(path) + " bytes");

            String content = Files.readString(path, Charset.forName("UTF-8"));
            System.out.println(content);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void exam07() {
        String filePath = "src/main/java/com/mjc813/Main.java";

        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(filePath);
            br = new BufferedReader(fr);

            int rowNumber = 0;
            String rowData = null;

            while (true) {
                if ((rowData = br.readLine()) == null) break;
                System.out.println(++rowNumber + ": " + rowData);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                br.close();
            } catch (Exception e) {}
            try {
                fr.close();
            } catch (Exception e) {}
        }
    }

    public void exam10() {
        String originalPath = "Temp/dir1/photo1.jpg";
        String targetPath = "Temp/dir2/photo2.jpg";

        InputStream is = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        System.out.println("원본 파일 경로: " + originalPath);
        System.out.println("복사 파일 경로: " + targetPath);
        File fi = new File("Temp/dir1/photo1.jpg");
        if (fi.exists()) {
            try {
                is = new FileInputStream(originalPath);
                os = new FileOutputStream(targetPath);
                bis = new BufferedInputStream(is);
                bos = new BufferedOutputStream(os);

                bis.transferTo(bos);
                System.out.println("파일 복사 성공");

            } catch (Exception e) {
                System.err.println(e);
            } finally {
                try {
                    bis.close();
                } catch (Exception e) {
                }
                try {
                    bos.close();
                } catch (Exception e) {
                }
                try {
                    os.close();
                } catch (Exception e) {
                }
                try {
                    is.close();
                } catch (Exception e) {
                }
            }
        } else {
            System.out.println("원본 파일이 존재하지 않습니다.");
        }
    }
}
