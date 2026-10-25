package p131o;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import org.conscrypt.BuildConfig;

/* renamed from: o.oaI */
/* loaded from: classes.dex */
public final class C4288oaI implements InterfaceC4731vBFMCS {

    /* renamed from: JHa */
    public static final Set f15759JHa;

    /* renamed from: KLFTb */
    public static final String f15760KLFTb;

    /* renamed from: ZfxDd */
    public static final String f15761ZfxDd;

    /* renamed from: lgHUyS */
    public static final C4288oaI f15762lgHUyS;

    /* renamed from: wA */
    public static final String f15763wA;

    /* renamed from: xJ */
    public static final C4288oaI f15764xJ;

    /* renamed from: AZxh */
    public final String f15765AZxh;

    /* renamed from: mjFkc */
    public final String f15766mjFkc;

    static {
        String strM13062mjFkc = AbstractC4325p7.m13062mjFkc("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f15763wA = strM13062mjFkc;
        String strM13062mjFkc2 = AbstractC4325p7.m13062mjFkc("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f15761ZfxDd = strM13062mjFkc2;
        String strM13062mjFkc3 = AbstractC4325p7.m13062mjFkc("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f15760KLFTb = strM13062mjFkc3;
        f15759JHa = Collections.unmodifiableSet(new HashSet(Arrays.asList(C3569dXmy.m11728AZxh("proto"), C3569dXmy.m11728AZxh("json"))));
        f15764xJ = new C4288oaI(strM13062mjFkc, null);
        f15762lgHUyS = new C4288oaI(strM13062mjFkc2, strM13062mjFkc3);
    }

    public C4288oaI(String str, String str2) {
        this.f15766mjFkc = str;
        this.f15765AZxh = str2;
    }

    /* renamed from: ZfxDd */
    public static C4288oaI m12979ZfxDd(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] strArrSplit = str.substring(2).split(Pattern.quote("\\"), 2);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = strArrSplit[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new C4288oaI(str2, str3);
    }

    @Override // p131o.InterfaceC1635Ab
    /* renamed from: AZxh */
    public byte[] mo7620AZxh() {
        return m12983wA();
    }

    /* renamed from: JHa */
    public String m12980JHa() {
        return this.f15766mjFkc;
    }

    /* renamed from: KLFTb */
    public String m12981KLFTb() {
        return this.f15765AZxh;
    }

    @Override // p131o.InterfaceC1635Ab
    /* renamed from: getName */
    public String mo7621getName() {
        return "cct";
    }

    @Override // p131o.InterfaceC4731vBFMCS
    /* renamed from: mjFkc */
    public Set mo12982mjFkc() {
        return f15759JHa;
    }

    /* renamed from: wA */
    public byte[] m12983wA() {
        String str = this.f15765AZxh;
        if (str == null && this.f15766mjFkc == null) {
            return null;
        }
        String str2 = this.f15766mjFkc;
        if (str == null) {
            str = BuildConfig.f24315FLAVOR;
        }
        return String.format("%s%s%s%s", "1$", str2, "\\", str).getBytes(Charset.forName("UTF-8"));
    }
}
