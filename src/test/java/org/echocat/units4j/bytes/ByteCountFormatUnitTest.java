package org.echocat.units4j.bytes;

import org.junit.Test;

import static org.echocat.units4j.bytes.ByteCount.valueOf;
import static org.echocat.units4j.bytes.ByteCountFormat.byteCountFormat;
import static org.echocat.units4j.bytes.ByteUnit.*;
import static org.echocat.units4j.bytes.ByteUnit.Kind.binary;
import static org.echocat.units4j.bytes.ByteUnit.Kind.metric;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ByteCountFormatUnitTest {

    @Test
    public void allUnitsFormat() throws Exception {
        for (final ByteUnit unit : values()) {
            final ByteCountFormat format = byteCountFormat()
                .ofByteUnitKind(unit.kind())
                .build();
            assertThat(format.format(valueOf(7, unit)), is("7" + unit.name()));
        }
    }

    @Test
    public void binaryUseCases() throws Exception {
        final ByteCountFormat format = byteCountFormat()
            .ofByteUnitKind(binary)
            .build();

        assertThat(format.format(valueOf(EiB.to(5, B) + MiB.to(100, B))), is("5EiB 100MiB"));
        assertThat(format.format(valueOf(PiB.to(666, B) + GiB.to(666, B) + TiB.to(666, B) + 1)), is("666PiB 666TiB 666GiB 1B"));
        assertThat(format.format(valueOf(1)), is("1B"));
        assertThat(format.format(valueOf(0)), is("0"));
    }

    @Test
    public void binaryUseCasesWithPrecision() throws Exception {
        final ByteCountFormat format = byteCountFormat()
            .withMaximumFractionDigits(2)
            .ofByteUnitKind(binary)
            .build();

        assertThat(format.format(valueOf(EiB.to(5, B) + MiB.to(100, B))), is("5EiB"));
        assertThat(format.format(valueOf(PiB.to(333, B) + GiB.to(333, B) + TiB.to(333, B) + 1)), is("333.33PiB"));
        assertThat(format.format(valueOf(PiB.to(666, B) + GiB.to(666, B) + TiB.to(666, B) + 1)), is("666.65PiB"));
        assertThat(format.format(valueOf(1)), is("1B"));
        assertThat(format.format(valueOf(0)), is("0"));
    }

    @Test
    public void metricUseCases() throws Exception {
        final ByteCountFormat format = byteCountFormat()
            .ofByteUnitKind(metric)
            .build();

        assertThat(format.format(valueOf(EB.to(5, B) + MB.to(100, B))), is("5EB 100MB"));
        assertThat(format.format(valueOf(PB.to(666, B) + GB.to(666, B) + TB.to(666, B) + 1)), is("666PB 666TB 666GB 1B"));
        assertThat(format.format(valueOf(1)), is("1B"));
        assertThat(format.format(valueOf(0)), is("0"));
    }

}