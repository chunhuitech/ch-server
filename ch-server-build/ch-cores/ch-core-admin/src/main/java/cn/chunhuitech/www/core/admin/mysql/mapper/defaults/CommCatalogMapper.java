package cn.chunhuitech.www.core.admin.mysql.mapper.defaults;

import cn.chunhuitech.www.core.admin.model.pojo.CommCatalog;
import cn.chunhuitech.www.core.admin.model.pojo.CommCatalogExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface CommCatalogMapper {
    long countByExample(CommCatalogExample example);

    int deleteByExample(CommCatalogExample example);

    @Delete({
        "delete from comm_catalog",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into comm_catalog (title, class_id, ",
        "start_page, end_page, ",
        "status, modify_time, ",
        "create_time)",
        "values (#{title,jdbcType=VARCHAR}, #{classId,jdbcType=INTEGER}, ",
        "#{startPage,jdbcType=INTEGER}, #{endPage,jdbcType=INTEGER}, ",
        "#{status,jdbcType=TINYINT}, #{modifyTime,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(CommCatalog record);

    int insertSelective(CommCatalog record);

    List<CommCatalog> selectByExample(CommCatalogExample example);

    @Select({
        "select",
        "id, title, class_id, start_page, end_page, status, modify_time, create_time",
        "from comm_catalog",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.chunhuitech.www.core.admin.mysql.mapper.defaults.CommCatalogMapper.BaseResultMap")
    CommCatalog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommCatalog record, @Param("example") CommCatalogExample example);

    int updateByExample(@Param("record") CommCatalog record, @Param("example") CommCatalogExample example);

    int updateByPrimaryKeySelective(CommCatalog record);

    @Update({
        "update comm_catalog",
        "set title = #{title,jdbcType=VARCHAR},",
          "class_id = #{classId,jdbcType=INTEGER},",
          "start_page = #{startPage,jdbcType=INTEGER},",
          "end_page = #{endPage,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT},",
          "modify_time = #{modifyTime,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommCatalog record);
}