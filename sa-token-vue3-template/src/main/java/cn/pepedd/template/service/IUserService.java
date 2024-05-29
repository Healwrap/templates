package cn.pepedd.template.service;

import cn.pepedd.template.entity.dto.RegisterBodyDTO;
import cn.pepedd.template.entity.dto.UserUpdateDTO;
import cn.pepedd.template.entity.pojo.User;
import cn.pepedd.template.entity.result.R;
import cn.pepedd.template.entity.vo.UserVO;

/**
 * 用户相关接口
 *
 * @author pepedd864
 * @since 2023/11/24
 */
public interface IUserService extends IAuthService<User> {
  /**
   * 注册
   *
   * @param registerBodyDTO
   * @return
   */
  R<Boolean> register(RegisterBodyDTO registerBodyDTO);

  /**
   * 更新用户信息
   * @param userUpdateDTO
   * @return
   */
  R<Boolean> updateInfo(UserUpdateDTO userUpdateDTO);

  /**
   * 获取用户信息
   *
   * @return
   */
  R<UserVO> getInfo();
}
