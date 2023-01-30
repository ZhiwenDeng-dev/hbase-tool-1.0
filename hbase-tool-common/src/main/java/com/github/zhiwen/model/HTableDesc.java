package com.github.zhiwen.model;

import com.github.zhiwen.constan.HMHBaseConstant;
import com.github.zhiwen.util.StrUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhiwen.deng@shopee.com
 * @date: 2023/01/30/ 6:41 PM
 * @Description: TODO
 */
public class HTableDesc {
    private final String tableName;
    private final Long maxFileSize;
    private final Boolean readOnly;
    private final Long memStoreFlushSize;
    private final Boolean compactionEnabled;
    private final Map<String, String> tableProps;
    private final List<ColumnFamilyDesc> columnFamilyDescList;
    private String state;
    private long lastMajorCompaction;


    public HTableDesc(Builder builder) {
        this.tableName = builder.tableName;
        this.maxFileSize = builder.maxFileSize;
        this.readOnly = builder.readOnly;
        this.memStoreFlushSize = builder.memStoreFlushSize;
        this.compactionEnabled = builder.compactionEnabled;
        this.tableProps = builder.tableProps;
        this.columnFamilyDescList = builder.columnFamilyDescList;
    }

    public static class Builder {
        private String tableName;
        private Long maxFileSize;
        private Boolean readOnly;
        private Long memStoreFlushSize;
        private Boolean compactionEnabled;
        private Map<String, String> tableProps;
        private List<ColumnFamilyDesc> columnFamilyDescList;

        public Builder tableName(String tableName) {
            this.tableName = tableName;
            return this;
        }

        public Builder defaultTableDesc(String tableName) {
            this.tableName = tableName;
            this.maxFileSize = null;
            this.readOnly = null;
            this.memStoreFlushSize = null;
            this.compactionEnabled = null;
            return this;
        }

        public Builder defaultTableDescWithNs(String namespaceName, String tableName) {
            this.tableName = namespaceName.concat(HMHBaseConstant.TABLE_NAME_SPLIT_CHAR).concat(tableName);
            this.maxFileSize = null;
            this.readOnly = null;
            this.memStoreFlushSize = null;
            this.compactionEnabled = null;
            return this;
        }

        public Builder maxFileSize(Long maxFileSize) {
            this.maxFileSize = maxFileSize;
            return this;
        }

        public Builder readOnly(Boolean readOnly) {
            this.readOnly = readOnly;
            return this;
        }

        public Builder memStoreFlushSize(Long memStoreFlushSize) {
            this.memStoreFlushSize = memStoreFlushSize;
            return this;
        }

        public Builder compactionEnabled(Boolean compactionEnabled) {
            this.compactionEnabled = compactionEnabled;
            return this;
        }

        public Builder tableProps(Map<String, String> tableProps) {
            this.tableProps = tableProps;
            return this;
        }

        public Builder addTableProp(String key, String value) {
            if (this.tableProps == null) {
                this.tableProps = new HashMap<>();
            }
            if (StrUtil.isBlank(key)) {
                return this;
            }
            if (value == null) {
                value = "";
            }
            this.tableProps.put(key, value);
            return this;
        }

        public Builder columnFamilyDescList(List<ColumnFamilyDesc> columnFamilyDescList) {
            this.columnFamilyDescList = columnFamilyDescList;
            return this;
        }

        public Builder addColumnFamilyDesc(ColumnFamilyDesc columnFamilyDesc) {
            if (this.columnFamilyDescList == null) {
                this.columnFamilyDescList = new ArrayList<>(2);
            }
            this.columnFamilyDescList.add(columnFamilyDesc);
            return this;
        }

        public HTableDesc build() {
            return new HTableDesc(this);
        }
    }
}
