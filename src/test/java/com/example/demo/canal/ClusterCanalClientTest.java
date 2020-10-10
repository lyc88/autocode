package com.example.demo.canal;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 集群模式的测试例子
 * 
 * @author jianghang 2013-4-15 下午04:19:20
 * @version 1.0.4
 */
public class ClusterCanalClientTest extends AbstractCanalClientTest {

    public ClusterCanalClientTest(String destination){
        super(destination);
    }

    public static void main(String args[]) {
        String str = "\"具体规则如下：具体规则如下：具体规则如下：具体规则如下具体规则如下2020年10月8日起-10月31日 每天满10单或以上免服务费，10单以下按7.5%收取服务费。11月整月份 每天满20单或以上免服务费，20单以下按7.5%收取服务费。欢迎广大商家积极参与。三生三世少时诵诗书所所所所所所所所所所所所所所所所所所所所\10单以下按7.5%收取服务费。11月整月份 每天满20单或以上免服务费，20单以下按7.5%收取服务费。欢迎广大商家积极参与。三生三世少时诵诗书所所所所所所所所所所所所所所所所所所所所\"";
        System.out.println(str.length());
      /*  DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss");
        String startTime = "12:00";
        System.out.println(startTime.length());
        if(startTime.length() == 5){
            df = DateTimeFormatter.ofPattern("HH:mm");
        }
        LocalTime startTimeLocal = LocalTime.parse(startTime, df);

        System.out.println(startTimeLocal);*/
        String destination = "example";

        // 基于固定canal server的地址，建立链接，其中一台server发生crash，可以支持failover
      /*   CanalConnector connector = CanalConnectors.newClusterConnector(
         Arrays.asList(new InetSocketAddress(
         AddressUtils.getHostIp(),
         11111)),
         "stability_test", "", "");*/

        // 基于zookeeper动态获取canal server的地址，建立链接，其中一台server发生crash，可以支持failover
       /* CanalConnector connector = CanalConnectors.newClusterConnector("127.0.0.1:2181", destination, "canal", "canal");

        final ClusterCanalClientTest clientTest = new ClusterCanalClientTest(destination);
        clientTest.setConnector(connector);
        clientTest.start();

        Runtime.getRuntime().addShutdownHook(new Thread() {

            public void run() {
                try {
                    logger.info("## stop the canal client");
                    clientTest.stop();
                } catch (Throwable e) {
                    logger.warn("##something goes wrong when stopping canal:", e);
                } finally {
                    logger.info("## canal client is down.");
                }
            }

        });*/
    }
}
