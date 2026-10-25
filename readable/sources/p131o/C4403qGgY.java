package p131o;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.indidevs.p086android.p087adbeesh.notifications.NotificationFlowConfig;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import p131o.AbstractC2069H2;
import p131o.AbstractC3859i1;
import p131o.AbstractC3921j1;
import p131o.AbstractC4893xbjHT;

/* renamed from: o.qGgY */
/* loaded from: classes.dex */
public final class C4403qGgY implements InterfaceC3076W8 {

    /* renamed from: AZxh */
    public final ConnectivityManager f16033AZxh;

    /* renamed from: JHa */
    public final InterfaceC3350aDq f16034JHa;

    /* renamed from: KLFTb */
    public final InterfaceC3350aDq f16035KLFTb;

    /* renamed from: ZfxDd */
    public final URL f16036ZfxDd;

    /* renamed from: mjFkc */
    public final InterfaceC3874iEjzEW f16037mjFkc;

    /* renamed from: wA */
    public final Context f16038wA;

    /* renamed from: xJ */
    public final int f16039xJ;

    /* renamed from: o.qGgY$AZxh */
    public static final class AZxh {

        /* renamed from: AZxh */
        public final URL f16040AZxh;

        /* renamed from: mjFkc */
        public final int f16041mjFkc;

        /* renamed from: wA */
        public final long f16042wA;

        public AZxh(int i, URL url, long j) {
            this.f16041mjFkc = i;
            this.f16040AZxh = url;
            this.f16042wA = j;
        }
    }

    /* renamed from: o.qGgY$mjFkc */
    public static final class mjFkc {

        /* renamed from: AZxh */
        public final AbstractC2512NV f16043AZxh;

        /* renamed from: mjFkc */
        public final URL f16044mjFkc;

        /* renamed from: wA */
        public final String f16045wA;

        public mjFkc(URL url, AbstractC2512NV abstractC2512NV, String str) {
            this.f16044mjFkc = url;
            this.f16043AZxh = abstractC2512NV;
            this.f16045wA = str;
        }

        /* renamed from: mjFkc */
        public mjFkc m13201mjFkc(URL url) {
            return new mjFkc(url, this.f16043AZxh, this.f16045wA);
        }
    }

    public C4403qGgY(Context context, InterfaceC3350aDq interfaceC3350aDq, InterfaceC3350aDq interfaceC3350aDq2, int i) {
        this.f16037mjFkc = AbstractC2512NV.m9683AZxh();
        this.f16038wA = context;
        this.f16033AZxh = (ConnectivityManager) context.getSystemService("connectivity");
        this.f16036ZfxDd = m13194MiMN(C4288oaI.f15763wA);
        this.f16035KLFTb = interfaceC3350aDq2;
        this.f16034JHa = interfaceC3350aDq;
        this.f16039xJ = i;
    }

    /* renamed from: Dt */
    public static long m13190Dt() {
        Calendar.getInstance();
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / NotificationFlowConfig.DEFAULT_BASE_REQUEST_CODE;
    }

    /* renamed from: ETF */
    public static /* synthetic */ mjFkc m13191ETF(mjFkc mjfkc, AZxh aZxh) {
        URL url = aZxh.f16040AZxh;
        if (url == null) {
            return null;
        }
        AbstractC4122m1.m12737mjFkc("CctTransportBackend", "Following redirect to: %s", url);
        return mjfkc.m13201mjFkc(aZxh.f16040AZxh);
    }

    /* renamed from: JHa */
    public static int m13192JHa(NetworkInfo networkInfo) {
        return networkInfo == null ? AbstractC2069H2.wA.NONE.m8507lgHUyS() : networkInfo.getType();
    }

    /* renamed from: KLFTb */
    public static int m13193KLFTb(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return AbstractC2069H2.AZxh.UNKNOWN_MOBILE_SUBTYPE.m8500lgHUyS();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return AbstractC2069H2.AZxh.COMBINED.m8500lgHUyS();
        }
        if (AbstractC2069H2.AZxh.m8497KLFTb(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    /* renamed from: MiMN */
    public static URL m13194MiMN(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid url: " + str, e);
        }
    }

    /* renamed from: VA */
    public static InputStream m13195VA(InputStream inputStream, String str) {
        return "gzip".equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    /* renamed from: qdMbNW */
    public static TelephonyManager m13196qdMbNW(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    /* renamed from: xJ */
    public static int m13198xJ(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            AbstractC4122m1.m12738wA("CctTransportBackend", "Unable to find version code for package", e);
            return -1;
        }
    }

    @Override // p131o.InterfaceC3076W8
    /* renamed from: AZxh */
    public AbstractC2097HPA mo10831AZxh(AbstractC2097HPA abstractC2097HPA) {
        NetworkInfo activeNetworkInfo = this.f16033AZxh.getActiveNetworkInfo();
        return abstractC2097HPA.m8551VA().m8564mjFkc("sdk-version", Build.VERSION.SDK_INT).m8566wA("model", Build.MODEL).m8566wA("hardware", Build.HARDWARE).m8566wA("device", Build.DEVICE).m8566wA("product", Build.PRODUCT).m8566wA("os-uild", Build.ID).m8566wA("manufacturer", Build.MANUFACTURER).m8566wA("fingerprint", Build.FINGERPRINT).m8557AZxh("tz-offset", m13190Dt()).m8564mjFkc("net-type", m13192JHa(activeNetworkInfo)).m8564mjFkc("mobile-subtype", m13193KLFTb(activeNetworkInfo)).m8566wA("country", Locale.getDefault().getCountry()).m8566wA("locale", Locale.getDefault().getLanguage()).m8566wA("mcc_mnc", m13196qdMbNW(this.f16038wA).getSimOperator()).m8566wA("application_build", Integer.toString(m13198xJ(this.f16038wA))).mo8562ZfxDd();
    }

    /* renamed from: ZfxDd */
    public final AZxh m13199ZfxDd(mjFkc mjfkc) throws IOException {
        AbstractC4122m1.m12737mjFkc("CctTransportBackend", "Making request to: %s", mjfkc.f16044mjFkc);
        HttpURLConnection httpURLConnection = (HttpURLConnection) mjfkc.f16044mjFkc.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.f16039xJ);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "2.3.3"));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = mjfkc.f16045wA;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.f16037mjFkc.mo12289AZxh(mjfkc.f16043AZxh, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    AbstractC4122m1.m12735KLFTb("CctTransportBackend", "Status Code: " + responseCode);
                    AbstractC4122m1.m12735KLFTb("CctTransportBackend", "Content-Type: " + httpURLConnection.getHeaderField("Content-Type"));
                    AbstractC4122m1.m12735KLFTb("CctTransportBackend", "Content-Encoding: " + httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new AZxh(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new AZxh(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream inputStreamM13195VA = m13195VA(inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                        try {
                            AZxh aZxh = new AZxh(responseCode, null, AbstractC3992k1.m12460AZxh(new BufferedReader(new InputStreamReader(inputStreamM13195VA))).mo10085wA());
                            if (inputStreamM13195VA != null) {
                                inputStreamM13195VA.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return aZxh;
                        } catch (Throwable th) {
                            if (inputStreamM13195VA != null) {
                                try {
                                    inputStreamM13195VA.close();
                                } catch (Throwable unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        throw th2;
                    }
                } catch (Throwable th3) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                    throw th3;
                }
            } catch (Throwable th4) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th4;
            }
        } catch (ConnectException | UnknownHostException e) {
            AbstractC4122m1.m12738wA("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new AZxh(500, null, 0L);
        } catch (IOException | C2570ORe e2) {
            AbstractC4122m1.m12738wA("CctTransportBackend", "Couldn't encode request, returning with 400", e2);
            return new AZxh(400, null, 0L);
        }
    }

    /* renamed from: lgHUyS */
    public final AbstractC2512NV m13200lgHUyS(AbstractC3551dGDT abstractC3551dGDT) {
        AbstractC3859i1.mjFkc mjfkcM12274Dt;
        HashMap map = new HashMap();
        for (AbstractC2097HPA abstractC2097HPA : abstractC3551dGDT.mo11721AZxh()) {
            String strMo8547Dt = abstractC2097HPA.mo8547Dt();
            if (map.containsKey(strMo8547Dt)) {
                ((List) map.get(strMo8547Dt)).add(abstractC2097HPA);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(abstractC2097HPA);
                map.put(strMo8547Dt, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            AbstractC2097HPA abstractC2097HPA2 = (AbstractC2097HPA) ((List) entry.getValue()).get(0);
            AbstractC3921j1.mjFkc mjfkcMo12252AZxh = AbstractC3921j1.m12333mjFkc().mo12253JHa(EnumC3473c4.DEFAULT).mo12259xJ(this.f16034JHa.mo7979mjFkc()).mo12256lgHUyS(this.f16035KLFTb.mo7979mjFkc()).mo12252AZxh(AbstractC4893xbjHT.m13953mjFkc().mo12022wA(AbstractC4893xbjHT.AZxh.ANDROID_FIREBASE).mo12020AZxh(AbstractC3051Vnb.m10706mjFkc().mo10724MiMN(Integer.valueOf(abstractC2097HPA2.m8556xJ("sdk-version"))).mo10720Dt(abstractC2097HPA2.m8546AZxh("model")).mo10722JHa(abstractC2097HPA2.m8546AZxh("hardware")).mo10726ZfxDd(abstractC2097HPA2.m8546AZxh("device")).mo10725VA(abstractC2097HPA2.m8546AZxh("product")).mo10721ETF(abstractC2097HPA2.m8546AZxh("os-uild")).mo10727lgHUyS(abstractC2097HPA2.m8546AZxh("manufacturer")).mo10723KLFTb(abstractC2097HPA2.m8546AZxh("fingerprint")).mo10730wA(abstractC2097HPA2.m8546AZxh("country")).mo10731xJ(abstractC2097HPA2.m8546AZxh("locale")).mo10729qdMbNW(abstractC2097HPA2.m8546AZxh("mcc_mnc")).mo10719AZxh(abstractC2097HPA2.m8546AZxh("application_build")).mo10728mjFkc()).mo12021mjFkc());
            try {
                mjfkcMo12252AZxh.m12335qdMbNW(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                mjfkcMo12252AZxh.m12334Dt((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (AbstractC2097HPA abstractC2097HPA3 : (List) entry.getValue()) {
                C3331ZxmHEb c3331ZxmHEbMo8550KLFTb = abstractC2097HPA3.mo8550KLFTb();
                C3569dXmy c3569dXmyM11233AZxh = c3331ZxmHEbMo8550KLFTb.m11233AZxh();
                if (c3569dXmyM11233AZxh.m11729equals(C3569dXmy.m11728AZxh("proto"))) {
                    mjfkcM12274Dt = AbstractC3859i1.m12274Dt(c3331ZxmHEbMo8550KLFTb.m11235mjFkc());
                } else if (c3569dXmyM11233AZxh.m11729equals(C3569dXmy.m11728AZxh("json"))) {
                    mjfkcM12274Dt = AbstractC3859i1.m12276qdMbNW(new String(c3331ZxmHEbMo8550KLFTb.m11235mjFkc(), Charset.forName("UTF-8")));
                } else {
                    AbstractC4122m1.m12734JHa("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", c3569dXmyM11233AZxh);
                }
                mjfkcM12274Dt.mo11918wA(abstractC2097HPA3.mo8549JHa()).mo11915ZfxDd(abstractC2097HPA3.mo8548ETF()).mo11916lgHUyS(abstractC2097HPA3.m8553lgHUyS("tz-offset")).mo11914KLFTb(AbstractC2069H2.m8494mjFkc().mo8503wA(AbstractC2069H2.wA.m8504KLFTb(abstractC2097HPA3.m8556xJ("net-type"))).mo8501AZxh(AbstractC2069H2.AZxh.m8497KLFTb(abstractC2097HPA3.m8556xJ("mobile-subtype"))).mo8502mjFkc());
                if (abstractC2097HPA3.mo8552ZfxDd() != null) {
                    mjfkcM12274Dt.mo11912AZxh(abstractC2097HPA3.mo8552ZfxDd());
                }
                arrayList3.add(mjfkcM12274Dt.mo11917mjFkc());
            }
            mjfkcMo12252AZxh.mo12258wA(arrayList3);
            arrayList2.add(mjfkcMo12252AZxh.mo12257mjFkc());
        }
        return AbstractC2512NV.m9684mjFkc(arrayList2);
    }

    @Override // p131o.InterfaceC3076W8
    /* renamed from: mjFkc */
    public AbstractC3197Xxz mo10832mjFkc(AbstractC3551dGDT abstractC3551dGDT) {
        AbstractC2512NV abstractC2512NVM13200lgHUyS = m13200lgHUyS(abstractC3551dGDT);
        URL urlM13194MiMN = this.f16036ZfxDd;
        if (abstractC3551dGDT.mo11722wA() != null) {
            try {
                C4288oaI c4288oaIM12979ZfxDd = C4288oaI.m12979ZfxDd(abstractC3551dGDT.mo11722wA());
                strM12981KLFTb = c4288oaIM12979ZfxDd.m12981KLFTb() != null ? c4288oaIM12979ZfxDd.m12981KLFTb() : null;
                if (c4288oaIM12979ZfxDd.m12980JHa() != null) {
                    urlM13194MiMN = m13194MiMN(c4288oaIM12979ZfxDd.m12980JHa());
                }
            } catch (IllegalArgumentException unused) {
                return AbstractC3197Xxz.m11000mjFkc();
            }
        }
        try {
            AZxh aZxh = (AZxh) AbstractC4926y5.m13993mjFkc(5, new mjFkc(urlM13194MiMN, abstractC2512NVM13200lgHUyS, strM12981KLFTb), C4698ui.m13723mjFkc(this), C4641tpGcn.m13652AZxh());
            int i = aZxh.f16041mjFkc;
            if (i == 200) {
                return AbstractC3197Xxz.m10999ZfxDd(aZxh.f16042wA);
            }
            if (i < 500 && i != 404) {
                return AbstractC3197Xxz.m11000mjFkc();
            }
            return AbstractC3197Xxz.m10998KLFTb();
        } catch (IOException e) {
            AbstractC4122m1.m12738wA("CctTransportBackend", "Could not make request to the backend", e);
            return AbstractC3197Xxz.m10998KLFTb();
        }
    }

    public C4403qGgY(Context context, InterfaceC3350aDq interfaceC3350aDq, InterfaceC3350aDq interfaceC3350aDq2) {
        this(context, interfaceC3350aDq, interfaceC3350aDq2, 40000);
    }
}
