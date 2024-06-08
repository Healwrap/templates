package cn.pepedd.template.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.StpUtil;
import cn.pepedd.template.annotation.VerifyCaptcha;
import cn.pepedd.template.common.cache.RedisCache;
import cn.pepedd.template.common.enums.ErrorCode;
import cn.pepedd.template.common.enums.UserRoleEnum;
import cn.pepedd.template.entity.dto.LoginBodyDTO;
import cn.pepedd.template.entity.dto.RegisterBodyDTO;
import cn.pepedd.template.entity.dto.UserUpdateDTO;
import cn.pepedd.template.entity.pojo.User;
import cn.pepedd.template.entity.result.R;
import cn.pepedd.template.entity.vo.UserVO;
import cn.pepedd.template.exception.ThrowUtils;
import cn.pepedd.template.mapper.UserMapper;
import cn.pepedd.template.service.IUserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户服务实现类
 *
 * @author pepedd864
 * @since 2023/11/24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
  @Resource
  private RedisCache redisCache;

  public static void main(String[] args) {
//    String pw_hash = "$2a$10$HI2nRLS.KC/A2AMHd/tPBufnVS2UOPRmkodfRyFH7v04UOjFfRNhG";
//    System.out.println(BCrypt.checkpw("R769UqF0M2", pw_hash));
    System.out.println(BCrypt.hashpw("123456", BCrypt.gensalt()));
    System.out.println(BCrypt.checkpw("123456", "$2a$10$rFEbLSe2n5O.sVeT80UTeetChNS2y1rEaxqycQA4WLxh6RRns.4M6"));
  }

  /**
   * 登录
   *
   * @param loginBodyDto 登录信息
   * @return 登录结果
   */
  @Override
  @VerifyCaptcha(code = "0$code", uuid = "0$uuid")
  public R<Boolean> login(LoginBodyDTO loginBodyDto) {
    // 1. 校验密码 TODO 这里 mybatis-plus 3.4.3 使用jdk17会报错
    User user = getOne(Wrappers.<User>lambdaQuery()
        .eq(User::getUsername, loginBodyDto.getUsername())
    );
    ThrowUtils.throwIf(user == null, ErrorCode.PARAMS_ERROR, "用户不存在");
    ThrowUtils.throwIf(
        !BCrypt.checkpw(loginBodyDto.getPassword(), user.getPassword()),
        ErrorCode.PARAMS_ERROR,
        "密码错误"
    );
    // 2. 登录
    StpUtil.login(user.getId(), loginBodyDto.isRememberMe());
    return R.success(true);
  }

  /**
   * 登出
   *
   * @return
   */
  @Override
  public R<Boolean> logout() {
    if (!StpUtil.isLogin()) {
      return R.success(true);
    }
    StpUtil.logout();
    return R.success(true);
  }

  /**
   * 注册
   *
   * @param registerBodyDTO 注册信息
   * @return 注册结果
   */
  @Override
  @VerifyCaptcha(code = "0$code", uuid = "0$uuid")
  public R<Boolean> register(RegisterBodyDTO registerBodyDTO) {
    // 1. 注册
    User user = User.builder()
        .username(registerBodyDTO.getUsername())
        .nickname(registerBodyDTO.getNickname())
        .role(UserRoleEnum.USER_ROLE) // 默认为用户
        .password(BCrypt.hashpw(registerBodyDTO.getPassword(), BCrypt.gensalt()))
        .phone(registerBodyDTO.getPhone())
        .email(registerBodyDTO.getEmail())
        .build();

    save(user);

    // 2. 登录
    StpUtil.login(user.getId(), false);

    return R.success(true);
  }

  /**
   * 更新用户信息
   *
   * @param userUpdateDTO
   * @return
   */
  @Override
  public R<Boolean> updateInfo(UserUpdateDTO userUpdateDTO) {
    // 1. 获取登录用户
    Object loginId = StpUtil.getLoginId();
    User user = getById(Long.valueOf((String) loginId));
    ThrowUtils.throwIf(user == null, ErrorCode.PARAMS_ERROR, "用户不存在");
    // 2. 更新用户信息
    BeanUtils.copyProperties(userUpdateDTO, user);
    updateById(user);
    return R.success(true);
  }

  /**
   * 获取用户信息
   *
   * @return
   */
  @Override
  public R<UserVO> getInfo() {
    // 1. 获取登录用户
    Object loginId = StpUtil.getLoginId();
    User user = getById(Long.valueOf((String) loginId));
    ThrowUtils.throwIf(user == null, ErrorCode.PARAMS_ERROR, "用户不存在");
    // 2. 返回用户信息
    UserVO userVO = new UserVO();
    BeanUtils.copyProperties(user, userVO);
    return R.success(userVO);
  }

}
