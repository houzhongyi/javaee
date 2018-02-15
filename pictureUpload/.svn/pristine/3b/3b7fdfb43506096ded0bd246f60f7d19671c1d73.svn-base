package com.zytec.upload.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zytec.upload.dao.PictureMapper;
import com.zytec.upload.model.Picture;
import com.zytec.upload.service.PictureService;

@Service("pictureServiceImpl")
public class PictureServiceImpl implements PictureService{

    @Autowired
    private PictureMapper pictureMapper;
    
    @Override
    public Picture realInsert(Picture record) {
        pictureMapper.realInsert(record);
        return record;
    }

    @Override
    public int updateByAddress(Picture record) {
        pictureMapper.updateByOfAndType(record);
        return pictureMapper.updateByOfAndType(record);
    }

    @Override
    public int deleteByOfAndType(Picture record) {
        pictureMapper.deleteByOfAndType(record);
        return pictureMapper.deleteByOfAndType(record);
    }

    @Override
    public List<Picture> selectPictureName(Picture record) {
        return pictureMapper.selectPictureName(record);
    }

    @Override
    public String selectByOfAndType(Picture record) {
        return pictureMapper.selectByOfAndType(record);
    }

    @Override
    public int selectExists(Picture record) {
        return pictureMapper.selectExists(record);
    }

}
