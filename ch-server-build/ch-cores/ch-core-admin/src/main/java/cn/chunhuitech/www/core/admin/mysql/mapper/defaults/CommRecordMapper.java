package cn.chunhuitech.www.core.admin.mysql.mapper.defaults;

import cn.chunhuitech.www.core.admin.model.pojo.CommRecord;
import cn.chunhuitech.www.core.admin.model.pojo.CommRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface CommRecordMapper {
    long countByExample(CommRecordExample example);

    int deleteByExample(CommRecordExample example);

    @Delete({
        "delete from comm_record",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into comm_record (class_id, sort_num, ",
        "title, label, relative_path, ",
        "file_size, file_type, ",
        "content_html, content_plain, ",
        "status, modify_time, ",
        "create_time)",
        "values (#{classId,jdbcType=INTEGER}, #{sortNum,jdbcType=INTEGER}, ",
        "#{title,jdbcType=VARCHAR}, #{label,jdbcType=VARCHAR}, #{relativePath,jdbcType=VARCHAR}, ",
        "#{fileSize,jdbcType=INTEGER}, #{fileType,jdbcType=VARCHAR}, ",
        "#{contentHtml,jdbcType=VARCHAR}, #{contentPlain,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=TINYINT}, #{modifyTime,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(CommRecord record);

    int insertSelective(CommRecord record);

    List<CommRecord> selectByExample(CommRecordExample example);

    @Select({
        "select",
        "id, class_id, sort_num, title, label, relative_path, file_size, file_type, content_html, ",
        "content_plain, status, modify_time, create_time",
        "from comm_record",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.chunhuitech.www.core.admin.mysql.mapper.defaults.CommRecordMapper.BaseResultMap")
    CommRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommRecord record, @Param("example") CommRecordExample example);

    int updateByExample(@Param("record") CommRecord record, @Param("example") CommRecordExample example);

    int updateByPrimaryKeySelective(CommRecord record);

    @Update({
        "update comm_record",
        "set class_id = #{classId,jdbcType=INTEGER},",
          "sort_num = #{sortNum,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "label = #{label,jdbcType=VARCHAR},",
          "relative_path = #{relativePath,jdbcType=VARCHAR},",
          "file_size = #{fileSize,jdbcType=INTEGER},",
          "file_type = #{fileType,jdbcType=VARCHAR},",
          "content_html = #{contentHtml,jdbcType=VARCHAR},",
          "content_plain = #{contentPlain,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "modify_time = #{modifyTime,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommRecord record);
}