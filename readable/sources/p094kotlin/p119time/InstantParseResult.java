package p094kotlin.p119time;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p117text.Typography;
import p094kotlin.p119time.C1324Instant;

@Metadata(m4987d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0005\u0006J\n\u0010\u0002\u001a\u00020\u0003H¦\u0080\u0004J\f\u0010\u0004\u001a\u0004\u0018\u00010\u0003H¦\u0080\u0004\u0082\u0001\u0002\u0007\b¨\u0006\t"}, m4988d2 = {"Lkotlin/time/InstantParseResult;", BuildConfig.f24315FLAVOR, "toInstant", "Lkotlin/time/Instant;", "toInstantOrNull", "Success", "Failure", "Lkotlin/time/InstantParseResult$Failure;", "Lkotlin/time/InstantParseResult$Success;", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
interface InstantParseResult {

    @Metadata(m4987d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004J\f\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, m4988d2 = {"Lkotlin/time/InstantParseResult$Failure;", "Lkotlin/time/InstantParseResult;", "error", BuildConfig.f24315FLAVOR, "input", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;)V", "getError", "()Ljava/lang/String;", "getInput", "()Ljava/lang/CharSequence;", "toInstant", "Lkotlin/time/Instant;", "toInstantOrNull", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: kotlin.time.InstantParseResult$Failure */
    public static final class C1325Failure implements InstantParseResult {
        private final String error;
        private final CharSequence input;

        public C1325Failure(String error, CharSequence input) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(input, "input");
            this.error = error;
            this.input = input;
        }

        public final String getError() {
            return this.error;
        }

        public final CharSequence getInput() {
            return this.input;
        }

        @Override // p094kotlin.p119time.InstantParseResult
        public C1324Instant toInstant() {
            throw new InstantFormatException(this.error + " when parsing an Instant from \"" + InstantKt.truncateForErrorMessage(this.input, 64) + Typography.quote);
        }

        @Override // p094kotlin.p119time.InstantParseResult
        public C1324Instant toInstantOrNull() {
            return null;
        }
    }

    @Metadata(m4987d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004J\f\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, m4988d2 = {"Lkotlin/time/InstantParseResult$Success;", "Lkotlin/time/InstantParseResult;", "epochSeconds", BuildConfig.f24315FLAVOR, "nanosecondsOfSecond", BuildConfig.f24315FLAVOR, "<init>", "(JI)V", "getEpochSeconds", "()J", "getNanosecondsOfSecond", "()I", "toInstant", "Lkotlin/time/Instant;", "toInstantOrNull", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: kotlin.time.InstantParseResult$Success */
    public static final class C1326Success implements InstantParseResult {
        private final long epochSeconds;
        private final int nanosecondsOfSecond;

        public C1326Success(long j, int i) {
            this.epochSeconds = j;
            this.nanosecondsOfSecond = i;
        }

        public final long getEpochSeconds() {
            return this.epochSeconds;
        }

        public final int getNanosecondsOfSecond() {
            return this.nanosecondsOfSecond;
        }

        @Override // p094kotlin.p119time.InstantParseResult
        public C1324Instant toInstant() {
            long j = this.epochSeconds;
            C1324Instant.Companion companion = C1324Instant.INSTANCE;
            if (j >= companion.getMIN$kotlin_stdlib().getEpochSeconds() && this.epochSeconds <= companion.getMAX$kotlin_stdlib().getEpochSeconds()) {
                return companion.fromEpochSeconds(this.epochSeconds, this.nanosecondsOfSecond);
            }
            throw new InstantFormatException("The parsed date is outside the range representable by Instant (Unix epoch second " + this.epochSeconds + ')');
        }

        @Override // p094kotlin.p119time.InstantParseResult
        public C1324Instant toInstantOrNull() {
            long j = this.epochSeconds;
            C1324Instant.Companion companion = C1324Instant.INSTANCE;
            if (j < companion.getMIN$kotlin_stdlib().getEpochSeconds() || this.epochSeconds > companion.getMAX$kotlin_stdlib().getEpochSeconds()) {
                return null;
            }
            return companion.fromEpochSeconds(this.epochSeconds, this.nanosecondsOfSecond);
        }
    }

    C1324Instant toInstant();

    C1324Instant toInstantOrNull();
}
