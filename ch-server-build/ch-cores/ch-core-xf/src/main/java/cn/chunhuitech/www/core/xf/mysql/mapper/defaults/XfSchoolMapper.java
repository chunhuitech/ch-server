package cn.chunhuitech.www.core.xf.mysql.mapper.defaults;

import cn.chunhuitech.www.core.xf.model.pojo.XfSchool;
import cn.chunhuitech.www.core.xf.model.pojo.XfSchoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface XfSchoolMapper {
    long countByExample(XfSchoolExample example);

    int deleteByExample(XfSchoolExample example);

    @Delete({
        "delete from xf_school",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into xf_school (name, description, ",
        "modify_time, create_time, ",
        "status)",
        "values (#{name,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{modifyTime,jdbcType=BIGINT}, #{createTime,jdbcType=BIGINT}, ",
        "#{status,jdbcType=TINYINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(XfSchool record);

    int insertSelective(XfSchool record);

    List<XfSchool> selectByExample(XfSchoolExample example);

    @Select({
        "select",
        "id, name, description, modify_time, create_time, status",
        "from xf_school",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.chunhuitech.www.core.xf.mysql.mapper.defaults.XfSchoolMapper.BaseResultMap")
    XfSchool selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XfSchool record, @Param("example") XfSchoolExample example);

    int updateByExample(@Param("record") XfSchool record, @Param("example") XfSchoolExample example);

    int updateByPrimaryKeySelective(XfSchool record);

    @Update({
        "update xf_school",
        "set name = #{name,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "modify_time = #{modifyTime,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=BIGINT},",
          "status = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(XfSchool record);
}