package p122kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
import org.bouncycastle.p133asn1.p174x509.DisplayText;
import org.bouncycastle.p284math.AbstractC5816Primes;
import org.conscrypt.BuildConfig;
import p094kotlin.BuilderInference;
import p094kotlin.C1122Pair;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.ExceptionsKt;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.ResultKt;
import p094kotlin.collections.IndexedValue;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.C1207Boxing;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.Dispatchers;
import p122kotlinx.coroutines.GlobalScope;
import p122kotlinx.coroutines.InterfaceC1342Job;
import p122kotlinx.coroutines.ObsoleteCoroutinesApi;

@Metadata(m4987d1 = {"\u0000Ê\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aC\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001d\u0010\u0004\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0004\u0012\u0002H\u00010\u0005¢\u0006\u0002\b\u0007H\u0087\b¢\u0006\u0002\u0010\b\u001a2\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\n0\u0005H\u0087H¢\u0006\u0002\u0010\f\u001aJ\u0010\r\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u00122\u001a\u0010\u0013\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u0014\"\u0006\u0012\u0002\b\u00030\u0006H\u0001¢\u0006\u0002\u0010\u0015\u001a&\u0010\u0016\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0087@¢\u0006\u0002\u0010\u0019\u001a(\u0010\u001a\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0087@¢\u0006\u0002\u0010\u0019\u001a\u001e\u0010\u001b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a \u0010\u001d\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a&\u0010\u001e\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u001f\u001a\u0002H\u0002H\u0087@¢\u0006\u0002\u0010 \u001a\u001e\u0010!\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a&\u0010\"\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u001f\u001a\u0002H\u0002H\u0087@¢\u0006\u0002\u0010 \u001a \u0010#\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a\u001e\u0010$\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a \u0010%\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a0\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010'\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020)H\u0007\u001aQ\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2\"\u0010+\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0007¢\u0006\u0002\u00100\u001aQ\u00101\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2\"\u0010+\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0001¢\u0006\u0002\u00100\u001af\u00102\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)27\u0010+\u001a3\b\u0001\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0006\u0012\u0004\u0018\u00010/03H\u0007¢\u0006\u0002\u00104\u001aQ\u00105\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2\"\u0010+\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0007¢\u0006\u0002\u00100\u001a$\u00106\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\b\b\u0000\u0010\u0002*\u00020/*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0006H\u0001\u001a>\u00107\u001a\u0002H8\"\b\b\u0000\u0010\u0002*\u00020/\"\u0010\b\u0001\u00108*\n\u0012\u0006\b\u0000\u0012\u0002H\u000209*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00062\u0006\u0010:\u001a\u0002H8H\u0087@¢\u0006\u0002\u0010;\u001a<\u00107\u001a\u0002H8\"\b\b\u0000\u0010\u0002*\u00020/\"\u000e\b\u0001\u00108*\b\u0012\u0004\u0012\u0002H\u00020<*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00062\u0006\u0010:\u001a\u0002H8H\u0087@¢\u0006\u0002\u0010=\u001a0\u0010>\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010'\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020)H\u0007\u001aQ\u0010?\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2\"\u0010+\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0007¢\u0006\u0002\u00100\u001a6\u0010@\u001a\u0002H8\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u00108*\b\u0012\u0004\u0012\u0002H\u00020<*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010:\u001a\u0002H8H\u0081@¢\u0006\u0002\u0010=\u001a8\u0010A\u001a\u0002H8\"\u0004\b\u0000\u0010\u0002\"\u0010\b\u0001\u00108*\n\u0012\u0006\b\u0000\u0012\u0002H\u000209*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010:\u001a\u0002H8H\u0081@¢\u0006\u0002\u0010;\u001a<\u0010B\u001a\u000e\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u0002HE0C\"\u0004\b\u0000\u0010D\"\u0004\b\u0001\u0010E*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u0002HE0F0\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001aR\u0010B\u001a\u0002HG\"\u0004\b\u0000\u0010D\"\u0004\b\u0001\u0010E\"\u0018\b\u0002\u0010G*\u0012\u0012\u0006\b\u0000\u0012\u0002HD\u0012\u0006\b\u0000\u0012\u0002HE0H*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u0002HE0F0\u00062\u0006\u0010:\u001a\u0002HGH\u0081@¢\u0006\u0002\u0010I\u001a$\u0010J\u001a\b\u0012\u0004\u0012\u0002H\u00020K\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a$\u0010L\u001a\b\u0012\u0004\u0012\u0002H\u00020M\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a]\u0010N\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2(\u0010O\u001a$\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00060-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0007¢\u0006\u0002\u00100\u001aW\u0010P\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2\"\u0010O\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0001¢\u0006\u0002\u00100\u001al\u0010Q\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)27\u0010O\u001a3\b\u0001\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010-\u0012\u0006\u0012\u0004\u0018\u00010/03H\u0001¢\u0006\u0002\u00104\u001ar\u0010R\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u00020/*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)29\u0010O\u001a5\b\u0001\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u0002H\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010-\u0012\u0006\u0012\u0004\u0018\u00010/03H\u0007¢\u0006\u0002\u00104\u001a]\u0010S\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u00020/*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2$\u0010O\u001a \b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0007¢\u0006\u0002\u00100\u001a.\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020U0\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)H\u0007\u001a\u001e\u0010V\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0007\u001aW\u0010W\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010D*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2\"\u0010X\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002HD0-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0001¢\u0006\u0002\u00100\u001a$\u0010Y\u001a\b\u0012\u0004\u0012\u0002H\u00020Z\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0081@¢\u0006\u0002\u0010\u001c\u001a\u001e\u0010[\u001a\u00020.\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a\u001e\u0010\\\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a<\u0010]\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u001a\u0010^\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020_j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002``H\u0087@¢\u0006\u0002\u0010a\u001a<\u0010b\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u001a\u0010^\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020_j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002``H\u0087@¢\u0006\u0002\u0010a\u001a\u001e\u0010c\u001a\u00020.\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a$\u0010d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\b\b\u0000\u0010\u0002*\u00020/*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0006H\u0007\u001a?\u0010e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010F0\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00062\f\u0010f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0087\u0004\u001az\u0010e\u001a\b\u0012\u0004\u0012\u0002HE0\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010E*\b\u0012\u0004\u0012\u0002H\u00020\u00062\f\u0010f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00062\b\b\u0002\u0010(\u001a\u00020)26\u0010O\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(g\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(h\u0012\u0004\u0012\u0002HE0,H\u0001\u001a1\u0010i\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u0012*\u0006\u0012\u0002\b\u00030\u0006H\u0001\u001a`\u0010j\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\u00020k2\u0006\u0010(\u001a\u00020l2\b\b\u0002\u0010m\u001a\u00020\u00182/\b\u0001\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0-\u0012\u0006\u0012\u0004\u0018\u00010/0,¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010o¨\u0006p"}, m4988d2 = {"consume", "R", "E", "Lkotlinx/coroutines/channels/BroadcastChannel;", "block", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "consumeEach", BuildConfig.f24315FLAVOR, "action", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumesAll", BuildConfig.f24315FLAVOR, "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "channels", BuildConfig.f24315FLAVOR, "([Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlin/jvm/functions/Function1;", "elementAt", "index", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "elementAtOrNull", "first", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firstOrNull", "indexOf", "element", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "last", "lastIndexOf", "lastOrNull", "single", "singleOrNull", "drop", "n", "context", "Lkotlin/coroutines/CoroutineContext;", "dropWhile", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "filter", "filterIndexed", "Lkotlin/Function3;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/channels/ReceiveChannel;", "filterNot", "filterNotNull", "filterNotNullTo", "C", BuildConfig.f24315FLAVOR, "destination", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/SendChannel;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "take", "takeWhile", "toChannel", "toCollection", "toMap", BuildConfig.f24315FLAVOR, "K", "V", "Lkotlin/Pair;", "M", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toMutableList", BuildConfig.f24315FLAVOR, "toSet", BuildConfig.f24315FLAVOR, "flatMap", "transform", "map", "mapIndexed", "mapIndexedNotNull", "mapNotNull", "withIndex", "Lkotlin/collections/IndexedValue;", "distinct", "distinctBy", "selector", "toMutableSet", BuildConfig.f24315FLAVOR, "any", "count", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Comparator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "minWith", "none", "requireNoNulls", "zip", "other", "a", "b", "consumes", "produce", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/Job;", "capacity", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/Job;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, m4989k = 5, m4990mv = {2, 2, 0}, m4992xi = 48, m4993xs = "kotlinx/coroutines/channels/ChannelsKt")
@SourceDebugExtension(m6344value = {"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,662:1\n24#1,5:663\n97#2,8:668\n97#2,8:676\n97#2,8:684\n97#2,8:692\n156#2:700\n97#2,3:701\n157#2:704\n104#2:705\n158#2:706\n100#2,3:707\n97#2,8:710\n156#2:718\n97#2,3:719\n157#2,2:722\n104#2:724\n100#2,3:725\n97#2,8:728\n97#2,8:736\n97#2,8:744\n156#2:752\n97#2,3:753\n157#2,2:756\n104#2:758\n100#2,3:759\n156#2:762\n97#2,3:763\n157#2,2:766\n104#2:768\n100#2,3:769\n156#2:772\n97#2,3:773\n157#2,2:776\n104#2:778\n100#2,3:779\n156#2:782\n97#2,3:783\n157#2,2:786\n104#2:788\n100#2,3:789\n156#2:792\n97#2,3:793\n157#2,2:796\n104#2:798\n100#2,3:799\n97#2,8:802\n156#2:810\n97#2,3:811\n157#2,2:814\n104#2:816\n100#2,3:817\n97#2,8:820\n97#2,8:828\n97#2,8:836\n1#3:844\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt\n*L\n40#1:663,5\n64#1:668,8\n79#1:676,8\n93#1:684,8\n103#1:692,8\n114#1:700\n114#1:701,3\n114#1:704\n114#1:705\n114#1:706\n114#1:707,3\n125#1:710,8\n140#1:718\n140#1:719,3\n140#1:722,2\n140#1:724\n140#1:725,3\n151#1:728,8\n164#1:736,8\n177#1:744,8\n262#1:752\n262#1:753,3\n262#1:756,2\n262#1:758\n262#1:759,3\n271#1:762\n271#1:763,3\n271#1:766,2\n271#1:768\n271#1:769,3\n307#1:772\n307#1:773,3\n307#1:776,2\n307#1:778\n307#1:779,3\n315#1:782\n315#1:783,3\n315#1:786,2\n315#1:788\n315#1:789,3\n328#1:792\n328#1:793,3\n328#1:796,2\n328#1:798\n328#1:799,3\n433#1:802,8\n441#1:810\n441#1:811,3\n441#1:814,2\n441#1:816\n441#1:817,3\n448#1:820,8\n462#1:828,8\n476#1:836,8\n*E\n"})
/* loaded from: classes.dex */
final /* synthetic */ class ChannelsKt__DeprecatedKt {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0}, m6126l = {434}, m6127m = "any", m6128n = {"$this$any", "$this$consume$iv", "$this$any_u24lambda_u240", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$any$2"}, m6130s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1 */
    public static final class C13691<E> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5677I$0;

        /* renamed from: I$1 */
        int f5678I$1;

        /* renamed from: L$0 */
        Object f5679L$0;

        /* renamed from: L$1 */
        Object f5680L$1;

        /* renamed from: L$2 */
        Object f5681L$2;

        /* renamed from: label */
        int f5682label;

        /* renamed from: result */
        /* synthetic */ Object f5683result;

        public C13691(Continuation<? super C13691> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5683result = obj;
            this.f5682label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.m7112any(null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0}, m6126l = {C5125EACTags.INTERCHANGE_PROFILE}, m6127m = "consumeEach", m6128n = {"$this$consumeEach", "action", "$this$consume$iv", "channel$iv", "$this$consumeEach_u24lambda_u240", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$consumeEach$2"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$consumeEach$1\n*L\n1#1,662:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$consumeEach$1 */
    public static final class C13701<E> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5684I$0;

        /* renamed from: I$1 */
        int f5685I$1;

        /* renamed from: I$2 */
        int f5686I$2;

        /* renamed from: L$0 */
        Object f5687L$0;

        /* renamed from: L$1 */
        Object f5688L$1;

        /* renamed from: L$2 */
        Object f5689L$2;

        /* renamed from: L$3 */
        Object f5690L$3;

        /* renamed from: L$4 */
        Object f5691L$4;

        /* renamed from: L$5 */
        Object f5692L$5;

        /* renamed from: label */
        int f5693label;

        /* renamed from: result */
        /* synthetic */ Object f5694result;

        public C13701(Continuation<? super C13701> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5694result = obj;
            this.f5693label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.consumeEach(null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0}, m6126l = {667}, m6127m = "count", m6128n = {"$this$count", "count", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1 */
    public static final class C13711<E> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5695I$0;

        /* renamed from: I$1 */
        int f5696I$1;

        /* renamed from: I$2 */
        int f5697I$2;

        /* renamed from: L$0 */
        Object f5698L$0;

        /* renamed from: L$1 */
        Object f5699L$1;

        /* renamed from: L$2 */
        Object f5700L$2;

        /* renamed from: L$3 */
        Object f5701L$3;

        /* renamed from: L$4 */
        Object f5702L$4;

        /* renamed from: L$5 */
        Object f5703L$5;

        /* renamed from: label */
        int f5704label;

        /* renamed from: result */
        /* synthetic */ Object f5705result;

        public C13711(Continuation<? super C13711> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5705result = obj;
            this.f5704label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.m7114count(null, this);
        }
    }

    @Metadata(m4987d1 = {"\u0000\u0004\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u0001H\n"}, m4988d2 = {"<anonymous>", "E", "it"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinct$1", m6124f = "Deprecated.kt", m6125i = {}, m6126l = {}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinct$1 */
    public static final class C13721 extends SuspendLambda implements Function2 {

        /* renamed from: L$0 */
        /* synthetic */ Object f5706L$0;

        /* renamed from: label */
        int f5707label;

        public C13721(Continuation<? super C13721> continuation) {
            super(2, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C13721 c13721 = new C13721(continuation);
            c13721.f5706L$0 = obj;
            return c13721;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2 = this.f5706L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5707label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj2;
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(Object obj, Continuation continuation) {
            return ((C13721) mo2166create(obj, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", m6124f = "Deprecated.kt", m6125i = {0, 0, 1, 1, 1, 2, 2, 2, 2}, m6126l = {417, 418, 420}, m6127m = "invokeSuspend", m6128n = {"$this$produce", "keys", "$this$produce", "keys", "e", "$this$produce", "keys", "e", "k"}, m6130s = {"L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$4"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1 */
    public static final class C13731<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ Function2<E, Continuation<? super K>, Object> $selector;
        final /* synthetic */ ReceiveChannel<E> $this_distinctBy;

        /* renamed from: L$0 */
        private /* synthetic */ Object f5708L$0;

        /* renamed from: L$1 */
        Object f5709L$1;

        /* renamed from: L$2 */
        Object f5710L$2;

        /* renamed from: L$3 */
        Object f5711L$3;

        /* renamed from: L$4 */
        Object f5712L$4;

        /* renamed from: label */
        int f5713label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C13731(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super C13731> continuation) {
            super(2, continuation);
            this.$this_distinctBy = receiveChannel;
            this.$selector = function2;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C13731 c13731 = new C13731(this.$this_distinctBy, this.$selector, continuation);
            c13731.f5708L$0 = obj;
            return c13731;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:15:0x006b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00b4  */
        /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v10 */
        /* JADX WARN: Type inference failed for: r7v11 */
        /* JADX WARN: Type inference failed for: r7v5, types: [java.util.Collection] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0093 -> B:29:0x00b2). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00ac -> B:28:0x00ae). Please report as a decompilation issue!!! */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ChannelIterator<E> it;
            HashSet hashSet;
            HashSet hashSet2;
            E e;
            boolean zContains;
            HashSet hashSet3;
            ProducerScope producerScope = (ProducerScope) this.f5708L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5713label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashSet hashSet4 = new HashSet();
                it = this.$this_distinctBy.iterator();
                hashSet = hashSet4;
                this.f5708L$0 = producerScope;
                this.f5709L$1 = hashSet;
                this.f5710L$2 = it;
                this.f5711L$3 = null;
                this.f5712L$4 = null;
                this.f5713label = 1;
                obj = it.mo7069hasNext(this);
                if (obj == coroutine_suspended) {
                }
                if (((Boolean) obj).booleanValue()) {
                }
            } else if (i == 1) {
                it = (ChannelIterator) this.f5710L$2;
                hashSet = (HashSet) this.f5709L$1;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                }
            } else if (i == 2) {
                ?? r2 = this.f5711L$3;
                ChannelIterator<E> channelIterator = (ChannelIterator) this.f5710L$2;
                HashSet hashSet5 = (HashSet) this.f5709L$1;
                ResultKt.throwOnFailure(obj);
                e = r2;
                it = channelIterator;
                hashSet2 = hashSet5;
                zContains = hashSet2.contains(obj);
                hashSet3 = hashSet2;
                if (!zContains) {
                }
                hashSet = hashSet3;
                this.f5708L$0 = producerScope;
                this.f5709L$1 = hashSet;
                this.f5710L$2 = it;
                this.f5711L$3 = null;
                this.f5712L$4 = null;
                this.f5713label = 1;
                obj = it.mo7069hasNext(this);
                if (obj == coroutine_suspended) {
                }
                if (((Boolean) obj).booleanValue()) {
                }
            } else {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object obj2 = this.f5712L$4;
                ChannelIterator<E> channelIterator2 = (ChannelIterator) this.f5710L$2;
                HashSet hashSet6 = (HashSet) this.f5709L$1;
                ResultKt.throwOnFailure(obj);
                ?? r7 = hashSet6;
                r7.add(obj2);
                it = channelIterator2;
                hashSet3 = r7;
                hashSet = hashSet3;
                this.f5708L$0 = producerScope;
                this.f5709L$1 = hashSet;
                this.f5710L$2 = it;
                this.f5711L$3 = null;
                this.f5712L$4 = null;
                this.f5713label = 1;
                obj = it.mo7069hasNext(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (((Boolean) obj).booleanValue()) {
                    E eMo7070next = it.mo7070next();
                    Function2 function2 = this.$selector;
                    this.f5708L$0 = producerScope;
                    this.f5709L$1 = hashSet;
                    this.f5710L$2 = it;
                    this.f5711L$3 = eMo7070next;
                    this.f5713label = 2;
                    Object objMo2167invoke = function2.mo2167invoke(eMo7070next, this);
                    if (objMo2167invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    HashSet hashSet7 = hashSet;
                    e = eMo7070next;
                    obj = objMo2167invoke;
                    hashSet2 = hashSet7;
                    zContains = hashSet2.contains(obj);
                    hashSet3 = hashSet2;
                    if (!zContains) {
                        this.f5708L$0 = producerScope;
                        this.f5709L$1 = hashSet2;
                        this.f5710L$2 = it;
                        this.f5711L$3 = SpillingKt.nullOutSpilledVariable(e);
                        this.f5712L$4 = obj;
                        this.f5713label = 3;
                        if (producerScope.mo7052send(e, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        channelIterator2 = it;
                        obj2 = obj;
                        r7 = hashSet2;
                        r7.add(obj2);
                        it = channelIterator2;
                        hashSet3 = r7;
                    }
                    hashSet = hashSet3;
                    this.f5708L$0 = producerScope;
                    this.f5709L$1 = hashSet;
                    this.f5710L$2 = it;
                    this.f5711L$3 = null;
                    this.f5712L$4 = null;
                    this.f5713label = 1;
                    obj = it.mo7069hasNext(this);
                    if (obj == coroutine_suspended) {
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return C1133Unit.INSTANCE;
                    }
                }
            }
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(ProducerScope<? super E> producerScope, Continuation<? super C1133Unit> continuation) {
            return ((C13731) mo2166create(producerScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1", m6124f = "Deprecated.kt", m6125i = {0, 0, 1, 1, 2, 2, 2}, m6126l = {194, 199, DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE}, m6127m = "invokeSuspend", m6128n = {"$this$produce", "remaining", "$this$produce", "remaining", "$this$produce", "e", "remaining"}, m6130s = {"L$0", "I$0", "L$0", "I$0", "L$0", "L$2", "I$0"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$drop$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,662:1\n1#2:663\n*E\n"})
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1 */
    public static final class C13741 extends SuspendLambda implements Function2 {

        /* renamed from: $n */
        final /* synthetic */ int f5714$n;
        final /* synthetic */ ReceiveChannel $this_drop;

        /* renamed from: I$0 */
        int f5715I$0;

        /* renamed from: L$0 */
        private /* synthetic */ Object f5716L$0;

        /* renamed from: L$1 */
        Object f5717L$1;

        /* renamed from: L$2 */
        Object f5718L$2;

        /* renamed from: label */
        int f5719label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13741(int i, ReceiveChannel receiveChannel, Continuation continuation) {
            super(2, continuation);
            this.f5714$n = i;
            this.$this_drop = receiveChannel;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C13741 c13741 = new C13741(this.f5714$n, this.$this_drop, continuation);
            c13741.f5716L$0 = obj;
            return c13741;
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
        
            if (r2 == 0) goto L27;
         */
        /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0089 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00af  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005f -> B:23:0x0062). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00ac -> B:8:0x001e). Please report as a decompilation issue!!! */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i;
            ChannelIterator it;
            int i2;
            ChannelIterator it2;
            ChannelIterator channelIterator;
            int i3;
            Object objMo7069hasNext;
            ProducerScope producerScope = (ProducerScope) this.f5716L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.f5719label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                i = this.f5714$n;
                if (!(i >= 0)) {
                    throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
                }
                if (i > 0) {
                    it = this.$this_drop.iterator();
                    i2 = i;
                    this.f5716L$0 = producerScope;
                    this.f5717L$1 = it;
                    this.f5715I$0 = i2;
                    this.f5719label = 1;
                    obj = it.mo7069hasNext(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (((Boolean) obj).booleanValue()) {
                    }
                    i = i2;
                }
                it2 = this.$this_drop.iterator();
                this.f5716L$0 = producerScope;
                this.f5717L$1 = it2;
                this.f5718L$2 = null;
                this.f5715I$0 = i;
                this.f5719label = 2;
                objMo7069hasNext = it2.mo7069hasNext(this);
                if (objMo7069hasNext != coroutine_suspended) {
                }
            } else if (i4 == 1) {
                i2 = this.f5715I$0;
                it = (ChannelIterator) this.f5717L$1;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    it.mo7070next();
                    i2--;
                }
                i = i2;
                it2 = this.$this_drop.iterator();
                this.f5716L$0 = producerScope;
                this.f5717L$1 = it2;
                this.f5718L$2 = null;
                this.f5715I$0 = i;
                this.f5719label = 2;
                objMo7069hasNext = it2.mo7069hasNext(this);
                if (objMo7069hasNext != coroutine_suspended) {
                }
            } else if (i4 == 2) {
                i3 = this.f5715I$0;
                channelIterator = (ChannelIterator) this.f5717L$1;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                }
            } else {
                if (i4 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i3 = this.f5715I$0;
                channelIterator = (ChannelIterator) this.f5717L$1;
                ResultKt.throwOnFailure(obj);
                i = i3;
                it2 = channelIterator;
                this.f5716L$0 = producerScope;
                this.f5717L$1 = it2;
                this.f5718L$2 = null;
                this.f5715I$0 = i;
                this.f5719label = 2;
                objMo7069hasNext = it2.mo7069hasNext(this);
                if (objMo7069hasNext != coroutine_suspended) {
                    return coroutine_suspended;
                }
                ChannelIterator channelIterator2 = it2;
                i3 = i;
                obj = objMo7069hasNext;
                channelIterator = channelIterator2;
                if (((Boolean) obj).booleanValue()) {
                    return C1133Unit.INSTANCE;
                }
                Object objMo7070next = channelIterator.mo7070next();
                this.f5716L$0 = producerScope;
                this.f5717L$1 = channelIterator;
                this.f5718L$2 = SpillingKt.nullOutSpilledVariable(objMo7070next);
                this.f5715I$0 = i3;
                this.f5719label = 3;
                if (producerScope.mo7052send(objMo7070next, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = i3;
                it2 = channelIterator;
                this.f5716L$0 = producerScope;
                this.f5717L$1 = it2;
                this.f5718L$2 = null;
                this.f5715I$0 = i;
                this.f5719label = 2;
                objMo7069hasNext = it2.mo7069hasNext(this);
                if (objMo7069hasNext != coroutine_suspended) {
                }
            }
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(ProducerScope producerScope, Continuation continuation) {
            return ((C13741) mo2166create(producerScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", m6124f = "Deprecated.kt", m6125i = {0, 1, 1, 2, 2, 3, 4, 4}, m6126l = {AbstractC5816Primes.SMALL_FACTOR_LIMIT, 212, 213, 217, 218}, m6127m = "invokeSuspend", m6128n = {"$this$produce", "$this$produce", "e", "$this$produce", "e", "$this$produce", "$this$produce", "e"}, m6130s = {"L$0", "L$0", "L$2", "L$0", "L$1", "L$0", "L$0", "L$2"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1 */
    public static final class C13751 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function2 $predicate;
        final /* synthetic */ ReceiveChannel $this_dropWhile;

        /* renamed from: L$0 */
        private /* synthetic */ Object f5720L$0;

        /* renamed from: L$1 */
        Object f5721L$1;

        /* renamed from: L$2 */
        Object f5722L$2;

        /* renamed from: label */
        int f5723label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13751(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.$this_dropWhile = receiveChannel;
            this.$predicate = function2;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C13751 c13751 = new C13751(this.$this_dropWhile, this.$predicate, continuation);
            c13751.f5720L$0 = obj;
            return c13751;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0065 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00b6 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00b7  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00c2  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00d9  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0082 -> B:27:0x0085). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00d6 -> B:10:0x0023). Please report as a decompilation issue!!! */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ChannelIterator it;
            ChannelIterator channelIterator;
            Object objMo7069hasNext;
            ChannelIterator it2;
            ChannelIterator channelIterator2;
            Object objMo7069hasNext2;
            ProducerScope producerScope = (ProducerScope) this.f5720L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5723label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                it = this.$this_dropWhile.iterator();
                this.f5720L$0 = producerScope;
                this.f5721L$1 = it;
                this.f5722L$2 = null;
                this.f5723label = 1;
                objMo7069hasNext = it.mo7069hasNext(this);
                if (objMo7069hasNext != coroutine_suspended) {
                }
            } else if (i == 1) {
                ChannelIterator channelIterator3 = (ChannelIterator) this.f5721L$1;
                ResultKt.throwOnFailure(obj);
                channelIterator = channelIterator3;
                if (((Boolean) obj).booleanValue()) {
                }
                it2 = this.$this_dropWhile.iterator();
                this.f5720L$0 = producerScope;
                this.f5721L$1 = it2;
                this.f5722L$2 = null;
                this.f5723label = 4;
                objMo7069hasNext2 = it2.mo7069hasNext(this);
                if (objMo7069hasNext2 != coroutine_suspended) {
                }
            } else if (i == 2) {
                Object objMo7070next = this.f5722L$2;
                channelIterator = (ChannelIterator) this.f5721L$1;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    this.f5720L$0 = producerScope;
                    this.f5721L$1 = SpillingKt.nullOutSpilledVariable(objMo7070next);
                    this.f5722L$2 = null;
                    this.f5723label = 3;
                    if (producerScope.mo7052send(objMo7070next, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it2 = this.$this_dropWhile.iterator();
                    this.f5720L$0 = producerScope;
                    this.f5721L$1 = it2;
                    this.f5722L$2 = null;
                    this.f5723label = 4;
                    objMo7069hasNext2 = it2.mo7069hasNext(this);
                    if (objMo7069hasNext2 != coroutine_suspended) {
                    }
                } else {
                    it = channelIterator;
                    this.f5720L$0 = producerScope;
                    this.f5721L$1 = it;
                    this.f5722L$2 = null;
                    this.f5723label = 1;
                    objMo7069hasNext = it.mo7069hasNext(this);
                    if (objMo7069hasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    channelIterator = it;
                    obj = objMo7069hasNext;
                    if (((Boolean) obj).booleanValue()) {
                        objMo7070next = channelIterator.mo7070next();
                        Function2 function2 = this.$predicate;
                        this.f5720L$0 = producerScope;
                        this.f5721L$1 = channelIterator;
                        this.f5722L$2 = objMo7070next;
                        this.f5723label = 2;
                        obj = function2.mo2167invoke(objMo7070next, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (((Boolean) obj).booleanValue()) {
                        }
                    }
                    it2 = this.$this_dropWhile.iterator();
                    this.f5720L$0 = producerScope;
                    this.f5721L$1 = it2;
                    this.f5722L$2 = null;
                    this.f5723label = 4;
                    objMo7069hasNext2 = it2.mo7069hasNext(this);
                    if (objMo7069hasNext2 != coroutine_suspended) {
                    }
                }
            } else if (i == 3) {
                ResultKt.throwOnFailure(obj);
                it2 = this.$this_dropWhile.iterator();
                this.f5720L$0 = producerScope;
                this.f5721L$1 = it2;
                this.f5722L$2 = null;
                this.f5723label = 4;
                objMo7069hasNext2 = it2.mo7069hasNext(this);
                if (objMo7069hasNext2 != coroutine_suspended) {
                }
            } else if (i == 4) {
                channelIterator2 = (ChannelIterator) this.f5721L$1;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                }
            } else {
                if (i != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelIterator2 = (ChannelIterator) this.f5721L$1;
                ResultKt.throwOnFailure(obj);
                it2 = channelIterator2;
                this.f5720L$0 = producerScope;
                this.f5721L$1 = it2;
                this.f5722L$2 = null;
                this.f5723label = 4;
                objMo7069hasNext2 = it2.mo7069hasNext(this);
                if (objMo7069hasNext2 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                channelIterator2 = it2;
                obj = objMo7069hasNext2;
                if (((Boolean) obj).booleanValue()) {
                    return C1133Unit.INSTANCE;
                }
                Object objMo7070next2 = channelIterator2.mo7070next();
                this.f5720L$0 = producerScope;
                this.f5721L$1 = channelIterator2;
                this.f5722L$2 = SpillingKt.nullOutSpilledVariable(objMo7070next2);
                this.f5723label = 5;
                if (producerScope.mo7052send(objMo7070next2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                it2 = channelIterator2;
                this.f5720L$0 = producerScope;
                this.f5721L$1 = it2;
                this.f5722L$2 = null;
                this.f5723label = 4;
                objMo7069hasNext2 = it2.mo7069hasNext(this);
                if (objMo7069hasNext2 != coroutine_suspended) {
                }
            }
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(ProducerScope producerScope, Continuation continuation) {
            return ((C13751) mo2166create(producerScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0, 0, 0}, m6126l = {C5125EACTags.APPLICATION_IMAGE}, m6127m = "elementAt", m6128n = {"$this$elementAt", "$this$consume$iv", "$this$elementAt_u24lambda_u240", "index", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$elementAt$2", "count"}, m6130s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1 */
    public static final class C13761<E> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5724I$0;

        /* renamed from: I$1 */
        int f5725I$1;

        /* renamed from: I$2 */
        int f5726I$2;

        /* renamed from: I$3 */
        int f5727I$3;

        /* renamed from: L$0 */
        Object f5728L$0;

        /* renamed from: L$1 */
        Object f5729L$1;

        /* renamed from: L$2 */
        Object f5730L$2;

        /* renamed from: L$3 */
        Object f5731L$3;

        /* renamed from: label */
        int f5732label;

        /* renamed from: result */
        /* synthetic */ Object f5733result;

        public C13761(Continuation<? super C13761> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5733result = obj;
            this.f5732label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.elementAt(null, 0, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0, 0, 0}, m6126l = {83}, m6127m = "elementAtOrNull", m6128n = {"$this$elementAtOrNull", "$this$consume$iv", "$this$elementAtOrNull_u24lambda_u240", "index", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$elementAtOrNull$2", "count"}, m6130s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1 */
    public static final class C13771<E> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5734I$0;

        /* renamed from: I$1 */
        int f5735I$1;

        /* renamed from: I$2 */
        int f5736I$2;

        /* renamed from: I$3 */
        int f5737I$3;

        /* renamed from: L$0 */
        Object f5738L$0;

        /* renamed from: L$1 */
        Object f5739L$1;

        /* renamed from: L$2 */
        Object f5740L$2;

        /* renamed from: L$3 */
        Object f5741L$3;

        /* renamed from: label */
        int f5742label;

        /* renamed from: result */
        /* synthetic */ Object f5743result;

        public C13771(Continuation<? super C13771> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5743result = obj;
            this.f5742label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.elementAtOrNull(null, 0, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1", m6124f = "Deprecated.kt", m6125i = {0, 1, 1, 2, 2}, m6126l = {228, 229, 229}, m6127m = "invokeSuspend", m6128n = {"$this$produce", "$this$produce", "e", "$this$produce", "e"}, m6130s = {"L$0", "L$0", "L$2", "L$0", "L$2"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1 */
    public static final class C13781<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
        final /* synthetic */ ReceiveChannel<E> $this_filter;

        /* renamed from: L$0 */
        private /* synthetic */ Object f5744L$0;

        /* renamed from: L$1 */
        Object f5745L$1;

        /* renamed from: L$2 */
        Object f5746L$2;

        /* renamed from: label */
        int f5747label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C13781(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super C13781> continuation) {
            super(2, continuation);
            this.$this_filter = receiveChannel;
            this.$predicate = function2;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C13781 c13781 = new C13781(this.$this_filter, this.$predicate, continuation);
            c13781.f5744L$0 = obj;
            return c13781;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:18:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x008f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007a -> B:13:0x0044). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x008c -> B:13:0x0044). Please report as a decompilation issue!!! */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ChannelIterator<E> it;
            E e;
            ProducerScope producerScope = (ProducerScope) this.f5744L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5747label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                it = this.$this_filter.iterator();
            } else if (i == 1) {
                it = (ChannelIterator) this.f5745L$1;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    return C1133Unit.INSTANCE;
                }
                E eMo7070next = it.mo7070next();
                Function2<E, Continuation<? super Boolean>, Object> function2 = this.$predicate;
                this.f5744L$0 = producerScope;
                this.f5745L$1 = it;
                this.f5746L$2 = eMo7070next;
                this.f5747label = 2;
                Object objMo2167invoke = function2.mo2167invoke(eMo7070next, this);
                if (objMo2167invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                e = eMo7070next;
                obj = objMo2167invoke;
                if (((Boolean) obj).booleanValue()) {
                }
            } else if (i == 2) {
                Object obj2 = this.f5746L$2;
                ChannelIterator<E> channelIterator = (ChannelIterator) this.f5745L$1;
                ResultKt.throwOnFailure(obj);
                e = obj2;
                it = channelIterator;
                if (((Boolean) obj).booleanValue()) {
                    this.f5744L$0 = producerScope;
                    this.f5745L$1 = it;
                    this.f5746L$2 = SpillingKt.nullOutSpilledVariable(e);
                    this.f5747label = 3;
                    if (producerScope.mo7052send(e, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (ChannelIterator) this.f5745L$1;
                ResultKt.throwOnFailure(obj);
            }
            this.f5744L$0 = producerScope;
            this.f5745L$1 = it;
            this.f5746L$2 = null;
            this.f5747label = 1;
            obj = it.mo7069hasNext(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (((Boolean) obj).booleanValue()) {
            }
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(ProducerScope<? super E> producerScope, Continuation<? super C1133Unit> continuation) {
            return ((C13781) mo2166create(producerScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", m6124f = "Deprecated.kt", m6125i = {0, 0, 1, 1, 1, 2, 2, 2}, m6126l = {241, 242, 242}, m6127m = "invokeSuspend", m6128n = {"$this$produce", "index", "$this$produce", "e", "index", "$this$produce", "e", "index"}, m6130s = {"L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "L$2", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1 */
    public static final class C13791 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function3 $predicate;
        final /* synthetic */ ReceiveChannel $this_filterIndexed;

        /* renamed from: I$0 */
        int f5748I$0;

        /* renamed from: L$0 */
        private /* synthetic */ Object f5749L$0;

        /* renamed from: L$1 */
        Object f5750L$1;

        /* renamed from: L$2 */
        Object f5751L$2;

        /* renamed from: label */
        int f5752label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13791(ReceiveChannel receiveChannel, Function3 function3, Continuation continuation) {
            super(2, continuation);
            this.$this_filterIndexed = receiveChannel;
            this.$predicate = function3;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C13791 c13791 = new C13791(this.$this_filterIndexed, this.$predicate, continuation);
            c13791.f5749L$0 = obj;
            return c13791;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00a2  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x008b -> B:13:0x004b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x009f -> B:13:0x004b). Please report as a decompilation issue!!! */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i;
            ChannelIterator it;
            Object obj2;
            ProducerScope producerScope = (ProducerScope) this.f5749L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.f5752label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                i = 0;
                it = this.$this_filterIndexed.iterator();
            } else if (i2 == 1) {
                i = this.f5748I$0;
                it = (ChannelIterator) this.f5750L$1;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    return C1133Unit.INSTANCE;
                }
                Object objMo7070next = it.mo7070next();
                Function3 function3 = this.$predicate;
                int i3 = i + 1;
                Integer numM6121boxInt = C1207Boxing.m6121boxInt(i);
                this.f5749L$0 = producerScope;
                this.f5750L$1 = it;
                this.f5751L$2 = objMo7070next;
                this.f5748I$0 = i3;
                this.f5752label = 2;
                Object objMo6219invoke = function3.mo6219invoke(numM6121boxInt, objMo7070next, this);
                if (objMo6219invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = objMo7070next;
                obj = objMo6219invoke;
                i = i3;
                if (((Boolean) obj).booleanValue()) {
                }
            } else if (i2 == 2) {
                i = this.f5748I$0;
                Object obj3 = this.f5751L$2;
                ChannelIterator channelIterator = (ChannelIterator) this.f5750L$1;
                ResultKt.throwOnFailure(obj);
                obj2 = obj3;
                it = channelIterator;
                if (((Boolean) obj).booleanValue()) {
                    this.f5749L$0 = producerScope;
                    this.f5750L$1 = it;
                    this.f5751L$2 = SpillingKt.nullOutSpilledVariable(obj2);
                    this.f5748I$0 = i;
                    this.f5752label = 3;
                    if (producerScope.mo7052send(obj2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.f5748I$0;
                it = (ChannelIterator) this.f5750L$1;
                ResultKt.throwOnFailure(obj);
            }
            this.f5749L$0 = producerScope;
            this.f5750L$1 = it;
            this.f5751L$2 = null;
            this.f5748I$0 = i;
            this.f5752label = 1;
            obj = it.mo7069hasNext(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (((Boolean) obj).booleanValue()) {
            }
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(ProducerScope producerScope, Continuation continuation) {
            return ((C13791) mo2166create(producerScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "E", "it"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNot$1", m6124f = "Deprecated.kt", m6125i = {0}, m6126l = {252}, m6127m = "invokeSuspend", m6128n = {"it"}, m6130s = {"L$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNot$1 */
    public static final class C13801 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function2 $predicate;

        /* renamed from: L$0 */
        /* synthetic */ Object f5753L$0;

        /* renamed from: label */
        int f5754label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13801(Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.$predicate = function2;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C13801 c13801 = new C13801(this.$predicate, continuation);
            c13801.f5753L$0 = obj;
            return c13801;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2 = this.f5753L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5754label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function2 function2 = this.$predicate;
                this.f5753L$0 = SpillingKt.nullOutSpilledVariable(obj2);
                this.f5754label = 1;
                obj = function2.mo2167invoke(obj2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return C1207Boxing.boxBoolean(!((Boolean) obj).booleanValue());
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(Object obj, Continuation continuation) {
            return ((C13801) mo2166create(obj, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    @Metadata(m4987d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "E", BuildConfig.f24315FLAVOR, "it"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNull$1", m6124f = "Deprecated.kt", m6125i = {}, m6126l = {}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNull$1 */
    public static final class C13811<E> extends SuspendLambda implements Function2<E, Continuation<? super Boolean>, Object> {

        /* renamed from: L$0 */
        /* synthetic */ Object f5755L$0;

        /* renamed from: label */
        int f5756label;

        public C13811(Continuation<? super C13811> continuation) {
            super(2, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C13811 c13811 = new C13811(continuation);
            c13811.f5755L$0 = obj;
            return c13811;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2167invoke(Object obj, Continuation<? super Boolean> continuation) {
            return invoke2((C13811<E>) obj, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2 = this.f5755L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5756label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return C1207Boxing.boxBoolean(obj2 != null);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(E e, Continuation<? super Boolean> continuation) {
            return ((C13811) mo2166create(e, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0}, m6126l = {667}, m6127m = "filterNotNullTo", m6128n = {"$this$filterNotNullTo", "destination", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1 */
    public static final class C13821<E, C extends Collection<? super E>> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5757I$0;

        /* renamed from: I$1 */
        int f5758I$1;

        /* renamed from: I$2 */
        int f5759I$2;

        /* renamed from: L$0 */
        Object f5760L$0;

        /* renamed from: L$1 */
        Object f5761L$1;

        /* renamed from: L$2 */
        Object f5762L$2;

        /* renamed from: L$3 */
        Object f5763L$3;

        /* renamed from: L$4 */
        Object f5764L$4;

        /* renamed from: L$5 */
        Object f5765L$5;

        /* renamed from: label */
        int f5766label;

        /* renamed from: result */
        /* synthetic */ Object f5767result;

        public C13821(Continuation<? super C13821> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5767result = obj;
            this.f5766label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.filterNotNullTo((ReceiveChannel) null, (Collection) null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, m6126l = {667, 272}, m6127m = "filterNotNullTo", m6128n = {"$this$filterNotNullTo", "destination", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv", "$this$filterNotNullTo", "destination", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "e$iv", "it", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv", "$i$a$-consumeEach-ChannelsKt__DeprecatedKt$filterNotNullTo$4"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3 */
    public static final class C13833<E, C extends SendChannel<? super E>> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5768I$0;

        /* renamed from: I$1 */
        int f5769I$1;

        /* renamed from: I$2 */
        int f5770I$2;

        /* renamed from: I$3 */
        int f5771I$3;

        /* renamed from: L$0 */
        Object f5772L$0;

        /* renamed from: L$1 */
        Object f5773L$1;

        /* renamed from: L$2 */
        Object f5774L$2;

        /* renamed from: L$3 */
        Object f5775L$3;

        /* renamed from: L$4 */
        Object f5776L$4;

        /* renamed from: L$5 */
        Object f5777L$5;

        /* renamed from: L$6 */
        Object f5778L$6;

        /* renamed from: L$7 */
        Object f5779L$7;

        /* renamed from: label */
        int f5780label;

        /* renamed from: result */
        /* synthetic */ Object f5781result;

        public C13833(Continuation<? super C13833> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5781result = obj;
            this.f5780label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.filterNotNullTo((ReceiveChannel) null, (SendChannel) null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0, 0}, m6126l = {95}, m6127m = "first", m6128n = {"$this$first", "$this$consume$iv", "$this$first_u24lambda_u240", "iterator", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$first$2"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1 */
    public static final class C13841<E> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5782I$0;

        /* renamed from: I$1 */
        int f5783I$1;

        /* renamed from: L$0 */
        Object f5784L$0;

        /* renamed from: L$1 */
        Object f5785L$1;

        /* renamed from: L$2 */
        Object f5786L$2;

        /* renamed from: L$3 */
        Object f5787L$3;

        /* renamed from: label */
        int f5788label;

        /* renamed from: result */
        /* synthetic */ Object f5789result;

        public C13841(Continuation<? super C13841> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5789result = obj;
            this.f5788label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.m7117first(null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0, 0}, m6126l = {105}, m6127m = "firstOrNull", m6128n = {"$this$firstOrNull", "$this$consume$iv", "$this$firstOrNull_u24lambda_u240", "iterator", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$firstOrNull$2"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1 */
    public static final class C13851<E> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5790I$0;

        /* renamed from: I$1 */
        int f5791I$1;

        /* renamed from: L$0 */
        Object f5792L$0;

        /* renamed from: L$1 */
        Object f5793L$1;

        /* renamed from: L$2 */
        Object f5794L$2;

        /* renamed from: L$3 */
        Object f5795L$3;

        /* renamed from: label */
        int f5796label;

        /* renamed from: result */
        /* synthetic */ Object f5797result;

        public C13851(Continuation<? super C13851> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5797result = obj;
            this.f5796label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.firstOrNull(null, this);
        }
    }

    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1", m6124f = "Deprecated.kt", m6125i = {0, 1, 1, 2, 2}, m6126l = {351, 352, 352}, m6127m = "invokeSuspend", m6128n = {"$this$produce", "$this$produce", "e", "$this$produce", "e"}, m6130s = {"L$0", "L$0", "L$2", "L$0", "L$2"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1 */
    public static final class C13861 extends SuspendLambda implements Function2 {
        final /* synthetic */ ReceiveChannel $this_flatMap;
        final /* synthetic */ Function2 $transform;

        /* renamed from: L$0 */
        private /* synthetic */ Object f5798L$0;

        /* renamed from: L$1 */
        Object f5799L$1;

        /* renamed from: L$2 */
        Object f5800L$2;

        /* renamed from: label */
        int f5801label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13861(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.$this_flatMap = receiveChannel;
            this.$transform = function2;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C13861 c13861 = new C13861(this.$this_flatMap, this.$transform, continuation);
            c13861.f5798L$0 = obj;
            return c13861;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x008c A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x008d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x008a -> B:13:0x0044). Please report as a decompilation issue!!! */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ChannelIterator it;
            Object obj2;
            ProducerScope producerScope = (ProducerScope) this.f5798L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5801label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                it = this.$this_flatMap.iterator();
            } else if (i == 1) {
                it = (ChannelIterator) this.f5799L$1;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    return C1133Unit.INSTANCE;
                }
                Object objMo7070next = it.mo7070next();
                Function2 function2 = this.$transform;
                this.f5798L$0 = producerScope;
                this.f5799L$1 = it;
                this.f5800L$2 = SpillingKt.nullOutSpilledVariable(objMo7070next);
                this.f5801label = 2;
                Object objMo2167invoke = function2.mo2167invoke(objMo7070next, this);
                if (objMo2167invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = objMo7070next;
                obj = objMo2167invoke;
                this.f5798L$0 = producerScope;
                this.f5799L$1 = it;
                this.f5800L$2 = SpillingKt.nullOutSpilledVariable(obj2);
                this.f5801label = 3;
                if (ChannelsKt.toChannel((ReceiveChannel) obj, producerScope, this) == coroutine_suspended) {
                }
            } else if (i == 2) {
                Object obj3 = this.f5800L$2;
                ChannelIterator channelIterator = (ChannelIterator) this.f5799L$1;
                ResultKt.throwOnFailure(obj);
                obj2 = obj3;
                it = channelIterator;
                this.f5798L$0 = producerScope;
                this.f5799L$1 = it;
                this.f5800L$2 = SpillingKt.nullOutSpilledVariable(obj2);
                this.f5801label = 3;
                if (ChannelsKt.toChannel((ReceiveChannel) obj, producerScope, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (ChannelIterator) this.f5799L$1;
                ResultKt.throwOnFailure(obj);
            }
            this.f5798L$0 = producerScope;
            this.f5799L$1 = it;
            this.f5800L$2 = null;
            this.f5801label = 1;
            obj = it.mo7069hasNext(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (((Boolean) obj).booleanValue()) {
            }
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(ProducerScope producerScope, Continuation continuation) {
            return ((C13861) mo2166create(producerScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, m6126l = {667}, m6127m = "indexOf", m6128n = {"$this$indexOf", "element", "index", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1 */
    public static final class C13871<E> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5802I$0;

        /* renamed from: I$1 */
        int f5803I$1;

        /* renamed from: I$2 */
        int f5804I$2;

        /* renamed from: L$0 */
        Object f5805L$0;

        /* renamed from: L$1 */
        Object f5806L$1;

        /* renamed from: L$2 */
        Object f5807L$2;

        /* renamed from: L$3 */
        Object f5808L$3;

        /* renamed from: L$4 */
        Object f5809L$4;

        /* renamed from: L$5 */
        Object f5810L$5;

        /* renamed from: L$6 */
        Object f5811L$6;

        /* renamed from: label */
        int f5812label;

        /* renamed from: result */
        /* synthetic */ Object f5813result;

        public C13871(Continuation<? super C13871> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5813result = obj;
            this.f5812label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.m7119indexOf(null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, m6126l = {127, 130}, m6127m = "last", m6128n = {"$this$last", "$this$consume$iv", "$this$last_u24lambda_u240", "iterator", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$last$2", "$this$last", "$this$consume$iv", "$this$last_u24lambda_u240", "iterator", "last", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$last$2"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$last$1 */
    public static final class C13881<E> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5814I$0;

        /* renamed from: I$1 */
        int f5815I$1;

        /* renamed from: L$0 */
        Object f5816L$0;

        /* renamed from: L$1 */
        Object f5817L$1;

        /* renamed from: L$2 */
        Object f5818L$2;

        /* renamed from: L$3 */
        Object f5819L$3;

        /* renamed from: L$4 */
        Object f5820L$4;

        /* renamed from: label */
        int f5821label;

        /* renamed from: result */
        /* synthetic */ Object f5822result;

        public C13881(Continuation<? super C13881> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5822result = obj;
            this.f5821label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.m7120last(null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m6126l = {667}, m6127m = "lastIndexOf", m6128n = {"$this$lastIndexOf", "element", "lastIndex", "index", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1 */
    public static final class C13891<E> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5823I$0;

        /* renamed from: I$1 */
        int f5824I$1;

        /* renamed from: I$2 */
        int f5825I$2;

        /* renamed from: L$0 */
        Object f5826L$0;

        /* renamed from: L$1 */
        Object f5827L$1;

        /* renamed from: L$2 */
        Object f5828L$2;

        /* renamed from: L$3 */
        Object f5829L$3;

        /* renamed from: L$4 */
        Object f5830L$4;

        /* renamed from: L$5 */
        Object f5831L$5;

        /* renamed from: L$6 */
        Object f5832L$6;

        /* renamed from: L$7 */
        Object f5833L$7;

        /* renamed from: label */
        int f5834label;

        /* renamed from: result */
        /* synthetic */ Object f5835result;

        public C13891(Continuation<? super C13891> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5835result = obj;
            this.f5834label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.lastIndexOf(null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, m6126l = {153, 156}, m6127m = "lastOrNull", m6128n = {"$this$lastOrNull", "$this$consume$iv", "$this$lastOrNull_u24lambda_u240", "iterator", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$lastOrNull$2", "$this$lastOrNull", "$this$consume$iv", "$this$lastOrNull_u24lambda_u240", "iterator", "last", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$lastOrNull$2"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastOrNull$1 */
    public static final class C13901<E> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5836I$0;

        /* renamed from: I$1 */
        int f5837I$1;

        /* renamed from: L$0 */
        Object f5838L$0;

        /* renamed from: L$1 */
        Object f5839L$1;

        /* renamed from: L$2 */
        Object f5840L$2;

        /* renamed from: L$3 */
        Object f5841L$3;

        /* renamed from: L$4 */
        Object f5842L$4;

        /* renamed from: label */
        int f5843label;

        /* renamed from: result */
        /* synthetic */ Object f5844result;

        public C13901(Continuation<? super C13901> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5844result = obj;
            this.f5843label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.lastOrNull(null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, m6126l = {667, 363, 363}, m6127m = "invokeSuspend", m6128n = {"$this$produce", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv", "$this$produce", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "e$iv", "it", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv", "$i$a$-consumeEach-ChannelsKt__DeprecatedKt$map$1$1", "$this$produce", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "e$iv", "it", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv", "$i$a$-consumeEach-ChannelsKt__DeprecatedKt$map$1$1"}, m6130s = {"L$0", "L$1", "L$3", "L$4", "I$0", "I$1", "I$2", "L$0", "L$1", "L$3", "L$4", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$3", "L$4", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$map$1\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,662:1\n156#2:663\n97#2,3:664\n157#2,2:667\n104#2:669\n100#2,3:670\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$map$1\n*L\n362#1:663\n362#1:664,3\n362#1:667,2\n362#1:669\n362#1:670,3\n*E\n"})
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1 */
    public static final class C13911<R> extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ ReceiveChannel<E> $this_map;
        final /* synthetic */ Function2<E, Continuation<? super R>, Object> $transform;

        /* renamed from: I$0 */
        int f5845I$0;

        /* renamed from: I$1 */
        int f5846I$1;

        /* renamed from: I$2 */
        int f5847I$2;

        /* renamed from: I$3 */
        int f5848I$3;

        /* renamed from: L$0 */
        private /* synthetic */ Object f5849L$0;

        /* renamed from: L$1 */
        Object f5850L$1;

        /* renamed from: L$2 */
        Object f5851L$2;

        /* renamed from: L$3 */
        Object f5852L$3;

        /* renamed from: L$4 */
        Object f5853L$4;

        /* renamed from: L$5 */
        Object f5854L$5;

        /* renamed from: L$6 */
        Object f5855L$6;

        /* renamed from: L$7 */
        Object f5856L$7;

        /* renamed from: L$8 */
        Object f5857L$8;

        /* renamed from: label */
        int f5858label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C13911(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super C13911> continuation) {
            super(2, continuation);
            this.$this_map = receiveChannel;
            this.$transform = function2;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C13911 c13911 = new C13911(this.$this_map, this.$transform, continuation);
            c13911.f5849L$0 = obj;
            return c13911;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00e3 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00ec A[Catch: all -> 0x003b, TryCatch #2 {all -> 0x003b, blocks: (B:8:0x0032, B:24:0x00bc, B:27:0x00e4, B:29:0x00ec, B:33:0x0133, B:38:0x016e, B:20:0x00a3, B:23:0x00b1), top: B:49:0x0010 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0166 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0167  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x016e A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #2 {all -> 0x003b, blocks: (B:8:0x0032, B:24:0x00bc, B:27:0x00e4, B:29:0x00ec, B:33:0x0133, B:38:0x016e, B:20:0x00a3, B:23:0x00b1), top: B:49:0x0010 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0167 -> B:37:0x016a). Please report as a decompilation issue!!! */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Throwable th;
            ReceiveChannel receiveChannel;
            Function2 function2;
            ChannelIterator it;
            ReceiveChannel receiveChannel2;
            ReceiveChannel receiveChannel3;
            int i;
            int i2;
            int i3;
            ReceiveChannel receiveChannel4;
            Object obj2;
            Function2 function22;
            ProducerScope producerScope;
            Object objMo2167invoke;
            int i4;
            int i5;
            Object obj3;
            int i6;
            Object objMo7069hasNext;
            ProducerScope producerScope2 = (ProducerScope) this.f5849L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i7 = this.f5858label;
            try {
                if (i7 == 0) {
                    ResultKt.throwOnFailure(obj);
                    receiveChannel = this.$this_map;
                    function2 = this.$transform;
                    it = receiveChannel.iterator();
                    receiveChannel2 = receiveChannel;
                    receiveChannel3 = receiveChannel2;
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    this.f5849L$0 = producerScope2;
                    this.f5850L$1 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                    this.f5851L$2 = function2;
                    this.f5852L$3 = receiveChannel;
                    this.f5853L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                    this.f5854L$5 = it;
                    this.f5855L$6 = null;
                    this.f5856L$7 = null;
                    this.f5845I$0 = i3;
                    this.f5846I$1 = i2;
                    this.f5847I$2 = i;
                    this.f5858label = 1;
                    objMo7069hasNext = it.mo7069hasNext(this);
                    if (objMo7069hasNext == coroutine_suspended) {
                    }
                    if (!((Boolean) objMo7069hasNext).booleanValue()) {
                    }
                } else if (i7 == 1) {
                    i = this.f5847I$2;
                    i2 = this.f5846I$1;
                    i3 = this.f5845I$0;
                    it = (ChannelIterator) this.f5854L$5;
                    receiveChannel2 = (ReceiveChannel) this.f5853L$4;
                    receiveChannel = (ReceiveChannel) this.f5852L$3;
                    function2 = (Function2) this.f5851L$2;
                    receiveChannel3 = (ReceiveChannel) this.f5850L$1;
                    ResultKt.throwOnFailure(obj);
                    objMo7069hasNext = obj;
                    if (!((Boolean) objMo7069hasNext).booleanValue()) {
                    }
                } else if (i7 == 2) {
                    int i8 = this.f5848I$3;
                    int i9 = this.f5847I$2;
                    int i10 = this.f5846I$1;
                    int i11 = this.f5845I$0;
                    producerScope = (ProducerScope) this.f5857L$8;
                    Object obj4 = this.f5856L$7;
                    Object obj5 = this.f5855L$6;
                    ChannelIterator channelIterator = (ChannelIterator) this.f5854L$5;
                    ReceiveChannel receiveChannel5 = (ReceiveChannel) this.f5853L$4;
                    ReceiveChannel receiveChannel6 = (ReceiveChannel) this.f5852L$3;
                    Function2 function23 = (Function2) this.f5851L$2;
                    ReceiveChannel receiveChannel7 = (ReceiveChannel) this.f5850L$1;
                    try {
                        ResultKt.throwOnFailure(obj);
                        receiveChannel4 = receiveChannel7;
                        obj2 = obj5;
                        it = channelIterator;
                        function22 = function23;
                        receiveChannel2 = receiveChannel5;
                        i6 = i8;
                        i = i9;
                        i5 = i10;
                        i4 = i11;
                        objMo2167invoke = obj;
                        receiveChannel = receiveChannel6;
                        obj3 = obj4;
                        this.f5849L$0 = producerScope2;
                        this.f5850L$1 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                        this.f5851L$2 = function22;
                        this.f5852L$3 = receiveChannel;
                        this.f5853L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                        this.f5854L$5 = it;
                        this.f5855L$6 = SpillingKt.nullOutSpilledVariable(obj2);
                        this.f5856L$7 = SpillingKt.nullOutSpilledVariable(obj3);
                        this.f5857L$8 = null;
                        this.f5845I$0 = i4;
                        this.f5846I$1 = i5;
                        this.f5847I$2 = i;
                        this.f5848I$3 = i6;
                        this.f5858label = 3;
                        if (producerScope.mo7052send(objMo2167invoke, this) != coroutine_suspended) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        receiveChannel = receiveChannel6;
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            ChannelsKt.cancelConsumed(receiveChannel, th);
                            throw th3;
                        }
                    }
                } else {
                    if (i7 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = this.f5847I$2;
                    i5 = this.f5846I$1;
                    int i12 = this.f5845I$0;
                    ChannelIterator channelIterator2 = (ChannelIterator) this.f5854L$5;
                    ReceiveChannel receiveChannel8 = (ReceiveChannel) this.f5853L$4;
                    receiveChannel = (ReceiveChannel) this.f5852L$3;
                    function22 = (Function2) this.f5851L$2;
                    ReceiveChannel receiveChannel9 = (ReceiveChannel) this.f5850L$1;
                    ResultKt.throwOnFailure(obj);
                    i3 = i12;
                    it = channelIterator2;
                    receiveChannel2 = receiveChannel8;
                    receiveChannel3 = receiveChannel9;
                    i2 = i5;
                    function2 = function22;
                    this.f5849L$0 = producerScope2;
                    this.f5850L$1 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                    this.f5851L$2 = function2;
                    this.f5852L$3 = receiveChannel;
                    this.f5853L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                    this.f5854L$5 = it;
                    this.f5855L$6 = null;
                    this.f5856L$7 = null;
                    this.f5845I$0 = i3;
                    this.f5846I$1 = i2;
                    this.f5847I$2 = i;
                    this.f5858label = 1;
                    objMo7069hasNext = it.mo7069hasNext(this);
                    if (objMo7069hasNext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!((Boolean) objMo7069hasNext).booleanValue()) {
                        Object objMo7070next = it.mo7070next();
                        this.f5849L$0 = producerScope2;
                        this.f5850L$1 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                        this.f5851L$2 = function2;
                        this.f5852L$3 = receiveChannel;
                        this.f5853L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                        this.f5854L$5 = it;
                        this.f5855L$6 = SpillingKt.nullOutSpilledVariable(objMo7070next);
                        this.f5856L$7 = SpillingKt.nullOutSpilledVariable(objMo7070next);
                        this.f5857L$8 = producerScope2;
                        this.f5845I$0 = i3;
                        this.f5846I$1 = i2;
                        this.f5847I$2 = i;
                        this.f5848I$3 = 0;
                        this.f5858label = 2;
                        objMo2167invoke = function2.mo2167invoke(objMo7070next, this);
                        if (objMo2167invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel4 = receiveChannel3;
                        obj2 = objMo7070next;
                        i4 = i3;
                        obj3 = obj2;
                        producerScope = producerScope2;
                        Function2 function24 = function2;
                        i5 = i2;
                        i6 = 0;
                        function22 = function24;
                        this.f5849L$0 = producerScope2;
                        this.f5850L$1 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                        this.f5851L$2 = function22;
                        this.f5852L$3 = receiveChannel;
                        this.f5853L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                        this.f5854L$5 = it;
                        this.f5855L$6 = SpillingKt.nullOutSpilledVariable(obj2);
                        this.f5856L$7 = SpillingKt.nullOutSpilledVariable(obj3);
                        this.f5857L$8 = null;
                        this.f5845I$0 = i4;
                        this.f5846I$1 = i5;
                        this.f5847I$2 = i;
                        this.f5848I$3 = i6;
                        this.f5858label = 3;
                        if (producerScope.mo7052send(objMo2167invoke, this) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i3 = i4;
                        receiveChannel3 = receiveChannel4;
                        i2 = i5;
                        function2 = function22;
                        this.f5849L$0 = producerScope2;
                        this.f5850L$1 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                        this.f5851L$2 = function2;
                        this.f5852L$3 = receiveChannel;
                        this.f5853L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                        this.f5854L$5 = it;
                        this.f5855L$6 = null;
                        this.f5856L$7 = null;
                        this.f5845I$0 = i3;
                        this.f5846I$1 = i2;
                        this.f5847I$2 = i;
                        this.f5858label = 1;
                        objMo7069hasNext = it.mo7069hasNext(this);
                        if (objMo7069hasNext == coroutine_suspended) {
                        }
                        if (!((Boolean) objMo7069hasNext).booleanValue()) {
                            C1133Unit c1133Unit = C1133Unit.INSTANCE;
                            ChannelsKt.cancelConsumed(receiveChannel, null);
                            return C1133Unit.INSTANCE;
                        }
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(ProducerScope<? super R> producerScope, Continuation<? super C1133Unit> continuation) {
            return ((C13911) mo2166create(producerScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", m6124f = "Deprecated.kt", m6125i = {0, 0, 1, 1, 1, 2, 2, 2}, m6126l = {374, 375, 375}, m6127m = "invokeSuspend", m6128n = {"$this$produce", "index", "$this$produce", "e", "index", "$this$produce", "e", "index"}, m6130s = {"L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "L$2", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1 */
    public static final class C13921<R> extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ ReceiveChannel<E> $this_mapIndexed;
        final /* synthetic */ Function3<Integer, E, Continuation<? super R>, Object> $transform;

        /* renamed from: I$0 */
        int f5859I$0;

        /* renamed from: L$0 */
        private /* synthetic */ Object f5860L$0;

        /* renamed from: L$1 */
        Object f5861L$1;

        /* renamed from: L$2 */
        Object f5862L$2;

        /* renamed from: L$3 */
        Object f5863L$3;

        /* renamed from: label */
        int f5864label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C13921(ReceiveChannel<? extends E> receiveChannel, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super C13921> continuation) {
            super(2, continuation);
            this.$this_mapIndexed = receiveChannel;
            this.$transform = function3;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C13921 c13921 = new C13921(this.$this_mapIndexed, this.$transform, continuation);
            c13921.f5860L$0 = obj;
            return c13921;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00a2 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00a3  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00a5  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00a3 -> B:13:0x004d). Please report as a decompilation issue!!! */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i;
            ChannelIterator it;
            ChannelIterator channelIterator;
            Object objMo7070next;
            ProducerScope producerScope;
            ProducerScope producerScope2 = (ProducerScope) this.f5860L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.f5864label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                i = 0;
                it = this.$this_mapIndexed.iterator();
            } else if (i2 == 1) {
                i = this.f5859I$0;
                it = (ChannelIterator) this.f5861L$1;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    return C1133Unit.INSTANCE;
                }
                objMo7070next = it.mo7070next();
                Function3<Integer, E, Continuation<? super R>, Object> function3 = this.$transform;
                int i3 = i + 1;
                Integer numM6121boxInt = C1207Boxing.m6121boxInt(i);
                this.f5860L$0 = producerScope2;
                this.f5861L$1 = it;
                this.f5862L$2 = SpillingKt.nullOutSpilledVariable(objMo7070next);
                this.f5863L$3 = producerScope2;
                this.f5859I$0 = i3;
                this.f5864label = 2;
                obj = function3.mo6219invoke(numM6121boxInt, objMo7070next, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = i3;
                channelIterator = it;
                producerScope = producerScope2;
                this.f5860L$0 = producerScope2;
                this.f5861L$1 = channelIterator;
                this.f5862L$2 = SpillingKt.nullOutSpilledVariable(objMo7070next);
                this.f5863L$3 = null;
                this.f5859I$0 = i;
                this.f5864label = 3;
                if (producerScope.mo7052send(obj, this) != coroutine_suspended) {
                }
            } else if (i2 == 2) {
                i = this.f5859I$0;
                producerScope = (ProducerScope) this.f5863L$3;
                objMo7070next = this.f5862L$2;
                channelIterator = (ChannelIterator) this.f5861L$1;
                ResultKt.throwOnFailure(obj);
                this.f5860L$0 = producerScope2;
                this.f5861L$1 = channelIterator;
                this.f5862L$2 = SpillingKt.nullOutSpilledVariable(objMo7070next);
                this.f5863L$3 = null;
                this.f5859I$0 = i;
                this.f5864label = 3;
                if (producerScope.mo7052send(obj, this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                it = channelIterator;
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.f5859I$0;
                it = (ChannelIterator) this.f5861L$1;
                ResultKt.throwOnFailure(obj);
            }
            this.f5860L$0 = producerScope2;
            this.f5861L$1 = it;
            this.f5862L$2 = null;
            this.f5859I$0 = i;
            this.f5864label = 1;
            obj = it.mo7069hasNext(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (((Boolean) obj).booleanValue()) {
            }
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(ProducerScope<? super R> producerScope, Continuation<? super C1133Unit> continuation) {
            return ((C13921) mo2166create(producerScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, m6126l = {450, 452}, m6127m = "maxWith", m6128n = {"$this$maxWith", "comparator", "$this$consume$iv", "$this$maxWith_u24lambda_u240", "iterator", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$maxWith$2", "$this$maxWith", "comparator", "$this$consume$iv", "$this$maxWith_u24lambda_u240", "iterator", "max", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$maxWith$2"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$maxWith$1 */
    public static final class C13931<E> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5865I$0;

        /* renamed from: I$1 */
        int f5866I$1;

        /* renamed from: L$0 */
        Object f5867L$0;

        /* renamed from: L$1 */
        Object f5868L$1;

        /* renamed from: L$2 */
        Object f5869L$2;

        /* renamed from: L$3 */
        Object f5870L$3;

        /* renamed from: L$4 */
        Object f5871L$4;

        /* renamed from: L$5 */
        Object f5872L$5;

        /* renamed from: label */
        int f5873label;

        /* renamed from: result */
        /* synthetic */ Object f5874result;

        public C13931(Continuation<? super C13931> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5874result = obj;
            this.f5873label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.m7122maxWith(null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, m6126l = {464, 466}, m6127m = "minWith", m6128n = {"$this$minWith", "comparator", "$this$consume$iv", "$this$minWith_u24lambda_u240", "iterator", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$minWith$2", "$this$minWith", "comparator", "$this$consume$iv", "$this$minWith_u24lambda_u240", "iterator", "min", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$minWith$2"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1 */
    public static final class C13941<E> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5875I$0;

        /* renamed from: I$1 */
        int f5876I$1;

        /* renamed from: L$0 */
        Object f5877L$0;

        /* renamed from: L$1 */
        Object f5878L$1;

        /* renamed from: L$2 */
        Object f5879L$2;

        /* renamed from: L$3 */
        Object f5880L$3;

        /* renamed from: L$4 */
        Object f5881L$4;

        /* renamed from: L$5 */
        Object f5882L$5;

        /* renamed from: label */
        int f5883label;

        /* renamed from: result */
        /* synthetic */ Object f5884result;

        public C13941(Continuation<? super C13941> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5884result = obj;
            this.f5883label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.m7123minWith(null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0}, m6126l = {477}, m6127m = "none", m6128n = {"$this$none", "$this$consume$iv", "$this$none_u24lambda_u240", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$none$2"}, m6130s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1 */
    public static final class C13951<E> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5885I$0;

        /* renamed from: I$1 */
        int f5886I$1;

        /* renamed from: L$0 */
        Object f5887L$0;

        /* renamed from: L$1 */
        Object f5888L$1;

        /* renamed from: L$2 */
        Object f5889L$2;

        /* renamed from: label */
        int f5890label;

        /* renamed from: result */
        /* synthetic */ Object f5891result;

        public C13951(Continuation<? super C13951> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5891result = obj;
            this.f5890label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.m7125none(null, this);
        }
    }

    @Metadata(m4987d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0001H\n"}, m4988d2 = {"<anonymous>", "E", BuildConfig.f24315FLAVOR, "it"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$requireNoNulls$1", m6124f = "Deprecated.kt", m6125i = {}, m6126l = {}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$requireNoNulls$1 */
    public static final class C13961 extends SuspendLambda implements Function2 {
        final /* synthetic */ ReceiveChannel $this_requireNoNulls;

        /* renamed from: L$0 */
        /* synthetic */ Object f5892L$0;

        /* renamed from: label */
        int f5893label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13961(ReceiveChannel receiveChannel, Continuation continuation) {
            super(2, continuation);
            this.$this_requireNoNulls = receiveChannel;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C13961 c13961 = new C13961(this.$this_requireNoNulls, continuation);
            c13961.f5892L$0 = obj;
            return c13961;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2 = this.f5892L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5893label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (obj2 != null) {
                return obj2;
            }
            throw new IllegalArgumentException("null element found in " + this.$this_requireNoNulls + '.');
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(Object obj, Continuation continuation) {
            return ((C13961) mo2166create(obj, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, m6126l = {166, 169}, m6127m = "single", m6128n = {"$this$single", "$this$consume$iv", "$this$single_u24lambda_u240", "iterator", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$single$2", "$this$single", "$this$consume$iv", "$this$single_u24lambda_u240", "iterator", "single", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$single$2"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1 */
    public static final class C13971<E> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5894I$0;

        /* renamed from: I$1 */
        int f5895I$1;

        /* renamed from: L$0 */
        Object f5896L$0;

        /* renamed from: L$1 */
        Object f5897L$1;

        /* renamed from: L$2 */
        Object f5898L$2;

        /* renamed from: L$3 */
        Object f5899L$3;

        /* renamed from: L$4 */
        Object f5900L$4;

        /* renamed from: label */
        int f5901label;

        /* renamed from: result */
        /* synthetic */ Object f5902result;

        public C13971(Continuation<? super C13971> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5902result = obj;
            this.f5901label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.m7127single(null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, m6126l = {179, 182}, m6127m = "singleOrNull", m6128n = {"$this$singleOrNull", "$this$consume$iv", "$this$singleOrNull_u24lambda_u240", "iterator", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$singleOrNull$2", "$this$singleOrNull", "$this$consume$iv", "$this$singleOrNull_u24lambda_u240", "iterator", "single", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$singleOrNull$2"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1 */
    public static final class C13981<E> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5903I$0;

        /* renamed from: I$1 */
        int f5904I$1;

        /* renamed from: L$0 */
        Object f5905L$0;

        /* renamed from: L$1 */
        Object f5906L$1;

        /* renamed from: L$2 */
        Object f5907L$2;

        /* renamed from: L$3 */
        Object f5908L$3;

        /* renamed from: L$4 */
        Object f5909L$4;

        /* renamed from: label */
        int f5910label;

        /* renamed from: result */
        /* synthetic */ Object f5911result;

        public C13981(Continuation<? super C13981> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5911result = obj;
            this.f5910label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.singleOrNull(null, this);
        }
    }

    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", m6124f = "Deprecated.kt", m6125i = {0, 0, 1, 1, 1}, m6126l = {284, 285}, m6127m = "invokeSuspend", m6128n = {"$this$produce", "remaining", "$this$produce", "e", "remaining"}, m6130s = {"L$0", "I$0", "L$0", "L$2", "I$0"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$take$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,662:1\n1#2:663\n*E\n"})
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1 */
    public static final class C13991 extends SuspendLambda implements Function2 {

        /* renamed from: $n */
        final /* synthetic */ int f5912$n;
        final /* synthetic */ ReceiveChannel $this_take;

        /* renamed from: I$0 */
        int f5913I$0;

        /* renamed from: L$0 */
        private /* synthetic */ Object f5914L$0;

        /* renamed from: L$1 */
        Object f5915L$1;

        /* renamed from: L$2 */
        Object f5916L$2;

        /* renamed from: label */
        int f5917label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13991(int i, ReceiveChannel receiveChannel, Continuation continuation) {
            super(2, continuation);
            this.f5912$n = i;
            this.$this_take = receiveChannel;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C13991 c13991 = new C13991(this.f5912$n, this.$this_take, continuation);
            c13991.f5914L$0 = obj;
            return c13991;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0056 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0079 -> B:28:0x007c). Please report as a decompilation issue!!! */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i;
            ChannelIterator it;
            ChannelIterator channelIterator;
            int i2;
            Object objMo7069hasNext;
            ProducerScope producerScope = (ProducerScope) this.f5914L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f5917label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                i = this.f5912$n;
                if (i == 0) {
                    return C1133Unit.INSTANCE;
                }
                if (!(i >= 0)) {
                    throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
                }
                it = this.$this_take.iterator();
                this.f5914L$0 = producerScope;
                this.f5915L$1 = it;
                this.f5916L$2 = null;
                this.f5913I$0 = i;
                this.f5917label = 1;
                objMo7069hasNext = it.mo7069hasNext(this);
                if (objMo7069hasNext != coroutine_suspended) {
                }
            } else if (i3 == 1) {
                i2 = this.f5913I$0;
                channelIterator = (ChannelIterator) this.f5915L$1;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                }
            } else {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i2 = this.f5913I$0;
                channelIterator = (ChannelIterator) this.f5915L$1;
                ResultKt.throwOnFailure(obj);
                i = i2 - 1;
                if (i != 0) {
                    return C1133Unit.INSTANCE;
                }
                it = channelIterator;
                this.f5914L$0 = producerScope;
                this.f5915L$1 = it;
                this.f5916L$2 = null;
                this.f5913I$0 = i;
                this.f5917label = 1;
                objMo7069hasNext = it.mo7069hasNext(this);
                if (objMo7069hasNext != coroutine_suspended) {
                    return coroutine_suspended;
                }
                ChannelIterator channelIterator2 = it;
                i2 = i;
                obj = objMo7069hasNext;
                channelIterator = channelIterator2;
                if (((Boolean) obj).booleanValue()) {
                    return C1133Unit.INSTANCE;
                }
                Object objMo7070next = channelIterator.mo7070next();
                this.f5914L$0 = producerScope;
                this.f5915L$1 = channelIterator;
                this.f5916L$2 = SpillingKt.nullOutSpilledVariable(objMo7070next);
                this.f5913I$0 = i2;
                this.f5917label = 2;
                if (producerScope.mo7052send(objMo7070next, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = i2 - 1;
                if (i != 0) {
                }
            }
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(ProducerScope producerScope, Continuation continuation) {
            return ((C13991) mo2166create(producerScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1", m6124f = "Deprecated.kt", m6125i = {0, 1, 1, 2, 2}, m6126l = {299, 300, 301}, m6127m = "invokeSuspend", m6128n = {"$this$produce", "$this$produce", "e", "$this$produce", "e"}, m6130s = {"L$0", "L$0", "L$2", "L$0", "L$2"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1 */
    public static final class C14001 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function2 $predicate;
        final /* synthetic */ ReceiveChannel $this_takeWhile;

        /* renamed from: L$0 */
        private /* synthetic */ Object f5918L$0;

        /* renamed from: L$1 */
        Object f5919L$1;

        /* renamed from: L$2 */
        Object f5920L$2;

        /* renamed from: label */
        int f5921label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14001(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.$this_takeWhile = receiveChannel;
            this.$predicate = function2;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C14001 c14001 = new C14001(this.$this_takeWhile, this.$predicate, continuation);
            c14001.f5918L$0 = obj;
            return c14001;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0092  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0090 -> B:13:0x0041). Please report as a decompilation issue!!! */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ChannelIterator it;
            ChannelIterator channelIterator;
            Object obj2;
            ProducerScope producerScope = (ProducerScope) this.f5918L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5921label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                it = this.$this_takeWhile.iterator();
            } else if (i == 1) {
                it = (ChannelIterator) this.f5919L$1;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    return C1133Unit.INSTANCE;
                }
                Object objMo7070next = it.mo7070next();
                Function2 function2 = this.$predicate;
                this.f5918L$0 = producerScope;
                this.f5919L$1 = it;
                this.f5920L$2 = objMo7070next;
                this.f5921label = 2;
                Object objMo2167invoke = function2.mo2167invoke(objMo7070next, this);
                if (objMo2167invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ChannelIterator channelIterator2 = it;
                obj2 = objMo7070next;
                obj = objMo2167invoke;
                channelIterator = channelIterator2;
                if (((Boolean) obj).booleanValue()) {
                }
            } else if (i == 2) {
                obj2 = this.f5920L$2;
                channelIterator = (ChannelIterator) this.f5919L$1;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    return C1133Unit.INSTANCE;
                }
                this.f5918L$0 = producerScope;
                this.f5919L$1 = channelIterator;
                this.f5920L$2 = SpillingKt.nullOutSpilledVariable(obj2);
                this.f5921label = 3;
                if (producerScope.mo7052send(obj2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                it = channelIterator;
            } else {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (ChannelIterator) this.f5919L$1;
                ResultKt.throwOnFailure(obj);
            }
            this.f5918L$0 = producerScope;
            this.f5919L$1 = it;
            this.f5920L$2 = null;
            this.f5921label = 1;
            obj = it.mo7069hasNext(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (((Boolean) obj).booleanValue()) {
            }
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(ProducerScope producerScope, Continuation continuation) {
            return ((C14001) mo2166create(producerScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, m6126l = {667, 308}, m6127m = "toChannel", m6128n = {"$this$toChannel", "destination", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv", "$this$toChannel", "destination", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "e$iv", "it", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv", "$i$a$-consumeEach-ChannelsKt__DeprecatedKt$toChannel$2"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1 */
    public static final class C14011<E, C extends SendChannel<? super E>> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5922I$0;

        /* renamed from: I$1 */
        int f5923I$1;

        /* renamed from: I$2 */
        int f5924I$2;

        /* renamed from: I$3 */
        int f5925I$3;

        /* renamed from: L$0 */
        Object f5926L$0;

        /* renamed from: L$1 */
        Object f5927L$1;

        /* renamed from: L$2 */
        Object f5928L$2;

        /* renamed from: L$3 */
        Object f5929L$3;

        /* renamed from: L$4 */
        Object f5930L$4;

        /* renamed from: L$5 */
        Object f5931L$5;

        /* renamed from: L$6 */
        Object f5932L$6;

        /* renamed from: L$7 */
        Object f5933L$7;

        /* renamed from: label */
        int f5934label;

        /* renamed from: result */
        /* synthetic */ Object f5935result;

        public C14011(Continuation<? super C14011> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5935result = obj;
            this.f5934label |= Integer.MIN_VALUE;
            return ChannelsKt.toChannel(null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0}, m6126l = {667}, m6127m = "toCollection", m6128n = {"$this$toCollection", "destination", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1 */
    public static final class C14021<E, C extends Collection<? super E>> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5936I$0;

        /* renamed from: I$1 */
        int f5937I$1;

        /* renamed from: I$2 */
        int f5938I$2;

        /* renamed from: L$0 */
        Object f5939L$0;

        /* renamed from: L$1 */
        Object f5940L$1;

        /* renamed from: L$2 */
        Object f5941L$2;

        /* renamed from: L$3 */
        Object f5942L$3;

        /* renamed from: L$4 */
        Object f5943L$4;

        /* renamed from: L$5 */
        Object f5944L$5;

        /* renamed from: label */
        int f5945label;

        /* renamed from: result */
        /* synthetic */ Object f5946result;

        public C14021(Continuation<? super C14021> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5946result = obj;
            this.f5945label |= Integer.MIN_VALUE;
            return ChannelsKt.toCollection(null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0}, m6126l = {667}, m6127m = "toMap", m6128n = {"$this$toMap", "destination", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2 */
    public static final class C14032<K, V, M extends Map<? super K, ? super V>> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5947I$0;

        /* renamed from: I$1 */
        int f5948I$1;

        /* renamed from: I$2 */
        int f5949I$2;

        /* renamed from: L$0 */
        Object f5950L$0;

        /* renamed from: L$1 */
        Object f5951L$1;

        /* renamed from: L$2 */
        Object f5952L$2;

        /* renamed from: L$3 */
        Object f5953L$3;

        /* renamed from: L$4 */
        Object f5954L$4;

        /* renamed from: L$5 */
        Object f5955L$5;

        /* renamed from: label */
        int f5956label;

        /* renamed from: result */
        /* synthetic */ Object f5957result;

        public C14032(Continuation<? super C14032> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5957result = obj;
            this.f5956label |= Integer.MIN_VALUE;
            return ChannelsKt.m7104toMap(null, null, this);
        }
    }

    @Metadata(m4987d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "E", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/collections/IndexedValue;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1", m6124f = "Deprecated.kt", m6125i = {0, 0, 1, 1, 1}, m6126l = {400, 401}, m6127m = "invokeSuspend", m6128n = {"$this$produce", "index", "$this$produce", "e", "index"}, m6130s = {"L$0", "I$0", "L$0", "L$2", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1 */
    public static final class C14041 extends SuspendLambda implements Function2 {
        final /* synthetic */ ReceiveChannel $this_withIndex;

        /* renamed from: I$0 */
        int f5958I$0;

        /* renamed from: L$0 */
        private /* synthetic */ Object f5959L$0;

        /* renamed from: L$1 */
        Object f5960L$1;

        /* renamed from: L$2 */
        Object f5961L$2;

        /* renamed from: label */
        int f5962label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14041(ReceiveChannel receiveChannel, Continuation continuation) {
            super(2, continuation);
            this.$this_withIndex = receiveChannel;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C14041 c14041 = new C14041(this.$this_withIndex, continuation);
            c14041.f5959L$0 = obj;
            return c14041;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0079  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0076 -> B:11:0x0039). Please report as a decompilation issue!!! */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ChannelIterator it;
            int i;
            ChannelIterator channelIterator;
            ProducerScope producerScope = (ProducerScope) this.f5959L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.f5962label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                it = this.$this_withIndex.iterator();
                i = 0;
            } else if (i2 == 1) {
                i = this.f5958I$0;
                channelIterator = (ChannelIterator) this.f5960L$1;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    return C1133Unit.INSTANCE;
                }
                Object objMo7070next = channelIterator.mo7070next();
                int i3 = i + 1;
                IndexedValue indexedValue = new IndexedValue(i, objMo7070next);
                this.f5959L$0 = producerScope;
                this.f5960L$1 = channelIterator;
                this.f5961L$2 = SpillingKt.nullOutSpilledVariable(objMo7070next);
                this.f5958I$0 = i3;
                this.f5962label = 2;
                if (producerScope.mo7052send(indexedValue, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                it = channelIterator;
                i = i3;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.f5958I$0;
                ChannelIterator channelIterator2 = (ChannelIterator) this.f5960L$1;
                ResultKt.throwOnFailure(obj);
                it = channelIterator2;
            }
            this.f5959L$0 = producerScope;
            this.f5960L$1 = it;
            this.f5961L$2 = null;
            this.f5958I$0 = i;
            this.f5962label = 1;
            Object objMo7069hasNext = it.mo7069hasNext(this);
            if (objMo7069hasNext == coroutine_suspended) {
                return coroutine_suspended;
            }
            channelIterator = it;
            obj = objMo7069hasNext;
            if (((Boolean) obj).booleanValue()) {
            }
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(ProducerScope producerScope, Continuation continuation) {
            return ((C14041) mo2166create(producerScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V] */
    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "V", "Lkotlinx/coroutines/channels/ProducerScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", m6124f = "Deprecated.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, m6126l = {667, 499, 501}, m6127m = "invokeSuspend", m6128n = {"$this$produce", "otherIterator", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv", "$this$produce", "otherIterator", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "e$iv", "element1", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv", "$i$a$-consumeEach-ChannelsKt__DeprecatedKt$zip$2$1", "$this$produce", "otherIterator", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "e$iv", "element1", "element2", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv", "$i$a$-consumeEach-ChannelsKt__DeprecatedKt$zip$2$1"}, m6130s = {"L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$4", "L$5", "L$7", "L$8", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$4", "L$5", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2", "I$3"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$zip$2\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,662:1\n156#2:663\n97#2,3:664\n157#2,2:667\n104#2:669\n100#2,3:670\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$zip$2\n*L\n498#1:663\n498#1:664,3\n498#1:667,2\n498#1:669\n498#1:670,3\n*E\n"})
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2 */
    public static final class C14052<V> extends SuspendLambda implements Function2<ProducerScope<? super V>, Continuation<? super C1133Unit>, Object> {

        /* renamed from: $other */
        final /* synthetic */ ReceiveChannel<R> f5963$other;
        final /* synthetic */ ReceiveChannel<E> $this_zip;
        final /* synthetic */ Function2<E, R, V> $transform;

        /* renamed from: I$0 */
        int f5964I$0;

        /* renamed from: I$1 */
        int f5965I$1;

        /* renamed from: I$2 */
        int f5966I$2;

        /* renamed from: I$3 */
        int f5967I$3;

        /* renamed from: L$0 */
        private /* synthetic */ Object f5968L$0;

        /* renamed from: L$1 */
        Object f5969L$1;

        /* renamed from: L$2 */
        Object f5970L$2;

        /* renamed from: L$3 */
        Object f5971L$3;

        /* renamed from: L$4 */
        Object f5972L$4;

        /* renamed from: L$5 */
        Object f5973L$5;

        /* renamed from: L$6 */
        Object f5974L$6;

        /* renamed from: L$7 */
        Object f5975L$7;

        /* renamed from: L$8 */
        Object f5976L$8;

        /* renamed from: L$9 */
        Object f5977L$9;

        /* renamed from: label */
        int f5978label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C14052(ReceiveChannel<? extends R> receiveChannel, ReceiveChannel<? extends E> receiveChannel2, Function2<? super E, ? super R, ? extends V> function2, Continuation<? super C14052> continuation) {
            super(2, continuation);
            this.f5963$other = receiveChannel;
            this.$this_zip = receiveChannel2;
            this.$transform = function2;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C14052 c14052 = new C14052(this.f5963$other, this.$this_zip, this.$transform, continuation);
            c14052.f5968L$0 = obj;
            return c14052;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00f0 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00f9 A[Catch: all -> 0x003d, TryCatch #1 {all -> 0x003d, blocks: (B:8:0x0036, B:24:0x00c5, B:27:0x00f1, B:29:0x00f9, B:33:0x013d, B:35:0x0145, B:42:0x01a4, B:20:0x00a5, B:23:0x00b9), top: B:51:0x0010 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0145 A[Catch: all -> 0x003d, TryCatch #1 {all -> 0x003d, blocks: (B:8:0x0036, B:24:0x00c5, B:27:0x00f1, B:29:0x00f9, B:33:0x013d, B:35:0x0145, B:42:0x01a4, B:20:0x00a5, B:23:0x00b9), top: B:51:0x0010 }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0195  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x01a4 A[Catch: all -> 0x003d, TRY_LEAVE, TryCatch #1 {all -> 0x003d, blocks: (B:8:0x0036, B:24:0x00c5, B:27:0x00f1, B:29:0x00f9, B:33:0x013d, B:35:0x0145, B:42:0x01a4, B:20:0x00a5, B:23:0x00b9), top: B:51:0x0010 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0189 -> B:39:0x018f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0195 -> B:41:0x019f). Please report as a decompilation issue!!! */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Throwable th;
            ReceiveChannel receiveChannel;
            ChannelIterator channelIterator;
            Function2 function2;
            ChannelIterator it;
            ReceiveChannel receiveChannel2;
            ReceiveChannel receiveChannel3;
            int i;
            int i2;
            int i3;
            ReceiveChannel receiveChannel4;
            Function2 function22;
            Object objMo7070next;
            Object objMo7069hasNext;
            ChannelIterator channelIterator2;
            int i4;
            int i5;
            ChannelIterator channelIterator3;
            Object obj2;
            int i6;
            Object objMo7069hasNext2;
            ProducerScope producerScope = (ProducerScope) this.f5968L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i7 = this.f5978label;
            Object obj3 = null;
            try {
                if (i7 == 0) {
                    ResultKt.throwOnFailure(obj);
                    ChannelIterator it2 = this.f5963$other.iterator();
                    receiveChannel = this.$this_zip;
                    channelIterator = it2;
                    function2 = this.$transform;
                    it = receiveChannel.iterator();
                    receiveChannel2 = receiveChannel;
                    receiveChannel3 = receiveChannel2;
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    this.f5968L$0 = producerScope;
                    this.f5969L$1 = channelIterator;
                    this.f5970L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                    this.f5971L$3 = function2;
                    this.f5972L$4 = receiveChannel;
                    this.f5973L$5 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                    this.f5974L$6 = it;
                    this.f5975L$7 = obj3;
                    this.f5976L$8 = obj3;
                    this.f5977L$9 = obj3;
                    this.f5964I$0 = i3;
                    this.f5965I$1 = i2;
                    this.f5966I$2 = i;
                    this.f5978label = 1;
                    objMo7069hasNext2 = it.mo7069hasNext(this);
                    if (objMo7069hasNext2 == coroutine_suspended) {
                    }
                    if (((Boolean) objMo7069hasNext2).booleanValue()) {
                    }
                } else if (i7 == 1) {
                    i = this.f5966I$2;
                    i2 = this.f5965I$1;
                    i3 = this.f5964I$0;
                    it = (ChannelIterator) this.f5974L$6;
                    receiveChannel2 = (ReceiveChannel) this.f5973L$5;
                    receiveChannel = (ReceiveChannel) this.f5972L$4;
                    function2 = (Function2) this.f5971L$3;
                    receiveChannel3 = (ReceiveChannel) this.f5970L$2;
                    channelIterator = (ChannelIterator) this.f5969L$1;
                    ResultKt.throwOnFailure(obj);
                    objMo7069hasNext2 = obj;
                    if (((Boolean) objMo7069hasNext2).booleanValue()) {
                    }
                } else if (i7 == 2) {
                    int i8 = this.f5967I$3;
                    int i9 = this.f5966I$2;
                    i5 = this.f5965I$1;
                    i4 = this.f5964I$0;
                    Object obj4 = this.f5976L$8;
                    Object obj5 = this.f5975L$7;
                    ChannelIterator channelIterator4 = (ChannelIterator) this.f5974L$6;
                    ReceiveChannel receiveChannel5 = (ReceiveChannel) this.f5973L$5;
                    ReceiveChannel receiveChannel6 = (ReceiveChannel) this.f5972L$4;
                    Function2 function23 = (Function2) this.f5971L$3;
                    ReceiveChannel receiveChannel7 = (ReceiveChannel) this.f5970L$2;
                    channelIterator3 = (ChannelIterator) this.f5969L$1;
                    try {
                        ResultKt.throwOnFailure(obj);
                        receiveChannel4 = receiveChannel7;
                        receiveChannel2 = receiveChannel5;
                        objMo7070next = obj4;
                        channelIterator2 = channelIterator4;
                        receiveChannel = receiveChannel6;
                        function22 = function23;
                        obj2 = obj5;
                        objMo7069hasNext = obj;
                        i6 = i8;
                        i = i9;
                        if (((Boolean) objMo7069hasNext).booleanValue()) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        receiveChannel = receiveChannel6;
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            ChannelsKt.cancelConsumed(receiveChannel, th);
                            throw th3;
                        }
                    }
                } else {
                    if (i7 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = this.f5966I$2;
                    i5 = this.f5965I$1;
                    i4 = this.f5964I$0;
                    channelIterator2 = (ChannelIterator) this.f5974L$6;
                    ReceiveChannel receiveChannel8 = (ReceiveChannel) this.f5973L$5;
                    receiveChannel = (ReceiveChannel) this.f5972L$4;
                    Function2 function24 = (Function2) this.f5971L$3;
                    ReceiveChannel receiveChannel9 = (ReceiveChannel) this.f5970L$2;
                    ChannelIterator channelIterator5 = (ChannelIterator) this.f5969L$1;
                    ResultKt.throwOnFailure(obj);
                    ChannelIterator channelIterator6 = channelIterator5;
                    it = channelIterator2;
                    receiveChannel2 = receiveChannel8;
                    channelIterator = channelIterator6;
                    i3 = i4;
                    receiveChannel3 = receiveChannel9;
                    i2 = i5;
                    function2 = function24;
                    obj3 = null;
                    this.f5968L$0 = producerScope;
                    this.f5969L$1 = channelIterator;
                    this.f5970L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                    this.f5971L$3 = function2;
                    this.f5972L$4 = receiveChannel;
                    this.f5973L$5 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                    this.f5974L$6 = it;
                    this.f5975L$7 = obj3;
                    this.f5976L$8 = obj3;
                    this.f5977L$9 = obj3;
                    this.f5964I$0 = i3;
                    this.f5965I$1 = i2;
                    this.f5966I$2 = i;
                    this.f5978label = 1;
                    objMo7069hasNext2 = it.mo7069hasNext(this);
                    if (objMo7069hasNext2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (((Boolean) objMo7069hasNext2).booleanValue()) {
                        objMo7070next = it.mo7070next();
                        this.f5968L$0 = producerScope;
                        this.f5969L$1 = channelIterator;
                        this.f5970L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                        this.f5971L$3 = function2;
                        this.f5972L$4 = receiveChannel;
                        this.f5973L$5 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                        this.f5974L$6 = it;
                        this.f5975L$7 = SpillingKt.nullOutSpilledVariable(objMo7070next);
                        this.f5976L$8 = objMo7070next;
                        this.f5964I$0 = i3;
                        this.f5965I$1 = i2;
                        this.f5966I$2 = i;
                        this.f5967I$3 = 0;
                        this.f5978label = 2;
                        objMo7069hasNext = channelIterator.mo7069hasNext(this);
                        if (objMo7069hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel4 = receiveChannel3;
                        i4 = i3;
                        obj2 = objMo7070next;
                        Function2 function25 = function2;
                        i5 = i2;
                        i6 = 0;
                        function22 = function25;
                        ChannelIterator channelIterator7 = channelIterator;
                        channelIterator2 = it;
                        channelIterator3 = channelIterator7;
                        if (((Boolean) objMo7069hasNext).booleanValue()) {
                            ChannelIterator channelIterator8 = channelIterator3;
                            i3 = i4;
                            it = channelIterator2;
                            function24 = function22;
                            receiveChannel3 = receiveChannel4;
                            channelIterator = channelIterator8;
                            i2 = i5;
                            function2 = function24;
                            obj3 = null;
                            this.f5968L$0 = producerScope;
                            this.f5969L$1 = channelIterator;
                            this.f5970L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                            this.f5971L$3 = function2;
                            this.f5972L$4 = receiveChannel;
                            this.f5973L$5 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                            this.f5974L$6 = it;
                            this.f5975L$7 = obj3;
                            this.f5976L$8 = obj3;
                            this.f5977L$9 = obj3;
                            this.f5964I$0 = i3;
                            this.f5965I$1 = i2;
                            this.f5966I$2 = i;
                            this.f5978label = 1;
                            objMo7069hasNext2 = it.mo7069hasNext(this);
                            if (objMo7069hasNext2 == coroutine_suspended) {
                            }
                            if (((Boolean) objMo7069hasNext2).booleanValue()) {
                            }
                        } else {
                            Object objMo7070next2 = channelIterator3.mo7070next();
                            Object objMo2167invoke = function22.mo2167invoke(objMo7070next, objMo7070next2);
                            this.f5968L$0 = producerScope;
                            this.f5969L$1 = channelIterator3;
                            ChannelIterator channelIterator9 = channelIterator3;
                            this.f5970L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                            this.f5971L$3 = function22;
                            this.f5972L$4 = receiveChannel;
                            this.f5973L$5 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                            this.f5974L$6 = channelIterator2;
                            this.f5975L$7 = SpillingKt.nullOutSpilledVariable(obj2);
                            this.f5976L$8 = SpillingKt.nullOutSpilledVariable(objMo7070next);
                            this.f5977L$9 = SpillingKt.nullOutSpilledVariable(objMo7070next2);
                            this.f5964I$0 = i4;
                            this.f5965I$1 = i5;
                            this.f5966I$2 = i;
                            this.f5967I$3 = i6;
                            this.f5978label = 3;
                            if (producerScope.mo7052send(objMo2167invoke, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            channelIterator6 = channelIterator9;
                            receiveChannel8 = receiveChannel2;
                            function24 = function22;
                            receiveChannel9 = receiveChannel4;
                            it = channelIterator2;
                            receiveChannel2 = receiveChannel8;
                            channelIterator = channelIterator6;
                            i3 = i4;
                            receiveChannel3 = receiveChannel9;
                            i2 = i5;
                            function2 = function24;
                            obj3 = null;
                            this.f5968L$0 = producerScope;
                            this.f5969L$1 = channelIterator;
                            this.f5970L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                            this.f5971L$3 = function2;
                            this.f5972L$4 = receiveChannel;
                            this.f5973L$5 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                            this.f5974L$6 = it;
                            this.f5975L$7 = obj3;
                            this.f5976L$8 = obj3;
                            this.f5977L$9 = obj3;
                            this.f5964I$0 = i3;
                            this.f5965I$1 = i2;
                            this.f5966I$2 = i;
                            this.f5978label = 1;
                            objMo7069hasNext2 = it.mo7069hasNext(this);
                            if (objMo7069hasNext2 == coroutine_suspended) {
                            }
                            if (((Boolean) objMo7069hasNext2).booleanValue()) {
                                C1133Unit c1133Unit = C1133Unit.INSTANCE;
                                ChannelsKt.cancelConsumed(receiveChannel, null);
                                return C1133Unit.INSTANCE;
                            }
                        }
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(ProducerScope<? super V> producerScope, Continuation<? super C1133Unit> continuation) {
            return ((C14052) mo2166create(producerScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    /* renamed from: any */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object m7112any(ReceiveChannel receiveChannel, Continuation continuation) {
        C13691 c13691;
        if (continuation instanceof C13691) {
            c13691 = (C13691) continuation;
            int i = c13691.f5682label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13691.f5682label = i - Integer.MIN_VALUE;
            } else {
                c13691 = new C13691(continuation);
            }
        }
        Object objMo7069hasNext = c13691.f5683result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c13691.f5682label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objMo7069hasNext);
                ChannelIterator it = receiveChannel.iterator();
                c13691.f5679L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                c13691.f5680L$1 = receiveChannel;
                c13691.f5681L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                c13691.f5677I$0 = 0;
                c13691.f5678I$1 = 0;
                c13691.f5682label = 1;
                objMo7069hasNext = it.mo7069hasNext(c13691);
                if (objMo7069hasNext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                receiveChannel = (ReceiveChannel) c13691.f5680L$1;
                ResultKt.throwOnFailure(objMo7069hasNext);
            }
            ChannelsKt.cancelConsumed(receiveChannel, null);
            return objMo7069hasNext;
        } finally {
        }
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @ObsoleteCoroutinesApi
    /* renamed from: consume */
    public static final <E, R> R m7113consume(BroadcastChannel<E> broadcastChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        ReceiveChannel<E> receiveChannelOpenSubscription = broadcastChannel.openSubscription();
        try {
            return function1.mo2237invoke(receiveChannelOpenSubscription);
        } finally {
            InlineMarker.finallyStart(1);
            ReceiveChannel.cancel$default((ReceiveChannel) receiveChannelOpenSubscription, (CancellationException) null, 1, (Object) null);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0097 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a4 A[Catch: all -> 0x00ae, TryCatch #1 {all -> 0x00ae, blocks: (B:25:0x009c, B:27:0x00a4, B:30:0x00b1), top: B:38:0x009c }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1 A[Catch: all -> 0x00ae, TRY_LEAVE, TryCatch #1 {all -> 0x00ae, blocks: (B:25:0x009c, B:27:0x00a4, B:30:0x00b1), top: B:38:0x009c }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0098 -> B:38:0x009c). Please report as a decompilation issue!!! */
    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object consumeEach(BroadcastChannel<E> broadcastChannel, Function1<? super E, C1133Unit> function1, Continuation<? super C1133Unit> continuation) throws Throwable {
        C13701 c13701;
        ReceiveChannel<E> receiveChannel;
        int i;
        C13701 c137012;
        int i2;
        int i3;
        ReceiveChannel<E> receiveChannel2;
        ReceiveChannel<E> receiveChannel3;
        ChannelIterator it;
        Function1<? super E, C1133Unit> function12;
        BroadcastChannel<E> broadcastChannel2;
        Object objMo7069hasNext;
        if (continuation instanceof C13701) {
            c13701 = (C13701) continuation;
            int i4 = c13701.f5693label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c13701.f5693label = i4 - Integer.MIN_VALUE;
            } else {
                c13701 = new C13701(continuation);
            }
        }
        Object obj = c13701.f5694result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c13701.f5693label;
        try {
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                ReceiveChannel<E> receiveChannelOpenSubscription = broadcastChannel.openSubscription();
                i = 0;
                c137012 = c13701;
                i2 = 0;
                i3 = 0;
                receiveChannel2 = receiveChannelOpenSubscription;
                receiveChannel3 = receiveChannel2;
                it = receiveChannelOpenSubscription.iterator();
                function12 = function1;
                broadcastChannel2 = broadcastChannel;
                c137012.f5687L$0 = SpillingKt.nullOutSpilledVariable(broadcastChannel);
                c137012.f5688L$1 = function12;
                c137012.f5689L$2 = SpillingKt.nullOutSpilledVariable(broadcastChannel2);
                c137012.f5690L$3 = receiveChannel3;
                c137012.f5691L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                c137012.f5692L$5 = it;
                c137012.f5684I$0 = i3;
                c137012.f5685I$1 = i2;
                c137012.f5686I$2 = i;
                c137012.f5693label = 1;
                objMo7069hasNext = it.mo7069hasNext(c137012);
                if (objMo7069hasNext != coroutine_suspended) {
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i6 = c13701.f5686I$2;
                int i7 = c13701.f5685I$1;
                int i8 = c13701.f5684I$0;
                ChannelIterator channelIterator = (ChannelIterator) c13701.f5692L$5;
                ReceiveChannel<E> receiveChannel4 = (ReceiveChannel) c13701.f5691L$4;
                ReceiveChannel<E> receiveChannel5 = (ReceiveChannel) c13701.f5690L$3;
                BroadcastChannel<E> broadcastChannel3 = (BroadcastChannel) c13701.f5689L$2;
                Function1<? super E, C1133Unit> function13 = (Function1) c13701.f5688L$1;
                BroadcastChannel<E> broadcastChannel4 = (BroadcastChannel) c13701.f5687L$0;
                ResultKt.throwOnFailure(obj);
                i = i6;
                broadcastChannel = broadcastChannel4;
                ReceiveChannel<E> receiveChannel6 = receiveChannel5;
                it = channelIterator;
                c137012 = c13701;
                i2 = i7;
                broadcastChannel2 = broadcastChannel3;
                receiveChannel2 = receiveChannel4;
                i3 = i8;
                try {
                    if (!((Boolean) obj).booleanValue()) {
                        function13.mo2237invoke((Object) it.mo7070next());
                        function12 = function13;
                        receiveChannel3 = receiveChannel6;
                        try {
                            c137012.f5687L$0 = SpillingKt.nullOutSpilledVariable(broadcastChannel);
                            c137012.f5688L$1 = function12;
                            c137012.f5689L$2 = SpillingKt.nullOutSpilledVariable(broadcastChannel2);
                            c137012.f5690L$3 = receiveChannel3;
                            c137012.f5691L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                            c137012.f5692L$5 = it;
                            c137012.f5684I$0 = i3;
                            c137012.f5685I$1 = i2;
                            c137012.f5686I$2 = i;
                            c137012.f5693label = 1;
                            objMo7069hasNext = it.mo7069hasNext(c137012);
                            if (objMo7069hasNext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ReceiveChannel<E> receiveChannel7 = receiveChannel3;
                            function13 = function12;
                            obj = objMo7069hasNext;
                            receiveChannel6 = receiveChannel7;
                            if (!((Boolean) obj).booleanValue()) {
                                C1133Unit c1133Unit = C1133Unit.INSTANCE;
                                InlineMarker.finallyStart(1);
                                ReceiveChannel.cancel$default((ReceiveChannel) receiveChannel6, (CancellationException) null, 1, (Object) null);
                                InlineMarker.finallyEnd(1);
                                return C1133Unit.INSTANCE;
                            }
                        } catch (Throwable th) {
                            th = th;
                            receiveChannel = receiveChannel3;
                            InlineMarker.finallyStart(1);
                            ReceiveChannel.cancel$default((ReceiveChannel) receiveChannel, (CancellationException) null, 1, (Object) null);
                            InlineMarker.finallyEnd(1);
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    receiveChannel = receiveChannel6;
                    InlineMarker.finallyStart(1);
                    ReceiveChannel.cancel$default((ReceiveChannel) receiveChannel, (CancellationException) null, 1, (Object) null);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    private static final <E> Object consumeEach$$forInline(BroadcastChannel<E> broadcastChannel, Function1<? super E, C1133Unit> function1, Continuation<? super C1133Unit> continuation) {
        ReceiveChannel<E> receiveChannelOpenSubscription = broadcastChannel.openSubscription();
        try {
            ChannelIterator<E> it = receiveChannelOpenSubscription.iterator();
            while (true) {
                InlineMarker.m6315mark(3);
                InlineMarker.m6315mark(0);
                Object objMo7069hasNext = it.mo7069hasNext(null);
                InlineMarker.m6315mark(1);
                if (!((Boolean) objMo7069hasNext).booleanValue()) {
                    C1133Unit c1133Unit = C1133Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ReceiveChannel.cancel$default((ReceiveChannel) receiveChannelOpenSubscription, (CancellationException) null, 1, (Object) null);
                    InlineMarker.finallyEnd(1);
                    return C1133Unit.INSTANCE;
                }
                function1.mo2237invoke(it.mo7070next());
            }
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            ReceiveChannel.cancel$default((ReceiveChannel) receiveChannelOpenSubscription, (CancellationException) null, 1, (Object) null);
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    @PublishedApi
    public static final Function1<Throwable, C1133Unit> consumes(final ReceiveChannel<?> receiveChannel) {
        return new Function1() { // from class: kotlinx.coroutines.channels.mjFkc
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return ChannelsKt__DeprecatedKt.consumes$lambda$0$ChannelsKt__DeprecatedKt(receiveChannel, (Throwable) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1133Unit consumes$lambda$0$ChannelsKt__DeprecatedKt(ReceiveChannel receiveChannel, Throwable th) {
        ChannelsKt.cancelConsumed(receiveChannel, th);
        return C1133Unit.INSTANCE;
    }

    @PublishedApi
    public static final Function1<Throwable, C1133Unit> consumesAll(final ReceiveChannel<?>... receiveChannelArr) {
        return new Function1() { // from class: kotlinx.coroutines.channels.AZxh
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return ChannelsKt__DeprecatedKt.consumesAll$lambda$0$ChannelsKt__DeprecatedKt(receiveChannelArr, (Throwable) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1133Unit consumesAll$lambda$0$ChannelsKt__DeprecatedKt(ReceiveChannel[] receiveChannelArr, Throwable th) throws Throwable {
        Throwable th2 = null;
        for (ReceiveChannel receiveChannel : receiveChannelArr) {
            try {
                ChannelsKt.cancelConsumed(receiveChannel, th);
            } catch (Throwable th3) {
                if (th2 == null) {
                    th2 = th3;
                } else {
                    ExceptionsKt.addSuppressed(th2, th3);
                }
            }
        }
        if (th2 == null) {
            return C1133Unit.INSTANCE;
        }
        throw th2;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a7 A[Catch: all -> 0x00b3, TryCatch #2 {all -> 0x00b3, blocks: (B:25:0x009f, B:27:0x00a7, B:21:0x0073, B:30:0x00b5), top: B:43:0x009f }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b5 A[Catch: all -> 0x00b3, TRY_LEAVE, TryCatch #2 {all -> 0x00b3, blocks: (B:25:0x009f, B:27:0x00a7, B:21:0x0073, B:30:0x00b5), top: B:43:0x009f }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x009a -> B:43:0x009f). Please report as a decompilation issue!!! */
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    /* renamed from: count */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object m7114count(ReceiveChannel receiveChannel, Continuation continuation) {
        C13711 c13711;
        ReceiveChannel receiveChannel2;
        Throwable th;
        int i;
        C1235Ref.IntRef intRef;
        C13711 c137112;
        ChannelIterator it;
        int i2;
        int i3;
        ReceiveChannel receiveChannel3;
        ReceiveChannel receiveChannel4;
        Object objMo7069hasNext;
        if (continuation instanceof C13711) {
            c13711 = (C13711) continuation;
            int i4 = c13711.f5704label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c13711.f5704label = i4 - Integer.MIN_VALUE;
            } else {
                c13711 = new C13711(continuation);
            }
        }
        Object obj = c13711.f5705result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c13711.f5704label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                i = 0;
                intRef = new C1235Ref.IntRef();
                c137112 = c13711;
                it = receiveChannel.iterator();
                i2 = 0;
                i3 = 0;
                receiveChannel3 = receiveChannel;
                receiveChannel2 = receiveChannel3;
                receiveChannel4 = receiveChannel2;
                c137112.f5698L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                c137112.f5699L$1 = intRef;
                c137112.f5700L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                c137112.f5701L$3 = receiveChannel2;
                c137112.f5702L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                c137112.f5703L$5 = it;
                c137112.f5695I$0 = i3;
                c137112.f5696I$1 = i2;
                c137112.f5697I$2 = i;
                c137112.f5704label = 1;
                objMo7069hasNext = it.mo7069hasNext(c137112);
                if (objMo7069hasNext != coroutine_suspended) {
                }
            } catch (Throwable th2) {
                receiveChannel2 = receiveChannel;
                th = th2;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i6 = c13711.f5697I$2;
            int i7 = c13711.f5696I$1;
            int i8 = c13711.f5695I$0;
            ChannelIterator channelIterator = (ChannelIterator) c13711.f5703L$5;
            ReceiveChannel receiveChannel5 = (ReceiveChannel) c13711.f5702L$4;
            ReceiveChannel receiveChannel6 = (ReceiveChannel) c13711.f5701L$3;
            ReceiveChannel receiveChannel7 = (ReceiveChannel) c13711.f5700L$2;
            C1235Ref.IntRef intRef2 = (C1235Ref.IntRef) c13711.f5699L$1;
            ReceiveChannel receiveChannel8 = (ReceiveChannel) c13711.f5698L$0;
            try {
                ResultKt.throwOnFailure(obj);
                i = i6;
                receiveChannel = receiveChannel8;
                C1235Ref.IntRef intRef3 = intRef2;
                ChannelIterator channelIterator2 = channelIterator;
                c137112 = c13711;
                receiveChannel2 = receiveChannel6;
                i3 = i8;
                i2 = i7;
                receiveChannel4 = receiveChannel5;
                try {
                    if (!((Boolean) obj).booleanValue()) {
                        channelIterator2.mo7070next();
                        intRef3.f5200element++;
                        receiveChannel3 = receiveChannel7;
                        it = channelIterator2;
                        intRef = intRef3;
                        c137112.f5698L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        c137112.f5699L$1 = intRef;
                        c137112.f5700L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                        c137112.f5701L$3 = receiveChannel2;
                        c137112.f5702L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                        c137112.f5703L$5 = it;
                        c137112.f5695I$0 = i3;
                        c137112.f5696I$1 = i2;
                        c137112.f5697I$2 = i;
                        c137112.f5704label = 1;
                        objMo7069hasNext = it.mo7069hasNext(c137112);
                        if (objMo7069hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ChannelIterator channelIterator3 = it;
                        receiveChannel7 = receiveChannel3;
                        obj = objMo7069hasNext;
                        intRef3 = intRef;
                        channelIterator2 = channelIterator3;
                        if (!((Boolean) obj).booleanValue()) {
                            C1133Unit c1133Unit = C1133Unit.INSTANCE;
                            ChannelsKt.cancelConsumed(receiveChannel2, null);
                            return C1207Boxing.m6121boxInt(intRef3.f5200element);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                receiveChannel2 = receiveChannel6;
            }
        }
        try {
            throw th;
        } catch (Throwable th5) {
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            throw th5;
        }
    }

    @PublishedApi
    public static final <E, K> ReceiveChannel<E> distinctBy(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new C13731(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel distinctBy$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.distinctBy(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    /* renamed from: drop */
    public static final /* synthetic */ ReceiveChannel m7115drop(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new C13741(i, receiveChannel, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel drop$default(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return m7115drop(receiveChannel, i, coroutineContext);
    }

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel dropWhile(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new C13751(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel dropWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return dropWhile(receiveChannel, coroutineContext, function2);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0097 A[Catch: all -> 0x00a9, TRY_LEAVE, TryCatch #2 {all -> 0x00a9, blocks: (B:26:0x008f, B:28:0x0097, B:22:0x0068, B:36:0x00ab, B:37:0x00c2), top: B:49:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ab A[Catch: all -> 0x00a9, TRY_ENTER, TryCatch #2 {all -> 0x00a9, blocks: (B:26:0x008f, B:28:0x0097, B:22:0x0068, B:36:0x00ab, B:37:0x00c2), top: B:49:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0089 -> B:49:0x008f). Please report as a decompilation issue!!! */
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object elementAt(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        C13761 c13761;
        ReceiveChannel receiveChannel2;
        Throwable th;
        int i2;
        ChannelIterator it;
        C13761 c137612;
        int i3;
        int i4;
        ReceiveChannel receiveChannel3;
        int i5;
        Object objMo7069hasNext;
        if (continuation instanceof C13761) {
            c13761 = (C13761) continuation;
            int i6 = c13761.f5732label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                c13761.f5732label = i6 - Integer.MIN_VALUE;
            } else {
                c13761 = new C13761(continuation);
            }
        }
        Object obj = c13761.f5733result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i7 = c13761.f5732label;
        if (i7 == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                if (i < 0) {
                    throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i + '.');
                }
                i2 = 0;
                it = receiveChannel.iterator();
                c137612 = c13761;
                i3 = 0;
                i4 = 0;
                receiveChannel3 = receiveChannel;
                i5 = i;
                receiveChannel2 = receiveChannel3;
                c137612.f5728L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                c137612.f5729L$1 = receiveChannel2;
                c137612.f5730L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                c137612.f5731L$3 = it;
                c137612.f5724I$0 = i5;
                c137612.f5725I$1 = i4;
                c137612.f5726I$2 = i3;
                c137612.f5727I$3 = i2;
                c137612.f5732label = 1;
                objMo7069hasNext = it.mo7069hasNext(c137612);
                if (objMo7069hasNext != coroutine_suspended) {
                }
            } catch (Throwable th2) {
                receiveChannel2 = receiveChannel;
                th = th2;
            }
        } else {
            if (i7 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i8 = c13761.f5727I$3;
            int i9 = c13761.f5726I$2;
            int i10 = c13761.f5725I$1;
            int i11 = c13761.f5724I$0;
            ChannelIterator channelIterator = (ChannelIterator) c13761.f5731L$3;
            ReceiveChannel receiveChannel4 = (ReceiveChannel) c13761.f5730L$2;
            ReceiveChannel receiveChannel5 = (ReceiveChannel) c13761.f5729L$1;
            ReceiveChannel receiveChannel6 = (ReceiveChannel) c13761.f5728L$0;
            try {
                ResultKt.throwOnFailure(obj);
                i3 = i9;
                receiveChannel2 = receiveChannel5;
                it = channelIterator;
                c137612 = c13761;
                i5 = i11;
                try {
                    if (!((Boolean) obj).booleanValue()) {
                        Object objMo7070next = it.mo7070next();
                        int i12 = i8 + 1;
                        if (i5 == i8) {
                            ChannelsKt.cancelConsumed(receiveChannel2, null);
                            return objMo7070next;
                        }
                        receiveChannel3 = receiveChannel4;
                        receiveChannel = receiveChannel6;
                        i4 = i10;
                        i2 = i12;
                        c137612.f5728L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        c137612.f5729L$1 = receiveChannel2;
                        c137612.f5730L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                        c137612.f5731L$3 = it;
                        c137612.f5724I$0 = i5;
                        c137612.f5725I$1 = i4;
                        c137612.f5726I$2 = i3;
                        c137612.f5727I$3 = i2;
                        c137612.f5732label = 1;
                        objMo7069hasNext = it.mo7069hasNext(c137612);
                        if (objMo7069hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel6 = receiveChannel;
                        i8 = i2;
                        i10 = i4;
                        receiveChannel4 = receiveChannel3;
                        obj = objMo7069hasNext;
                        if (!((Boolean) obj).booleanValue()) {
                            throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i5 + '.');
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                receiveChannel2 = receiveChannel5;
            }
        }
        try {
            throw th;
        } catch (Throwable th5) {
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            throw th5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0089 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0098 A[Catch: all -> 0x00a9, TRY_LEAVE, TryCatch #2 {all -> 0x00a9, blocks: (B:28:0x0090, B:30:0x0098, B:24:0x0069), top: B:50:0x0090 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x008a -> B:50:0x0090). Please report as a decompilation issue!!! */
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object elementAtOrNull(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        C13771 c13771;
        ReceiveChannel receiveChannel2;
        Throwable th;
        int i2;
        ChannelIterator it;
        C13771 c137712;
        int i3;
        int i4;
        ReceiveChannel receiveChannel3;
        int i5;
        Object objMo7069hasNext;
        if (continuation instanceof C13771) {
            c13771 = (C13771) continuation;
            int i6 = c13771.f5742label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                c13771.f5742label = i6 - Integer.MIN_VALUE;
            } else {
                c13771 = new C13771(continuation);
            }
        }
        Object obj = c13771.f5743result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i7 = c13771.f5742label;
        if (i7 == 0) {
            ResultKt.throwOnFailure(obj);
            if (i < 0) {
                ChannelsKt.cancelConsumed(receiveChannel, null);
                return null;
            }
            try {
                i2 = 0;
                it = receiveChannel.iterator();
                c137712 = c13771;
                i3 = 0;
                i4 = 0;
                receiveChannel3 = receiveChannel;
                i5 = i;
                receiveChannel2 = receiveChannel3;
                c137712.f5738L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                c137712.f5739L$1 = receiveChannel2;
                c137712.f5740L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                c137712.f5741L$3 = it;
                c137712.f5734I$0 = i5;
                c137712.f5735I$1 = i4;
                c137712.f5736I$2 = i3;
                c137712.f5737I$3 = i2;
                c137712.f5742label = 1;
                objMo7069hasNext = it.mo7069hasNext(c137712);
                if (objMo7069hasNext != coroutine_suspended) {
                }
            } catch (Throwable th2) {
                receiveChannel2 = receiveChannel;
                th = th2;
            }
        } else {
            if (i7 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i8 = c13771.f5737I$3;
            int i9 = c13771.f5736I$2;
            int i10 = c13771.f5735I$1;
            int i11 = c13771.f5734I$0;
            ChannelIterator channelIterator = (ChannelIterator) c13771.f5741L$3;
            ReceiveChannel receiveChannel4 = (ReceiveChannel) c13771.f5740L$2;
            ReceiveChannel receiveChannel5 = (ReceiveChannel) c13771.f5739L$1;
            ReceiveChannel receiveChannel6 = (ReceiveChannel) c13771.f5738L$0;
            try {
                ResultKt.throwOnFailure(obj);
                i3 = i9;
                receiveChannel2 = receiveChannel5;
                it = channelIterator;
                c137712 = c13771;
                i5 = i11;
                try {
                    if (!((Boolean) obj).booleanValue()) {
                        Object objMo7070next = it.mo7070next();
                        int i12 = i8 + 1;
                        if (i5 == i8) {
                            ChannelsKt.cancelConsumed(receiveChannel2, null);
                            return objMo7070next;
                        }
                        receiveChannel3 = receiveChannel4;
                        receiveChannel = receiveChannel6;
                        i4 = i10;
                        i2 = i12;
                        c137712.f5738L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        c137712.f5739L$1 = receiveChannel2;
                        c137712.f5740L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                        c137712.f5741L$3 = it;
                        c137712.f5734I$0 = i5;
                        c137712.f5735I$1 = i4;
                        c137712.f5736I$2 = i3;
                        c137712.f5737I$3 = i2;
                        c137712.f5742label = 1;
                        objMo7069hasNext = it.mo7069hasNext(c137712);
                        if (objMo7069hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel6 = receiveChannel;
                        i8 = i2;
                        i10 = i4;
                        receiveChannel4 = receiveChannel3;
                        obj = objMo7069hasNext;
                        if (!((Boolean) obj).booleanValue()) {
                            ChannelsKt.cancelConsumed(receiveChannel2, null);
                            return null;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                receiveChannel2 = receiveChannel5;
            }
        }
        try {
            throw th;
        } catch (Throwable th5) {
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            throw th5;
        }
    }

    @PublishedApi
    /* renamed from: filter */
    public static final <E> ReceiveChannel<E> m7116filter(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new C13781(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel filter$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.m7091filter(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterIndexed(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new C13791(receiveChannel, function3, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel filterIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return filterIndexed(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterNot(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt.m7091filter(receiveChannel, coroutineContext, new C13801(function2, null));
    }

    public static /* synthetic */ ReceiveChannel filterNot$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return filterNot(receiveChannel, coroutineContext, function2);
    }

    @PublishedApi
    public static final <E> ReceiveChannel<E> filterNotNull(ReceiveChannel<? extends E> receiveChannel) {
        ReceiveChannel<E> receiveChannelFilter$default = filter$default(receiveChannel, null, new C13811(null), 1, null);
        Intrinsics.checkNotNull(receiveChannelFilter$default, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.filterNotNull>");
        return receiveChannelFilter$default;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a3 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:12:0x0043, B:25:0x009b, B:27:0x00a3, B:29:0x00a9, B:31:0x00b1), top: B:42:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b1 A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #0 {all -> 0x0052, blocks: (B:12:0x0043, B:25:0x009b, B:27:0x00a3, B:29:0x00a9, B:31:0x00b1), top: B:42:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0095 -> B:25:0x009b). Please report as a decompilation issue!!! */
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel receiveChannel, Collection collection, Continuation continuation) {
        C13821 c13821;
        ReceiveChannel receiveChannel2;
        Throwable th;
        int i;
        Collection collection2;
        ChannelIterator it;
        C13821 c138212;
        int i2;
        int i3;
        ReceiveChannel receiveChannel3;
        ReceiveChannel receiveChannel4;
        Object objMo7069hasNext;
        if (continuation instanceof C13821) {
            c13821 = (C13821) continuation;
            int i4 = c13821.f5766label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c13821.f5766label = i4 - Integer.MIN_VALUE;
            } else {
                c13821 = new C13821(continuation);
            }
        }
        Object obj = c13821.f5767result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c13821.f5766label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                i = 0;
                collection2 = collection;
                it = receiveChannel.iterator();
                c138212 = c13821;
                i2 = 0;
                i3 = 0;
                receiveChannel3 = receiveChannel;
                receiveChannel2 = receiveChannel3;
                receiveChannel4 = receiveChannel2;
                c138212.f5760L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                c138212.f5761L$1 = collection2;
                c138212.f5762L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                c138212.f5763L$3 = receiveChannel2;
                c138212.f5764L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                c138212.f5765L$5 = it;
                c138212.f5757I$0 = i3;
                c138212.f5758I$1 = i2;
                c138212.f5759I$2 = i;
                c138212.f5766label = 1;
                objMo7069hasNext = it.mo7069hasNext(c138212);
                if (objMo7069hasNext != coroutine_suspended) {
                }
            } catch (Throwable th2) {
                receiveChannel2 = receiveChannel;
                th = th2;
                throw th;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i6 = c13821.f5759I$2;
            int i7 = c13821.f5758I$1;
            int i8 = c13821.f5757I$0;
            ChannelIterator channelIterator = (ChannelIterator) c13821.f5765L$5;
            ReceiveChannel receiveChannel5 = (ReceiveChannel) c13821.f5764L$4;
            ReceiveChannel receiveChannel6 = (ReceiveChannel) c13821.f5763L$3;
            ReceiveChannel receiveChannel7 = (ReceiveChannel) c13821.f5762L$2;
            Collection collection3 = (Collection) c13821.f5761L$1;
            ReceiveChannel receiveChannel8 = (ReceiveChannel) c13821.f5760L$0;
            try {
                ResultKt.throwOnFailure(obj);
                i = i6;
                receiveChannel = receiveChannel8;
                ChannelIterator channelIterator2 = channelIterator;
                collection2 = collection3;
                int i9 = i8;
                i2 = i7;
                receiveChannel3 = receiveChannel7;
                C13821 c138213 = c13821;
                receiveChannel4 = receiveChannel5;
                if (!((Boolean) obj).booleanValue()) {
                    C1133Unit c1133Unit = C1133Unit.INSTANCE;
                    ChannelsKt.cancelConsumed(receiveChannel6, null);
                    return collection2;
                }
                try {
                    Object objMo7070next = channelIterator2.mo7070next();
                    if (objMo7070next != null) {
                        collection2.add(objMo7070next);
                    }
                    c138212.f5760L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                    c138212.f5761L$1 = collection2;
                    c138212.f5762L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                    c138212.f5763L$3 = receiveChannel2;
                    c138212.f5764L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                    c138212.f5765L$5 = it;
                    c138212.f5757I$0 = i3;
                    c138212.f5758I$1 = i2;
                    c138212.f5759I$2 = i;
                    c138212.f5766label = 1;
                    objMo7069hasNext = it.mo7069hasNext(c138212);
                    if (objMo7069hasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    C13821 c138214 = c138212;
                    receiveChannel6 = receiveChannel2;
                    obj = objMo7069hasNext;
                    channelIterator2 = it;
                    i9 = i3;
                    c138213 = c138214;
                    if (!((Boolean) obj).booleanValue()) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        ChannelsKt.cancelConsumed(receiveChannel2, th);
                        throw th4;
                    }
                }
                receiveChannel2 = receiveChannel6;
                c138212 = c138213;
                i3 = i9;
                it = channelIterator2;
            } catch (Throwable th5) {
                th = th5;
                receiveChannel2 = receiveChannel6;
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0073 A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #2 {all -> 0x0039, blocks: (B:12:0x0035, B:23:0x006b, B:25:0x0073, B:28:0x007c, B:29:0x0083), top: B:40:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007c A[Catch: all -> 0x0039, TRY_ENTER, TryCatch #2 {all -> 0x0039, blocks: (B:12:0x0035, B:23:0x006b, B:25:0x0073, B:28:0x007c, B:29:0x0083), top: B:40:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    /* renamed from: first */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object m7117first(ReceiveChannel receiveChannel, Continuation continuation) {
        C13841 c13841;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator channelIterator;
        if (continuation instanceof C13841) {
            c13841 = (C13841) continuation;
            int i = c13841.f5788label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13841.f5788label = i - Integer.MIN_VALUE;
            } else {
                c13841 = new C13841(continuation);
            }
        }
        Object obj = c13841.f5789result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c13841.f5788label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            channelIterator = (ChannelIterator) c13841.f5787L$3;
            receiveChannel2 = (ReceiveChannel) c13841.f5785L$1;
            try {
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
                Object objMo7070next = channelIterator.mo7070next();
                ChannelsKt.cancelConsumed(receiveChannel2, null);
                return objMo7070next;
            } catch (Throwable th2) {
                th = th2;
                try {
                    throw th;
                } catch (Throwable th3) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                    throw th3;
                }
            }
        }
        ResultKt.throwOnFailure(obj);
        try {
            ChannelIterator it = receiveChannel.iterator();
            c13841.f5784L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
            c13841.f5785L$1 = receiveChannel;
            c13841.f5786L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel);
            c13841.f5787L$3 = it;
            c13841.f5782I$0 = 0;
            c13841.f5783I$1 = 0;
            c13841.f5788label = 1;
            Object objMo7069hasNext = it.mo7069hasNext(c13841);
            if (objMo7069hasNext == coroutine_suspended) {
                return coroutine_suspended;
            }
            receiveChannel2 = receiveChannel;
            channelIterator = it;
            obj = objMo7069hasNext;
            if (((Boolean) obj).booleanValue()) {
            }
        } catch (Throwable th4) {
            receiveChannel2 = receiveChannel;
            th = th4;
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object firstOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        C13851 c13851;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator channelIterator;
        if (continuation instanceof C13851) {
            c13851 = (C13851) continuation;
            int i = c13851.f5796label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13851.f5796label = i - Integer.MIN_VALUE;
            } else {
                c13851 = new C13851(continuation);
            }
        }
        Object obj = c13851.f5797result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c13851.f5796label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                ChannelIterator it = receiveChannel.iterator();
                c13851.f5792L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                c13851.f5793L$1 = receiveChannel;
                c13851.f5794L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                c13851.f5795L$3 = it;
                c13851.f5790I$0 = 0;
                c13851.f5791I$1 = 0;
                c13851.f5796label = 1;
                Object objMo7069hasNext = it.mo7069hasNext(c13851);
                if (objMo7069hasNext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                receiveChannel2 = receiveChannel;
                channelIterator = it;
                obj = objMo7069hasNext;
            } catch (Throwable th2) {
                receiveChannel2 = receiveChannel;
                th = th2;
                throw th;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            channelIterator = (ChannelIterator) c13851.f5795L$3;
            receiveChannel2 = (ReceiveChannel) c13851.f5793L$1;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                    throw th4;
                }
            }
        }
        if (!((Boolean) obj).booleanValue()) {
            ChannelsKt.cancelConsumed(receiveChannel2, null);
            return null;
        }
        Object objMo7070next = channelIterator.mo7070next();
        ChannelsKt.cancelConsumed(receiveChannel2, null);
        return objMo7070next;
    }

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    /* renamed from: flatMap */
    public static final /* synthetic */ ReceiveChannel m7118flatMap(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new C13861(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel flatMap$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return m7118flatMap(receiveChannel, coroutineContext, function2);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b5 A[Catch: all -> 0x00c9, TryCatch #1 {all -> 0x00c9, blocks: (B:25:0x00ac, B:27:0x00b5, B:29:0x00bf, B:34:0x00cc, B:21:0x0080, B:35:0x00d3), top: B:46:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d3 A[Catch: all -> 0x00c9, TRY_LEAVE, TryCatch #1 {all -> 0x00c9, blocks: (B:25:0x00ac, B:27:0x00b5, B:29:0x00bf, B:34:0x00cc, B:21:0x0080, B:35:0x00d3), top: B:46:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00a9 -> B:46:0x00ac). Please report as a decompilation issue!!! */
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    /* renamed from: indexOf */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object m7119indexOf(ReceiveChannel receiveChannel, Object obj, Continuation continuation) {
        C13871 c13871;
        ReceiveChannel receiveChannel2;
        Object obj2;
        C1235Ref.IntRef intRef;
        C13871 c138712;
        ChannelIterator it;
        int i;
        int i2;
        int i3;
        ReceiveChannel receiveChannel3;
        ReceiveChannel receiveChannel4;
        ReceiveChannel receiveChannel5;
        Throwable th;
        Object objMo7069hasNext;
        if (continuation instanceof C13871) {
            c13871 = (C13871) continuation;
            int i4 = c13871.f5812label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c13871.f5812label = i4 - Integer.MIN_VALUE;
            } else {
                c13871 = new C13871(continuation);
            }
        }
        Object obj3 = c13871.f5813result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c13871.f5812label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj3);
            try {
                obj2 = obj;
                intRef = new C1235Ref.IntRef();
                c138712 = c13871;
                it = receiveChannel.iterator();
                i = 0;
                i2 = 0;
                i3 = 0;
                receiveChannel3 = receiveChannel;
                receiveChannel4 = receiveChannel3;
                receiveChannel2 = receiveChannel4;
                receiveChannel5 = receiveChannel2;
                c138712.f5805L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                c138712.f5806L$1 = obj2;
                c138712.f5807L$2 = intRef;
                c138712.f5808L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                c138712.f5809L$4 = receiveChannel2;
                c138712.f5810L$5 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                c138712.f5811L$6 = it;
                c138712.f5802I$0 = i3;
                c138712.f5803I$1 = i2;
                c138712.f5804I$2 = i;
                c138712.f5812label = 1;
                objMo7069hasNext = it.mo7069hasNext(c138712);
                if (objMo7069hasNext != coroutine_suspended) {
                }
            } catch (Throwable th2) {
                th = th2;
                receiveChannel2 = receiveChannel;
                th = th;
                throw th;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i6 = c13871.f5804I$2;
            int i7 = c13871.f5803I$1;
            int i8 = c13871.f5802I$0;
            ChannelIterator channelIterator = (ChannelIterator) c13871.f5811L$6;
            ReceiveChannel receiveChannel6 = (ReceiveChannel) c13871.f5810L$5;
            ReceiveChannel receiveChannel7 = (ReceiveChannel) c13871.f5809L$4;
            ReceiveChannel receiveChannel8 = (ReceiveChannel) c13871.f5808L$3;
            C1235Ref.IntRef intRef2 = (C1235Ref.IntRef) c13871.f5807L$2;
            Object obj4 = c13871.f5806L$1;
            ReceiveChannel receiveChannel9 = (ReceiveChannel) c13871.f5805L$0;
            try {
                ResultKt.throwOnFailure(obj3);
                c138712 = c13871;
                receiveChannel4 = receiveChannel8;
                i3 = i8;
                obj2 = obj4;
                intRef = intRef2;
                it = channelIterator;
                i = i6;
                receiveChannel2 = receiveChannel7;
                i2 = i7;
                receiveChannel5 = receiveChannel6;
                try {
                    if (!((Boolean) obj3).booleanValue()) {
                        C1133Unit c1133Unit = C1133Unit.INSTANCE;
                        ChannelsKt.cancelConsumed(receiveChannel2, null);
                        return C1207Boxing.m6121boxInt(-1);
                    }
                    if (Intrinsics.areEqual(obj2, it.mo7070next())) {
                        Integer numM6121boxInt = C1207Boxing.m6121boxInt(intRef.f5200element);
                        ChannelsKt.cancelConsumed(receiveChannel2, null);
                        return numM6121boxInt;
                    }
                    intRef.f5200element++;
                    receiveChannel3 = receiveChannel9;
                    c138712.f5805L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                    c138712.f5806L$1 = obj2;
                    c138712.f5807L$2 = intRef;
                    c138712.f5808L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                    c138712.f5809L$4 = receiveChannel2;
                    c138712.f5810L$5 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                    c138712.f5811L$6 = it;
                    c138712.f5802I$0 = i3;
                    c138712.f5803I$1 = i2;
                    c138712.f5804I$2 = i;
                    c138712.f5812label = 1;
                    objMo7069hasNext = it.mo7069hasNext(c138712);
                    if (objMo7069hasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    receiveChannel9 = receiveChannel3;
                    obj3 = objMo7069hasNext;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        ChannelsKt.cancelConsumed(receiveChannel2, th);
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                receiveChannel2 = receiveChannel7;
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00cd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00db A[Catch: all -> 0x00e3, TRY_LEAVE, TryCatch #1 {all -> 0x00e3, blocks: (B:38:0x00d3, B:40:0x00db, B:34:0x00af, B:26:0x0078), top: B:53:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00ce -> B:15:0x0044). Please report as a decompilation issue!!! */
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    /* renamed from: last */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object m7120last(ReceiveChannel receiveChannel, Continuation continuation) {
        C13881 c13881;
        int i;
        ReceiveChannel receiveChannel2;
        ReceiveChannel receiveChannel3;
        ChannelIterator channelIterator;
        int i2;
        Object objMo7070next;
        ReceiveChannel receiveChannel4;
        ReceiveChannel receiveChannel5;
        ChannelIterator channelIterator2;
        Throwable th;
        Object objMo7069hasNext;
        if (continuation instanceof C13881) {
            c13881 = (C13881) continuation;
            int i3 = c13881.f5821label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c13881.f5821label = i3 - Integer.MIN_VALUE;
            } else {
                c13881 = new C13881(continuation);
            }
        }
        Object obj = c13881.f5822result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c13881.f5821label;
        if (i4 != 0) {
            if (i4 == 1) {
                int i5 = c13881.f5815I$1;
                int i6 = c13881.f5814I$0;
                ChannelIterator channelIterator3 = (ChannelIterator) c13881.f5819L$3;
                receiveChannel2 = (ReceiveChannel) c13881.f5818L$2;
                receiveChannel3 = (ReceiveChannel) c13881.f5817L$1;
                ReceiveChannel receiveChannel6 = (ReceiveChannel) c13881.f5816L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    i = i5;
                    receiveChannel = receiveChannel6;
                    channelIterator = channelIterator3;
                    i2 = i6;
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                if (i4 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i7 = c13881.f5815I$1;
                int i8 = c13881.f5814I$0;
                Object obj2 = c13881.f5820L$4;
                channelIterator2 = (ChannelIterator) c13881.f5819L$3;
                receiveChannel5 = (ReceiveChannel) c13881.f5818L$2;
                ReceiveChannel receiveChannel7 = (ReceiveChannel) c13881.f5817L$1;
                receiveChannel4 = (ReceiveChannel) c13881.f5816L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    int i9 = i8;
                    i = i7;
                    receiveChannel = receiveChannel7;
                    ReceiveChannel receiveChannel8 = receiveChannel5;
                    ChannelIterator channelIterator4 = channelIterator2;
                    int i10 = i9;
                    if (!((Boolean) obj).booleanValue()) {
                        objMo7070next = channelIterator4.mo7070next();
                        i2 = i10;
                        channelIterator2 = channelIterator4;
                        receiveChannel5 = receiveChannel8;
                        c13881.f5816L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                        c13881.f5817L$1 = receiveChannel;
                        c13881.f5818L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                        c13881.f5819L$3 = channelIterator2;
                        c13881.f5820L$4 = objMo7070next;
                        c13881.f5814I$0 = i2;
                        c13881.f5815I$1 = i;
                        c13881.f5821label = 2;
                        objMo7069hasNext = channelIterator2.mo7069hasNext(c13881);
                        if (objMo7069hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i9 = i2;
                        obj2 = objMo7070next;
                        obj = objMo7069hasNext;
                        ReceiveChannel receiveChannel82 = receiveChannel5;
                        ChannelIterator channelIterator42 = channelIterator2;
                        int i102 = i9;
                        if (!((Boolean) obj).booleanValue()) {
                            ChannelsKt.cancelConsumed(receiveChannel, null);
                            return obj2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    receiveChannel3 = receiveChannel7;
                }
            }
            try {
                throw th;
            } catch (Throwable th4) {
                ChannelsKt.cancelConsumed(receiveChannel3, th);
                throw th4;
            }
        }
        ResultKt.throwOnFailure(obj);
        try {
            ChannelIterator it = receiveChannel.iterator();
            c13881.f5816L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
            c13881.f5817L$1 = receiveChannel;
            c13881.f5818L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel);
            c13881.f5819L$3 = it;
            i = 0;
            c13881.f5814I$0 = 0;
            c13881.f5815I$1 = 0;
            c13881.f5821label = 1;
            Object objMo7069hasNext2 = it.mo7069hasNext(c13881);
            if (objMo7069hasNext2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            receiveChannel2 = receiveChannel;
            receiveChannel3 = receiveChannel2;
            channelIterator = it;
            obj = objMo7069hasNext2;
            i2 = 0;
        } catch (Throwable th5) {
            receiveChannel3 = receiveChannel;
            th = th5;
        }
        if (!((Boolean) obj).booleanValue()) {
            throw new NoSuchElementException("ReceiveChannel is empty.");
        }
        objMo7070next = channelIterator.mo7070next();
        receiveChannel4 = receiveChannel;
        receiveChannel = receiveChannel3;
        receiveChannel5 = receiveChannel2;
        channelIterator2 = channelIterator;
        c13881.f5816L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
        c13881.f5817L$1 = receiveChannel;
        c13881.f5818L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
        c13881.f5819L$3 = channelIterator2;
        c13881.f5820L$4 = objMo7070next;
        c13881.f5814I$0 = i2;
        c13881.f5815I$1 = i;
        c13881.f5821label = 2;
        objMo7069hasNext = channelIterator2.mo7069hasNext(c13881);
        if (objMo7069hasNext != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c5 A[Catch: all -> 0x00d4, TryCatch #1 {all -> 0x00d4, blocks: (B:25:0x00bd, B:27:0x00c5, B:29:0x00cf, B:32:0x00d7, B:21:0x008f, B:33:0x00de), top: B:44:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00de A[Catch: all -> 0x00d4, TRY_LEAVE, TryCatch #1 {all -> 0x00d4, blocks: (B:25:0x00bd, B:27:0x00c5, B:29:0x00cf, B:32:0x00d7, B:21:0x008f, B:33:0x00de), top: B:44:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00ba -> B:44:0x00bd). Please report as a decompilation issue!!! */
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object lastIndexOf(ReceiveChannel receiveChannel, Object obj, Continuation continuation) {
        C13891 c13891;
        ReceiveChannel receiveChannel2;
        C1235Ref.IntRef intRef;
        C13891 c138912;
        C1235Ref.IntRef intRef2;
        ChannelIterator it;
        int i;
        int i2;
        int i3;
        ReceiveChannel receiveChannel3;
        ReceiveChannel receiveChannel4;
        ReceiveChannel receiveChannel5;
        Object obj2;
        Throwable th;
        Object objMo7069hasNext;
        if (continuation instanceof C13891) {
            c13891 = (C13891) continuation;
            int i4 = c13891.f5834label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c13891.f5834label = i4 - Integer.MIN_VALUE;
            } else {
                c13891 = new C13891(continuation);
            }
        }
        Object obj3 = c13891.f5835result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c13891.f5834label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj3);
            C1235Ref.IntRef intRef3 = new C1235Ref.IntRef();
            intRef3.f5200element = -1;
            try {
                intRef = intRef3;
                c138912 = c13891;
                intRef2 = new C1235Ref.IntRef();
                it = receiveChannel.iterator();
                i = 0;
                i2 = 0;
                i3 = 0;
                receiveChannel3 = receiveChannel;
                receiveChannel4 = receiveChannel3;
                receiveChannel2 = receiveChannel4;
                receiveChannel5 = receiveChannel2;
                obj2 = obj;
                c138912.f5826L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                c138912.f5827L$1 = obj2;
                c138912.f5828L$2 = intRef;
                c138912.f5829L$3 = intRef2;
                c138912.f5830L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                c138912.f5831L$5 = receiveChannel2;
                c138912.f5832L$6 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                c138912.f5833L$7 = it;
                c138912.f5823I$0 = i3;
                c138912.f5824I$1 = i2;
                c138912.f5825I$2 = i;
                c138912.f5834label = 1;
                objMo7069hasNext = it.mo7069hasNext(c138912);
                if (objMo7069hasNext != coroutine_suspended) {
                }
            } catch (Throwable th2) {
                th = th2;
                receiveChannel2 = receiveChannel;
                th = th;
                throw th;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i6 = c13891.f5825I$2;
            int i7 = c13891.f5824I$1;
            int i8 = c13891.f5823I$0;
            ChannelIterator channelIterator = (ChannelIterator) c13891.f5833L$7;
            ReceiveChannel receiveChannel6 = (ReceiveChannel) c13891.f5832L$6;
            ReceiveChannel receiveChannel7 = (ReceiveChannel) c13891.f5831L$5;
            ReceiveChannel receiveChannel8 = (ReceiveChannel) c13891.f5830L$4;
            C1235Ref.IntRef intRef4 = (C1235Ref.IntRef) c13891.f5829L$3;
            C1235Ref.IntRef intRef5 = (C1235Ref.IntRef) c13891.f5828L$2;
            Object obj4 = c13891.f5827L$1;
            ReceiveChannel receiveChannel9 = (ReceiveChannel) c13891.f5826L$0;
            try {
                ResultKt.throwOnFailure(obj3);
                c138912 = c13891;
                receiveChannel4 = receiveChannel8;
                i3 = i8;
                obj2 = obj4;
                intRef = intRef5;
                intRef2 = intRef4;
                it = channelIterator;
                i = i6;
                receiveChannel2 = receiveChannel7;
                i2 = i7;
                receiveChannel5 = receiveChannel6;
                try {
                    if (!((Boolean) obj3).booleanValue()) {
                        C1133Unit c1133Unit = C1133Unit.INSTANCE;
                        ChannelsKt.cancelConsumed(receiveChannel2, null);
                        return C1207Boxing.m6121boxInt(intRef.f5200element);
                    }
                    if (Intrinsics.areEqual(obj2, it.mo7070next())) {
                        intRef.f5200element = intRef2.f5200element;
                    }
                    intRef2.f5200element++;
                    receiveChannel3 = receiveChannel9;
                    c138912.f5826L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                    c138912.f5827L$1 = obj2;
                    c138912.f5828L$2 = intRef;
                    c138912.f5829L$3 = intRef2;
                    c138912.f5830L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                    c138912.f5831L$5 = receiveChannel2;
                    c138912.f5832L$6 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                    c138912.f5833L$7 = it;
                    c138912.f5823I$0 = i3;
                    c138912.f5824I$1 = i2;
                    c138912.f5825I$2 = i;
                    c138912.f5834label = 1;
                    objMo7069hasNext = it.mo7069hasNext(c138912);
                    if (objMo7069hasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    receiveChannel9 = receiveChannel3;
                    obj3 = objMo7069hasNext;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        ChannelsKt.cancelConsumed(receiveChannel2, th);
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                receiveChannel2 = receiveChannel7;
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00d2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e0 A[Catch: all -> 0x00e8, TRY_LEAVE, TryCatch #2 {all -> 0x00e8, blocks: (B:39:0x00d8, B:41:0x00e0, B:35:0x00b4, B:30:0x00a0, B:34:0x00ac, B:26:0x0079), top: B:55:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00d3 -> B:15:0x0045). Please report as a decompilation issue!!! */
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object lastOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        C13901 c13901;
        int i;
        ReceiveChannel receiveChannel2;
        ReceiveChannel receiveChannel3;
        ChannelIterator channelIterator;
        int i2;
        Object objMo7070next;
        ReceiveChannel receiveChannel4;
        ReceiveChannel receiveChannel5;
        ChannelIterator channelIterator2;
        Throwable th;
        ReceiveChannel receiveChannel6;
        Object objMo7069hasNext;
        if (continuation instanceof C13901) {
            c13901 = (C13901) continuation;
            int i3 = c13901.f5843label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c13901.f5843label = i3 - Integer.MIN_VALUE;
            } else {
                c13901 = new C13901(continuation);
            }
        }
        Object obj = c13901.f5844result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c13901.f5843label;
        if (i4 != 0) {
            if (i4 == 1) {
                int i5 = c13901.f5837I$1;
                int i6 = c13901.f5836I$0;
                ChannelIterator channelIterator3 = (ChannelIterator) c13901.f5841L$3;
                receiveChannel2 = (ReceiveChannel) c13901.f5840L$2;
                receiveChannel6 = (ReceiveChannel) c13901.f5839L$1;
                receiveChannel3 = (ReceiveChannel) c13901.f5838L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    i = i5;
                    receiveChannel = receiveChannel6;
                    channelIterator = channelIterator3;
                    i2 = i6;
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                if (i4 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i7 = c13901.f5837I$1;
                int i8 = c13901.f5836I$0;
                Object obj2 = c13901.f5842L$4;
                channelIterator2 = (ChannelIterator) c13901.f5841L$3;
                receiveChannel5 = (ReceiveChannel) c13901.f5840L$2;
                ReceiveChannel receiveChannel7 = (ReceiveChannel) c13901.f5839L$1;
                receiveChannel4 = (ReceiveChannel) c13901.f5838L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    int i9 = i8;
                    i = i7;
                    receiveChannel = receiveChannel7;
                    ReceiveChannel receiveChannel8 = receiveChannel5;
                    ChannelIterator channelIterator4 = channelIterator2;
                    int i10 = i9;
                    if (!((Boolean) obj).booleanValue()) {
                        objMo7070next = channelIterator4.mo7070next();
                        i2 = i10;
                        channelIterator2 = channelIterator4;
                        receiveChannel5 = receiveChannel8;
                        c13901.f5838L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                        c13901.f5839L$1 = receiveChannel;
                        c13901.f5840L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                        c13901.f5841L$3 = channelIterator2;
                        c13901.f5842L$4 = objMo7070next;
                        c13901.f5836I$0 = i2;
                        c13901.f5837I$1 = i;
                        c13901.f5843label = 2;
                        objMo7069hasNext = channelIterator2.mo7069hasNext(c13901);
                        if (objMo7069hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i9 = i2;
                        obj2 = objMo7070next;
                        obj = objMo7069hasNext;
                        ReceiveChannel receiveChannel82 = receiveChannel5;
                        ChannelIterator channelIterator42 = channelIterator2;
                        int i102 = i9;
                        if (!((Boolean) obj).booleanValue()) {
                            ChannelsKt.cancelConsumed(receiveChannel, null);
                            return obj2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    receiveChannel6 = receiveChannel7;
                }
            }
            try {
                throw th;
            } catch (Throwable th4) {
                ChannelsKt.cancelConsumed(receiveChannel6, th);
                throw th4;
            }
        }
        ResultKt.throwOnFailure(obj);
        try {
            ChannelIterator it = receiveChannel.iterator();
            c13901.f5838L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
            c13901.f5839L$1 = receiveChannel;
            c13901.f5840L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel);
            c13901.f5841L$3 = it;
            i = 0;
            c13901.f5836I$0 = 0;
            c13901.f5837I$1 = 0;
            c13901.f5843label = 1;
            Object objMo7069hasNext2 = it.mo7069hasNext(c13901);
            if (objMo7069hasNext2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            receiveChannel2 = receiveChannel;
            receiveChannel3 = receiveChannel2;
            channelIterator = it;
            obj = objMo7069hasNext2;
            i2 = 0;
        } catch (Throwable th5) {
            receiveChannel6 = receiveChannel;
            th = th5;
        }
        if (!((Boolean) obj).booleanValue()) {
            ChannelsKt.cancelConsumed(receiveChannel, null);
            return null;
        }
        objMo7070next = channelIterator.mo7070next();
        receiveChannel4 = receiveChannel3;
        ChannelIterator channelIterator5 = channelIterator;
        receiveChannel5 = receiveChannel2;
        channelIterator2 = channelIterator5;
        c13901.f5838L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
        c13901.f5839L$1 = receiveChannel;
        c13901.f5840L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
        c13901.f5841L$3 = channelIterator2;
        c13901.f5842L$4 = objMo7070next;
        c13901.f5836I$0 = i2;
        c13901.f5837I$1 = i;
        c13901.f5843label = 2;
        objMo7069hasNext = channelIterator2.mo7069hasNext(c13901);
        if (objMo7069hasNext != coroutine_suspended) {
        }
    }

    @PublishedApi
    /* renamed from: map */
    public static final <E, R> ReceiveChannel<R> m7121map(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new C13911(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel map$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.m7096map(receiveChannel, coroutineContext, function2);
    }

    @PublishedApi
    public static final <E, R> ReceiveChannel<R> mapIndexed(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new C13921(receiveChannel, function3, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel mapIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.mapIndexed(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapIndexedNotNull(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3) {
        return ChannelsKt.filterNotNull(ChannelsKt.mapIndexed(receiveChannel, coroutineContext, function3));
    }

    public static /* synthetic */ ReceiveChannel mapIndexedNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return mapIndexedNotNull(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapNotNull(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt.filterNotNull(ChannelsKt.m7096map(receiveChannel, coroutineContext, function2));
    }

    public static /* synthetic */ ReceiveChannel mapNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return mapNotNull(receiveChannel, coroutineContext, function2);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f2 A[Catch: all -> 0x0109, TRY_LEAVE, TryCatch #1 {all -> 0x0109, blocks: (B:39:0x00ea, B:41:0x00f2, B:35:0x00c4, B:30:0x00ae, B:34:0x00ba, B:26:0x0085), top: B:55:0x0085 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00e5 -> B:15:0x0049). Please report as a decompilation issue!!! */
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    /* renamed from: maxWith */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object m7122maxWith(ReceiveChannel receiveChannel, Comparator comparator, Continuation continuation) {
        C13931 c13931;
        int i;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        Object obj;
        ReceiveChannel receiveChannel3;
        int i2;
        ReceiveChannel receiveChannel4;
        Comparator comparator2;
        int i3;
        Object objMo7070next;
        ReceiveChannel receiveChannel5;
        ChannelIterator channelIterator2;
        Throwable th;
        ReceiveChannel receiveChannel6;
        Object objMo7069hasNext;
        if (continuation instanceof C13931) {
            c13931 = (C13931) continuation;
            int i4 = c13931.f5873label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c13931.f5873label = i4 - Integer.MIN_VALUE;
            } else {
                c13931 = new C13931(continuation);
            }
        }
        Object obj2 = c13931.f5874result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c13931.f5873label;
        if (i5 != 0) {
            if (i5 == 1) {
                int i6 = c13931.f5866I$1;
                int i7 = c13931.f5865I$0;
                ChannelIterator channelIterator3 = (ChannelIterator) c13931.f5871L$4;
                receiveChannel3 = (ReceiveChannel) c13931.f5870L$3;
                receiveChannel6 = (ReceiveChannel) c13931.f5869L$2;
                Comparator comparator3 = (Comparator) c13931.f5868L$1;
                receiveChannel2 = (ReceiveChannel) c13931.f5867L$0;
                try {
                    ResultKt.throwOnFailure(obj2);
                    i = i6;
                    receiveChannel = receiveChannel6;
                    obj = obj2;
                    i2 = i7;
                    comparator = comparator3;
                    channelIterator = channelIterator3;
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i8 = c13931.f5866I$1;
                i3 = c13931.f5865I$0;
                objMo7070next = c13931.f5872L$5;
                channelIterator2 = (ChannelIterator) c13931.f5871L$4;
                receiveChannel5 = (ReceiveChannel) c13931.f5870L$3;
                ReceiveChannel receiveChannel7 = (ReceiveChannel) c13931.f5869L$2;
                comparator2 = (Comparator) c13931.f5868L$1;
                receiveChannel4 = (ReceiveChannel) c13931.f5867L$0;
                try {
                    ResultKt.throwOnFailure(obj2);
                    C13931 c139312 = c13931;
                    int i9 = i8;
                    receiveChannel = receiveChannel7;
                    ReceiveChannel receiveChannel8 = receiveChannel5;
                    ChannelIterator channelIterator4 = channelIterator2;
                    Object obj3 = objMo7070next;
                    C13931 c139313 = c139312;
                    if (!((Boolean) obj2).booleanValue()) {
                        Object objMo7070next2 = channelIterator4.mo7070next();
                        if (comparator2.compare(obj3, objMo7070next2) < 0) {
                            channelIterator2 = channelIterator4;
                            receiveChannel5 = receiveChannel8;
                            objMo7070next = objMo7070next2;
                            i = i9;
                            c13931 = c139313;
                        } else {
                            i = i9;
                            c13931 = c139313;
                            objMo7070next = obj3;
                            channelIterator2 = channelIterator4;
                            receiveChannel5 = receiveChannel8;
                        }
                        c13931.f5867L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                        c13931.f5868L$1 = comparator2;
                        c13931.f5869L$2 = receiveChannel;
                        c13931.f5870L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                        c13931.f5871L$4 = channelIterator2;
                        c13931.f5872L$5 = objMo7070next;
                        c13931.f5865I$0 = i3;
                        c13931.f5866I$1 = i;
                        c13931.f5873label = 2;
                        objMo7069hasNext = channelIterator2.mo7069hasNext(c13931);
                        if (objMo7069hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c139312 = c13931;
                        i9 = i;
                        obj2 = objMo7069hasNext;
                        ReceiveChannel receiveChannel82 = receiveChannel5;
                        ChannelIterator channelIterator42 = channelIterator2;
                        Object obj32 = objMo7070next;
                        C13931 c1393132 = c139312;
                        if (!((Boolean) obj2).booleanValue()) {
                            ChannelsKt.cancelConsumed(receiveChannel, null);
                            return obj32;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    receiveChannel6 = receiveChannel7;
                }
            }
            try {
                throw th;
            } catch (Throwable th4) {
                ChannelsKt.cancelConsumed(receiveChannel6, th);
                throw th4;
            }
        }
        ResultKt.throwOnFailure(obj2);
        try {
            ChannelIterator it = receiveChannel.iterator();
            c13931.f5867L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
            c13931.f5868L$1 = comparator;
            c13931.f5869L$2 = receiveChannel;
            c13931.f5870L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel);
            c13931.f5871L$4 = it;
            i = 0;
            c13931.f5865I$0 = 0;
            c13931.f5866I$1 = 0;
            c13931.f5873label = 1;
            Object objMo7069hasNext2 = it.mo7069hasNext(c13931);
            if (objMo7069hasNext2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            receiveChannel2 = receiveChannel;
            channelIterator = it;
            obj = objMo7069hasNext2;
            receiveChannel3 = receiveChannel2;
            i2 = 0;
        } catch (Throwable th5) {
            receiveChannel6 = receiveChannel;
            th = th5;
        }
        if (!((Boolean) obj).booleanValue()) {
            ChannelsKt.cancelConsumed(receiveChannel, null);
            return null;
        }
        receiveChannel4 = receiveChannel2;
        comparator2 = comparator;
        i3 = i2;
        objMo7070next = channelIterator.mo7070next();
        receiveChannel5 = receiveChannel3;
        channelIterator2 = channelIterator;
        c13931.f5867L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
        c13931.f5868L$1 = comparator2;
        c13931.f5869L$2 = receiveChannel;
        c13931.f5870L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
        c13931.f5871L$4 = channelIterator2;
        c13931.f5872L$5 = objMo7070next;
        c13931.f5865I$0 = i3;
        c13931.f5866I$1 = i;
        c13931.f5873label = 2;
        objMo7069hasNext = channelIterator2.mo7069hasNext(c13931);
        if (objMo7069hasNext != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f2 A[Catch: all -> 0x0109, TRY_LEAVE, TryCatch #1 {all -> 0x0109, blocks: (B:39:0x00ea, B:41:0x00f2, B:35:0x00c4, B:30:0x00ae, B:34:0x00ba, B:26:0x0085), top: B:55:0x0085 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00e5 -> B:15:0x0049). Please report as a decompilation issue!!! */
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    /* renamed from: minWith */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object m7123minWith(ReceiveChannel receiveChannel, Comparator comparator, Continuation continuation) {
        C13941 c13941;
        int i;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        Object obj;
        ReceiveChannel receiveChannel3;
        int i2;
        ReceiveChannel receiveChannel4;
        Comparator comparator2;
        int i3;
        Object objMo7070next;
        ReceiveChannel receiveChannel5;
        ChannelIterator channelIterator2;
        Throwable th;
        ReceiveChannel receiveChannel6;
        Object objMo7069hasNext;
        if (continuation instanceof C13941) {
            c13941 = (C13941) continuation;
            int i4 = c13941.f5883label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c13941.f5883label = i4 - Integer.MIN_VALUE;
            } else {
                c13941 = new C13941(continuation);
            }
        }
        Object obj2 = c13941.f5884result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c13941.f5883label;
        if (i5 != 0) {
            if (i5 == 1) {
                int i6 = c13941.f5876I$1;
                int i7 = c13941.f5875I$0;
                ChannelIterator channelIterator3 = (ChannelIterator) c13941.f5881L$4;
                receiveChannel3 = (ReceiveChannel) c13941.f5880L$3;
                receiveChannel6 = (ReceiveChannel) c13941.f5879L$2;
                Comparator comparator3 = (Comparator) c13941.f5878L$1;
                receiveChannel2 = (ReceiveChannel) c13941.f5877L$0;
                try {
                    ResultKt.throwOnFailure(obj2);
                    i = i6;
                    receiveChannel = receiveChannel6;
                    obj = obj2;
                    i2 = i7;
                    comparator = comparator3;
                    channelIterator = channelIterator3;
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i8 = c13941.f5876I$1;
                i3 = c13941.f5875I$0;
                objMo7070next = c13941.f5882L$5;
                channelIterator2 = (ChannelIterator) c13941.f5881L$4;
                receiveChannel5 = (ReceiveChannel) c13941.f5880L$3;
                ReceiveChannel receiveChannel7 = (ReceiveChannel) c13941.f5879L$2;
                comparator2 = (Comparator) c13941.f5878L$1;
                receiveChannel4 = (ReceiveChannel) c13941.f5877L$0;
                try {
                    ResultKt.throwOnFailure(obj2);
                    C13941 c139412 = c13941;
                    int i9 = i8;
                    receiveChannel = receiveChannel7;
                    ReceiveChannel receiveChannel8 = receiveChannel5;
                    ChannelIterator channelIterator4 = channelIterator2;
                    Object obj3 = objMo7070next;
                    C13941 c139413 = c139412;
                    if (!((Boolean) obj2).booleanValue()) {
                        Object objMo7070next2 = channelIterator4.mo7070next();
                        if (comparator2.compare(obj3, objMo7070next2) > 0) {
                            channelIterator2 = channelIterator4;
                            receiveChannel5 = receiveChannel8;
                            objMo7070next = objMo7070next2;
                            i = i9;
                            c13941 = c139413;
                        } else {
                            i = i9;
                            c13941 = c139413;
                            objMo7070next = obj3;
                            channelIterator2 = channelIterator4;
                            receiveChannel5 = receiveChannel8;
                        }
                        c13941.f5877L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                        c13941.f5878L$1 = comparator2;
                        c13941.f5879L$2 = receiveChannel;
                        c13941.f5880L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                        c13941.f5881L$4 = channelIterator2;
                        c13941.f5882L$5 = objMo7070next;
                        c13941.f5875I$0 = i3;
                        c13941.f5876I$1 = i;
                        c13941.f5883label = 2;
                        objMo7069hasNext = channelIterator2.mo7069hasNext(c13941);
                        if (objMo7069hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c139412 = c13941;
                        i9 = i;
                        obj2 = objMo7069hasNext;
                        ReceiveChannel receiveChannel82 = receiveChannel5;
                        ChannelIterator channelIterator42 = channelIterator2;
                        Object obj32 = objMo7070next;
                        C13941 c1394132 = c139412;
                        if (!((Boolean) obj2).booleanValue()) {
                            ChannelsKt.cancelConsumed(receiveChannel, null);
                            return obj32;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    receiveChannel6 = receiveChannel7;
                }
            }
            try {
                throw th;
            } catch (Throwable th4) {
                ChannelsKt.cancelConsumed(receiveChannel6, th);
                throw th4;
            }
        }
        ResultKt.throwOnFailure(obj2);
        try {
            ChannelIterator it = receiveChannel.iterator();
            c13941.f5877L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
            c13941.f5878L$1 = comparator;
            c13941.f5879L$2 = receiveChannel;
            c13941.f5880L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel);
            c13941.f5881L$4 = it;
            i = 0;
            c13941.f5875I$0 = 0;
            c13941.f5876I$1 = 0;
            c13941.f5883label = 1;
            Object objMo7069hasNext2 = it.mo7069hasNext(c13941);
            if (objMo7069hasNext2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            receiveChannel2 = receiveChannel;
            channelIterator = it;
            obj = objMo7069hasNext2;
            receiveChannel3 = receiveChannel2;
            i2 = 0;
        } catch (Throwable th5) {
            receiveChannel6 = receiveChannel;
            th = th5;
        }
        if (!((Boolean) obj).booleanValue()) {
            ChannelsKt.cancelConsumed(receiveChannel, null);
            return null;
        }
        receiveChannel4 = receiveChannel2;
        comparator2 = comparator;
        i3 = i2;
        objMo7070next = channelIterator.mo7070next();
        receiveChannel5 = receiveChannel3;
        channelIterator2 = channelIterator;
        c13941.f5877L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
        c13941.f5878L$1 = comparator2;
        c13941.f5879L$2 = receiveChannel;
        c13941.f5880L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
        c13941.f5881L$4 = channelIterator2;
        c13941.f5882L$5 = objMo7070next;
        c13941.f5875I$0 = i3;
        c13941.f5876I$1 = i;
        c13941.f5883label = 2;
        objMo7069hasNext = channelIterator2.mo7069hasNext(c13941);
        if (objMo7069hasNext != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    /* renamed from: none */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object m7125none(ReceiveChannel receiveChannel, Continuation continuation) {
        C13951 c13951;
        if (continuation instanceof C13951) {
            c13951 = (C13951) continuation;
            int i = c13951.f5890label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13951.f5890label = i - Integer.MIN_VALUE;
            } else {
                c13951 = new C13951(continuation);
            }
        }
        Object objMo7069hasNext = c13951.f5891result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c13951.f5890label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objMo7069hasNext);
                ChannelIterator it = receiveChannel.iterator();
                c13951.f5887L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                c13951.f5888L$1 = receiveChannel;
                c13951.f5889L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                c13951.f5885I$0 = 0;
                c13951.f5886I$1 = 0;
                c13951.f5890label = 1;
                objMo7069hasNext = it.mo7069hasNext(c13951);
                if (objMo7069hasNext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                receiveChannel = (ReceiveChannel) c13951.f5888L$1;
                ResultKt.throwOnFailure(objMo7069hasNext);
            }
            Boolean boolBoxBoolean = C1207Boxing.boxBoolean(!((Boolean) objMo7069hasNext).booleanValue());
            ChannelsKt.cancelConsumed(receiveChannel, null);
            return boolBoxBoolean;
        } finally {
        }
    }

    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = "Passing a Job to coroutine builders breaks structured concurrency, leading to hard-to-diagnose errors. This pattern should be avoided. This overload will be deprecated with an error in the future.")
    /* renamed from: produce */
    public static final <E> ReceiveChannel<E> m7126produce(CoroutineScope coroutineScope, InterfaceC1342Job interfaceC1342Job, int i, @BuilderInference Function2<? super ProducerScope<? super E>, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNull(interfaceC1342Job, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext");
        return ProduceKt.m7151produce(coroutineScope, interfaceC1342Job, i, function2);
    }

    public static /* synthetic */ ReceiveChannel produce$default(CoroutineScope coroutineScope, InterfaceC1342Job interfaceC1342Job, int i, Function2 function2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return ChannelsKt.m7100produce(coroutineScope, interfaceC1342Job, i, function2);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009d A[Catch: all -> 0x0068, TRY_LEAVE, TryCatch #1 {all -> 0x0068, blocks: (B:20:0x005f, B:29:0x0095, B:31:0x009d, B:41:0x00dd, B:42:0x00e4), top: B:51:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dd A[Catch: all -> 0x0068, TRY_ENTER, TryCatch #1 {all -> 0x0068, blocks: (B:20:0x005f, B:29:0x0095, B:31:0x009d, B:41:0x00dd, B:42:0x00e4), top: B:51:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    /* renamed from: single */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object m7127single(ReceiveChannel receiveChannel, Continuation continuation) {
        C13971 c13971;
        ReceiveChannel receiveChannel2;
        Throwable th;
        int i;
        ReceiveChannel receiveChannel3;
        ChannelIterator channelIterator;
        int i2;
        ReceiveChannel receiveChannel4;
        Object obj;
        if (continuation instanceof C13971) {
            c13971 = (C13971) continuation;
            int i3 = c13971.f5901label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c13971.f5901label = i3 - Integer.MIN_VALUE;
            } else {
                c13971 = new C13971(continuation);
            }
        }
        Object obj2 = c13971.f5902result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c13971.f5901label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj2);
            try {
                ChannelIterator it = receiveChannel.iterator();
                c13971.f5896L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                c13971.f5897L$1 = receiveChannel;
                c13971.f5898L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                c13971.f5899L$3 = it;
                i = 0;
                c13971.f5894I$0 = 0;
                c13971.f5895I$1 = 0;
                c13971.f5901label = 1;
                Object objMo7069hasNext = it.mo7069hasNext(c13971);
                if (objMo7069hasNext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                receiveChannel3 = receiveChannel;
                receiveChannel2 = receiveChannel3;
                channelIterator = it;
                obj2 = objMo7069hasNext;
                i2 = 0;
                if (((Boolean) obj2).booleanValue()) {
                }
            } catch (Throwable th2) {
                receiveChannel2 = receiveChannel;
                th = th2;
                throw th;
            }
        } else if (i4 == 1) {
            int i5 = c13971.f5895I$1;
            int i6 = c13971.f5894I$0;
            ChannelIterator channelIterator2 = (ChannelIterator) c13971.f5899L$3;
            receiveChannel3 = (ReceiveChannel) c13971.f5898L$2;
            receiveChannel2 = (ReceiveChannel) c13971.f5897L$1;
            ReceiveChannel receiveChannel5 = (ReceiveChannel) c13971.f5896L$0;
            try {
                ResultKt.throwOnFailure(obj2);
                i = i5;
                receiveChannel = receiveChannel5;
                channelIterator = channelIterator2;
                i2 = i6;
                if (((Boolean) obj2).booleanValue()) {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
                Object objMo7070next = channelIterator.mo7070next();
                c13971.f5896L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                c13971.f5897L$1 = receiveChannel2;
                c13971.f5898L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                c13971.f5899L$3 = SpillingKt.nullOutSpilledVariable(channelIterator);
                c13971.f5900L$4 = objMo7070next;
                c13971.f5894I$0 = i2;
                c13971.f5895I$1 = i;
                c13971.f5901label = 2;
                Object objMo7069hasNext2 = channelIterator.mo7069hasNext(c13971);
                if (objMo7069hasNext2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                receiveChannel4 = receiveChannel2;
                obj2 = objMo7069hasNext2;
                obj = objMo7070next;
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        } else {
            if (i4 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj = c13971.f5900L$4;
            receiveChannel4 = (ReceiveChannel) c13971.f5897L$1;
            try {
                ResultKt.throwOnFailure(obj2);
            } catch (Throwable th4) {
                th = th4;
                receiveChannel2 = receiveChannel4;
                try {
                    throw th;
                } catch (Throwable th5) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                    throw th5;
                }
            }
        }
        if (((Boolean) obj2).booleanValue()) {
            throw new IllegalArgumentException("ReceiveChannel has more than one element.");
        }
        ChannelsKt.cancelConsumed(receiveChannel4, null);
        return obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object singleOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        C13981 c13981;
        int i;
        ReceiveChannel receiveChannel2;
        ReceiveChannel receiveChannel3;
        ChannelIterator channelIterator;
        int i2;
        ReceiveChannel receiveChannel4;
        Throwable th;
        Object obj;
        if (continuation instanceof C13981) {
            c13981 = (C13981) continuation;
            int i3 = c13981.f5910label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c13981.f5910label = i3 - Integer.MIN_VALUE;
            } else {
                c13981 = new C13981(continuation);
            }
        }
        Object obj2 = c13981.f5911result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c13981.f5910label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj2);
            try {
                ChannelIterator it = receiveChannel.iterator();
                c13981.f5905L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                c13981.f5906L$1 = receiveChannel;
                c13981.f5907L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                c13981.f5908L$3 = it;
                i = 0;
                c13981.f5903I$0 = 0;
                c13981.f5904I$1 = 0;
                c13981.f5910label = 1;
                Object objMo7069hasNext = it.mo7069hasNext(c13981);
                if (objMo7069hasNext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                receiveChannel2 = receiveChannel;
                receiveChannel3 = receiveChannel2;
                channelIterator = it;
                obj2 = objMo7069hasNext;
                i2 = 0;
            } catch (Throwable th2) {
                receiveChannel4 = receiveChannel;
                th = th2;
                throw th;
            }
        } else {
            if (i4 != 1) {
                if (i4 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = c13981.f5909L$4;
                receiveChannel4 = (ReceiveChannel) c13981.f5906L$1;
                try {
                    ResultKt.throwOnFailure(obj2);
                    if (((Boolean) obj2).booleanValue()) {
                        ChannelsKt.cancelConsumed(receiveChannel4, null);
                        return obj;
                    }
                    ChannelsKt.cancelConsumed(receiveChannel4, null);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        ChannelsKt.cancelConsumed(receiveChannel4, th);
                        throw th4;
                    }
                }
            }
            int i5 = c13981.f5904I$1;
            int i6 = c13981.f5903I$0;
            ChannelIterator channelIterator2 = (ChannelIterator) c13981.f5908L$3;
            receiveChannel2 = (ReceiveChannel) c13981.f5907L$2;
            ReceiveChannel receiveChannel5 = (ReceiveChannel) c13981.f5906L$1;
            receiveChannel3 = (ReceiveChannel) c13981.f5905L$0;
            try {
                ResultKt.throwOnFailure(obj2);
                i = i5;
                receiveChannel = receiveChannel5;
                channelIterator = channelIterator2;
                i2 = i6;
            } catch (Throwable th5) {
                th = th5;
                receiveChannel4 = receiveChannel5;
                throw th;
            }
        }
        if (!((Boolean) obj2).booleanValue()) {
            ChannelsKt.cancelConsumed(receiveChannel, null);
            return null;
        }
        Object objMo7070next = channelIterator.mo7070next();
        c13981.f5905L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
        c13981.f5906L$1 = receiveChannel;
        c13981.f5907L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
        c13981.f5908L$3 = SpillingKt.nullOutSpilledVariable(channelIterator);
        c13981.f5909L$4 = objMo7070next;
        c13981.f5903I$0 = i2;
        c13981.f5904I$1 = i;
        c13981.f5910label = 2;
        Object objMo7069hasNext2 = channelIterator.mo7069hasNext(c13981);
        if (objMo7069hasNext2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        receiveChannel4 = receiveChannel;
        obj = objMo7070next;
        obj2 = objMo7069hasNext2;
        if (((Boolean) obj2).booleanValue()) {
        }
    }

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    /* renamed from: take */
    public static final /* synthetic */ ReceiveChannel m7128take(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new C13991(i, receiveChannel, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel take$default(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return m7128take(receiveChannel, i, coroutineContext);
    }

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel takeWhile(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new C14001(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel takeWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return takeWhile(receiveChannel, coroutineContext, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0060: MOVE (r3 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]), block:B:17:0x005f */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ea A[Catch: all -> 0x0132, TryCatch #1 {all -> 0x0132, blocks: (B:26:0x00a6, B:30:0x00e2, B:32:0x00ea, B:39:0x0135), top: B:50:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0135 A[Catch: all -> 0x0132, TRY_LEAVE, TryCatch #1 {all -> 0x0132, blocks: (B:26:0x00a6, B:30:0x00e2, B:32:0x00ea, B:39:0x0135), top: B:50:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.lang.Object, kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x012f -> B:50:0x00a6). Please report as a decompilation issue!!! */
    @PublishedApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends SendChannel<? super E>> Object toChannel(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        C14011 c14011;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        int i;
        int i2;
        ChannelIterator it;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        int i3;
        ?? r12;
        ReceiveChannel<? extends E> receiveChannel7;
        C14011 c140112;
        ReceiveChannel<? extends E> receiveChannel8;
        int i4;
        ReceiveChannel<? extends E> receiveChannel9;
        Throwable th2;
        int i5;
        Object obj;
        Object objMo7069hasNext;
        if (continuation instanceof C14011) {
            c14011 = (C14011) continuation;
            int i6 = c14011.f5934label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                c14011.f5934label = i6 - Integer.MIN_VALUE;
            } else {
                c14011 = new C14011(continuation);
            }
        }
        Object obj2 = c14011.f5935result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i7 = c14011.f5934label;
        int i8 = 1;
        if (i7 != 0) {
            try {
                if (i7 == 1) {
                    int i9 = c14011.f5924I$2;
                    i = c14011.f5923I$1;
                    i2 = c14011.f5922I$0;
                    it = (ChannelIterator) c14011.f5931L$5;
                    receiveChannel4 = (ReceiveChannel) c14011.f5930L$4;
                    ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) c14011.f5929L$3;
                    receiveChannel5 = (ReceiveChannel) c14011.f5928L$2;
                    SendChannel sendChannel = (SendChannel) c14011.f5927L$1;
                    receiveChannel6 = (ReceiveChannel) c14011.f5926L$0;
                    ResultKt.throwOnFailure(obj2);
                    i3 = i9;
                    receiveChannel3 = receiveChannel10;
                    r12 = sendChannel;
                    if (((Boolean) obj2).booleanValue()) {
                    }
                } else {
                    if (i7 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i10 = c14011.f5924I$2;
                    int i11 = c14011.f5923I$1;
                    i2 = c14011.f5922I$0;
                    it = (ChannelIterator) c14011.f5931L$5;
                    ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) c14011.f5930L$4;
                    ReceiveChannel<? extends E> receiveChannel12 = (ReceiveChannel) c14011.f5929L$3;
                    ReceiveChannel<? extends E> receiveChannel13 = (ReceiveChannel) c14011.f5928L$2;
                    Object obj3 = (SendChannel) c14011.f5927L$1;
                    ReceiveChannel<? extends E> receiveChannel14 = (ReceiveChannel) c14011.f5926L$0;
                    ResultKt.throwOnFailure(obj2);
                    receiveChannel7 = receiveChannel14;
                    c140112 = c14011;
                    receiveChannel8 = receiveChannel13;
                    i4 = i11;
                    receiveChannel9 = receiveChannel11;
                    Object obj4 = obj3;
                    i3 = i10;
                    receiveChannel3 = receiveChannel12;
                    try {
                        i5 = i2;
                        obj = obj4;
                        c140112.f5926L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel7);
                        c140112.f5927L$1 = obj;
                        c140112.f5928L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel8);
                        c140112.f5929L$3 = receiveChannel3;
                        c140112.f5930L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel9);
                        c140112.f5931L$5 = it;
                        c140112.f5932L$6 = null;
                        c140112.f5933L$7 = null;
                        c140112.f5922I$0 = i5;
                        c140112.f5923I$1 = i4;
                        c140112.f5924I$2 = i3;
                        c140112.f5934label = i8;
                        objMo7069hasNext = it.mo7069hasNext(c140112);
                        if (objMo7069hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel6 = receiveChannel7;
                        obj2 = objMo7069hasNext;
                        int i12 = i4;
                        receiveChannel5 = receiveChannel8;
                        c14011 = c140112;
                        receiveChannel4 = receiveChannel9;
                        i = i12;
                        int i13 = i5;
                        r12 = obj;
                        i2 = i13;
                        if (((Boolean) obj2).booleanValue()) {
                            C1133Unit c1133Unit = C1133Unit.INSTANCE;
                            ChannelsKt.cancelConsumed(receiveChannel3, null);
                            return r12;
                        }
                        Object objMo7070next = it.mo7070next();
                        c14011.f5926L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel6);
                        c14011.f5927L$1 = r12;
                        c14011.f5928L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                        c14011.f5929L$3 = receiveChannel3;
                        c14011.f5930L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                        c14011.f5931L$5 = it;
                        c14011.f5932L$6 = SpillingKt.nullOutSpilledVariable(objMo7070next);
                        c14011.f5933L$7 = SpillingKt.nullOutSpilledVariable(objMo7070next);
                        c14011.f5922I$0 = i2;
                        c14011.f5923I$1 = i;
                        c14011.f5924I$2 = i3;
                        c14011.f5925I$3 = 0;
                        c14011.f5934label = 2;
                        if (r12.mo7052send(objMo7070next, c14011) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel7 = receiveChannel6;
                        ReceiveChannel<? extends E> receiveChannel15 = receiveChannel4;
                        c140112 = c14011;
                        receiveChannel8 = receiveChannel5;
                        i4 = i;
                        receiveChannel9 = receiveChannel15;
                        obj4 = r12;
                        i5 = i2;
                        obj = obj4;
                        i8 = 1;
                        c140112.f5926L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel7);
                        c140112.f5927L$1 = obj;
                        c140112.f5928L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel8);
                        c140112.f5929L$3 = receiveChannel3;
                        c140112.f5930L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel9);
                        c140112.f5931L$5 = it;
                        c140112.f5932L$6 = null;
                        c140112.f5933L$7 = null;
                        c140112.f5922I$0 = i5;
                        c140112.f5923I$1 = i4;
                        c140112.f5924I$2 = i3;
                        c140112.f5934label = i8;
                        objMo7069hasNext = it.mo7069hasNext(c140112);
                        if (objMo7069hasNext == coroutine_suspended) {
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        th = th2;
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            ChannelsKt.cancelConsumed(receiveChannel3, th);
                            throw th4;
                        }
                    }
                    i8 = 1;
                }
            } catch (Throwable th5) {
                th = th5;
                receiveChannel3 = receiveChannel2;
                throw th;
            }
        } else {
            ResultKt.throwOnFailure(obj2);
            try {
                receiveChannel3 = receiveChannel;
                receiveChannel9 = receiveChannel3;
                obj = c;
                it = receiveChannel.iterator();
                c140112 = c14011;
                i5 = 0;
                i4 = 0;
                i3 = 0;
                receiveChannel7 = receiveChannel9;
                receiveChannel8 = receiveChannel7;
                c140112.f5926L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel7);
                c140112.f5927L$1 = obj;
                c140112.f5928L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel8);
                c140112.f5929L$3 = receiveChannel3;
                c140112.f5930L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel9);
                c140112.f5931L$5 = it;
                c140112.f5932L$6 = null;
                c140112.f5933L$7 = null;
                c140112.f5922I$0 = i5;
                c140112.f5923I$1 = i4;
                c140112.f5924I$2 = i3;
                c140112.f5934label = i8;
                objMo7069hasNext = it.mo7069hasNext(c140112);
                if (objMo7069hasNext == coroutine_suspended) {
                }
            } catch (Throwable th6) {
                th2 = th6;
                receiveChannel3 = receiveChannel;
                th = th2;
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a3 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:12:0x0043, B:25:0x009b, B:27:0x00a3, B:28:0x00af), top: B:39:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00af A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #0 {all -> 0x0052, blocks: (B:12:0x0043, B:25:0x009b, B:27:0x00a3, B:28:0x00af), top: B:39:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0095 -> B:25:0x009b). Please report as a decompilation issue!!! */
    @PublishedApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends Collection<? super E>> Object toCollection(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        C14021 c14021;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        int i;
        C c2;
        ChannelIterator it;
        C14021 c140212;
        int i2;
        int i3;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        Object objMo7069hasNext;
        if (continuation instanceof C14021) {
            c14021 = (C14021) continuation;
            int i4 = c14021.f5945label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c14021.f5945label = i4 - Integer.MIN_VALUE;
            } else {
                c14021 = new C14021(continuation);
            }
        }
        Object obj = c14021.f5946result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c14021.f5945label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                i = 0;
                c2 = c;
                it = receiveChannel.iterator();
                c140212 = c14021;
                i2 = 0;
                i3 = 0;
                receiveChannel3 = receiveChannel;
                receiveChannel2 = receiveChannel3;
                receiveChannel4 = receiveChannel2;
                c140212.f5939L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                c140212.f5940L$1 = c2;
                c140212.f5941L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                c140212.f5942L$3 = receiveChannel2;
                c140212.f5943L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                c140212.f5944L$5 = it;
                c140212.f5936I$0 = i3;
                c140212.f5937I$1 = i2;
                c140212.f5938I$2 = i;
                c140212.f5945label = 1;
                objMo7069hasNext = it.mo7069hasNext(c140212);
                if (objMo7069hasNext != coroutine_suspended) {
                }
            } catch (Throwable th2) {
                receiveChannel2 = receiveChannel;
                th = th2;
                throw th;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i6 = c14021.f5938I$2;
            int i7 = c14021.f5937I$1;
            int i8 = c14021.f5936I$0;
            ChannelIterator channelIterator = (ChannelIterator) c14021.f5944L$5;
            ReceiveChannel<? extends E> receiveChannel5 = (ReceiveChannel) c14021.f5943L$4;
            ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) c14021.f5942L$3;
            ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) c14021.f5941L$2;
            Collection collection = (Collection) c14021.f5940L$1;
            ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) c14021.f5939L$0;
            try {
                ResultKt.throwOnFailure(obj);
                i = i6;
                receiveChannel = receiveChannel8;
                ChannelIterator channelIterator2 = channelIterator;
                ?? r4 = collection;
                int i9 = i8;
                i2 = i7;
                receiveChannel3 = receiveChannel7;
                C14021 c140213 = c14021;
                receiveChannel4 = receiveChannel5;
                if (!((Boolean) obj).booleanValue()) {
                    r4.add(channelIterator2.mo7070next());
                    receiveChannel2 = receiveChannel6;
                    c140212 = c140213;
                    i3 = i9;
                    it = channelIterator2;
                    c2 = r4;
                    try {
                        c140212.f5939L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        c140212.f5940L$1 = c2;
                        c140212.f5941L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                        c140212.f5942L$3 = receiveChannel2;
                        c140212.f5943L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                        c140212.f5944L$5 = it;
                        c140212.f5936I$0 = i3;
                        c140212.f5937I$1 = i2;
                        c140212.f5938I$2 = i;
                        c140212.f5945label = 1;
                        objMo7069hasNext = it.mo7069hasNext(c140212);
                        if (objMo7069hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        C14021 c140214 = c140212;
                        receiveChannel6 = receiveChannel2;
                        obj = objMo7069hasNext;
                        channelIterator2 = it;
                        i9 = i3;
                        c140213 = c140214;
                        r4 = c2;
                        if (!((Boolean) obj).booleanValue()) {
                            C1133Unit c1133Unit = C1133Unit.INSTANCE;
                            ChannelsKt.cancelConsumed(receiveChannel6, null);
                            return r4;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th4;
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                receiveChannel2 = receiveChannel6;
                throw th;
            }
        }
    }

    @PublishedApi
    public static final <E> Object toMutableSet(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Set<E>> continuation) {
        return ChannelsKt.toCollection(receiveChannel, new LinkedHashSet(), continuation);
    }

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel withIndex(ReceiveChannel receiveChannel, CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new C14041(receiveChannel, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel withIndex$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return withIndex(receiveChannel, coroutineContext);
    }

    public static /* synthetic */ ReceiveChannel zip$default(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.m7108zip(receiveChannel, receiveChannel2, coroutineContext, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a3 A[Catch: all -> 0x0052, TryCatch #2 {all -> 0x0052, blocks: (B:12:0x0043, B:25:0x009b, B:27:0x00a3, B:28:0x00b9), top: B:43:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b9 A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #2 {all -> 0x0052, blocks: (B:12:0x0043, B:25:0x009b, B:27:0x00a3, B:28:0x00b9), top: B:43:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0095 -> B:25:0x009b). Please report as a decompilation issue!!! */
    @PublishedApi
    /* renamed from: toMap */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <K, V, M extends Map<? super K, ? super V>> Object m7129toMap(ReceiveChannel<? extends C1122Pair<? extends K, ? extends V>> receiveChannel, M m, Continuation<? super M> continuation) {
        C14032 c14032;
        ReceiveChannel<? extends C1122Pair<? extends K, ? extends V>> receiveChannel2;
        Throwable th;
        int i;
        M m2;
        ChannelIterator it;
        C14032 c140322;
        int i2;
        int i3;
        ReceiveChannel<? extends C1122Pair<? extends K, ? extends V>> receiveChannel3;
        ReceiveChannel<? extends C1122Pair<? extends K, ? extends V>> receiveChannel4;
        Object objMo7069hasNext;
        if (continuation instanceof C14032) {
            c14032 = (C14032) continuation;
            int i4 = c14032.f5956label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c14032.f5956label = i4 - Integer.MIN_VALUE;
            } else {
                c14032 = new C14032(continuation);
            }
        }
        Object obj = c14032.f5957result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c14032.f5956label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                i = 0;
                m2 = m;
                it = receiveChannel.iterator();
                c140322 = c14032;
                i2 = 0;
                i3 = 0;
                receiveChannel3 = receiveChannel;
                receiveChannel2 = receiveChannel3;
                receiveChannel4 = receiveChannel2;
                c140322.f5950L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                c140322.f5951L$1 = m2;
                c140322.f5952L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                c140322.f5953L$3 = receiveChannel2;
                c140322.f5954L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                c140322.f5955L$5 = it;
                c140322.f5947I$0 = i3;
                c140322.f5948I$1 = i2;
                c140322.f5949I$2 = i;
                c140322.f5956label = 1;
                objMo7069hasNext = it.mo7069hasNext(c140322);
                if (objMo7069hasNext != coroutine_suspended) {
                }
            } catch (Throwable th2) {
                receiveChannel2 = receiveChannel;
                th = th2;
                throw th;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i6 = c14032.f5949I$2;
            int i7 = c14032.f5948I$1;
            int i8 = c14032.f5947I$0;
            ChannelIterator channelIterator = (ChannelIterator) c14032.f5955L$5;
            ReceiveChannel<? extends C1122Pair<? extends K, ? extends V>> receiveChannel5 = (ReceiveChannel) c14032.f5954L$4;
            ReceiveChannel<? extends C1122Pair<? extends K, ? extends V>> receiveChannel6 = (ReceiveChannel) c14032.f5953L$3;
            ReceiveChannel<? extends C1122Pair<? extends K, ? extends V>> receiveChannel7 = (ReceiveChannel) c14032.f5952L$2;
            Map map = (Map) c14032.f5951L$1;
            ReceiveChannel<? extends C1122Pair<? extends K, ? extends V>> receiveChannel8 = (ReceiveChannel) c14032.f5950L$0;
            try {
                ResultKt.throwOnFailure(obj);
                i = i6;
                receiveChannel = receiveChannel8;
                ChannelIterator channelIterator2 = channelIterator;
                ?? r4 = map;
                int i9 = i8;
                i2 = i7;
                receiveChannel3 = receiveChannel7;
                C14032 c140323 = c14032;
                receiveChannel4 = receiveChannel5;
                if (!((Boolean) obj).booleanValue()) {
                    C1122Pair c1122Pair = (C1122Pair) channelIterator2.mo7070next();
                    r4.put(c1122Pair.getFirst(), c1122Pair.getSecond());
                    receiveChannel2 = receiveChannel6;
                    c140322 = c140323;
                    i3 = i9;
                    it = channelIterator2;
                    m2 = r4;
                    try {
                        c140322.f5950L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        c140322.f5951L$1 = m2;
                        c140322.f5952L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                        c140322.f5953L$3 = receiveChannel2;
                        c140322.f5954L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                        c140322.f5955L$5 = it;
                        c140322.f5947I$0 = i3;
                        c140322.f5948I$1 = i2;
                        c140322.f5949I$2 = i;
                        c140322.f5956label = 1;
                        objMo7069hasNext = it.mo7069hasNext(c140322);
                        if (objMo7069hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        C14032 c140324 = c140322;
                        receiveChannel6 = receiveChannel2;
                        obj = objMo7069hasNext;
                        channelIterator2 = it;
                        i9 = i3;
                        c140323 = c140324;
                        r4 = m2;
                        if (!((Boolean) obj).booleanValue()) {
                            C1133Unit c1133Unit = C1133Unit.INSTANCE;
                            ChannelsKt.cancelConsumed(receiveChannel6, null);
                            return r4;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th4;
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                receiveChannel2 = receiveChannel6;
                throw th;
            }
        }
    }

    @PublishedApi
    /* renamed from: zip */
    public static final <E, R, V> ReceiveChannel<V> m7134zip(ReceiveChannel<? extends E> receiveChannel, ReceiveChannel<? extends R> receiveChannel2, CoroutineContext coroutineContext, Function2<? super E, ? super R, ? extends V> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumesAll(receiveChannel, receiveChannel2), new C14052(receiveChannel2, receiveChannel, function2, null), 6, null);
    }

    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0051: MOVE (r3 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]), block:B:16:0x0050 */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00db A[Catch: all -> 0x012c, TryCatch #2 {all -> 0x012c, blocks: (B:25:0x0097, B:29:0x00d3, B:31:0x00db, B:33:0x00e1, B:43:0x013d), top: B:56:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013d A[Catch: all -> 0x012c, TRY_LEAVE, TryCatch #2 {all -> 0x012c, blocks: (B:25:0x0097, B:29:0x00d3, B:31:0x00db, B:33:0x00e1, B:43:0x013d), top: B:56:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x013a -> B:56:0x0097). Please report as a decompilation issue!!! */
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel receiveChannel, SendChannel sendChannel, Continuation continuation) {
        C13833 c13833;
        Throwable th;
        ReceiveChannel receiveChannel2;
        ReceiveChannel receiveChannel3;
        int i;
        int i2;
        ChannelIterator it;
        ReceiveChannel receiveChannel4;
        ReceiveChannel receiveChannel5;
        ReceiveChannel receiveChannel6;
        int i3;
        SendChannel sendChannel2;
        Throwable th2;
        int i4;
        C13833 c138332;
        ReceiveChannel receiveChannel7;
        ReceiveChannel receiveChannel8;
        ReceiveChannel receiveChannel9;
        int i5;
        SendChannel sendChannel3;
        Object objMo7069hasNext;
        if (continuation instanceof C13833) {
            c13833 = (C13833) continuation;
            int i6 = c13833.f5780label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                c13833.f5780label = i6 - Integer.MIN_VALUE;
            } else {
                c13833 = new C13833(continuation);
            }
        }
        Object obj = c13833.f5781result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i7 = c13833.f5780label;
        int i8 = 1;
        if (i7 == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                receiveChannel3 = receiveChannel;
                receiveChannel7 = receiveChannel3;
                sendChannel3 = sendChannel;
                it = receiveChannel.iterator();
                c138332 = c13833;
                i5 = 0;
                i4 = 0;
                i3 = 0;
                receiveChannel9 = receiveChannel7;
                receiveChannel8 = receiveChannel9;
                c138332.f5772L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel9);
                c138332.f5773L$1 = sendChannel3;
                c138332.f5774L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel8);
                c138332.f5775L$3 = receiveChannel3;
                c138332.f5776L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel7);
                c138332.f5777L$5 = it;
                c138332.f5778L$6 = null;
                c138332.f5779L$7 = null;
                c138332.f5768I$0 = i5;
                c138332.f5769I$1 = i4;
                c138332.f5770I$2 = i3;
                c138332.f5780label = i8;
                objMo7069hasNext = it.mo7069hasNext(c138332);
                if (objMo7069hasNext != coroutine_suspended) {
                }
            } catch (Throwable th3) {
                th2 = th3;
                receiveChannel3 = receiveChannel;
                th = th2;
                throw th;
            }
        } else {
            try {
                if (i7 == 1) {
                    int i9 = c13833.f5770I$2;
                    i = c13833.f5769I$1;
                    i2 = c13833.f5768I$0;
                    it = (ChannelIterator) c13833.f5777L$5;
                    receiveChannel4 = (ReceiveChannel) c13833.f5776L$4;
                    ReceiveChannel receiveChannel10 = (ReceiveChannel) c13833.f5775L$3;
                    receiveChannel5 = (ReceiveChannel) c13833.f5774L$2;
                    SendChannel sendChannel4 = (SendChannel) c13833.f5773L$1;
                    receiveChannel6 = (ReceiveChannel) c13833.f5772L$0;
                    ResultKt.throwOnFailure(obj);
                    i3 = i9;
                    receiveChannel3 = receiveChannel10;
                    sendChannel2 = sendChannel4;
                    if (!((Boolean) obj).booleanValue()) {
                    }
                } else {
                    if (i7 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i10 = c13833.f5770I$2;
                    i = c13833.f5769I$1;
                    i2 = c13833.f5768I$0;
                    it = (ChannelIterator) c13833.f5777L$5;
                    receiveChannel4 = (ReceiveChannel) c13833.f5776L$4;
                    ReceiveChannel receiveChannel11 = (ReceiveChannel) c13833.f5775L$3;
                    receiveChannel5 = (ReceiveChannel) c13833.f5774L$2;
                    SendChannel sendChannel5 = (SendChannel) c13833.f5773L$1;
                    receiveChannel6 = (ReceiveChannel) c13833.f5772L$0;
                    ResultKt.throwOnFailure(obj);
                    try {
                        receiveChannel9 = receiveChannel6;
                        ReceiveChannel receiveChannel12 = receiveChannel4;
                        c138332 = c13833;
                        receiveChannel8 = receiveChannel5;
                        i4 = i;
                        receiveChannel7 = receiveChannel12;
                        SendChannel sendChannel6 = sendChannel5;
                        i3 = i10;
                        receiveChannel3 = receiveChannel11;
                        i5 = i2;
                        sendChannel3 = sendChannel6;
                        c138332.f5772L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel9);
                        c138332.f5773L$1 = sendChannel3;
                        c138332.f5774L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel8);
                        c138332.f5775L$3 = receiveChannel3;
                        c138332.f5776L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel7);
                        c138332.f5777L$5 = it;
                        c138332.f5778L$6 = null;
                        c138332.f5779L$7 = null;
                        c138332.f5768I$0 = i5;
                        c138332.f5769I$1 = i4;
                        c138332.f5770I$2 = i3;
                        c138332.f5780label = i8;
                        objMo7069hasNext = it.mo7069hasNext(c138332);
                        if (objMo7069hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel6 = receiveChannel9;
                        obj = objMo7069hasNext;
                        int i11 = i4;
                        receiveChannel5 = receiveChannel8;
                        c13833 = c138332;
                        receiveChannel4 = receiveChannel7;
                        i = i11;
                        int i12 = i5;
                        sendChannel2 = sendChannel3;
                        i2 = i12;
                        if (!((Boolean) obj).booleanValue()) {
                            C1133Unit c1133Unit = C1133Unit.INSTANCE;
                            ChannelsKt.cancelConsumed(receiveChannel3, null);
                            return sendChannel2;
                        }
                        Object objMo7070next = it.mo7070next();
                        if (objMo7070next != null) {
                            c13833.f5772L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel6);
                            c13833.f5773L$1 = sendChannel2;
                            c13833.f5774L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                            c13833.f5775L$3 = receiveChannel3;
                            c13833.f5776L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                            c13833.f5777L$5 = it;
                            c13833.f5778L$6 = SpillingKt.nullOutSpilledVariable(objMo7070next);
                            c13833.f5779L$7 = SpillingKt.nullOutSpilledVariable(objMo7070next);
                            c13833.f5768I$0 = i2;
                            c13833.f5769I$1 = i;
                            c13833.f5770I$2 = i3;
                            c13833.f5771I$3 = 0;
                            c13833.f5780label = 2;
                            if (sendChannel2.mo7052send(objMo7070next, c13833) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            SendChannel sendChannel7 = sendChannel2;
                            receiveChannel11 = receiveChannel3;
                            i10 = i3;
                            sendChannel5 = sendChannel7;
                            receiveChannel9 = receiveChannel6;
                            ReceiveChannel receiveChannel122 = receiveChannel4;
                            c138332 = c13833;
                            receiveChannel8 = receiveChannel5;
                            i4 = i;
                            receiveChannel7 = receiveChannel122;
                            SendChannel sendChannel62 = sendChannel5;
                            i3 = i10;
                            receiveChannel3 = receiveChannel11;
                            i5 = i2;
                            sendChannel3 = sendChannel62;
                            i8 = 1;
                            c138332.f5772L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel9);
                            c138332.f5773L$1 = sendChannel3;
                            c138332.f5774L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel8);
                            c138332.f5775L$3 = receiveChannel3;
                            c138332.f5776L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel7);
                            c138332.f5777L$5 = it;
                            c138332.f5778L$6 = null;
                            c138332.f5779L$7 = null;
                            c138332.f5768I$0 = i5;
                            c138332.f5769I$1 = i4;
                            c138332.f5770I$2 = i3;
                            c138332.f5780label = i8;
                            objMo7069hasNext = it.mo7069hasNext(c138332);
                            if (objMo7069hasNext != coroutine_suspended) {
                            }
                        } else {
                            receiveChannel9 = receiveChannel6;
                            ReceiveChannel receiveChannel13 = receiveChannel4;
                            c138332 = c13833;
                            receiveChannel8 = receiveChannel5;
                            i4 = i;
                            receiveChannel7 = receiveChannel13;
                            sendChannel62 = sendChannel2;
                            i5 = i2;
                            sendChannel3 = sendChannel62;
                            i8 = 1;
                            c138332.f5772L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel9);
                            c138332.f5773L$1 = sendChannel3;
                            c138332.f5774L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel8);
                            c138332.f5775L$3 = receiveChannel3;
                            c138332.f5776L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel7);
                            c138332.f5777L$5 = it;
                            c138332.f5778L$6 = null;
                            c138332.f5779L$7 = null;
                            c138332.f5768I$0 = i5;
                            c138332.f5769I$1 = i4;
                            c138332.f5770I$2 = i3;
                            c138332.f5780label = i8;
                            objMo7069hasNext = it.mo7069hasNext(c138332);
                            if (objMo7069hasNext != coroutine_suspended) {
                            }
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        th = th2;
                        try {
                            throw th;
                        } catch (Throwable th5) {
                            ChannelsKt.cancelConsumed(receiveChannel3, th);
                            throw th5;
                        }
                    }
                    i8 = 1;
                }
            } catch (Throwable th6) {
                th = th6;
                receiveChannel3 = receiveChannel2;
                throw th;
            }
        }
    }
}
