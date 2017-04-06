package org.echocat.units4j.bytes;

import org.junit.Test;

import java.math.BigInteger;

import static org.echocat.units4j.bytes.ByteCount.parseByteCount;
import static org.echocat.units4j.bytes.ByteCount.valueOf;
import static org.echocat.units4j.bytes.ByteUnit.MEGA_BYTE;
import static org.echocat.units4j.bytes.ByteUnit.values;
import static org.echocat.unittest.utils.matchers.ThrowsException.throwsException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ByteCountUnitTest {

    @Test
    public void testToByteCount() throws Exception {
        for (final ByteUnit unit : values()) {
            assertThat(parseByteCount("7" + unit.display()), is(unit.toBytes(BigInteger.valueOf(7))));
            assertThat(parseByteCount("7" + unit.display().toLowerCase()), is(unit.toBytes(BigInteger.valueOf(7))));
            assertThat(new ByteCount("7" + unit.display()), is(valueOf(7, unit)));
            assertThat(new ByteCount("7" + unit.display().toLowerCase()), is(valueOf(7, unit)));
        }
        assertThat(parseByteCount("66mb 1024kb 2097152b"), is(MEGA_BYTE.toBytes(BigInteger.valueOf(69))));
        assertThat(new ByteCount("66mb 1024kb 2097152b"), is(valueOf(69, MEGA_BYTE)));
        assertThat(parseByteCount("0b"), is(MEGA_BYTE.toBytes(BigInteger.ZERO)));
        assertThat(new ByteCount("0b"), is(valueOf(0)));
        assertThat(parseByteCount("0"), is(BigInteger.ZERO));
        assertThat(new ByteCount("0"), is(valueOf(0)));
        assertThat(() -> parseByteCount("1mb 2s"), throwsException(IllegalArgumentException.class));
        assertThat(() -> parseByteCount("2v"), throwsException(IllegalArgumentException.class));
    }

}
