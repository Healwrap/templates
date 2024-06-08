package cn.pepedd.template.entity.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户实体类
 *
 * @author pepedd864
 * @since 2023/11/24
 */
@Data
@Builder
@TableName(value = "sys_user", autoResultMap = true)
public class User implements Serializable {
  private Long id;

  private String username;
  private String nickname;
  private String password;
  private String role; // user: 普通用户, admin: 管理员, ban: 禁用
  private String phone;
  private String email;
  @TableField(fill = FieldFill.INSERT)
  private LocalDateTime createTime;
  @TableLogic
  private Integer deleted;
}
