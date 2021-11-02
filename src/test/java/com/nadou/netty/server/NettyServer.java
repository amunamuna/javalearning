package com.nadou.netty.server;

import com.nadou.netty.Config;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyServer {
    private int mPort;

    public NettyServer(int port) {
        this.mPort = port;
    }

    public void run() {
        EventLoopGroup parentGroup = new NioEventLoopGroup();
        EventLoopGroup childGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap
                    .group(parentGroup, childGroup)
                    .channel(NioServerSocketChannel.class)
                    // 指定连接队列大小
                    .option(ChannelOption.SO_BACKLOG, 128)
                    //KeepAlive
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    //Handler
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline().addLast(new IdleStateHandler(5, 5, 10));
                            //这个配置需要在添加Handler前设置
                            channel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,
                                    Unpooled.copiedBuffer(Config.DATA_PACK_SEPARATOR.getBytes())));
                            channel.pipeline().addLast("encoder", new StringEncoder());
                            channel.pipeline().addLast("decoder", new StringDecoder());
                            channel.pipeline().addLast(new NettyServerHandler());
                        }
                    });
            ChannelFuture f = bootstrap.bind(mPort).sync();
            if (f.isSuccess()) {
                log.info("Server,启动Netty服务端成功，端口号:" + mPort);
            }
            // f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // workerGroup.shutdownGracefully();
            // bossGroup.shutdownGracefully();
        }
    }
}
