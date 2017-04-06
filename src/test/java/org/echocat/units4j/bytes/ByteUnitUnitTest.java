package org.echocat.units4j.bytes;

import org.echocat.unittest.utils.matchers.OptionalMatchers;
import org.hamcrest.Matcher;
import org.junit.Test;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.math.BigInteger;

import static java.lang.StrictMath.pow;
import static org.echocat.units4j.bytes.ByteUnit.*;
import static org.echocat.unittest.utils.matchers.OptionalMatchers.isAbsent;
import static org.echocat.unittest.utils.matchers.OptionalMatchers.whereContentMatches;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ByteUnitUnitTest {

    public static final long L_VALUE = 666L;
    public static final double D_VALUE = 666D;
    public static final BigInteger BI_VALUE = BigInteger.valueOf(666);
    public static final BigDecimal BD_VALUE = BigDecimal.valueOf(666, 0);

    @Test
    public void testToBytes() throws Exception {
        assertThat(BYTE.toBytes(L_VALUE), is(L_VALUE));
        assertThat(KILO_BYTE.toBytes(L_VALUE), isMultipliedBy(L_VALUE, 1));
        assertThat(MEGA_BYTE.toBytes(L_VALUE), isMultipliedBy(L_VALUE, 2));
        assertThat(GIGA_BYTE.toBytes(L_VALUE), isMultipliedBy(L_VALUE, 3));
        assertThat(TERA_BYTE.toBytes(L_VALUE), isMultipliedBy(L_VALUE, 4));
        assertThat(PETA_BYTE.toBytes(L_VALUE), isMultipliedBy(L_VALUE, 5));
        assertThat(EXA_BYTE.toBytes(L_VALUE), isMultipliedBy(L_VALUE, 6));

        assertThat(BYTE.toBytes(D_VALUE), is(D_VALUE));
        assertThat(KILO_BYTE.toBytes(D_VALUE), isMultipliedBy(D_VALUE, 1));
        assertThat(MEGA_BYTE.toBytes(D_VALUE), isMultipliedBy(D_VALUE, 2));
        assertThat(GIGA_BYTE.toBytes(D_VALUE), isMultipliedBy(D_VALUE, 3));
        assertThat(TERA_BYTE.toBytes(D_VALUE), isMultipliedBy(D_VALUE, 4));
        assertThat(PETA_BYTE.toBytes(D_VALUE), isMultipliedBy(D_VALUE, 5));
        assertThat(EXA_BYTE.toBytes(D_VALUE), isMultipliedBy(D_VALUE, 6));

        assertThat(BYTE.toBytes(BI_VALUE), is(BI_VALUE));
        assertThat(KILO_BYTE.toBytes(BI_VALUE), isMultipliedBy(BI_VALUE, 1));
        assertThat(MEGA_BYTE.toBytes(BI_VALUE), isMultipliedBy(BI_VALUE, 2));
        assertThat(GIGA_BYTE.toBytes(BI_VALUE), isMultipliedBy(BI_VALUE, 3));
        assertThat(TERA_BYTE.toBytes(BI_VALUE), isMultipliedBy(BI_VALUE, 4));
        assertThat(PETA_BYTE.toBytes(BI_VALUE), isMultipliedBy(BI_VALUE, 5));
        assertThat(EXA_BYTE.toBytes(BI_VALUE), isMultipliedBy(BI_VALUE, 6));

        assertThat(BYTE.toBytes(BD_VALUE), is(BD_VALUE));
        assertThat(KILO_BYTE.toBytes(BD_VALUE), isMultipliedBy(BD_VALUE, 1));
        assertThat(MEGA_BYTE.toBytes(BD_VALUE), isMultipliedBy(BD_VALUE, 2));
        assertThat(GIGA_BYTE.toBytes(BD_VALUE), isMultipliedBy(BD_VALUE, 3));
        assertThat(TERA_BYTE.toBytes(BD_VALUE), isMultipliedBy(BD_VALUE, 4));
        assertThat(PETA_BYTE.toBytes(BD_VALUE), isMultipliedBy(BD_VALUE, 5));
        //assertThat(EXA_BYTE.toBytes(BD_VALUE), isMultipliedBy(BD_VALUE, 6));
    }

    @Test
    public void testToKiloBytes() throws Exception {
        assertThat(BYTE.toKiloBytes(L_VALUE), isDividedBy(L_VALUE, 1));
        assertThat(KILO_BYTE.toKiloBytes(L_VALUE), is(L_VALUE));
        assertThat(MEGA_BYTE.toKiloBytes(L_VALUE), isMultipliedBy(L_VALUE, 1));
        assertThat(GIGA_BYTE.toKiloBytes(L_VALUE), isMultipliedBy(L_VALUE, 2));
        assertThat(TERA_BYTE.toKiloBytes(L_VALUE), isMultipliedBy(L_VALUE, 3));
        assertThat(PETA_BYTE.toKiloBytes(L_VALUE), isMultipliedBy(L_VALUE, 4));
        assertThat(EXA_BYTE.toKiloBytes(L_VALUE), isMultipliedBy(L_VALUE, 5));

        assertThat(BYTE.toKiloBytes(D_VALUE), isDividedBy(D_VALUE, 1));
        assertThat(KILO_BYTE.toKiloBytes(D_VALUE), is(D_VALUE));
        assertThat(MEGA_BYTE.toKiloBytes(D_VALUE), isMultipliedBy(D_VALUE, 1));
        assertThat(GIGA_BYTE.toKiloBytes(D_VALUE), isMultipliedBy(D_VALUE, 2));
        assertThat(TERA_BYTE.toKiloBytes(D_VALUE), isMultipliedBy(D_VALUE, 3));
        assertThat(PETA_BYTE.toKiloBytes(D_VALUE), isMultipliedBy(D_VALUE, 4));
        assertThat(EXA_BYTE.toKiloBytes(D_VALUE), isMultipliedBy(D_VALUE, 5));

        assertThat(BYTE.toKiloBytes(BI_VALUE), isDividedBy(BI_VALUE, 1));
        assertThat(KILO_BYTE.toKiloBytes(BI_VALUE), is(BI_VALUE));
        assertThat(MEGA_BYTE.toKiloBytes(BI_VALUE), isMultipliedBy(BI_VALUE, 1));
        assertThat(GIGA_BYTE.toKiloBytes(BI_VALUE), isMultipliedBy(BI_VALUE, 2));
        assertThat(TERA_BYTE.toKiloBytes(BI_VALUE), isMultipliedBy(BI_VALUE, 3));
        assertThat(PETA_BYTE.toKiloBytes(BI_VALUE), isMultipliedBy(BI_VALUE, 4));
        assertThat(EXA_BYTE.toKiloBytes(BI_VALUE), isMultipliedBy(BI_VALUE, 5));

        assertThat(BYTE.toKiloBytes(BD_VALUE), isDividedBy(BD_VALUE, 1));
        assertThat(KILO_BYTE.toKiloBytes(BD_VALUE), is(BD_VALUE));
        assertThat(MEGA_BYTE.toKiloBytes(BD_VALUE), isMultipliedBy(BD_VALUE, 1));
        assertThat(GIGA_BYTE.toKiloBytes(BD_VALUE), isMultipliedBy(BD_VALUE, 2));
        assertThat(TERA_BYTE.toKiloBytes(BD_VALUE), isMultipliedBy(BD_VALUE, 3));
        assertThat(PETA_BYTE.toKiloBytes(BD_VALUE), isMultipliedBy(BD_VALUE, 4));
        assertThat(EXA_BYTE.toKiloBytes(BD_VALUE), isMultipliedBy(BD_VALUE, 5));
    }

    @Test
    public void testToMegaBytes() throws Exception {
        assertThat(BYTE.toMegaBytes(L_VALUE), isDividedBy(L_VALUE, 2));
        assertThat(KILO_BYTE.toMegaBytes(L_VALUE), isDividedBy(L_VALUE, 1));
        assertThat(MEGA_BYTE.toMegaBytes(L_VALUE), is(L_VALUE));
        assertThat(GIGA_BYTE.toMegaBytes(L_VALUE), isMultipliedBy(L_VALUE, 1));
        assertThat(TERA_BYTE.toMegaBytes(L_VALUE), isMultipliedBy(L_VALUE, 2));
        assertThat(PETA_BYTE.toMegaBytes(L_VALUE), isMultipliedBy(L_VALUE, 3));
        assertThat(EXA_BYTE.toMegaBytes(L_VALUE), isMultipliedBy(L_VALUE, 4));

        assertThat(BYTE.toMegaBytes(D_VALUE), isDividedBy(D_VALUE, 2));
        assertThat(KILO_BYTE.toMegaBytes(D_VALUE), isDividedBy(D_VALUE, 1));
        assertThat(MEGA_BYTE.toMegaBytes(D_VALUE), is(D_VALUE));
        assertThat(GIGA_BYTE.toMegaBytes(D_VALUE), isMultipliedBy(D_VALUE, 1));
        assertThat(TERA_BYTE.toMegaBytes(D_VALUE), isMultipliedBy(D_VALUE, 2));
        assertThat(PETA_BYTE.toMegaBytes(D_VALUE), isMultipliedBy(D_VALUE, 3));
        assertThat(EXA_BYTE.toMegaBytes(D_VALUE), isMultipliedBy(D_VALUE, 4));

        assertThat(BYTE.toMegaBytes(BI_VALUE), isDividedBy(BI_VALUE, 2));
        assertThat(KILO_BYTE.toMegaBytes(BI_VALUE), isDividedBy(BI_VALUE, 1));
        assertThat(MEGA_BYTE.toMegaBytes(BI_VALUE), is(BI_VALUE));
        assertThat(GIGA_BYTE.toMegaBytes(BI_VALUE), isMultipliedBy(BI_VALUE, 1));
        assertThat(TERA_BYTE.toMegaBytes(BI_VALUE), isMultipliedBy(BI_VALUE, 2));
        assertThat(PETA_BYTE.toMegaBytes(BI_VALUE), isMultipliedBy(BI_VALUE, 3));
        assertThat(EXA_BYTE.toMegaBytes(BI_VALUE), isMultipliedBy(BI_VALUE, 4));

        assertThat(BYTE.toMegaBytes(BD_VALUE), isDividedBy(BD_VALUE, 2));
        assertThat(KILO_BYTE.toMegaBytes(BD_VALUE), isDividedBy(BD_VALUE, 1));
        assertThat(MEGA_BYTE.toMegaBytes(BD_VALUE), is(BD_VALUE));
        assertThat(GIGA_BYTE.toMegaBytes(BD_VALUE), isMultipliedBy(BD_VALUE, 1));
        assertThat(TERA_BYTE.toMegaBytes(BD_VALUE), isMultipliedBy(BD_VALUE, 2));
        assertThat(PETA_BYTE.toMegaBytes(BD_VALUE), isMultipliedBy(BD_VALUE, 3));
        assertThat(EXA_BYTE.toMegaBytes(BD_VALUE), isMultipliedBy(BD_VALUE, 4));
    }

    @Test
    public void testToGigaBytes() throws Exception {
        assertThat(BYTE.toGigaBytes(L_VALUE), isDividedBy(L_VALUE, 3));
        assertThat(KILO_BYTE.toGigaBytes(L_VALUE), isDividedBy(L_VALUE, 2));
        assertThat(MEGA_BYTE.toGigaBytes(L_VALUE), isDividedBy(L_VALUE, 1));
        assertThat(GIGA_BYTE.toGigaBytes(L_VALUE), is(L_VALUE));
        assertThat(TERA_BYTE.toGigaBytes(L_VALUE), isMultipliedBy(L_VALUE, 1));
        assertThat(PETA_BYTE.toGigaBytes(L_VALUE), isMultipliedBy(L_VALUE, 2));
        assertThat(EXA_BYTE.toGigaBytes(L_VALUE), isMultipliedBy(L_VALUE, 3));

        assertThat(BYTE.toGigaBytes(D_VALUE), isDividedBy(D_VALUE, 3));
        assertThat(KILO_BYTE.toGigaBytes(D_VALUE), isDividedBy(D_VALUE, 2));
        assertThat(MEGA_BYTE.toGigaBytes(D_VALUE), isDividedBy(D_VALUE, 1));
        assertThat(GIGA_BYTE.toGigaBytes(D_VALUE), is(D_VALUE));
        assertThat(TERA_BYTE.toGigaBytes(D_VALUE), isMultipliedBy(D_VALUE, 1));
        assertThat(PETA_BYTE.toGigaBytes(D_VALUE), isMultipliedBy(D_VALUE, 2));
        assertThat(EXA_BYTE.toGigaBytes(D_VALUE), isMultipliedBy(D_VALUE, 3));

        assertThat(BYTE.toGigaBytes(BI_VALUE), isDividedBy(BI_VALUE, 3));
        assertThat(KILO_BYTE.toGigaBytes(BI_VALUE), isDividedBy(BI_VALUE, 2));
        assertThat(MEGA_BYTE.toGigaBytes(BI_VALUE), isDividedBy(BI_VALUE, 1));
        assertThat(GIGA_BYTE.toGigaBytes(BI_VALUE), is(BI_VALUE));
        assertThat(TERA_BYTE.toGigaBytes(BI_VALUE), isMultipliedBy(BI_VALUE, 1));
        assertThat(PETA_BYTE.toGigaBytes(BI_VALUE), isMultipliedBy(BI_VALUE, 2));
        assertThat(EXA_BYTE.toGigaBytes(BI_VALUE), isMultipliedBy(BI_VALUE, 3));

        assertThat(BYTE.toGigaBytes(BD_VALUE), isDividedBy(BD_VALUE, 3));
        assertThat(KILO_BYTE.toGigaBytes(BD_VALUE), isDividedBy(BD_VALUE, 2));
        assertThat(MEGA_BYTE.toGigaBytes(BD_VALUE), isDividedBy(BD_VALUE, 1));
        assertThat(GIGA_BYTE.toGigaBytes(BD_VALUE), is(BD_VALUE));
        assertThat(TERA_BYTE.toGigaBytes(BD_VALUE), isMultipliedBy(BD_VALUE, 1));
        assertThat(PETA_BYTE.toGigaBytes(BD_VALUE), isMultipliedBy(BD_VALUE, 2));
        assertThat(EXA_BYTE.toGigaBytes(BD_VALUE), isMultipliedBy(BD_VALUE, 3));
    }

    @Test
    public void testToTeraBytes() throws Exception {
        assertThat(BYTE.toTeraBytes(L_VALUE), isDividedBy(L_VALUE, 4));
        assertThat(KILO_BYTE.toTeraBytes(L_VALUE), isDividedBy(L_VALUE, 3));
        assertThat(MEGA_BYTE.toTeraBytes(L_VALUE), isDividedBy(L_VALUE, 2));
        assertThat(GIGA_BYTE.toTeraBytes(L_VALUE), isDividedBy(L_VALUE, 1));
        assertThat(TERA_BYTE.toTeraBytes(L_VALUE), is(L_VALUE));
        assertThat(PETA_BYTE.toTeraBytes(L_VALUE), isMultipliedBy(L_VALUE, 1));
        assertThat(EXA_BYTE.toTeraBytes(L_VALUE), isMultipliedBy(L_VALUE, 2));

        assertThat(BYTE.toTeraBytes(D_VALUE), isDividedBy(D_VALUE, 4));
        assertThat(KILO_BYTE.toTeraBytes(D_VALUE), isDividedBy(D_VALUE, 3));
        assertThat(MEGA_BYTE.toTeraBytes(D_VALUE), isDividedBy(D_VALUE, 2));
        assertThat(GIGA_BYTE.toTeraBytes(D_VALUE), isDividedBy(D_VALUE, 1));
        assertThat(TERA_BYTE.toTeraBytes(D_VALUE), is(D_VALUE));
        assertThat(PETA_BYTE.toTeraBytes(D_VALUE), isMultipliedBy(D_VALUE, 1));
        assertThat(EXA_BYTE.toTeraBytes(D_VALUE), isMultipliedBy(D_VALUE, 2));

        assertThat(BYTE.toTeraBytes(BI_VALUE), isDividedBy(BI_VALUE, 4));
        assertThat(KILO_BYTE.toTeraBytes(BI_VALUE), isDividedBy(BI_VALUE, 3));
        assertThat(MEGA_BYTE.toTeraBytes(BI_VALUE), isDividedBy(BI_VALUE, 2));
        assertThat(GIGA_BYTE.toTeraBytes(BI_VALUE), isDividedBy(BI_VALUE, 1));
        assertThat(TERA_BYTE.toTeraBytes(BI_VALUE), is(BI_VALUE));
        assertThat(PETA_BYTE.toTeraBytes(BI_VALUE), isMultipliedBy(BI_VALUE, 1));
        assertThat(EXA_BYTE.toTeraBytes(BI_VALUE), isMultipliedBy(BI_VALUE, 2));

        assertThat(BYTE.toTeraBytes(BD_VALUE), isDividedBy(BD_VALUE, 4));
        assertThat(KILO_BYTE.toTeraBytes(BD_VALUE), isDividedBy(BD_VALUE, 3));
        assertThat(MEGA_BYTE.toTeraBytes(BD_VALUE), isDividedBy(BD_VALUE, 2));
        assertThat(GIGA_BYTE.toTeraBytes(BD_VALUE), isDividedBy(BD_VALUE, 1));
        assertThat(TERA_BYTE.toTeraBytes(BD_VALUE), is(BD_VALUE));
        assertThat(PETA_BYTE.toTeraBytes(BD_VALUE), isMultipliedBy(BD_VALUE, 1));
        assertThat(EXA_BYTE.toTeraBytes(BD_VALUE), isMultipliedBy(BD_VALUE, 2));
    }

    @Test
    public void testToPetaBytes() throws Exception {
        assertThat(BYTE.toPetaBytes(L_VALUE), isDividedBy(L_VALUE, 5));
        assertThat(KILO_BYTE.toPetaBytes(L_VALUE), isDividedBy(L_VALUE, 4));
        assertThat(MEGA_BYTE.toPetaBytes(L_VALUE), isDividedBy(L_VALUE, 3));
        assertThat(GIGA_BYTE.toPetaBytes(L_VALUE), isDividedBy(L_VALUE, 2));
        assertThat(TERA_BYTE.toPetaBytes(L_VALUE), isDividedBy(L_VALUE, 1));
        assertThat(PETA_BYTE.toPetaBytes(L_VALUE), is(L_VALUE));
        assertThat(EXA_BYTE.toPetaBytes(L_VALUE), isMultipliedBy(L_VALUE, 1));

        assertThat(BYTE.toPetaBytes(D_VALUE), isDividedBy(D_VALUE, 5));
        assertThat(KILO_BYTE.toPetaBytes(D_VALUE), isDividedBy(D_VALUE, 4));
        assertThat(MEGA_BYTE.toPetaBytes(D_VALUE), isDividedBy(D_VALUE, 3));
        assertThat(GIGA_BYTE.toPetaBytes(D_VALUE), isDividedBy(D_VALUE, 2));
        assertThat(TERA_BYTE.toPetaBytes(D_VALUE), isDividedBy(D_VALUE, 1));
        assertThat(PETA_BYTE.toPetaBytes(D_VALUE), is(D_VALUE));
        assertThat(EXA_BYTE.toPetaBytes(D_VALUE), isMultipliedBy(D_VALUE, 1));

        assertThat(BYTE.toPetaBytes(BI_VALUE), isDividedBy(BI_VALUE, 5));
        assertThat(KILO_BYTE.toPetaBytes(BI_VALUE), isDividedBy(BI_VALUE, 4));
        assertThat(MEGA_BYTE.toPetaBytes(BI_VALUE), isDividedBy(BI_VALUE, 3));
        assertThat(GIGA_BYTE.toPetaBytes(BI_VALUE), isDividedBy(BI_VALUE, 2));
        assertThat(TERA_BYTE.toPetaBytes(BI_VALUE), isDividedBy(BI_VALUE, 1));
        assertThat(PETA_BYTE.toPetaBytes(BI_VALUE), is(BI_VALUE));
        assertThat(EXA_BYTE.toPetaBytes(BI_VALUE), isMultipliedBy(BI_VALUE, 1));

        assertThat(BYTE.toPetaBytes(BD_VALUE), isDividedBy(BD_VALUE, 5));
        assertThat(KILO_BYTE.toPetaBytes(BD_VALUE), isDividedBy(BD_VALUE, 4));
        assertThat(MEGA_BYTE.toPetaBytes(BD_VALUE), isDividedBy(BD_VALUE, 3));
        assertThat(GIGA_BYTE.toPetaBytes(BD_VALUE), isDividedBy(BD_VALUE, 2));
        assertThat(TERA_BYTE.toPetaBytes(BD_VALUE), isDividedBy(BD_VALUE, 1));
        assertThat(PETA_BYTE.toPetaBytes(BD_VALUE), is(BD_VALUE));
        assertThat(EXA_BYTE.toPetaBytes(BD_VALUE), isMultipliedBy(BD_VALUE, 1));
    }

    @Test
    public void testToExaBytes() throws Exception {
        assertThat(BYTE.toExaBytes(L_VALUE), isDividedBy(L_VALUE, 6));
        assertThat(KILO_BYTE.toExaBytes(L_VALUE), isDividedBy(L_VALUE, 5));
        assertThat(MEGA_BYTE.toExaBytes(L_VALUE), isDividedBy(L_VALUE, 4));
        assertThat(GIGA_BYTE.toExaBytes(L_VALUE), isDividedBy(L_VALUE, 3));
        assertThat(TERA_BYTE.toExaBytes(L_VALUE), isDividedBy(L_VALUE, 2));
        assertThat(PETA_BYTE.toExaBytes(L_VALUE), isDividedBy(L_VALUE, 1));
        assertThat(EXA_BYTE.toExaBytes(L_VALUE), is(L_VALUE));

        assertThat(BYTE.toExaBytes(D_VALUE), isDividedBy(D_VALUE, 6));
        assertThat(KILO_BYTE.toExaBytes(D_VALUE), isDividedBy(D_VALUE, 5));
        assertThat(MEGA_BYTE.toExaBytes(D_VALUE), isDividedBy(D_VALUE, 4));
        assertThat(GIGA_BYTE.toExaBytes(D_VALUE), isDividedBy(D_VALUE, 3));
        assertThat(TERA_BYTE.toExaBytes(D_VALUE), isDividedBy(D_VALUE, 2));
        assertThat(PETA_BYTE.toExaBytes(D_VALUE), isDividedBy(D_VALUE, 1));
        assertThat(EXA_BYTE.toExaBytes(D_VALUE), is(D_VALUE));

        assertThat(BYTE.toExaBytes(BI_VALUE), isDividedBy(BI_VALUE, 6));
        assertThat(KILO_BYTE.toExaBytes(BI_VALUE), isDividedBy(BI_VALUE, 5));
        assertThat(MEGA_BYTE.toExaBytes(BI_VALUE), isDividedBy(BI_VALUE, 4));
        assertThat(GIGA_BYTE.toExaBytes(BI_VALUE), isDividedBy(BI_VALUE, 3));
        assertThat(TERA_BYTE.toExaBytes(BI_VALUE), isDividedBy(BI_VALUE, 2));
        assertThat(PETA_BYTE.toExaBytes(BI_VALUE), isDividedBy(BI_VALUE, 1));
        assertThat(EXA_BYTE.toExaBytes(BI_VALUE), is(BI_VALUE));

        assertThat(BYTE.toExaBytes(BD_VALUE), isDividedBy(BD_VALUE, 6));
        assertThat(KILO_BYTE.toExaBytes(BD_VALUE), isDividedBy(BD_VALUE, 5));
        assertThat(MEGA_BYTE.toExaBytes(BD_VALUE), isDividedBy(BD_VALUE, 4));
        assertThat(GIGA_BYTE.toExaBytes(BD_VALUE), isDividedBy(BD_VALUE, 3));
        assertThat(TERA_BYTE.toExaBytes(BD_VALUE), isDividedBy(BD_VALUE, 2));
        assertThat(PETA_BYTE.toExaBytes(BD_VALUE), isDividedBy(BD_VALUE, 1));
        assertThat(EXA_BYTE.toExaBytes(BD_VALUE), is(BD_VALUE));
    }

    @Test
    public void testConvert() throws Exception {
        assertThat(BYTE.convert(L_VALUE, BYTE), is(L_VALUE));
        assertThat(BYTE.convert(L_VALUE, KILO_BYTE), isMultipliedBy(L_VALUE, 1));
        assertThat(BYTE.convert(L_VALUE, MEGA_BYTE), isMultipliedBy(L_VALUE, 2));
        assertThat(BYTE.convert(L_VALUE, GIGA_BYTE), isMultipliedBy(L_VALUE, 3));
        assertThat(BYTE.convert(L_VALUE, TERA_BYTE), isMultipliedBy(L_VALUE, 4));
        assertThat(BYTE.convert(L_VALUE, PETA_BYTE), isMultipliedBy(L_VALUE, 5));
        assertThat(BYTE.convert(L_VALUE, EXA_BYTE), isMultipliedBy(L_VALUE, 6));

        assertThat(BYTE.convert(D_VALUE, BYTE), is(D_VALUE));
        assertThat(BYTE.convert(D_VALUE, KILO_BYTE), isMultipliedBy(D_VALUE, 1));
        assertThat(BYTE.convert(D_VALUE, MEGA_BYTE), isMultipliedBy(D_VALUE, 2));
        assertThat(BYTE.convert(D_VALUE, GIGA_BYTE), isMultipliedBy(D_VALUE, 3));
        assertThat(BYTE.convert(D_VALUE, TERA_BYTE), isMultipliedBy(D_VALUE, 4));
        assertThat(BYTE.convert(D_VALUE, PETA_BYTE), isMultipliedBy(D_VALUE, 5));
        assertThat(BYTE.convert(D_VALUE, EXA_BYTE), isMultipliedBy(D_VALUE, 6));

        assertThat(BYTE.convert(BI_VALUE, BYTE), is(BI_VALUE));
        assertThat(BYTE.convert(BI_VALUE, KILO_BYTE), isMultipliedBy(BI_VALUE, 1));
        assertThat(BYTE.convert(BI_VALUE, MEGA_BYTE), isMultipliedBy(BI_VALUE, 2));
        assertThat(BYTE.convert(BI_VALUE, GIGA_BYTE), isMultipliedBy(BI_VALUE, 3));
        assertThat(BYTE.convert(BI_VALUE, TERA_BYTE), isMultipliedBy(BI_VALUE, 4));
        assertThat(BYTE.convert(BI_VALUE, PETA_BYTE), isMultipliedBy(BI_VALUE, 5));
        assertThat(BYTE.convert(BI_VALUE, EXA_BYTE), isMultipliedBy(BI_VALUE, 6));

        assertThat(BYTE.convert(BD_VALUE, BYTE), is(BD_VALUE));
        assertThat(BYTE.convert(BD_VALUE, KILO_BYTE), isMultipliedBy(BD_VALUE, 1));
        assertThat(BYTE.convert(BD_VALUE, MEGA_BYTE), isMultipliedBy(BD_VALUE, 2));
        assertThat(BYTE.convert(BD_VALUE, GIGA_BYTE), isMultipliedBy(BD_VALUE, 3));
        assertThat(BYTE.convert(BD_VALUE, TERA_BYTE), isMultipliedBy(BD_VALUE, 4));
        assertThat(BYTE.convert(BD_VALUE, PETA_BYTE), isMultipliedBy(BD_VALUE, 5));
        assertThat(KILO_BYTE.convert(BD_VALUE, EXA_BYTE), isMultipliedBy(BD_VALUE, 5));
    }

    @Test
    public void testToString() throws Exception {
        assertThat(BYTE.toString(), is("B"));
        assertThat(KILO_BYTE.toString(), is("kB"));
        assertThat(MEGA_BYTE.toString(), is("MB"));
        assertThat(GIGA_BYTE.toString(), is("GB"));
        assertThat(TERA_BYTE.toString(), is("TB"));
        assertThat(PETA_BYTE.toString(), is("PB"));
        assertThat(EXA_BYTE.toString(), is("EB"));
    }

    @Test
    public void testDisplay() throws Exception {
        assertThat(BYTE.display(), is("B"));
        assertThat(KILO_BYTE.display(), is("kB"));
        assertThat(MEGA_BYTE.display(), is("MB"));
        assertThat(GIGA_BYTE.display(), is("GB"));
        assertThat(TERA_BYTE.display(), is("TB"));
        assertThat(PETA_BYTE.display(), is("PB"));
        assertThat(EXA_BYTE.display(), is("EB"));
    }

    @Test
    public void testShortDisplay() throws Exception {
        assertThat(BYTE.shortDisplay(), is("B"));
        assertThat(KILO_BYTE.shortDisplay(), is("k"));
        assertThat(MEGA_BYTE.shortDisplay(), is("M"));
        assertThat(GIGA_BYTE.shortDisplay(), is("G"));
        assertThat(TERA_BYTE.shortDisplay(), is("T"));
        assertThat(PETA_BYTE.shortDisplay(), is("P"));
        assertThat(EXA_BYTE.shortDisplay(), is("E"));
    }

    @Test
    public void testByteUnitForDisplay() throws Exception {
        assertThat(byteUnitForDisplay(""), whereContentMatches(is(BYTE)));
        assertThat(byteUnitForDisplay("B"), whereContentMatches(is(BYTE)));
        assertThat(byteUnitForDisplay("kB"), whereContentMatches(is(KILO_BYTE)));
        assertThat(byteUnitForDisplay("MB"), whereContentMatches(is(MEGA_BYTE)));
        assertThat(byteUnitForDisplay("GB"), whereContentMatches(is(GIGA_BYTE)));
        assertThat(byteUnitForDisplay("TB"), whereContentMatches(is(TERA_BYTE)));
        assertThat(byteUnitForDisplay("PB"), whereContentMatches(is(PETA_BYTE)));
        assertThat(byteUnitForDisplay("EB"), whereContentMatches(is(EXA_BYTE)));

        assertThat(byteUnitForDisplay("x"), isAbsent());
    }

    @Test
    public void testByteUnitForShortDisplay() throws Exception {
        assertThat(byteUnitForShortDisplay(""), whereContentMatches(is(BYTE)));
        assertThat(byteUnitForShortDisplay("B"), whereContentMatches(is(BYTE)));
        assertThat(byteUnitForShortDisplay("k"), whereContentMatches(is(KILO_BYTE)));
        assertThat(byteUnitForShortDisplay("M"), whereContentMatches(is(MEGA_BYTE)));
        assertThat(byteUnitForShortDisplay("G"), whereContentMatches(is(GIGA_BYTE)));
        assertThat(byteUnitForShortDisplay("T"), whereContentMatches(is(TERA_BYTE)));
        assertThat(byteUnitForShortDisplay("P"), whereContentMatches(is(PETA_BYTE)));
        assertThat(byteUnitForShortDisplay("E"), whereContentMatches(is(EXA_BYTE)));

        assertThat(byteUnitForShortDisplay("x"), isAbsent());
    }

    @Nonnull
    protected static Matcher<Long> isMultipliedBy(@Nonnegative long value, @Nonnegative int step) {
        return is(multipliedBy(value, step));
    }

    @Nonnull
    protected static Matcher<Double> isMultipliedBy(@Nonnegative double value, @Nonnegative int step) {
        return is(multipliedBy(value, step));
    }

    @Nonnull
    protected static Matcher<BigInteger> isMultipliedBy(@Nonnegative BigInteger value, @Nonnegative int step) {
        return is(multipliedBy(value, step));
    }

    @Nonnull
    protected static Matcher<BigDecimal> isMultipliedBy(@Nonnegative BigDecimal value, @Nonnegative int step) {
        return is(multipliedBy(value, step).setScale(0));
    }

    @Nonnegative
    protected static long multipliedBy(@Nonnegative long value, @Nonnegative int step) {
        return value * (long)pow(2, step * 10);
    }

    @Nonnegative
    protected static double multipliedBy(@Nonnegative double value, @Nonnegative int step) {
        return value * pow(2, step * 10);
    }

    @Nonnegative
    protected static BigInteger multipliedBy(@Nonnegative BigInteger value, @Nonnegative int step) {
        return value.multiply(BigInteger.valueOf((long) pow(2, step * 10)));
    }

    @Nonnegative
    protected static BigDecimal multipliedBy(@Nonnegative BigDecimal value, @Nonnegative int step) {
        return value.multiply(BigDecimal.valueOf(pow(2, step * 10)));
    }

    @Nonnull
    protected static Matcher<Long> isDividedBy(@Nonnegative long value, @Nonnegative int step) {
        return is(dividedBy(value, step));
    }

    @Nonnull
    protected static Matcher<Double> isDividedBy(@Nonnegative double value, @Nonnegative int step) {
        return is(dividedBy(value, step));
    }

    @Nonnull
    protected static Matcher<BigInteger> isDividedBy(@Nonnegative BigInteger value, @Nonnegative int step) {
        return is(dividedBy(value, step));
    }

    @Nonnull
    protected static Matcher<BigDecimal> isDividedBy(@Nonnegative BigDecimal value, @Nonnegative int step) {
        return is(dividedBy(value, step));
    }

    @Nonnegative
    protected static long dividedBy(@Nonnegative long value, @Nonnegative long step) {
        return value / (long)pow(2, step * 10);
    }

    @Nonnegative
    protected static double dividedBy(@Nonnegative double value, @Nonnegative double step) {
        return value / pow(2, step * 10);
    }

    @Nonnegative
    protected static BigInteger dividedBy(@Nonnegative BigInteger value, @Nonnegative int step) {
        return value.divide(BigInteger.valueOf((long) pow(2, step * 10)));
    }

    @Nonnegative
    protected static BigDecimal dividedBy(@Nonnegative BigDecimal value, @Nonnegative int step) {
        return value.divide(BigDecimal.valueOf(pow(2, step * 10)), ROUNDING_MODE);
    }
}
