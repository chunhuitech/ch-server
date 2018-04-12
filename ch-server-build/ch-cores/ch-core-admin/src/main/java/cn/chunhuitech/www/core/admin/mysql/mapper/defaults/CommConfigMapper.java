package cn.chunhuitech.www.core.admin.mysql.mapper.defaults;

import cn.chunhuitech.www.core.admin.model.pojo.CommConfig;
import cn.chunhuitech.www.core.admin.model.pojo.CommConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface CommConfigMapper {
    long countByExample(CommConfigExample example);

    int deleteByExample(CommConfigExample example);

    @Delete({
        "delete from comm_config",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into comm_config (key_name, value_info, ",
        "status)",
        "values (#{keyName,jdbcType=VARCHAR}, #{valueInfo,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=TINYINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(CommConfig record);

    int insertSelective(CommConfig record);

    List<CommConfig> selectByExample(CommConfigExample example);

    @Select({
        "select",
        "id, key_name, value_info, status",
        "from comm_config",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.chunhuitech.www.core.admin.mysql.mapper.defaults.CommConfigMapper.BaseResultMap")
    CommConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommConfig record, @Param("example") CommConfigExample example);

    int updateByExample(@Param("record") CommConfig record, @Param("example") CommConfigExample example);

    int updateByPrimaryKeySelective(CommConfig record);

    @Update({
        "update comm_config",
        "set key_name = #{keyName,jdbcType=VARCHAR},",
          "value_info = #{valueInfo,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommConfig record);
}