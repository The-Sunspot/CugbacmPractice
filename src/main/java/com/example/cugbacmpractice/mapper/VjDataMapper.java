package com.example.cugbacmpractice.mapper;

import com.example.cugbacmpractice.bean.CfData;
import com.example.cugbacmpractice.bean.VjData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VjDataMapper {
    List<VjData> getVjList();
    VjData getVjListBySid(String sid);
    int insertVjData(VjData vjData);
}
