package com.flyfishxu.p028kadb.p032mdns.internal;

import com.flyfishxu.p028kadb.p032mdns.MdnsServiceType;
import java.util.Iterator;
import java.util.Locale;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.StringsKt;

@Metadata(m4987d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u000e\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u0003H\u0000¨\u0006\u0005"}, m4988d2 = {"parseMdnsServiceType", "Lcom/flyfishxu/kadb/mdns/MdnsServiceType;", "serviceType", BuildConfig.f24315FLAVOR, "normalizeMdnsServiceType", "com.github.IndiTheo:kadb-mdns"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nMdnsServiceTypeParser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MdnsServiceTypeParser.kt\ncom/flyfishxu/kadb/mdns/internal/MdnsServiceTypeParserKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,16:1\n296#2,2:17\n*S KotlinDebug\n*F\n+ 1 MdnsServiceTypeParser.kt\ncom/flyfishxu/kadb/mdns/internal/MdnsServiceTypeParserKt\n*L\n7#1:17,2\n*E\n"})
/* loaded from: classes.dex */
public final class MdnsServiceTypeParserKt {
    public static final String normalizeMdnsServiceType(String str) {
        if (str == null) {
            str = BuildConfig.f24315FLAVOR;
        }
        String lowerCase = StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.m6778trim((CharSequence) str).toString(), (CharSequence) "."), (CharSequence) ".local").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public static final MdnsServiceType parseMdnsServiceType(String str) {
        MdnsServiceType next;
        String strNormalizeMdnsServiceType = normalizeMdnsServiceType(str);
        Iterator<MdnsServiceType> it = MdnsServiceType.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(next.getDnsType(), strNormalizeMdnsServiceType)) {
                break;
            }
        }
        return next;
    }
}
