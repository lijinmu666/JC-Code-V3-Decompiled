package p132okio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import org.conscrypt.BuildConfig;
import p094kotlin.C1126UByte;
import p094kotlin.Metadata;
import p094kotlin.collections.AbstractList;
import p094kotlin.collections.ArraysKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.JvmStatic;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0016B!\b\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0096\u0002R\u001e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006X\u0080\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, m4988d2 = {"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "byteStrings", BuildConfig.f24315FLAVOR, "trie", BuildConfig.f24315FLAVOR, "<init>", "([Lokio/ByteString;[I)V", "getByteStrings$okio", "()[Lokio/ByteString;", "[Lokio/ByteString;", "getTrie$okio", "()[I", "size", BuildConfig.f24315FLAVOR, "getSize", "()I", "get", "index", "Companion", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* renamed from: okio.Options */
/* loaded from: classes.dex */
public final class C5054Options extends AbstractList<ByteString> implements RandomAccess {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ByteString[] byteStrings;
    private final int[] trie;

    @Metadata(m4987d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH\u0007¢\u0006\u0002\u0010\tJT\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0012H\u0002R\u0018\u0010\u0016\u001a\u00020\r*\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, m4988d2 = {"Lokio/Options$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "of", "Lokio/Options;", "byteStrings", BuildConfig.f24315FLAVOR, "Lokio/ByteString;", "([Lokio/ByteString;)Lokio/Options;", "buildTrieRecursive", BuildConfig.f24315FLAVOR, "nodeOffset", BuildConfig.f24315FLAVOR, "node", "Lokio/Buffer;", "byteStringOffset", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "fromIndex", "toIndex", "indexes", "intCount", "getIntCount", "(Lokio/Buffer;)J", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
    @SourceDebugExtension(m6344value = {"SMAP\nOptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Options.kt\nokio/Options$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,238:1\n1#2:239\n13537#3,3:240\n75#4:243\n75#4:244\n*S KotlinDebug\n*F\n+ 1 Options.kt\nokio/Options$Companion\n*L\n48#1:240,3\n153#1:243\n210#1:244\n*E\n"})
    /* renamed from: okio.Options$Companion, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void buildTrieRecursive(long nodeOffset, C5052Buffer node, int byteStringOffset, List<? extends ByteString> byteStrings, int fromIndex, int toIndex, List<Integer> indexes) {
            int i;
            int i2;
            int i3;
            int i4;
            C5052Buffer c5052Buffer;
            int i5 = byteStringOffset;
            if (fromIndex >= toIndex) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            for (int i6 = fromIndex; i6 < toIndex; i6++) {
                if (byteStrings.get(i6).m14252size() < i5) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
            ByteString byteString = byteStrings.get(fromIndex);
            ByteString byteString2 = byteStrings.get(toIndex - 1);
            int i7 = -1;
            if (i5 == byteString.m14252size()) {
                int iIntValue = indexes.get(fromIndex).intValue();
                int i8 = fromIndex + 1;
                ByteString byteString3 = byteStrings.get(i8);
                i = i8;
                i2 = iIntValue;
                byteString = byteString3;
            } else {
                i = fromIndex;
                i2 = -1;
            }
            if (byteString.m14242getByte(i5) == byteString2.m14242getByte(i5)) {
                int iMin = Math.min(byteString.m14252size(), byteString2.m14252size());
                int i9 = 0;
                for (int i10 = i5; i10 < iMin && byteString.m14242getByte(i10) == byteString2.m14242getByte(i10); i10++) {
                    i9++;
                }
                long intCount = nodeOffset + getIntCount(node) + 2 + i9 + 1;
                node.writeInt(-i9);
                node.writeInt(i2);
                int i11 = i9 + i5;
                while (i5 < i11) {
                    node.writeInt(byteString.m14242getByte(i5) & C1126UByte.MAX_VALUE);
                    i5++;
                }
                if (i + 1 == toIndex) {
                    if (i11 != byteStrings.get(i).m14252size()) {
                        throw new IllegalStateException("Check failed.");
                    }
                    node.writeInt(indexes.get(i).intValue());
                    return;
                } else {
                    C5052Buffer c5052Buffer2 = new C5052Buffer();
                    node.writeInt(((int) (getIntCount(c5052Buffer2) + intCount)) * (-1));
                    buildTrieRecursive(intCount, c5052Buffer2, i11, byteStrings, i, toIndex, indexes);
                    node.writeAll(c5052Buffer2);
                    return;
                }
            }
            int i12 = 1;
            for (int i13 = i + 1; i13 < toIndex; i13++) {
                if (byteStrings.get(i13 - 1).m14242getByte(i5) != byteStrings.get(i13).m14242getByte(i5)) {
                    i12++;
                }
            }
            long intCount2 = nodeOffset + getIntCount(node) + 2 + (i12 * 2);
            node.writeInt(i12);
            node.writeInt(i2);
            for (int i14 = i; i14 < toIndex; i14++) {
                byte bM14242getByte = byteStrings.get(i14).m14242getByte(i5);
                if (i14 == i || bM14242getByte != byteStrings.get(i14 - 1).m14242getByte(i5)) {
                    node.writeInt(bM14242getByte & C1126UByte.MAX_VALUE);
                }
            }
            C5052Buffer c5052Buffer3 = new C5052Buffer();
            while (i < toIndex) {
                byte bM14242getByte2 = byteStrings.get(i).m14242getByte(i5);
                int i15 = i + 1;
                int i16 = i15;
                while (true) {
                    if (i16 >= toIndex) {
                        i3 = toIndex;
                        break;
                    } else {
                        if (bM14242getByte2 != byteStrings.get(i16).m14242getByte(i5)) {
                            i3 = i16;
                            break;
                        }
                        i16++;
                    }
                }
                if (i15 == i3 && i5 + 1 == byteStrings.get(i).m14252size()) {
                    node.writeInt(indexes.get(i).intValue());
                    i4 = i3;
                    c5052Buffer = c5052Buffer3;
                } else {
                    node.writeInt(((int) (intCount2 + getIntCount(c5052Buffer3))) * i7);
                    i4 = i3;
                    c5052Buffer = c5052Buffer3;
                    buildTrieRecursive(intCount2, c5052Buffer3, i5 + 1, byteStrings, i, i3, indexes);
                }
                c5052Buffer3 = c5052Buffer;
                i = i4;
                i7 = -1;
            }
            node.writeAll(c5052Buffer3);
        }

        public static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j, C5052Buffer c5052Buffer, int i, List list, int i2, int i3, List list2, int i4, Object obj) {
            companion.buildTrieRecursive((i4 & 1) != 0 ? 0L : j, c5052Buffer, (i4 & 4) != 0 ? 0 : i, list, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? list.size() : i3, list2);
        }

        private final long getIntCount(C5052Buffer c5052Buffer) {
            return c5052Buffer.m14225size() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:43:0x00cc, code lost:
        
            continue;
         */
        @JvmStatic
        /* renamed from: of */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final C5054Options m14345of(ByteString... byteStrings) {
            Intrinsics.checkNotNullParameter(byteStrings, "byteStrings");
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (byteStrings.length == 0) {
                return new C5054Options(new ByteString[0], new int[]{0, -1}, defaultConstructorMarker);
            }
            List mutableList = ArraysKt.toMutableList(byteStrings);
            CollectionsKt.m5815sort(mutableList);
            int size = mutableList.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList.add(-1);
            }
            int length = byteStrings.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                arrayList.set(CollectionsKt.binarySearch$default(mutableList, byteStrings[i2], 0, 0, 6, (Object) null), Integer.valueOf(i3));
                i2++;
                i3++;
            }
            if (((ByteString) mutableList.get(0)).m14252size() <= 0) {
                throw new IllegalArgumentException("the empty byte string is not a supported option");
            }
            int i4 = 0;
            while (i4 < mutableList.size()) {
                ByteString byteString = (ByteString) mutableList.get(i4);
                int i5 = i4 + 1;
                int i6 = i5;
                while (i6 < mutableList.size()) {
                    ByteString byteString2 = (ByteString) mutableList.get(i6);
                    if (byteString2.startsWith(byteString)) {
                        if (byteString2.m14252size() == byteString.m14252size()) {
                            throw new IllegalArgumentException(("duplicate option: " + byteString2).toString());
                        }
                        if (((Number) arrayList.get(i6)).intValue() > ((Number) arrayList.get(i4)).intValue()) {
                            mutableList.remove(i6);
                            ((Number) arrayList.remove(i6)).intValue();
                        } else {
                            i6++;
                        }
                    }
                }
                i4 = i5;
            }
            C5052Buffer c5052Buffer = new C5052Buffer();
            buildTrieRecursive$default(this, 0L, c5052Buffer, 0, mutableList, 0, 0, arrayList, 53, null);
            int intCount = (int) getIntCount(c5052Buffer);
            int[] iArr = new int[intCount];
            for (int i7 = 0; i7 < intCount; i7++) {
                iArr[i7] = c5052Buffer.mo14217readInt();
            }
            Object[] objArrCopyOf = Arrays.copyOf(byteStrings, byteStrings.length);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            return new C5054Options((ByteString[]) objArrCopyOf, iArr, defaultConstructorMarker);
        }

        private Companion() {
        }
    }

    public /* synthetic */ C5054Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    @JvmStatic
    /* renamed from: of */
    public static final C5054Options m14343of(ByteString... byteStringArr) {
        return INSTANCE.m14345of(byteStringArr);
    }

    @Override // p094kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    /* renamed from: getByteStrings$okio, reason: from getter */
    public final ByteString[] getByteStrings() {
        return this.byteStrings;
    }

    @Override // p094kotlin.collections.AbstractList, p094kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int get_size() {
        return this.byteStrings.length;
    }

    /* renamed from: getTrie$okio, reason: from getter */
    public final int[] getTrie() {
        return this.trie;
    }

    @Override // p094kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return m14344indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // p094kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    private C5054Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains((Object) byteString);
    }

    @Override // p094kotlin.collections.AbstractList, java.util.List
    public ByteString get(int index) {
        return this.byteStrings[index];
    }

    /* renamed from: indexOf */
    public /* bridge */ int m14344indexOf(ByteString byteString) {
        return super.indexOf((Object) byteString);
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf((Object) byteString);
    }
}
