package p094kotlin.p101io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.IgnorableReturnValue;
import p094kotlin.Metadata;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p101io.TextStreamsKt;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.Charsets;
import p094kotlin.sequences.Sequence;
import p094kotlin.sequences.SequencesKt;

@Metadata(m4987d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\u0002\b\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\u0002\b\u0005\u001a\"\u0010\b\u001a\u00020\t*\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000bH\u0086\u0080\u0004\u001a\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e*\u00020\u0002H\u0086\u0080\u0004\u001aG\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\u00020\u00022\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0012\u0012\u0004\u0012\u0002H\u00100\u000bH\u0087\u0088\bb\u0002\b\u0014ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0013\u001a\u0012\u0010\u0015\u001a\u00020\u0016*\u00020\fH\u0087\u0088\u0004b\u0002\b\u0005\u001a\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0012*\u00020\u0001H\u0086\u0080\u0004\u001a\u000e\u0010\u0018\u001a\u00020\f*\u00020\u0002H\u0086\u0080\u0004\u001a$\u0010\u0019\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\bb\u0002\b\u0014\u001a\u001c\u0010\u0018\u001a\u00020\f*\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0087\u0088\u0004b\u0002\b\u0005\u001a\u000e\u0010\u001f\u001a\u00020 *\u00020\u001cH\u0086\u0080\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, m4988d2 = {"buffered", "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", BuildConfig.f24315FLAVOR, "Lkotlin/internal/InlineOnly;", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "forEachLine", BuildConfig.f24315FLAVOR, "action", "Lkotlin/Function1;", BuildConfig.f24315FLAVOR, "readLines", BuildConfig.f24315FLAVOR, "useLines", "T", "block", "Lkotlin/sequences/Sequence;", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlin/IgnorableReturnValue;", "reader", "Ljava/io/StringReader;", "lineSequence", "readText", "copyTo", BuildConfig.f24315FLAVOR, "out", "Ljava/net/URL;", "charset", "Ljava/nio/charset/Charset;", "readBytes", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "TextStreamsKt")
@SourceDebugExtension(m6344value = {"SMAP\nReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,166:1\n66#1:167\n1#2:168\n1#2:171\n1505#3,2:169\n*S KotlinDebug\n*F\n+ 1 ReadWrite.kt\nkotlin/io/TextStreamsKt\n*L\n43#1:167\n43#1:168\n43#1:169,2\n*E\n"})
/* loaded from: classes.dex */
public final class TextStreamsKt {
    @InlineOnly
    private static final BufferedReader buffered(Reader reader, int i) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i);
    }

    public static /* synthetic */ BufferedReader buffered$default(Reader reader, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        Intrinsics.checkNotNullParameter(reader, "<this>");
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i);
    }

    @IgnorableReturnValue
    /* renamed from: copyTo */
    public static final long m6208copyTo(Reader reader, Writer out, int i) throws IOException {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        char[] cArr = new char[i];
        int i2 = reader.read(cArr);
        long j = 0;
        while (i2 >= 0) {
            out.write(cArr, 0, i2);
            j += i2;
            i2 = reader.read(cArr);
        }
        return j;
    }

    public static /* synthetic */ long copyTo$default(Reader reader, Writer writer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return m6208copyTo(reader, writer, i);
    }

    public static final void forEachLine(Reader reader, Function1<? super String, C1133Unit> action) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            Iterator<String> it = lineSequence(bufferedReader).iterator();
            while (it.hasNext()) {
                action.mo2237invoke(it.next());
            }
            C1133Unit c1133Unit = C1133Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedReader, null);
        } finally {
        }
    }

    public static final Sequence<String> lineSequence(BufferedReader bufferedReader) {
        Intrinsics.checkNotNullParameter(bufferedReader, "<this>");
        return SequencesKt.constrainOnce(new LinesSequence(bufferedReader));
    }

    public static final byte[] readBytes(URL url) throws IOException {
        Intrinsics.checkNotNullParameter(url, "<this>");
        InputStream inputStreamOpenStream = url.openStream();
        try {
            Intrinsics.checkNotNull(inputStreamOpenStream);
            byte[] bytes = ByteStreamsKt.readBytes(inputStreamOpenStream);
            CloseableKt.closeFinally(inputStreamOpenStream, null);
            return bytes;
        } finally {
        }
    }

    public static final List<String> readLines(Reader reader) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        final ArrayList arrayList = new ArrayList();
        forEachLine(reader, new Function1() { // from class: o.j8
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return TextStreamsKt.readLines$lambda$0(arrayList, (String) obj);
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1133Unit readLines$lambda$0(ArrayList arrayList, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        arrayList.add(it);
        return C1133Unit.INSTANCE;
    }

    public static final String readText(Reader reader) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        copyTo$default(reader, stringWriter, 0, 2, null);
        String string = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String readText$default(URL url, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(url, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(readBytes(url), charset);
    }

    @InlineOnly
    /* renamed from: reader */
    private static final StringReader m6210reader(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new StringReader(str);
    }

    @IgnorableReturnValue
    public static final <T> T useLines(Reader reader, Function1<? super Sequence<String>, ? extends T> block) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            T tMo2237invoke = block.mo2237invoke(lineSequence(bufferedReader));
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(bufferedReader, null);
            InlineMarker.finallyEnd(1);
            return tMo2237invoke;
        } finally {
        }
    }

    @InlineOnly
    private static final BufferedWriter buffered(Writer writer, int i) {
        Intrinsics.checkNotNullParameter(writer, "<this>");
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i);
    }

    public static /* synthetic */ BufferedWriter buffered$default(Writer writer, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        Intrinsics.checkNotNullParameter(writer, "<this>");
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i);
    }

    @InlineOnly
    private static final String readText(URL url, Charset charset) {
        Intrinsics.checkNotNullParameter(url, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(readBytes(url), charset);
    }
}
