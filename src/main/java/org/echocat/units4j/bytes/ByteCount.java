package org.echocat.units4j.bytes;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Long.parseLong;
import static java.util.Objects.hash;
import static java.util.Objects.requireNonNull;
import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.compile;
import static org.echocat.units4j.bytes.ByteCountFormat.byteCountFormat;
import static org.echocat.units4j.bytes.ByteUnit.BYTE;
import static org.echocat.units4j.bytes.ByteUnit.ROUNDING_MODE;

@Immutable
public class ByteCount extends Number implements Comparable<ByteCount> {

    private static final long serialVersionUID = 1L;

    public static final ByteCount ZERO = new ByteCount(BigInteger.ZERO);

    private static final String ZERO_STRING = "0";
    private static final ByteUnit[] BYTE_UNITS = ByteUnit.values();
    private static final Pattern SPLIT_PATTERN = createSplitPattern();

    private static final ByteCountFormat DEFAULT_FORMAT = byteCountFormat()
        .build();

    @Nullable
    public static ByteCount valueOf(@Nullable String byteCount) {
        return byteCount != null ? new ByteCount(byteCount) : null;
    }

    @Nonnull
    public static ByteCount valueOf(@Nonnegative BigInteger byteCount) {
        return new ByteCount(byteCount);
    }

    @Nonnull
    public static ByteCount valueOf(@Nonnegative BigInteger byteCount, @Nonnull ByteUnit unit) {
        return valueOf(unit.toBytes(byteCount));
    }

    @Nonnull
    public static ByteCount valueOf(@Nonnegative BigDecimal byteCount) {
        return valueOf(byteCount.toBigInteger());
    }

    @Nonnull
    public static ByteCount valueOf(@Nonnegative BigDecimal byteCount, @Nonnull ByteUnit unit) {
        return valueOf(byteCount.toBigInteger(), unit);
    }

    @Nonnull
    public static ByteCount valueOf(@Nonnegative long byteCount) {
        return valueOf(BigInteger.valueOf(byteCount));
    }

    @Nonnull
    public static ByteCount valueOf(@Nonnegative long byteCount, @Nonnull ByteUnit unit) {
        return valueOf(BigInteger.valueOf(byteCount), unit);
    }

    private final BigInteger byteCount;

    public ByteCount(@Nonnegative BigInteger byteCount) {
        this.byteCount = byteCount;
    }

    public ByteCount(@Nonnull String formattedByteCount) throws IllegalArgumentException {
        byteCount = parseByteCount(formattedByteCount);
    }

    @Nonnull
    public BigInteger bigIntegerValue() {
        return byteCount;
    }

    @Nonnull
    public BigDecimal bigDecimalValue() {
        return new BigDecimal(bigIntegerValue());
    }

    /**
     * @throws IllegalArgumentException if this byteCount exceeds {@link Integer#MAX_VALUE}.
     */
    @Nonnull
    public byte[] allocateBytes() throws IllegalArgumentException {
        return new byte[toAllocatableByteCount()];
    }

    /**
     * @throws IllegalArgumentException if this byteCount exceeds {@link Integer#MAX_VALUE}.
     */
    @Nonnull
    public ByteBuffer allocateBuffer() throws IllegalArgumentException {
        return ByteBuffer.allocate(toAllocatableByteCount());
    }

    /**
     * @throws IllegalArgumentException if this byteCount exceeds {@link Integer#MAX_VALUE}.
     */
    @Nonnegative
    public int toAllocatableByteCount() throws IllegalArgumentException {
        if (byteCount.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new IllegalArgumentException("This byteCount exceeds " + valueOf(Integer.MAX_VALUE) + " and could not be allocated.");
        }
        return byteCount.intValue();
    }

    @Nonnull
    public BigDecimal in(@Nonnull ByteUnit byteUnit) {
        return byteUnit.convert(new BigDecimal(byteCount), BYTE);
    }

    @Nonnull
    public ByteUnit bestFittingUnit() {
        ByteUnit result = BYTE;
        for (int i = BYTE_UNITS.length - 1; i >= 0; i--) {
            final ByteUnit unit = BYTE_UNITS[i];
            if (unit.convert(byteCount, BYTE).compareTo(BigInteger.ZERO) > 0) {
                result = unit;
                break;
            }
        }
        return result;
    }

    @Nonnull
    protected static BigInteger requirePositive(@Nullable BigInteger value) {
        requireNonNull(value);
        if (value.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Provided value is negative: " + value);
        }
        return value;
    }

    @Nonnull
    public ByteCount add(@Nullable BigInteger value) {
        return value != null ? valueOf(bigIntegerValue().add(value)) : this;
    }

    @Nonnull
    public ByteCount add(@Nullable BigDecimal value) {
        return value != null ? valueOf(bigDecimalValue().add(value)) : this;
    }

    @Nonnull
    public ByteCount add(long value) {
        return add(BigInteger.valueOf(value));
    }

    @Nonnull
    public ByteCount add(double value) {
        return add(BigDecimal.valueOf(value));
    }

    @Nonnull
    public ByteCount add(@Nullable ByteCount value) {
        return value != null ? add(value.bigIntegerValue()) : this;
    }

    @Nonnull
    public ByteCount add(@Nullable BigInteger value, @Nonnull ByteUnit unit) {
        return value != null ? add(unit.toBytes(value)) : this;
    }

    @Nonnull
    public ByteCount add(@Nullable String value) {
        return value != null ? add(valueOf(value)) : this;
    }

    @Nonnull
    public ByteCount subtract(@Nullable BigInteger value) {
        return value != null ? valueOf(bigIntegerValue().subtract(value)) : this;
    }

    @Nonnull
    public ByteCount subtract(@Nullable BigDecimal value) {
        return value != null ? valueOf(bigDecimalValue().subtract(value)) : this;
    }

    @Nonnull
    public ByteCount subtract(long value) {
        return subtract(BigInteger.valueOf(value));
    }

    @Nonnull
    public ByteCount subtract(double value) {
        return subtract(BigDecimal.valueOf(value));
    }

    @Nonnull
    public ByteCount subtract(@Nullable ByteCount value) {
        return value != null ? subtract(value.bigIntegerValue()) : this;
    }

    @Nonnull
    public ByteCount subtract(@Nullable BigInteger value, @Nonnull ByteUnit unit) {
        return value != null ? subtract(unit.toBytes(value)) : this;
    }

    @Nonnull
    public ByteCount subtract(@Nullable String value) {
        return value != null ? subtract(valueOf(value)) : this;
    }

    @Nonnull
    public ByteCount multiply(@Nonnull BigInteger what) {
        return valueOf(bigIntegerValue().multiply(what));
    }

    @Nonnull
    public ByteCount multiply(@Nonnull BigDecimal what) {
        return valueOf(bigDecimalValue().multiply(what));
    }

    @Nonnull
    public ByteCount multiply(long what) {
        return valueOf(bigIntegerValue().multiply(BigInteger.valueOf(what)));
    }

    @Nonnull
    public ByteCount multiply(double what) {
        return valueOf(bigDecimalValue().multiply(BigDecimal.valueOf(what)));
    }


    @Nonnull
    public ByteCount divide(@Nonnull BigInteger what) {
        return valueOf(bigIntegerValue().divide(what));
    }

    @Nonnull
    public ByteCount divide(@Nonnull BigDecimal what) {
        return valueOf(bigDecimalValue().divide(what, ROUNDING_MODE));
    }

    @Nonnull
    public ByteCount divide(long what) {
        return valueOf(bigIntegerValue().divide(BigInteger.valueOf(what)));
    }

    @Nonnull
    public ByteCount divide(double what) {
        return valueOf(bigDecimalValue().divide(BigDecimal.valueOf(what), ROUNDING_MODE));
    }

    @Nonnegative
    public double getProcessInRelationTo(@Nonnull ByteCount current) {
        return current.bigDecimalValue().divide(bigDecimalValue(), ROUNDING_MODE).doubleValue();
    }

    @Override
    public int compareTo(@Nonnull ByteCount other) {
        return bigIntegerValue().compareTo(other.bigIntegerValue());
    }

    @Override
    public int hashCode() {
        return hash(bigIntegerValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ByteCount)) {
            return false;
        }
        final ByteCount other = (ByteCount) o;
        return bigIntegerValue().equals(other.bigIntegerValue());
    }

    @Override
    public String toString() {
        return DEFAULT_FORMAT.format(this);
    }

    @Nonnull
    private static Pattern createSplitPattern() {
        final StringBuilder sb = new StringBuilder();
        sb.append("\\s*(?:");
        boolean first = true;
        for (final ByteUnit byteUnit : BYTE_UNITS) {
            if (first) {
                first = false;
            } else {
                sb.append("|");
            }
            sb.append("(\\d+)\\s*(?:").append(byteUnit.display()).append('|').append(byteUnit.shortDisplay()).append(')');
        }
        sb.append(")\\s*");
        return compile(sb.toString(), CASE_INSENSITIVE);
    }

    @Override
    public int intValue() {
        return byteCount.intValue();
    }

    @Override
    public long longValue() {
        return byteCount.longValue();
    }

    @Override
    public float floatValue() {
        return byteCount.floatValue();
    }

    @Override
    public double doubleValue() {
        return byteCount.doubleValue();
    }

    @Nonnegative
    protected static BigInteger parseByteCount(@Nonnull String plain) throws IllegalArgumentException {
        requireNonNull(plain);
        BigInteger result = BigInteger.ZERO;
        if (!plain.trim().equals(ZERO_STRING)) {
            final Matcher matcher = SPLIT_PATTERN.matcher(plain);
            int lastEnd = 0;
            while (matcher.find()) {
                if (matcher.start() != lastEnd) {
                    throw new IllegalArgumentException("Could not parse: " + plain);
                }
                lastEnd = matcher.end();
                result = result.add(parsePartValueOf(matcher));
            }
            if (lastEnd != plain.length()) {
                throw new IllegalArgumentException("Could not parse: " + plain);
            }
        }

        return result;
    }

    @Nonnegative
    protected static BigInteger parsePartValueOf(@Nonnull Matcher matcher) {
        requireNonNull(matcher);
        BigInteger partValue = null;
        for (int i = 0; i < BYTE_UNITS.length; i++) {
            final String group = matcher.group(i + 1);
            if (group != null && !group.isEmpty()) {
                partValue = BYTE_UNITS[i].toBytes(BigInteger.valueOf(parseLong(group)));
            }
        }
        if (partValue == null || partValue.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Could not parse part: " + matcher.group());
        }
        return partValue;
    }

}
