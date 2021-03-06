package io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-07-26 17:30
 **/
public class FileChannelTest {
    public static void main(String[] args) throws IOException {

        //1.创建一个RandomAccessFile（随机访问文件）对象，
        RandomAccessFile raf=new RandomAccessFile("D:\\testFileChannel.txt", "rw");
        //通过RandomAccessFile对象的getChannel()方法。FileChannel是抽象类。
        FileChannel inChannel=raf.getChannel();
        //2.创建一个读数据缓冲区对象
        ByteBuffer buf=ByteBuffer.allocate(10);
        //3.从通道中读取数据
        int bytesRead = inChannel.read(buf);
        //创建一个写数据缓冲区对象
        inChannel.write(buf);
        while (bytesRead != -1) {

            System.out.println("Read --> " + bytesRead);
            //Buffer有两种模式，写模式和读模式。在写模式下调用flip()之后，Buffer从写模式变成读模式。
            buf.flip();
            //如果还有未读内容
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }
            //清空缓存区
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        //关闭RandomAccessFile（随机访问文件）对象
        raf.close();
    }
}
