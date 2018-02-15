package com.zytec.upload.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.zytec.type.utils.GetUser;
import com.zytec.type.utils.DataListReturn;
import com.zytec.type.utils.GetPath;
import com.zytec.type.utils.PictureType;
import com.zytec.upload.model.PicName;
import com.zytec.upload.model.Picture;
import com.zytec.upload.service.PictureService;



/**
 * 文件(图片) 上传
 * @author wangsl
 */
@RequestMapping("uploadPicture")
@Controller
public class PictureController {

    
    @Autowired
    @Qualifier("pictureServiceImpl")
    private PictureService pictureServiceImpl;
    
    @RequestMapping("picture")
    public String picture(){
        return "picture";
    }
    
    @RequestMapping("picture1")
    @ResponseBody
    public DataListReturn picture1(){
        DataListReturn dlr = new DataListReturn();
        dlr.setStatus(false);
        dlr.setMessage("用户未登录");
        return dlr;
    }
    
    @RequestMapping(value = "getPictureName", method = RequestMethod.POST)
    @ResponseBody
    public DataListReturn getPictureName(Picture record){
        DataListReturn dlr = new DataListReturn();
        if(record.getpOf()==null){
            dlr.setStatus(false);
            dlr.setMessage("获取图片名需要pOf参数");
            return dlr;
        }
        dlr.setStatus(true);
        dlr.setMessage("success");
        Map<String,Object> map = new HashMap<String,Object>();
        GetPath g = new GetPath();
        String readPath = g.getReadPath();
        List<Picture> list = pictureServiceImpl.selectPictureName(record);
        PicName p = new PicName();
        for(Picture s : list){
            if("hzz".equals(s.getType())){
                p.setHzz(readPath+s.getAddress());
            }
            if("sfz".equals(s.getType())){
                p.setSfz(readPath+s.getAddress());
            }
            if("ycz".equals(s.getType())){
                p.setYcz(readPath+s.getAddress());
            }
            if("ecz".equals(s.getType())){
                p.setEcz(readPath+s.getAddress());
            }
        }
        map.put("picturename",p);
        dlr.setDataList(map);
        return dlr;
    }
    
    
    
    @Transactional
    @RequestMapping(value = "pictureUp", method = RequestMethod.POST)
    @ResponseBody
    public DataListReturn picture1(MultipartHttpServletRequest request,Picture record){
        DataListReturn dlr = new DataListReturn();
        String userName = null;
        if (SecurityUtils.getSubject().isAuthenticated()) {
            userName = GetUser.getUsername();
        }
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        PictureType pt = new PictureType();
        GetPath g = new GetPath();
            MultipartFile file = request.getFile("picture");
            if(file == null){
                if(record.getpOf()==null||record.getType()==null){
                    dlr.setStatus(false);
                    dlr.setMessage("删除图片需要传入pOf,type参数");
                    return dlr;
                }
                String address = pictureServiceImpl.selectByOfAndType(record);
                if(address==null){
                    dlr.setStatus(false);
                    dlr.setMessage("不允许上传空图片");
                }
                File fileUp = new File(g.getSavePath()+address);
                if(fileUp.exists()){
                    fileUp.delete();
                    pictureServiceImpl.deleteByOfAndType(record);
                    dlr.setStatus(true);
                    dlr.setMessage("删除成功");
                    return dlr;
                }
                
                
            }
            try{
                if(file.getSize()>52428800){
                    dlr.setStatus(false);
                    dlr.setMessage("图片大小不能超过50M");
                    return dlr;
                }
            }catch(Exception e){
                e.printStackTrace();
                dlr.setStatus(false);
                dlr.setMessage("获取图片大小失败!");
                return dlr;
            }
            String fileName = file.getOriginalFilename();
            String pName = fileName.substring(fileName.lastIndexOf("."));
            String savePath = g.getSavePath();
            if(pt.getJpeg().equals(pName)||pt.getJpg().equals(pName)
                    ||pt.getPdf().equals(pName)||pt.getPng().equals(pName)
                    ||pt.getGif().equals(pName)||pt.getBmp().equals(pName)){
                if(record.getpOf()==null||record.getType()==null){
                    dlr.setStatus(false);
                    dlr.setMessage("上传图片需要传入pOf,type参数");
                    return dlr;
                }else{
                   try{
                       String picName = record.getpOf()+record.getType()+pName;
                       File fileUp = new File(savePath+picName);
                       String existsName = pictureServiceImpl.selectByOfAndType(record);                 
                       if(existsName!=null){
                           File exists = new File(savePath+existsName);
                           if(exists.exists()){
                               exists.delete(); 
                               fileUp.createNewFile();
                               FileCopyUtils.copy(file.getBytes(), fileUp);
                               record.setXgr(userName);
                               record.setXgsj(sdf.format(new Date()));
                               record.setAddress(picName);
                               pictureServiceImpl.updateByAddress(record);
                             dlr.setStatus(true);
                             dlr.setMessage("图片修改成功");
                             return dlr;
                           }
                       }
                           FileCopyUtils.copy(file.getBytes(), fileUp);
                           record.setAddress(picName);  
                           record.setTjr(userName);
                           record.setTjsj(date);
                           pictureServiceImpl.realInsert(record);
                       dlr.setStatus(true);
                       dlr.setMessage("图片上传成功");
                       return dlr;
                   }catch(Exception e){
                       e.printStackTrace();
                       dlr.setStatus(false);
                       dlr.setMessage("未知错误");
                       return dlr;
                   }
                }
            }else{
                dlr.setStatus(false);
                dlr.setMessage("图片格式只能为:png jpg pdf jpeg");
                return dlr;
            }
        }
}
