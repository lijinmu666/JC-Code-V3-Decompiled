package p094kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import org.conscrypt.BuildConfig;
import p094kotlin.C1126UByte;
import p094kotlin.C1128UInt;
import p094kotlin.C1130ULong;
import p094kotlin.C1132UShort;
import p094kotlin.ExperimentalUnsignedTypes;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.UByteArray;
import p094kotlin.UIntArray;
import p094kotlin.ULongArray;
import p094kotlin.UShortArray;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a+\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0002\u0010\u0004\u001a+\u0010\t\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0002\u0010\f\u001a+\u0010\r\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\u000f0\u0002H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0002\u0010\u0010\u001a+\u0010\u0011\u001a\u00020\u0012*\b\u0012\u0004\u0012\u00020\u00130\u0002H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0002\u0010\u0014\u001a7\u0010\u0015\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0087\u0080\u0004b\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0017b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001b¢\u0006\u0004\b\u0017\u0010\u0018\u001a7\u0010\u0015\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u000f0\u0016H\u0087\u0080\u0004b\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001cb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001b¢\u0006\u0004\b\u001c\u0010\u001d\u001a7\u0010\u0015\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0087\u0080\u0004b\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001eb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001b¢\u0006\u0004\b\u001e\u0010\u0018\u001a7\u0010\u0015\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00130\u0016H\u0087\u0080\u0004b\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001fb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001b¢\u0006\u0004\b\u001f\u0010\u0018¨\u0006 "}, m4988d2 = {"toUByteArray", "Lkotlin/UByteArray;", BuildConfig.f24315FLAVOR, "Lkotlin/UByte;", "(Ljava/util/Collection;)[B", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/ExperimentalUnsignedTypes;", "toUIntArray", "Lkotlin/UIntArray;", "Lkotlin/UInt;", "(Ljava/util/Collection;)[I", "toULongArray", "Lkotlin/ULongArray;", "Lkotlin/ULong;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lkotlin/UShortArray;", "Lkotlin/UShort;", "(Ljava/util/Collection;)[S", "sum", BuildConfig.f24315FLAVOR, "sumOfUInt", "(Ljava/lang/Iterable;)I", "Lkotlin/jvm/JvmName;", "name", "1.5", "sumOfULong", "(Ljava/lang/Iterable;)J", "sumOfUByte", "sumOfUShort", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/collections/UCollectionsKt")
/* loaded from: classes.dex */
class UCollectionsKt___UCollectionsKt {
    @SinceKotlin(m5061version = "1.5")
    @InterfaceC1231JvmName(m6260name = "sumOfUByte")
    public static final int sumOfUByte(Iterable<C1126UByte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<C1126UByte> it = iterable.iterator();
        int iM18641constructorimpl = 0;
        while (it.hasNext()) {
            iM18641constructorimpl = C1128UInt.m18641constructorimpl(iM18641constructorimpl + C1128UInt.m18641constructorimpl(it.next().getData() & C1126UByte.MAX_VALUE));
        }
        return iM18641constructorimpl;
    }

    @SinceKotlin(m5061version = "1.5")
    @InterfaceC1231JvmName(m6260name = "sumOfUInt")
    public static final int sumOfUInt(Iterable<C1128UInt> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<C1128UInt> it = iterable.iterator();
        int iM18641constructorimpl = 0;
        while (it.hasNext()) {
            iM18641constructorimpl = C1128UInt.m18641constructorimpl(iM18641constructorimpl + it.next().getData());
        }
        return iM18641constructorimpl;
    }

    @SinceKotlin(m5061version = "1.5")
    @InterfaceC1231JvmName(m6260name = "sumOfULong")
    public static final long sumOfULong(Iterable<C1130ULong> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<C1130ULong> it = iterable.iterator();
        long jM18720constructorimpl = 0;
        while (it.hasNext()) {
            jM18720constructorimpl = C1130ULong.m18720constructorimpl(jM18720constructorimpl + it.next().getData());
        }
        return jM18720constructorimpl;
    }

    @SinceKotlin(m5061version = "1.5")
    @InterfaceC1231JvmName(m6260name = "sumOfUShort")
    public static final int sumOfUShort(Iterable<C1132UShort> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<C1132UShort> it = iterable.iterator();
        int iM18641constructorimpl = 0;
        while (it.hasNext()) {
            iM18641constructorimpl = C1128UInt.m18641constructorimpl(iM18641constructorimpl + C1128UInt.m18641constructorimpl(it.next().getData() & 65535));
        }
        return iM18641constructorimpl;
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    public static final byte[] toUByteArray(Collection<C1126UByte> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        byte[] bArrM18616constructorimpl = UByteArray.m18616constructorimpl(collection.size());
        Iterator<C1126UByte> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            UByteArray.m18627setVurrAj0(bArrM18616constructorimpl, i, it.next().getData());
            i++;
        }
        return bArrM18616constructorimpl;
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int[] toUIntArray(Collection<C1128UInt> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] iArrM18695constructorimpl = UIntArray.m18695constructorimpl(collection.size());
        Iterator<C1128UInt> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            UIntArray.m18706setVXSXFK8(iArrM18695constructorimpl, i, it.next().getData());
            i++;
        }
        return iArrM18695constructorimpl;
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long[] toULongArray(Collection<C1130ULong> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] jArrM18774constructorimpl = ULongArray.m18774constructorimpl(collection.size());
        Iterator<C1130ULong> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            ULongArray.m18785setk8EXiF4(jArrM18774constructorimpl, i, it.next().getData());
            i++;
        }
        return jArrM18774constructorimpl;
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    public static final short[] toUShortArray(Collection<C1132UShort> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        short[] sArrM18879constructorimpl = UShortArray.m18879constructorimpl(collection.size());
        Iterator<C1132UShort> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            UShortArray.m18890set01HTLdE(sArrM18879constructorimpl, i, it.next().getData());
            i++;
        }
        return sArrM18879constructorimpl;
    }
}
