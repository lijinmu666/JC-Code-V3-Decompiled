package p094kotlin.p110random;

import java.util.Random;
import org.conscrypt.BuildConfig;
import p094kotlin.IgnorableReturnValue;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0096\u0080\u0004J\n\u0010\u000b\u001a\u00020\tH\u0096\u0080\u0004J\u0012\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0096\u0080\u0004J\n\u0010\r\u001a\u00020\u000eH\u0096\u0080\u0004J\n\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0011\u001a\u00020\u0012H\u0096\u0080\u0004J\n\u0010\u0013\u001a\u00020\u0014H\u0096\u0080\u0004J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0097\u0080\bb\u0002\b\u0018R\u0013\u0010\u0004\u001a\u00020\u0005X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, m4988d2 = {"Lkotlin/random/AbstractPlatformRandom;", "Lkotlin/random/Random;", "<init>", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "nextBits", BuildConfig.f24315FLAVOR, "bitCount", "nextInt", "until", "nextLong", BuildConfig.f24315FLAVOR, "nextBoolean", BuildConfig.f24315FLAVOR, "nextDouble", BuildConfig.f24315FLAVOR, "nextFloat", BuildConfig.f24315FLAVOR, "nextBytes", BuildConfig.f24315FLAVOR, "array", "Lkotlin/IgnorableReturnValue;", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nPlatformRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformRandom.kt\nkotlin/random/AbstractPlatformRandom\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,94:1\n1#2:95\n*E\n"})
/* loaded from: classes.dex */
public abstract class AbstractPlatformRandom extends AbstractC1241Random {
    /* renamed from: getImpl */
    public abstract Random mo6434getImpl();

    @Override // p094kotlin.p110random.AbstractC1241Random
    public int nextBits(int bitCount) {
        return RandomKt.takeUpperBits(mo6434getImpl().nextInt(), bitCount);
    }

    @Override // p094kotlin.p110random.AbstractC1241Random
    public boolean nextBoolean() {
        return mo6434getImpl().nextBoolean();
    }

    @Override // p094kotlin.p110random.AbstractC1241Random
    @IgnorableReturnValue
    public byte[] nextBytes(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        mo6434getImpl().nextBytes(array);
        return array;
    }

    @Override // p094kotlin.p110random.AbstractC1241Random
    public double nextDouble() {
        return mo6434getImpl().nextDouble();
    }

    @Override // p094kotlin.p110random.AbstractC1241Random
    public float nextFloat() {
        return mo6434getImpl().nextFloat();
    }

    @Override // p094kotlin.p110random.AbstractC1241Random
    /* renamed from: nextInt */
    public int mo6435nextInt() {
        return mo6434getImpl().nextInt();
    }

    @Override // p094kotlin.p110random.AbstractC1241Random
    public long nextLong() {
        return mo6434getImpl().nextLong();
    }

    @Override // p094kotlin.p110random.AbstractC1241Random
    /* renamed from: nextInt */
    public int mo6436nextInt(int until) {
        return mo6434getImpl().nextInt(until);
    }
}
