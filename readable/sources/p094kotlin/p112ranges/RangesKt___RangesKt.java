package p094kotlin.p112ranges;

import java.util.NoSuchElementException;
import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecatedSinceKotlin;
import p094kotlin.ExperimentalStdlibApi;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.WasExperimental;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p110random.AbstractC1241Random;
import p094kotlin.p110random.RandomKt;
import p094kotlin.p112ranges.CharProgression;
import p094kotlin.p112ranges.IntProgression;
import p094kotlin.p112ranges.LongProgression;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000f\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0006*\u00020\u0007H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a\u001c\u0010\u0000\u001a\u00020\b*\u00020\tH\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a#\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005¢\u0006\u0002\u0010\u000b\u001a#\u0010\n\u001a\u0004\u0018\u00010\u0006*\u00020\u0007H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005¢\u0006\u0002\u0010\f\u001a#\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\tH\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005¢\u0006\u0002\u0010\r\u001a\u001c\u0010\u000e\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a\u001c\u0010\u000e\u001a\u00020\u0006*\u00020\u0007H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a\u001c\u0010\u000e\u001a\u00020\b*\u00020\tH\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a#\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005¢\u0006\u0002\u0010\u000b\u001a#\u0010\u000f\u001a\u0004\u0018\u00010\u0006*\u00020\u0007H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005¢\u0006\u0002\u0010\f\u001a#\u0010\u000f\u001a\u0004\u0018\u00010\b*\u00020\tH\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005¢\u0006\u0002\u0010\r\u001a \u0010\u0010\u001a\u00020\u0001*\u00020\u0011H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012b\u0002\b\u0013\u001a \u0010\u0010\u001a\u00020\u0006*\u00020\u0014H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012b\u0002\b\u0013\u001a \u0010\u0010\u001a\u00020\b*\u00020\u0015H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012b\u0002\b\u0013\u001a$\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0016H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u001a$\u0010\u0010\u001a\u00020\u0006*\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0016H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u001a$\u0010\u0010\u001a\u00020\b*\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0016H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u001a'\u0010\u0017\u001a\u0004\u0018\u00010\u0001*\u00020\u0011H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019b\u0002\b\u0013¢\u0006\u0002\u0010\u0018\u001a'\u0010\u0017\u001a\u0004\u0018\u00010\u0006*\u00020\u0014H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019b\u0002\b\u0013¢\u0006\u0002\u0010\u001a\u001a'\u0010\u0017\u001a\u0004\u0018\u00010\b*\u00020\u0015H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019b\u0002\b\u0013¢\u0006\u0002\u0010\u001b\u001a+\u0010\u0017\u001a\u0004\u0018\u00010\u0001*\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0016H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019¢\u0006\u0002\u0010\u001c\u001a+\u0010\u0017\u001a\u0004\u0018\u00010\u0006*\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0016H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019¢\u0006\u0002\u0010\u001d\u001a+\u0010\u0017\u001a\u0004\u0018\u00010\b*\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0016H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019¢\u0006\u0002\u0010\u001e\u001a/\u0010\u001f\u001a\u00020 *\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0087\u008a\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012b\u0002\b\u0013¢\u0006\u0002\u0010\"\u001a/\u0010\u001f\u001a\u00020 *\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\u0006H\u0087\u008a\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012b\u0002\b\u0013¢\u0006\u0002\u0010#\u001a/\u0010\u001f\u001a\u00020 *\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\bH\u0087\u008a\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012b\u0002\b\u0013¢\u0006\u0002\u0010$\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00010%2\u0006\u0010&\u001a\u00020'H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b((¢\u0006\u0002\b(\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010&\u001a\u00020'H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(+¢\u0006\u0002\b+\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020,0%2\u0006\u0010&\u001a\u00020'H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(-¢\u0006\u0002\b-\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020.0%2\u0006\u0010&\u001a\u00020'H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(/¢\u0006\u0002\b/\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u0002080%2\u0006\u0010&\u001a\u00020'H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(9¢\u0006\u0002\b9\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00010:2\u0006\u0010&\u001a\u00020'H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b((b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b(\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00060:2\u0006\u0010&\u001a\u00020'H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(+b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b+\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020,0:2\u0006\u0010&\u001a\u00020'H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(-b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b-\u001a\u001a\u0010\u001f\u001a\u00020 *\u00020\u00112\u0006\u0010&\u001a\u00020'H\u0087\u008a\u0004b\u0002\b\u0013\u001a\u001a\u0010\u001f\u001a\u00020 *\u00020\u00142\u0006\u0010&\u001a\u00020'H\u0087\u008a\u0004b\u0002\b\u0013\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00010%2\u0006\u0010&\u001a\u00020.H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b((¢\u0006\u0002\b(\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010&\u001a\u00020.H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(+¢\u0006\u0002\b+\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020'0%2\u0006\u0010&\u001a\u00020.H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(?¢\u0006\u0002\b?\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020,0%2\u0006\u0010&\u001a\u00020.H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(-¢\u0006\u0002\b-\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u0002080%2\u0006\u0010&\u001a\u00020.H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(9¢\u0006\u0002\b9\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00010%2\u0006\u0010&\u001a\u000208H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b((¢\u0006\u0002\b(\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010&\u001a\u000208H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(+¢\u0006\u0002\b+\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020'0%2\u0006\u0010&\u001a\u000208H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(?¢\u0006\u0002\b?\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020,0%2\u0006\u0010&\u001a\u000208H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(-¢\u0006\u0002\b-\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020.0%2\u0006\u0010&\u001a\u000208H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(/¢\u0006\u0002\b/\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020.0:2\u0006\u0010&\u001a\u000208H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(/b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b/\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(+¢\u0006\u0002\b+\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020'0%2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(?¢\u0006\u0002\b?\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020,0%2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(-¢\u0006\u0002\b-\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020.0%2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(/¢\u0006\u0002\b/\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u0002080%2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(9¢\u0006\u0002\b9\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00060:2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(+b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b+\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020'0:2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(?b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b?\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020,0:2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(-b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b-\u001a\u001a\u0010\u001f\u001a\u00020 *\u00020\u00142\u0006\u0010&\u001a\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0013\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00010%2\u0006\u0010&\u001a\u00020\u0006H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b((¢\u0006\u0002\b(\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020'0%2\u0006\u0010&\u001a\u00020\u0006H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(?¢\u0006\u0002\b?\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020,0%2\u0006\u0010&\u001a\u00020\u0006H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(-¢\u0006\u0002\b-\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020.0%2\u0006\u0010&\u001a\u00020\u0006H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(/¢\u0006\u0002\b/\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u0002080%2\u0006\u0010&\u001a\u00020\u0006H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(9¢\u0006\u0002\b9\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00010:2\u0006\u0010&\u001a\u00020\u0006H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b((b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b(\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020'0:2\u0006\u0010&\u001a\u00020\u0006H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(?b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b?\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020,0:2\u0006\u0010&\u001a\u00020\u0006H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(-b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b-\u001a\u001a\u0010\u001f\u001a\u00020 *\u00020\u00112\u0006\u0010&\u001a\u00020\u0006H\u0087\u008a\u0004b\u0002\b\u0013\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00010%2\u0006\u0010&\u001a\u00020,H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b((¢\u0006\u0002\b(\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010&\u001a\u00020,H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(+¢\u0006\u0002\b+\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020'0%2\u0006\u0010&\u001a\u00020,H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(?¢\u0006\u0002\b?\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020.0%2\u0006\u0010&\u001a\u00020,H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(/¢\u0006\u0002\b/\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u0002080%2\u0006\u0010&\u001a\u00020,H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(9¢\u0006\u0002\b9\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00010:2\u0006\u0010&\u001a\u00020,H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b((b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b(\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00060:2\u0006\u0010&\u001a\u00020,H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(+b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b+\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020'0:2\u0006\u0010&\u001a\u00020,H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(?b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b?\u001a\u001a\u0010\u001f\u001a\u00020 *\u00020\u00112\u0006\u0010&\u001a\u00020,H\u0087\u008a\u0004b\u0002\b\u0013\u001a\u001a\u0010\u001f\u001a\u00020 *\u00020\u00142\u0006\u0010&\u001a\u00020,H\u0087\u008a\u0004b\u0002\b\u0013\u001a\u0016\u0010@\u001a\u00020\u0002*\u00020\u00012\u0006\u0010A\u001a\u00020'H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0007*\u00020\u00062\u0006\u0010A\u001a\u00020'H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0002*\u00020'2\u0006\u0010A\u001a\u00020'H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0002*\u00020,2\u0006\u0010A\u001a\u00020'H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\t*\u00020\b2\u0006\u0010A\u001a\u00020\bH\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0002*\u00020\u00012\u0006\u0010A\u001a\u00020\u0001H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0007*\u00020\u00062\u0006\u0010A\u001a\u00020\u0001H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0002*\u00020'2\u0006\u0010A\u001a\u00020\u0001H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0002*\u00020,2\u0006\u0010A\u001a\u00020\u0001H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0007*\u00020\u00012\u0006\u0010A\u001a\u00020\u0006H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0007*\u00020\u00062\u0006\u0010A\u001a\u00020\u0006H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0007*\u00020'2\u0006\u0010A\u001a\u00020\u0006H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0007*\u00020,2\u0006\u0010A\u001a\u00020\u0006H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0002*\u00020\u00012\u0006\u0010A\u001a\u00020,H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0007*\u00020\u00062\u0006\u0010A\u001a\u00020,H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0002*\u00020'2\u0006\u0010A\u001a\u00020,H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0002*\u00020,2\u0006\u0010A\u001a\u00020,H\u0086\u0084\u0004\u001a\u000e\u0010B\u001a\u00020\u0002*\u00020\u0002H\u0086\u0080\u0004\u001a\u000e\u0010B\u001a\u00020\u0007*\u00020\u0007H\u0086\u0080\u0004\u001a\u000e\u0010B\u001a\u00020\t*\u00020\tH\u0086\u0080\u0004\u001a\u0016\u0010C\u001a\u00020\u0002*\u00020\u00022\u0006\u0010C\u001a\u00020\u0001H\u0086\u0084\u0004\u001a\u0016\u0010C\u001a\u00020\u0007*\u00020\u00072\u0006\u0010C\u001a\u00020\u0006H\u0086\u0084\u0004\u001a\u0016\u0010C\u001a\u00020\t*\u00020\t2\u0006\u0010C\u001a\u00020\u0001H\u0086\u0084\u0004\u001a\u0015\u0010D\u001a\u0004\u0018\u00010'*\u00020\u0001H\u0080\u0080\u0004¢\u0006\u0002\u0010E\u001a\u0015\u0010D\u001a\u0004\u0018\u00010'*\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\u0010F\u001a\u0015\u0010D\u001a\u0004\u0018\u00010'*\u00020,H\u0080\u0080\u0004¢\u0006\u0002\u0010G\u001a\u0015\u0010D\u001a\u0004\u0018\u00010'*\u00020.H\u0080\u0080\u0004¢\u0006\u0002\u0010H\u001a\u0015\u0010D\u001a\u0004\u0018\u00010'*\u000208H\u0080\u0080\u0004¢\u0006\u0002\u0010I\u001a\u0015\u0010J\u001a\u0004\u0018\u00010\u0001*\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\u0010K\u001a\u0015\u0010J\u001a\u0004\u0018\u00010\u0001*\u00020.H\u0080\u0080\u0004¢\u0006\u0002\u0010L\u001a\u0015\u0010J\u001a\u0004\u0018\u00010\u0001*\u000208H\u0080\u0080\u0004¢\u0006\u0002\u0010M\u001a\u0015\u0010N\u001a\u0004\u0018\u00010\u0006*\u00020.H\u0080\u0080\u0004¢\u0006\u0002\u0010O\u001a\u0015\u0010N\u001a\u0004\u0018\u00010\u0006*\u000208H\u0080\u0080\u0004¢\u0006\u0002\u0010P\u001a\u0015\u0010Q\u001a\u0004\u0018\u00010,*\u00020\u0001H\u0080\u0080\u0004¢\u0006\u0002\u0010R\u001a\u0015\u0010Q\u001a\u0004\u0018\u00010,*\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\u0010S\u001a\u0015\u0010Q\u001a\u0004\u0018\u00010,*\u00020.H\u0080\u0080\u0004¢\u0006\u0002\u0010T\u001a\u0015\u0010Q\u001a\u0004\u0018\u00010,*\u000208H\u0080\u0080\u0004¢\u0006\u0002\u0010U\u001a\u0016\u0010V\u001a\u00020\u0011*\u00020\u00012\u0006\u0010A\u001a\u00020'H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0014*\u00020\u00062\u0006\u0010A\u001a\u00020'H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0011*\u00020'2\u0006\u0010A\u001a\u00020'H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0011*\u00020,2\u0006\u0010A\u001a\u00020'H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0015*\u00020\b2\u0006\u0010A\u001a\u00020\bH\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0011*\u00020\u00012\u0006\u0010A\u001a\u00020\u0001H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0014*\u00020\u00062\u0006\u0010A\u001a\u00020\u0001H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0011*\u00020'2\u0006\u0010A\u001a\u00020\u0001H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0011*\u00020,2\u0006\u0010A\u001a\u00020\u0001H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0014*\u00020\u00012\u0006\u0010A\u001a\u00020\u0006H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0014*\u00020\u00062\u0006\u0010A\u001a\u00020\u0006H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0014*\u00020'2\u0006\u0010A\u001a\u00020\u0006H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0014*\u00020,2\u0006\u0010A\u001a\u00020\u0006H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0011*\u00020\u00012\u0006\u0010A\u001a\u00020,H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0014*\u00020\u00062\u0006\u0010A\u001a\u00020,H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0011*\u00020'2\u0006\u0010A\u001a\u00020,H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0011*\u00020,2\u0006\u0010A\u001a\u00020,H\u0086\u0084\u0004\u001a+\u0010W\u001a\u0002HX\"\u000e\b\u0000\u0010X*\b\u0012\u0004\u0012\u0002HX0Y*\u0002HX2\u0006\u0010Z\u001a\u0002HXH\u0086\u0080\u0004¢\u0006\u0002\u0010[\u001a\u0016\u0010W\u001a\u00020'*\u00020'2\u0006\u0010Z\u001a\u00020'H\u0086\u0080\u0004\u001a\u0016\u0010W\u001a\u00020,*\u00020,2\u0006\u0010Z\u001a\u00020,H\u0086\u0080\u0004\u001a\u0016\u0010W\u001a\u00020\u0001*\u00020\u00012\u0006\u0010Z\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0016\u0010W\u001a\u00020\u0006*\u00020\u00062\u0006\u0010Z\u001a\u00020\u0006H\u0086\u0080\u0004\u001a\u0016\u0010W\u001a\u000208*\u0002082\u0006\u0010Z\u001a\u000208H\u0086\u0080\u0004\u001a\u0016\u0010W\u001a\u00020.*\u00020.2\u0006\u0010Z\u001a\u00020.H\u0086\u0080\u0004\u001a+\u0010\\\u001a\u0002HX\"\u000e\b\u0000\u0010X*\b\u0012\u0004\u0012\u0002HX0Y*\u0002HX2\u0006\u0010]\u001a\u0002HXH\u0086\u0080\u0004¢\u0006\u0002\u0010[\u001a\u0016\u0010\\\u001a\u00020'*\u00020'2\u0006\u0010]\u001a\u00020'H\u0086\u0080\u0004\u001a\u0016\u0010\\\u001a\u00020,*\u00020,2\u0006\u0010]\u001a\u00020,H\u0086\u0080\u0004\u001a\u0016\u0010\\\u001a\u00020\u0001*\u00020\u00012\u0006\u0010]\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0016\u0010\\\u001a\u00020\u0006*\u00020\u00062\u0006\u0010]\u001a\u00020\u0006H\u0086\u0080\u0004\u001a\u0016\u0010\\\u001a\u000208*\u0002082\u0006\u0010]\u001a\u000208H\u0086\u0080\u0004\u001a\u0016\u0010\\\u001a\u00020.*\u00020.2\u0006\u0010]\u001a\u00020.H\u0086\u0080\u0004\u001a7\u0010^\u001a\u0002HX\"\u000e\b\u0000\u0010X*\b\u0012\u0004\u0012\u0002HX0Y*\u0002HX2\b\u0010Z\u001a\u0004\u0018\u0001HX2\b\u0010]\u001a\u0004\u0018\u0001HXH\u0086\u0080\u0004¢\u0006\u0002\u0010_\u001a\u001e\u0010^\u001a\u00020'*\u00020'2\u0006\u0010Z\u001a\u00020'2\u0006\u0010]\u001a\u00020'H\u0086\u0080\u0004\u001a\u001e\u0010^\u001a\u00020,*\u00020,2\u0006\u0010Z\u001a\u00020,2\u0006\u0010]\u001a\u00020,H\u0086\u0080\u0004\u001a\u001e\u0010^\u001a\u00020\u0001*\u00020\u00012\u0006\u0010Z\u001a\u00020\u00012\u0006\u0010]\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u001e\u0010^\u001a\u00020\u0006*\u00020\u00062\u0006\u0010Z\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u0006H\u0086\u0080\u0004\u001a\u001e\u0010^\u001a\u000208*\u0002082\u0006\u0010Z\u001a\u0002082\u0006\u0010]\u001a\u000208H\u0086\u0080\u0004\u001a\u001e\u0010^\u001a\u00020.*\u00020.2\u0006\u0010Z\u001a\u00020.2\u0006\u0010]\u001a\u00020.H\u0086\u0080\u0004\u001a?\u0010^\u001a\u0002HX\"\u000e\b\u0000\u0010X*\b\u0012\u0004\u0012\u0002HX0Y*\u0002HX2\f\u0010`\u001a\b\u0012\u0004\u0012\u0002HX0aH\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(c¢\u0006\u0002\u0010b\u001a1\u0010^\u001a\u0002HX\"\u000e\b\u0000\u0010X*\b\u0012\u0004\u0012\u0002HX0Y*\u0002HX2\f\u0010`\u001a\b\u0012\u0004\u0012\u0002HX0%H\u0086\u0080\u0004¢\u0006\u0002\u0010d\u001a\u001c\u0010^\u001a\u00020\u0001*\u00020\u00012\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00010%H\u0086\u0080\u0004\u001a\u001c\u0010^\u001a\u00020\u0006*\u00020\u00062\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00060%H\u0086\u0080\u0004¨\u0006e"}, m4988d2 = {"first", BuildConfig.f24315FLAVOR, "Lkotlin/ranges/IntProgression;", "Lkotlin/SinceKotlin;", "version", "1.7", BuildConfig.f24315FLAVOR, "Lkotlin/ranges/LongProgression;", BuildConfig.f24315FLAVOR, "Lkotlin/ranges/CharProgression;", "firstOrNull", "(Lkotlin/ranges/IntProgression;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongProgression;)Ljava/lang/Long;", "(Lkotlin/ranges/CharProgression;)Ljava/lang/Character;", "last", "lastOrNull", "random", "Lkotlin/ranges/IntRange;", "1.3", "Lkotlin/internal/InlineOnly;", "Lkotlin/ranges/LongRange;", "Lkotlin/ranges/CharRange;", "Lkotlin/random/Random;", "randomOrNull", "(Lkotlin/ranges/IntRange;)Ljava/lang/Integer;", "1.4", "(Lkotlin/ranges/LongRange;)Ljava/lang/Long;", "(Lkotlin/ranges/CharRange;)Ljava/lang/Character;", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)Ljava/lang/Long;", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)Ljava/lang/Character;", "contains", BuildConfig.f24315FLAVOR, "element", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", "Lkotlin/ranges/ClosedRange;", "value", BuildConfig.f24315FLAVOR, "intRangeContains", "Lkotlin/jvm/JvmName;", "name", "longRangeContains", BuildConfig.f24315FLAVOR, "shortRangeContains", BuildConfig.f24315FLAVOR, "doubleRangeContains", "Lkotlin/Deprecated;", "message", "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "errorSince", "hiddenSince", "1.5", BuildConfig.f24315FLAVOR, "floatRangeContains", "Lkotlin/ranges/OpenEndRange;", "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/ExperimentalStdlibApi;", "byteRangeContains", "downTo", "to", "reversed", "step", "toByteExactOrNull", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "toIntExactOrNull", "(J)Ljava/lang/Integer;", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "until", "coerceAtLeast", "T", BuildConfig.f24315FLAVOR, "minimumValue", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "coerceAtMost", "maximumValue", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "1.1", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/ranges/RangesKt")
@SourceDebugExtension(m6344value = {"SMAP\n_Ranges.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Ranges.kt\nkotlin/ranges/RangesKt___RangesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1573:1\n1#2:1574\n*E\n"})
/* loaded from: classes.dex */
public class RangesKt___RangesKt extends RangesKt__RangesKt {
    @Deprecated(m4972message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @InterfaceC1231JvmName(m6260name = "byteRangeContains")
    public static final /* synthetic */ boolean byteRangeContains(ClosedRange closedRange, double d) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(d);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final byte coerceAtLeast(byte b, byte b2) {
        return b < b2 ? b2 : b;
    }

    public static final byte coerceAtMost(byte b, byte b2) {
        return b > b2 ? b2 : b;
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t, T t2, T t3) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        if (t2 == null || t3 == null) {
            if (t2 != null && t.compareTo(t2) < 0) {
                return t2;
            }
            if (t3 != null && t.compareTo(t3) > 0) {
                return t3;
            }
        } else {
            if (t2.compareTo(t3) > 0) {
                throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t3 + " is less than minimum " + t2 + '.');
            }
            if (t.compareTo(t2) < 0) {
                return t2;
            }
            if (t.compareTo(t3) > 0) {
                return t3;
            }
        }
        return t;
    }

    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    private static final boolean contains(IntRange intRange, Integer num) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        return num != null && intRange.contains(num.intValue());
    }

    @Deprecated(m4972message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @InterfaceC1231JvmName(m6260name = "doubleRangeContains")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange closedRange, byte b) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Double.valueOf(b));
    }

    /* renamed from: downTo */
    public static final IntProgression m6471downTo(int i, byte b) {
        return IntProgression.INSTANCE.fromClosedRange(i, b, -1);
    }

    @SinceKotlin(m5061version = "1.7")
    /* renamed from: first */
    public static final int m6485first(IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        if (!intProgression.mo6445isEmpty()) {
            return intProgression.getFirst();
        }
        throw new NoSuchElementException("Progression " + intProgression + " is empty.");
    }

    @SinceKotlin(m5061version = "1.7")
    public static final Integer firstOrNull(IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        if (intProgression.mo6445isEmpty()) {
            return null;
        }
        return Integer.valueOf(intProgression.getFirst());
    }

    @Deprecated(m4972message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @InterfaceC1231JvmName(m6260name = "floatRangeContains")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange closedRange, byte b) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Float.valueOf(b));
    }

    @InterfaceC1231JvmName(m6260name = "intRangeContains")
    public static final boolean intRangeContains(ClosedRange<Integer> closedRange, byte b) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Integer.valueOf(b));
    }

    @SinceKotlin(m5061version = "1.7")
    /* renamed from: last */
    public static final int m6488last(IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        if (!intProgression.mo6445isEmpty()) {
            return intProgression.getLast();
        }
        throw new NoSuchElementException("Progression " + intProgression + " is empty.");
    }

    @SinceKotlin(m5061version = "1.7")
    public static final Integer lastOrNull(IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        if (intProgression.mo6445isEmpty()) {
            return null;
        }
        return Integer.valueOf(intProgression.getLast());
    }

    @InterfaceC1231JvmName(m6260name = "longRangeContains")
    public static final boolean longRangeContains(ClosedRange<Long> closedRange, byte b) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Long.valueOf(b));
    }

    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    /* renamed from: random */
    private static final int m6492random(IntRange intRange) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        return m6493random(intRange, AbstractC1241Random.INSTANCE);
    }

    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    private static final Integer randomOrNull(IntRange intRange) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        return randomOrNull(intRange, AbstractC1241Random.INSTANCE);
    }

    public static final IntProgression reversed(IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        return IntProgression.INSTANCE.fromClosedRange(intProgression.getLast(), intProgression.getFirst(), -intProgression.getStep());
    }

    @InterfaceC1231JvmName(m6260name = "shortRangeContains")
    public static final boolean shortRangeContains(ClosedRange<Short> closedRange, byte b) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Short.valueOf(b));
    }

    /* renamed from: step */
    public static IntProgression m6497step(IntProgression intProgression, int i) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        RangesKt__RangesKt.checkStepIsPositive(i > 0, Integer.valueOf(i));
        IntProgression.Companion companion = IntProgression.INSTANCE;
        int first = intProgression.getFirst();
        int iM6454getLast = intProgression.getLast();
        if (intProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.fromClosedRange(first, iM6454getLast, i);
    }

    public static final Byte toByteExactOrNull(int i) {
        if (-128 > i || i >= 128) {
            return null;
        }
        return Byte.valueOf((byte) i);
    }

    public static final Integer toIntExactOrNull(long j) {
        if (-2147483648L > j || j >= 2147483648L) {
            return null;
        }
        return Integer.valueOf((int) j);
    }

    public static final Long toLongExactOrNull(double d) {
        if (-9.223372036854776E18d > d || d > 9.223372036854776E18d) {
            return null;
        }
        return Long.valueOf((long) d);
    }

    public static final Short toShortExactOrNull(int i) {
        if (-32768 > i || i >= 32768) {
            return null;
        }
        return Short.valueOf((short) i);
    }

    /* renamed from: until */
    public static final IntRange m6503until(int i, byte b) {
        return new IntRange(i, b - 1);
    }

    @Deprecated(m4972message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @InterfaceC1231JvmName(m6260name = "byteRangeContains")
    public static final /* synthetic */ boolean byteRangeContains(ClosedRange closedRange, float f) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(f);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final double coerceAtLeast(double d, double d2) {
        return d < d2 ? d2 : d;
    }

    public static final double coerceAtMost(double d, double d2) {
        return d > d2 ? d2 : d;
    }

    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    private static final boolean contains(LongRange longRange, Long l) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        return l != null && longRange.contains(l.longValue());
    }

    @InterfaceC1231JvmName(m6260name = "doubleRangeContains")
    public static final boolean doubleRangeContains(ClosedRange<Double> closedRange, float f) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Double.valueOf(f));
    }

    /* renamed from: downTo */
    public static final LongProgression m6479downTo(long j, byte b) {
        return LongProgression.INSTANCE.fromClosedRange(j, b, -1L);
    }

    @SinceKotlin(m5061version = "1.7")
    public static final Long firstOrNull(LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, "<this>");
        if (longProgression.mo6445isEmpty()) {
            return null;
        }
        return Long.valueOf(longProgression.getFirst());
    }

    @InterfaceC1231JvmName(m6260name = "floatRangeContains")
    public static final boolean floatRangeContains(ClosedRange<Float> closedRange, double d) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Float.valueOf((float) d));
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InterfaceC1231JvmName(m6260name = "intRangeContains")
    public static final boolean intRangeContains(OpenEndRange<Integer> openEndRange, byte b) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Integer.valueOf(b));
    }

    @SinceKotlin(m5061version = "1.7")
    public static final Long lastOrNull(LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, "<this>");
        if (longProgression.mo6445isEmpty()) {
            return null;
        }
        return Long.valueOf(longProgression.getLast());
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InterfaceC1231JvmName(m6260name = "longRangeContains")
    public static final boolean longRangeContains(OpenEndRange<Long> openEndRange, byte b) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Long.valueOf(b));
    }

    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    /* renamed from: random */
    private static final long m6494random(LongRange longRange) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        return m6495random(longRange, AbstractC1241Random.INSTANCE);
    }

    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    private static final Long randomOrNull(LongRange longRange) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        return randomOrNull(longRange, AbstractC1241Random.INSTANCE);
    }

    public static final LongProgression reversed(LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, "<this>");
        return LongProgression.INSTANCE.fromClosedRange(longProgression.getLast(), longProgression.getFirst(), -longProgression.getStep());
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InterfaceC1231JvmName(m6260name = "shortRangeContains")
    public static final boolean shortRangeContains(OpenEndRange<Short> openEndRange, byte b) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Short.valueOf(b));
    }

    public static final Byte toByteExactOrNull(long j) {
        if (-128 > j || j >= 128) {
            return null;
        }
        return Byte.valueOf((byte) j);
    }

    public static final Integer toIntExactOrNull(double d) {
        if (-2.147483648E9d > d || d > 2.147483647E9d) {
            return null;
        }
        return Integer.valueOf((int) d);
    }

    public static final Long toLongExactOrNull(float f) {
        if (-9.223372E18f > f || f > 9.223372E18f) {
            return null;
        }
        return Long.valueOf((long) f);
    }

    public static final Short toShortExactOrNull(long j) {
        if (-32768 > j || j >= 32768) {
            return null;
        }
        return Short.valueOf((short) j);
    }

    /* renamed from: until */
    public static final LongRange m6511until(long j, byte b) {
        return new LongRange(j, b - 1);
    }

    @InterfaceC1231JvmName(m6260name = "byteRangeContains")
    public static final boolean byteRangeContains(ClosedRange<Byte> closedRange, int i) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(i);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final float coerceAtLeast(float f, float f2) {
        return f < f2 ? f2 : f;
    }

    public static final float coerceAtMost(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    private static final boolean contains(CharRange charRange, Character ch) {
        Intrinsics.checkNotNullParameter(charRange, "<this>");
        return ch != null && charRange.contains(ch.charValue());
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InterfaceC1231JvmName(m6260name = "doubleRangeContains")
    public static final boolean doubleRangeContains(OpenEndRange<Double> openEndRange, float f) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Double.valueOf(f));
    }

    /* renamed from: downTo */
    public static final IntProgression m6468downTo(byte b, byte b2) {
        return IntProgression.INSTANCE.fromClosedRange(b, b2, -1);
    }

    @SinceKotlin(m5061version = "1.7")
    public static final Character firstOrNull(CharProgression charProgression) {
        Intrinsics.checkNotNullParameter(charProgression, "<this>");
        if (charProgression.mo6445isEmpty()) {
            return null;
        }
        return Character.valueOf(charProgression.getFirst());
    }

    @Deprecated(m4972message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @InterfaceC1231JvmName(m6260name = "floatRangeContains")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange closedRange, int i) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Float.valueOf(i));
    }

    @Deprecated(m4972message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @InterfaceC1231JvmName(m6260name = "intRangeContains")
    public static final /* synthetic */ boolean intRangeContains(ClosedRange closedRange, double d) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Integer intExactOrNull = toIntExactOrNull(d);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    @SinceKotlin(m5061version = "1.7")
    public static final Character lastOrNull(CharProgression charProgression) {
        Intrinsics.checkNotNullParameter(charProgression, "<this>");
        if (charProgression.mo6445isEmpty()) {
            return null;
        }
        return Character.valueOf(charProgression.getLast());
    }

    @Deprecated(m4972message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @InterfaceC1231JvmName(m6260name = "longRangeContains")
    public static final /* synthetic */ boolean longRangeContains(ClosedRange closedRange, double d) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Long longExactOrNull = toLongExactOrNull(d);
        if (longExactOrNull != null) {
            return closedRange.contains(longExactOrNull);
        }
        return false;
    }

    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    /* renamed from: random */
    private static final char m6490random(CharRange charRange) {
        Intrinsics.checkNotNullParameter(charRange, "<this>");
        return m6491random(charRange, AbstractC1241Random.INSTANCE);
    }

    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    private static final Character randomOrNull(CharRange charRange) {
        Intrinsics.checkNotNullParameter(charRange, "<this>");
        return randomOrNull(charRange, AbstractC1241Random.INSTANCE);
    }

    public static final CharProgression reversed(CharProgression charProgression) {
        Intrinsics.checkNotNullParameter(charProgression, "<this>");
        return CharProgression.INSTANCE.fromClosedRange(charProgression.getLast(), charProgression.getFirst(), -charProgression.getStep());
    }

    @Deprecated(m4972message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @InterfaceC1231JvmName(m6260name = "shortRangeContains")
    public static final /* synthetic */ boolean shortRangeContains(ClosedRange closedRange, double d) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Short shortExactOrNull = toShortExactOrNull(d);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    /* renamed from: step */
    public static final LongProgression m6498step(LongProgression longProgression, long j) {
        Intrinsics.checkNotNullParameter(longProgression, "<this>");
        RangesKt__RangesKt.checkStepIsPositive(j > 0, Long.valueOf(j));
        LongProgression.Companion companion = LongProgression.INSTANCE;
        long first = longProgression.getFirst();
        long jM6458getLast = longProgression.getLast();
        if (longProgression.getStep() <= 0) {
            j = -j;
        }
        return companion.fromClosedRange(first, jM6458getLast, j);
    }

    public static final Byte toByteExactOrNull(short s) {
        if (-128 > s || s >= 128) {
            return null;
        }
        return Byte.valueOf((byte) s);
    }

    public static final Integer toIntExactOrNull(float f) {
        if (-2.14748365E9f > f || f > 2.14748365E9f) {
            return null;
        }
        return Integer.valueOf((int) f);
    }

    public static final Short toShortExactOrNull(double d) {
        if (-32768.0d > d || d > 32767.0d) {
            return null;
        }
        return Short.valueOf((short) d);
    }

    /* renamed from: until */
    public static final IntRange m6500until(byte b, byte b2) {
        return new IntRange(b, b2 - 1);
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InterfaceC1231JvmName(m6260name = "byteRangeContains")
    public static final boolean byteRangeContains(OpenEndRange<Byte> openEndRange, int i) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(i);
        if (byteExactOrNull != null) {
            return openEndRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static int coerceAtLeast(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static int coerceAtMost(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    @InlineOnly
    private static final boolean contains(IntRange intRange, byte b) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        return intRangeContains((ClosedRange<Integer>) intRange, b);
    }

    @Deprecated(m4972message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @InterfaceC1231JvmName(m6260name = "doubleRangeContains")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange closedRange, int i) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Double.valueOf(i));
    }

    /* renamed from: downTo */
    public static final IntProgression m6474downTo(short s, byte b) {
        return IntProgression.INSTANCE.fromClosedRange(s, b, -1);
    }

    @SinceKotlin(m5061version = "1.7")
    /* renamed from: first */
    public static final long m6486first(LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, "<this>");
        if (!longProgression.mo6445isEmpty()) {
            return longProgression.getFirst();
        }
        throw new NoSuchElementException("Progression " + longProgression + " is empty.");
    }

    @Deprecated(m4972message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @InterfaceC1231JvmName(m6260name = "floatRangeContains")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange closedRange, long j) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Float.valueOf(j));
    }

    @Deprecated(m4972message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @InterfaceC1231JvmName(m6260name = "intRangeContains")
    public static final /* synthetic */ boolean intRangeContains(ClosedRange closedRange, float f) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Integer intExactOrNull = toIntExactOrNull(f);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    @SinceKotlin(m5061version = "1.7")
    /* renamed from: last */
    public static final long m6489last(LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, "<this>");
        if (!longProgression.mo6445isEmpty()) {
            return longProgression.getLast();
        }
        throw new NoSuchElementException("Progression " + longProgression + " is empty.");
    }

    @Deprecated(m4972message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @InterfaceC1231JvmName(m6260name = "longRangeContains")
    public static final /* synthetic */ boolean longRangeContains(ClosedRange closedRange, float f) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Long longExactOrNull = toLongExactOrNull(f);
        if (longExactOrNull != null) {
            return closedRange.contains(longExactOrNull);
        }
        return false;
    }

    @SinceKotlin(m5061version = "1.3")
    /* renamed from: random */
    public static final int m6493random(IntRange intRange, AbstractC1241Random random) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return RandomKt.m6441nextInt(random, intRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @SinceKotlin(m5061version = "1.4")
    public static final Integer randomOrNull(IntRange intRange, AbstractC1241Random random) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (intRange.mo6445isEmpty()) {
            return null;
        }
        return Integer.valueOf(RandomKt.m6441nextInt(random, intRange));
    }

    @Deprecated(m4972message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @InterfaceC1231JvmName(m6260name = "shortRangeContains")
    public static final /* synthetic */ boolean shortRangeContains(ClosedRange closedRange, float f) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Short shortExactOrNull = toShortExactOrNull(f);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    public static final Byte toByteExactOrNull(double d) {
        if (-128.0d > d || d > 127.0d) {
            return null;
        }
        return Byte.valueOf((byte) d);
    }

    public static final Short toShortExactOrNull(float f) {
        if (-32768.0f > f || f > 32767.0f) {
            return null;
        }
        return Short.valueOf((short) f);
    }

    /* renamed from: until */
    public static final IntRange m6506until(short s, byte b) {
        return new IntRange(s, b - 1);
    }

    @InterfaceC1231JvmName(m6260name = "byteRangeContains")
    public static final boolean byteRangeContains(ClosedRange<Byte> closedRange, long j) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(j);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static long coerceAtLeast(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static long coerceAtMost(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    @InlineOnly
    private static final boolean contains(LongRange longRange, byte b) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        return longRangeContains((ClosedRange<Long>) longRange, b);
    }

    @Deprecated(m4972message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @InterfaceC1231JvmName(m6260name = "doubleRangeContains")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange closedRange, long j) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Double.valueOf(j));
    }

    /* renamed from: downTo */
    public static final CharProgression m6467downTo(char c, char c2) {
        return CharProgression.INSTANCE.fromClosedRange(c, c2, -1);
    }

    @Deprecated(m4972message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @InterfaceC1231JvmName(m6260name = "floatRangeContains")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange closedRange, short s) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Float.valueOf(s));
    }

    @InterfaceC1231JvmName(m6260name = "intRangeContains")
    public static final boolean intRangeContains(ClosedRange<Integer> closedRange, long j) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Integer intExactOrNull = toIntExactOrNull(j);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    @InterfaceC1231JvmName(m6260name = "longRangeContains")
    public static final boolean longRangeContains(ClosedRange<Long> closedRange, int i) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Long.valueOf(i));
    }

    @InterfaceC1231JvmName(m6260name = "shortRangeContains")
    public static final boolean shortRangeContains(ClosedRange<Short> closedRange, int i) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Short shortExactOrNull = toShortExactOrNull(i);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    /* renamed from: step */
    public static final CharProgression m6496step(CharProgression charProgression, int i) {
        Intrinsics.checkNotNullParameter(charProgression, "<this>");
        RangesKt__RangesKt.checkStepIsPositive(i > 0, Integer.valueOf(i));
        CharProgression.Companion companion = CharProgression.INSTANCE;
        char first = charProgression.getFirst();
        char cM6443getLast = charProgression.getLast();
        if (charProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.fromClosedRange(first, cM6443getLast, i);
    }

    public static final Byte toByteExactOrNull(float f) {
        if (-128.0f > f || f > 127.0f) {
            return null;
        }
        return Byte.valueOf((byte) f);
    }

    /* renamed from: until */
    public static final CharRange m6499until(char c, char c2) {
        if (c2 <= 0) {
            return CharRange.INSTANCE.getEMPTY();
        }
        return new CharRange(c, (char) (c2 - 1));
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InterfaceC1231JvmName(m6260name = "byteRangeContains")
    public static final boolean byteRangeContains(OpenEndRange<Byte> openEndRange, long j) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(j);
        if (byteExactOrNull != null) {
            return openEndRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final short coerceAtLeast(short s, short s2) {
        return s < s2 ? s2 : s;
    }

    public static final short coerceAtMost(short s, short s2) {
        return s > s2 ? s2 : s;
    }

    @InlineOnly
    private static final boolean contains(LongRange longRange, int i) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        return longRangeContains((ClosedRange<Long>) longRange, i);
    }

    @Deprecated(m4972message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @InterfaceC1231JvmName(m6260name = "doubleRangeContains")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange closedRange, short s) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Double.valueOf(s));
    }

    /* renamed from: downTo */
    public static IntProgression m6472downTo(int i, int i2) {
        return IntProgression.INSTANCE.fromClosedRange(i, i2, -1);
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InterfaceC1231JvmName(m6260name = "intRangeContains")
    public static final boolean intRangeContains(OpenEndRange<Integer> openEndRange, long j) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Integer intExactOrNull = toIntExactOrNull(j);
        if (intExactOrNull != null) {
            return openEndRange.contains(intExactOrNull);
        }
        return false;
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InterfaceC1231JvmName(m6260name = "longRangeContains")
    public static final boolean longRangeContains(OpenEndRange<Long> openEndRange, int i) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Long.valueOf(i));
    }

    @SinceKotlin(m5061version = "1.3")
    /* renamed from: random */
    public static final long m6495random(LongRange longRange, AbstractC1241Random random) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return RandomKt.nextLong(random, longRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @SinceKotlin(m5061version = "1.4")
    public static final Long randomOrNull(LongRange longRange, AbstractC1241Random random) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (longRange.mo6445isEmpty()) {
            return null;
        }
        return Long.valueOf(RandomKt.nextLong(random, longRange));
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InterfaceC1231JvmName(m6260name = "shortRangeContains")
    public static final boolean shortRangeContains(OpenEndRange<Short> openEndRange, int i) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Short shortExactOrNull = toShortExactOrNull(i);
        if (shortExactOrNull != null) {
            return openEndRange.contains(shortExactOrNull);
        }
        return false;
    }

    @InterfaceC1231JvmName(m6260name = "byteRangeContains")
    public static final boolean byteRangeContains(ClosedRange<Byte> closedRange, short s) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(s);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final <T extends Comparable<? super T>> T coerceAtLeast(T t, T minimumValue) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(minimumValue, "minimumValue");
        return t.compareTo(minimumValue) < 0 ? minimumValue : t;
    }

    public static final <T extends Comparable<? super T>> T coerceAtMost(T t, T maximumValue) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(maximumValue, "maximumValue");
        return t.compareTo(maximumValue) > 0 ? maximumValue : t;
    }

    public static final byte coerceIn(byte b, byte b2, byte b3) {
        if (b2 <= b3) {
            return b < b2 ? b2 : b > b3 ? b3 : b;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) b3) + " is less than minimum " + ((int) b2) + '.');
    }

    @InlineOnly
    private static final boolean contains(IntRange intRange, long j) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        return intRangeContains((ClosedRange<Integer>) intRange, j);
    }

    /* renamed from: downTo */
    public static final LongProgression m6480downTo(long j, int i) {
        return LongProgression.INSTANCE.fromClosedRange(j, i, -1L);
    }

    @SinceKotlin(m5061version = "1.7")
    /* renamed from: first */
    public static final char m6484first(CharProgression charProgression) {
        Intrinsics.checkNotNullParameter(charProgression, "<this>");
        if (!charProgression.mo6445isEmpty()) {
            return charProgression.getFirst();
        }
        throw new NoSuchElementException("Progression " + charProgression + " is empty.");
    }

    @InterfaceC1231JvmName(m6260name = "intRangeContains")
    public static final boolean intRangeContains(ClosedRange<Integer> closedRange, short s) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Integer.valueOf(s));
    }

    @SinceKotlin(m5061version = "1.7")
    /* renamed from: last */
    public static final char m6487last(CharProgression charProgression) {
        Intrinsics.checkNotNullParameter(charProgression, "<this>");
        if (!charProgression.mo6445isEmpty()) {
            return charProgression.getLast();
        }
        throw new NoSuchElementException("Progression " + charProgression + " is empty.");
    }

    @InterfaceC1231JvmName(m6260name = "longRangeContains")
    public static final boolean longRangeContains(ClosedRange<Long> closedRange, short s) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Long.valueOf(s));
    }

    @InterfaceC1231JvmName(m6260name = "shortRangeContains")
    public static final boolean shortRangeContains(ClosedRange<Short> closedRange, long j) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Short shortExactOrNull = toShortExactOrNull(j);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    /* renamed from: until */
    public static IntRange m6504until(int i, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return IntRange.INSTANCE.getEMPTY();
        }
        return new IntRange(i, i2 - 1);
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InterfaceC1231JvmName(m6260name = "byteRangeContains")
    public static final boolean byteRangeContains(OpenEndRange<Byte> openEndRange, short s) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(s);
        if (byteExactOrNull != null) {
            return openEndRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final short coerceIn(short s, short s2, short s3) {
        if (s2 <= s3) {
            return s < s2 ? s2 : s > s3 ? s3 : s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) s3) + " is less than minimum " + ((int) s2) + '.');
    }

    @InlineOnly
    private static final boolean contains(IntRange intRange, short s) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        return intRangeContains((ClosedRange<Integer>) intRange, s);
    }

    /* renamed from: downTo */
    public static final IntProgression m6469downTo(byte b, int i) {
        return IntProgression.INSTANCE.fromClosedRange(b, i, -1);
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InterfaceC1231JvmName(m6260name = "intRangeContains")
    public static final boolean intRangeContains(OpenEndRange<Integer> openEndRange, short s) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Integer.valueOf(s));
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InterfaceC1231JvmName(m6260name = "longRangeContains")
    public static final boolean longRangeContains(OpenEndRange<Long> openEndRange, short s) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Long.valueOf(s));
    }

    @SinceKotlin(m5061version = "1.3")
    /* renamed from: random */
    public static final char m6491random(CharRange charRange, AbstractC1241Random random) {
        Intrinsics.checkNotNullParameter(charRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return (char) random.mo6438nextInt(charRange.getFirst(), charRange.getLast() + 1);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @SinceKotlin(m5061version = "1.4")
    public static final Character randomOrNull(CharRange charRange, AbstractC1241Random random) {
        Intrinsics.checkNotNullParameter(charRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (charRange.mo6445isEmpty()) {
            return null;
        }
        return Character.valueOf((char) random.mo6438nextInt(charRange.getFirst(), charRange.getLast() + 1));
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InterfaceC1231JvmName(m6260name = "shortRangeContains")
    public static final boolean shortRangeContains(OpenEndRange<Short> openEndRange, long j) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Short shortExactOrNull = toShortExactOrNull(j);
        if (shortExactOrNull != null) {
            return openEndRange.contains(shortExactOrNull);
        }
        return false;
    }

    public static int coerceIn(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    @InlineOnly
    private static final boolean contains(LongRange longRange, short s) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        return longRangeContains((ClosedRange<Long>) longRange, s);
    }

    /* renamed from: downTo */
    public static final IntProgression m6475downTo(short s, int i) {
        return IntProgression.INSTANCE.fromClosedRange(s, i, -1);
    }

    /* renamed from: until */
    public static final LongRange m6512until(long j, int i) {
        return new LongRange(j, i - 1);
    }

    public static long coerceIn(long j, long j2, long j3) {
        if (j2 <= j3) {
            return j < j2 ? j2 : j > j3 ? j3 : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j3 + " is less than minimum " + j2 + '.');
    }

    /* renamed from: downTo */
    public static final LongProgression m6478downTo(int i, long j) {
        return LongProgression.INSTANCE.fromClosedRange(i, j, -1L);
    }

    /* renamed from: until */
    public static final IntRange m6501until(byte b, int i) {
        if (i <= Integer.MIN_VALUE) {
            return IntRange.INSTANCE.getEMPTY();
        }
        return new IntRange(b, i - 1);
    }

    public static final float coerceIn(float f, float f2, float f3) {
        if (f2 <= f3) {
            return f < f2 ? f2 : f > f3 ? f3 : f;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f3 + " is less than minimum " + f2 + '.');
    }

    /* renamed from: downTo */
    public static final LongProgression m6481downTo(long j, long j2) {
        return LongProgression.INSTANCE.fromClosedRange(j, j2, -1L);
    }

    public static final double coerceIn(double d, double d2, double d3) {
        if (d2 <= d3) {
            return d < d2 ? d2 : d > d3 ? d3 : d;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d3 + " is less than minimum " + d2 + '.');
    }

    /* renamed from: downTo */
    public static final LongProgression m6477downTo(byte b, long j) {
        return LongProgression.INSTANCE.fromClosedRange(b, j, -1L);
    }

    /* renamed from: until */
    public static final IntRange m6507until(short s, int i) {
        if (i <= Integer.MIN_VALUE) {
            return IntRange.INSTANCE.getEMPTY();
        }
        return new IntRange(s, i - 1);
    }

    @SinceKotlin(m5061version = "1.1")
    public static final <T extends Comparable<? super T>> T coerceIn(T t, ClosedFloatingPointRange<T> range) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (!range.mo6445isEmpty()) {
            return (!range.lessThanOrEquals(t, range.getStart()) || range.lessThanOrEquals(range.getStart(), t)) ? (!range.lessThanOrEquals(range.getEndInclusive(), t) || range.lessThanOrEquals(t, range.getEndInclusive())) ? t : range.getEndInclusive() : range.getStart();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    /* renamed from: downTo */
    public static final LongProgression m6483downTo(short s, long j) {
        return LongProgression.INSTANCE.fromClosedRange(s, j, -1L);
    }

    /* renamed from: downTo */
    public static final IntProgression m6473downTo(int i, short s) {
        return IntProgression.INSTANCE.fromClosedRange(i, s, -1);
    }

    /* renamed from: until */
    public static final LongRange m6510until(int i, long j) {
        if (j <= Long.MIN_VALUE) {
            return LongRange.INSTANCE.getEMPTY();
        }
        return new LongRange(i, j - 1);
    }

    /* renamed from: downTo */
    public static final LongProgression m6482downTo(long j, short s) {
        return LongProgression.INSTANCE.fromClosedRange(j, s, -1L);
    }

    /* renamed from: downTo */
    public static final IntProgression m6470downTo(byte b, short s) {
        return IntProgression.INSTANCE.fromClosedRange(b, s, -1);
    }

    /* renamed from: until */
    public static final LongRange m6513until(long j, long j2) {
        if (j2 <= Long.MIN_VALUE) {
            return LongRange.INSTANCE.getEMPTY();
        }
        return new LongRange(j, j2 - 1);
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t, ClosedRange<T> range) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return (T) coerceIn((Comparable) t, (ClosedFloatingPointRange) range);
        }
        if (!range.mo6445isEmpty()) {
            return t.compareTo(range.getStart()) < 0 ? (T) range.getStart() : t.compareTo(range.getEndInclusive()) > 0 ? (T) range.getEndInclusive() : t;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    /* renamed from: downTo */
    public static final IntProgression m6476downTo(short s, short s2) {
        return IntProgression.INSTANCE.fromClosedRange(s, s2, -1);
    }

    /* renamed from: until */
    public static final LongRange m6509until(byte b, long j) {
        if (j <= Long.MIN_VALUE) {
            return LongRange.INSTANCE.getEMPTY();
        }
        return new LongRange(b, j - 1);
    }

    /* renamed from: until */
    public static final LongRange m6515until(short s, long j) {
        if (j <= Long.MIN_VALUE) {
            return LongRange.INSTANCE.getEMPTY();
        }
        return new LongRange(s, j - 1);
    }

    /* renamed from: until */
    public static final IntRange m6505until(int i, short s) {
        return new IntRange(i, s - 1);
    }

    public static final int coerceIn(int i, ClosedRange<Integer> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((Number) coerceIn(Integer.valueOf(i), (ClosedFloatingPointRange<Integer>) range)).intValue();
        }
        if (!range.mo6445isEmpty()) {
            return i < ((Number) range.getStart()).intValue() ? ((Number) range.getStart()).intValue() : i > ((Number) range.getEndInclusive()).intValue() ? ((Number) range.getEndInclusive()).intValue() : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    /* renamed from: until */
    public static final LongRange m6514until(long j, short s) {
        return new LongRange(j, s - 1);
    }

    /* renamed from: until */
    public static final IntRange m6502until(byte b, short s) {
        return new IntRange(b, s - 1);
    }

    /* renamed from: until */
    public static final IntRange m6508until(short s, short s2) {
        return new IntRange(s, s2 - 1);
    }

    public static long coerceIn(long j, ClosedRange<Long> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((Number) coerceIn(Long.valueOf(j), (ClosedFloatingPointRange<Long>) range)).longValue();
        }
        if (!range.mo6445isEmpty()) {
            return j < ((Number) range.getStart()).longValue() ? ((Number) range.getStart()).longValue() : j > ((Number) range.getEndInclusive()).longValue() ? ((Number) range.getEndInclusive()).longValue() : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }
}
