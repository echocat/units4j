package org.echocat.units4j.bytes;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static org.echocat.units4j.bytes.ByteUnit.BYTE;

@Immutable
public class ByteCountFormat {

    @Nonnull
    public static Builder byteCountFormat() {
        return new Builder();
    }

    public static final int DEFAULT_PRECISION = 2;
    private static final ByteUnit[] BYTE_UNITS = ByteUnit.values();

    @Nonnull
    private final Optional<ByteUnit> byteUnit;
    @Nonnull
    private final NumberFormat numberFormat;
    @Nonnull
    private final Locale locale;
    @Nonnegative
    private final int precision;

    protected ByteCountFormat(
        @Nonnull Optional<ByteUnit> byteUnit,
        @Nonnull Locale locale,
        @Nonnegative int precision
    ) {
        this.byteUnit = byteUnit;
        this.locale = locale;
        this.precision = precision;
        this.numberFormat = DecimalFormat.getNumberInstance(locale);
        this.numberFormat.setMaximumFractionDigits(precision);
    }

    @Nonnull
    public String format(@Nonnull ByteCount value) {
        if (byteUnit.isPresent()) {
            return formatWithUnit(value, byteUnit.get());
        }
        return formatWithoutUnit(value);
    }

    @Nonnull
    protected String formatWithUnit(@Nonnull ByteCount value, @Nonnull ByteUnit unit) {
        final BigDecimal valueAsDecimal = value.in(unit);
        return numberFormat.format(valueAsDecimal) + unit.display();
    }

    @Nonnull
    protected String formatWithoutUnit(@Nonnull ByteCount value) {
        return formatWithoutUnit(value.bigIntegerValue());
    }

    @Nonnull
    protected String formatWithoutUnit(@Nonnull BigInteger byteCount) {
        final StringBuilder sb = new StringBuilder();
        BigInteger rest = byteCount;
        for (int i = BYTE_UNITS.length - 1; i >= 0; i--) {
            final ByteUnit unit = BYTE_UNITS[i];
            final BigInteger value = unit.convert(rest, BYTE);
            if (value.compareTo(BigInteger.ZERO) > 0) {
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(value).append(unit.display());
                rest = rest.subtract(unit.toBytes(value));
            }
        }
        if (sb.length() == 0) {
            sb.append('0');
        }
        return sb.toString();
    }


    @Nonnull
    public Optional<ByteUnit> byteUnit() {
        return byteUnit;
    }

    @Nonnull
    public Locale locale() {
        return locale;
    }

    public int precision() {
        return precision;
    }

    public static class Builder {

        @Nonnull
        private Optional<ByteUnit> byteUnit = Optional.empty();
        @Nonnull
        private Optional<Locale> locale = Optional.empty();
        @Nonnull
        private Optional<Integer> precision = Optional.empty();

        @Nonnull
        public Builder ofByteUnit(@Nullable ByteUnit byteUnit) {
            this.byteUnit = ofNullable(byteUnit);
            return this;
        }

        @Nonnull
        public Builder withLocale(@Nullable Locale locale) {
            this.locale = ofNullable(locale);
            return this;
        }

        @Nonnull
        public Builder setPrecision(@Nullable @Nonnegative Integer precision) {
            if (precision != null && precision < 0) {
                throw new IllegalArgumentException("Given precision is negative: " + precision);
            }
            this.precision = ofNullable(precision);
            return this;
        }

        protected Builder() {
        }

        @Nonnull
        public ByteCountFormat build() {
            return new ByteCountFormat(
                byteUnit,
                locale.orElseGet(Locale::getDefault),
                precision.orElse(DEFAULT_PRECISION)
            );
        }

    }

}
