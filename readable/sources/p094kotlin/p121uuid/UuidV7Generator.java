package p094kotlin.p121uuid;

import java.util.concurrent.atomic.AtomicLong;
import org.conscrypt.BuildConfig;
import p094kotlin.C1126UByte;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.ByteCompanionObject;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p119time.InterfaceC1323Clock;
import p132okio.C5066Utf8;

@Metadata(m4987d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086\u0080\u0004R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0006\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0007\u001a\u00020\bX\u0082Ô\b¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\nX\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0010"}, m4988d2 = {"Lkotlin/uuid/UuidV7Generator;", BuildConfig.f24315FLAVOR, "<init>", "()V", "TIMESTAMP_BIAS_BITS", BuildConfig.f24315FLAVOR, "VERSION_MASK", "OVERFLOW_MASK", BuildConfig.f24315FLAVOR, "timestampAndCounter", "Lkotlin/concurrent/atomics/AtomicLong;", "Ljava/util/concurrent/atomic/AtomicLong;", "generate", "Lkotlin/uuid/Uuid;", "clock", "Lkotlin/time/Clock;", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
final class UuidV7Generator {
    private static final long OVERFLOW_MASK = 32768;
    private static final int TIMESTAMP_BIAS_BITS = 16;
    private static final int VERSION_MASK = 28672;
    public static final UuidV7Generator INSTANCE = new UuidV7Generator();
    private static final AtomicLong timestampAndCounter = new AtomicLong(0);

    private UuidV7Generator() {
    }

    public final C1327Uuid generate(InterfaceC1323Clock clock) {
        long j;
        Intrinsics.checkNotNullParameter(clock, "clock");
        byte[] bArr = new byte[10];
        UuidKt__UuidJVMKt.secureRandomBytes(bArr);
        int i = ((bArr[8] & 7) << 8) | (bArr[9] & C1126UByte.MAX_VALUE) | VERSION_MASK;
        while (true) {
            AtomicLong atomicLong = timestampAndCounter;
            long j2 = atomicLong.get();
            long epochMilliseconds = clock.mo6153now().toEpochMilliseconds();
            long j3 = j2 >>> 16;
            if (j3 < epochMilliseconds) {
                j = (epochMilliseconds << 16) | i;
                if (atomicLong.compareAndSet(j2, j)) {
                    break;
                }
            } else {
                long j4 = j2 + 1;
                j = (OVERFLOW_MASK & j4) != 0 ? ((j3 + 1) << 16) | i : j4;
                if (atomicLong.compareAndSet(j2, j)) {
                    break;
                }
            }
        }
        bArr[0] = (byte) (((byte) (bArr[0] & C5066Utf8.REPLACEMENT_BYTE)) | ByteCompanionObject.MIN_VALUE);
        return C1327Uuid.INSTANCE.fromLongs(j, UuidKt__UuidJVMKt.getLongAt(bArr, 0));
    }
}
