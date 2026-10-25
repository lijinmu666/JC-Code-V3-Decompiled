package p094kotlin.p121uuid;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import org.conscrypt.BuildConfig;
import p094kotlin.IgnorableReturnValue;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.WasExperimental;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0080\u0080\u0004\u001a\u0012\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0080\u0080\u0004\u001a\u0016\u0010\b\u001a\u00020\t*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0080\u0080\u0004\u001a.\u0010\f\u001a\u00020\u0001*\u00020\t2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0080\u0080\u0004\u001a\u001e\u0010\u0011\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\tH\u0080\u0080\u0004\u001a\u0012\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0080\u0080\u0004\u001a\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0081\u0080\u0004b\u0002\b\u0017\u001a\u0012\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0015H\u0080\u0080\u0004\u001a\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0019\u001a\u00020\u0015H\u0081\u0080\u0004b\u0002\b\u0017\u001a.\u0010\u001b\u001a\u00020\u0007*\u00020\u001cH\u0087\u0088\u0004b\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\u0010\b \u0012\f\b!\u0012\b\b\fJ\u0004\b\t0\u0017\u001a.\u0010\"\u001a\u00020\u001c*\u00020\u0007H\u0087\u0088\u0004b\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\u0010\b \u0012\f\b!\u0012\b\b\fJ\u0004\b\t0\u0017\u001a.\u0010#\u001a\u00020\u0007*\u00020$H\u0087\u0080\u0004b\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\u0010\b \u0012\f\b!\u0012\b\b\fJ\u0004\b\t0\u0017\u001a6\u0010#\u001a\u00020\u0007*\u00020$2\u0006\u0010\n\u001a\u00020\u000bH\u0087\u0080\u0004b\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\u0010\b \u0012\f\b!\u0012\b\b\fJ\u0004\b\t0\u0017\u001a:\u0010%\u001a\u00020$*\u00020$2\u0006\u0010\u0006\u001a\u00020\u0007H\u0087\u0080\bb\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\u0010\b \u0012\f\b!\u0012\b\b\fJ\u0004\b\t0\u0017b\u0002\b&\u001aB\u0010%\u001a\u00020$*\u00020$2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0087\u0080\bb\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\u0010\b \u0012\f\b!\u0012\b\b\fJ\u0004\b\t0\u0017b\u0002\b&\u001a\u000e\u0010'\u001a\u00020\t*\u00020\tH\u0080\u0088\u0004¨\u0006("}, m4988d2 = {"secureRandomBytes", BuildConfig.f24315FLAVOR, "destination", BuildConfig.f24315FLAVOR, "serializedUuid", BuildConfig.f24315FLAVOR, "uuid", "Lkotlin/uuid/Uuid;", "getLongAt", BuildConfig.f24315FLAVOR, "index", BuildConfig.f24315FLAVOR, "formatBytesInto", "dst", "dstOffset", "startIndex", "endIndex", "setLongAt", "value", "uuidParseHexDash", "hexDashString", BuildConfig.f24315FLAVOR, "uuidParseHexDashOrNull", "Lkotlin/uuid/ExperimentalUuidApi;", "uuidParseHex", "hexString", "uuidParseHexOrNull", "toKotlinUuid", "Ljava/util/UUID;", "Lkotlin/SinceKotlin;", "version", "2.4", "Lkotlin/WasExperimental;", "markerClass", "toJavaUuid", "getUuid", "Ljava/nio/ByteBuffer;", "putUuid", "Lkotlin/IgnorableReturnValue;", "reverseBytes", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/uuid/UuidKt")
@SourceDebugExtension(m6344value = {"SMAP\nUuidJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UuidJVM.kt\nkotlin/uuid/UuidKt__UuidJVMKt\n*L\n1#1,278:1\n277#1:279\n277#1:280\n277#1:281\n277#1:282\n277#1:283\n277#1:284\n277#1:285\n277#1:286\n*S KotlinDebug\n*F\n+ 1 UuidJVM.kt\nkotlin/uuid/UuidKt__UuidJVMKt\n*L\n137#1:279\n138#1:280\n182#1:281\n183#1:282\n223#1:283\n224#1:284\n271#1:285\n272#1:286\n*E\n"})
/* loaded from: classes.dex */
class UuidKt__UuidJVMKt {
    public static final void formatBytesInto(long j, byte[] dst, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        UuidKt__UuidKt.formatBytesIntoCommonImpl(j, dst, i, i2, i3);
    }

    public static final long getLongAt(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return UuidKt__UuidKt.getLongAtCommonImpl(bArr, i);
    }

    @SinceKotlin(m5061version = "2.4")
    @WasExperimental(markerClass = {ExperimentalUuidApi.class})
    /* renamed from: getUuid */
    public static final C1327Uuid m6896getUuid(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        if (byteBuffer.position() + 15 >= byteBuffer.limit()) {
            throw new BufferUnderflowException();
        }
        long jReverseBytes = byteBuffer.getLong();
        long jReverseBytes2 = byteBuffer.getLong();
        if (Intrinsics.areEqual(byteBuffer.order(), ByteOrder.LITTLE_ENDIAN)) {
            jReverseBytes = Long.reverseBytes(jReverseBytes);
            jReverseBytes2 = Long.reverseBytes(jReverseBytes2);
        }
        return C1327Uuid.INSTANCE.fromLongs(jReverseBytes, jReverseBytes2);
    }

    @SinceKotlin(m5061version = "2.4")
    @IgnorableReturnValue
    @WasExperimental(markerClass = {ExperimentalUuidApi.class})
    /* renamed from: putUuid */
    public static final ByteBuffer m6899putUuid(ByteBuffer byteBuffer, C1327Uuid uuid) {
        ByteBuffer byteBufferPutLong;
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        if (byteBuffer.position() + 15 >= byteBuffer.limit()) {
            throw new BufferOverflowException();
        }
        if (Intrinsics.areEqual(byteBuffer.order(), ByteOrder.BIG_ENDIAN)) {
            byteBuffer.putLong(mostSignificantBits);
            byteBufferPutLong = byteBuffer.putLong(leastSignificantBits);
        } else {
            byteBuffer.putLong(Long.reverseBytes(mostSignificantBits));
            byteBufferPutLong = byteBuffer.putLong(Long.reverseBytes(leastSignificantBits));
        }
        Intrinsics.checkNotNullExpressionValue(byteBufferPutLong, "toLongs(...)");
        return byteBufferPutLong;
    }

    public static final long reverseBytes(long j) {
        return Long.reverseBytes(j);
    }

    public static final void secureRandomBytes(byte[] destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        SecureRandomHolder.INSTANCE.getInstance().nextBytes(destination);
    }

    public static final Object serializedUuid(C1327Uuid uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return new UuidSerialized(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits());
    }

    public static final void setLongAt(byte[] bArr, int i, long j) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        UuidKt__UuidKt.setLongAtCommonImpl(bArr, i, j);
    }

    @SinceKotlin(m5061version = "2.4")
    @WasExperimental(markerClass = {ExperimentalUuidApi.class})
    public static final UUID toJavaUuid(C1327Uuid c1327Uuid) {
        Intrinsics.checkNotNullParameter(c1327Uuid, "<this>");
        return new UUID(c1327Uuid.getMostSignificantBits(), c1327Uuid.getLeastSignificantBits());
    }

    @SinceKotlin(m5061version = "2.4")
    @WasExperimental(markerClass = {ExperimentalUuidApi.class})
    public static final C1327Uuid toKotlinUuid(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "<this>");
        return C1327Uuid.INSTANCE.fromLongs(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits());
    }

    public static final C1327Uuid uuidParseHex(String hexString) {
        Intrinsics.checkNotNullParameter(hexString, "hexString");
        return UuidKt__UuidKt.uuidParseHexCommonImpl(hexString);
    }

    public static final C1327Uuid uuidParseHexDash(String hexDashString) {
        Intrinsics.checkNotNullParameter(hexDashString, "hexDashString");
        return UuidKt__UuidKt.uuidParseHexDashCommonImpl(hexDashString);
    }

    @ExperimentalUuidApi
    public static final C1327Uuid uuidParseHexDashOrNull(String hexDashString) {
        Intrinsics.checkNotNullParameter(hexDashString, "hexDashString");
        return UuidKt__UuidKt.uuidParseHexDashOrNullCommonImpl(hexDashString);
    }

    @ExperimentalUuidApi
    public static final C1327Uuid uuidParseHexOrNull(String hexString) {
        Intrinsics.checkNotNullParameter(hexString, "hexString");
        return UuidKt__UuidKt.uuidParseHexOrNullCommonImpl(hexString);
    }

    @SinceKotlin(m5061version = "2.4")
    @WasExperimental(markerClass = {ExperimentalUuidApi.class})
    /* renamed from: getUuid */
    public static final C1327Uuid m6897getUuid(ByteBuffer byteBuffer, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        if (i >= 0) {
            if (i + 15 < byteBuffer.limit()) {
                long jReverseBytes = byteBuffer.getLong(i);
                long jReverseBytes2 = byteBuffer.getLong(i + 8);
                if (Intrinsics.areEqual(byteBuffer.order(), ByteOrder.LITTLE_ENDIAN)) {
                    jReverseBytes = Long.reverseBytes(jReverseBytes);
                    jReverseBytes2 = Long.reverseBytes(jReverseBytes2);
                }
                return C1327Uuid.INSTANCE.fromLongs(jReverseBytes, jReverseBytes2);
            }
            throw new IndexOutOfBoundsException("Not enough bytes to read a uuid at index: " + i + ", with limit: " + byteBuffer.limit() + ' ');
        }
        throw new IndexOutOfBoundsException("Negative index: " + i);
    }

    @SinceKotlin(m5061version = "2.4")
    @IgnorableReturnValue
    @WasExperimental(markerClass = {ExperimentalUuidApi.class})
    /* renamed from: putUuid */
    public static final ByteBuffer m6898putUuid(ByteBuffer byteBuffer, int i, C1327Uuid uuid) {
        ByteBuffer byteBufferPutLong;
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        if (i >= 0) {
            if (i + 15 < byteBuffer.limit()) {
                if (Intrinsics.areEqual(byteBuffer.order(), ByteOrder.BIG_ENDIAN)) {
                    byteBuffer.putLong(i, mostSignificantBits);
                    byteBufferPutLong = byteBuffer.putLong(i + 8, leastSignificantBits);
                } else {
                    byteBuffer.putLong(i, Long.reverseBytes(mostSignificantBits));
                    byteBufferPutLong = byteBuffer.putLong(i + 8, Long.reverseBytes(leastSignificantBits));
                }
                Intrinsics.checkNotNullExpressionValue(byteBufferPutLong, "toLongs(...)");
                return byteBufferPutLong;
            }
            throw new IndexOutOfBoundsException("Not enough capacity to write a uuid at index: " + i + ", with limit: " + byteBuffer.limit() + ' ');
        }
        throw new IndexOutOfBoundsException("Negative index: " + i);
    }
}
