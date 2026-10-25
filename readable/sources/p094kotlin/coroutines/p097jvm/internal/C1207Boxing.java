package p094kotlin.coroutines.p097jvm.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.SinceKotlin;
import p094kotlin.p105jvm.InterfaceC1231JvmName;

@Metadata(m4987d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007\u001a$\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\nH\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007\u001a$\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\rH\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007\u001a$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0010H\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007\u001a$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0013H\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007\u001a$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0016H\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007\u001a$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0019H\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007\u001a$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u001cH\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¨\u0006\u001d"}, m4988d2 = {"boxBoolean", "Ljava/lang/Boolean;", "primitive", BuildConfig.f24315FLAVOR, "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/PublishedApi;", "boxByte", "Ljava/lang/Byte;", BuildConfig.f24315FLAVOR, "boxShort", "Ljava/lang/Short;", BuildConfig.f24315FLAVOR, "boxInt", "Ljava/lang/Integer;", BuildConfig.f24315FLAVOR, "boxLong", "Ljava/lang/Long;", BuildConfig.f24315FLAVOR, "boxFloat", "Ljava/lang/Float;", BuildConfig.f24315FLAVOR, "boxDouble", "Ljava/lang/Double;", BuildConfig.f24315FLAVOR, "boxChar", "Ljava/lang/Character;", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "Boxing")
/* renamed from: kotlin.coroutines.jvm.internal.Boxing */
/* loaded from: classes.dex */
public final class C1207Boxing {
    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    public static final Boolean boxBoolean(boolean z) {
        return Boolean.valueOf(z);
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    /* renamed from: boxByte */
    public static final Byte m6119boxByte(byte b) {
        return Byte.valueOf(b);
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    /* renamed from: boxChar */
    public static final Character m6120boxChar(char c) {
        return new Character(c);
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    public static final Double boxDouble(double d) {
        return new Double(d);
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    public static final Float boxFloat(float f) {
        return new Float(f);
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    /* renamed from: boxInt */
    public static final Integer m6121boxInt(int i) {
        return new Integer(i);
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    /* renamed from: boxLong */
    public static final Long m6122boxLong(long j) {
        return new Long(j);
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    public static final Short boxShort(short s) {
        return new Short(s);
    }
}
