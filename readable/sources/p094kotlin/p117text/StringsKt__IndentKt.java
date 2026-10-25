package p094kotlin.p117text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.internal.IntrinsicConstEvaluation;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.sequences.SequencesKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0087\u0080\u0004b\u0002\b\u0003\u001a\"\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u0001H\u0087\u0080\u0004b\u0002\b\u0003\u001a\u0018\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0018\u0010\b\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0013\u0010\n\u001a\u00020\u000b*\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b\f\u001a#\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\t\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b\u000f\u001aK\u0010\u0010\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u000e2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eH\u0082\u0088\u0004¢\u0006\u0002\b\u0015¨\u0006\u0016"}, m4988d2 = {"trimMargin", BuildConfig.f24315FLAVOR, "marginPrefix", "Lkotlin/internal/IntrinsicConstEvaluation;", "replaceIndentByMargin", "newIndent", "trimIndent", "replaceIndent", "prependIndent", "indent", "indentWidth", BuildConfig.f24315FLAVOR, "indentWidth$StringsKt__IndentKt", "getIndentFunction", "Lkotlin/Function1;", "getIndentFunction$StringsKt__IndentKt", "reindent", BuildConfig.f24315FLAVOR, "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/text/StringsKt")
@SourceDebugExtension(m6344value = {"SMAP\nIndent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Indent.kt\nkotlin/text/StringsKt__IndentKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,129:1\n119#1,2:131\n121#1,4:137\n126#1,2:150\n119#1,2:159\n121#1,4:165\n126#1,2:172\n1#2:130\n1#2:147\n1#2:169\n1#2:184\n1759#3:133\n1770#3:134\n2077#3,2:135\n2079#3:148\n1771#3:149\n777#3:152\n873#3,2:153\n1739#3:155\n1814#3,3:156\n1759#3:161\n1770#3:162\n2077#3,2:163\n2079#3:170\n1771#3:171\n1759#3:180\n1770#3:181\n2077#3,2:182\n2079#3:185\n1771#3:186\n161#4,6:141\n161#4,6:174\n*S KotlinDebug\n*F\n+ 1 Indent.kt\nkotlin/text/StringsKt__IndentKt\n*L\n42#1:131,2\n42#1:137,4\n42#1:150,2\n83#1:159,2\n83#1:165,4\n83#1:172,2\n42#1:147\n83#1:169\n120#1:184\n42#1:133\n42#1:134\n42#1:135,2\n42#1:148\n42#1:149\n79#1:152\n79#1:153,2\n80#1:155\n80#1:156,3\n83#1:161\n83#1:162\n83#1:163,2\n83#1:170\n83#1:171\n120#1:180\n120#1:181\n120#1:182,2\n120#1:185\n120#1:186\n43#1:141,6\n107#1:174,6\n*E\n"})
/* loaded from: classes.dex */
public class StringsKt__IndentKt extends StringsKt__AppendableKt {
    private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(final String str) {
        return str.length() == 0 ? new Function1() { // from class: kotlin.text.AZxh
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return StringsKt__IndentKt.getIndentFunction$lambda$0$StringsKt__IndentKt((String) obj);
            }
        } : new Function1() { // from class: kotlin.text.wA
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return StringsKt__IndentKt.getIndentFunction$lambda$1$StringsKt__IndentKt(str, (String) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getIndentFunction$lambda$0$StringsKt__IndentKt(String line) {
        Intrinsics.checkNotNullParameter(line, "line");
        return line;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getIndentFunction$lambda$1$StringsKt__IndentKt(String str, String line) {
        Intrinsics.checkNotNullParameter(line, "line");
        return str + line;
    }

    private static final int indentWidth$StringsKt__IndentKt(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            if (!CharsKt__CharJVMKt.isWhitespace(str.charAt(i))) {
                break;
            }
            i++;
        }
        return i == -1 ? str.length() : i;
    }

    public static final String prependIndent(String str, final String indent) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(indent, "indent");
        return SequencesKt.joinToString$default(SequencesKt.m6610map(StringsKt__StringsKt.lineSequence(str), new Function1() { // from class: kotlin.text.mjFkc
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return StringsKt__IndentKt.prependIndent$lambda$0$StringsKt__IndentKt(indent, (String) obj);
            }
        }), "\n", null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ String prependIndent$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "    ";
        }
        return prependIndent(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String prependIndent$lambda$0$StringsKt__IndentKt(String str, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (StringsKt.m6766isBlank(it)) {
            return it.length() < str.length() ? str : it;
        }
        return str + it;
    }

    private static final String reindent$StringsKt__IndentKt(List<String> list, int i, Function1<? super String, String> function1, Function1<? super String, String> function12) {
        String strMo2237invoke;
        int lastIndex = CollectionsKt.getLastIndex(list);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            if ((i2 == 0 || i2 == lastIndex) && StringsKt.m6766isBlank(str)) {
                str = null;
            } else {
                String strMo2237invoke2 = function12.mo2237invoke(str);
                if (strMo2237invoke2 != null && (strMo2237invoke = function1.mo2237invoke(strMo2237invoke2)) != null) {
                    str = strMo2237invoke;
                }
            }
            if (str != null) {
                arrayList.add(str);
            }
            i2 = i3;
        }
        return ((StringBuilder) CollectionsKt.joinTo$default(arrayList, new StringBuilder(i), "\n", null, null, 0, null, null, 124, null)).toString();
    }

    public static final String replaceIndent(String str, String newIndent) {
        String strMo2237invoke;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        List<String> listM6768lines = StringsKt__StringsKt.m6768lines(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM6768lines) {
            if (!StringsKt.m6766isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(indentWidth$StringsKt__IndentKt((String) it.next())));
        }
        Integer num = (Integer) CollectionsKt.minOrNull((Iterable) arrayList2);
        int i = 0;
        int iIntValue = num != null ? num.intValue() : 0;
        int length = str.length() + (newIndent.length() * listM6768lines.size());
        Function1<String, String> indentFunction$StringsKt__IndentKt = getIndentFunction$StringsKt__IndentKt(newIndent);
        int lastIndex = CollectionsKt.getLastIndex(listM6768lines);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listM6768lines) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str2 = (String) obj2;
            if ((i == 0 || i == lastIndex) && StringsKt.m6766isBlank(str2)) {
                str2 = null;
            } else {
                String strM6808drop = StringsKt___StringsKt.m6808drop(str2, iIntValue);
                if (strM6808drop != null && (strMo2237invoke = indentFunction$StringsKt__IndentKt.mo2237invoke(strM6808drop)) != null) {
                    str2 = strMo2237invoke;
                }
            }
            if (str2 != null) {
                arrayList3.add(str2);
            }
            i = i2;
        }
        return ((StringBuilder) CollectionsKt.joinTo$default(arrayList3, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
    }

    public static /* synthetic */ String replaceIndent$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = BuildConfig.f24315FLAVOR;
        }
        return replaceIndent(str, str2);
    }

    public static final String replaceIndentByMargin(String str, String newIndent, String marginPrefix) {
        int i;
        String strMo2237invoke;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        if (StringsKt.m6766isBlank(marginPrefix)) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        List<String> listM6768lines = StringsKt__StringsKt.m6768lines(str);
        int length = str.length() + (newIndent.length() * listM6768lines.size());
        Function1<String, String> indentFunction$StringsKt__IndentKt = getIndentFunction$StringsKt__IndentKt(newIndent);
        int lastIndex = CollectionsKt.getLastIndex(listM6768lines);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : listM6768lines) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str2 = (String) obj;
            String strSubstring = null;
            if ((i2 == 0 || i2 == lastIndex) && StringsKt.m6766isBlank(str2)) {
                str2 = null;
            } else {
                int length2 = str2.length();
                int i4 = 0;
                while (true) {
                    if (i4 >= length2) {
                        i = -1;
                        break;
                    }
                    if (!CharsKt__CharJVMKt.isWhitespace(str2.charAt(i4))) {
                        i = i4;
                        break;
                    }
                    i4++;
                }
                if (i != -1) {
                    int i5 = i;
                    if (StringsKt__StringsJVMKt.startsWith$default(str2, marginPrefix, i, false, 4, null)) {
                        int length3 = i5 + marginPrefix.length();
                        Intrinsics.checkNotNull(str2, "null cannot be cast to non-null type java.lang.String");
                        strSubstring = str2.substring(length3);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    }
                }
                if (strSubstring != null && (strMo2237invoke = indentFunction$StringsKt__IndentKt.mo2237invoke(strSubstring)) != null) {
                    str2 = strMo2237invoke;
                }
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
            i2 = i3;
        }
        return ((StringBuilder) CollectionsKt.joinTo$default(arrayList, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
    }

    public static /* synthetic */ String replaceIndentByMargin$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = BuildConfig.f24315FLAVOR;
        }
        if ((i & 2) != 0) {
            str3 = "|";
        }
        return replaceIndentByMargin(str, str2, str3);
    }

    @IntrinsicConstEvaluation
    public static String trimIndent(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return replaceIndent(str, BuildConfig.f24315FLAVOR);
    }

    @IntrinsicConstEvaluation
    public static final String trimMargin(String str, String marginPrefix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        return replaceIndentByMargin(str, BuildConfig.f24315FLAVOR, marginPrefix);
    }

    public static /* synthetic */ String trimMargin$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return trimMargin(str, str2);
    }
}
