package hello;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import asap.T2sserviceimpl;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class GreetingController {

    @RequestMapping("/speak")

    public byte[] speak(@RequestParam(value = "name", defaultValue = "be carefull") String name,HttpServletResponse response) {

        T2sserviceimpl t2sserviceimpl = new T2sserviceimpl();

        try {
            response.getOutputStream().write(t2sserviceimpl.speak(name));
            response.addHeader("Content-disposition", "attachment;filename=hello_world.wav");
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] array = new byte[0];
        try {
            array = Files.readAllBytes(new File("hello_world.wav").toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;


    }
}
