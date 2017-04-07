package org.echocat.units4j.bytes;

import org.echocat.units4j.bytes.ByteUnit.Kind;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Function;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;
import static org.echocat.units4j.bytes.ByteCountFormat.NameFormat.briefly;
import static org.echocat.units4j.bytes.ByteUnit.B;
import static org.echocat.units4j.bytes.ByteUnit.Kind.binary;

@Immutable
public class ByteCountFormat {

    @Nonnull
    public static Builder byteCountFormat() {
        return new Builder();
    }

    @Nonnull
    private final Optional<ByteUnit> byteUnit;
    @Nonnull
    private final ByteUnit.Kind byteUnitKind;
    @Nonnull
    private final NumberFormat numberFormat;
    @Nonnull
    private final Locale locale;
    @Nonnull
    private final NameFormat nameFormat;
    @Nonnegative
    @Nonnull
    private final Optional<Integer> maximumFractionDigits;
    @Nonnegative
    @Nonnull
    private final Optional<Integer> minimumFractionDigits;

    protected ByteCountFormat(
        @Nonnull Optional<ByteUnit> byteUnit,
        @Nonnull Kind byteUnitKind,
        @Nonnull Locale locale,
        @Nonnull NameFormat nameFormat,
        @Nonnegative @Nonnull Optional<Integer> maximumFractionDigits,
        @Nonnegative @Nonnull Optional<Integer> minimumFractionDigits
    ) {
        this.byteUnit = byteUnit;
        this.byteUnitKind = byteUnitKind;
        this.locale = locale;
        this.nameFormat = nameFormat;
        this.maximumFractionDigits = maximumFractionDigits;
        this.minimumFractionDigits = minimumFractionDigits;
        this.numberFormat = NumberFormat.getNumberInstance(locale);
        this.numberFormat.setMaximumFractionDigits(maximumFractionDigits.orElse(0));
        this.numberFormat.setMinimumFractionDigits(minimumFractionDigits.orElse(0));
    }

    @Nonnull
    public String format(@Nonnull ByteCount value) {
        if (ByteCount.ZERO.equals(value)) {
            return "0";
        }
        return byteUnit()
            .map(candidate -> formatWithUnit(value, candidate))
            .orElseGet(() -> maximumFractionDigits()
                .map(ignored -> formatWithBestFittingUnit(value))
                .orElseGet(() -> formatWithoutUnit(value))
            );
    }

    @Nonnull
    protected String formatWithUnit(@Nonnull ByteCount value, @Nonnull ByteUnit unit) {
        final BigDecimal valueAsDecimal = value.toDecimal(unit);
        return numberFormat().format(valueAsDecimal) + nameFormat().format(unit);
    }

    @Nonnull
    protected String formatWithBestFittingUnit(@Nonnull ByteCount value) {
        final ByteUnit unit = value.bestFittingUnitOf(byteUnitKind());
        return formatWithUnit(value, unit);
    }

    @Nonnull
    protected String formatWithoutUnit(@Nonnull ByteCount value) {
        return formatWithoutUnit(value.bigIntegerValue());
    }

    @Nonnull
    protected String formatWithoutUnit(@Nonnull BigInteger byteCount) {
        final StringBuilder sb = new StringBuilder();
        BigInteger rest = byteCount;
        final List<ByteUnit> values = ByteUnit.valuesOf(byteUnitKind());
        final int numberOfValues = values.size();
        for (int i = numberOfValues - 1; i >= 0; i--) {
            final ByteUnit unit = values.get(i);
            final BigInteger value = unit.from(rest, B);
            if (value.compareTo(BigInteger.ZERO) > 0) {
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(numberFormat().format(value)).append(nameFormat().format(unit));
                rest = rest.subtract(unit.to(value, B));
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
    public Kind byteUnitKind() {
        return byteUnitKind;
    }

    @Nonnull
    public Locale locale() {
        return locale;
    }

    @Nonnull
    public NameFormat nameFormat() {
        return nameFormat;
    }

    @Nonnull
    protected NumberFormat numberFormat() {
        return numberFormat;
    }

    @Nonnull
    @Nonnegative
    public Optional<Integer> maximumFractionDigits() {
        return maximumFractionDigits;
    }

    @Nonnull
    @Nonnegative
    public Optional<Integer> minimumFractionDigits() {
        return minimumFractionDigits;
    }

    public static class Builder {

        @Nonnull
        private Optional<ByteUnit> byteUnit = empty();
        @Nonnull
        private Optional<ByteUnit.Kind> byteUnitKind = empty();
        @Nonnull
        private Optional<NameFormat> nameFormat = empty();
        @Nonnull
        private Optional<Locale> locale = empty();
        @Nonnull
        private Optional<Integer> maximumFractionDigits = empty();
        @Nonnull
        private Optional<Integer> minimumFractionDigits = empty();

        @Nonnull
        public Builder ofByteUnit(@Nullable ByteUnit byteUnit) {
            this.byteUnit = ofNullable(byteUnit);
            return this;
        }

        @Nonnull
        public Builder ofByteUnitKind(@Nullable ByteUnit.Kind byteUnitKind) {
            this.byteUnitKind = ofNullable(byteUnitKind);
            return this;
        }

        @Nonnull
        public Builder withLocale(@Nullable Locale locale) {
            this.locale = ofNullable(locale);
            return this;
        }

        @Nonnull
        public Builder withNameFormat(@Nullable NameFormat nameFormat) {
            this.nameFormat = ofNullable(nameFormat);
            return this;
        }

        @Nonnull
        public Builder withMaximumFractionDigits(@Nullable @Nonnegative Integer maximumFractionDigits) {
            if (maximumFractionDigits != null && maximumFractionDigits < 0) {
                throw new IllegalArgumentException("Given maximumFractionDigits value is negative: " + maximumFractionDigits);
            }
            this.maximumFractionDigits = ofNullable(maximumFractionDigits);
            return this;
        }

        @Nonnull
        public Builder withMinimumFractionDigits(@Nullable @Nonnegative Integer minimumFractionDigits) {
            if (minimumFractionDigits != null && minimumFractionDigits < 0) {
                throw new IllegalArgumentException("Given minimumFractionDigits value is negative: " + minimumFractionDigits);
            }
            this.minimumFractionDigits = ofNullable(minimumFractionDigits);
            return this;
        }

        protected Builder() {
        }

        @Nonnull
        public ByteCountFormat build() {
            return new ByteCountFormat(
                byteUnit,
                byteUnitKind.orElse(binary),
                locale.orElseGet(Locale::getDefault),
                nameFormat.orElse(briefly),
                maximumFractionDigits,
                minimumFractionDigits
            );
        }

    }

    public enum NameFormat {
        briefly(ByteUnit::name),
        complete(ByteUnit::name);

        private final Function<ByteUnit, String> function;

        NameFormat(Function<ByteUnit, String> function) {
            this.function = function;
        }

        public String format(@Nonnull ByteUnit byteUnit) {
            return function.apply(byteUnit);
        }
    }
}
