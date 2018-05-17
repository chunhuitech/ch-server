package cn.chunhuitech.www.core.admin.mysql.mapper.defaults;

import cn.chunhuitech.www.core.admin.model.pojo.CommPointReadBlock;
import cn.chunhuitech.www.core.admin.model.pojo.CommPointReadBlockExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface CommPointReadBlockMapper {
    long countByExample(CommPointReadBlockExample example);

    int deleteByExample(CommPointReadBlockExample example);

    @Delete({
        "delete from comm_point_read_block",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into comm_point_read_block (record_id, resource_id, ",
        "sort_num, left_position, ",
        "top_position, width, ",
        "height, begin_point, ",
        "end_point, title, ",
        "text, status, modify_time, ",
        "create_time)",
        "values (#{recordId,jdbcType=INTEGER}, #{resourceId,jdbcType=INTEGER}, ",
        "#{sortNum,jdbcType=INTEGER}, #{leftPosition,jdbcType=INTEGER}, ",
        "#{topPosition,jdbcType=INTEGER}, #{width,jdbcType=INTEGER}, ",
        "#{height,jdbcType=INTEGER}, #{beginPoint,jdbcType=INTEGER}, ",
        "#{endPoint,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{text,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT}, #{modifyTime,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(CommPointReadBlock record);

    int insertSelective(CommPointReadBlock record);

    List<CommPointReadBlock> selectByExample(CommPointReadBlockExample example);

    @Select({
        "select",
        "id, record_id, resource_id, sort_num, left_position, top_position, width, height, ",
        "begin_point, end_point, title, text, status, modify_time, create_time",
        "from comm_point_read_block",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.chunhuitech.www.core.admin.mysql.mapper.defaults.CommPointReadBlockMapper.BaseResultMap")
    CommPointReadBlock selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommPointReadBlock record, @Param("example") CommPointReadBlockExample example);

    int updateByExample(@Param("record") CommPointReadBlock record, @Param("example") CommPointReadBlockExample example);

    int updateByPrimaryKeySelective(CommPointReadBlock record);

    @Update({
        "update comm_point_read_block",
        "set record_id = #{recordId,jdbcType=INTEGER},",
          "resource_id = #{resourceId,jdbcType=INTEGER},",
          "sort_num = #{sortNum,jdbcType=INTEGER},",
          "left_position = #{leftPosition,jdbcType=INTEGER},",
          "top_position = #{topPosition,jdbcType=INTEGER},",
          "width = #{width,jdbcType=INTEGER},",
          "height = #{height,jdbcType=INTEGER},",
          "begin_point = #{beginPoint,jdbcType=INTEGER},",
          "end_point = #{endPoint,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "text = #{text,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "modify_time = #{modifyTime,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommPointReadBlock record);
}