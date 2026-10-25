package p094kotlin.p105jvm.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;

@Metadata(m4987d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\b\u001a\u00020\u0004*\u00020\u0002H\u0094\u0080\u0004J\u0012\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0080\u0004J\n\u0010\r\u001a\u00020\u0002H\u0086\u0080\u0004R\u000f\u0010\u0007\u001a\u00020\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m4988d2 = {"Lkotlin/jvm/internal/ByteSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", BuildConfig.f24315FLAVOR, "size", BuildConfig.f24315FLAVOR, "<init>", "(I)V", "values", "getSize", "add", BuildConfig.f24315FLAVOR, "value", BuildConfig.f24315FLAVOR, "toArray", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class ByteSpreadBuilder extends PrimitiveSpreadBuilder<byte[]> {
    private final byte[] values;

    public ByteSpreadBuilder(int i) {
        super(i);
        this.values = new byte[i];
    }

    /* renamed from: add */
    public final void m6287add(byte value) {
        byte[] bArr = this.values;
        int position = getPosition();
        setPosition(position + 1);
        bArr[position] = value;
    }

    /* renamed from: toArray */
    public final byte[] m6288toArray() {
        return m6332toArray(this.values, new byte[m6331size()]);
    }

    @Override // p094kotlin.p105jvm.internal.PrimitiveSpreadBuilder
    /* renamed from: getSize, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public int mo6285getSize(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr.length;
    }
}
