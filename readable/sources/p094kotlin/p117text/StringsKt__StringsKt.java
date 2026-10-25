package p094kotlin.p117text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.C1122Pair;
import p094kotlin.Deprecated;
import p094kotlin.DeprecatedSinceKotlin;
import p094kotlin.Metadata;
import p094kotlin.OverloadResolutionByLambdaReturnType;
import p094kotlin.ReplaceWith;
import p094kotlin.SinceKotlin;
import p094kotlin.TuplesKt;
import p094kotlin.collections.ArraysKt;
import p094kotlin.collections.CharIterator;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p112ranges.IntProgression;
import p094kotlin.p112ranges.IntRange;
import p094kotlin.p112ranges.RangesKt;
import p094kotlin.sequences.Sequence;
import p094kotlin.sequences.SequencesKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\u0088\u0004ø\u0001\u0000\u001a%\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\u0088\u0004ø\u0001\u0000\u001a%\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\u0088\u0004ø\u0001\u0000\u001a%\u0010\u0007\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\u0088\u0004ø\u0001\u0000\u001a%\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\u0088\u0004ø\u0001\u0000\u001a%\u0010\b\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\u0088\u0004ø\u0001\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0004H\u0086\u0080\u0004\u001a\u001a\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\n\u0010\t\u001a\u00020\n\"\u00020\u0004H\u0086\u0080\u0004\u001a\u001a\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0004H\u0086\u0080\u0004\u001a\u001a\u0010\u0007\u001a\u00020\u0006*\u00020\u00062\n\u0010\t\u001a\u00020\n\"\u00020\u0004H\u0086\u0080\u0004\u001a\u001a\u0010\b\u001a\u00020\u0001*\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0004H\u0086\u0080\u0004\u001a\u001a\u0010\b\u001a\u00020\u0006*\u00020\u00062\n\u0010\t\u001a\u00020\n\"\u00020\u0004H\u0086\u0080\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0086\u0080\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0006*\u00020\u0006H\u0087\u0088\u0004b\u0002\b\u000b\u001a\u000e\u0010\u0007\u001a\u00020\u0001*\u00020\u0001H\u0086\u0080\u0004\u001a\u0012\u0010\u0007\u001a\u00020\u0006*\u00020\u0006H\u0087\u0088\u0004b\u0002\b\u000b\u001a\u000e\u0010\b\u001a\u00020\u0001*\u00020\u0001H\u0086\u0080\u0004\u001a\u0012\u0010\b\u001a\u00020\u0006*\u00020\u0006H\u0087\u0088\u0004b\u0002\b\u000b\u001a \u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0086\u0080\u0004\u001a \u0010\f\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0086\u0080\u0004\u001a \u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0086\u0080\u0004\u001a \u0010\u0010\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0086\u0080\u0004\u001a%\u0010\u0011\u001a\u00020\u0005*\u0004\u0018\u00010\u0001H\u0087\u0088\u0004b\u0002\b\u000b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\u0012\u0010\u0012\u001a\u00020\u0005*\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u000b\u001a\u0012\u0010\u0013\u001a\u00020\u0005*\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u000b\u001a\u000e\u0010\u0014\u001a\u00020\u0005*\u00020\u0001H\u0086\u0080\u0004\u001a\u0012\u0010\u0015\u001a\u00020\u0005*\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u000b\u001a%\u0010\u0016\u001a\u00020\u0005*\u0004\u0018\u00010\u0001H\u0087\u0088\u0004b\u0002\b\u000b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\u000e\u0010\u0017\u001a\u00020\u0018*\u00020\u0001H\u0086\u0082\u0004\u001a\u0014\u0010\u0019\u001a\u00020\u0006*\u0004\u0018\u00010\u0006H\u0087\u0088\u0004b\u0002\b\u000b\u001aW\u0010\u001a\u001a\u0002H\u001b\"\f\b\u0000\u0010\u001c*\u00020\u0001*\u0002H\u001b\"\u0004\b\u0001\u0010\u001b*\u0002H\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001eH\u0087\u0088\u0004b\f\b \u0012\b\b!\u0012\u0004\b\b(\"b\u0002\b\u000bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u001f\u001aW\u0010#\u001a\u0002H\u001b\"\f\b\u0000\u0010\u001c*\u00020\u0001*\u0002H\u001b\"\u0004\b\u0001\u0010\u001b*\u0002H\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001eH\u0087\u0088\u0004b\f\b \u0012\b\b!\u0012\u0004\b\b(\"b\u0002\b\u000bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u001f\u001a\u0016\u0010+\u001a\u00020\u0005*\u00020\u00012\u0006\u0010,\u001a\u00020\u000eH\u0086\u0080\u0004\u001a\u0016\u0010-\u001a\u00020\u0006*\u00020\u00062\u0006\u0010.\u001a\u00020%H\u0086\u0080\u0004\u001a\u0016\u0010/\u001a\u00020\u0001*\u00020\u00012\u0006\u0010.\u001a\u00020%H\u0086\u0080\u0004\u001af\u0010/\u001a\u00020\u0001*\u00020\u00062\u0006\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u000eH\u0087\u0088\u0004b\u0002\b\u000bb*\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u001c\b5\u0012\u0018\b\u000bB\u0014\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0006\b9\u0012\u0002\b\fb\u0016\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\b\b=\u0012\u0004\b\b(>\u001a$\u0010-\u001a\u00020\u0006*\u00020\u00012\u0006\u0010?\u001a\u00020\u000e2\b\b\u0002\u0010@\u001a\u00020\u000eH\u0087\u0088\u0004b\u0002\b\u000b\u001a\u0016\u0010-\u001a\u00020\u0006*\u00020\u00012\u0006\u0010.\u001a\u00020%H\u0086\u0080\u0004\u001a \u0010A\u001a\u00020\u0006*\u00020\u00062\u0006\u0010B\u001a\u00020\u00042\b\b\u0002\u0010C\u001a\u00020\u0006H\u0086\u0080\u0004\u001a \u0010A\u001a\u00020\u0006*\u00020\u00062\u0006\u0010B\u001a\u00020\u00062\b\b\u0002\u0010C\u001a\u00020\u0006H\u0086\u0080\u0004\u001a \u0010D\u001a\u00020\u0006*\u00020\u00062\u0006\u0010B\u001a\u00020\u00042\b\b\u0002\u0010C\u001a\u00020\u0006H\u0086\u0080\u0004\u001a \u0010D\u001a\u00020\u0006*\u00020\u00062\u0006\u0010B\u001a\u00020\u00062\b\b\u0002\u0010C\u001a\u00020\u0006H\u0086\u0080\u0004\u001a \u0010E\u001a\u00020\u0006*\u00020\u00062\u0006\u0010B\u001a\u00020\u00042\b\b\u0002\u0010C\u001a\u00020\u0006H\u0086\u0080\u0004\u001a \u0010E\u001a\u00020\u0006*\u00020\u00062\u0006\u0010B\u001a\u00020\u00062\b\b\u0002\u0010C\u001a\u00020\u0006H\u0086\u0080\u0004\u001a \u0010F\u001a\u00020\u0006*\u00020\u00062\u0006\u0010B\u001a\u00020\u00042\b\b\u0002\u0010C\u001a\u00020\u0006H\u0086\u0080\u0004\u001a \u0010F\u001a\u00020\u0006*\u00020\u00062\u0006\u0010B\u001a\u00020\u00062\b\b\u0002\u0010C\u001a\u00020\u0006H\u0086\u0080\u0004\u001a&\u0010G\u001a\u00020\u0001*\u00020\u00012\u0006\u0010?\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u0001H\u0086\u0080\u0004\u001a*\u0010G\u001a\u00020\u0006*\u00020\u00062\u0006\u0010?\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u000b\u001a\u001e\u0010G\u001a\u00020\u0001*\u00020\u00012\u0006\u0010.\u001a\u00020%2\u0006\u0010H\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\"\u0010G\u001a\u00020\u0006*\u00020\u00062\u0006\u0010.\u001a\u00020%2\u0006\u0010H\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u000b\u001a\u001e\u0010I\u001a\u00020\u0001*\u00020\u00012\u0006\u0010?\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\u000eH\u0086\u0080\u0004\u001a\"\u0010I\u001a\u00020\u0006*\u00020\u00062\u0006\u0010?\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\u000eH\u0087\u0088\u0004b\u0002\b\u000b\u001a\u0016\u0010I\u001a\u00020\u0001*\u00020\u00012\u0006\u0010.\u001a\u00020%H\u0086\u0080\u0004\u001a\u001a\u0010I\u001a\u00020\u0006*\u00020\u00062\u0006\u0010.\u001a\u00020%H\u0087\u0088\u0004b\u0002\b\u000b\u001a\u0016\u0010J\u001a\u00020\u0001*\u00020\u00012\u0006\u0010K\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0016\u0010J\u001a\u00020\u0006*\u00020\u00062\u0006\u0010K\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0016\u0010L\u001a\u00020\u0001*\u00020\u00012\u0006\u0010M\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0016\u0010L\u001a\u00020\u0006*\u00020\u00062\u0006\u0010M\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u001e\u0010N\u001a\u00020\u0001*\u00020\u00012\u0006\u0010K\u001a\u00020\u00012\u0006\u0010M\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u001e\u0010N\u001a\u00020\u0006*\u00020\u00062\u0006\u0010K\u001a\u00020\u00012\u0006\u0010M\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0016\u0010N\u001a\u00020\u0001*\u00020\u00012\u0006\u0010B\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0016\u0010N\u001a\u00020\u0006*\u00020\u00062\u0006\u0010B\u001a\u00020\u0001H\u0086\u0080\u0004\u001a(\u0010O\u001a\u00020\u0006*\u00020\u00062\u0006\u0010B\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00062\b\b\u0002\u0010C\u001a\u00020\u0006H\u0086\u0080\u0004\u001a(\u0010O\u001a\u00020\u0006*\u00020\u00062\u0006\u0010B\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u00062\b\b\u0002\u0010C\u001a\u00020\u0006H\u0086\u0080\u0004\u001a(\u0010P\u001a\u00020\u0006*\u00020\u00062\u0006\u0010B\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00062\b\b\u0002\u0010C\u001a\u00020\u0006H\u0086\u0080\u0004\u001a(\u0010P\u001a\u00020\u0006*\u00020\u00062\u0006\u0010B\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u00062\b\b\u0002\u0010C\u001a\u00020\u0006H\u0086\u0080\u0004\u001a(\u0010Q\u001a\u00020\u0006*\u00020\u00062\u0006\u0010B\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u00062\b\b\u0002\u0010C\u001a\u00020\u0006H\u0086\u0080\u0004\u001a(\u0010Q\u001a\u00020\u0006*\u00020\u00062\u0006\u0010B\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00062\b\b\u0002\u0010C\u001a\u00020\u0006H\u0086\u0080\u0004\u001a(\u0010R\u001a\u00020\u0006*\u00020\u00062\u0006\u0010B\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00062\b\b\u0002\u0010C\u001a\u00020\u0006H\u0086\u0080\u0004\u001a(\u0010R\u001a\u00020\u0006*\u00020\u00062\u0006\u0010B\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u00062\b\b\u0002\u0010C\u001a\u00020\u0006H\u0086\u0080\u0004\u001a\"\u0010S\u001a\u00020\u0006*\u00020\u00012\u0006\u0010T\u001a\u00020U2\u0006\u0010H\u001a\u00020\u0006H\u0087\u0088\u0004b\u0002\b\u000b\u001a3\u0010S\u001a\u00020\u0006*\u00020\u00012\u0006\u0010T\u001a\u00020U2\u0014\b\b\u0010V\u001a\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020\u00010\u0003H\u0087\u0088\u0004b\u0002\b\u000bø\u0001\u0000\u001a\"\u0010X\u001a\u00020\u0006*\u00020\u00012\u0006\u0010T\u001a\u00020U2\u0006\u0010H\u001a\u00020\u0006H\u0087\u0088\u0004b\u0002\b\u000b\u001aN\u0010Y\u001a\u00020\u0006*\u00020\u00062\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\u0088\u0004b\f\b \u0012\b\b!\u0012\u0004\b\b([b\u0002\b\\b\f\b]\u0012\b\b^\u0012\u0004\b\b(Zb\u0002\b\u000bø\u0001\u0000¢\u0006\u0002\bZ\u001aN\u0010Y\u001a\u00020\u0006*\u00020\u00062\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0087\u0088\u0004b\f\b \u0012\b\b!\u0012\u0004\b\b([b\u0002\b\\b\f\b]\u0012\b\b^\u0012\u0004\b\b(_b\u0002\b\u000bø\u0001\u0000¢\u0006\u0002\b_\u001a\u001a\u0010`\u001a\u00020\u0005*\u00020\u00012\u0006\u0010T\u001a\u00020UH\u0087\u008c\u0004b\u0002\b\u000b\u001a6\u0010a\u001a\u00020\u0005*\u00020\u00012\u0006\u0010b\u001a\u00020\u000e2\u0006\u0010c\u001a\u00020\u00012\u0006\u0010d\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010e\u001a\u00020\u0005H\u0080\u0080\u0004\u001a \u0010f\u001a\u00020\u0005*\u00020\u00012\u0006\u0010g\u001a\u00020\u00042\b\b\u0002\u0010e\u001a\u00020\u0005H\u0086\u0080\u0004\u001a \u0010h\u001a\u00020\u0005*\u00020\u00012\u0006\u0010g\u001a\u00020\u00042\b\b\u0002\u0010e\u001a\u00020\u0005H\u0086\u0080\u0004\u001a \u0010f\u001a\u00020\u0005*\u00020\u00012\u0006\u0010K\u001a\u00020\u00012\b\b\u0002\u0010e\u001a\u00020\u0005H\u0086\u0080\u0004\u001a(\u0010f\u001a\u00020\u0005*\u00020\u00012\u0006\u0010K\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u000e2\b\b\u0002\u0010e\u001a\u00020\u0005H\u0086\u0080\u0004\u001a \u0010h\u001a\u00020\u0005*\u00020\u00012\u0006\u0010M\u001a\u00020\u00012\b\b\u0002\u0010e\u001a\u00020\u0005H\u0086\u0080\u0004\u001a \u0010i\u001a\u00020\u0006*\u00020\u00012\u0006\u0010c\u001a\u00020\u00012\b\b\u0002\u0010e\u001a\u00020\u0005H\u0086\u0080\u0004\u001a \u0010j\u001a\u00020\u0006*\u00020\u00012\u0006\u0010c\u001a\u00020\u00012\b\b\u0002\u0010e\u001a\u00020\u0005H\u0086\u0080\u0004\u001a*\u0010k\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010?\u001a\u00020\u000e2\b\b\u0002\u0010e\u001a\u00020\u0005H\u0086\u0080\u0004\u001a*\u0010l\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010?\u001a\u00020\u000e2\b\b\u0002\u0010e\u001a\u00020\u0005H\u0086\u0080\u0004\u001a=\u0010m\u001a\u00020\u000e*\u00020\u00012\u0006\u0010c\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\u000e2\u0006\u0010e\u001a\u00020\u00052\b\b\u0002\u0010n\u001a\u00020\u0005H\u0082\u0080\u0004¢\u0006\u0002\bo\u001aG\u0010p\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0006\u0018\u00010q*\u00020\u00012\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00060s2\u0006\u0010?\u001a\u00020\u000e2\u0006\u0010e\u001a\u00020\u00052\u0006\u0010n\u001a\u00020\u0005H\u0082\u0080\u0004¢\u0006\u0002\bt\u001a>\u0010p\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0006\u0018\u00010q*\u00020\u00012\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00060s2\b\b\u0002\u0010?\u001a\u00020\u000e2\b\b\u0002\u0010e\u001a\u00020\u0005H\u0086\u0080\u0004\u001a>\u0010u\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0006\u0018\u00010q*\u00020\u00012\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00060s2\b\b\u0002\u0010?\u001a\u00020\u000e2\b\b\u0002\u0010e\u001a\u00020\u0005H\u0086\u0080\u0004\u001a0\u0010k\u001a\u00020\u000e*\u00020\u00012\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00060s2\b\b\u0002\u0010?\u001a\u00020\u000e2\b\b\u0002\u0010e\u001a\u00020\u0005H\u0086\u0080\u0004\u001a0\u0010l\u001a\u00020\u000e*\u00020\u00012\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00060s2\b\b\u0002\u0010?\u001a\u00020\u000e2\b\b\u0002\u0010e\u001a\u00020\u0005H\u0086\u0080\u0004\u001a*\u0010m\u001a\u00020\u000e*\u00020\u00012\u0006\u0010g\u001a\u00020\u00042\b\b\u0002\u0010?\u001a\u00020\u000e2\b\b\u0002\u0010e\u001a\u00020\u0005H\u0086\u0080\u0004\u001a*\u0010m\u001a\u00020\u000e*\u00020\u00012\u0006\u0010v\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u000e2\b\b\u0002\u0010e\u001a\u00020\u0005H\u0086\u0080\u0004\u001a*\u0010w\u001a\u00020\u000e*\u00020\u00012\u0006\u0010g\u001a\u00020\u00042\b\b\u0002\u0010?\u001a\u00020\u000e2\b\b\u0002\u0010e\u001a\u00020\u0005H\u0086\u0080\u0004\u001a*\u0010w\u001a\u00020\u000e*\u00020\u00012\u0006\u0010v\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u000e2\b\b\u0002\u0010e\u001a\u00020\u0005H\u0086\u0080\u0004\u001a \u0010x\u001a\u00020\u0005*\u00020\u00012\u0006\u0010c\u001a\u00020\u00012\b\b\u0002\u0010e\u001a\u00020\u0005H\u0086\u0082\u0004\u001a \u0010x\u001a\u00020\u0005*\u00020\u00012\u0006\u0010g\u001a\u00020\u00042\b\b\u0002\u0010e\u001a\u00020\u0005H\u0086\u0082\u0004\u001a\u001a\u0010x\u001a\u00020\u0005*\u00020\u00012\u0006\u0010T\u001a\u00020UH\u0087\u008a\u0004b\u0002\b\u000b\u001a?\u0010y\u001a\b\u0012\u0004\u0012\u00020%0z*\u00020\u00012\u0006\u0010{\u001a\u00020\n2\b\b\u0002\u0010?\u001a\u00020\u000e2\b\b\u0002\u0010e\u001a\u00020\u00052\b\b\u0002\u0010|\u001a\u00020\u000eH\u0082\u0080\u0004¢\u0006\u0002\b}\u001aI\u0010y\u001a\b\u0012\u0004\u0012\u00020%0z*\u00020\u00012\u000e\u0010{\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060~2\b\b\u0002\u0010?\u001a\u00020\u000e2\b\b\u0002\u0010e\u001a\u00020\u00052\b\b\u0002\u0010|\u001a\u00020\u000eH\u0082\u0080\u0004¢\u0006\u0004\b}\u0010\u007f\u001a\u0014\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0006\u0010|\u001a\u00020\u000eH\u0080\u0080\u0004\u001aC\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060z*\u00020\u00012\u0012\u0010{\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060~\"\u00020\u00062\b\b\u0002\u0010e\u001a\u00020\u00052\b\b\u0002\u0010|\u001a\u00020\u000eH\u0086\u0080\u0004¢\u0006\u0003\u0010\u0083\u0001\u001aD\u0010\u0084\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0085\u0001*\u00020\u00012\u0012\u0010{\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060~\"\u00020\u00062\b\b\u0002\u0010e\u001a\u00020\u00052\b\b\u0002\u0010|\u001a\u00020\u000eH\u0086\u0080\u0004¢\u0006\u0003\u0010\u0086\u0001\u001a5\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060z*\u00020\u00012\n\u0010{\u001a\u00020\n\"\u00020\u00042\b\b\u0002\u0010e\u001a\u00020\u00052\b\b\u0002\u0010|\u001a\u00020\u000eH\u0086\u0080\u0004\u001a6\u0010\u0084\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0085\u0001*\u00020\u00012\n\u0010{\u001a\u00020\n\"\u00020\u00042\b\b\u0002\u0010e\u001a\u00020\u00052\b\b\u0002\u0010|\u001a\u00020\u000eH\u0086\u0080\u0004\u001a4\u0010\u0084\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0085\u0001*\u00020\u00012\u0006\u0010B\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u000eH\u0082\u0080\u0004¢\u0006\u0003\b\u0087\u0001\u001a,\u0010\u0084\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0085\u0001*\u00020\u00012\u0006\u0010T\u001a\u00020U2\b\b\u0002\u0010|\u001a\u00020\u000eH\u0087\u0088\u0004b\u0002\b\u000b\u001a:\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060z*\u00020\u00012\u0006\u0010T\u001a\u00020U2\b\b\u0002\u0010|\u001a\u00020\u000eH\u0087\u0088\u0004b\r\b \u0012\t\b!\u0012\u0005\b\b(\u0088\u0001b\u0002\b\u000b\u001a\u0015\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060z*\u00020\u0001H\u0086\u0080\u0004\u001a\u0016\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0085\u0001*\u00020\u0001H\u0086\u0080\u0004\u001a\u001b\u0010\u008b\u0001\u001a\u00020\u0005*\u0004\u0018\u00010\u00012\b\u0010c\u001a\u0004\u0018\u00010\u0001H\u0080\u0080\u0004\u001a\u001b\u0010\u008c\u0001\u001a\u00020\u0005*\u0004\u0018\u00010\u00012\b\u0010c\u001a\u0004\u0018\u00010\u0001H\u0080\u0080\u0004\u001a\u001d\u0010\u008d\u0001\u001a\u00020\u0005*\u00020\u0006H\u0087\u0080\u0004b\f\b \u0012\b\b!\u0012\u0004\b\b([\u001a%\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0087\u0080\u0004b\f\b \u0012\b\b!\u0012\u0004\b\b([¢\u0006\u0003\u0010\u008f\u0001\u001a.\u0010\u0090\u0001\u001a\u00020\u000e*\u00020\u00062\u0006\u0010?\u001a\u00020\u000e2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0080\u0088\u0004ø\u0001\u0000\"\u0019\u0010$\u001a\u00020%*\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b&\u0010'\"\u0019\u0010(\u001a\u00020\u000e*\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b)\u0010*\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0091\u0001"}, m4988d2 = {"trim", BuildConfig.f24315FLAVOR, "predicate", "Lkotlin/Function1;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "trimStart", "trimEnd", "chars", BuildConfig.f24315FLAVOR, "Lkotlin/internal/InlineOnly;", "padStart", "length", BuildConfig.f24315FLAVOR, "padChar", "padEnd", "isNullOrEmpty", "isEmpty", "isNotEmpty", "isBlank", "isNotBlank", "isNullOrBlank", "iterator", "Lkotlin/collections/CharIterator;", "orEmpty", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlin/SinceKotlin;", "version", "1.3", "ifBlank", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "getLastIndex", "(Ljava/lang/CharSequence;)I", "hasSurrogatePairAt", "index", "substring", "range", "subSequence", "start", "end", "Lkotlin/Deprecated;", "message", "Use parameters named startIndex and endIndex.", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "subSequence(startIndex = start, endIndex = end)", "imports", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "1.0", "errorSince", "2.3", "startIndex", "endIndex", "substringBefore", "delimiter", "missingDelimiterValue", "substringAfter", "substringBeforeLast", "substringAfterLast", "replaceRange", "replacement", "removeRange", "removePrefix", "prefix", "removeSuffix", "suffix", "removeSurrounding", "replaceBefore", "replaceAfter", "replaceAfterLast", "replaceBeforeLast", "replace", "regex", "Lkotlin/text/Regex;", "transform", "Lkotlin/text/MatchResult;", "replaceFirst", "replaceFirstChar", "replaceFirstCharWithChar", "1.5", "Lkotlin/OverloadResolutionByLambdaReturnType;", "Lkotlin/jvm/JvmName;", "name", "replaceFirstCharWithCharSequence", "matches", "regionMatchesImpl", "thisOffset", "other", "otherOffset", "ignoreCase", "startsWith", "char", "endsWith", "commonPrefixWith", "commonSuffixWith", "indexOfAny", "lastIndexOfAny", "indexOf", "last", "indexOf$StringsKt__StringsKt", "findAnyOf", "Lkotlin/Pair;", "strings", BuildConfig.f24315FLAVOR, "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "string", "lastIndexOf", "contains", "rangesDelimitedBy", "Lkotlin/sequences/Sequence;", "delimiters", "limit", "rangesDelimitedBy$StringsKt__StringsKt", BuildConfig.f24315FLAVOR, "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "requireNonNegativeLimit", BuildConfig.f24315FLAVOR, "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "split", BuildConfig.f24315FLAVOR, "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "1.6", "lineSequence", "lines", "contentEqualsIgnoreCaseImpl", "contentEqualsImpl", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "skipWhile", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/text/StringsKt")
@SourceDebugExtension(m6344value = {"SMAP\nStrings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1669:1\n78#1,22:1670\n112#1,5:1692\n129#1,5:1697\n78#1,22:1702\n106#1:1724\n78#1,22:1725\n112#1,5:1747\n123#1:1752\n112#1,5:1753\n129#1,5:1758\n140#1:1763\n129#1,5:1764\n78#1,22:1769\n112#1,5:1791\n129#1,5:1796\n1088#2,2:1801\n14346#3,2:1803\n14346#3,2:1805\n296#4,2:1807\n296#4,2:1809\n1739#4:1812\n1814#4,3:1813\n1739#4:1816\n1814#4,3:1817\n1#5:1811\n*S KotlinDebug\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n106#1:1670,22\n123#1:1692,5\n140#1:1697,5\n145#1:1702,22\n150#1:1724\n150#1:1725,22\n155#1:1747,5\n160#1:1752\n160#1:1753,5\n165#1:1758,5\n170#1:1763\n170#1:1764,5\n175#1:1769,22\n186#1:1791,5\n197#1:1796,5\n310#1:1801,2\n984#1:1803,2\n1008#1:1805,2\n1047#1:1807,2\n1053#1:1809,2\n1434#1:1812\n1434#1:1813,3\n1476#1:1816\n1476#1:1817,3\n*E\n"})
/* loaded from: classes.dex */
public class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public static final String commonPrefixWith(CharSequence charSequence, CharSequence other, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(charSequence.length(), other.length());
        int i = 0;
        while (i < iMin && CharsKt__CharKt.m6677equals(charSequence.charAt(i), other.charAt(i), z)) {
            i++;
        }
        int i2 = i - 1;
        if (hasSurrogatePairAt(charSequence, i2) || hasSurrogatePairAt(other, i2)) {
            i--;
        }
        return charSequence.subSequence(0, i).toString();
    }

    public static /* synthetic */ String commonPrefixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return commonPrefixWith(charSequence, charSequence2, z);
    }

    public static final String commonSuffixWith(CharSequence charSequence, CharSequence other, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = charSequence.length();
        int iMin = Math.min(length, other.length());
        int i = 0;
        while (i < iMin && CharsKt__CharKt.m6677equals(charSequence.charAt((length - i) - 1), other.charAt((r1 - i) - 1), z)) {
            i++;
        }
        if (hasSurrogatePairAt(charSequence, (length - i) - 1) || hasSurrogatePairAt(other, (r1 - i) - 1)) {
            i--;
        }
        return charSequence.subSequence(length - i, length).toString();
    }

    public static /* synthetic */ String commonSuffixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return commonSuffixWith(charSequence, charSequence2, z);
    }

    public static final boolean contains(CharSequence charSequence, CharSequence other, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (other instanceof String) {
            if (indexOf$default(charSequence, (String) other, 0, z, 2, (Object) null) < 0) {
                return false;
            }
        } else if (indexOf$StringsKt__StringsKt$default(charSequence, other, 0, charSequence.length(), z, false, 16, null) < 0) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return contains(charSequence, charSequence2, z);
    }

    public static final boolean contentEqualsIgnoreCaseImpl(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt__StringsJVMKt.m6749equals((String) charSequence, (String) charSequence2, true);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!CharsKt__CharKt.m6677equals(charSequence.charAt(i), charSequence2.charAt(i), true)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean contentEqualsImpl(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return Intrinsics.areEqual(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean endsWith(CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() > 0 && CharsKt__CharKt.m6677equals(charSequence.charAt(StringsKt.getLastIndex(charSequence)), c, z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return endsWith(charSequence, c, z);
    }

    public static final C1122Pair<Integer, String> findAnyOf(CharSequence charSequence, Collection<String> strings, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        return findAnyOf$StringsKt__StringsKt(charSequence, strings, i, z, false);
    }

    private static final C1122Pair<Integer, String> findAnyOf$StringsKt__StringsKt(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        Object next;
        Object next2;
        if (!z && collection.size() == 1) {
            String str = (String) CollectionsKt.m5890single(collection);
            int iIndexOf$default = !z2 ? indexOf$default(charSequence, str, i, false, 4, (Object) null) : StringsKt.lastIndexOf$default(charSequence, str, i, false, 4, (Object) null);
            if (iIndexOf$default < 0) {
                return null;
            }
            return TuplesKt.m5076to(Integer.valueOf(iIndexOf$default), str);
        }
        IntProgression intRange = !z2 ? new IntRange(RangesKt.coerceAtLeast(i, 0), charSequence.length()) : RangesKt.m6472downTo(RangesKt.coerceAtMost(i, StringsKt.getLastIndex(charSequence)), 0);
        if (charSequence instanceof String) {
            int first = intRange.getFirst();
            int iM6454getLast = intRange.getLast();
            int iM6455getStep = intRange.getStep();
            if ((iM6455getStep > 0 && first <= iM6454getLast) || (iM6455getStep < 0 && iM6454getLast <= first)) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        String str2 = (String) next2;
                        if (StringsKt.regionMatches(str2, 0, (String) charSequence, first, str2.length(), z)) {
                            break;
                        }
                    }
                    String str3 = (String) next2;
                    if (str3 == null) {
                        if (first == iM6454getLast) {
                            break;
                        }
                        first += iM6455getStep;
                    } else {
                        return TuplesKt.m5076to(Integer.valueOf(first), str3);
                    }
                }
            }
        } else {
            int first2 = intRange.getFirst();
            int iM6454getLast2 = intRange.getLast();
            int iM6455getStep2 = intRange.getStep();
            if ((iM6455getStep2 > 0 && first2 <= iM6454getLast2) || (iM6455getStep2 < 0 && iM6454getLast2 <= first2)) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        String str4 = (String) next;
                        if (regionMatchesImpl(str4, 0, charSequence, first2, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) next;
                    if (str5 == null) {
                        if (first2 == iM6454getLast2) {
                            break;
                        }
                        first2 += iM6455getStep2;
                    } else {
                        return TuplesKt.m5076to(Integer.valueOf(first2), str5);
                    }
                }
            }
        }
        return null;
    }

    public static /* synthetic */ C1122Pair findAnyOf$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return findAnyOf(charSequence, collection, i, z);
    }

    public static final C1122Pair<Integer, String> findLastAnyOf(CharSequence charSequence, Collection<String> strings, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        return findAnyOf$StringsKt__StringsKt(charSequence, strings, i, z, true);
    }

    public static /* synthetic */ C1122Pair findLastAnyOf$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return findLastAnyOf(charSequence, collection, i, z);
    }

    public static final IntRange getIndices(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return new IntRange(0, charSequence.length() - 1);
    }

    public static int getLastIndex(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final boolean hasSurrogatePairAt(CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return i >= 0 && i <= charSequence.length() + (-2) && Character.isHighSurrogate(charSequence.charAt(i)) && Character.isLowSurrogate(charSequence.charAt(i + 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    /* renamed from: ifBlank */
    private static final <C extends CharSequence & R, R> R m6762ifBlank(C c, Function0<? extends R> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return StringsKt.m6766isBlank(c) ? defaultValue.mo4323invoke() : c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    /* renamed from: ifEmpty */
    private static final <C extends CharSequence & R, R> R m6763ifEmpty(C c, Function0<? extends R> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return c.length() == 0 ? defaultValue.mo4323invoke() : c;
    }

    /* renamed from: indexOf */
    public static final int m6764indexOf(CharSequence charSequence, char c, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? indexOfAny(charSequence, new char[]{c}, i, z) : ((String) charSequence).indexOf(c, i);
    }

    private static final int indexOf$StringsKt__StringsKt(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        IntProgression intRange = !z2 ? new IntRange(RangesKt.coerceAtLeast(i, 0), RangesKt.coerceAtMost(i2, charSequence.length())) : RangesKt.m6472downTo(RangesKt.coerceAtMost(i, StringsKt.getLastIndex(charSequence)), RangesKt.coerceAtLeast(i2, 0));
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int first = intRange.getFirst();
            int iM6454getLast = intRange.getLast();
            int iM6455getStep = intRange.getStep();
            if ((iM6455getStep <= 0 || first > iM6454getLast) && (iM6455getStep >= 0 || iM6454getLast > first)) {
                return -1;
            }
            while (!regionMatchesImpl(charSequence2, 0, charSequence, first, charSequence2.length(), z)) {
                if (first == iM6454getLast) {
                    return -1;
                }
                first += iM6455getStep;
            }
            return first;
        }
        int first2 = intRange.getFirst();
        int iM6454getLast2 = intRange.getLast();
        int iM6455getStep2 = intRange.getStep();
        if ((iM6455getStep2 <= 0 || first2 > iM6454getLast2) && (iM6455getStep2 >= 0 || iM6454getLast2 > first2)) {
            return -1;
        }
        while (true) {
            String str = (String) charSequence2;
            if (StringsKt.regionMatches(str, 0, (String) charSequence, first2, str.length(), z)) {
                return first2;
            }
            if (first2 == iM6454getLast2) {
                return -1;
            }
            first2 += iM6455getStep2;
        }
    }

    public static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        return indexOf$StringsKt__StringsKt(charSequence, charSequence2, i, i2, z, z2);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m6764indexOf(charSequence, c, i, z);
    }

    public static final int indexOfAny(CharSequence charSequence, char[] chars, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        if (!z && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(ArraysKt.m5650single(chars), i);
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i, 0);
        int lastIndex = StringsKt.getLastIndex(charSequence);
        if (iCoerceAtLeast > lastIndex) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iCoerceAtLeast);
            for (char c : chars) {
                if (CharsKt__CharKt.m6677equals(c, cCharAt, z)) {
                    return iCoerceAtLeast;
                }
            }
            if (iCoerceAtLeast == lastIndex) {
                return -1;
            }
            iCoerceAtLeast++;
        }
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOfAny(charSequence, cArr, i, z);
    }

    /* renamed from: isBlank */
    public static boolean m6766isBlank(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        for (int i = 0; i < charSequence.length(); i++) {
            if (!CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    @InlineOnly
    /* renamed from: isEmpty */
    private static final boolean m6767isEmpty(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() == 0;
    }

    @InlineOnly
    private static final boolean isNotBlank(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return !StringsKt.m6766isBlank(charSequence);
    }

    @InlineOnly
    private static final boolean isNotEmpty(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() > 0;
    }

    @InlineOnly
    private static final boolean isNullOrBlank(CharSequence charSequence) {
        return charSequence == null || StringsKt.m6766isBlank(charSequence);
    }

    @InlineOnly
    private static final boolean isNullOrEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static final CharIterator iterator(final CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return new CharIterator() { // from class: kotlin.text.StringsKt__StringsKt.iterator.1
            private int index;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < charSequence.length();
            }

            @Override // p094kotlin.collections.CharIterator
            public char nextChar() {
                CharSequence charSequence2 = charSequence;
                int i = this.index;
                this.index = i + 1;
                return charSequence2.charAt(i);
            }
        };
    }

    public static final int lastIndexOf(CharSequence charSequence, char c, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? lastIndexOfAny(charSequence, new char[]{c}, i, z) : ((String) charSequence).lastIndexOf(c, i);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, c, i, z);
    }

    public static final int lastIndexOfAny(CharSequence charSequence, char[] chars, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        if (!z && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(ArraysKt.m5650single(chars), i);
        }
        for (int iCoerceAtMost = RangesKt.coerceAtMost(i, StringsKt.getLastIndex(charSequence)); -1 < iCoerceAtMost; iCoerceAtMost--) {
            char cCharAt = charSequence.charAt(iCoerceAtMost);
            for (char c : chars) {
                if (CharsKt__CharKt.m6677equals(c, cCharAt, z)) {
                    return iCoerceAtMost;
                }
            }
        }
        return -1;
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOfAny(charSequence, cArr, i, z);
    }

    public static final Sequence<String> lineSequence(final CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return new Sequence<String>() { // from class: kotlin.text.StringsKt__StringsKt$lineSequence$$inlined$Sequence$1
            @Override // p094kotlin.sequences.Sequence
            public Iterator<String> iterator() {
                return new LinesIterator(charSequence);
            }
        };
    }

    /* renamed from: lines */
    public static final List<String> m6768lines(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return SequencesKt.m6639toList(lineSequence(charSequence));
    }

    @InlineOnly
    /* renamed from: matches */
    private static final boolean m6769matches(CharSequence charSequence, C1312Regex regex) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.m6697matches(charSequence);
    }

    @InlineOnly
    /* renamed from: orEmpty */
    private static final String m6770orEmpty(String str) {
        return str == null ? BuildConfig.f24315FLAVOR : str;
    }

    /* renamed from: padEnd */
    public static final CharSequence m6771padEnd(CharSequence charSequence, int i, char c) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
        }
        if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i);
        sb.append(charSequence);
        int length = i - charSequence.length();
        int i2 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c);
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        return sb;
    }

    public static /* synthetic */ CharSequence padEnd$default(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return m6771padEnd(charSequence, i, c);
    }

    public static final CharSequence padStart(CharSequence charSequence, int i, char c) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
        }
        if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i);
        int length = i - charSequence.length();
        int i2 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c);
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        sb.append(charSequence);
        return sb;
    }

    public static /* synthetic */ CharSequence padStart$default(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return padStart(charSequence, i, c);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, final char[] cArr, int i, final boolean z, int i2) {
        requireNonNegativeLimit(i2);
        return new DelimitedRangesSequence(charSequence, i, i2, new Function2() { // from class: kotlin.text.KLFTb
            @Override // p094kotlin.p105jvm.functions.Function2
            /* renamed from: invoke */
            public final Object mo2167invoke(Object obj, Object obj2) {
                return StringsKt__StringsKt.rangesDelimitedBy$lambda$0$StringsKt__StringsKt(cArr, z, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    public static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, cArr, i, z, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1122Pair rangesDelimitedBy$lambda$0$StringsKt__StringsKt(char[] cArr, boolean z, CharSequence DelimitedRangesSequence, int i) {
        Intrinsics.checkNotNullParameter(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        int iIndexOfAny = indexOfAny(DelimitedRangesSequence, cArr, i, z);
        if (iIndexOfAny < 0) {
            return null;
        }
        return TuplesKt.m5076to(Integer.valueOf(iIndexOfAny), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1122Pair rangesDelimitedBy$lambda$1$StringsKt__StringsKt(List list, boolean z, CharSequence DelimitedRangesSequence, int i) {
        Intrinsics.checkNotNullParameter(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        C1122Pair<Integer, String> c1122PairFindAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(DelimitedRangesSequence, list, i, z, false);
        if (c1122PairFindAnyOf$StringsKt__StringsKt != null) {
            return TuplesKt.m5076to(c1122PairFindAnyOf$StringsKt__StringsKt.getFirst(), Integer.valueOf(c1122PairFindAnyOf$StringsKt__StringsKt.getSecond().length()));
        }
        return null;
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int i, CharSequence other, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > other.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!CharsKt__CharKt.m6677equals(charSequence.charAt(i + i4), other.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static final CharSequence removePrefix(CharSequence charSequence, CharSequence prefix) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return startsWith$default(charSequence, prefix, false, 2, (Object) null) ? charSequence.subSequence(prefix.length(), charSequence.length()) : charSequence.subSequence(0, charSequence.length());
    }

    public static final CharSequence removeRange(CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i2 < i) {
            throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
        }
        if (i2 == i) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(charSequence.length() - (i2 - i));
        sb.append(charSequence, 0, i);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append(charSequence, i2, charSequence.length());
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        return sb;
    }

    public static final CharSequence removeSuffix(CharSequence charSequence, CharSequence suffix) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return endsWith$default(charSequence, suffix, false, 2, (Object) null) ? charSequence.subSequence(0, charSequence.length() - suffix.length()) : charSequence.subSequence(0, charSequence.length());
    }

    public static final CharSequence removeSurrounding(CharSequence charSequence, CharSequence prefix, CharSequence suffix) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return (charSequence.length() >= prefix.length() + suffix.length() && startsWith$default(charSequence, prefix, false, 2, (Object) null) && endsWith$default(charSequence, suffix, false, 2, (Object) null)) ? charSequence.subSequence(prefix.length(), charSequence.length() - suffix.length()) : charSequence.subSequence(0, charSequence.length());
    }

    @InlineOnly
    /* renamed from: replace */
    private static final String m6773replace(CharSequence charSequence, C1312Regex regex, String replacement) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return regex.m6698replace(charSequence, replacement);
    }

    public static final String replaceAfter(String str, char c, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        return iIndexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) str, iIndexOf$default + 1, str.length(), (CharSequence) replacement).toString();
    }

    public static /* synthetic */ String replaceAfter$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceAfter(str, c, str2, str3);
    }

    public static final String replaceAfterLast(String str, String delimiter, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        return iLastIndexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) str, iLastIndexOf$default + delimiter.length(), str.length(), (CharSequence) replacement).toString();
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceAfterLast(str, str2, str3, str4);
    }

    public static final String replaceBefore(String str, char c, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        return iIndexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) str, 0, iIndexOf$default, (CharSequence) replacement).toString();
    }

    public static /* synthetic */ String replaceBefore$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceBefore(str, c, str2, str3);
    }

    public static final String replaceBeforeLast(String str, char c, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iLastIndexOf$default = lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        return iLastIndexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) str, 0, iLastIndexOf$default, (CharSequence) replacement).toString();
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceBeforeLast(str, c, str2, str3);
    }

    @InlineOnly
    private static final String replaceFirst(CharSequence charSequence, C1312Regex regex, String replacement) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return regex.replaceFirst(charSequence, replacement);
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    @InterfaceC1231JvmName(m6260name = "replaceFirstCharWithChar")
    @OverloadResolutionByLambdaReturnType
    private static final String replaceFirstCharWithChar(String str, Function1<? super Character, Character> transform) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (str.length() <= 0) {
            return str;
        }
        char cCharValue = transform.mo2237invoke(Character.valueOf(str.charAt(0))).charValue();
        String strSubstring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return cCharValue + strSubstring;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    @InterfaceC1231JvmName(m6260name = "replaceFirstCharWithCharSequence")
    @OverloadResolutionByLambdaReturnType
    private static final String replaceFirstCharWithCharSequence(String str, Function1<? super Character, ? extends CharSequence> transform) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Object) transform.mo2237invoke(Character.valueOf(str.charAt(0))));
        String strSubstring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        sb.append(strSubstring);
        return sb.toString();
    }

    public static final CharSequence replaceRange(CharSequence charSequence, int i, int i2, CharSequence replacement) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        if (i2 >= i) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(replacement);
            sb.append(charSequence, i2, charSequence.length());
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
    }

    public static final void requireNonNegativeLimit(int i) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i).toString());
    }

    public static final int skipWhile(String str, int i, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        while (i < str.length() && predicate.mo2237invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
            i++;
        }
        return i;
    }

    /* renamed from: split */
    public static final List<String> m6777split(CharSequence charSequence, String[] delimiters, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (str.length() > 0) {
                return split$StringsKt__StringsKt(charSequence, str, z, i);
            }
        }
        Iterable iterableAsIterable = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, delimiters, 0, z, i, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterableAsIterable, 10));
        Iterator it = iterableAsIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    private static final List<String> split$StringsKt__StringsKt(CharSequence charSequence, String str, boolean z, int i) {
        requireNonNegativeLimit(i);
        int length = 0;
        int iM6765indexOf = m6765indexOf(charSequence, str, 0, z);
        if (iM6765indexOf == -1 || i == 1) {
            return CollectionsKt.m5801listOf(charSequence.toString());
        }
        boolean z2 = i > 0;
        ArrayList arrayList = new ArrayList(z2 ? RangesKt.coerceAtMost(i, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iM6765indexOf).toString());
            length = str.length() + iM6765indexOf;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            iM6765indexOf = m6765indexOf(charSequence, str, length, z);
        } while (iM6765indexOf != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return m6777split(charSequence, strArr, z, i);
    }

    public static final Sequence<String> splitToSequence(final CharSequence charSequence, String[] delimiters, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        return SequencesKt.m6610map(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, delimiters, 0, z, i, 2, (Object) null), new Function1() { // from class: kotlin.text.xJ
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return StringsKt__StringsKt.splitToSequence$lambda$0$StringsKt__StringsKt(charSequence, (IntRange) obj);
            }
        });
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return splitToSequence(charSequence, strArr, z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String splitToSequence$lambda$0$StringsKt__StringsKt(CharSequence charSequence, IntRange it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return substring(charSequence, it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String splitToSequence$lambda$1$StringsKt__StringsKt(CharSequence charSequence, IntRange it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return substring(charSequence, it);
    }

    public static final boolean startsWith(CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() > 0 && CharsKt__CharKt.m6677equals(charSequence.charAt(0), c, z);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return startsWith(charSequence, c, z);
    }

    public static final CharSequence subSequence(CharSequence charSequence, IntRange range) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    public static final String substring(String str, IntRange range) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        String strSubstring = str.substring(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String substring$default(CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = charSequence.length();
        }
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.subSequence(i, i2).toString();
    }

    public static final String substringAfter(String str, char c, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iIndexOf$default + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String substringAfter$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringAfter(str, c, str2);
    }

    public static String substringAfterLast(String str, char c, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iLastIndexOf$default = lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iLastIndexOf$default + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String substringAfterLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringAfterLast(str, c, str2);
    }

    public static final String substringBefore(String str, char c, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String substringBefore$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringBefore(str, c, str2);
    }

    public static final String substringBeforeLast(String str, char c, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iLastIndexOf$default = lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iLastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringBeforeLast(str, c, str2);
    }

    @SinceKotlin(m5061version = "1.5")
    public static final boolean toBooleanStrict(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (Intrinsics.areEqual(str, "true")) {
            return true;
        }
        if (Intrinsics.areEqual(str, "false")) {
            return false;
        }
        throw new IllegalArgumentException("The string doesn't represent a boolean value: " + str);
    }

    @SinceKotlin(m5061version = "1.5")
    public static final Boolean toBooleanStrictOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (Intrinsics.areEqual(str, "true")) {
            return Boolean.TRUE;
        }
        if (Intrinsics.areEqual(str, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    /* renamed from: trim */
    public static final CharSequence m6779trim(CharSequence charSequence, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zBooleanValue = predicate.mo2237invoke(Character.valueOf(charSequence.charAt(!z ? i : length))).booleanValue();
            if (z) {
                if (!zBooleanValue) {
                    break;
                }
                length--;
            } else if (zBooleanValue) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    /* renamed from: trimEnd */
    public static final CharSequence m6785trimEnd(CharSequence charSequence, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return BuildConfig.f24315FLAVOR;
        }
        while (true) {
            int i = length - 1;
            if (!predicate.mo2237invoke(Character.valueOf(charSequence.charAt(length))).booleanValue()) {
                return charSequence.subSequence(0, length + 1);
            }
            if (i < 0) {
                return BuildConfig.f24315FLAVOR;
            }
            length = i;
        }
    }

    public static final CharSequence trimStart(CharSequence charSequence, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!predicate.mo2237invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return BuildConfig.f24315FLAVOR;
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return contains(charSequence, c, z);
    }

    public static final boolean endsWith(CharSequence charSequence, CharSequence suffix, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return (!z && (charSequence instanceof String) && (suffix instanceof String)) ? StringsKt.endsWith$default((String) charSequence, (String) suffix, false, 2, (Object) null) : regionMatchesImpl(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return endsWith(charSequence, charSequence2, z);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m6765indexOf(charSequence, str, i, z);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOfAny(charSequence, (Collection<String>) collection, i, z);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, str, i, z);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOfAny(charSequence, (Collection<String>) collection, i, z);
    }

    public static /* synthetic */ String padEnd$default(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return m6772padEnd(str, i, c);
    }

    public static /* synthetic */ String padStart$default(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return StringsKt.padStart(str, i, c);
    }

    public static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, strArr, i, z, i2);
    }

    @InlineOnly
    /* renamed from: replace */
    private static final String m6774replace(CharSequence charSequence, C1312Regex regex, Function1<? super MatchResult, ? extends CharSequence> transform) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return regex.m6699replace(charSequence, transform);
    }

    public static /* synthetic */ String replaceAfter$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceAfter(str, str2, str3, str4);
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceAfterLast(str, c, str2, str3);
    }

    public static /* synthetic */ String replaceBefore$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceBefore(str, str2, str3, str4);
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceBeforeLast(str, str2, str3, str4);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return m6776split(charSequence, cArr, z, i);
    }

    public static final Sequence<String> splitToSequence(final CharSequence charSequence, char[] delimiters, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        return SequencesKt.m6610map(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, delimiters, 0, z, i, 2, (Object) null), new Function1() { // from class: kotlin.text.ZfxDd
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return StringsKt__StringsKt.splitToSequence$lambda$1$StringsKt__StringsKt(charSequence, (IntRange) obj);
            }
        });
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return splitToSequence(charSequence, cArr, z, i);
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence prefix, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return (!z && (charSequence instanceof String) && (prefix instanceof String)) ? StringsKt.startsWith$default((String) charSequence, (String) prefix, false, 2, (Object) null) : regionMatchesImpl(charSequence, 0, prefix, 0, prefix.length(), z);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return startsWith(charSequence, charSequence2, z);
    }

    @Deprecated(m4972message = "Use parameters named startIndex and endIndex.", replaceWith = @ReplaceWith(expression = "subSequence(startIndex = start, endIndex = end)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.3", warningSince = "1.0")
    @InlineOnly
    private static final CharSequence subSequence(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.subSequence(i, i2);
    }

    @InlineOnly
    private static final String substring(CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.subSequence(i, i2).toString();
    }

    public static /* synthetic */ String substringAfter$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringAfter(str, str2, str3);
    }

    public static /* synthetic */ String substringAfterLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringAfterLast(str, str2, str3);
    }

    public static /* synthetic */ String substringBefore$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringBefore(str, str2, str3);
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringBeforeLast(str, str2, str3);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, String[] strArr, int i, final boolean z, int i2) {
        requireNonNegativeLimit(i2);
        final List listAsList = ArraysKt.m5136asList(strArr);
        return new DelimitedRangesSequence(charSequence, i, i2, new Function2() { // from class: kotlin.text.JHa
            @Override // p094kotlin.p105jvm.functions.Function2
            /* renamed from: invoke */
            public final Object mo2167invoke(Object obj, Object obj2) {
                return StringsKt__StringsKt.rangesDelimitedBy$lambda$1$StringsKt__StringsKt(listAsList, z, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    public static final String replaceAfter(String str, String delimiter, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iIndexOf$default = indexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        return iIndexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) str, iIndexOf$default + delimiter.length(), str.length(), (CharSequence) replacement).toString();
    }

    public static final String replaceAfterLast(String str, char c, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iLastIndexOf$default = lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        return iLastIndexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) str, iLastIndexOf$default + 1, str.length(), (CharSequence) replacement).toString();
    }

    public static final String replaceBefore(String str, String delimiter, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iIndexOf$default = indexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        return iIndexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) str, 0, iIndexOf$default, (CharSequence) replacement).toString();
    }

    public static final String replaceBeforeLast(String str, String delimiter, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        return iLastIndexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) str, 0, iLastIndexOf$default, (CharSequence) replacement).toString();
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, C1312Regex regex, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.m6700split(charSequence, i);
    }

    @SinceKotlin(m5061version = "1.6")
    @InlineOnly
    private static final Sequence<String> splitToSequence(CharSequence charSequence, C1312Regex regex, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.splitToSequence(charSequence, i);
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, C1312Regex regex, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.splitToSequence(charSequence, i);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return startsWith(charSequence, charSequence2, i, z);
    }

    public static final String substring(CharSequence charSequence, IntRange range) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1).toString();
    }

    public static final String substringAfter(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iIndexOf$default = indexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iIndexOf$default + delimiter.length(), str.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String substringAfterLast(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iLastIndexOf$default + delimiter.length(), str.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String substringBefore(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iIndexOf$default = indexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String substringBeforeLast(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iLastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean contains(CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return StringsKt.indexOf$default(charSequence, c, 0, z, 2, (Object) null) >= 0;
    }

    /* renamed from: indexOf */
    public static final int m6765indexOf(CharSequence charSequence, String string, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(string, i);
        }
        return indexOf$StringsKt__StringsKt$default(charSequence, string, i, charSequence.length(), z, false, 16, null);
    }

    public static final int lastIndexOf(CharSequence charSequence, String string, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(string, i);
        }
        return indexOf$StringsKt__StringsKt(charSequence, string, i, 0, z, true);
    }

    public static String removePrefix(String str, CharSequence prefix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!startsWith$default((CharSequence) str, prefix, false, 2, (Object) null)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String removeSuffix(String str, CharSequence suffix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (!endsWith$default((CharSequence) str, suffix, false, 2, (Object) null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - suffix.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String removeSurrounding(String str, CharSequence prefix, CharSequence suffix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (str.length() < prefix.length() + suffix.length() || !startsWith$default((CharSequence) str, prefix, false, 2, (Object) null) || !endsWith$default((CharSequence) str, suffix, false, 2, (Object) null)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length(), str.length() - suffix.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    @InlineOnly
    /* renamed from: trim */
    private static final String m6781trim(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.m6778trim((CharSequence) str).toString();
    }

    @InlineOnly
    private static final boolean contains(CharSequence charSequence, C1312Regex regex) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.containsMatchIn(charSequence);
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence prefix, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!z && (charSequence instanceof String) && (prefix instanceof String)) {
            return StringsKt__StringsJVMKt.startsWith$default((String) charSequence, (String) prefix, i, false, 4, null);
        }
        return regionMatchesImpl(charSequence, i, prefix, 0, prefix.length(), z);
    }

    /* renamed from: trim */
    public static final String m6782trim(String str, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zBooleanValue = predicate.mo2237invoke(Character.valueOf(str.charAt(!z ? i : length))).booleanValue();
            if (z) {
                if (!zBooleanValue) {
                    break;
                }
                length--;
            } else if (zBooleanValue) {
                i++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i, length + 1).toString();
    }

    @InlineOnly
    /* renamed from: trimEnd */
    private static final String m6787trimEnd(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return m6784trimEnd((CharSequence) str).toString();
    }

    @InlineOnly
    private static final String trimStart(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return trimStart((CharSequence) str).toString();
    }

    @InlineOnly
    private static final String removeRange(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return removeRange((CharSequence) str, i, i2).toString();
    }

    public static final CharSequence removeSurrounding(CharSequence charSequence, CharSequence delimiter) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        return removeSurrounding(charSequence, delimiter, delimiter);
    }

    @InlineOnly
    private static final String replaceRange(String str, int i, int i2, CharSequence replacement) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return replaceRange((CharSequence) str, i, i2, replacement).toString();
    }

    /* renamed from: trimEnd */
    public static final String m6788trimEnd(String str, Function1<? super Character, Boolean> predicate) {
        CharSequence charSequenceSubSequence;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!predicate.mo2237invoke(Character.valueOf(str.charAt(length))).booleanValue()) {
                    charSequenceSubSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
            charSequenceSubSequence = BuildConfig.f24315FLAVOR;
        } else {
            charSequenceSubSequence = BuildConfig.f24315FLAVOR;
        }
        return charSequenceSubSequence.toString();
    }

    public static final String trimStart(String str, Function1<? super Character, Boolean> predicate) {
        CharSequence charSequenceSubSequence;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = str.length();
        int i = 0;
        while (true) {
            if (i < length) {
                if (!predicate.mo2237invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
                    charSequenceSubSequence = str.subSequence(i, str.length());
                    break;
                }
                i++;
            } else {
                charSequenceSubSequence = BuildConfig.f24315FLAVOR;
                break;
            }
        }
        return charSequenceSubSequence.toString();
    }

    public static final CharSequence removeRange(CharSequence charSequence, IntRange range) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return removeRange(charSequence, range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    public static final String removeSurrounding(String str, CharSequence delimiter) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        return removeSurrounding(str, delimiter, delimiter);
    }

    public static final CharSequence replaceRange(CharSequence charSequence, IntRange range, CharSequence replacement) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return replaceRange(charSequence, range.getStart().intValue(), range.getEndInclusive().intValue() + 1, replacement);
    }

    public static final int indexOfAny(CharSequence charSequence, Collection<String> strings, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        C1122Pair<Integer, String> c1122PairFindAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(charSequence, strings, i, z, false);
        if (c1122PairFindAnyOf$StringsKt__StringsKt != null) {
            return c1122PairFindAnyOf$StringsKt__StringsKt.getFirst().intValue();
        }
        return -1;
    }

    public static final int lastIndexOfAny(CharSequence charSequence, Collection<String> strings, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        C1122Pair<Integer, String> c1122PairFindAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(charSequence, strings, i, z, true);
        if (c1122PairFindAnyOf$StringsKt__StringsKt != null) {
            return c1122PairFindAnyOf$StringsKt__StringsKt.getFirst().intValue();
        }
        return -1;
    }

    /* renamed from: padEnd */
    public static final String m6772padEnd(String str, int i, char c) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return m6771padEnd((CharSequence) str, i, c).toString();
    }

    public static String padStart(String str, int i, char c) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return padStart((CharSequence) str, i, c).toString();
    }

    @InlineOnly
    private static final String removeRange(String str, IntRange range) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return removeRange((CharSequence) str, range).toString();
    }

    @InlineOnly
    private static final String replaceRange(String str, IntRange range, CharSequence replacement) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return replaceRange((CharSequence) str, range, replacement).toString();
    }

    /* renamed from: trim */
    public static final CharSequence m6780trim(CharSequence charSequence, char... chars) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zContains = ArraysKt.contains(chars, charSequence.charAt(!z ? i : length));
            if (z) {
                if (!zContains) {
                    break;
                }
                length--;
            } else if (zContains) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    /* renamed from: split */
    public static final List<String> m6776split(CharSequence charSequence, char[] delimiters, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return split$StringsKt__StringsKt(charSequence, String.valueOf(delimiters[0]), z, i);
        }
        Iterable iterableAsIterable = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, delimiters, 0, z, i, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterableAsIterable, 10));
        Iterator it = iterableAsIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    /* renamed from: trimEnd */
    public static final CharSequence m6786trimEnd(CharSequence charSequence, char... chars) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!ArraysKt.contains(chars, charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return BuildConfig.f24315FLAVOR;
    }

    public static final CharSequence trimStart(CharSequence charSequence, char... chars) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!ArraysKt.contains(chars, charSequence.charAt(i))) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return BuildConfig.f24315FLAVOR;
    }

    /* renamed from: trim */
    public static final String m6783trim(String str, char... chars) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zContains = ArraysKt.contains(chars, str.charAt(!z ? i : length));
            if (z) {
                if (!zContains) {
                    break;
                }
                length--;
            } else if (zContains) {
                i++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i, length + 1).toString();
    }

    /* renamed from: trimEnd */
    public static final String m6789trimEnd(String str, char... chars) {
        CharSequence charSequenceSubSequence;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!ArraysKt.contains(chars, str.charAt(length))) {
                    charSequenceSubSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
            charSequenceSubSequence = BuildConfig.f24315FLAVOR;
        } else {
            charSequenceSubSequence = BuildConfig.f24315FLAVOR;
        }
        return charSequenceSubSequence.toString();
    }

    public static final String trimStart(String str, char... chars) {
        CharSequence charSequenceSubSequence;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = str.length();
        int i = 0;
        while (true) {
            if (i < length) {
                if (!ArraysKt.contains(chars, str.charAt(i))) {
                    charSequenceSubSequence = str.subSequence(i, str.length());
                    break;
                }
                i++;
            } else {
                charSequenceSubSequence = BuildConfig.f24315FLAVOR;
                break;
            }
        }
        return charSequenceSubSequence.toString();
    }

    /* renamed from: trim */
    public static CharSequence m6778trim(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zIsWhitespace = CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!zIsWhitespace) {
                    break;
                }
                length--;
            } else if (zIsWhitespace) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    @InlineOnly
    /* renamed from: split */
    private static final List<String> m6775split(CharSequence charSequence, C1312Regex regex, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.m6700split(charSequence, i);
    }

    /* renamed from: trimEnd */
    public static final CharSequence m6784trimEnd(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return BuildConfig.f24315FLAVOR;
    }

    public static final CharSequence trimStart(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(i))) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return BuildConfig.f24315FLAVOR;
    }
}
