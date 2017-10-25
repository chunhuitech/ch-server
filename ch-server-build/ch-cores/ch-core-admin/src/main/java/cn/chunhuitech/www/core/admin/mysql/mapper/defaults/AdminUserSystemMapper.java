package cn.chunhuitech.www.core.admin.mysql.mapper.defaults;

import cn.chunhuitech.www.core.admin.model.pojo.AdminUserSystem;
import cn.chunhuitech.www.core.admin.model.pojo.AdminUserSystemExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface AdminUserSystemMapper {
    long countByExample(AdminUserSystemExample example);

    int deleteByExample(AdminUserSystemExample example);

    @Delete({
        "delete from admin_user_system",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into admin_user_system (user_id, system_id)",
        "values (#{userId,jdbcType=INTEGER}, #{systemId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(AdminUserSystem record);

    int insertSelective(AdminUserSystem record);

    List<AdminUserSystem> selectByExample(AdminUserSystemExample example);

    @Select({
        "select",
        "id, user_id, system_id",
        "from admin_user_system",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.chunhuitech.www.core.admin.mysql.mapper.defaults.AdminUserSystemMapper.BaseResultMap")
    AdminUserSystem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminUserSystem record, @Param("example") AdminUserSystemExample example);

    int updateByExample(@Param("record") AdminUserSystem record, @Param("example") AdminUserSystemExample example);

    int updateByPrimaryKeySelective(AdminUserSystem record);

    @Update({
        "update admin_user_system",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "system_id = #{systemId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AdminUserSystem record);
}