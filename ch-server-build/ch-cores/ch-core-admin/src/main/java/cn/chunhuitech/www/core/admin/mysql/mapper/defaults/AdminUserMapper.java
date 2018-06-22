package cn.chunhuitech.www.core.admin.mysql.mapper.defaults;

import cn.chunhuitech.www.core.admin.model.pojo.AdminUser;
import cn.chunhuitech.www.core.admin.model.pojo.AdminUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface AdminUserMapper {
    long countByExample(AdminUserExample example);

    int deleteByExample(AdminUserExample example);

    @Delete({
        "delete from admin_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into admin_user (username, password, ",
        "token, nickname, ",
        "avatar, email, qq, ",
        "weixin, union_id, ",
        "open_id, wx_nick_name, ",
        "wx_head_url, phone, ",
        "city, country, province, ",
        "language, gender, ",
        "status, des, modify_time, ",
        "create_time)",
        "values (#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{token,jdbcType=VARCHAR}, #{nickname,jdbcType=VARCHAR}, ",
        "#{avatar,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{qq,jdbcType=VARCHAR}, ",
        "#{weixin,jdbcType=VARCHAR}, #{unionId,jdbcType=VARCHAR}, ",
        "#{openId,jdbcType=VARCHAR}, #{wxNickName,jdbcType=VARCHAR}, ",
        "#{wxHeadUrl,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, ",
        "#{city,jdbcType=VARCHAR}, #{country,jdbcType=VARCHAR}, #{province,jdbcType=VARCHAR}, ",
        "#{language,jdbcType=VARCHAR}, #{gender,jdbcType=TINYINT}, ",
        "#{status,jdbcType=TINYINT}, #{des,jdbcType=VARCHAR}, #{modifyTime,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    List<AdminUser> selectByExample(AdminUserExample example);

    @Select({
        "select",
        "id, username, password, token, nickname, avatar, email, qq, weixin, union_id, ",
        "open_id, wx_nick_name, wx_head_url, phone, city, country, province, language, ",
        "gender, status, des, modify_time, create_time",
        "from admin_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.chunhuitech.www.core.admin.mysql.mapper.defaults.AdminUserMapper.BaseResultMap")
    AdminUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminUser record, @Param("example") AdminUserExample example);

    int updateByExample(@Param("record") AdminUser record, @Param("example") AdminUserExample example);

    int updateByPrimaryKeySelective(AdminUser record);

    @Update({
        "update admin_user",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "token = #{token,jdbcType=VARCHAR},",
          "nickname = #{nickname,jdbcType=VARCHAR},",
          "avatar = #{avatar,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "qq = #{qq,jdbcType=VARCHAR},",
          "weixin = #{weixin,jdbcType=VARCHAR},",
          "union_id = #{unionId,jdbcType=VARCHAR},",
          "open_id = #{openId,jdbcType=VARCHAR},",
          "wx_nick_name = #{wxNickName,jdbcType=VARCHAR},",
          "wx_head_url = #{wxHeadUrl,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR},",
          "country = #{country,jdbcType=VARCHAR},",
          "province = #{province,jdbcType=VARCHAR},",
          "language = #{language,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=TINYINT},",
          "status = #{status,jdbcType=TINYINT},",
          "des = #{des,jdbcType=VARCHAR},",
          "modify_time = #{modifyTime,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AdminUser record);
}