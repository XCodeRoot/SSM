package com.atguigu.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class FileUpAndDownController {

    @RequestMapping("/text/down")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径,如果是本机服务器,则会在d盘idea这个项目里的target目录下的snapshot里,真实路径
        String realPath = servletContext.getRealPath("/img/1.jpg");//写webapp目录下的路径, 修改路径即可变更 下载
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组 ,is.available()获取当前输入流对应文件的字节数
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");//修改文件名 1.jpg可改
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象 , 参数 :响应体bytes , 响应头header ,响应状态码
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);//参数组成完整的响应报文
        //关闭输入流
        is.close();
        return responseEntity;
    }

    /** 上传文件:
     *      1.将file转换为MultipartFile类型
     *      2.获取文件名
     *      3.获取ServletContext对象
     *      4.获取当前工程的真实路径
     *      5.创建photoPath所对应的File对象
     *      6.上传文件
     *
     * @param photo
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping("/test/up")
    public String testUp(MultipartFile photo, HttpSession session) throws IOException {
        //MultipartFile 形参来接收 上传的文件,形参名要和文件名对应 ,
        //SpringMVC配置文件解析器,才能将上传的file转换为MultipartFile类型
        String filename = photo.getOriginalFilename();//获取文件名
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取当前工程的真实路径
        String photoPath = servletContext.getRealPath("photo");
        //创建photoPath所对应的File对象,这样就有目录了
        File file = new File(photoPath);
        //判断file所对应目录是否存在
        if (!file.exists()) {
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + filename;//完整上传文件的路径
        //上传文件
        photo.transferTo(new File(finalPath)); //上传后的文件 ,最终可以在target目录下找到 photo目录里的文件
        return "success";
    }
}
