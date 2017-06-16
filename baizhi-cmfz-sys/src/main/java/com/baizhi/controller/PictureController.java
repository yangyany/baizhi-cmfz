package com.baizhi.controller;

import com.baizhi.entity.Picture;
import com.baizhi.service.PictureService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static java.util.UUID.randomUUID;

/**
 * Created by yanyan on 2017/6/13.
 */
@Controller
@RequestMapping("/picture")
public class PictureController {
    @Resource
    private PictureService pictureService;

    /**
     * 展示所有图片
     */
    @RequestMapping("/splitPicture")
    @ResponseBody
  public Map splitPicture(Integer page,Integer rows){
        Map map = pictureService.queryPictureByPage(page,rows);
        return map;
  }
    /**
     * 查一个
     */
    @RequestMapping("/queryOne")
    @ResponseBody
    public Picture queryOne(String id){

            Picture picture = pictureService.queryById(id);
        System.out.println(picture);

        return picture;
    }
    /**
     * 修改
     */
    @RequestMapping("/updatePicture")
    @ResponseBody
    public Map updatePicture(Picture picture){
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            pictureService.update(picture);
            map.put("success","修改成功!");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("error",e.getMessage());
            return map;
        }

    }
    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(String id){
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            pictureService.delete(id);
            map.put("success","删除成功!");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("error",e.getMessage());
            return map;
        }

    }
    /**
     * 上传图片
     */
    @RequestMapping("/upload")
    public void upload(HttpServletRequest request, MultipartFile file,String title,String type) throws Exception {
        String realPath = request.getSession().getServletContext().getRealPath("/back/image");
        String newFileName = randomUUID().toString() +
                    new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
                    + "."
                    + FilenameUtils.getExtension(file.getOriginalFilename());
            Picture picture = new Picture();
            String str = UUID.randomUUID().toString();
            picture.setId(str);
            picture.setName(newFileName);
            picture.setTitle(title);
        picture.setType(type);
            //上传文件
        try {
            file.transferTo(new File(realPath, newFileName));
            pictureService.save(picture);
        } catch (IOException e) {
            pictureService.delete(str);
            e.printStackTrace();
        }

    }
    /**
     * 下载文件
     */
    @RequestMapping("/download")
    public void download(String name,HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取webapps中的图片路径
        String webapps = request.getSession().getServletContext().getRealPath("/back/image");
        System.out.println(webapps);
        //去指定上传目录获取当前下载文件的输入流
        FileInputStream fis = new FileInputStream(new File(webapps, name));

        //获取response响应流
        ServletOutputStream os = response.getOutputStream();
        //设置下载的响应类型
        response.setContentType("image/jpeg");
        response.setHeader("content-disposition","inline; name= "+ URLEncoder.encode(name,"UTF-8"));
        int len = 0;
        byte[] b = new byte[1024];
        while(true){
            len = fis.read(b);
            if(len==-1) break;
            os.write(b,0,len);
        }
        IOUtils.closeQuietly(fis);
        IOUtils.closeQuietly(os);
    }



}
