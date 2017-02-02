package com.web.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by shiyi on 2016/12/19.
 */
@Controller("DownloadController")
@RequestMapping("/download")
public class DownloadController {

    @RequestMapping("image/{fileName:.+}")
    public ResponseEntity<byte[]> download(HttpServletRequest request, @PathVariable String fileName) throws IOException {

        String path = request.getServletContext().getRealPath("/");
        path += "/WEB-INF/static/images/" + fileName;

        System.out.println(path);

        File file=new File(path);
        HttpHeaders headers = new HttpHeaders();
        fileName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }
}
