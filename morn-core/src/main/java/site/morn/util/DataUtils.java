package site.morn.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.BooleanUtils;
import site.morn.data.Displayable;
import site.morn.data.Lockable;

/**
 * 数据工具
 *
 * @author timely-rain
 * @since 1.2.0, 2019/8/21
 */
@UtilityClass
public class DataUtils {


  /**
   * 判断是否为显示状态
   */
  public static boolean isDisplay(Displayable displayable) {
    return !BooleanUtils.isFalse(displayable.getDisplay());
  }

  /**
   * 判断是否为锁定状态
   */
  public static boolean isLocked(Lockable lockable) {
    return BooleanUtils.isTrue(lockable.getLocked());
  }
}
