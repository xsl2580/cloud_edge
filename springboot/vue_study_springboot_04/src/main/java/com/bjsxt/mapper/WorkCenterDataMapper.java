package com.bjsxt.mapper;

import com.bjsxt.pojo.WorkCenterData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WorkCenterDataMapper {
    @Select("select * from work_center_data")
    List<WorkCenterData> getAllWorkCenterData();

    @Insert("INSERT INTO `test`.`work_center_data` (`WorkCenterIndex`, `StartTime`, `EndTime`, `ProcessingTime`, `Job`) VALUES (#{workCenterIndex}, #{startTime}, #{endTime}, #{processingTime}, #{job});")
    Integer saveAllWorkCenterData(WorkCenterData data);

}
