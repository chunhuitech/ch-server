package cn.chunhuitech.www.core.admin.mysql.mapper.defaults;

import cn.chunhuitech.www.core.admin.model.pojo.AdminMenu;
import cn.chunhuitech.www.core.admin.model.pojo.AdminMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface AdminMenuMapper {
    long countByExample(AdminMenuExample example);

    int deleteByExample(AdminMenuExample example);

    @Delete({
        "delete from admin_menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into admin_menu (system_id, name, ",
        "index_path, route, ",
        "icon, res_url, seq, ",
        "des, status, modify_time, ",
        "create_time)",
        "values (#{systemId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{indexPath,jdbcType=VARCHAR}, #{route,jdbcType=VARCHAR}, ",
        "#{icon,jdbcType=VARCHAR}, #{resUrl,jdbcType=VARCHAR}, #{seq,jdbcType=INTEGER}, ",
        "#{des,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT}, #{modifyTime,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(AdminMenu record);

    int insertSelective(AdminMenu record);

    List<AdminMenu> selectByExample(AdminMenuExample example);

    @Select({
        "select",
        "id, system_id, name, index_path, route, icon, res_url, seq, des, status, modify_time, ",
        "create_time",
        "from admin_menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.chunhuitech.www.core.admin.mysql.mapper.defaults.AdminMenuMapper.BaseResultMap")
    AdminMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminMenu record, @Param("example") AdminMenuExample example);

    int updateByExample(@Param("record") AdminMenu record, @Param("example") AdminMenuExample example);

    int updateByPrimaryKeySelective(AdminMenu record);

    @Update({
        "update admin_menu",
        "set system_id = #{systemId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "index_path = #{indexPath,jdbcType=VARCHAR},",
          "route = #{route,jdbcType=VARCHAR},",
          "icon = #{icon,jdbcType=VARCHAR},",
          "res_url = #{resUrl,jdbcType=VARCHAR},",
          "seq = #{seq,jdbcType=INTEGER},",
          "des = #{des,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "modify_time = #{modifyTime,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AdminMenu record);
}