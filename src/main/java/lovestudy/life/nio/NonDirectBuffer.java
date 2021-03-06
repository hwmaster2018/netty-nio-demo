package lovestudy.life.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Create by huangwei on 2020/5/20 0020
 */
public class NonDirectBuffer {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream input = new FileInputStream("F:\\迅雷下载\\xmind.exe");
        FileOutputStream output = new FileOutputStream("F:\\fromH\\recordsystem\\测试视频\\xmind.exe");
        FileChannel inChannel = input.getChannel();
        FileChannel outChannel = output.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (-1 != inChannel.read(byteBuffer)){
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        long end = System.currentTimeMillis();
        inChannel.close();;
        outChannel.close();

        System.out.println(end-start);
    }
}
