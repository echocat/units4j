package org.echocat.units4j.bytes;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

import static java.math.BigDecimal.ROUND_HALF_EVEN;
import static java.util.Optional.empty;
import static java.util.Optional.of;

public enum ByteUnit {
    BYTE("B", "B") {
        @Override public long toBytes(@Nonnegative long count) { return count; }
        @Override public long toKiloBytes(@Nonnegative long count) { return toBytes(count) / L_STEP; }
        @Override public long toMegaBytes(@Nonnegative long count) { return toKiloBytes(count) / L_STEP; }
        @Override public long toGigaBytes(@Nonnegative long count) { return toMegaBytes(count) / L_STEP; }
        @Override public long toTeraBytes(@Nonnegative long count) { return toGigaBytes(count) / L_STEP; }
        @Override public long toPetaBytes(@Nonnegative long count) { return toTeraBytes(count) / L_STEP; }
        @Override public long toExaBytes(@Nonnegative long count) { return toPetaBytes(count) / L_STEP; }
        @Override public long convert(@Nonnegative long count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toBytes(count); }

        @Override public double toBytes(@Nonnegative double count) { return count; }
        @Override public double toKiloBytes(@Nonnegative double count) { return toBytes(count) / D_STEP; }
        @Override public double toMegaBytes(@Nonnegative double count) { return toKiloBytes(count) / D_STEP; }
        @Override public double toGigaBytes(@Nonnegative double count) { return toMegaBytes(count) / D_STEP; }
        @Override public double toTeraBytes(@Nonnegative double count) { return toGigaBytes(count) / D_STEP; }
        @Override public double toPetaBytes(@Nonnegative double count) { return toTeraBytes(count) / D_STEP; }
        @Override public double toExaBytes(@Nonnegative double count) { return toPetaBytes(count) / D_STEP; }
        @Override public double convert(@Nonnegative double count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toBytes(count); }

        @Override public BigInteger toBytes(@Nonnegative BigInteger count) { return count; }
        @Override public BigInteger toKiloBytes(@Nonnegative BigInteger count) { return toBytes(count).divide(BI_STEP); }
        @Override public BigInteger toMegaBytes(@Nonnegative BigInteger count) { return toKiloBytes(count).divide(BI_STEP); }
        @Override public BigInteger toGigaBytes(@Nonnegative BigInteger count) { return toMegaBytes(count).divide(BI_STEP); }
        @Override public BigInteger toTeraBytes(@Nonnegative BigInteger count) { return toGigaBytes(count).divide(BI_STEP); }
        @Override public BigInteger toPetaBytes(@Nonnegative BigInteger count) { return toTeraBytes(count).divide(BI_STEP); }
        @Override public BigInteger toExaBytes(@Nonnegative BigInteger count) { return toPetaBytes(count).divide(BI_STEP); }
        @Override public BigInteger convert(@Nonnegative BigInteger count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toBytes(count); }

        @Override public BigDecimal toBytes(@Nonnegative BigDecimal count) { return count; }
        @Override public BigDecimal toKiloBytes(@Nonnegative BigDecimal count) { return toBytes(count).divide(BD_STEP, ROUNDING_MODE); }
        @Override public BigDecimal toMegaBytes(@Nonnegative BigDecimal count) { return toKiloBytes(count).divide(BD_STEP, ROUNDING_MODE); }
        @Override public BigDecimal toGigaBytes(@Nonnegative BigDecimal count) { return toMegaBytes(count).divide(BD_STEP, ROUNDING_MODE); }
        @Override public BigDecimal toTeraBytes(@Nonnegative BigDecimal count) { return toGigaBytes(count).divide(BD_STEP, ROUNDING_MODE); }
        @Override public BigDecimal toPetaBytes(@Nonnegative BigDecimal count) { return toTeraBytes(count).divide(BD_STEP, ROUNDING_MODE); }
        @Override public BigDecimal toExaBytes(@Nonnegative BigDecimal count) { return toPetaBytes(count).divide(BD_STEP, ROUNDING_MODE); }
        @Override public BigDecimal convert(@Nonnegative BigDecimal count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toBytes(count); }
    },
    KILO_BYTE("kB", "k") {
        @Override public long toBytes(@Nonnegative long count) { return toKiloBytes(count) * L_STEP; }
        @Override public long toKiloBytes(@Nonnegative long count) { return count; }
        @Override public long toMegaBytes(@Nonnegative long count) { return toKiloBytes(count) / L_STEP; }
        @Override public long toGigaBytes(@Nonnegative long count) { return toMegaBytes(count) / L_STEP; }
        @Override public long toTeraBytes(@Nonnegative long count) { return toGigaBytes(count) / L_STEP; }
        @Override public long toPetaBytes(@Nonnegative long count) { return toTeraBytes(count) / L_STEP; }
        @Override public long toExaBytes(@Nonnegative long count) { return toPetaBytes(count) / L_STEP; }
        @Override public long convert(@Nonnegative long count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toKiloBytes(count); }

        @Override public double toBytes(@Nonnegative double count) { return toKiloBytes(count) * D_STEP; }
        @Override public double toKiloBytes(@Nonnegative double count) { return count; }
        @Override public double toMegaBytes(@Nonnegative double count) { return toKiloBytes(count) / D_STEP; }
        @Override public double toGigaBytes(@Nonnegative double count) { return toMegaBytes(count) / D_STEP; }
        @Override public double toTeraBytes(@Nonnegative double count) { return toGigaBytes(count) / D_STEP; }
        @Override public double toPetaBytes(@Nonnegative double count) { return toTeraBytes(count) / D_STEP; }
        @Override public double toExaBytes(@Nonnegative double count) { return toPetaBytes(count) / D_STEP; }
        @Override public double convert(@Nonnegative double count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toKiloBytes(count); }

        @Override public BigInteger toBytes(@Nonnegative BigInteger count) { return toKiloBytes(count).multiply(BI_STEP); }
        @Override public BigInteger toKiloBytes(@Nonnegative BigInteger count) { return count; }
        @Override public BigInteger toMegaBytes(@Nonnegative BigInteger count) { return toKiloBytes(count).divide(BI_STEP); }
        @Override public BigInteger toGigaBytes(@Nonnegative BigInteger count) { return toMegaBytes(count).divide(BI_STEP); }
        @Override public BigInteger toTeraBytes(@Nonnegative BigInteger count) { return toGigaBytes(count).divide(BI_STEP); }
        @Override public BigInteger toPetaBytes(@Nonnegative BigInteger count) { return toTeraBytes(count).divide(BI_STEP); }
        @Override public BigInteger toExaBytes(@Nonnegative BigInteger count) { return toPetaBytes(count).divide(BI_STEP); }
        @Override public BigInteger convert(@Nonnegative BigInteger count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toKiloBytes(count); }

        @Override public BigDecimal toBytes(@Nonnegative BigDecimal count) { return toKiloBytes(count).multiply(BD_STEP); }
        @Override public BigDecimal toKiloBytes(@Nonnegative BigDecimal count) { return count; }
        @Override public BigDecimal toMegaBytes(@Nonnegative BigDecimal count) { return toKiloBytes(count).divide(BD_STEP, ROUNDING_MODE); }
        @Override public BigDecimal toGigaBytes(@Nonnegative BigDecimal count) { return toMegaBytes(count).divide(BD_STEP, ROUNDING_MODE); }
        @Override public BigDecimal toTeraBytes(@Nonnegative BigDecimal count) { return toGigaBytes(count).divide(BD_STEP, ROUNDING_MODE); }
        @Override public BigDecimal toPetaBytes(@Nonnegative BigDecimal count) { return toTeraBytes(count).divide(BD_STEP, ROUNDING_MODE); }
        @Override public BigDecimal toExaBytes(@Nonnegative BigDecimal count) { return toPetaBytes(count).divide(BD_STEP, ROUNDING_MODE); }
        @Override public BigDecimal convert(@Nonnegative BigDecimal count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toKiloBytes(count); }
    },
    MEGA_BYTE("MB", "M") {
        @Override public long toBytes(@Nonnegative long count) { return toKiloBytes(count) * L_STEP; }
        @Override public long toKiloBytes(@Nonnegative long count) { return toMegaBytes(count) * L_STEP; }
        @Override public long toMegaBytes(@Nonnegative long count) { return count; }
        @Override public long toGigaBytes(@Nonnegative long count) { return toMegaBytes(count) / L_STEP; }
        @Override public long toTeraBytes(@Nonnegative long count) { return toGigaBytes(count) / L_STEP; }
        @Override public long toPetaBytes(@Nonnegative long count) { return toTeraBytes(count) / L_STEP; }
        @Override public long toExaBytes(@Nonnegative long count) { return toPetaBytes(count) / L_STEP; }
        @Override public long convert(@Nonnegative long count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toMegaBytes(count); }

        @Override public double toBytes(@Nonnegative double count) { return toKiloBytes(count) * D_STEP; }
        @Override public double toKiloBytes(@Nonnegative double count) { return toMegaBytes(count) * D_STEP; }
        @Override public double toMegaBytes(@Nonnegative double count) { return count; }
        @Override public double toGigaBytes(@Nonnegative double count) { return toMegaBytes(count) / D_STEP; }
        @Override public double toTeraBytes(@Nonnegative double count) { return toGigaBytes(count) / D_STEP; }
        @Override public double toPetaBytes(@Nonnegative double count) { return toTeraBytes(count) / D_STEP; }
        @Override public double toExaBytes(@Nonnegative double count) { return toPetaBytes(count) / D_STEP; }
        @Override public double convert(@Nonnegative double count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toMegaBytes(count); }

        @Override public BigInteger toBytes(@Nonnegative BigInteger count) { return toKiloBytes(count).multiply(BI_STEP); }
        @Override public BigInteger toKiloBytes(@Nonnegative BigInteger count) { return toMegaBytes(count).multiply(BI_STEP); }
        @Override public BigInteger toMegaBytes(@Nonnegative BigInteger count) { return count; }
        @Override public BigInteger toGigaBytes(@Nonnegative BigInteger count) { return toMegaBytes(count).divide(BI_STEP); }
        @Override public BigInteger toTeraBytes(@Nonnegative BigInteger count) { return toGigaBytes(count).divide(BI_STEP); }
        @Override public BigInteger toPetaBytes(@Nonnegative BigInteger count) { return toTeraBytes(count).divide(BI_STEP); }
        @Override public BigInteger toExaBytes(@Nonnegative BigInteger count) { return toPetaBytes(count).divide(BI_STEP); }
        @Override public BigInteger convert(@Nonnegative BigInteger count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toMegaBytes(count); }

        @Override public BigDecimal toBytes(@Nonnegative BigDecimal count) { return toKiloBytes(count).multiply(BD_STEP); }
        @Override public BigDecimal toKiloBytes(@Nonnegative BigDecimal count) { return toMegaBytes(count).multiply(BD_STEP); }
        @Override public BigDecimal toMegaBytes(@Nonnegative BigDecimal count) { return count; }
        @Override public BigDecimal toGigaBytes(@Nonnegative BigDecimal count) { return toMegaBytes(count).divide(BD_STEP, ROUNDING_MODE); }
        @Override public BigDecimal toTeraBytes(@Nonnegative BigDecimal count) { return toGigaBytes(count).divide(BD_STEP, ROUNDING_MODE); }
        @Override public BigDecimal toPetaBytes(@Nonnegative BigDecimal count) { return toTeraBytes(count).divide(BD_STEP, ROUNDING_MODE); }
        @Override public BigDecimal toExaBytes(@Nonnegative BigDecimal count) { return toPetaBytes(count).divide(BD_STEP, ROUNDING_MODE); }
        @Override public BigDecimal convert(@Nonnegative BigDecimal count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toMegaBytes(count); }
    },
    GIGA_BYTE("GB", "G") {
        @Override public long toBytes(@Nonnegative long count) { return toKiloBytes(count) * L_STEP; }
        @Override public long toKiloBytes(@Nonnegative long count) { return toMegaBytes(count) * L_STEP; }
        @Override public long toMegaBytes(@Nonnegative long count) { return toGigaBytes(count) * L_STEP; }
        @Override public long toGigaBytes(@Nonnegative long count) { return count; }
        @Override public long toTeraBytes(@Nonnegative long count) { return toGigaBytes(count) / L_STEP; }
        @Override public long toPetaBytes(@Nonnegative long count) { return toTeraBytes(count) / L_STEP; }
        @Override public long toExaBytes(@Nonnegative long count) { return toPetaBytes(count) / L_STEP; }
        @Override public long convert(@Nonnegative long count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toGigaBytes(count); }

        @Override public double toBytes(@Nonnegative double count) { return toKiloBytes(count) * D_STEP; }
        @Override public double toKiloBytes(@Nonnegative double count) { return toMegaBytes(count) * D_STEP; }
        @Override public double toMegaBytes(@Nonnegative double count) { return toGigaBytes(count) * D_STEP; }
        @Override public double toGigaBytes(@Nonnegative double count) { return count; }
        @Override public double toTeraBytes(@Nonnegative double count) { return toGigaBytes(count) / D_STEP; }
        @Override public double toPetaBytes(@Nonnegative double count) { return toTeraBytes(count) / D_STEP; }
        @Override public double toExaBytes(@Nonnegative double count) { return toPetaBytes(count) / D_STEP; }
        @Override public double convert(@Nonnegative double count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toGigaBytes(count); }

        @Override public BigInteger toBytes(@Nonnegative BigInteger count) { return toKiloBytes(count).multiply(BI_STEP); }
        @Override public BigInteger toKiloBytes(@Nonnegative BigInteger count) { return toMegaBytes(count).multiply(BI_STEP); }
        @Override public BigInteger toMegaBytes(@Nonnegative BigInteger count) { return toGigaBytes(count).multiply(BI_STEP); }
        @Override public BigInteger toGigaBytes(@Nonnegative BigInteger count) { return count; }
        @Override public BigInteger toTeraBytes(@Nonnegative BigInteger count) { return toGigaBytes(count).divide(BI_STEP); }
        @Override public BigInteger toPetaBytes(@Nonnegative BigInteger count) { return toTeraBytes(count).divide(BI_STEP); }
        @Override public BigInteger toExaBytes(@Nonnegative BigInteger count) { return toPetaBytes(count).divide(BI_STEP); }
        @Override public BigInteger convert(@Nonnegative BigInteger count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toGigaBytes(count); }

        @Override public BigDecimal toBytes(@Nonnegative BigDecimal count) { return toKiloBytes(count).multiply(BD_STEP); }
        @Override public BigDecimal toKiloBytes(@Nonnegative BigDecimal count) { return toMegaBytes(count).multiply(BD_STEP); }
        @Override public BigDecimal toMegaBytes(@Nonnegative BigDecimal count) { return toGigaBytes(count).multiply(BD_STEP); }
        @Override public BigDecimal toGigaBytes(@Nonnegative BigDecimal count) { return count; }
        @Override public BigDecimal toTeraBytes(@Nonnegative BigDecimal count) { return toGigaBytes(count).divide(BD_STEP, ROUNDING_MODE); }
        @Override public BigDecimal toPetaBytes(@Nonnegative BigDecimal count) { return toTeraBytes(count).divide(BD_STEP, ROUNDING_MODE); }
        @Override public BigDecimal toExaBytes(@Nonnegative BigDecimal count) { return toPetaBytes(count).divide(BD_STEP, ROUNDING_MODE); }
        @Override public BigDecimal convert(@Nonnegative BigDecimal count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toGigaBytes(count); }
    },
    TERA_BYTE("TB", "T") {
        @Override public long toBytes(@Nonnegative long count) { return toKiloBytes(count) * L_STEP; }
        @Override public long toKiloBytes(@Nonnegative long count) { return toMegaBytes(count) * L_STEP; }
        @Override public long toMegaBytes(@Nonnegative long count) { return toGigaBytes(count) * L_STEP; }
        @Override public long toGigaBytes(@Nonnegative long count) { return toTeraBytes(count) * L_STEP; }
        @Override public long toTeraBytes(@Nonnegative long count) { return count; }
        @Override public long toPetaBytes(@Nonnegative long count) { return toTeraBytes(count) / L_STEP; }
        @Override public long toExaBytes(@Nonnegative long count) { return toPetaBytes(count) / L_STEP; }
        @Override public long convert(@Nonnegative long count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toTeraBytes(count); }

        @Override public double toBytes(@Nonnegative double count) { return toKiloBytes(count) * D_STEP; }
        @Override public double toKiloBytes(@Nonnegative double count) { return toMegaBytes(count) * D_STEP; }
        @Override public double toMegaBytes(@Nonnegative double count) { return toGigaBytes(count) * D_STEP; }
        @Override public double toGigaBytes(@Nonnegative double count) { return toTeraBytes(count) * D_STEP; }
        @Override public double toTeraBytes(@Nonnegative double count) { return count; }
        @Override public double toPetaBytes(@Nonnegative double count) { return toTeraBytes(count) / D_STEP; }
        @Override public double toExaBytes(@Nonnegative double count) { return toPetaBytes(count) / D_STEP; }
        @Override public double convert(@Nonnegative double count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toTeraBytes(count); }

        @Override public BigInteger toBytes(@Nonnegative BigInteger count) { return toKiloBytes(count).multiply(BI_STEP); }
        @Override public BigInteger toKiloBytes(@Nonnegative BigInteger count) { return toMegaBytes(count).multiply(BI_STEP); }
        @Override public BigInteger toMegaBytes(@Nonnegative BigInteger count) { return toGigaBytes(count).multiply(BI_STEP); }
        @Override public BigInteger toGigaBytes(@Nonnegative BigInteger count) { return toTeraBytes(count).multiply(BI_STEP); }
        @Override public BigInteger toTeraBytes(@Nonnegative BigInteger count) { return count; }
        @Override public BigInteger toPetaBytes(@Nonnegative BigInteger count) { return toTeraBytes(count).divide(BI_STEP); }
        @Override public BigInteger toExaBytes(@Nonnegative BigInteger count) { return toPetaBytes(count).divide(BI_STEP); }
        @Override public BigInteger convert(@Nonnegative BigInteger count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toTeraBytes(count); }

        @Override public BigDecimal toBytes(@Nonnegative BigDecimal count) { return toKiloBytes(count).multiply(BD_STEP); }
        @Override public BigDecimal toKiloBytes(@Nonnegative BigDecimal count) { return toMegaBytes(count).multiply(BD_STEP); }
        @Override public BigDecimal toMegaBytes(@Nonnegative BigDecimal count) { return toGigaBytes(count).multiply(BD_STEP); }
        @Override public BigDecimal toGigaBytes(@Nonnegative BigDecimal count) { return toTeraBytes(count).multiply(BD_STEP); }
        @Override public BigDecimal toTeraBytes(@Nonnegative BigDecimal count) { return count; }
        @Override public BigDecimal toPetaBytes(@Nonnegative BigDecimal count) { return toTeraBytes(count).divide(BD_STEP, ROUNDING_MODE); }
        @Override public BigDecimal toExaBytes(@Nonnegative BigDecimal count) { return toPetaBytes(count).divide(BD_STEP, ROUNDING_MODE); }
        @Override public BigDecimal convert(@Nonnegative BigDecimal count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toTeraBytes(count); }
    },
    PETA_BYTE("PB", "P") {
        @Override public long toBytes(@Nonnegative long count) { return toKiloBytes(count) * L_STEP; }
        @Override public long toKiloBytes(@Nonnegative long count) { return toMegaBytes(count) * L_STEP; }
        @Override public long toMegaBytes(@Nonnegative long count) { return toGigaBytes(count) * L_STEP; }
        @Override public long toGigaBytes(@Nonnegative long count) { return toTeraBytes(count) * L_STEP; }
        @Override public long toTeraBytes(@Nonnegative long count) { return toPetaBytes(count) * L_STEP; }
        @Override public long toPetaBytes(@Nonnegative long count) { return count; }
        @Override public long toExaBytes(@Nonnegative long count) { return toPetaBytes(count) / L_STEP; }
        @Override public long convert(@Nonnegative long count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toPetaBytes(count); }

        @Override public double toBytes(@Nonnegative double count) { return toKiloBytes(count) * D_STEP; }
        @Override public double toKiloBytes(@Nonnegative double count) { return toMegaBytes(count) * D_STEP; }
        @Override public double toMegaBytes(@Nonnegative double count) { return toGigaBytes(count) * D_STEP; }
        @Override public double toGigaBytes(@Nonnegative double count) { return toTeraBytes(count) * D_STEP; }
        @Override public double toTeraBytes(@Nonnegative double count) { return toPetaBytes(count) * D_STEP; }
        @Override public double toPetaBytes(@Nonnegative double count) { return count; }
        @Override public double toExaBytes(@Nonnegative double count) { return toPetaBytes(count) / D_STEP; }
        @Override public double convert(@Nonnegative double count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toPetaBytes(count); }

        @Override public BigInteger toBytes(@Nonnegative BigInteger count) { return toKiloBytes(count).multiply(BI_STEP); }
        @Override public BigInteger toKiloBytes(@Nonnegative BigInteger count) { return toMegaBytes(count).multiply(BI_STEP); }
        @Override public BigInteger toMegaBytes(@Nonnegative BigInteger count) { return toGigaBytes(count).multiply(BI_STEP); }
        @Override public BigInteger toGigaBytes(@Nonnegative BigInteger count) { return toTeraBytes(count).multiply(BI_STEP); }
        @Override public BigInteger toTeraBytes(@Nonnegative BigInteger count) { return toPetaBytes(count).multiply(BI_STEP); }
        @Override public BigInteger toPetaBytes(@Nonnegative BigInteger count) { return count; }
        @Override public BigInteger toExaBytes(@Nonnegative BigInteger count) { return toPetaBytes(count).divide(BI_STEP); }
        @Override public BigInteger convert(@Nonnegative BigInteger count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toPetaBytes(count); }

        @Override public BigDecimal toBytes(@Nonnegative BigDecimal count) { return toKiloBytes(count).multiply(BD_STEP); }
        @Override public BigDecimal toKiloBytes(@Nonnegative BigDecimal count) { return toMegaBytes(count).multiply(BD_STEP); }
        @Override public BigDecimal toMegaBytes(@Nonnegative BigDecimal count) { return toGigaBytes(count).multiply(BD_STEP); }
        @Override public BigDecimal toGigaBytes(@Nonnegative BigDecimal count) { return toTeraBytes(count).multiply(BD_STEP); }
        @Override public BigDecimal toTeraBytes(@Nonnegative BigDecimal count) { return toPetaBytes(count).multiply(BD_STEP); }
        @Override public BigDecimal toPetaBytes(@Nonnegative BigDecimal count) { return count; }
        @Override public BigDecimal toExaBytes(@Nonnegative BigDecimal count) { return toPetaBytes(count).divide(BD_STEP, ROUNDING_MODE); }
        @Override public BigDecimal convert(@Nonnegative BigDecimal count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toPetaBytes(count); }
    },
    EXA_BYTE("EB", "E") {
        @Override public long toBytes(@Nonnegative long count) { return toKiloBytes(count) * L_STEP; }
        @Override public long toKiloBytes(@Nonnegative long count) { return toMegaBytes(count) * L_STEP; }
        @Override public long toMegaBytes(@Nonnegative long count) { return toGigaBytes(count) * L_STEP; }
        @Override public long toGigaBytes(@Nonnegative long count) { return toTeraBytes(count) * L_STEP; }
        @Override public long toTeraBytes(@Nonnegative long count) { return toPetaBytes(count) * L_STEP; }
        @Override public long toPetaBytes(@Nonnegative long count) { return toExaBytes(count) * L_STEP; }
        @Override public long toExaBytes(@Nonnegative long count) { return count; }
        @Override public long convert(@Nonnegative long count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toExaBytes(count); }

        @Override public double toBytes(@Nonnegative double count) { return toKiloBytes(count) * D_STEP; }
        @Override public double toKiloBytes(@Nonnegative double count) { return toMegaBytes(count) * D_STEP; }
        @Override public double toMegaBytes(@Nonnegative double count) { return toGigaBytes(count) * D_STEP; }
        @Override public double toGigaBytes(@Nonnegative double count) { return toTeraBytes(count) * D_STEP; }
        @Override public double toTeraBytes(@Nonnegative double count) { return toPetaBytes(count) * D_STEP; }
        @Override public double toPetaBytes(@Nonnegative double count) { return toExaBytes(count) * D_STEP; }
        @Override public double toExaBytes(@Nonnegative double count) { return count; }
        @Override public double convert(@Nonnegative double count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toExaBytes(count); }

        @Override public BigInteger toBytes(@Nonnegative BigInteger count) { return toKiloBytes(count).multiply(BI_STEP); }
        @Override public BigInteger toKiloBytes(@Nonnegative BigInteger count) { return toMegaBytes(count).multiply(BI_STEP); }
        @Override public BigInteger toMegaBytes(@Nonnegative BigInteger count) { return toGigaBytes(count).multiply(BI_STEP); }
        @Override public BigInteger toGigaBytes(@Nonnegative BigInteger count) { return toTeraBytes(count).multiply(BI_STEP); }
        @Override public BigInteger toTeraBytes(@Nonnegative BigInteger count) { return toPetaBytes(count).multiply(BI_STEP); }
        @Override public BigInteger toPetaBytes(@Nonnegative BigInteger count) { return toExaBytes(count).multiply(BI_STEP); }
        @Override public BigInteger toExaBytes(@Nonnegative BigInteger count) { return count; }
        @Override public BigInteger convert(@Nonnegative BigInteger count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toExaBytes(count); }

        @Override public BigDecimal toBytes(@Nonnegative BigDecimal count) { return toKiloBytes(count).multiply(BD_STEP); }
        @Override public BigDecimal toKiloBytes(@Nonnegative BigDecimal count) { return toMegaBytes(count).multiply(BD_STEP); }
        @Override public BigDecimal toMegaBytes(@Nonnegative BigDecimal count) { return toGigaBytes(count).multiply(BD_STEP); }
        @Override public BigDecimal toGigaBytes(@Nonnegative BigDecimal count) { return toTeraBytes(count).multiply(BD_STEP); }
        @Override public BigDecimal toTeraBytes(@Nonnegative BigDecimal count) { return toPetaBytes(count).multiply(BD_STEP); }
        @Override public BigDecimal toPetaBytes(@Nonnegative BigDecimal count) { return toExaBytes(count).multiply(BD_STEP); }
        @Override public BigDecimal toExaBytes(@Nonnegative BigDecimal count) { return count; }
        @Override public BigDecimal convert(@Nonnegative BigDecimal count, @Nonnull ByteUnit sourceUnit) { return sourceUnit.toExaBytes(count); }
    };

    static final long L_STEP = 1024L;
    static final double D_STEP = 1024D;
    static final BigInteger BI_STEP = BigInteger.valueOf(1024L);
    static final BigDecimal BD_STEP = BigDecimal.valueOf(1024L, 0);
    static final int ROUNDING_MODE = ROUND_HALF_EVEN;

    @Nonnull
    public static Optional<ByteUnit> byteUnitForDisplay(@Nonnull String display) {
        for (final ByteUnit unit : values()) {
            if (unit.display().equals(display) || (unit == BYTE && "".equals(display))) {
                return of(unit);
            }
        }
        return empty();
    }

    @Nonnull
    public static Optional<ByteUnit> byteUnitForShortDisplay(@Nonnull String shortDisplay) {
        for (final ByteUnit unit : values()) {
            if (unit.shortDisplay().equals(shortDisplay) || (unit == BYTE && "".equals(shortDisplay))) {
                return of(unit);
            }
        }
        return empty();
    }

    private final String display;
    private final String shortDisplay;

    ByteUnit(@Nonnull String display, @Nonnull String shortDisplay) {
        this.display = display;
        this.shortDisplay = shortDisplay;
    }

    @Nonnegative public abstract long convert(@Nonnegative long count, @Nonnull ByteUnit sourceUnit);
    @Nonnegative public abstract double convert(@Nonnegative double count, @Nonnull ByteUnit sourceUnit);
    @Nonnegative public abstract BigInteger convert(@Nonnegative BigInteger count, @Nonnull ByteUnit sourceUnit);
    @Nonnegative public abstract BigDecimal convert(@Nonnegative BigDecimal count, @Nonnull ByteUnit sourceUnit);

    @Nonnegative public abstract long toBytes(@Nonnegative long count);
    @Nonnegative public abstract long toKiloBytes(@Nonnegative long count);
    @Nonnegative public abstract long toMegaBytes(@Nonnegative long count);
    @Nonnegative public abstract long toGigaBytes(@Nonnegative long count);
    @Nonnegative public abstract long toTeraBytes(@Nonnegative long count);
    @Nonnegative public abstract long toPetaBytes(@Nonnegative long count);
    @Nonnegative public abstract long toExaBytes(@Nonnegative long count);

    @Nonnegative public abstract double toBytes(@Nonnegative double count);
    @Nonnegative public abstract double toKiloBytes(@Nonnegative double count);
    @Nonnegative public abstract double toMegaBytes(@Nonnegative double count);
    @Nonnegative public abstract double toGigaBytes(@Nonnegative double count);
    @Nonnegative public abstract double toTeraBytes(@Nonnegative double count);
    @Nonnegative public abstract double toPetaBytes(@Nonnegative double count);
    @Nonnegative public abstract double toExaBytes(@Nonnegative double count);

    @Nonnegative public abstract BigInteger toBytes(@Nonnegative BigInteger count);
    @Nonnegative public abstract BigInteger toKiloBytes(@Nonnegative BigInteger count);
    @Nonnegative public abstract BigInteger toMegaBytes(@Nonnegative BigInteger count);
    @Nonnegative public abstract BigInteger toGigaBytes(@Nonnegative BigInteger count);
    @Nonnegative public abstract BigInteger toTeraBytes(@Nonnegative BigInteger count);
    @Nonnegative public abstract BigInteger toPetaBytes(@Nonnegative BigInteger count);
    @Nonnegative public abstract BigInteger toExaBytes(@Nonnegative BigInteger count);

    @Nonnegative public abstract BigDecimal toBytes(@Nonnegative BigDecimal count);
    @Nonnegative public abstract BigDecimal toKiloBytes(@Nonnegative BigDecimal count);
    @Nonnegative public abstract BigDecimal toMegaBytes(@Nonnegative BigDecimal count);
    @Nonnegative public abstract BigDecimal toGigaBytes(@Nonnegative BigDecimal count);
    @Nonnegative public abstract BigDecimal toTeraBytes(@Nonnegative BigDecimal count);
    @Nonnegative public abstract BigDecimal toPetaBytes(@Nonnegative BigDecimal count);
    @Nonnegative public abstract BigDecimal toExaBytes(@Nonnegative BigDecimal count);

    @Nonnull
    public String display() {
        return display;
    }

    @Nonnull
    public String shortDisplay() {
        return shortDisplay;
    }

    @Override
    public String toString() {
        return display;
    }
}
