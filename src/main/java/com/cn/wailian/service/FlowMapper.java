package com.cn.wailian.service;

import java.io.IOException;

import com.cn.wailian.entity.FlowBean;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.commons.lang.StringUtils;

/**
 * @author hewl-a
 * @title: FlowMapper
 * @projectName my-bigdata-mapreduce
 * @description: Mapper程序
 * @date 2021/7/1419:36
 */
public class FlowMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String item = value.toString();
//        String[] items = item.split("\t");
        String[] items = StringUtils.split(item, "\t");
        if (items.length > 2) {
            context.write(new Text(items[1]), new FlowBean(Long.parseLong(items[7]), Long.parseLong(items[8])));
        }
    }
}
