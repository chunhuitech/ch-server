package cn.chunhuitech.www.core.admin.mysql.mapper.defaults;

import cn.chunhuitech.www.core.admin.model.pojo.CommResource;
import cn.chunhuitech.www.core.admin.model.pojo.CommResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface CommResourceMapper {
    long countByExample(CommResourceExample example);

    int deleteByExample(CommResourceExample example);

    @Delete({
        "delete from comm_resource",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into comm_resource (class_id, sort_num, ",
        "title, label, relative_path, ",
        "file_size, file_type, ",
        "status, modify_time, ",
        "create_time)",
        "values (#{classId,jdbcType=INTEGER}, #{sortNum,jdbcType=INTEGER}, ",
        "#{title,jdbcType=VARCHAR}, #{label,jdbcType=VARCHAR}, #{relativePath,jdbcType=VARCHAR}, ",
        "#{fileSize,jdbcType=INTEGER}, #{fileType,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=TINYINT}, #{modifyTime,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(CommResource record);

    int insertSelective(CommResource record);

    List<CommResource> selectByExample(CommResourceExample example);

    @Select({
        "select",
        "id, class_id, sort_num, title, label, relative_path, file_size, file_type, status, ",
        "modify_time, create_time",
        "from comm_resource",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.chunhuitech.www.core.admin.mysql.mapper.defaults.CommResourceMapper.BaseResultMap")
    CommResource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommResource record, @Param("example") CommResourceExample example);

    int updateByExample(@Param("record") CommResource record, @Param("example") CommResourceExample example);

    int updateByPrimaryKeySelective(CommResource record);

    @Update({
        "update comm_resource",
        "set class_id = #{classId,jdbcType=INTEGER},",
          "sort_num = #{sortNum,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "label = #{label,jdbcType=VARCHAR},",
          "relative_path = #{relativePath,jdbcType=VARCHAR},",
          "file_size = #{fileSize,jdbcType=INTEGER},",
          "file_type = #{fileType,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "modify_time = #{modifyTime,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommResource record);
}