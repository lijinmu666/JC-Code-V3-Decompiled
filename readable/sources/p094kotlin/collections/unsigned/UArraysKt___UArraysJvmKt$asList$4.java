package p094kotlin.collections.unsigned;

import java.util.RandomAccess;
import org.conscrypt.BuildConfig;
import p094kotlin.C1132UShort;
import p094kotlin.Metadata;
import p094kotlin.UShortArray;
import p094kotlin.collections.AbstractList;
import p094kotlin.collections.ArraysKt;

@Metadata(m4987d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\n\u0010\t\u001a\u00020\nH\u0096\u0080\u0004J\u0019\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0006H\u0096\u0082\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\u0017\u0010\u0015R\u0015\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, m4988d2 = {"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$4", "Lkotlin/collections/AbstractList;", "Lkotlin/UShort;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", BuildConfig.f24315FLAVOR, "getSize", "()I", "isEmpty", BuildConfig.f24315FLAVOR, "contains", "element", "contains-xj2QHRw", "(S)Z", "get", "index", "get-Mh2AYeg", "(I)S", "indexOf", "indexOf-xj2QHRw", "(S)I", "lastIndexOf", "lastIndexOf-xj2QHRw", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class UArraysKt___UArraysJvmKt$asList$4 extends AbstractList<C1132UShort> implements RandomAccess {
    final /* synthetic */ short[] $this_asList;

    public UArraysKt___UArraysJvmKt$asList$4(short[] sArr) {
        this.$this_asList = sArr;
    }

    @Override // p094kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof C1132UShort) {
            return m19018containsxj2QHRw(((C1132UShort) obj).getData());
        }
        return false;
    }

    /* renamed from: contains-xj2QHRw, reason: not valid java name */
    public boolean m19018containsxj2QHRw(short element) {
        return UShortArray.m18881containsxj2QHRw(this.$this_asList, element);
    }

    @Override // p094kotlin.collections.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int i) {
        return C1132UShort.m18821boximpl(m19019getMh2AYeg(i));
    }

    /* renamed from: get-Mh2AYeg, reason: not valid java name */
    public short m19019getMh2AYeg(int index) {
        return UShortArray.m18885getMh2AYeg(this.$this_asList, index);
    }

    @Override // p094kotlin.collections.AbstractList, p094kotlin.collections.AbstractCollection
    public int getSize() {
        return UShortArray.m18886getSizeimpl(this.$this_asList);
    }

    @Override // p094kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof C1132UShort) {
            return m19020indexOfxj2QHRw(((C1132UShort) obj).getData());
        }
        return -1;
    }

    /* renamed from: indexOf-xj2QHRw, reason: not valid java name */
    public int m19020indexOfxj2QHRw(short element) {
        return ArraysKt.m5436indexOf(this.$this_asList, element);
    }

    @Override // p094kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return UShortArray.m18888isEmptyimpl(this.$this_asList);
    }

    @Override // p094kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof C1132UShort) {
            return m19021lastIndexOfxj2QHRw(((C1132UShort) obj).getData());
        }
        return -1;
    }

    /* renamed from: lastIndexOf-xj2QHRw, reason: not valid java name */
    public int m19021lastIndexOfxj2QHRw(short element) {
        return ArraysKt.lastIndexOf(this.$this_asList, element);
    }
}
