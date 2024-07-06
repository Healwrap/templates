package cn.pepedd.template.controller.api;

import cn.pepedd.template.common.enums.ErrorCode;
import cn.pepedd.template.common.upload.FileUploadFactory;
import cn.pepedd.template.common.upload.FileUploadProxy;
import cn.pepedd.template.entity.result.R;
import cn.pepedd.template.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 公共接口
 *
 * @author pepedd864
 * @since 2024/5/31
 */
@RestController
@RequestMapping("/api/common")
public class CommonController {
  @Autowired(required = false)
  private FileUploadFactory fileUploadFactory;

  /**
   * 文件上传
   *
   * @param file 文件
   * @return 文件路径
   */
  @ApiOperation("文件上传")
  @PostMapping("/upload")
  public R<String> upload(@RequestParam("file") MultipartFile file) {
    if (Objects.isNull(fileUploadFactory)) {
      throw new BusinessException(ErrorCode.SYSTEM_ERROR,"文件上传未开启");
    }
    FileUploadProxy fileUploadProxy = fileUploadFactory.newInstance("aliyun");
    String[] upload = fileUploadProxy.upload(file);
    return R.success(upload[0]);
  }
}
