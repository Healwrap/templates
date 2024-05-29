package cn.pepedd.template.service;

import cn.pepedd.template.entity.dto.LoginBodyDTO;
import cn.pepedd.template.entity.result.R;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * TODO
 *
 * @author pepedd864
 * @since 2023/11/24
 */
public interface IAuthService<T> extends IService<T> {
  /**
   * 登录
   *
   * @param loginBodyDto
   * @return
   */
  R<Boolean> login(LoginBodyDTO loginBodyDto);

  /**
   * 登出
   *
   * @return
   */
  R<Boolean> logout();
}
