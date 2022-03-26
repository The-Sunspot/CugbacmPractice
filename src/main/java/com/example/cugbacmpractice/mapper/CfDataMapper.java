package com.example.cugbacmpractice.mapper;

import com.example.cugbacmpractice.bean.CfData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CfDataMapper {
    List<CfData> getCfList();
    CfData getCfListBySid(String sid);
    int insertCfData(CfData cfData);
}
