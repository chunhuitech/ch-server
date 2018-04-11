package cn.chunhuitech.www.core.admin.mysql.mapper.defaults;

import cn.chunhuitech.www.core.admin.model.pojo.ProductInfo;
import cn.chunhuitech.www.core.admin.model.pojo.ProductInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface ProductInfoMapper {
    long countByExample(ProductInfoExample example);

    int deleteByExample(ProductInfoExample example);

    @Delete({
        "delete from product_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into product_info (name, technology_platform, ",
        "version, version_num, ",
        "down_address, modify_time, ",
        "create_time, remarks, ",
        "status)",
        "values (#{name,jdbcType=VARCHAR}, #{technologyPlatform,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=VARCHAR}, #{versionNum,jdbcType=INTEGER}, ",
        "#{downAddress,jdbcType=VARCHAR}, #{modifyTime,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=BIGINT}, #{remarks,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=TINYINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    List<ProductInfo> selectByExample(ProductInfoExample example);

    @Select({
        "select",
        "id, name, technology_platform, version, version_num, down_address, modify_time, ",
        "create_time, remarks, status",
        "from product_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("cn.chunhuitech.www.core.admin.mysql.mapper.defaults.ProductInfoMapper.BaseResultMap")
    ProductInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductInfo record, @Param("example") ProductInfoExample example);

    int updateByExample(@Param("record") ProductInfo record, @Param("example") ProductInfoExample example);

    int updateByPrimaryKeySelective(ProductInfo record);

    @Update({
        "update product_info",
        "set name = #{name,jdbcType=VARCHAR},",
          "technology_platform = #{technologyPlatform,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=VARCHAR},",
          "version_num = #{versionNum,jdbcType=INTEGER},",
          "down_address = #{downAddress,jdbcType=VARCHAR},",
          "modify_time = #{modifyTime,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=BIGINT},",
          "remarks = #{remarks,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ProductInfo record);
}