package com.flyfishxu.p028kadb.p029cert;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001cB/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/KadbCertPolicy;", BuildConfig.f24315FLAVOR, "keySizeBits", BuildConfig.f24315FLAVOR, "certValidityDays", "autoHealInvalidPrivateKey", BuildConfig.f24315FLAVOR, "subject", "Lcom/flyfishxu/kadb/cert/KadbCertPolicy$Subject;", "<init>", "(IIZLcom/flyfishxu/kadb/cert/KadbCertPolicy$Subject;)V", "getKeySizeBits", "()I", "getCertValidityDays", "getAutoHealInvalidPrivateKey", "()Z", "getSubject", "()Lcom/flyfishxu/kadb/cert/KadbCertPolicy$Subject;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", BuildConfig.f24315FLAVOR, "Subject", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final /* data */ class KadbCertPolicy {
    private final boolean autoHealInvalidPrivateKey;
    private final int certValidityDays;
    private final int keySizeBits;
    private final Subject subject;

    @Metadata(m4987d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/KadbCertPolicy$Subject;", BuildConfig.f24315FLAVOR, "cn", BuildConfig.f24315FLAVOR, "ou", "o", "l", "st", "c", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCn", "()Ljava/lang/String;", "getOu", "getO", "getL", "getSt", "getC", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", BuildConfig.f24315FLAVOR, "other", "hashCode", BuildConfig.f24315FLAVOR, "toString", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final /* data */ class Subject {
        private final String c;
        private final String cn;
        private final String l;
        private final String o;
        private final String ou;
        private final String st;

        public Subject() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ Subject copy$default(Subject subject, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subject.cn;
            }
            if ((i & 2) != 0) {
                str2 = subject.ou;
            }
            String str7 = str2;
            if ((i & 4) != 0) {
                str3 = subject.o;
            }
            String str8 = str3;
            if ((i & 8) != 0) {
                str4 = subject.l;
            }
            String str9 = str4;
            if ((i & 16) != 0) {
                str5 = subject.st;
            }
            String str10 = str5;
            if ((i & 32) != 0) {
                str6 = subject.c;
            }
            return subject.m2190copy(str, str7, str8, str9, str10, str6);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCn() {
            return this.cn;
        }

        /* renamed from: component2, reason: from getter */
        public final String getOu() {
            return this.ou;
        }

        /* renamed from: component3, reason: from getter */
        public final String getO() {
            return this.o;
        }

        /* renamed from: component4, reason: from getter */
        public final String getL() {
            return this.l;
        }

        /* renamed from: component5, reason: from getter */
        public final String getSt() {
            return this.st;
        }

        /* renamed from: component6, reason: from getter */
        public final String getC() {
            return this.c;
        }

        /* renamed from: copy */
        public final Subject m2190copy(String cn, String ou, String o2, String l, String st, String c) {
            Intrinsics.checkNotNullParameter(cn, "cn");
            Intrinsics.checkNotNullParameter(ou, "ou");
            Intrinsics.checkNotNullParameter(o2, "o");
            Intrinsics.checkNotNullParameter(l, "l");
            Intrinsics.checkNotNullParameter(st, "st");
            Intrinsics.checkNotNullParameter(c, "c");
            return new Subject(cn, ou, o2, l, st, c);
        }

        /* renamed from: equals */
        public boolean m2191equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Subject)) {
                return false;
            }
            Subject subject = (Subject) other;
            return Intrinsics.areEqual(this.cn, subject.cn) && Intrinsics.areEqual(this.ou, subject.ou) && Intrinsics.areEqual(this.o, subject.o) && Intrinsics.areEqual(this.l, subject.l) && Intrinsics.areEqual(this.st, subject.st) && Intrinsics.areEqual(this.c, subject.c);
        }

        /* renamed from: getC */
        public final String m2192getC() {
            return this.c;
        }

        /* renamed from: getCn */
        public final String m2193getCn() {
            return this.cn;
        }

        /* renamed from: getL */
        public final String m2194getL() {
            return this.l;
        }

        /* renamed from: getO */
        public final String m2195getO() {
            return this.o;
        }

        /* renamed from: getOu */
        public final String m2196getOu() {
            return this.ou;
        }

        /* renamed from: getSt */
        public final String m2197getSt() {
            return this.st;
        }

        public int hashCode() {
            return (((((((((this.cn.hashCode() * 31) + this.ou.hashCode()) * 31) + this.o.hashCode()) * 31) + this.l.hashCode()) * 31) + this.st.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "Subject(cn=" + this.cn + ", ou=" + this.ou + ", o=" + this.o + ", l=" + this.l + ", st=" + this.st + ", c=" + this.c + ")";
        }

        public Subject(String cn, String ou, String o2, String l, String st, String c) {
            Intrinsics.checkNotNullParameter(cn, "cn");
            Intrinsics.checkNotNullParameter(ou, "ou");
            Intrinsics.checkNotNullParameter(o2, "o");
            Intrinsics.checkNotNullParameter(l, "l");
            Intrinsics.checkNotNullParameter(st, "st");
            Intrinsics.checkNotNullParameter(c, "c");
            this.cn = cn;
            this.ou = ou;
            this.o = o2;
            this.l = l;
            this.st = st;
            this.c = c;
        }

        public /* synthetic */ Subject(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "Adb" : str, (i & 2) != 0 ? BuildConfig.f24315FLAVOR : str2, (i & 4) != 0 ? "Android" : str3, (i & 8) != 0 ? BuildConfig.f24315FLAVOR : str4, (i & 16) == 0 ? str5 : BuildConfig.f24315FLAVOR, (i & 32) != 0 ? "US" : str6);
        }
    }

    public KadbCertPolicy() {
        this(0, 0, false, null, 15, null);
    }

    public static /* synthetic */ KadbCertPolicy copy$default(KadbCertPolicy kadbCertPolicy, int i, int i2, boolean z, Subject subject, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = kadbCertPolicy.keySizeBits;
        }
        if ((i3 & 2) != 0) {
            i2 = kadbCertPolicy.certValidityDays;
        }
        if ((i3 & 4) != 0) {
            z = kadbCertPolicy.autoHealInvalidPrivateKey;
        }
        if ((i3 & 8) != 0) {
            subject = kadbCertPolicy.subject;
        }
        return kadbCertPolicy.m2188copy(i, i2, z, subject);
    }

    /* renamed from: component1, reason: from getter */
    public final int getKeySizeBits() {
        return this.keySizeBits;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCertValidityDays() {
        return this.certValidityDays;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getAutoHealInvalidPrivateKey() {
        return this.autoHealInvalidPrivateKey;
    }

    /* renamed from: component4, reason: from getter */
    public final Subject getSubject() {
        return this.subject;
    }

    /* renamed from: copy */
    public final KadbCertPolicy m2188copy(int keySizeBits, int certValidityDays, boolean autoHealInvalidPrivateKey, Subject subject) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        return new KadbCertPolicy(keySizeBits, certValidityDays, autoHealInvalidPrivateKey, subject);
    }

    /* renamed from: equals */
    public boolean m2189equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KadbCertPolicy)) {
            return false;
        }
        KadbCertPolicy kadbCertPolicy = (KadbCertPolicy) other;
        return this.keySizeBits == kadbCertPolicy.keySizeBits && this.certValidityDays == kadbCertPolicy.certValidityDays && this.autoHealInvalidPrivateKey == kadbCertPolicy.autoHealInvalidPrivateKey && Intrinsics.areEqual(this.subject, kadbCertPolicy.subject);
    }

    public final boolean getAutoHealInvalidPrivateKey() {
        return this.autoHealInvalidPrivateKey;
    }

    public final int getCertValidityDays() {
        return this.certValidityDays;
    }

    public final int getKeySizeBits() {
        return this.keySizeBits;
    }

    public final Subject getSubject() {
        return this.subject;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.keySizeBits) * 31) + Integer.hashCode(this.certValidityDays)) * 31) + Boolean.hashCode(this.autoHealInvalidPrivateKey)) * 31) + this.subject.hashCode();
    }

    public String toString() {
        return "KadbCertPolicy(keySizeBits=" + this.keySizeBits + ", certValidityDays=" + this.certValidityDays + ", autoHealInvalidPrivateKey=" + this.autoHealInvalidPrivateKey + ", subject=" + this.subject + ")";
    }

    public KadbCertPolicy(int i, int i2, boolean z, Subject subject) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        this.keySizeBits = i;
        this.certValidityDays = i2;
        this.autoHealInvalidPrivateKey = z;
        this.subject = subject;
    }

    public /* synthetic */ KadbCertPolicy(int i, int i2, boolean z, Subject subject, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 2048 : i, (i3 & 2) != 0 ? 3650 : i2, (i3 & 4) != 0 ? true : z, (i3 & 8) != 0 ? new Subject(null, null, null, null, null, null, 63, null) : subject);
    }
}
