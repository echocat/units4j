package org.echocat.units4j.bytes;

import org.junit.Test;

import static org.echocat.units4j.bytes.ByteCount.valueOf;
import static org.echocat.units4j.bytes.ByteCountFormat.byteCountFormat;
import static org.echocat.units4j.bytes.ByteUnit.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ByteCountFormatUnitTest {

    @Test
    public void format() throws Exception {
        final ByteCountFormat format = byteCountFormat().build();

        for (final ByteUnit unit : values()) {
            assertThat(format.format(valueOf(7, unit)), is("7" + unit.display()));
        }
        assertThat(format.format(valueOf(EXA_BYTE.toBytes(5) + MEGA_BYTE.toBytes(100))), is("5EB 100MB"));
        assertThat(format.format(valueOf(PETA_BYTE.toBytes(666) + GIGA_BYTE.toBytes(666) + TERA_BYTE.toBytes(666) + 1)), is("666PB 666TB 666GB 1B"));
        assertThat(format.format(valueOf(1)), is("1B"));
        assertThat(format.format(valueOf(0)), is("0"));
    }

}