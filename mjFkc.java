package com.jc.code.v3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Base64;
import android.util.Log;
import com.flyfishxu.kadb.Kadb;
import com.indidevs.android.adbeesh.config.AdbSessionConfig;
import com.indidevs.android.adbeesh.internal.connection.AdbClient;
import com.indidevs.android.adbeesh.internal.connection.AdbSessionImpl;
import com.indidevs.android.adbeesh.internal.security.IdentityStore;
import com.indidevs.android.adbeesh.internal.security.KeyPair;
import com.indidevs.android.adbeesh.pairing.AdbPairing;
import com.indidevs.android.adbeesh.pairing.AdbPairingCallback;
import com.indidevs.android.adbeesh.pairing.AdbPairingCodeProvider;
import com.indidevs.android.adbeesh.pairing.AdbPairingWorkflow;
import com.indidevs.android.adbeesh.runtime.AdbSession;
import com.indidevs.android.adbeesh.runtime.AdbShellResult;
import com.jc.code.v3.AZxh;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.time.DurationKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public abstract class mjFkc {
    public static AdbSession JHa;
    public static AdbPairing KLFTb;
    public static volatile fehf YoKzxo;
    public static qGY ZfxDd;
    public static Context xJ;
    public static final Object mjFkc = new Object();
    public static final Object AZxh = new Object();
    public static final LinkedBlockingQueue wA = new LinkedBlockingQueue();
    public static String lgHUyS = "jc_code_v3";
    public static volatile boolean qdMbNW = false;
    public static volatile boolean Dt = false;
    public static volatile boolean ETF = false;
    public static volatile boolean VA = false;
    public static int MiMN = 0;

    public class AZxh implements Callable {
        @Override // java.util.concurrent.Callable
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public String call() {
            return mjFkc.JBhc("id");
        }
    }

    public class Dt implements Callable {
        public final /* synthetic */ AdbPairing mjFkc;

        /* renamed from: com.jc.code.v3.mjFkc$Dt$mjFkc, reason: collision with other inner class name */
        public class C0037mjFkc implements Function2 {
            public C0037mjFkc() {
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
            public Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return Dt.this.mjFkc.openSession(15000L, continuation);
            }
        }

        public Dt(AdbPairing adbPairing) {
            this.mjFkc = adbPairing;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public AdbSession call() {
            return (AdbSession) BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new C0037mjFkc());
        }
    }

    public class ETF implements Callable {
        public final /* synthetic */ Method AZxh;
        public final /* synthetic */ int ZfxDd;
        public final /* synthetic */ Object mjFkc;
        public final /* synthetic */ String wA;

        public ETF(Object obj, Method method, String str, int i) {
            this.mjFkc = obj;
            this.AZxh = method;
            this.wA = str;
            this.ZfxDd = i;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return mjFkc.HGpJ(this.mjFkc, this.AZxh, this.wA, Integer.valueOf(this.ZfxDd));
        }
    }

    public interface IEE {
        String mjFkc(AdbSession adbSession);
    }

    public class JHa implements Callable {
        public final /* synthetic */ AdbSession AZxh;
        public final /* synthetic */ IEE mjFkc;

        public JHa(IEE iee, AdbSession adbSession) {
            this.mjFkc = iee;
            this.AZxh = adbSession;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public String call() {
            return this.mjFkc.mjFkc(this.AZxh);
        }
    }

    public class KLFTb implements Callable {
        @Override // java.util.concurrent.Callable
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public AdbSession call() {
            AdbSession adbSessionWrLQs = mjFkc.WrLQs(15000L);
            if (mjFkc.Vnb(adbSessionWrLQs)) {
                return adbSessionWrLQs;
            }
            mjFkc.lB();
            return mjFkc.WrLQs(15000L);
        }
    }

    public class MiMN implements Runnable {
        public final /* synthetic */ Callable AZxh;
        public final /* synthetic */ Object[] mjFkc;

        public MiMN(Object[] objArr, Callable callable) {
            this.mjFkc = objArr;
            this.AZxh = callable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mjFkc[0] = this.AZxh.call();
            } catch (Throwable th) {
                this.mjFkc[1] = th;
            }
        }
    }

    public class VA implements Function2 {
        public final /* synthetic */ Method AZxh;
        public final /* synthetic */ Object[] mjFkc;
        public final /* synthetic */ Object wA;

        public VA(Object[] objArr, Method method, Object obj) {
            this.mjFkc = objArr;
            this.AZxh = method;
            this.wA = obj;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            Object[] objArr = this.mjFkc;
            Object[] objArr2 = new Object[objArr.length + 1];
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
            objArr2[this.mjFkc.length] = continuation;
            try {
                return this.AZxh.invoke(this.wA, objArr2);
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new RuntimeException(cause);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public class YoKzxo implements IEE {
        public final /* synthetic */ String mjFkc;

        public YoKzxo(String str) {
            this.mjFkc = str;
        }

        @Override // com.jc.code.v3.mjFkc.IEE
        public String mjFkc(AdbSession adbSession) {
            AdbShellResult adbShellResultSwgkN = mjFkc.SwgkN(adbSession, this.mjFkc);
            String output = adbShellResultSwgkN.getOutput();
            boolean zIsSuccess = adbShellResultSwgkN.isSuccess();
            String strTrim = BuildConfig.FLAVOR;
            if (zIsSuccess) {
                return output != null ? output : BuildConfig.FLAVOR;
            }
            String error = adbShellResultSwgkN.getError();
            if (error != null && error.trim().length() > 0) {
                strTrim = error.trim();
            } else if (output != null) {
                strTrim = output.trim();
            }
            if (strTrim.length() <= 0) {
                strTrim = "退出码 " + adbShellResultSwgkN.getExitCode();
            }
            throw new IllegalStateException(strTrim);
        }
    }

    public class ZfxDd implements IEE {
        public final /* synthetic */ String mjFkc;

        public ZfxDd(String str) {
            this.mjFkc = str;
        }

        @Override // com.jc.code.v3.mjFkc.IEE
        public String mjFkc(AdbSession adbSession) throws Exception {
            mjFkc.cMLeY(mjFkc.oCFDzJ(adbSession), "uninstall", new Class[]{String.class}, new Object[]{this.mjFkc});
            return "Success";
        }
    }

    public interface fehf {
        void mjFkc(String str);
    }

    public class lgHUyS implements Runnable {
        public final /* synthetic */ AdbPairing AZxh;
        public final /* synthetic */ int mjFkc;

        public lgHUyS(int i, AdbPairing adbPairing) {
            this.mjFkc = i;
            this.AZxh = adbPairing;
        }

        @Override // java.lang.Runnable
        public void run() {
            mjFkc.SmIWf(this.mjFkc, this.AZxh);
        }
    }

    /* renamed from: com.jc.code.v3.mjFkc$mjFkc, reason: collision with other inner class name */
    public class RunnableC0038mjFkc implements Runnable {
        public final /* synthetic */ String AZxh;
        public final /* synthetic */ int mjFkc;
        public final /* synthetic */ Context wA;

        /* renamed from: com.jc.code.v3.mjFkc$mjFkc$AZxh */
        public class AZxh implements AdbPairingCodeProvider {
            public AZxh() {
            }

            @Override // com.indidevs.android.adbeesh.pairing.AdbPairingCodeProvider
            public Object provideCode(String str, int i, Continuation continuation) {
                try {
                    mjFkc.tQ(RunnableC0038mjFkc.this.mjFkc, "已找到配对端口 " + i + "，等待配对码...");
                    return mjFkc.wA.poll(180000L, TimeUnit.MILLISECONDS);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
        }

        /* renamed from: com.jc.code.v3.mjFkc$mjFkc$mjFkc, reason: collision with other inner class name */
        public class C0039mjFkc implements AdbPairingCallback {
            public final /* synthetic */ AdbPairing mjFkc;

            public C0039mjFkc(AdbPairing adbPairing) {
                this.mjFkc = adbPairing;
            }

            @Override // com.indidevs.android.adbeesh.pairing.AdbPairingCallback
            public void onPairingError(String str, String str2) {
                mjFkc.JYgkl(RunnableC0038mjFkc.this.mjFkc, "配对失败: " + str2);
            }

            @Override // com.indidevs.android.adbeesh.pairing.AdbPairingCallback
            public void onPairingHandshakeStarted(String str) {
                mjFkc.tQ(RunnableC0038mjFkc.this.mjFkc, "正在与设备配对...");
            }

            @Override // com.indidevs.android.adbeesh.pairing.AdbPairingCallback
            public void onPairingStarted(String str) {
                mjFkc.tQ(RunnableC0038mjFkc.this.mjFkc, "正在搜索无线调试配对服务...");
            }

            @Override // com.indidevs.android.adbeesh.pairing.AdbPairingCallback
            public void onPairingSuccess(String str) {
                mjFkc.tQ(RunnableC0038mjFkc.this.mjFkc, "配对握手成功，正在验证 ADB 连接...");
                mjFkc.dm(RunnableC0038mjFkc.this.mjFkc, this.mjFkc);
            }

            @Override // com.indidevs.android.adbeesh.pairing.AdbPairingCallback
            public void onPortFound(String str, int i) {
                mjFkc.tQ(RunnableC0038mjFkc.this.mjFkc, "找到配对端口 " + i);
            }
        }

        /* renamed from: com.jc.code.v3.mjFkc$mjFkc$wA */
        public class wA implements Function2 {
            public final /* synthetic */ AdbPairingWorkflow AZxh;
            public final /* synthetic */ AdbPairing mjFkc;

            public wA(AdbPairing adbPairing, AdbPairingWorkflow adbPairingWorkflow) {
                this.mjFkc = adbPairing;
                this.AZxh = adbPairingWorkflow;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
            public Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return this.mjFkc.ensurePaired(this.AZxh, continuation);
            }
        }

        public RunnableC0038mjFkc(int i, String str, Context context) {
            this.mjFkc = i;
            this.AZxh = str;
            this.wA = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AdbSessionConfig adbSessionConfigGd = mjFkc.Gd();
                mjFkc.tQ(this.mjFkc, "开始配对流程（身份 " + this.AZxh + "）");
                AdbPairing adbPairing = AdbPairing.INSTANCE.get(this.wA, this.AZxh, adbSessionConfigGd, GlobalScope.INSTANCE);
                synchronized (mjFkc.mjFkc) {
                    AdbPairing unused = mjFkc.KLFTb = adbPairing;
                }
                if (mjFkc.IVlxe(this.mjFkc, adbPairing)) {
                    synchronized (mjFkc.mjFkc) {
                        try {
                            if (this.mjFkc == mjFkc.MiMN && mjFkc.ETF) {
                                boolean unused2 = mjFkc.qdMbNW = false;
                            }
                        } finally {
                        }
                    }
                    return;
                }
                mjFkc.mByQ(this.AZxh);
                mjFkc.tQ(this.mjFkc, "旧配对已失效，开始全新配对...");
                try {
                    BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new wA(adbPairing, new AdbPairingWorkflow.Builder().withCodeProvider(new AZxh()).addCallback(new C0039mjFkc(adbPairing)).build()));
                    mjFkc.tQ(this.mjFkc, "配对流程返回");
                    mjFkc.dm(this.mjFkc, adbPairing);
                    synchronized (mjFkc.mjFkc) {
                        try {
                            if (this.mjFkc == mjFkc.MiMN && mjFkc.ETF) {
                                boolean unused3 = mjFkc.qdMbNW = false;
                            }
                        } finally {
                        }
                    }
                } catch (Throwable th) {
                    if (mjFkc.rWxwaT(this.mjFkc) && !mjFkc.ETF) {
                        mjFkc.JYgkl(this.mjFkc, "配对流程异常: " + th.getMessage());
                    }
                    synchronized (mjFkc.mjFkc) {
                        try {
                            if (this.mjFkc == mjFkc.MiMN && mjFkc.ETF) {
                                boolean unused4 = mjFkc.qdMbNW = false;
                            }
                        } finally {
                        }
                    }
                }
            } catch (Throwable th2) {
                try {
                    mjFkc.JYgkl(this.mjFkc, "自动配对异常: " + th2.getMessage());
                    synchronized (mjFkc.mjFkc) {
                        try {
                            if (this.mjFkc == mjFkc.MiMN) {
                                AdbPairing unused5 = mjFkc.KLFTb = null;
                            }
                            synchronized (mjFkc.mjFkc) {
                                try {
                                    if (this.mjFkc == mjFkc.MiMN && mjFkc.ETF) {
                                        boolean unused6 = mjFkc.qdMbNW = false;
                                    }
                                } finally {
                                }
                            }
                        } finally {
                        }
                    }
                } catch (Throwable th3) {
                    synchronized (mjFkc.mjFkc) {
                        try {
                            if (this.mjFkc == mjFkc.MiMN && mjFkc.ETF) {
                                boolean unused7 = mjFkc.qdMbNW = false;
                            }
                            throw th3;
                        } finally {
                        }
                    }
                }
            }
        }
    }

    public interface qGY {
        void AZxh();

        void mjFkc(String str);

        void wA(String str);
    }

    public class qdMbNW implements Callable {
        public final /* synthetic */ AdbSession mjFkc;

        public qdMbNW(AdbSession adbSession) {
            this.mjFkc = adbSession;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public String call() {
            AdbShellResult adbShellResultSwgkN = mjFkc.SwgkN(this.mjFkc, "id");
            return (adbShellResultSwgkN == null || adbShellResultSwgkN.getOutput() == null) ? BuildConfig.FLAVOR : adbShellResultSwgkN.getOutput().trim();
        }
    }

    public class rkYL implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (com.jc.code.v3.AZxh.KLFTb()) {
                return;
            }
            if (com.jc.code.v3.AZxh.mjFkc()) {
                mjFkc.tQ(mjFkc.MiMN, "已切换到本地 ADB 模式（断网 / 关无线调试后仍可用）");
            } else {
                mjFkc.jm("本地 ADB runner 启动失败，本次只能用无线调试会话");
            }
        }
    }

    public class wA implements IEE {
        public final /* synthetic */ File AZxh;
        public final /* synthetic */ boolean mjFkc;

        public wA(boolean z, File file) {
            this.mjFkc = z;
            this.AZxh = file;
        }

        @Override // com.jc.code.v3.mjFkc.IEE
        public String mjFkc(AdbSession adbSession) throws Exception {
            mjFkc.cMLeY(mjFkc.oCFDzJ(adbSession), "install", new Class[]{File.class, String[].class}, new Object[]{this.AZxh, this.mjFkc ? new String[]{"-r", "-d"} : new String[]{"-r"}});
            return "Success";
        }
    }

    public class xJ implements Function2 {
        public final /* synthetic */ String AZxh;
        public final /* synthetic */ AdbSession mjFkc;

        public xJ(AdbSession adbSession, String str) {
            this.mjFkc = adbSession;
            this.AZxh = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return this.mjFkc.shell(this.AZxh, continuation);
        }
    }

    public static void ANMGZc(Context context, String str, qGY qgy) {
        if (Build.VERSION.SDK_INT < 30) {
            if (qgy != null) {
                qgy.wA("无线调试自动配对需要 Android 11 及以上");
                return;
            }
            return;
        }
        xJ = context.getApplicationContext();
        synchronized (mjFkc) {
            try {
                ZfxDd = qgy;
                if (qdMbNW) {
                    return;
                }
                lgHUyS = str;
                wA.clear();
                qdMbNW = true;
                ETF = false;
                VA = false;
                int i = MiMN + 1;
                MiMN = i;
                new Thread(new RunnableC0038mjFkc(i, str, context), "jc-adb-pair").start();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void BAnRFn() {
        ZfxDd = null;
    }

    public static String CqaNbM() {
        return lgHUyS;
    }

    public static AdbSession GMIER(AdbPairing adbPairing) {
        AdbSession adbSessionWJVbdd = wJVbdd();
        return adbSessionWJVbdd != null ? adbSessionWJVbdd : KRTLGT(adbPairing);
    }

    public static AdbSessionConfig Gd() {
        return new AdbSessionConfig.Builder().identityName("JC Code V3").deviceName("JC Code V3").certificateSubject("CN=JC Code V3").handshakeTimeoutMs(120000L).build();
    }

    public static Object HGpJ(Object obj, Method method, Object... objArr) {
        return BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new VA(objArr, method, obj));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:8|34|9|(2:(0)(1:43)|30)(5:36|14|(1:20)(1:18)|21|(1:23)(4:24|25|41|26))|38|12|45|30|6) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean IVlxe(int i, AdbPairing adbPairing) {
        AdbSession adbSessionWJVbdd;
        if (OjSQV(lgHUyS) == null) {
            return false;
        }
        for (int i2 = 0; i2 < 2; i2++) {
            AdbSession adbSession = null;
            try {
                tQ(i, "检查已有配对是否可用...");
                adbSessionWJVbdd = wJVbdd();
            } catch (Throwable unused) {
            }
            if (adbSessionWJVbdd == null) {
                if (adbSessionWJVbdd != null) {
                }
            } else {
                try {
                    AdbShellResult adbShellResultSwgkN = SwgkN(adbSessionWJVbdd, "id");
                    String strTrim = (adbShellResultSwgkN == null || adbShellResultSwgkN.getOutput() == null) ? BuildConfig.FLAVOR : adbShellResultSwgkN.getOutput().trim();
                    if (strTrim.contains("uid=2000")) {
                        tQ(i, "已有配对仍然有效，复用连接: " + strTrim);
                        yfx(adbSessionWJVbdd);
                        JrJO(i);
                        alEkx();
                        return true;
                    }
                } catch (Throwable unused2) {
                    adbSession = adbSessionWJVbdd;
                    if (adbSession != null) {
                        adbSession.close();
                    }
                }
            }
            adbSessionWJVbdd.close();
        }
        return false;
    }

    public static String JBhc(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("命令为空");
        }
        return WGXroI(new YoKzxo(str), DurationKt.MILLIS_IN_MINUTE);
    }

    public static void JYgkl(int i, String str) {
        synchronized (mjFkc) {
            if (i == MiMN && !ETF) {
                ETF = true;
                qdMbNW = false;
                Dt = false;
                qGY qgy = ZfxDd;
                if (qgy != null) {
                    qgy.wA(str);
                }
            }
        }
    }

    public static Integer JYn(String str) throws InterruptedException, IOException {
        try {
            Process processExec = Runtime.getRuntime().exec(new String[]{"getprop", str});
            String line = new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine();
            processExec.waitFor(2L, TimeUnit.SECONDS);
            if (line == null || line.trim().length() <= 0) {
                return null;
            }
            return Integer.valueOf(line.trim());
        } catch (Exception unused) {
            return null;
        }
    }

    public static void JrJO(int i) {
        synchronized (mjFkc) {
            if (i == MiMN && !ETF) {
                ETF = true;
                Dt = true;
                qdMbNW = false;
                qGY qgy = ZfxDd;
                if (qgy != null) {
                    qgy.AZxh();
                }
            }
        }
    }

    public static void KLMXS(Context context, String str) {
        if (context != null) {
            xJ = context.getApplicationContext();
        }
        synchronized (mjFkc) {
            try {
                if (!qdMbNW && KLFTb == null && JHa == null && str != null && str.length() > 0) {
                    lgHUyS = str;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static AdbSession KRTLGT(AdbPairing adbPairing) {
        AdbSession adbSession = (AdbSession) huTpC(20000L, "ADB 会话验证", new Dt(adbPairing));
        if (adbSession != null) {
            return adbSession;
        }
        throw new IllegalStateException("openSession 返回 null");
    }

    public static String Moer(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("包名为空");
        }
        if (com.jc.code.v3.AZxh.KLFTb()) {
            try {
                String strBbzow = bbzow("pm uninstall '" + str + "' 2>&1");
                if (strBbzow != null && strBbzow.toLowerCase().contains("success")) {
                    return strBbzow.trim();
                }
            } catch (Throwable th) {
                tQ(MiMN, "本地 pm uninstall 失败，回退 ADB 会话卸载: " + th.getMessage());
            }
        }
        return WGXroI(new ZfxDd(str), DurationKt.MILLIS_IN_MINUTE);
    }

    public static boolean NPj() {
        return Dt;
    }

    public static Method Ne(Class cls, String str, int i) throws SecurityException {
        for (Method method : cls.getDeclaredMethods()) {
            if (method.getName().equals(str) && method.getParameterTypes().length == i + 1) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    public static Object OjSQV(String str) {
        try {
            IdentityStore.Companion companion = IdentityStore.INSTANCE;
            Object objNewInstance = IdentityStore.class.getConstructor(Context.class, String.class).newInstance(xJ, str);
            Object objInvoke = IdentityStore.class.getMethod("load", null).invoke(objNewInstance, null);
            if (objInvoke == null && (objInvoke = nxI(KeyPair.class)) != null) {
                IdentityStore.class.getMethod("save", KeyPair.class).invoke(objNewInstance, objInvoke);
            }
            if (objInvoke != null) {
                Ucbh(objInvoke);
            }
            return objInvoke;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void SmIWf(int i, AdbPairing adbPairing) {
        AdbSession adbSession = null;
        try {
            tQ(i, "正在打开 ADB 会话验证...");
            AdbSession adbSessionGMIER = null;
            for (int i2 = 0; i2 < 2 && adbSessionGMIER == null; i2++) {
                if (i2 > 0) {
                    try {
                        tQ(i, "ADB 会话建立失败，2 秒后重试...");
                        try {
                            Thread.sleep(2000L);
                        } catch (InterruptedException unused) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        adbSession = adbSessionGMIER;
                        try {
                            JYgkl(i, "ADB 连接验证失败: " + th.getMessage());
                            if (adbSession != null) {
                                try {
                                    adbSession.close();
                                } catch (Exception unused2) {
                                }
                            }
                            synchronized (mjFkc) {
                                try {
                                    if (i == MiMN) {
                                        qdMbNW = false;
                                    }
                                } finally {
                                }
                            }
                            return;
                        } catch (Throwable th2) {
                            if (adbSession != null) {
                                try {
                                    adbSession.close();
                                } catch (Exception unused3) {
                                }
                            }
                            synchronized (mjFkc) {
                                try {
                                    if (i == MiMN) {
                                        qdMbNW = false;
                                    }
                                    throw th2;
                                } finally {
                                }
                            }
                        }
                    }
                }
                try {
                    adbSessionGMIER = GMIER(adbPairing);
                } catch (Exception e) {
                    if (i2 == 1) {
                        throw e;
                    }
                }
            }
            if (adbSessionGMIER == null) {
                throw new IllegalStateException("无法建立 ADB 会话");
            }
            String str = (String) huTpC(DurationKt.MILLIS_IN_MINUTE, "ADB Shell 验证", new qdMbNW(adbSessionGMIER));
            if (!str.contains("uid=2000")) {
                throw new IllegalStateException("ADB Shell 未返回 uid=2000: " + str);
            }
            tQ(i, "ADB Shell 已连接: " + str);
            yfx(adbSessionGMIER);
            JrJO(i);
            alEkx();
            synchronized (mjFkc) {
                try {
                    if (i == MiMN) {
                        qdMbNW = false;
                    }
                } finally {
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static AdbShellResult SwgkN(AdbSession adbSession, String str) {
        AdbShellResult adbShellResult = (AdbShellResult) BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new xJ(adbSession, str));
        if (adbShellResult != null) {
            return adbShellResult;
        }
        throw new IllegalStateException("ADB Shell 无返回");
    }

    public static void Ucbh(Object obj) {
        try {
            xJ.getSharedPreferences("jc_adb_identity_backup", 0).edit().putString("priv", Base64.encodeToString(((PrivateKey) obj.getClass().getMethod("getPrivateKey", null).invoke(obj, null)).getEncoded(), 16)).putString("cert", Base64.encodeToString(((Certificate) obj.getClass().getMethod("getCertificate", null).invoke(obj, null)).getEncoded(), 16)).apply();
        } catch (Throwable unused) {
        }
    }

    public static boolean Vdz(Exception exc) {
        if (exc instanceof IOException) {
            return true;
        }
        String name = exc.getClass().getName();
        return name.contains("AdbStreamClosed") || name.contains("AdbTimeout") || name.contains("AdbAuthentication") || name.contains("AdbNotPaired");
    }

    public static boolean Vnb(AdbSession adbSession) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objOCFDzJ = oCFDzJ(adbSession);
            return Boolean.TRUE.equals(objOCFDzJ.getClass().getMethod("connectionCheck", null).invoke(objOCFDzJ, null));
        } catch (Exception unused) {
            return false;
        }
    }

    public static List VocHEe() throws SocketException {
        String hostAddress;
        ArrayList arrayList = new ArrayList();
        arrayList.add("127.0.0.1");
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null) {
                if (!networkInterfaces.hasMoreElements()) {
                    break;
                }
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if ((inetAddressNextElement instanceof Inet4Address) && !inetAddressNextElement.isLoopbackAddress() && (hostAddress = inetAddressNextElement.getHostAddress()) != null && !arrayList.contains(hostAddress)) {
                        arrayList.add(hostAddress);
                    }
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static String WGXroI(IEE iee, long j) {
        String str;
        synchronized (AZxh) {
            Exception e = null;
            for (int i = 0; i < 2; i++) {
                try {
                    str = (String) huTpC(j, "ADB 操作", new JHa(iee, (AdbSession) huTpC(30000L, "ADB 会话建立", new KLFTb())));
                } catch (Exception e2) {
                    e = e2;
                    try {
                        lB();
                        if (!Vdz(e)) {
                            break;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (e != null) {
                throw e;
            }
            throw new IllegalStateException("ADB 操作失败");
        }
        return str;
    }

    public static AdbSession WrLQs(long j) {
        AdbPairing adbPairing;
        Object obj = mjFkc;
        synchronized (obj) {
            try {
                AdbSession adbSession = JHa;
                if (adbSession != null) {
                    return adbSession;
                }
                synchronized (obj) {
                    try {
                        if (KLFTb == null) {
                            if (xJ == null) {
                                throw new IllegalStateException("ADB 未初始化");
                            }
                            KLFTb = AdbPairing.INSTANCE.get(xJ, lgHUyS, Gd(), GlobalScope.INSTANCE);
                        }
                        adbPairing = KLFTb;
                    } finally {
                    }
                }
                AdbSession adbSessionGMIER = GMIER(adbPairing);
                if (adbSessionGMIER == null) {
                    throw new IllegalStateException("无法建立 ADB 会话");
                }
                synchronized (obj) {
                    AdbSession adbSession2 = JHa;
                    if (adbSession2 == null) {
                        JHa = adbSessionGMIER;
                        return adbSessionGMIER;
                    }
                    if (adbSession2 != adbSessionGMIER) {
                        try {
                            adbSessionGMIER.close();
                        } catch (Exception unused) {
                        }
                    }
                    return adbSession2;
                }
            } finally {
            }
        }
    }

    public static void XV(fehf fehfVar) {
        YoKzxo = fehfVar;
    }

    public static void alEkx() {
        new Thread(new rkYL(), "jc-local-adb").start();
    }

    public static List aqHPIZ() throws Throwable {
        int iLastIndexOf;
        int i;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        String[] strArr = {"/proc/net/tcp", "/proc/net/tcp6"};
        for (int i2 = 0; i2 < 2; i2++) {
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(strArr[i2]));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line != null) {
                            String[] strArrSplit = line.trim().split("\\s+");
                            if (strArrSplit.length >= 4 && "0A".equals(strArrSplit[3]) && (iLastIndexOf = strArrSplit[1].lastIndexOf(58)) >= 0 && (i = Integer.parseInt(strArrSplit[1].substring(iLastIndexOf + 1), 16)) > 0) {
                                linkedHashSet.add(Integer.valueOf(i));
                            }
                        } else {
                            try {
                                break;
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused3) {
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
            } catch (Exception unused4) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return new ArrayList(linkedHashSet);
    }

    public static String bbzow(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("命令为空");
        }
        if (com.jc.code.v3.AZxh.KLFTb()) {
            try {
                return com.jc.code.v3.AZxh.wA(str, DurationKt.MILLIS_IN_MINUTE);
            } catch (AZxh.mjFkc e) {
                com.jc.code.v3.AZxh.JHa();
                tQ(MiMN, "本地 ADB 通道失效，回退无线调试会话: " + e.getMessage());
            }
        }
        return JBhc(str);
    }

    public static void cMLeY(Object obj, String str, Class[] clsArr, Object[] objArr) throws Exception {
        Method method = obj.getClass().getMethod(str, clsArr);
        method.setAccessible(true);
        try {
            method.invoke(obj, objArr);
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Exception) {
                throw ((Exception) cause);
            }
            if (!(cause instanceof Error)) {
                throw e;
            }
            throw ((Error) cause);
        }
    }

    public static void dm(int i, AdbPairing adbPairing) {
        synchronized (mjFkc) {
            if (i == MiMN && !ETF && !VA) {
                VA = true;
                new Thread(new lgHUyS(i, adbPairing), "jc-adb-verify").start();
            }
        }
    }

    public static Object huTpC(long j, String str, Callable callable) throws Exception {
        Object[] objArr = new Object[2];
        Thread thread = new Thread(new MiMN(objArr, callable), "jc-adb-op");
        thread.setDaemon(true);
        thread.start();
        thread.join(j);
        if (thread.isAlive()) {
            throw new IllegalStateException(str + "超时（" + j + "ms）");
        }
        Throwable th = (Throwable) objArr[1];
        if (th == null) {
            return objArr[0];
        }
        if (th instanceof Exception) {
            throw ((Exception) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        throw new IllegalStateException(th);
    }

    public static void jm(String str) {
        fehf fehfVar = YoKzxo;
        if (fehfVar != null) {
            fehfVar.mjFkc(str);
        } else {
            Log.i("AdbBridge", str);
        }
    }

    public static void lB() {
        AdbSession adbSession;
        synchronized (mjFkc) {
            adbSession = JHa;
            JHa = null;
        }
        if (adbSession != null) {
            try {
                adbSession.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void mByQ(String str) {
        try {
            xJ.getSharedPreferences("jc_adb_identity_backup", 0).edit().clear().apply();
        } catch (Throwable unused) {
        }
        try {
            xJ.deleteSharedPreferences("adbeesh_identity_" + str);
        } catch (Throwable unused2) {
        }
    }

    public static Object nxI(Class cls) {
        try {
            SharedPreferences sharedPreferences = xJ.getSharedPreferences("jc_adb_identity_backup", 0);
            String string = sharedPreferences.getString("priv", null);
            String string2 = sharedPreferences.getString("cert", null);
            if (string != null && string2 != null) {
                return cls.getConstructor(PrivateKey.class, X509Certificate.class).newInstance(KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(string, 16))), CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(Base64.decode(string2, 16))));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static Object oCFDzJ(AdbSession adbSession) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method method = adbSession.getClass().getMethod("getKadb", null);
        method.setAccessible(true);
        Object objInvoke = method.invoke(adbSession, null);
        if (objInvoke != null) {
            return objInvoke;
        }
        throw new IllegalStateException("ADB 会话为空");
    }

    public static boolean rWxwaT(int i) {
        boolean z;
        synchronized (mjFkc) {
            z = i == MiMN;
        }
        return z;
    }

    public static void tQ(int i, String str) {
        jm(str);
        synchronized (mjFkc) {
            try {
                if (i != MiMN) {
                    return;
                }
                qGY qgy = ZfxDd;
                if (qgy != null) {
                    qgy.mjFkc(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean uHVRx() {
        if (com.jc.code.v3.AZxh.KLFTb()) {
            try {
                String strWA = com.jc.code.v3.AZxh.wA("id", 5000L);
                if (strWA != null) {
                    if (strWA.contains("uid=2000")) {
                        return true;
                    }
                }
            } catch (AZxh.mjFkc unused) {
                com.jc.code.v3.AZxh.JHa();
            } catch (Throwable unused2) {
            }
        }
        if (!com.jc.code.v3.AZxh.KLFTb() && (Dt || xrEuO())) {
            alEkx();
        }
        if (!Dt && !xrEuO()) {
            return false;
        }
        try {
            String str = (String) huTpC(8000L, "ADB 通道探测", new AZxh());
            if (str != null) {
                if (str.contains("uid=2000")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused3) {
            return false;
        }
    }

    public static void vI() {
        AdbPairing adbPairing;
        synchronized (mjFkc) {
            qdMbNW = false;
            ETF = true;
            Dt = false;
            MiMN++;
            adbPairing = KLFTb;
            KLFTb = null;
        }
        wA.clear();
        if (adbPairing != null) {
            try {
                adbPairing.close();
            } catch (Exception unused) {
            }
        }
        lB();
    }

    public static boolean vadzgd() {
        return qdMbNW;
    }

    public static void vjlshU(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        wA.offer(str);
    }

    public static AdbSession wJVbdd() {
        Object objOjSQV;
        try {
        } catch (Throwable th) {
            tQ(MiMN, "ADB 直连异常: " + th.getMessage());
        }
        if (xJ == null || (objOjSQV = OjSQV(lgHUyS)) == null) {
            return null;
        }
        AdbClient.Companion companion = AdbClient.INSTANCE;
        Object objNewInstance = AdbClient.class.getConstructor(KeyPair.class, String.class).newInstance(objOjSQV, "JC Code V3");
        Method methodNe = Ne(AdbClient.class, "connect", 2);
        if (methodNe == null) {
            return null;
        }
        List listVocHEe = VocHEe();
        List listAqHPIZ = aqHPIZ();
        Integer numJYn = JYn("service.adb.tls.port");
        if (numJYn != null && !listAqHPIZ.contains(numJYn)) {
            listAqHPIZ.add(0, numJYn);
        }
        Integer numJYn2 = JYn("service.adb.tcp.port");
        if (numJYn2 != null && !listAqHPIZ.contains(numJYn2)) {
            listAqHPIZ.add(numJYn2);
        }
        Throwable th2 = null;
        for (int i = 0; i < listVocHEe.size(); i++) {
            for (int i2 = 0; i2 < listAqHPIZ.size(); i2++) {
                String str = (String) listVocHEe.get(i);
                int iIntValue = ((Integer) listAqHPIZ.get(i2)).intValue();
                if (xROA(str, iIntValue)) {
                    try {
                        Object objHuTpC = huTpC(8000L, "ADB 直连 " + str + ":" + iIntValue, new ETF(objNewInstance, methodNe, str, iIntValue));
                        if (objHuTpC != null) {
                            Kadb.Companion companion2 = Kadb.INSTANCE;
                            return (AdbSession) AdbSessionImpl.class.getConstructor(Kadb.class).newInstance(objHuTpC);
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                    }
                }
            }
        }
        int i3 = MiMN;
        StringBuilder sb = new StringBuilder();
        sb.append("ADB 直连未成功");
        sb.append(th2 != null ? "（" + th2.getMessage() + "）" : "（未发现可用 adbd 端口）");
        tQ(i3, sb.toString());
        return null;
    }

    public static boolean xROA(String str, int i) throws IOException {
        Socket socket = new Socket();
        try {
            try {
                socket.connect(new InetSocketAddress(str, i), 400);
                try {
                    socket.close();
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            } catch (Exception unused2) {
                return false;
            }
        } catch (Exception unused3) {
            socket.close();
            return false;
        } catch (Throwable th) {
            try {
                socket.close();
            } catch (Exception unused4) {
            }
            throw th;
        }
    }

    public static boolean xrEuO() {
        boolean z;
        synchronized (mjFkc) {
            z = JHa != null;
        }
        return z;
    }

    public static void yfx(AdbSession adbSession) {
        AdbSession adbSession2;
        synchronized (mjFkc) {
            adbSession2 = JHa;
            JHa = adbSession;
        }
        if (adbSession2 == null || adbSession2 == adbSession) {
            return;
        }
        try {
            adbSession2.close();
        } catch (Exception unused) {
        }
    }

    public static String zvd(File file, boolean z) {
        if (file == null || !file.exists()) {
            throw new IllegalStateException("安装包不存在");
        }
        String absolutePath = file.getAbsolutePath();
        boolean z2 = com.jc.code.v3.AZxh.KLFTb() && (absolutePath.startsWith("/storage/") || absolutePath.startsWith("/sdcard/"));
        if (z2) {
            Context context = xJ;
            String str = context != null ? context.getApplicationInfo().sourceDir : null;
            if (str != null) {
                jm("安装通道①：app_process 安装代理（PackageInstaller 会话 API）");
                try {
                    String strBbzow = bbzow("CLASSPATH='" + str + "' app_process /system/bin com.jc.code.v3.InstallAgent '" + absolutePath + "' 2>&1");
                    if (strBbzow != null && strBbzow.contains("INSTALL_AGENT_OK")) {
                        jm("安装代理成功: " + strBbzow.trim().replace("\n", " | "));
                        return "Success";
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("安装代理未成功: ");
                    sb.append(strBbzow != null ? strBbzow.trim().replace("\n", " | ") : "(空)");
                    jm(sb.toString());
                } catch (Throwable th) {
                    jm("安装代理异常: " + th.getMessage() + "，走下一通道");
                }
            }
        }
        if (z2) {
            jm("安装通道②：本地 ADB runner → pm install -r " + absolutePath);
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("pm install -r ");
                sb2.append(z ? "-d " : BuildConfig.FLAVOR);
                sb2.append("'");
                sb2.append(absolutePath);
                sb2.append("' 2>&1");
                String strBbzow2 = bbzow(sb2.toString());
                if (strBbzow2 != null && strBbzow2.toLowerCase().contains("success")) {
                    jm("本地 pm install 成功: " + strBbzow2.trim());
                    return strBbzow2.trim();
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("本地 pm install 未成功，输出: ");
                sb3.append(strBbzow2 != null ? strBbzow2.trim() : "(空)");
                sb3.append("，回退无线会话");
                jm(sb3.toString());
            } catch (Throwable th2) {
                jm("本地 pm install 异常: " + th2.getMessage() + "，回退无线会话");
            }
        } else {
            jm("本地 runner 不可用(" + com.jc.code.v3.AZxh.KLFTb() + ")，跳过本地通道");
        }
        jm("安装通道③：无线调试会话 kadb install（本地回环推包）");
        return WGXroI(new wA(z, file), 180000L);
    }
}
