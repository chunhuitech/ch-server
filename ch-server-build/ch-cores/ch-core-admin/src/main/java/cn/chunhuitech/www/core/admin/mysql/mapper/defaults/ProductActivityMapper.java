package cn.chunhuitech.www.core.admin.mysql.mapper.defaults;

import cn.chunhuitech.www.core.admin.model.pojo.ProductActivity;
import cn.chunhuitech.www.core.admin.model.pojo.ProductActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface ProductActivityMapper {
    long countByExample(ProductActivityExample example);

    int deleteByExample(ProductActivityExample example);

    @Delete({
        "delete from product_activity",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into product_activity (user_id, client_flag, ",
        "proc_name, proc_version, ",
        "proc_id, os, event_name, ",
        "ip, net_ip, area, ",
        "event_count, modify_time, ",
        "create_time, remarks, ",
        "status)",
        "values (#{userId,jdbcType=BIGINT}, #{clientFlag,jdbcType=VARCHAR}, ",
        "#{procName,jdbcType=VARCHAR}, #{procVersion,jdbcType=VARCHAR}, ",
        "#{procId,jdbcType=BIGINT}, #{os,jdbcType=VARCHAR}, #{eventName,jdbcType=VARCHAR}, ",
        "#{ip,jdbcType=VARCHAR}, #{netIp,jdbcType=VARCHAR}, #{area,jdbcType=VARCHAR}, ",
        "#{eventCount,jdbcType=INTEGER}, #{modifyTime,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=BIGINT}, #{remarks,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=TINYINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ProductActivity record);

    int insertSelective(ProductActivity record);

    List<ProductActivity> selectByExample(ProductActivityExample example);

    @Select({
        "select",
        "id, user_id, client_flag, proc_name, proc_version, proc_id, os, event_name, ",
        "ip, net_ip, area, event_count, modify_time, create_time, remarks, status",
        "from product_activity",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("cn.chunhuitech.www.core.admin.mysql.mapper.defaults.ProductActivityMapper.BaseResultMap")
    ProductActivity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductActivity record, @Param("example") ProductActivityExample example);

    int updateByExample(@Param("record") ProductActivity record, @Param("example") ProductActivityExample example);

    int updateByPrimaryKeySelective(ProductActivity record);

    @Update({
        "update product_activity",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "client_flag = #{clientFlag,jdbcType=VARCHAR},",
          "proc_name = #{procName,jdbcType=VARCHAR},",
          "proc_version = #{procVersion,jdbcType=VARCHAR},",
          "proc_id = #{procId,jdbcType=BIGINT},",
          "os = #{os,jdbcType=VARCHAR},",
          "event_name = #{eventName,jdbcType=VARCHAR},",
          "ip = #{ip,jdbcType=VARCHAR},",
          "net_ip = #{netIp,jdbcType=VARCHAR},",
          "area = #{area,jdbcType=VARCHAR},",
          "event_count = #{eventCount,jdbcType=INTEGER},",
          "modify_time = #{modifyTime,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=BIGINT},",
          "remarks = #{remarks,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ProductActivity record);
}