package p094kotlin.experimental;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.InlineOnly;

@Metadata(m4987d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0000\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008c\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a(\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008c\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a(\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008c\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\t\u001a\u00020\u0001*\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a(\u0010\u0000\u001a\u00020\n*\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0087\u008c\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a(\u0010\u0007\u001a\u00020\n*\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0087\u008c\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a(\u0010\b\u001a\u00020\n*\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0087\u008c\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\t\u001a\u00020\n*\u00020\nH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006¨\u0006\u000b"}, m4988d2 = {"and", BuildConfig.f24315FLAVOR, "other", "Lkotlin/SinceKotlin;", "version", "1.1", "Lkotlin/internal/InlineOnly;", "or", "xor", "inv", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class BitwiseOperationsKt {
    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: and */
    private static final byte m6134and(byte b, byte b2) {
        return (byte) (b & b2);
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: inv */
    private static final byte m6136inv(byte b) {
        return (byte) (~b);
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: or */
    private static final byte m6138or(byte b, byte b2) {
        return (byte) (b | b2);
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: xor */
    private static final byte m6140xor(byte b, byte b2) {
        return (byte) (b ^ b2);
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: and */
    private static final short m6135and(short s, short s2) {
        return (short) (s & s2);
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: inv */
    private static final short m6137inv(short s) {
        return (short) (~s);
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: or */
    private static final short m6139or(short s, short s2) {
        return (short) (s | s2);
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: xor */
    private static final short m6141xor(short s, short s2) {
        return (short) (s ^ s2);
    }
}
