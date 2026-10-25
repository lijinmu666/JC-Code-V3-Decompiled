package p094kotlin.sequences;

import java.util.Iterator;
import p094kotlin.C1126UByte;
import p094kotlin.C1128UInt;
import p094kotlin.C1130ULong;
import p094kotlin.C1132UShort;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0003b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0004\b\u0003\u0010\u0004\u001a7\u0010\u0000\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0004\b\u000b\u0010\f\u001a7\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\r0\u0002H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000eb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0004\b\u000e\u0010\u0004\u001a7\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u000f0\u0002H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0010b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0004\b\u0010\u0010\u0004¨\u0006\u0011"}, m4988d2 = {"sum", "Lkotlin/UInt;", "Lkotlin/sequences/Sequence;", "sumOfUInt", "(Lkotlin/sequences/Sequence;)I", "Lkotlin/jvm/JvmName;", "name", "Lkotlin/SinceKotlin;", "version", "1.5", "Lkotlin/ULong;", "sumOfULong", "(Lkotlin/sequences/Sequence;)J", "Lkotlin/UByte;", "sumOfUByte", "Lkotlin/UShort;", "sumOfUShort", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/sequences/USequencesKt")
/* loaded from: classes.dex */
class USequencesKt___USequencesKt {
    @SinceKotlin(m5061version = "1.5")
    @InterfaceC1231JvmName(m6260name = "sumOfUByte")
    public static final int sumOfUByte(Sequence<C1126UByte> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<C1126UByte> it = sequence.iterator();
        int iM18641constructorimpl = 0;
        while (it.hasNext()) {
            iM18641constructorimpl = C1128UInt.m18641constructorimpl(iM18641constructorimpl + C1128UInt.m18641constructorimpl(it.next().getData() & C1126UByte.MAX_VALUE));
        }
        return iM18641constructorimpl;
    }

    @SinceKotlin(m5061version = "1.5")
    @InterfaceC1231JvmName(m6260name = "sumOfUInt")
    public static final int sumOfUInt(Sequence<C1128UInt> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<C1128UInt> it = sequence.iterator();
        int iM18641constructorimpl = 0;
        while (it.hasNext()) {
            iM18641constructorimpl = C1128UInt.m18641constructorimpl(iM18641constructorimpl + it.next().getData());
        }
        return iM18641constructorimpl;
    }

    @SinceKotlin(m5061version = "1.5")
    @InterfaceC1231JvmName(m6260name = "sumOfULong")
    public static final long sumOfULong(Sequence<C1130ULong> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<C1130ULong> it = sequence.iterator();
        long jM18720constructorimpl = 0;
        while (it.hasNext()) {
            jM18720constructorimpl = C1130ULong.m18720constructorimpl(jM18720constructorimpl + it.next().getData());
        }
        return jM18720constructorimpl;
    }

    @SinceKotlin(m5061version = "1.5")
    @InterfaceC1231JvmName(m6260name = "sumOfUShort")
    public static final int sumOfUShort(Sequence<C1132UShort> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<C1132UShort> it = sequence.iterator();
        int iM18641constructorimpl = 0;
        while (it.hasNext()) {
            iM18641constructorimpl = C1128UInt.m18641constructorimpl(iM18641constructorimpl + C1128UInt.m18641constructorimpl(it.next().getData() & 65535));
        }
        return iM18641constructorimpl;
    }
}
