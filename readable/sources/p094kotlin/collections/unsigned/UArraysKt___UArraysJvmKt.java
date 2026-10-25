package p094kotlin.collections.unsigned;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.C1126UByte;
import p094kotlin.C1128UInt;
import p094kotlin.C1130ULong;
import p094kotlin.C1132UShort;
import p094kotlin.Deprecated;
import p094kotlin.DeprecatedSinceKotlin;
import p094kotlin.ExperimentalUnsignedTypes;
import p094kotlin.Metadata;
import p094kotlin.OverloadResolutionByLambdaReturnType;
import p094kotlin.ReplaceWith;
import p094kotlin.SinceKotlin;
import p094kotlin.UByteArray;
import p094kotlin.UIntArray;
import p094kotlin.ULongArray;
import p094kotlin.UShortArray;
import p094kotlin.UnsignedKt;
import p094kotlin.collections.AbstractList;
import p094kotlin.collections.ArraysKt;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000b¢\u0006\u0004\b\u0005\u0010\u0006\u001a3\u0010\u0000\u001a\u00020\f*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000b¢\u0006\u0004\b\u000e\u0010\u000f\u001a3\u0010\u0000\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000b¢\u0006\u0004\b\u0012\u0010\u0013\u001a3\u0010\u0000\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000b¢\u0006\u0004\b\u0016\u0010\u0017\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0019*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b\u001a\u0010\u001b\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0019*\u00020\rH\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b\u001c\u0010\u001d\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019*\u00020\u0011H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b\u001e\u0010\u001f\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u0019*\u00020\u0015H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b \u0010!\u001aC\u0010\"\u001a\u00020\u0004*\u00020\u00022\u0006\u0010#\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b&\u0010'\u001aC\u0010\"\u001a\u00020\u0004*\u00020\r2\u0006\u0010#\u001a\u00020\f2\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b(\u0010)\u001aC\u0010\"\u001a\u00020\u0004*\u00020\u00112\u0006\u0010#\u001a\u00020\u00102\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b*\u0010+\u001aC\u0010\"\u001a\u00020\u0004*\u00020\u00152\u0006\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b,\u0010-\u001aw\u0010.\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b/\u00100\u001aw\u0010.\u001a\u0004\u0018\u00010\f*\u00020\rH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b@\u0010A\u001aw\u0010.\u001a\u0004\u0018\u00010\u0010*\u00020\u0011H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bB\u0010C\u001aw\u0010.\u001a\u0004\u0018\u00010\u0014*\u00020\u0015H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bD\u0010E\u001a¢\u0001\u0010F\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00022\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(M\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(N\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001a¢\u0001\u0010F\u001a\u0004\u0018\u00010\f\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\r2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(M\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(N\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bO\u0010P\u001a¢\u0001\u0010F\u001a\u0004\u0018\u00010\u0010\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00112\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(M\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(N\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bQ\u0010R\u001a¢\u0001\u0010F\u001a\u0004\u0018\u00010\u0014\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00152\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(M\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(N\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a\u0093\u0001\u0010U\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0001`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b([\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(\\\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bY\u0010Z\u001a\u0093\u0001\u0010U\u001a\u0004\u0018\u00010\f*\u00020\r2\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\f0Wj\n\u0012\u0006\b\u0000\u0012\u00020\f`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b([\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(\\\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b]\u0010^\u001a\u0093\u0001\u0010U\u001a\u0004\u0018\u00010\u0010*\u00020\u00112\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00100Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0010`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b([\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(\\\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b_\u0010`\u001a\u0093\u0001\u0010U\u001a\u0004\u0018\u00010\u0014*\u00020\u00152\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00140Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0014`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b([\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(\\\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\ba\u0010b\u001aw\u0010c\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(e\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(f\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bd\u00100\u001aw\u0010c\u001a\u0004\u0018\u00010\f*\u00020\rH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(e\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(f\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bg\u0010A\u001aw\u0010c\u001a\u0004\u0018\u00010\u0010*\u00020\u0011H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(e\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(f\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bh\u0010C\u001aw\u0010c\u001a\u0004\u0018\u00010\u0014*\u00020\u0015H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(e\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(f\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bi\u0010E\u001a¢\u0001\u0010j\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00022\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(l\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(m\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bk\u0010L\u001a¢\u0001\u0010j\u001a\u0004\u0018\u00010\f\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\r2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(l\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(m\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bn\u0010P\u001a¢\u0001\u0010j\u001a\u0004\u0018\u00010\u0010\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00112\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(l\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(m\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bo\u0010R\u001a¢\u0001\u0010j\u001a\u0004\u0018\u00010\u0014\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00152\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(l\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(m\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bp\u0010T\u001a\u0093\u0001\u0010q\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0001`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(s\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(t\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\br\u0010Z\u001a\u0093\u0001\u0010q\u001a\u0004\u0018\u00010\f*\u00020\r2\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\f0Wj\n\u0012\u0006\b\u0000\u0012\u00020\f`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(s\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(t\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bu\u0010^\u001a\u0093\u0001\u0010q\u001a\u0004\u0018\u00010\u0010*\u00020\u00112\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00100Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0010`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(s\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(t\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bv\u0010`\u001a\u0093\u0001\u0010q\u001a\u0004\u0018\u00010\u0014*\u00020\u00152\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00140Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0014`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(s\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(t\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bw\u0010b\u001aT\u0010x\u001a\u00020y*\u00020\u00022\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020y0JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\f\b}\u0012\b\b~\u0012\u0004\b\b(zb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bz\u0010{\u001aT\u0010x\u001a\u00020y*\u00020\r2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020y0JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\f\b}\u0012\b\b~\u0012\u0004\b\b(zb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bz\u0010\u007f\u001aU\u0010x\u001a\u00020y*\u00020\u00112\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020y0JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\f\b}\u0012\b\b~\u0012\u0004\b\b(zb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0005\bz\u0010\u0080\u0001\u001aU\u0010x\u001a\u00020y*\u00020\u00152\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020y0JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\f\b}\u0012\b\b~\u0012\u0004\b\b(zb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0005\bz\u0010\u0081\u0001\u001aY\u0010x\u001a\u00030\u0082\u0001*\u00020\u00022\u0013\u0010I\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0012\u0005\u0012\u00030\u0082\u00010JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0083\u0001b\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001\u001aY\u0010x\u001a\u00030\u0082\u0001*\u00020\r2\u0013\u0010I\u001a\u000f\u0012\u0004\u0012\u00020\f\u0012\u0005\u0012\u00030\u0082\u00010JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0083\u0001b\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0085\u0001\u001aY\u0010x\u001a\u00030\u0082\u0001*\u00020\u00112\u0013\u0010I\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0005\u0012\u00030\u0082\u00010JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0083\u0001b\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0086\u0001\u001aY\u0010x\u001a\u00030\u0082\u0001*\u00020\u00152\u0013\u0010I\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0005\u0012\u00030\u0082\u00010JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0083\u0001b\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0087\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0088\u0001"}, m4988d2 = {"elementAt", "Lkotlin/UInt;", "Lkotlin/UIntArray;", "index", BuildConfig.f24315FLAVOR, "elementAt-qFRl0hI", "([II)I", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/ExperimentalUnsignedTypes;", "Lkotlin/internal/InlineOnly;", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "elementAt-r7IrZao", "([JI)J", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "elementAt-PpDY95g", "([BI)B", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "elementAt-nggk6HY", "([SI)S", "asList", BuildConfig.f24315FLAVOR, "asList--ajY-9A", "([I)Ljava/util/List;", "asList-QwZRm1k", "([J)Ljava/util/List;", "asList-GBYM_sE", "([B)Ljava/util/List;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "element", "fromIndex", "toIndex", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-EtDCXyQ", "([SSII)I", "max", "max--ajY-9A", "([I)Lkotlin/UInt;", "Lkotlin/Deprecated;", "message", "Use maxOrNull instead.", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "this.maxOrNull()", "imports", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "1.4", "errorSince", "1.5", "hiddenSince", "1.6", "max-QwZRm1k", "([J)Lkotlin/ULong;", "max-GBYM_sE", "([B)Lkotlin/UByte;", "max-rL5Bavg", "([S)Lkotlin/UShort;", "maxBy", "R", BuildConfig.f24315FLAVOR, "selector", "Lkotlin/Function1;", "maxBy-jgv0xPQ", "([ILkotlin/jvm/functions/Function1;)Lkotlin/UInt;", "Use maxByOrNull instead.", "this.maxByOrNull(selector)", "maxBy-MShoTSo", "([JLkotlin/jvm/functions/Function1;)Lkotlin/ULong;", "maxBy-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)Lkotlin/UByte;", "maxBy-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)Lkotlin/UShort;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "maxWith-YmdZ_VM", "([ILjava/util/Comparator;)Lkotlin/UInt;", "Use maxWithOrNull instead.", "this.maxWithOrNull(comparator)", "maxWith-zrEWJaI", "([JLjava/util/Comparator;)Lkotlin/ULong;", "maxWith-XMRcp5o", "([BLjava/util/Comparator;)Lkotlin/UByte;", "maxWith-eOHTfZs", "([SLjava/util/Comparator;)Lkotlin/UShort;", "min", "min--ajY-9A", "Use minOrNull instead.", "this.minOrNull()", "min-QwZRm1k", "min-GBYM_sE", "min-rL5Bavg", "minBy", "minBy-jgv0xPQ", "Use minByOrNull instead.", "this.minByOrNull(selector)", "minBy-MShoTSo", "minBy-JOV_ifY", "minBy-xTcfx_M", "minWith", "minWith-YmdZ_VM", "Use minWithOrNull instead.", "this.minWithOrNull(comparator)", "minWith-zrEWJaI", "minWith-XMRcp5o", "minWith-eOHTfZs", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Lkotlin/OverloadResolutionByLambdaReturnType;", "Lkotlin/jvm/JvmName;", "name", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4991pn = "kotlin.collections", m4992xi = 49, m4993xs = "kotlin/collections/unsigned/UArraysKt")
/* loaded from: classes.dex */
class UArraysKt___UArraysJvmKt {
    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: asList--ajY-9A, reason: not valid java name */
    public static final List<C1128UInt> m18966asListajY9A(int[] asList) {
        Intrinsics.checkNotNullParameter(asList, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$1(asList);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: asList-GBYM_sE, reason: not valid java name */
    public static final List<C1126UByte> m18967asListGBYM_sE(byte[] asList) {
        Intrinsics.checkNotNullParameter(asList, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$3(asList);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: asList-QwZRm1k, reason: not valid java name */
    public static final List<C1130ULong> m18968asListQwZRm1k(long[] asList) {
        Intrinsics.checkNotNullParameter(asList, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$2(asList);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: asList-rL5Bavg, reason: not valid java name */
    public static final List<C1132UShort> m18969asListrL5Bavg(short[] asList) {
        Intrinsics.checkNotNullParameter(asList, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$4(asList);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: binarySearch-2fe2U9s, reason: not valid java name */
    public static final int m18970binarySearch2fe2U9s(int[] binarySearch, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(binarySearch, "$this$binarySearch");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i2, i3, UIntArray.m18702getSizeimpl(binarySearch));
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int iUintCompare = UnsignedKt.uintCompare(binarySearch[i5], i);
            if (iUintCompare < 0) {
                i2 = i5 + 1;
            } else {
                if (iUintCompare <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* renamed from: binarySearch-2fe2U9s$default, reason: not valid java name */
    public static /* synthetic */ int m18971binarySearch2fe2U9s$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UIntArray.m18702getSizeimpl(iArr);
        }
        return m18970binarySearch2fe2U9s(iArr, i, i2, i3);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: binarySearch-EtDCXyQ, reason: not valid java name */
    public static final int m18972binarySearchEtDCXyQ(short[] binarySearch, short s, int i, int i2) {
        Intrinsics.checkNotNullParameter(binarySearch, "$this$binarySearch");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, UShortArray.m18886getSizeimpl(binarySearch));
        int i3 = s & 65535;
        int i4 = i2 - 1;
        while (i <= i4) {
            int i5 = (i + i4) >>> 1;
            int iUintCompare = UnsignedKt.uintCompare(binarySearch[i5], i3);
            if (iUintCompare < 0) {
                i = i5 + 1;
            } else {
                if (iUintCompare <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: binarySearch-EtDCXyQ$default, reason: not valid java name */
    public static /* synthetic */ int m18973binarySearchEtDCXyQ$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m18886getSizeimpl(sArr);
        }
        return m18972binarySearchEtDCXyQ(sArr, s, i, i2);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: binarySearch-K6DWlUc, reason: not valid java name */
    public static final int m18974binarySearchK6DWlUc(long[] binarySearch, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(binarySearch, "$this$binarySearch");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, ULongArray.m18781getSizeimpl(binarySearch));
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int iUlongCompare = UnsignedKt.ulongCompare(binarySearch[i4], j);
            if (iUlongCompare < 0) {
                i = i4 + 1;
            } else {
                if (iUlongCompare <= 0) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: binarySearch-K6DWlUc$default, reason: not valid java name */
    public static /* synthetic */ int m18975binarySearchK6DWlUc$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m18781getSizeimpl(jArr);
        }
        return m18974binarySearchK6DWlUc(jArr, j, i, i2);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: binarySearch-WpHrYlw, reason: not valid java name */
    public static final int m18976binarySearchWpHrYlw(byte[] binarySearch, byte b, int i, int i2) {
        Intrinsics.checkNotNullParameter(binarySearch, "$this$binarySearch");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, UByteArray.m18623getSizeimpl(binarySearch));
        int i3 = b & C1126UByte.MAX_VALUE;
        int i4 = i2 - 1;
        while (i <= i4) {
            int i5 = (i + i4) >>> 1;
            int iUintCompare = UnsignedKt.uintCompare(binarySearch[i5], i3);
            if (iUintCompare < 0) {
                i = i5 + 1;
            } else {
                if (iUintCompare <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: binarySearch-WpHrYlw$default, reason: not valid java name */
    public static /* synthetic */ int m18977binarySearchWpHrYlw$default(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m18623getSizeimpl(bArr);
        }
        return m18976binarySearchWpHrYlw(bArr, b, i, i2);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: elementAt-PpDY95g, reason: not valid java name */
    private static final byte m18978elementAtPpDY95g(byte[] elementAt, int i) {
        Intrinsics.checkNotNullParameter(elementAt, "$this$elementAt");
        return UByteArray.m18622getw2LRezQ(elementAt, i);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: elementAt-nggk6HY, reason: not valid java name */
    private static final short m18979elementAtnggk6HY(short[] elementAt, int i) {
        Intrinsics.checkNotNullParameter(elementAt, "$this$elementAt");
        return UShortArray.m18885getMh2AYeg(elementAt, i);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: elementAt-qFRl0hI, reason: not valid java name */
    private static final int m18980elementAtqFRl0hI(int[] elementAt, int i) {
        Intrinsics.checkNotNullParameter(elementAt, "$this$elementAt");
        return UIntArray.m18701getpVg5ArA(elementAt, i);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: elementAt-r7IrZao, reason: not valid java name */
    private static final long m18981elementAtr7IrZao(long[] elementAt, int i) {
        Intrinsics.checkNotNullParameter(elementAt, "$this$elementAt");
        return ULongArray.m18780getsVKNKU(elementAt, i);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(m4972message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max--ajY-9A, reason: not valid java name */
    public static final /* synthetic */ C1128UInt m18982maxajY9A(int[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        return UArraysKt___UArraysKt.m19374maxOrNullajY9A(max);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(m4972message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max-GBYM_sE, reason: not valid java name */
    public static final /* synthetic */ C1126UByte m18983maxGBYM_sE(byte[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        return UArraysKt___UArraysKt.m19375maxOrNullGBYM_sE(max);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(m4972message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max-QwZRm1k, reason: not valid java name */
    public static final /* synthetic */ C1130ULong m18984maxQwZRm1k(long[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        return UArraysKt___UArraysKt.m19376maxOrNullQwZRm1k(max);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(m4972message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max-rL5Bavg, reason: not valid java name */
    public static final /* synthetic */ C1132UShort m18985maxrL5Bavg(short[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        return UArraysKt___UArraysKt.m19377maxOrNullrL5Bavg(max);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(m4972message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxBy-JOV_ifY, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> C1126UByte m18986maxByJOV_ifY(byte[] maxBy, Function1<? super C1126UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxBy, "$this$maxBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m18625isEmptyimpl(maxBy)) {
            return null;
        }
        byte bM18622getw2LRezQ = UByteArray.m18622getw2LRezQ(maxBy, 0);
        int lastIndex = ArraysKt.getLastIndex(maxBy);
        if (lastIndex != 0) {
            R rMo2237invoke = selector.mo2237invoke(C1126UByte.m18558boximpl(bM18622getw2LRezQ));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    byte bM18622getw2LRezQ2 = UByteArray.m18622getw2LRezQ(maxBy, i);
                    R rMo2237invoke2 = selector.mo2237invoke(C1126UByte.m18558boximpl(bM18622getw2LRezQ2));
                    if (rMo2237invoke.compareTo(rMo2237invoke2) < 0) {
                        bM18622getw2LRezQ = bM18622getw2LRezQ2;
                        rMo2237invoke = rMo2237invoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return C1126UByte.m18558boximpl(bM18622getw2LRezQ);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(m4972message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxBy-MShoTSo, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> C1130ULong m18987maxByMShoTSo(long[] maxBy, Function1<? super C1130ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxBy, "$this$maxBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m18783isEmptyimpl(maxBy)) {
            return null;
        }
        long jM18780getsVKNKU = ULongArray.m18780getsVKNKU(maxBy, 0);
        int lastIndex = ArraysKt.getLastIndex(maxBy);
        if (lastIndex != 0) {
            R rMo2237invoke = selector.mo2237invoke(C1130ULong.m18714boximpl(jM18780getsVKNKU));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    long jM18780getsVKNKU2 = ULongArray.m18780getsVKNKU(maxBy, i);
                    R rMo2237invoke2 = selector.mo2237invoke(C1130ULong.m18714boximpl(jM18780getsVKNKU2));
                    if (rMo2237invoke.compareTo(rMo2237invoke2) < 0) {
                        jM18780getsVKNKU = jM18780getsVKNKU2;
                        rMo2237invoke = rMo2237invoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return C1130ULong.m18714boximpl(jM18780getsVKNKU);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(m4972message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxBy-jgv0xPQ, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> C1128UInt m18988maxByjgv0xPQ(int[] maxBy, Function1<? super C1128UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxBy, "$this$maxBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m18704isEmptyimpl(maxBy)) {
            return null;
        }
        int iM18701getpVg5ArA = UIntArray.m18701getpVg5ArA(maxBy, 0);
        int lastIndex = ArraysKt.getLastIndex(maxBy);
        if (lastIndex != 0) {
            R rMo2237invoke = selector.mo2237invoke(C1128UInt.m18635boximpl(iM18701getpVg5ArA));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    int iM18701getpVg5ArA2 = UIntArray.m18701getpVg5ArA(maxBy, i);
                    R rMo2237invoke2 = selector.mo2237invoke(C1128UInt.m18635boximpl(iM18701getpVg5ArA2));
                    if (rMo2237invoke.compareTo(rMo2237invoke2) < 0) {
                        iM18701getpVg5ArA = iM18701getpVg5ArA2;
                        rMo2237invoke = rMo2237invoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return C1128UInt.m18635boximpl(iM18701getpVg5ArA);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(m4972message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxBy-xTcfx_M, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> C1132UShort m18989maxByxTcfx_M(short[] maxBy, Function1<? super C1132UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxBy, "$this$maxBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m18888isEmptyimpl(maxBy)) {
            return null;
        }
        short sM18885getMh2AYeg = UShortArray.m18885getMh2AYeg(maxBy, 0);
        int lastIndex = ArraysKt.getLastIndex(maxBy);
        if (lastIndex != 0) {
            R rMo2237invoke = selector.mo2237invoke(C1132UShort.m18821boximpl(sM18885getMh2AYeg));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    short sM18885getMh2AYeg2 = UShortArray.m18885getMh2AYeg(maxBy, i);
                    R rMo2237invoke2 = selector.mo2237invoke(C1132UShort.m18821boximpl(sM18885getMh2AYeg2));
                    if (rMo2237invoke.compareTo(rMo2237invoke2) < 0) {
                        sM18885getMh2AYeg = sM18885getMh2AYeg2;
                        rMo2237invoke = rMo2237invoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return C1132UShort.m18821boximpl(sM18885getMh2AYeg);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(m4972message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxWith-XMRcp5o, reason: not valid java name */
    public static final /* synthetic */ C1126UByte m18990maxWithXMRcp5o(byte[] maxWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m19382maxWithOrNullXMRcp5o(maxWith, comparator);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(m4972message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxWith-YmdZ_VM, reason: not valid java name */
    public static final /* synthetic */ C1128UInt m18991maxWithYmdZ_VM(int[] maxWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m19383maxWithOrNullYmdZ_VM(maxWith, comparator);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(m4972message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxWith-eOHTfZs, reason: not valid java name */
    public static final /* synthetic */ C1132UShort m18992maxWitheOHTfZs(short[] maxWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m19384maxWithOrNulleOHTfZs(maxWith, comparator);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(m4972message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxWith-zrEWJaI, reason: not valid java name */
    public static final /* synthetic */ C1130ULong m18993maxWithzrEWJaI(long[] maxWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m19385maxWithOrNullzrEWJaI(maxWith, comparator);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(m4972message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min--ajY-9A, reason: not valid java name */
    public static final /* synthetic */ C1128UInt m18994minajY9A(int[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        return UArraysKt___UArraysKt.m19430minOrNullajY9A(min);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(m4972message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min-GBYM_sE, reason: not valid java name */
    public static final /* synthetic */ C1126UByte m18995minGBYM_sE(byte[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        return UArraysKt___UArraysKt.m19431minOrNullGBYM_sE(min);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(m4972message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min-QwZRm1k, reason: not valid java name */
    public static final /* synthetic */ C1130ULong m18996minQwZRm1k(long[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        return UArraysKt___UArraysKt.m19432minOrNullQwZRm1k(min);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(m4972message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min-rL5Bavg, reason: not valid java name */
    public static final /* synthetic */ C1132UShort m18997minrL5Bavg(short[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        return UArraysKt___UArraysKt.m19433minOrNullrL5Bavg(min);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(m4972message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minBy-JOV_ifY, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> C1126UByte m18998minByJOV_ifY(byte[] minBy, Function1<? super C1126UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minBy, "$this$minBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m18625isEmptyimpl(minBy)) {
            return null;
        }
        byte bM18622getw2LRezQ = UByteArray.m18622getw2LRezQ(minBy, 0);
        int lastIndex = ArraysKt.getLastIndex(minBy);
        if (lastIndex != 0) {
            R rMo2237invoke = selector.mo2237invoke(C1126UByte.m18558boximpl(bM18622getw2LRezQ));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    byte bM18622getw2LRezQ2 = UByteArray.m18622getw2LRezQ(minBy, i);
                    R rMo2237invoke2 = selector.mo2237invoke(C1126UByte.m18558boximpl(bM18622getw2LRezQ2));
                    if (rMo2237invoke.compareTo(rMo2237invoke2) > 0) {
                        bM18622getw2LRezQ = bM18622getw2LRezQ2;
                        rMo2237invoke = rMo2237invoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return C1126UByte.m18558boximpl(bM18622getw2LRezQ);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(m4972message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minBy-MShoTSo, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> C1130ULong m18999minByMShoTSo(long[] minBy, Function1<? super C1130ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minBy, "$this$minBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m18783isEmptyimpl(minBy)) {
            return null;
        }
        long jM18780getsVKNKU = ULongArray.m18780getsVKNKU(minBy, 0);
        int lastIndex = ArraysKt.getLastIndex(minBy);
        if (lastIndex != 0) {
            R rMo2237invoke = selector.mo2237invoke(C1130ULong.m18714boximpl(jM18780getsVKNKU));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    long jM18780getsVKNKU2 = ULongArray.m18780getsVKNKU(minBy, i);
                    R rMo2237invoke2 = selector.mo2237invoke(C1130ULong.m18714boximpl(jM18780getsVKNKU2));
                    if (rMo2237invoke.compareTo(rMo2237invoke2) > 0) {
                        jM18780getsVKNKU = jM18780getsVKNKU2;
                        rMo2237invoke = rMo2237invoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return C1130ULong.m18714boximpl(jM18780getsVKNKU);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(m4972message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minBy-jgv0xPQ, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> C1128UInt m19000minByjgv0xPQ(int[] minBy, Function1<? super C1128UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minBy, "$this$minBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m18704isEmptyimpl(minBy)) {
            return null;
        }
        int iM18701getpVg5ArA = UIntArray.m18701getpVg5ArA(minBy, 0);
        int lastIndex = ArraysKt.getLastIndex(minBy);
        if (lastIndex != 0) {
            R rMo2237invoke = selector.mo2237invoke(C1128UInt.m18635boximpl(iM18701getpVg5ArA));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    int iM18701getpVg5ArA2 = UIntArray.m18701getpVg5ArA(minBy, i);
                    R rMo2237invoke2 = selector.mo2237invoke(C1128UInt.m18635boximpl(iM18701getpVg5ArA2));
                    if (rMo2237invoke.compareTo(rMo2237invoke2) > 0) {
                        iM18701getpVg5ArA = iM18701getpVg5ArA2;
                        rMo2237invoke = rMo2237invoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return C1128UInt.m18635boximpl(iM18701getpVg5ArA);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(m4972message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minBy-xTcfx_M, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> C1132UShort m19001minByxTcfx_M(short[] minBy, Function1<? super C1132UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minBy, "$this$minBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m18888isEmptyimpl(minBy)) {
            return null;
        }
        short sM18885getMh2AYeg = UShortArray.m18885getMh2AYeg(minBy, 0);
        int lastIndex = ArraysKt.getLastIndex(minBy);
        if (lastIndex != 0) {
            R rMo2237invoke = selector.mo2237invoke(C1132UShort.m18821boximpl(sM18885getMh2AYeg));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    short sM18885getMh2AYeg2 = UShortArray.m18885getMh2AYeg(minBy, i);
                    R rMo2237invoke2 = selector.mo2237invoke(C1132UShort.m18821boximpl(sM18885getMh2AYeg2));
                    if (rMo2237invoke.compareTo(rMo2237invoke2) > 0) {
                        sM18885getMh2AYeg = sM18885getMh2AYeg2;
                        rMo2237invoke = rMo2237invoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return C1132UShort.m18821boximpl(sM18885getMh2AYeg);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(m4972message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minWith-XMRcp5o, reason: not valid java name */
    public static final /* synthetic */ C1126UByte m19002minWithXMRcp5o(byte[] minWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m19438minWithOrNullXMRcp5o(minWith, comparator);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(m4972message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minWith-YmdZ_VM, reason: not valid java name */
    public static final /* synthetic */ C1128UInt m19003minWithYmdZ_VM(int[] minWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m19439minWithOrNullYmdZ_VM(minWith, comparator);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(m4972message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minWith-eOHTfZs, reason: not valid java name */
    public static final /* synthetic */ C1132UShort m19004minWitheOHTfZs(short[] minWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m19440minWithOrNulleOHTfZs(minWith, comparator);
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(m4972message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minWith-zrEWJaI, reason: not valid java name */
    public static final /* synthetic */ C1130ULong m19005minWithzrEWJaI(long[] minWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m19441minWithOrNullzrEWJaI(minWith, comparator);
    }

    @SinceKotlin(m5061version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @InterfaceC1231JvmName(m6260name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(int[] sumOf, Function1<? super C1128UInt, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        int iM18702getSizeimpl = UIntArray.m18702getSizeimpl(sumOf);
        for (int i = 0; i < iM18702getSizeimpl; i++) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.mo2237invoke(C1128UInt.m18635boximpl(UIntArray.m18701getpVg5ArA(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    @SinceKotlin(m5061version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @InterfaceC1231JvmName(m6260name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(int[] sumOf, Function1<? super C1128UInt, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        int iM18702getSizeimpl = UIntArray.m18702getSizeimpl(sumOf);
        for (int i = 0; i < iM18702getSizeimpl; i++) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.mo2237invoke(C1128UInt.m18635boximpl(UIntArray.m18701getpVg5ArA(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    @SinceKotlin(m5061version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @InterfaceC1231JvmName(m6260name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(long[] sumOf, Function1<? super C1130ULong, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        int iM18781getSizeimpl = ULongArray.m18781getSizeimpl(sumOf);
        for (int i = 0; i < iM18781getSizeimpl; i++) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.mo2237invoke(C1130ULong.m18714boximpl(ULongArray.m18780getsVKNKU(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    @SinceKotlin(m5061version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @InterfaceC1231JvmName(m6260name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(long[] sumOf, Function1<? super C1130ULong, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        int iM18781getSizeimpl = ULongArray.m18781getSizeimpl(sumOf);
        for (int i = 0; i < iM18781getSizeimpl; i++) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.mo2237invoke(C1130ULong.m18714boximpl(ULongArray.m18780getsVKNKU(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    @SinceKotlin(m5061version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @InterfaceC1231JvmName(m6260name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(byte[] sumOf, Function1<? super C1126UByte, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        int iM18623getSizeimpl = UByteArray.m18623getSizeimpl(sumOf);
        for (int i = 0; i < iM18623getSizeimpl; i++) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.mo2237invoke(C1126UByte.m18558boximpl(UByteArray.m18622getw2LRezQ(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    @SinceKotlin(m5061version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @InterfaceC1231JvmName(m6260name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(byte[] sumOf, Function1<? super C1126UByte, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        int iM18623getSizeimpl = UByteArray.m18623getSizeimpl(sumOf);
        for (int i = 0; i < iM18623getSizeimpl; i++) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.mo2237invoke(C1126UByte.m18558boximpl(UByteArray.m18622getw2LRezQ(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    @SinceKotlin(m5061version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @InterfaceC1231JvmName(m6260name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(short[] sumOf, Function1<? super C1132UShort, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        int iM18886getSizeimpl = UShortArray.m18886getSizeimpl(sumOf);
        for (int i = 0; i < iM18886getSizeimpl; i++) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.mo2237invoke(C1132UShort.m18821boximpl(UShortArray.m18885getMh2AYeg(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    @SinceKotlin(m5061version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @InterfaceC1231JvmName(m6260name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(short[] sumOf, Function1<? super C1132UShort, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        int iM18886getSizeimpl = UShortArray.m18886getSizeimpl(sumOf);
        for (int i = 0; i < iM18886getSizeimpl; i++) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.mo2237invoke(C1132UShort.m18821boximpl(UShortArray.m18885getMh2AYeg(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }
}
