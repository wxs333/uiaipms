package cn.edu.cdu.wxs.uiaipms.utils;

import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 验证码工具类
 *
 * @author WXS
 * @date 2019/12/24
 */
public class CodeUtils {

    /**
     * 产生验证码图片
     *
     * @param width        图片的宽
     * @param height       图片的高
     * @param imgType      图片类型
     * @param outputStream 输出流
     * @return 验证码字符串
     */
    public static String getCode(final int width, final int height, final String imgType, OutputStream outputStream) {
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        // 干扰线条数
        final int lineNum = 20;
        // 字母个数
        final int codeNum = 6;
        // 图片
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 画笔
        Graphics graphic = image.getGraphics();

        graphic.setColor(Color.getColor("F8F8F8"));
        graphic.fillRect(0, 0, width, height);

        Color[] colors = new Color[]{Color.BLUE, Color.GRAY, Color.GREEN, Color.RED, Color.BLACK, Color.ORANGE,
                Color.CYAN};
        // 在 "画板"上生成干扰线条
        for (int i = 0; i < lineNum; i++) {
            graphic.setColor(colors[random.nextInt(colors.length)]);
            final int x = random.nextInt(width);
            final int y = random.nextInt(height);
            final int w = random.nextInt(20);
            final int h = random.nextInt(20);
            final int signA = random.nextBoolean() ? 1 : -1;
            final int signB = random.nextBoolean() ? 1 : -1;
            graphic.drawLine(x, y, x + w * signA, y + h * signB);
        }

        // 在 "画板"上绘制字母
        graphic.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        for (int i = 0; i < codeNum; i++) {
            final int temp = random.nextInt(26) + 97;
            String s = String.valueOf((char) temp);
            buffer.append(s);
            graphic.setColor(colors[random.nextInt(colors.length)]);
            graphic.drawString(s, i * (width / 6), height - (height / 3));
        }
        graphic.dispose();
        try {
            ImageIO.write(image, imgType, outputStream);
        } catch (IOException e) {
            return null;
        }
        return buffer.toString();
    }

    /**
     * 验证码比较
     *
     * @param sessionCode session里的验证码
     * @param formCode    前端传过来的验证码
     * @return true 相同  false 不同
     */
    public static boolean compare(String sessionCode, String formCode) {
        return !StringUtils.isEmpty(formCode) && sessionCode.equals(formCode);
    }
}
