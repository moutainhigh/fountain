package net.neoremind.fountain.producer.parser.impl;

import java.nio.ByteBuffer;
import java.sql.Types;

import net.neoremind.fountain.event.ColumnDataParser;
import net.neoremind.fountain.event.data.ColumnData;
import net.neoremind.fountain.meta.ColumnMeta;
import net.neoremind.fountain.util.UnsignedNumberHelper;

/**
 * enum类型
 */
public class EnumColumnDataParser implements ColumnDataParser {

    @Override
    public void parse(ByteBuffer buf, ColumnData columnData, ColumnMeta meta) {
        int value =
                (int) UnsignedNumberHelper.convertLittleEndianUnsignedInt(buf,
                        meta.getMetaValue() >>> 8);
        columnData.setValue(value);
        columnData.setJavaType(Types.INTEGER);
        columnData.setSqlType(meta.getTypeEnum().getTypeValue());
    }

}
