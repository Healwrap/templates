package cn.pepedd.template.common.upload;

import cn.pepedd.template.common.upload.aliyun.AliOssUpload;
import cn.pepedd.template.common.upload.tencent.TencentOssUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * 文件上传工厂类，获取各种文件上传实现类
 *
 * @author pepedd864
 * @since 2024/5/31
 */
@Component
@ConditionalOnProperty(name = "oss.enabled", havingValue = "true")
public class FileUploadFactory {
  @Autowired(required = false)
  private AliOssUpload aliOssUpload;
  @Autowired(required = false)
  private TencentOssUpload tencentOssUpload;

  public FileUploadProxy newInstance(String type) {
    switch (type) {
      case "tencent":
        return new FileUploadProxy(tencentOssUpload);
      case "aliyun":
      default:
        return new FileUploadProxy(aliOssUpload);
    }
  }
}
