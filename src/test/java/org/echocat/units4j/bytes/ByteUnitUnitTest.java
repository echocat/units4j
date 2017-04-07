package org.echocat.units4j.bytes;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.echocat.units4j.bytes.ByteUnit.B;
import static org.echocat.units4j.bytes.ByteUnit.KiB;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ByteUnitUnitTest {

    @Test
    public void useCases() throws Exception {
        assertThat(B.value(1).to(KiB), is(BigInteger.valueOf(0)));
        assertThat(B.value(1).toDecimal(KiB), is(BigDecimal.valueOf(0.000977d)));
    }

}
