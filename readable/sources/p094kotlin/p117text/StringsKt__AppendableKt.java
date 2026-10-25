package p094kotlin.p117text;

import java.io.IOException;
import org.conscrypt.BuildConfig;
import p094kotlin.IgnorableReturnValue;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u0000P\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\u0000\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0087\u0080\bb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\r¢\u0006\u0002\u0010\t\u001a=\u0010\u000e\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u000f\"\u0004\u0018\u00010\u0005H\u0087\u0080\bb\u0002\b\r¢\u0006\u0002\u0010\u0010\u001a1\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u0003H\u0087\u0088\bb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0013b\u0002\b\r¢\u0006\u0002\u0010\u0012\u001a;\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0087\u0088\bb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0013b\u0002\b\r¢\u0006\u0002\u0010\u0014\u001a9\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0015H\u0087\u0088\bb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0013b\u0002\b\r¢\u0006\u0002\u0010\u0016\u001a;\u0010\u0017\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0019\u001a\u0002H\u00012\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001bH\u0080\u0080\u0004¢\u0006\u0002\u0010\u001c¨\u0006\u001d"}, m4988d2 = {"appendRange", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "value", BuildConfig.f24315FLAVOR, "startIndex", BuildConfig.f24315FLAVOR, "endIndex", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;II)Ljava/lang/Appendable;", "Lkotlin/SinceKotlin;", "version", "1.4", "Lkotlin/IgnorableReturnValue;", "append", BuildConfig.f24315FLAVOR, "(Ljava/lang/Appendable;[Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "appendLine", "(Ljava/lang/Appendable;)Ljava/lang/Appendable;", "Lkotlin/internal/InlineOnly;", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;)Ljava/lang/Appendable;", BuildConfig.f24315FLAVOR, "(Ljava/lang/Appendable;C)Ljava/lang/Appendable;", "appendElement", BuildConfig.f24315FLAVOR, "element", "transform", "Lkotlin/Function1;", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
public class StringsKt__AppendableKt {
    @IgnorableReturnValue
    /* renamed from: append */
    public static final <T extends Appendable> T m6711append(T t, CharSequence... value) throws IOException {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        for (CharSequence charSequence : value) {
            t.append(charSequence);
        }
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void appendElement(Appendable appendable, T t, Function1<? super T, ? extends CharSequence> function1) throws IOException {
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        if (function1 != null) {
            appendable.append(function1.mo2237invoke(t));
            return;
        }
        if (t == 0 ? true : t instanceof CharSequence) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(t.toString());
        }
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    @InlineOnly
    private static final Appendable appendLine(Appendable appendable) {
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        return appendable.append('\n');
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    public static final <T extends Appendable> T appendRange(T t, CharSequence value, int i, int i2) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        T t2 = (T) t.append(value, i, i2);
        Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type T of kotlin.text.StringsKt__AppendableKt.appendRange");
        return t2;
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    @InlineOnly
    private static final Appendable appendLine(Appendable appendable, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        return appendable.append(charSequence).append('\n');
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    @InlineOnly
    private static final Appendable appendLine(Appendable appendable, char c) {
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        return appendable.append(c).append('\n');
    }
}
