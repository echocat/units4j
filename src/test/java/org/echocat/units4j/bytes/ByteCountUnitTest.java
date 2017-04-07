package org.echocat.units4j.bytes;

import org.junit.Test;

import java.math.BigInteger;

import static org.echocat.units4j.bytes.ByteCount.valueOf;
import static org.echocat.units4j.bytes.ByteUnit.*;
import static org.echocat.unittest.utils.matchers.ThrowsException.throwsException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ByteCountUnitTest {

    @Test
    public void differentUnits() throws Exception {
        for (final ByteUnit unit : values()) {
            assertThat(valueOf("7" + unit.name()), is(valueOf(7, unit)));
            assertThat(valueOf("7" + unit.name().toLowerCase()), is(valueOf(7, unit)));

            assertThat(valueOf("7" + unit.name()).bigIntegerValue(), is(unit.to(BigInteger.valueOf(7), B)));
            assertThat(valueOf("7" + unit.name().toLowerCase()).bigIntegerValue(), is(unit.to(BigInteger.valueOf(7), B)));

            assertThat(valueOf("7" + unit.fullName()), is(valueOf(7, unit)));
            assertThat(valueOf("7" + unit.fullName().toLowerCase()), is(valueOf(7, unit)));

            assertThat(valueOf("7" + unit.fullName()).bigIntegerValue(), is(unit.to(BigInteger.valueOf(7), B)));
            assertThat(valueOf("7" + unit.fullName().toLowerCase()).bigIntegerValue(), is(unit.to(BigInteger.valueOf(7), B)));
        }
    }

    @Test
    public void useCases() throws Exception {
        assertThat(valueOf("66mib 1024kib 2097152b").bigIntegerValue(), is(MiB.to(BigInteger.valueOf(69), B)));
        assertThat(valueOf("66mib 1024kib 2097152b"), is(valueOf(69, MiB)));
        assertThat(valueOf("0b").bigIntegerValue(), is(MiB.to(BigInteger.ZERO, B)));
        assertThat(valueOf("0b"), is(valueOf(0)));
        assertThat(valueOf("0").bigIntegerValue(), is(BigInteger.ZERO));
        assertThat(valueOf("0"), is(valueOf(0)));
        assertThat(() -> valueOf("1mb 2s"), throwsException(IllegalArgumentException.class));
        assertThat(() -> valueOf("2v"), throwsException(IllegalArgumentException.class));
    }

}
