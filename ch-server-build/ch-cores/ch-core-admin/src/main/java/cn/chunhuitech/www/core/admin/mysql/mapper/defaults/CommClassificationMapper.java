package cn.chunhuitech.www.core.admin.mysql.mapper.defaults;

import cn.chunhuitech.www.core.admin.model.pojo.CommClassification;
import cn.chunhuitech.www.core.admin.model.pojo.CommClassificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface CommClassificationMapper {
    long countByExample(CommClassificationExample example);

    int deleteByExample(CommClassificationExample example);

    @Delete({
        "delete from comm_classification",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into comm_classification (cn_name, en_name, ",
        "parent_id, leaf, ",
        "sort_num, status, ",
        "des, modify_time, ",
        "create_time)",
        "values (#{cnName,jdbcType=VARCHAR}, #{enName,jdbcType=VARCHAR}, ",
        "#{parentId,jdbcType=INTEGER}, #{leaf,jdbcType=TINYINT}, ",
        "#{sortNum,jdbcType=INTEGER}, #{status,jdbcType=TINYINT}, ",
        "#{des,jdbcType=VARCHAR}, #{modifyTime,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(CommClassification record);

    int insertSelective(CommClassification record);

    List<CommClassification> selectByExample(CommClassificationExample example);

    @Select({
        "select",
        "id, cn_name, en_name, parent_id, leaf, sort_num, status, des, modify_time, create_time",
        "from comm_classification",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.chunhuitech.www.core.admin.mysql.mapper.defaults.CommClassificationMapper.BaseResultMap")
    CommClassification selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommClassification record, @Param("example") CommClassificationExample example);

    int updateByExample(@Param("record") CommClassification record, @Param("example") CommClassificationExample example);

    int updateByPrimaryKeySelective(CommClassification record);

    @Update({
        "update comm_classification",
        "set cn_name = #{cnName,jdbcType=VARCHAR},",
          "en_name = #{enName,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=INTEGER},",
          "leaf = #{leaf,jdbcType=TINYINT},",
          "sort_num = #{sortNum,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT},",
          "des = #{des,jdbcType=VARCHAR},",
          "modify_time = #{modifyTime,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommClassification record);
}