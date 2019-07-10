package site.morn.boot.netty.adapter;

import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Objects;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * Hex消息编码器
 *
 * @author timely-rain
 * @since 2.1.0, 2019/6/27
 */
@Sharable
public class HexMessageEncoder extends MessageToMessageEncoder<HexMessage> {

  /**
   * 字符编码
   */
  private final Charset charset;

  public HexMessageEncoder() {
    this(Charset.defaultCharset());
  }

  public HexMessageEncoder(Charset charset) {
    Assert.notNull(charset, "charset");
    this.charset = charset;
  }

  @Override
  protected void encode(ChannelHandlerContext ctx, HexMessage msg, List<Object> out) {
    if (Objects.isNull(msg) || StringUtils.isEmpty(msg.getMessage())) {
      return;
    }
    out.add(ByteBufUtil.encodeString(ctx.alloc(), CharBuffer.wrap(msg.getMessage()), charset));
  }
}
