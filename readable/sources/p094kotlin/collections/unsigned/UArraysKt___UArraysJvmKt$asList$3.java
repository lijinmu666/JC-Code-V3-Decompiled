package p094kotlin.collections.unsigned;

import java.util.RandomAccess;
import org.conscrypt.BuildConfig;
import p094kotlin.C1126UByte;
import p094kotlin.Metadata;
import p094kotlin.UByteArray;
import p094kotlin.collections.AbstractList;
import p094kotlin.collections.ArraysKt;

@Metadata(m4987d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\n\u0010\t\u001a\u00020\nH\u0096\u0080\u0004J\u0019\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0006H\u0096\u0082\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\u0017\u0010\u0015R\u0015\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, m4988d2 = {"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$3", "Lkotlin/collections/AbstractList;", "Lkotlin/UByte;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", BuildConfig.f24315FLAVOR, "getSize", "()I", "isEmpty", BuildConfig.f24315FLAVOR, "contains", "element", "contains-7apg3OU", "(B)Z", "get", "index", "get-w2LRezQ", "(I)B", "indexOf", "indexOf-7apg3OU", "(B)I", "lastIndexOf", "lastIndexOf-7apg3OU", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class UArraysKt___UArraysJvmKt$asList$3 extends AbstractList<C1126UByte> implements RandomAccess {
    final /* synthetic */ byte[] $this_asList;

    public UArraysKt___UArraysJvmKt$asList$3(byte[] bArr) {
        this.$this_asList = bArr;
    }

    @Override // p094kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof C1126UByte) {
            return m19014contains7apg3OU(((C1126UByte) obj).getData());
        }
        return false;
    }

    /* renamed from: contains-7apg3OU, reason: not valid java name */
    public boolean m19014contains7apg3OU(byte element) {
        return UByteArray.m18618contains7apg3OU(this.$this_asList, element);
    }

    @Override // p094kotlin.collections.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int i) {
        return C1126UByte.m18558boximpl(m19015getw2LRezQ(i));
    }

    /* renamed from: get-w2LRezQ, reason: not valid java name */
    public byte m19015getw2LRezQ(int index) {
        return UByteArray.m18622getw2LRezQ(this.$this_asList, index);
    }

    @Override // p094kotlin.collections.AbstractList, p094kotlin.collections.AbstractCollection
    public int getSize() {
        return UByteArray.m18623getSizeimpl(this.$this_asList);
    }

    @Override // p094kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof C1126UByte) {
            return m19016indexOf7apg3OU(((C1126UByte) obj).getData());
        }
        return -1;
    }

    /* renamed from: indexOf-7apg3OU, reason: not valid java name */
    public int m19016indexOf7apg3OU(byte element) {
        return ArraysKt.m5429indexOf(this.$this_asList, element);
    }

    @Override // p094kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return UByteArray.m18625isEmptyimpl(this.$this_asList);
    }

    @Override // p094kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof C1126UByte) {
            return m19017lastIndexOf7apg3OU(((C1126UByte) obj).getData());
        }
        return -1;
    }

    /* renamed from: lastIndexOf-7apg3OU, reason: not valid java name */
    public int m19017lastIndexOf7apg3OU(byte element) {
        return ArraysKt.lastIndexOf(this.$this_asList, element);
    }
}
