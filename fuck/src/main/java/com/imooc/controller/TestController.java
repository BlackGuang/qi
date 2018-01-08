package com.imooc.controller;

//import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import static javax.xml.crypto.dsig.Transform.BASE64;
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/hi")
    public String hi(){
        return "hi";
    }

    @RequestMapping(value="/toShowPic/{file}/{fileName}/{id}")
    public ModelAndView toShowPic(HttpServletRequest request, HttpServletResponse response, @PathVariable String file, @PathVariable String fileName, @PathVariable String id){
        ModelAndView mv = new ModelAndView();
        mv.addObject("id", id);
        mv.addObject("file", file);
        mv.addObject("fileName", fileName);
        mv.setViewName("/pbo/showPic");
        return mv;
    }

    @RequestMapping(value="/showPic/{file}/{fileName}/{id}")
    public void showPic(HttpServletRequest request,HttpServletResponse response,@PathVariable String file,@PathVariable String fileName,@PathVariable String id){
        //String uploadUrl = PropertyUtils.getValueByProperty("upload_reward_rule_path");
        String uploadUrl = ("upload_reward_rule_path");
        byte[] b=new byte[20];
        try {
            b = BASE64.getBytes(fileName);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        String str = new String(b);
        String[] strArr = str.split("/");


        String fileUrl=uploadUrl+"/"+file+"/"+strArr[0]+"."+strArr[1];
        try {
            File filePath = new File(fileUrl);
            if(filePath.exists()){
                //读图片
                FileInputStream inputStream = new FileInputStream(filePath);
                int available = inputStream.available();
                byte[] data = new byte[available];
                inputStream.read(data);
                inputStream.close();
                //写图片
                response.setContentType("image/"+strArr[1]);
                response.setCharacterEncoding("UTF-8");
                OutputStream stream = new BufferedOutputStream(response.getOutputStream());
                stream.write(data);
                stream.flush();
                stream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value="/toShowPic1")
    public ModelAndView toShowPic1(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new ModelAndView();
        int id=1;
        String file="D";
        String fileName="123.jpg";
        mv.addObject("id", id);
        mv.addObject("file", file);
        mv.addObject("fileName", fileName);
        mv.setViewName("/pbo/showPic");
        System.out.print("123");
        return mv;
    }

    @RequestMapping(value="/showPic1")
    public void showPic1(HttpServletRequest request,HttpServletResponse response){
        String fileUrl="D:/123.jpg";
        try {
            File filePath = new File(fileUrl);
            if(filePath.exists()){
                //读图片
                FileInputStream inputStream = new FileInputStream(filePath);
                int available = inputStream.available();
                byte[] data = new byte[available];
                inputStream.read(data);
                inputStream.close();
                //写图片
                response.setContentType("image/");
                response.setCharacterEncoding("UTF-8");
                OutputStream stream = new BufferedOutputStream(response.getOutputStream());
                stream.write(data);
                stream.flush();
                stream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
