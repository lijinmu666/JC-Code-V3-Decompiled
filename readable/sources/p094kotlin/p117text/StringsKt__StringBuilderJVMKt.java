package p094kotlin.p117text;

import java.io.IOException;
import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecatedSinceKotlin;
import p094kotlin.IgnorableReturnValue;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\u001a4\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\bb\u0002\b\t\u001a4\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\bb\u0002\b\t\u001a<\u0010\u000b\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\bb\u0002\b\t\u001a<\u0010\u000b\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\nH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\bb\u0002\b\t\u001a(\u0010\u000e\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0087\u0080\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000fb\u0002\b\t\u001a&\u0010\u0010\u001a\u00020\u0011*\u00060\u0001j\u0002`\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0012H\u0087\u008a\u0004b\u0002\b\b\u001aD\u0010\u0013\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0016H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a4\u0010\u0018\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\f\u001a\u00020\rH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a<\u0010\u0019\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001aJ\u0010\u001a\u001a\u00020\u0011*\u00060\u0001j\u0002`\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\rH\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\b\u001aD\u0010\u001e\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001aD\u0010\u001e\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001aL\u0010 \u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001aL\u0010 \u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a6\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\"H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a<\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000e\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a4\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\rH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a4\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a4\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a4\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020#H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a4\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020$H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a4\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020%H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001aZ\u0010&\u001a\u00060'j\u0002`(*\u00060'j\u0002`(H\u0087\u0080\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4\u001ah\u0010&\u001a\u00060'j\u0002`(*\u00060'j\u0002`(2\b\u0010\u0003\u001a\u0004\u0018\u00010\u001fH\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060'j\u0002`(*\u00060'j\u0002`(2\u0006\u0010\u0003\u001a\u00020\u0012H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001aZ\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0087\u0080\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4\u001ah\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\"H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001ah\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u001fH\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001ah\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0016H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001ah\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u000106H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001an\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000e\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u001cH\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0012H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u000207H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\rH\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020#H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020$H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020%H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b¨\u00068"}, m4988d2 = {"append", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "value", BuildConfig.f24315FLAVOR, "Lkotlin/SinceKotlin;", "version", "1.9", "Lkotlin/internal/InlineOnly;", "Lkotlin/IgnorableReturnValue;", BuildConfig.f24315FLAVOR, "insert", "index", BuildConfig.f24315FLAVOR, "clear", "1.3", "set", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "setRange", "startIndex", "endIndex", BuildConfig.f24315FLAVOR, "1.4", "deleteAt", "deleteRange", "toCharArray", "destination", BuildConfig.f24315FLAVOR, "destinationOffset", "appendRange", BuildConfig.f24315FLAVOR, "insertRange", "appendLine", "Ljava/lang/StringBuffer;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "appendln", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "Lkotlin/Deprecated;", "message", "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "appendLine()", "imports", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "errorSince", "2.1", "appendLine(value)", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/text/StringsKt")
@SourceDebugExtension(m6344value = {"SMAP\nStringBuilderJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringBuilderJVM.kt\nkotlin/text/StringsKt__StringBuilderJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,437:1\n1#2:438\n*E\n"})
/* loaded from: classes.dex */
class StringsKt__StringBuilderJVMKt extends StringsKt__RegexExtensionsKt {
    @SinceKotlin(m5061version = "1.9")
    @IgnorableReturnValue
    @InlineOnly
    /* renamed from: append */
    private static final StringBuilder m6719append(StringBuilder sb, byte b) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append((int) b);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        return sb;
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb, StringBuffer stringBuffer) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append(stringBuffer);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        return sb;
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    @InlineOnly
    private static final StringBuilder appendRange(StringBuilder sb, char[] value, int i, int i2) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        sb.append(value, i, i2 - i);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        return sb;
    }

    @Deprecated(m4972message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    public static final Appendable appendln(Appendable appendable) throws IOException {
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        Appendable appendableAppend = appendable.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(appendableAppend, "append(...)");
        return appendableAppend;
    }

    @SinceKotlin(m5061version = "1.3")
    @IgnorableReturnValue
    /* renamed from: clear */
    public static final StringBuilder m6721clear(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.setLength(0);
        return sb;
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    @InlineOnly
    private static final StringBuilder deleteAt(StringBuilder sb, int i) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder sbDeleteCharAt = sb.deleteCharAt(i);
        Intrinsics.checkNotNullExpressionValue(sbDeleteCharAt, "deleteCharAt(...)");
        return sbDeleteCharAt;
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    @InlineOnly
    private static final StringBuilder deleteRange(StringBuilder sb, int i, int i2) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder sbDelete = sb.delete(i, i2);
        Intrinsics.checkNotNullExpressionValue(sbDelete, "delete(...)");
        return sbDelete;
    }

    @SinceKotlin(m5061version = "1.9")
    @IgnorableReturnValue
    @InlineOnly
    /* renamed from: insert */
    private static final StringBuilder m6722insert(StringBuilder sb, int i, byte b) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder sbInsert = sb.insert(i, (int) b);
        Intrinsics.checkNotNullExpressionValue(sbInsert, "insert(...)");
        return sbInsert;
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    @InlineOnly
    private static final StringBuilder insertRange(StringBuilder sb, int i, char[] value, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sbInsert = sb.insert(i, value, i2, i3 - i2);
        Intrinsics.checkNotNullExpressionValue(sbInsert, "insert(...)");
        return sbInsert;
    }

    @InlineOnly
    /* renamed from: set */
    private static final void m6724set(StringBuilder sb, int i, char c) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.setCharAt(i, c);
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    @InlineOnly
    private static final StringBuilder setRange(StringBuilder sb, int i, int i2, String value) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sbReplace = sb.replace(i, i2, value);
        Intrinsics.checkNotNullExpressionValue(sbReplace, "replace(...)");
        return sbReplace;
    }

    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    private static final void toCharArray(StringBuilder sb, char[] destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        sb.getChars(i2, i3, destination, i);
    }

    public static /* synthetic */ void toCharArray$default(StringBuilder sb, char[] destination, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = sb.length();
        }
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        sb.getChars(i2, i3, destination, i);
    }

    @SinceKotlin(m5061version = "1.9")
    @IgnorableReturnValue
    @InlineOnly
    /* renamed from: append */
    private static final StringBuilder m6720append(StringBuilder sb, short s) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append((int) s);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        return sb;
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb, StringBuilder sb2) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append((CharSequence) sb2);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        return sb;
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    @InlineOnly
    private static final StringBuilder appendRange(StringBuilder sb, CharSequence value, int i, int i2) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        sb.append(value, i, i2);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        return sb;
    }

    @Deprecated(m4972message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    @InlineOnly
    private static final Appendable appendln(Appendable appendable, CharSequence charSequence) throws IOException {
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        Appendable appendableAppend = appendable.append(charSequence);
        Intrinsics.checkNotNullExpressionValue(appendableAppend, "append(...)");
        return appendln(appendableAppend);
    }

    @SinceKotlin(m5061version = "1.9")
    @IgnorableReturnValue
    @InlineOnly
    /* renamed from: insert */
    private static final StringBuilder m6723insert(StringBuilder sb, int i, short s) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder sbInsert = sb.insert(i, (int) s);
        Intrinsics.checkNotNullExpressionValue(sbInsert, "insert(...)");
        return sbInsert;
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    @InlineOnly
    private static final StringBuilder insertRange(StringBuilder sb, int i, CharSequence value, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sbInsert = sb.insert(i, value, i2, i3);
        Intrinsics.checkNotNullExpressionValue(sbInsert, "insert(...)");
        return sbInsert;
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb, int i) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append(i);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        return sb;
    }

    @Deprecated(m4972message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    @InlineOnly
    private static final Appendable appendln(Appendable appendable, char c) throws IOException {
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        Appendable appendableAppend = appendable.append(c);
        Intrinsics.checkNotNullExpressionValue(appendableAppend, "append(...)");
        return appendln(appendableAppend);
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb, short s) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append((int) s);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        return sb;
    }

    @Deprecated(m4972message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    public static final StringBuilder appendln(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        return sb;
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb, byte b) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append((int) b);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        return sb;
    }

    @Deprecated(m4972message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb, StringBuffer stringBuffer) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append(stringBuffer);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        return appendln(sb);
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb, long j) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append(j);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        return sb;
    }

    @Deprecated(m4972message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append(charSequence);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        return appendln(sb);
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb, float f) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append(f);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        return sb;
    }

    @Deprecated(m4972message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb, String str) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append(str);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        return appendln(sb);
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb, double d) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append(d);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        return sb;
    }

    @Deprecated(m4972message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb, Object obj) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append(obj);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        return appendln(sb);
    }

    @Deprecated(m4972message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb, StringBuilder sb2) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append((CharSequence) sb2);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        return appendln(sb);
    }

    @Deprecated(m4972message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb, char[] value) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        sb.append(value);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        return appendln(sb);
    }

    @Deprecated(m4972message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb, char c) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append(c);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        return appendln(sb);
    }

    @Deprecated(m4972message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb, boolean z) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append(z);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        return appendln(sb);
    }

    @Deprecated(m4972message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb, int i) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append(i);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        return appendln(sb);
    }

    @Deprecated(m4972message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb, short s) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append((int) s);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        return appendln(sb);
    }

    @Deprecated(m4972message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb, byte b) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append((int) b);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        return appendln(sb);
    }

    @Deprecated(m4972message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb, long j) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append(j);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        return appendln(sb);
    }

    @Deprecated(m4972message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb, float f) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append(f);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        return appendln(sb);
    }

    @Deprecated(m4972message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder sb, double d) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.append(d);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        return appendln(sb);
    }
}
