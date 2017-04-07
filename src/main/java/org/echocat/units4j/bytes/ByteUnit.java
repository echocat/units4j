package org.echocat.units4j.bytes;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

import static java.math.RoundingMode.HALF_EVEN;
import static java.util.Collections.unmodifiableList;
import static java.util.Optional.*;
import static org.echocat.units4j.bytes.ByteUnit.Kind.binary;
import static org.echocat.units4j.bytes.ByteUnit.Kind.metric;

public enum ByteUnit {
    B("byte", 0, binary, metric),

    KiB("kibibyte", 1, binary),
    MiB("mebibyte", 2, binary),
    GiB("gibibyte", 3, binary),
    TiB("tebibyte", 4, binary),
    PiB("pebibyte", 5, binary),
    EiB("exbibyte", 6, binary),

    kB("kilobyte", 1, metric),
    MB("megabyte", 2, metric),
    GB("gigabyte", 3, metric),
    TB("terabyte", 4, metric),
    PB("petabyte", 5, metric),
    EB("exabyte", 6, metric);

    static final RoundingMode ROUNDING_MODE = HALF_EVEN;

    static final List<ByteUnit> BINARY_VALUES = selectAllValueOf(binary);
    static final List<ByteUnit> METRIC_VALUES = selectAllValueOf(metric);

    @Nonnull
    public static List<ByteUnit> valuesOf(@Nullable Kind kind) {
        if (kind == metric) {
            return metricValues();
        }
        if (kind == binary) {
            return binaryValues();
        }
        throw new IllegalArgumentException("Could not handle: " + kind);
    }

    @Nonnull
    public static List<ByteUnit> binaryValues() {
        return BINARY_VALUES;
    }

    @Nonnull
    public static List<ByteUnit> metricValues() {
        return METRIC_VALUES;
    }

    @Nonnull
    public static Optional<ByteUnit> byteUnitForFullname(@Nonnull String name) {
        return byteUnitFor(name, ByteUnit::fullName);
    }

    @Nonnull
    public static Optional<ByteUnit> byteUnitForName(@Nonnull String name) {
        return byteUnitFor(name, ByteUnit::name);
    }

    @Nonnull
    static Optional<ByteUnit> byteUnitFor(@Nonnull String value, @Nonnull Function<ByteUnit, String> getCompareValue) {
        for (final ByteUnit candidate : values()) {
            final String compareValue = getCompareValue.apply(candidate);
            if (compareValue.equalsIgnoreCase(value)) {
                return of(candidate);
            }
        }
        if ("".endsWith(value)) {
            return of(B);
        }
        return empty();
    }

    @Nonnull
    private final String fullName;
    @Nonnull
    private final Kind kind;
    @Nonnegative
    private final int exponent;
    @Nonnegative
    private final long longBase;
    @Nonnegative
    private final double doubleBase;
    @Nonnull
    @Nonnegative
    private final BigInteger bigIntegerBase;
    @Nonnull
    @Nonnegative
    private final BigDecimal bigDecimalBase;
    @Nonnull
    private final Optional<Kind> secondaryKind;

    ByteUnit(@Nonnull String fullName, @Nonnegative int exponent, @Nonnull Kind kind) {
        this(fullName, exponent, kind, null);
    }

    ByteUnit(@Nonnull String fullName, @Nonnegative int exponent, @Nonnull Kind kind, @Nullable Kind secondaryKind) {
        this.fullName = fullName;
        this.kind = kind;
        this.exponent = exponent;
        this.secondaryKind = ofNullable(secondaryKind);

        bigIntegerBase = BigInteger.valueOf(kind == binary ? 1024 : 1000).pow(exponent);
        bigDecimalBase = BigDecimal.valueOf(kind == binary ? 1024 : 1000, 0).pow(exponent);
        longBase = bigIntegerBase.longValue();
        doubleBase = bigDecimalBase.doubleValue();
    }

    @Nonnull
    public ByteCount value(long value) {
        return value(BigInteger.valueOf(value));
    }

    @Nonnull
    public ByteCount value(double value) {
        return value(BigDecimal.valueOf(value));
    }

    @Nonnull
    public ByteCount value(@Nullable BigInteger value) {
        final BigInteger bytes = (value != null ? value : BigInteger.ZERO).multiply(bigIntegerBase());
        return new ByteCount(bytes);
    }

    @Nonnull
    public ByteCount value(@Nullable BigDecimal value) {
        final BigDecimal bytes = (value != null ? value : BigDecimal.ZERO).multiply(bigDecimalBase());
        return new ByteCount(bytes.toBigInteger());
    }

    public long from(long value, @Nonnull ByteUnit sourceUnit) {
        Objects.requireNonNull(sourceUnit);
        return from(BigInteger.valueOf(value), sourceUnit).longValue();
    }

    public double from(double value, @Nonnull ByteUnit sourceUnit) {
        Objects.requireNonNull(sourceUnit);
        return from(BigDecimal.valueOf(value), sourceUnit).doubleValue();
    }

    @Nonnull
    public BigInteger from(@Nullable BigInteger value, @Nonnull ByteUnit sourceUnit) {
        Objects.requireNonNull(sourceUnit);
        final BigInteger bytes = (value != null ? value : BigInteger.ZERO).multiply(sourceUnit.bigIntegerBase());
        return bytes.divide(bigIntegerBase());
    }

    @Nonnull
    public BigDecimal from(@Nullable BigDecimal value, @Nonnull ByteUnit sourceUnit) {
        Objects.requireNonNull(sourceUnit);
        final BigDecimal bytes = (value != null ? value : BigDecimal.ZERO).multiply(sourceUnit.bigDecimalBase());
        return divide(bytes, sourceUnit, this);
    }

    public long to(long value, @Nonnull ByteUnit targetUnit) {
        Objects.requireNonNull(targetUnit);
        return to(BigInteger.valueOf(value), targetUnit).longValue();
    }

    public double to(double value, @Nonnull ByteUnit targetUnit) {
        Objects.requireNonNull(targetUnit);
        return to(BigDecimal.valueOf(value), targetUnit).doubleValue();
    }

    @Nonnull
    public BigInteger to(@Nullable BigInteger value, @Nonnull ByteUnit targetUnit) {
        Objects.requireNonNull(targetUnit);
        final BigInteger bytes = (value != null ? value : BigInteger.ZERO).multiply(bigIntegerBase());
        return bytes.divide(targetUnit.bigIntegerBase());
    }

    @Nonnull
    public BigDecimal to(@Nullable BigDecimal value, @Nonnull ByteUnit targetUnit) {
        Objects.requireNonNull(targetUnit);
        final BigDecimal bytes = (value != null ? value : BigDecimal.ZERO).multiply(bigDecimalBase());
        return divide(bytes, this, targetUnit);
    }

    @Nonnull
    public String fullName() {
        return fullName;
    }

    @Nonnull
    public Kind kind() {
        return kind;
    }

    @Nonnegative
    public int exponent() {
        return exponent;
    }

    @Nonnegative
    public long longBase() {
        return longBase;
    }

    @Nonnegative
    public double doubleBase() {
        return doubleBase;
    }

    @Nonnegative
    @Nonnull
    public BigInteger bigIntegerBase() {
        return bigIntegerBase;
    }

    @Nonnegative
    @Nonnull
    public BigDecimal bigDecimalBase() {
        return bigDecimalBase;
    }


    public enum Kind {
        metric,
        binary
    }

    @Nonnull
    static List<ByteUnit> selectAllValueOf(@Nonnull Kind kind) {
        final List<ByteUnit> result = new ArrayList<>();
        for (final ByteUnit candidate : values()) {
            if (candidate.kind == kind || candidate.secondaryKind.orElse(null) == kind) {
                result.add(candidate);
            }
        }
        return unmodifiableList(result);
    }

    @Nonnull
    BigDecimal divide(@Nonnull BigDecimal input, @Nonnull ByteUnit source, @Nonnull ByteUnit target) {
        final int diffExponent = target.exponent() - source.exponent();
        if (diffExponent > 0) {
            return input.divide(bigDecimalBase(), (diffExponent + 1) * 3, ROUNDING_MODE);
        }
        return input.divide(bigDecimalBase(), ROUNDING_MODE);
    }

}
