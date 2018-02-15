package com.zytec.upload.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zytec.type.utils.DataListReturn;
import com.zytec.type.utils.GetPath;
import com.zytec.upload.model.PicName;
import com.zytec.upload.model.Picture;
import com.zytec.upload.service.PictureService;

@RequestMapping("Test")
@Controller
public class PictureTestController {

    @Autowired
    @Qualifier("pictureServiceImpl")
    private PictureService pictureServiceImpl;
    
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
}
