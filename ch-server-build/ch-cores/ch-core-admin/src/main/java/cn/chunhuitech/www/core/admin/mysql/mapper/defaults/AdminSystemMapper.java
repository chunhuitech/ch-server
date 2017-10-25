package cn.chunhuitech.www.core.admin.mysql.mapper.defaults;

import cn.chunhuitech.www.core.admin.model.pojo.AdminSystem;
import cn.chunhuitech.www.core.admin.model.pojo.AdminSystemExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface AdminSystemMapper {
    long countByExample(AdminSystemExample example);

    int deleteByExample(AdminSystemExample example);

    @Delete({
        "delete from admin_system",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into admin_system (name, des)",
        "values (#{name,jdbcType=VARCHAR}, #{des,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(AdminSystem record);

    int insertSelective(AdminSystem record);

    List<AdminSystem> selectByExample(AdminSystemExample example);

    @Select({
        "select",
        "id, name, des",
        "from admin_system",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.chunhuitech.www.core.admin.mysql.mapper.defaults.AdminSystemMapper.BaseResultMap")
    AdminSystem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminSystem record, @Param("example") AdminSystemExample example);

    int updateByExample(@Param("record") AdminSystem record, @Param("example") AdminSystemExample example);

    int updateByPrimaryKeySelective(AdminSystem record);

    @Update({
        "update admin_system",
        "set name = #{name,jdbcType=VARCHAR},",
          "des = #{des,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AdminSystem record);
}