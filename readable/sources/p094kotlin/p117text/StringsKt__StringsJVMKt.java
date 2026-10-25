package p094kotlin.p117text;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecatedSinceKotlin;
import p094kotlin.IgnorableReturnValue;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.SinceKotlin;
import p094kotlin.collections.AbstractList;
import p094kotlin.collections.ArraysKt;
import p094kotlin.internal.InlineOnly;
import p094kotlin.internal.LowPriorityInOverloadResolution;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p105jvm.internal.StringCompanionObject;
import p094kotlin.p112ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u0000¶\u0001\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0081\u0088\u0004b\u0002\b\u0006\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001H\u0081\u0088\u0004b\u0002\b\u0006\u001a\"\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0081\u0088\u0004b\u0002\b\u0006\u001a\"\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001H\u0081\u0088\u0004b\u0002\b\u0006\u001a$\u0010\t\u001a\u00020\n*\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\nH\u0086\u0080\u0004\u001a(\u0010\r\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\nH\u0086\u0080\u0004\u001a(\u0010\r\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\nH\u0086\u0080\u0004\u001a(\u0010\u0012\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\nH\u0086\u0080\u0004\u001a(\u0010\u0012\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\nH\u0086\u0080\u0004\u001a\\\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b0\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\"\b\u0017\u0012\u001e\b\u000bB\u001a\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\f\b\u001b\u0012\b\b\fJ\u0004\b\b(\u001cb\u0016\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!b\u0002\b\u0006\u001a \u0010\"\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(\u001fb\u0002\b\u0006\u001a\\\u0010%\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b0\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(&\u0012\"\b\u0017\u0012\u001e\b\u000bB\u001a\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b('\u0012\f\b\u001b\u0012\b\b\fJ\u0004\b\b(\u001cb\u0016\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!b\u0002\b\u0006\u001a \u0010(\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(\u001fb\u0002\b\u0006\u001a\u001c\u0010)\u001a\u00020\u0002*\u00020*H\u0087\u0080\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(+\u001a0\u0010)\u001a\u00020\u0002*\u00020*2\b\b\u0002\u0010,\u001a\u00020\u00012\b\b\u0002\u0010-\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(+\u001a0\u0010.\u001a\u00020**\u00020\u00022\b\b\u0002\u0010,\u001a\u00020\u00012\b\b\u0002\u0010-\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(+\u001a\u001c\u0010/\u001a\u00020\u0002*\u000200H\u0087\u0080\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(+\u001a:\u0010/\u001a\u00020\u0002*\u0002002\b\b\u0002\u0010,\u001a\u00020\u00012\b\b\u0002\u0010-\u001a\u00020\u00012\b\b\u0002\u00101\u001a\u00020\nH\u0087\u0080\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(+\u001a\u001c\u00102\u001a\u000200*\u00020\u0002H\u0087\u0080\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(+\u001a:\u00102\u001a\u000200*\u00020\u00022\b\b\u0002\u0010,\u001a\u00020\u00012\b\b\u0002\u0010-\u001a\u00020\u00012\b\b\u0002\u00101\u001a\u00020\nH\u0087\u0080\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(+\u001a\u0012\u0010.\u001a\u00020**\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0006\u001a<\u0010.\u001a\u00020**\u00020\u00022\u0006\u00103\u001a\u00020*2\b\b\u0002\u00104\u001a\u00020\u00012\b\b\u0002\u0010,\u001a\u00020\u00012\b\b\u0002\u0010-\u001a\u00020\u0001H\u0087\u0088\bb\u0002\b\u0006b\u0002\b5\u001a/\u00106\u001a\u00020\u0002*\u00020\u00022\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0087\u0088\u0004b\u0002\b\u0006¢\u0006\u0002\u0010:\u001a7\u00106\u001a\u00020\u0002*\u00020;2\u0006\u00106\u001a\u00020\u00022\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0087\u0088\u0004b\u0002\b\u0006¢\u0006\u0002\u0010<\u001aG\u00106\u001a\u00020\u0002*\u00020\u00022\b\u0010=\u001a\u0004\u0018\u00010>2\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0087\u0088\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(+b\u0002\b\u0006¢\u0006\u0002\u0010?\u001aO\u00106\u001a\u00020\u0002*\u00020;2\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u00106\u001a\u00020\u00022\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0087\u0088\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(+b\u0002\b\u0006¢\u0006\u0002\u0010@\u001a&\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00020B*\u00020C2\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010F\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u001a\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010,\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0006\u001a\"\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010,\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0006\u001a \u0010H\u001a\u00020\n*\u00020\u00022\u0006\u0010I\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\nH\u0086\u0080\u0004\u001a(\u0010H\u001a\u00020\n*\u00020\u00022\u0006\u0010I\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\nH\u0086\u0080\u0004\u001a \u0010J\u001a\u00020\n*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\nH\u0086\u0080\u0004\u001a.\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u0002002\u0006\u0010N\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\u00012\u0006\u0010P\u001a\u00020QH\u0087\u0088\u0004b\u0002\b\u0006\u001a\u001e\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u0002002\u0006\u0010P\u001a\u00020QH\u0087\u0088\u0004b\u0002\b\u0006\u001a&\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u0002002\u0006\u0010N\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0006\u001a\u0016\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u000200H\u0087\u0088\u0004b\u0002\b\u0006\u001a\u0016\u0010L\u001a\u00020\u00022\u0006\u0010R\u001a\u00020*H\u0087\u0088\u0004b\u0002\b\u0006\u001a&\u0010L\u001a\u00020\u00022\u0006\u0010R\u001a\u00020*2\u0006\u0010N\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0006\u001a&\u0010L\u001a\u00020\u00022\u0006\u0010S\u001a\u00020T2\u0006\u0010N\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0006\u001a\u0016\u0010L\u001a\u00020\u00022\u0006\u0010U\u001a\u00020VH\u0087\u0088\u0004b\u0002\b\u0006\u001a\u0016\u0010L\u001a\u00020\u00022\u0006\u0010W\u001a\u00020XH\u0087\u0088\u0004b\u0002\b\u0006\u001a\u001a\u0010Y\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Z\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0006\u001a\u001a\u0010[\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Z\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0006\u001a\"\u0010\\\u001a\u00020\u0001*\u00020\u00022\u0006\u0010]\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0006\u001a \u0010^\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\nH\u0086\u0080\u0004\u001a\u001a\u0010_\u001a\u00020\n*\u00020\u00022\u0006\u0010`\u001a\u00020CH\u0087\u0088\u0004b\u0002\b\u0006\u001a\u001a\u0010_\u001a\u00020\n*\u00020\u00022\u0006\u0010W\u001a\u00020VH\u0087\u0088\u0004b\u0002\b\u0006\u001a(\u0010_\u001a\u00020\n*\u0004\u0018\u00010C2\b\u0010\u000b\u001a\u0004\u0018\u00010CH\u0087\u0084\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(\u001f\u001a0\u0010_\u001a\u00020\n*\u0004\u0018\u00010C2\b\u0010\u000b\u001a\u0004\u0018\u00010C2\u0006\u0010\f\u001a\u00020\nH\u0087\u0080\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(\u001f\u001a\u0012\u0010a\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0006\u001a\"\u0010b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Z\u001a\u00020\u00012\u0006\u0010c\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0006\u001a8\u0010d\u001a\u00020\n*\u00020C2\u0006\u0010e\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020C2\u0006\u0010f\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\nH\u0086\u0080\u0004\u001a8\u0010d\u001a\u00020\n*\u00020\u00022\u0006\u0010e\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010f\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\nH\u0086\u0080\u0004\u001a^\u0010%\u001a\u00020\u0002*\u00020\u00022\u0006\u0010=\u001a\u00020>H\u0087\u0088\u0004b*\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(&\u0012\u001c\b\u0017\u0012\u0018\b\u000bB\u0014\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(g\u0012\u0006\b\u001b\u0012\u0002\b\fb\u0016\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!b\u0002\b\u0006\u001a(\u0010(\u001a\u00020\u0002*\u00020\u00022\u0006\u0010=\u001a\u00020>H\u0087\u0088\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(\u001fb\u0002\b\u0006\u001a^\u0010\u0013\u001a\u00020\u0002*\u00020\u00022\u0006\u0010=\u001a\u00020>H\u0087\u0088\u0004b*\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u001c\b\u0017\u0012\u0018\b\u000bB\u0014\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(h\u0012\u0006\b\u001b\u0012\u0002\b\fb\u0016\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!b\u0002\b\u0006\u001a(\u0010\"\u001a\u00020\u0002*\u00020\u00022\u0006\u0010=\u001a\u00020>H\u0087\u0088\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(\u001fb\u0002\b\u0006\u001a\u001c\u0010i\u001a\u000200*\u00020\u00022\b\b\u0002\u0010P\u001a\u00020QH\u0087\u0088\u0004b\u0002\b\u0006\u001a\u001c\u0010j\u001a\u00020E*\u00020\u00022\b\b\u0002\u0010k\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0006\u001aN\u0010l\u001a\u00020\u0002*\u00020\u0002H\u0087\u0080\u0004b0\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(m\u0012\"\b\u0017\u0012\u001e\b\u000bB\u001a\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(n\u0012\f\b\u001b\u0012\b\b\fJ\u0004\b\b(\u001cb\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u001ab\u0010l\u001a\u00020\u0002*\u00020\u00022\u0006\u0010=\u001a\u00020>H\u0087\u0080\u0004b*\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(m\u0012\u001c\b\u0017\u0012\u0018\b\u000bB\u0014\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(o\u0012\u0006\b\u001b\u0012\u0002\b\fb\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\f\b#\u0012\b\b$\u0012\u0004\b\b(+b\u0002\bp\u001aN\u0010q\u001a\u00020\u0002*\u00020\u0002H\u0087\u0080\u0004b0\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(m\u0012\"\b\u0017\u0012\u001e\b\u000bB\u001a\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(r\u0012\f\b\u001b\u0012\b\b\fJ\u0004\b\b(\u001cb\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u001ab\u0010q\u001a\u00020\u0002*\u00020\u00022\u0006\u0010=\u001a\u00020>H\u0087\u0080\u0004b*\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(m\u0012\u001c\b\u0017\u0012\u0018\b\u000bB\u0014\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(s\u0012\u0006\b\u001b\u0012\u0002\b\fb\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\f\b#\u0012\b\b$\u0012\u0004\b\b(+b\u0002\bp\u001a\u0016\u0010t\u001a\u00020\u0002*\u00020C2\u0006\u0010u\u001a\u00020\u0001H\u0086\u0080\u0004\")\u0010v\u001a\u0012\u0012\u0004\u0012\u00020\u00020wj\b\u0012\u0004\u0012\u00020\u0002`x*\u00020;8FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\by\u0010z¨\u0006{"}, m4988d2 = {"nativeIndexOf", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "ch", BuildConfig.f24315FLAVOR, "fromIndex", "Lkotlin/internal/InlineOnly;", "str", "nativeLastIndexOf", "equals", BuildConfig.f24315FLAVOR, "other", "ignoreCase", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "toUpperCase", "Lkotlin/Deprecated;", "message", "Use uppercase() instead.", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "uppercase(Locale.getDefault())", "imports", "java.util.Locale", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "1.5", "errorSince", "2.1", "uppercase", "Lkotlin/SinceKotlin;", "version", "toLowerCase", "Use lowercase() instead.", "lowercase(Locale.getDefault())", "lowercase", "concatToString", BuildConfig.f24315FLAVOR, "1.4", "startIndex", "endIndex", "toCharArray", "decodeToString", BuildConfig.f24315FLAVOR, "throwOnInvalidSequence", "encodeToByteArray", "destination", "destinationOffset", "Lkotlin/IgnorableReturnValue;", "format", "args", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Lkotlin/String$Companion;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "locale", "Ljava/util/Locale;", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "split", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "regex", "Ljava/util/regex/Pattern;", "limit", "substring", "startsWith", "prefix", "endsWith", "suffix", "String", "bytes", "offset", "length", "charset", "Ljava/nio/charset/Charset;", "chars", "codePoints", BuildConfig.f24315FLAVOR, "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "compareTo", "contentEquals", "charSequence", "intern", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "lowercase(locale)", "uppercase(locale)", "toByteArray", "toPattern", "flags", "capitalize", "Use replaceFirstChar instead.", "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", "Lkotlin/internal/LowPriorityInOverloadResolution;", "decapitalize", "replaceFirstChar { it.lowercase(Locale.getDefault()) }", "replaceFirstChar { it.lowercase(locale) }", "repeat", "n", "CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/text/StringsKt")
@SourceDebugExtension(m6344value = {"SMAP\nStringsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringsJVM.kt\nkotlin/text/StringsKt__StringsJVMKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,894:1\n1198#2,2:895\n1#3:897\n*S KotlinDebug\n*F\n+ 1 StringsJVM.kt\nkotlin/text/StringsKt__StringsJVMKt\n*L\n73#1:895,2\n*E\n"})
/* loaded from: classes.dex */
public class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    @InlineOnly
    /* renamed from: String */
    private static final String m6744String(byte[] bytes, int i, int i2, Charset charset) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(bytes, i, i2, charset);
    }

    @Deprecated(m4972message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", m5048imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String capitalize(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        return capitalize(str, locale);
    }

    @InlineOnly
    private static final int codePointAt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.codePointAt(i);
    }

    @InlineOnly
    private static final int codePointBefore(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.codePointBefore(i);
    }

    @InlineOnly
    private static final int codePointCount(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.codePointCount(i, i2);
    }

    public static final int compareTo(String str, String other, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return z ? str.compareToIgnoreCase(other) : str.compareTo(other);
    }

    public static /* synthetic */ int compareTo$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return compareTo(str, str2, z);
    }

    @SinceKotlin(m5061version = "1.4")
    public static String concatToString(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return new String(cArr);
    }

    public static /* synthetic */ String concatToString$default(char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = cArr.length;
        }
        return StringsKt.concatToString(cArr, i, i2);
    }

    @InlineOnly
    private static final boolean contentEquals(String str, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        return str.contentEquals(charSequence);
    }

    @Deprecated(m4972message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(Locale.getDefault()) }", m5048imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String decapitalize(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() <= 0 || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        sb.append(lowerCase);
        String strSubstring2 = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        sb.append(strSubstring2);
        return sb.toString();
    }

    @SinceKotlin(m5061version = "1.4")
    public static String decodeToString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new String(bArr, Charsets.UTF_8);
    }

    public static /* synthetic */ String decodeToString$default(byte[] bArr, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return decodeToString(bArr, i, i2, z);
    }

    @SinceKotlin(m5061version = "1.4")
    public static byte[] encodeToByteArray(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(String str, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return encodeToByteArray(str, i, i2, z);
    }

    public static boolean endsWith(String str, String suffix, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return !z ? str.endsWith(suffix) : StringsKt.regionMatches(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean endsWith$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.endsWith(str, str2, z);
    }

    /* renamed from: equals */
    public static final boolean m6749equals(String str, String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ boolean equals$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m6749equals(str, str2, z);
    }

    @InlineOnly
    /* renamed from: format */
    private static final String m6751format(String str, Object... args) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        String str2 = String.format(str, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    public static final Comparator<String> getCASE_INSENSITIVE_ORDER(StringCompanionObject stringCompanionObject) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "<this>");
        Comparator<String> CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.checkNotNullExpressionValue(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        return CASE_INSENSITIVE_ORDER;
    }

    @InlineOnly
    /* renamed from: intern */
    private static final String m6754intern(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String strIntern = str.intern();
        Intrinsics.checkNotNullExpressionValue(strIntern, "intern(...)");
        return strIntern;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final String lowercase(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @InlineOnly
    private static final int nativeIndexOf(String str, char c, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.indexOf(c, i);
    }

    @InlineOnly
    private static final int nativeLastIndexOf(String str, char c, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.lastIndexOf(c, i);
    }

    @InlineOnly
    private static final int offsetByCodePoints(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.offsetByCodePoints(i, i2);
    }

    public static final boolean regionMatches(CharSequence charSequence, int i, CharSequence other, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return ((charSequence instanceof String) && (other instanceof String)) ? StringsKt.regionMatches((String) charSequence, i, (String) other, i2, i3, z) : StringsKt__StringsKt.regionMatchesImpl(charSequence, i, other, i2, i3, z);
    }

    public static /* synthetic */ boolean regionMatches$default(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            z = false;
        }
        return regionMatches(charSequence, i, charSequence2, i2, i3, z);
    }

    /* renamed from: repeat */
    public static String m6755repeat(CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + '.').toString());
        }
        if (i == 0) {
            return BuildConfig.f24315FLAVOR;
        }
        int i2 = 1;
        if (i == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return BuildConfig.f24315FLAVOR;
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i];
            for (int i3 = 0; i3 < i; i3++) {
                cArr[i3] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(charSequence.length() * i);
        if (1 <= i) {
            while (true) {
                sb.append(charSequence);
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNull(string);
        return string;
    }

    /* renamed from: replace */
    public static final String m6756replace(String str, char c, char c2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!z) {
            String strReplace = str.replace(c, c2);
            Intrinsics.checkNotNullExpressionValue(strReplace, "replace(...)");
            return strReplace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (CharsKt__CharKt.m6677equals(cCharAt, c, z)) {
                cCharAt = c2;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static /* synthetic */ String replace$default(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return m6756replace(str, c, c2, z);
    }

    public static final String replaceFirst(String str, char c, char c2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int iIndexOf$default = StringsKt.indexOf$default(str, c, 0, z, 2, (Object) null);
        return iIndexOf$default < 0 ? str : StringsKt__StringsKt.replaceRange((CharSequence) str, iIndexOf$default, iIndexOf$default + 1, (CharSequence) String.valueOf(c2)).toString();
    }

    public static /* synthetic */ String replaceFirst$default(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return replaceFirst(str, c, c2, z);
    }

    /* renamed from: split */
    public static final List<String> m6758split(CharSequence charSequence, Pattern regex, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        StringsKt__StringsKt.requireNonNegativeLimit(i);
        if (i == 0) {
            i = -1;
        }
        String[] strArrSplit = regex.split(charSequence, i);
        Intrinsics.checkNotNullExpressionValue(strArrSplit, "split(...)");
        return ArraysKt.m5136asList(strArrSplit);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, Pattern pattern, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m6758split(charSequence, pattern, i);
    }

    public static boolean startsWith(String str, String prefix, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return !z ? str.startsWith(prefix) : StringsKt.regionMatches(str, 0, prefix, 0, prefix.length(), z);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.startsWith(str, str2, z);
    }

    @InlineOnly
    private static final String substring(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String strSubstring = str.substring(i);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    @InlineOnly
    private static final byte[] toByteArray(String str, Charset charset) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    public static /* synthetic */ byte[] toByteArray$default(String str, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    @SinceKotlin(m5061version = "1.4")
    public static final char[] toCharArray(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        char[] cArr = new char[i2 - i];
        str.getChars(i, i2, cArr, 0);
        return cArr;
    }

    public static /* synthetic */ char[] toCharArray$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return toCharArray(str, i, i2);
    }

    @Deprecated(m4972message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(Locale.getDefault())", m5048imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    @InlineOnly
    private static final String toLowerCase(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @InlineOnly
    private static final Pattern toPattern(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Pattern patternCompile = Pattern.compile(str, i);
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        return patternCompile;
    }

    public static /* synthetic */ Pattern toPattern$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Pattern patternCompile = Pattern.compile(str, i);
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        return patternCompile;
    }

    @Deprecated(m4972message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(Locale.getDefault())", m5048imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    @InlineOnly
    private static final String toUpperCase(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String upperCase = str.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final String uppercase(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @InlineOnly
    /* renamed from: String */
    private static final String m6745String(byte[] bytes, Charset charset) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(bytes, charset);
    }

    @SinceKotlin(m5061version = "1.4")
    @Deprecated(m4972message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", m5048imports = {}))
    @LowPriorityInOverloadResolution
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String capitalize(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (str.length() <= 0) {
            return str;
        }
        char cCharAt = str.charAt(0);
        if (!Character.isLowerCase(cCharAt)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char titleCase = Character.toTitleCase(cCharAt);
        if (titleCase != Character.toUpperCase(cCharAt)) {
            sb.append(titleCase);
        } else {
            String strSubstring = str.substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strSubstring.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            sb.append(upperCase);
        }
        String strSubstring2 = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        sb.append(strSubstring2);
        return sb.toString();
    }

    @SinceKotlin(m5061version = "1.4")
    public static String concatToString(char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, cArr.length);
        return new String(cArr, i, i2 - i);
    }

    @InlineOnly
    private static final boolean contentEquals(String str, StringBuffer stringBuilder) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(stringBuilder, "stringBuilder");
        return str.contentEquals(stringBuilder);
    }

    @SinceKotlin(m5061version = "1.4")
    @Deprecated(m4972message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(locale) }", m5048imports = {}))
    @LowPriorityInOverloadResolution
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String decapitalize(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (str.length() <= 0 || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        sb.append(lowerCase);
        String strSubstring2 = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        sb.append(strSubstring2);
        return sb.toString();
    }

    @SinceKotlin(m5061version = "1.4")
    public static final String decodeToString(byte[] bArr, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, bArr.length);
        if (!z) {
            return new String(bArr, i, i2 - i, Charsets.UTF_8);
        }
        CharsetDecoder charsetDecoderNewDecoder = Charsets.UTF_8.newDecoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
        String string = charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).decode(ByteBuffer.wrap(bArr, i, i2 - i)).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @SinceKotlin(m5061version = "1.4")
    public static final byte[] encodeToByteArray(String str, int i, int i2, boolean z) throws CharacterCodingException {
        Intrinsics.checkNotNullParameter(str, "<this>");
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        if (!z) {
            String strSubstring = str.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Charset charset = Charsets.UTF_8;
            Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
            byte[] bytes = strSubstring.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return bytes;
        }
        CharsetEncoder charsetEncoderNewEncoder = Charsets.UTF_8.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
        ByteBuffer byteBufferEncode = charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).encode(CharBuffer.wrap(str, i, i2));
        if (byteBufferEncode.hasArray() && byteBufferEncode.arrayOffset() == 0) {
            int iRemaining = byteBufferEncode.remaining();
            byte[] bArrArray = byteBufferEncode.array();
            Intrinsics.checkNotNull(bArrArray);
            if (iRemaining == bArrArray.length) {
                byte[] bArrArray2 = byteBufferEncode.array();
                Intrinsics.checkNotNull(bArrArray2);
                return bArrArray2;
            }
        }
        byte[] bArr = new byte[byteBufferEncode.remaining()];
        byteBufferEncode.get(bArr);
        return bArr;
    }

    @InlineOnly
    /* renamed from: format */
    private static final String m6752format(StringCompanionObject stringCompanionObject, String format, Object... args) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        String str = String.format(format, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final String lowercase(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @InlineOnly
    private static final int nativeIndexOf(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "str");
        return str.indexOf(str2, i);
    }

    @InlineOnly
    private static final int nativeLastIndexOf(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "str");
        return str.lastIndexOf(str2, i);
    }

    public static /* synthetic */ boolean regionMatches$default(String str, int i, String str2, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            z = false;
        }
        return StringsKt.regionMatches(str, i, str2, i2, i3, z);
    }

    public static /* synthetic */ String replace$default(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return m6757replace(str, str2, str3, z);
    }

    public static /* synthetic */ String replaceFirst$default(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return replaceFirst(str, str2, str3, z);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return startsWith(str, str2, i, z);
    }

    @InlineOnly
    private static final String substring(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String strSubstring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ char[] toCharArray$default(String str, char[] destination, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = str.length();
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        str.getChars(i2, i3, destination, i);
        return destination;
    }

    @Deprecated(m4972message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(locale)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    @InlineOnly
    private static final String toLowerCase(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @Deprecated(m4972message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(locale)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    @InlineOnly
    private static final String toUpperCase(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String upperCase = str.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final String uppercase(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String upperCase = str.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @InlineOnly
    /* renamed from: String */
    private static final String m6743String(byte[] bytes, int i, int i2) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return new String(bytes, i, i2, Charsets.UTF_8);
    }

    @SinceKotlin(m5061version = "1.5")
    public static final boolean contentEquals(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence instanceof String) && charSequence2 != null) {
            return ((String) charSequence).contentEquals(charSequence2);
        }
        return StringsKt__StringsKt.contentEqualsImpl(charSequence, charSequence2);
    }

    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    /* renamed from: format */
    private static final String m6750format(String str, Locale locale, Object... args) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        String str2 = String.format(locale, str, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    public static final String replaceFirst(String str, String oldValue, String newValue, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default(str, oldValue, 0, z, 2, (Object) null);
        return iIndexOf$default < 0 ? str : StringsKt__StringsKt.replaceRange((CharSequence) str, iIndexOf$default, oldValue.length() + iIndexOf$default, (CharSequence) newValue).toString();
    }

    public static final boolean startsWith(String str, String prefix, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!z) {
            return str.startsWith(prefix, i);
        }
        return StringsKt.regionMatches(str, i, prefix, 0, prefix.length(), z);
    }

    @InlineOnly
    private static final char[] toCharArray(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        char[] charArray = str.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        return charArray;
    }

    @InlineOnly
    /* renamed from: String */
    private static final String m6742String(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return new String(bytes, Charsets.UTF_8);
    }

    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    /* renamed from: format */
    private static final String m6753format(StringCompanionObject stringCompanionObject, Locale locale, String format, Object... args) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        String str = String.format(locale, format, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static boolean regionMatches(String str, int i, String other, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (!z) {
            return str.regionMatches(i, other, i2, i3);
        }
        return str.regionMatches(z, i, other, i2, i3);
    }

    @IgnorableReturnValue
    @InlineOnly
    private static final char[] toCharArray(String str, char[] destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        str.getChars(i2, i3, destination, i);
        return destination;
    }

    @InlineOnly
    /* renamed from: String */
    private static final String m6746String(char[] chars) {
        Intrinsics.checkNotNullParameter(chars, "chars");
        return new String(chars);
    }

    @InlineOnly
    /* renamed from: String */
    private static final String m6747String(char[] chars, int i, int i2) {
        Intrinsics.checkNotNullParameter(chars, "chars");
        return new String(chars, i, i2);
    }

    @SinceKotlin(m5061version = "1.5")
    public static final boolean contentEquals(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        if (z) {
            return StringsKt__StringsKt.contentEqualsIgnoreCaseImpl(charSequence, charSequence2);
        }
        return contentEquals(charSequence, charSequence2);
    }

    /* renamed from: replace */
    public static final String m6757replace(String str, String oldValue, String newValue, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        int i = 0;
        int iM6765indexOf = StringsKt__StringsKt.m6765indexOf(str, oldValue, 0, z);
        if (iM6765indexOf < 0) {
            return str;
        }
        int length = oldValue.length();
        int iCoerceAtLeast = RangesKt.coerceAtLeast(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append((CharSequence) str, i, iM6765indexOf);
                sb.append(newValue);
                i = iM6765indexOf + length;
                if (iM6765indexOf >= str.length()) {
                    break;
                }
                iM6765indexOf = StringsKt__StringsKt.m6765indexOf(str, oldValue, iM6765indexOf + iCoerceAtLeast, z);
            } while (iM6765indexOf > 0);
            sb.append((CharSequence) str, i, str.length());
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
        throw new OutOfMemoryError();
    }

    @InlineOnly
    /* renamed from: String */
    private static final String m6748String(int[] codePoints, int i, int i2) {
        Intrinsics.checkNotNullParameter(codePoints, "codePoints");
        return new String(codePoints, i, i2);
    }

    @InlineOnly
    /* renamed from: String */
    private static final String m6740String(StringBuffer stringBuffer) {
        Intrinsics.checkNotNullParameter(stringBuffer, "stringBuffer");
        return new String(stringBuffer);
    }

    @InlineOnly
    /* renamed from: String */
    private static final String m6741String(StringBuilder stringBuilder) {
        Intrinsics.checkNotNullParameter(stringBuilder, "stringBuilder");
        return new String(stringBuilder);
    }
}
