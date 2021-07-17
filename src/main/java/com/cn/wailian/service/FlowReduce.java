package com.cn.wailian.service;

import java.io.IOException;
import com.cn.wailian.entity.FlowBean;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;



/**
 * @author hewl-a
 * @title: FlowReduce
 * @projectName my-bigdata-mapreduce
 * @description: Reduce程序
 * @date 2021/7/1419:58
 */
public class FlowReduce extends Reducer<Text, FlowBean, Text, FlowBean> {

    @Override
    public void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
        long upFlow = 0L;
        long downFlow = 0L;
        System.out.println("hello reduce");
        for (FlowBean flowBean : values) {
            System.out.println( flowBean.getUpFlow()+"==============");
            System.out.println( flowBean.getDownFlow()+"==============");
            upFlow += flowBean.getUpFlow();
            downFlow += flowBean.getDownFlow();
        }
        context.write(key, new FlowBean(upFlow, downFlow));
    }
}
