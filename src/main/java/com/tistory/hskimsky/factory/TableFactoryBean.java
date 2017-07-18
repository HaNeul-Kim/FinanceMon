package com.tistory.hskimsky.factory;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class TableFactoryBean implements FactoryBean<Table>, InitializingBean {

    private Table table;

    @Override
    public Table getObject() throws Exception {
        return this.table;
    }

    @Override
    public Class<Table> getObjectType() {
        return Table.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String tableName = "finance";

        Configuration conf = new Configuration();
        conf.set("hbase.table.name", tableName);
        conf.set("hbase.master", "master2.hdp.local");
        conf.set("hbase.zookeeper.quorum", "master1.hdp.local,master2.hdp.local,admin.hdp.local");
        conf.set("zookeeper.znode.parent", "/hbase-unsecure");
        HBaseConfiguration.addHbaseResources(conf);

        Connection hbCon = ConnectionFactory.createConnection(conf);
        this.table = hbCon.getTable(TableName.valueOf(tableName));
    }
}
