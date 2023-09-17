package com.bjsxt.mapper;


import com.bjsxt.pojo.Produce;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProduceMapper {
    @Select("select * from prod")
    List<Produce> getProd();

    //    INSERT INTO `test`.`prod` (`produce`, `number`, `time`, `orderNumber`, `requestArea`, `contactAddress`, `remark`) VALUES ('冰箱', 10, 1111111111222554455, 1102, '湖南省', '湖南省长沙理工大学', '加急');
    @Insert("INSERT INTO `test`.`prod` (`produce`, `number`, `time`, `orderNumber`, `requestArea`, `contactAddress`, `remark`) VALUES (#{produce}, #{number}, #{time} ,#{orderNumber},#{requestArea},#{contactAddress},#{remark});")
    Integer addProd(Produce p);

    @Delete("delete FROM `prod` WHERE `orderNumber`= #{orderNumber}")
    Integer deleteProd(String orderNumber);
}

