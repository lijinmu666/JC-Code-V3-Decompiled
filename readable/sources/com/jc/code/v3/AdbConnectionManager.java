package com.jc.code.v3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Base64;
import android.util.Log;
import com.flyfishxu.p028kadb.C0187Kadb;
import com.indidevs.p086android.p087adbeesh.internal.connection.AdbClient;
import com.indidevs.p086android.p087adbeesh.internal.connection.AdbSessionImpl;
import com.indidevs.p086android.p087adbeesh.internal.security.IdentityStore;
import com.indidevs.p086android.p087adbeesh.internal.security.KeyPair;
import com.indidevs.p086android.p087adbeesh.p088config.AdbSessionConfig;
import com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairing;
import com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingCallback;
import com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingCodeProvider;
import com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingWorkflow;
import com.indidevs.p086android.p087adbeesh.p090runtime.AdbSession;
import com.indidevs.p086android.p087adbeesh.p090runtime.AdbShellResult;
import com.jc.code.v3.LocalAdbBridge;
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
import org.conscrypt.BuildConfig;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.EmptyCoroutineContext;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p119time.DurationKt;
import p122kotlinx.coroutines.BuildersKt;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.GlobalScope;

/* renamed from: com.jc.code.v3.mjFkc */
/* loaded from: classes.dex */
public abstract class AdbConnectionManager {

    /* renamed from: JHa */
    public static AdbSession f4832JHa;

    /* renamed from: KLFTb */
    public static AdbPairing f4833KLFTb;

    /* renamed from: YoKzxo */
    public static volatile fehf f4836YoKzxo;

    /* renamed from: ZfxDd */
    public static qGY f4837ZfxDd;

    /* renamed from: xJ */
    public static Context f4842xJ;

    /* renamed from: mjFkc */
    public static final Object f4839mjFkc = new Object();

    /* renamed from: AZxh */
    public static final Object f4829AZxh = new Object();

    /* renamed from: wA */
    public static final LinkedBlockingQueue f4841wA = new LinkedBlockingQueue();

    /* renamed from: lgHUyS */
    public static String f4838lgHUyS = "jc_code_v3";

    /* renamed from: qdMbNW */
    public static volatile boolean f4840qdMbNW = false;

    /* renamed from: Dt */
    public static volatile boolean f4830Dt = false;

    /* renamed from: ETF */
    public static volatile boolean f4831ETF = false;

    /* renamed from: VA */
    public static volatile boolean f4835VA = false;

    /* renamed from: MiMN */
    public static int f4834MiMN = 0;

    /* renamed from: com.jc.code.v3.mjFkc$AZxh */
    public class AZxh implements Callable {
        @Override // java.util.concurrent.Callable
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public String call() {
            return AdbConnectionManager.m4892JBhc("id");
        }
    }

    /* renamed from: com.jc.code.v3.mjFkc$Dt */
    public class Dt implements Callable {

        /* renamed from: mjFkc */
        public final /* synthetic */ AdbPairing f4843mjFkc;

        /* renamed from: com.jc.code.v3.mjFkc$Dt$mjFkc */
        public class mjFkc implements Function2 {
            public mjFkc() {
            }

            @Override // p094kotlin.p105jvm.functions.Function2
            /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
            public Object mo2167invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return Dt.this.f4843mjFkc.openSession(15000L, continuation);
            }
        }

        public Dt(AdbPairing adbPairing) {
            this.f4843mjFkc = adbPairing;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public AdbSession call() {
            return (AdbSession) BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new mjFkc());
        }
    }

    /* renamed from: com.jc.code.v3.mjFkc$ETF */
    public class ETF implements Callable {

        /* renamed from: AZxh */
        public final /* synthetic */ Method f4845AZxh;

        /* renamed from: ZfxDd */
        public final /* synthetic */ int f4846ZfxDd;

        /* renamed from: mjFkc */
        public final /* synthetic */ Object f4847mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ String f4848wA;

        public ETF(Object obj, Method method, String str, int i) {
            this.f4847mjFkc = obj;
            this.f4845AZxh = method;
            this.f4848wA = str;
            this.f4846ZfxDd = i;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return AdbConnectionManager.m4889HGpJ(this.f4847mjFkc, this.f4845AZxh, this.f4848wA, Integer.valueOf(this.f4846ZfxDd));
        }
    }

    /* renamed from: com.jc.code.v3.mjFkc$IEE */
    public interface IEE {
        /* renamed from: mjFkc */
        String mo4953mjFkc(AdbSession adbSession);
    }

    /* renamed from: com.jc.code.v3.mjFkc$JHa */
    public class JHa implements Callable {

        /* renamed from: AZxh */
        public final /* synthetic */ AdbSession f4849AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ IEE f4850mjFkc;

        public JHa(IEE iee, AdbSession adbSession) {
            this.f4850mjFkc = iee;
            this.f4849AZxh = adbSession;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public String call() {
            return this.f4850mjFkc.mo4953mjFkc(this.f4849AZxh);
        }
    }

    /* renamed from: com.jc.code.v3.mjFkc$KLFTb */
    public class KLFTb implements Callable {
        @Override // java.util.concurrent.Callable
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public AdbSession call() {
            AdbSession adbSessionM4914WrLQs = AdbConnectionManager.m4914WrLQs(15000L);
            if (AdbConnectionManager.m4911Vnb(adbSessionM4914WrLQs)) {
                return adbSessionM4914WrLQs;
            }
            AdbConnectionManager.m4928lB();
            return AdbConnectionManager.m4914WrLQs(15000L);
        }
    }

    /* renamed from: com.jc.code.v3.mjFkc$MiMN */
    public class MiMN implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ Callable f4851AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ Object[] f4852mjFkc;

        public MiMN(Object[] objArr, Callable callable) {
            this.f4852mjFkc = objArr;
            this.f4851AZxh = callable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f4852mjFkc[0] = this.f4851AZxh.call();
            } catch (Throwable th) {
                this.f4852mjFkc[1] = th;
            }
        }
    }

    /* renamed from: com.jc.code.v3.mjFkc$VA */
    public class VA implements Function2 {

        /* renamed from: AZxh */
        public final /* synthetic */ Method f4853AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ Object[] f4854mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ Object f4855wA;

        public VA(Object[] objArr, Method method, Object obj) {
            this.f4854mjFkc = objArr;
            this.f4853AZxh = method;
            this.f4855wA = obj;
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public Object mo2167invoke(CoroutineScope coroutineScope, Continuation continuation) {
            Object[] objArr = this.f4854mjFkc;
            Object[] objArr2 = new Object[objArr.length + 1];
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
            objArr2[this.f4854mjFkc.length] = continuation;
            try {
                return this.f4853AZxh.invoke(this.f4855wA, objArr2);
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

    /* renamed from: com.jc.code.v3.mjFkc$YoKzxo */
    public class YoKzxo implements IEE {

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4856mjFkc;

        public YoKzxo(String str) {
            this.f4856mjFkc = str;
        }

        @Override // com.jc.code.v3.AdbConnectionManager.IEE
        /* renamed from: mjFkc */
        public String mo4953mjFkc(AdbSession adbSession) {
            AdbShellResult adbShellResultM4907SwgkN = AdbConnectionManager.m4907SwgkN(adbSession, this.f4856mjFkc);
            String output = adbShellResultM4907SwgkN.getOutput();
            boolean zIsSuccess = adbShellResultM4907SwgkN.isSuccess();
            String strTrim = BuildConfig.f24315FLAVOR;
            if (zIsSuccess) {
                return output != null ? output : BuildConfig.f24315FLAVOR;
            }
            String error = adbShellResultM4907SwgkN.getError();
            if (error != null && error.trim().length() > 0) {
                strTrim = error.trim();
            } else if (output != null) {
                strTrim = output.trim();
            }
            if (strTrim.length() <= 0) {
                strTrim = "退出码 " + adbShellResultM4907SwgkN.getExitCode();
            }
            throw new IllegalStateException(strTrim);
        }
    }

    /* renamed from: com.jc.code.v3.mjFkc$ZfxDd */
    public class ZfxDd implements IEE {

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4857mjFkc;

        public ZfxDd(String str) {
            this.f4857mjFkc = str;
        }

        @Override // com.jc.code.v3.AdbConnectionManager.IEE
        /* renamed from: mjFkc */
        public String mo4953mjFkc(AdbSession adbSession) throws Exception {
            AdbConnectionManager.m4921cMLeY(AdbConnectionManager.m4933oCFDzJ(adbSession), "uninstall", new Class[]{String.class}, new Object[]{this.f4857mjFkc});
            return "Success";
        }
    }

    /* renamed from: com.jc.code.v3.mjFkc$fehf */
    public interface fehf {
        /* renamed from: mjFkc */
        void mo4868mjFkc(String str);
    }

    /* renamed from: com.jc.code.v3.mjFkc$lgHUyS */
    public class lgHUyS implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ AdbPairing f4858AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ int f4859mjFkc;

        public lgHUyS(int i, AdbPairing adbPairing) {
            this.f4859mjFkc = i;
            this.f4858AZxh = adbPairing;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdbConnectionManager.m4906SmIWf(this.f4859mjFkc, this.f4858AZxh);
        }
    }

    /* renamed from: com.jc.code.v3.mjFkc$mjFkc */
    public class mjFkc implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ String f4860AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ int f4861mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ Context f4862wA;

        /* renamed from: com.jc.code.v3.mjFkc$mjFkc$AZxh */
        public class AZxh implements AdbPairingCodeProvider {
            public AZxh() {
            }

            @Override // com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingCodeProvider
            public Object provideCode(String str, int i, Continuation continuation) {
                try {
                    AdbConnectionManager.m4938tQ(mjFkc.this.f4861mjFkc, "已找到配对端口 " + i + "，等待配对码...");
                    return AdbConnectionManager.f4841wA.poll(180000L, TimeUnit.MILLISECONDS);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
        }

        /* renamed from: com.jc.code.v3.mjFkc$mjFkc$mjFkc, reason: collision with other inner class name */
        public class C6353mjFkc implements AdbPairingCallback {

            /* renamed from: mjFkc */
            public final /* synthetic */ AdbPairing f4865mjFkc;

            public C6353mjFkc(AdbPairing adbPairing) {
                this.f4865mjFkc = adbPairing;
            }

            @Override // com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingCallback
            public void onPairingError(String str, String str2) {
                AdbConnectionManager.m4894JYgkl(mjFkc.this.f4861mjFkc, "配对失败: " + str2);
            }

            @Override // com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingCallback
            public void onPairingHandshakeStarted(String str) {
                AdbConnectionManager.m4938tQ(mjFkc.this.f4861mjFkc, "正在与设备配对...");
            }

            @Override // com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingCallback
            public void onPairingStarted(String str) {
                AdbConnectionManager.m4938tQ(mjFkc.this.f4861mjFkc, "正在搜索无线调试配对服务...");
            }

            @Override // com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingCallback
            public void onPairingSuccess(String str) {
                AdbConnectionManager.m4938tQ(mjFkc.this.f4861mjFkc, "配对握手成功，正在验证 ADB 连接...");
                AdbConnectionManager.m4923dm(mjFkc.this.f4861mjFkc, this.f4865mjFkc);
            }

            @Override // com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingCallback
            public void onPortFound(String str, int i) {
                AdbConnectionManager.m4938tQ(mjFkc.this.f4861mjFkc, "找到配对端口 " + i);
            }
        }

        /* renamed from: com.jc.code.v3.mjFkc$mjFkc$wA */
        public class wA implements Function2 {

            /* renamed from: AZxh */
            public final /* synthetic */ AdbPairingWorkflow f4866AZxh;

            /* renamed from: mjFkc */
            public final /* synthetic */ AdbPairing f4867mjFkc;

            public wA(AdbPairing adbPairing, AdbPairingWorkflow adbPairingWorkflow) {
                this.f4867mjFkc = adbPairing;
                this.f4866AZxh = adbPairingWorkflow;
            }

            @Override // p094kotlin.p105jvm.functions.Function2
            /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
            public Object mo2167invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return this.f4867mjFkc.ensurePaired(this.f4866AZxh, continuation);
            }
        }

        public mjFkc(int i, String str, Context context) {
            this.f4861mjFkc = i;
            this.f4860AZxh = str;
            this.f4862wA = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AdbSessionConfig adbSessionConfigM4888Gd = AdbConnectionManager.m4888Gd();
                AdbConnectionManager.m4938tQ(this.f4861mjFkc, "开始配对流程（身份 " + this.f4860AZxh + "）");
                AdbPairing adbPairingM4356get = AdbPairing.INSTANCE.m4356get(this.f4862wA, this.f4860AZxh, adbSessionConfigM4888Gd, GlobalScope.INSTANCE);
                synchronized (AdbConnectionManager.f4839mjFkc) {
                    AdbPairing unused = AdbConnectionManager.f4833KLFTb = adbPairingM4356get;
                }
                if (AdbConnectionManager.m4891IVlxe(this.f4861mjFkc, adbPairingM4356get)) {
                    synchronized (AdbConnectionManager.f4839mjFkc) {
                        try {
                            if (this.f4861mjFkc == AdbConnectionManager.f4834MiMN && AdbConnectionManager.f4831ETF) {
                                boolean unused2 = AdbConnectionManager.f4840qdMbNW = false;
                            }
                        } finally {
                        }
                    }
                    return;
                }
                AdbConnectionManager.m4930mByQ(this.f4860AZxh);
                AdbConnectionManager.m4938tQ(this.f4861mjFkc, "旧配对已失效，开始全新配对...");
                try {
                    BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new wA(adbPairingM4356get, new AdbPairingWorkflow.C0902Builder().withCodeProvider(new AZxh()).addCallback(new C6353mjFkc(adbPairingM4356get)).m4365build()));
                    AdbConnectionManager.m4938tQ(this.f4861mjFkc, "配对流程返回");
                    AdbConnectionManager.m4923dm(this.f4861mjFkc, adbPairingM4356get);
                    synchronized (AdbConnectionManager.f4839mjFkc) {
                        try {
                            if (this.f4861mjFkc == AdbConnectionManager.f4834MiMN && AdbConnectionManager.f4831ETF) {
                                boolean unused3 = AdbConnectionManager.f4840qdMbNW = false;
                            }
                        } finally {
                        }
                    }
                } catch (Throwable th) {
                    if (AdbConnectionManager.m4936rWxwaT(this.f4861mjFkc) && !AdbConnectionManager.f4831ETF) {
                        AdbConnectionManager.m4894JYgkl(this.f4861mjFkc, "配对流程异常: " + th.getMessage());
                    }
                    synchronized (AdbConnectionManager.f4839mjFkc) {
                        try {
                            if (this.f4861mjFkc == AdbConnectionManager.f4834MiMN && AdbConnectionManager.f4831ETF) {
                                boolean unused4 = AdbConnectionManager.f4840qdMbNW = false;
                            }
                        } finally {
                        }
                    }
                }
            } catch (Throwable th2) {
                try {
                    AdbConnectionManager.m4894JYgkl(this.f4861mjFkc, "自动配对异常: " + th2.getMessage());
                    synchronized (AdbConnectionManager.f4839mjFkc) {
                        try {
                            if (this.f4861mjFkc == AdbConnectionManager.f4834MiMN) {
                                AdbPairing unused5 = AdbConnectionManager.f4833KLFTb = null;
                            }
                            synchronized (AdbConnectionManager.f4839mjFkc) {
                                try {
                                    if (this.f4861mjFkc == AdbConnectionManager.f4834MiMN && AdbConnectionManager.f4831ETF) {
                                        boolean unused6 = AdbConnectionManager.f4840qdMbNW = false;
                                    }
                                } finally {
                                }
                            }
                        } finally {
                        }
                    }
                } catch (Throwable th3) {
                    synchronized (AdbConnectionManager.f4839mjFkc) {
                        try {
                            if (this.f4861mjFkc == AdbConnectionManager.f4834MiMN && AdbConnectionManager.f4831ETF) {
                                boolean unused7 = AdbConnectionManager.f4840qdMbNW = false;
                            }
                            throw th3;
                        } finally {
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.jc.code.v3.mjFkc$qGY */
    public interface qGY {
        /* renamed from: AZxh */
        void mo4871AZxh();

        /* renamed from: mjFkc */
        void mo4872mjFkc(String str);

        /* renamed from: wA */
        void mo4873wA(String str);
    }

    /* renamed from: com.jc.code.v3.mjFkc$qdMbNW */
    public class qdMbNW implements Callable {

        /* renamed from: mjFkc */
        public final /* synthetic */ AdbSession f4869mjFkc;

        public qdMbNW(AdbSession adbSession) {
            this.f4869mjFkc = adbSession;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public String call() {
            AdbShellResult adbShellResultM4907SwgkN = AdbConnectionManager.m4907SwgkN(this.f4869mjFkc, "id");
            return (adbShellResultM4907SwgkN == null || adbShellResultM4907SwgkN.getOutput() == null) ? BuildConfig.f24315FLAVOR : adbShellResultM4907SwgkN.getOutput().trim();
        }
    }

    /* renamed from: com.jc.code.v3.mjFkc$rkYL */
    public class rkYL implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (LocalAdbBridge.isReady()) {
                return;
            }
            if (LocalAdbBridge.ensureRunner()) {
                AdbConnectionManager.m4938tQ(AdbConnectionManager.f4834MiMN, "已切换到本地 ADB 模式（断网 / 关无线调试后仍可用）");
            } else {
                AdbConnectionManager.m4927jm("本地 ADB runner 启动失败，本次只能用无线调试会话");
            }
        }
    }

    /* renamed from: com.jc.code.v3.mjFkc$wA */
    public class wA implements IEE {

        /* renamed from: AZxh */
        public final /* synthetic */ File f4870AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ boolean f4871mjFkc;

        public wA(boolean z, File file) {
            this.f4871mjFkc = z;
            this.f4870AZxh = file;
        }

        @Override // com.jc.code.v3.AdbConnectionManager.IEE
        /* renamed from: mjFkc */
        public String mo4953mjFkc(AdbSession adbSession) throws Exception {
            AdbConnectionManager.m4921cMLeY(AdbConnectionManager.m4933oCFDzJ(adbSession), "install", new Class[]{File.class, String[].class}, new Object[]{this.f4870AZxh, this.f4871mjFkc ? new String[]{"-r", "-d"} : new String[]{"-r"}});
            return "Success";
        }
    }

    /* renamed from: com.jc.code.v3.mjFkc$xJ */
    public class xJ implements Function2 {

        /* renamed from: AZxh */
        public final /* synthetic */ String f4872AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ AdbSession f4873mjFkc;

        public xJ(AdbSession adbSession, String str) {
            this.f4873mjFkc = adbSession;
            this.f4872AZxh = str;
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public Object mo2167invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return this.f4873mjFkc.mo4316shell(this.f4872AZxh, continuation);
        }
    }

    /* renamed from: ANMGZc */
    public static void m4881ANMGZc(Context context, String str, qGY qgy) {
        if (Build.VERSION.SDK_INT < 30) {
            if (qgy != null) {
                qgy.mo4873wA("无线调试自动配对需要 Android 11 及以上");
                return;
            }
            return;
        }
        f4842xJ = context.getApplicationContext();
        synchronized (f4839mjFkc) {
            try {
                f4837ZfxDd = qgy;
                if (f4840qdMbNW) {
                    return;
                }
                f4838lgHUyS = str;
                f4841wA.clear();
                f4840qdMbNW = true;
                f4831ETF = false;
                f4835VA = false;
                int i = f4834MiMN + 1;
                f4834MiMN = i;
                new Thread(new mjFkc(i, str, context), "jc-adb-pair").start();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: BAnRFn */
    public static void m4883BAnRFn() {
        f4837ZfxDd = null;
    }

    /* renamed from: CqaNbM */
    public static String m4884CqaNbM() {
        return f4838lgHUyS;
    }

    /* renamed from: GMIER */
    public static AdbSession m4887GMIER(AdbPairing adbPairing) {
        AdbSession adbSessionM4944wJVbdd = m4944wJVbdd();
        return adbSessionM4944wJVbdd != null ? adbSessionM4944wJVbdd : m4899KRTLGT(adbPairing);
    }

    /* renamed from: Gd */
    public static AdbSessionConfig m4888Gd() {
        return new AdbSessionConfig.C0884Builder().identityName("JC Code V3").deviceName("JC Code V3").certificateSubject("CN=JC Code V3").handshakeTimeoutMs(120000L).m4305build();
    }

    /* renamed from: HGpJ */
    public static Object m4889HGpJ(Object obj, Method method, Object... objArr) {
        return BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new VA(objArr, method, obj));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:8|34|9|(2:(0)(1:43)|30)(5:36|14|(1:20)(1:18)|21|(1:23)(4:24|25|41|26))|38|12|45|30|6) */
    /* renamed from: IVlxe */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m4891IVlxe(int i, AdbPairing adbPairing) {
        AdbSession adbSessionM4944wJVbdd;
        if (m4904OjSQV(f4838lgHUyS) == null) {
            return false;
        }
        for (int i2 = 0; i2 < 2; i2++) {
            AdbSession adbSession = null;
            try {
                m4938tQ(i, "检查已有配对是否可用...");
                adbSessionM4944wJVbdd = m4944wJVbdd();
            } catch (Throwable unused) {
            }
            if (adbSessionM4944wJVbdd == null) {
                if (adbSessionM4944wJVbdd != null) {
                }
            } else {
                try {
                    AdbShellResult adbShellResultM4907SwgkN = m4907SwgkN(adbSessionM4944wJVbdd, "id");
                    String strTrim = (adbShellResultM4907SwgkN == null || adbShellResultM4907SwgkN.getOutput() == null) ? BuildConfig.f24315FLAVOR : adbShellResultM4907SwgkN.getOutput().trim();
                    if (strTrim.contains("uid=2000")) {
                        m4938tQ(i, "已有配对仍然有效，复用连接: " + strTrim);
                        m4948yfx(adbSessionM4944wJVbdd);
                        m4896JrJO(i);
                        m4918alEkx();
                        return true;
                    }
                } catch (Throwable unused2) {
                    adbSession = adbSessionM4944wJVbdd;
                    if (adbSession != null) {
                        adbSession.close();
                    }
                }
            }
            adbSessionM4944wJVbdd.close();
        }
        return false;
    }

    /* renamed from: JBhc */
    public static String m4892JBhc(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("命令为空");
        }
        return m4913WGXroI(new YoKzxo(str), DurationKt.MILLIS_IN_MINUTE);
    }

    /* renamed from: JYgkl */
    public static void m4894JYgkl(int i, String str) {
        synchronized (f4839mjFkc) {
            if (i == f4834MiMN && !f4831ETF) {
                f4831ETF = true;
                f4840qdMbNW = false;
                f4830Dt = false;
                qGY qgy = f4837ZfxDd;
                if (qgy != null) {
                    qgy.mo4873wA(str);
                }
            }
        }
    }

    /* renamed from: JYn */
    public static Integer m4895JYn(String str) throws InterruptedException, IOException {
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

    /* renamed from: JrJO */
    public static void m4896JrJO(int i) {
        synchronized (f4839mjFkc) {
            if (i == f4834MiMN && !f4831ETF) {
                f4831ETF = true;
                f4830Dt = true;
                f4840qdMbNW = false;
                qGY qgy = f4837ZfxDd;
                if (qgy != null) {
                    qgy.mo4871AZxh();
                }
            }
        }
    }

    /* renamed from: KLMXS */
    public static void m4898KLMXS(Context context, String str) {
        if (context != null) {
            f4842xJ = context.getApplicationContext();
        }
        synchronized (f4839mjFkc) {
            try {
                if (!f4840qdMbNW && f4833KLFTb == null && f4832JHa == null && str != null && str.length() > 0) {
                    f4838lgHUyS = str;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: KRTLGT */
    public static AdbSession m4899KRTLGT(AdbPairing adbPairing) {
        AdbSession adbSession = (AdbSession) m4926huTpC(20000L, "ADB 会话验证", new Dt(adbPairing));
        if (adbSession != null) {
            return adbSession;
        }
        throw new IllegalStateException("openSession 返回 null");
    }

    /* renamed from: Moer */
    public static String m4901Moer(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("包名为空");
        }
        if (LocalAdbBridge.isReady()) {
            try {
                String strM4920bbzow = m4920bbzow("pm uninstall '" + str + "' 2>&1");
                if (strM4920bbzow != null && strM4920bbzow.toLowerCase().contains("success")) {
                    return strM4920bbzow.trim();
                }
            } catch (Throwable th) {
                m4938tQ(f4834MiMN, "本地 pm uninstall 失败，回退 ADB 会话卸载: " + th.getMessage());
            }
        }
        return m4913WGXroI(new ZfxDd(str), DurationKt.MILLIS_IN_MINUTE);
    }

    /* renamed from: NPj */
    public static boolean m4902NPj() {
        return f4830Dt;
    }

    /* renamed from: Ne */
    public static Method m4903Ne(Class cls, String str, int i) throws SecurityException {
        for (Method method : cls.getDeclaredMethods()) {
            if (method.getName().equals(str) && method.getParameterTypes().length == i + 1) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    /* renamed from: OjSQV */
    public static Object m4904OjSQV(String str) {
        try {
            IdentityStore.Companion companion = IdentityStore.INSTANCE;
            Object objNewInstance = IdentityStore.class.getConstructor(Context.class, String.class).newInstance(f4842xJ, str);
            Object objInvoke = IdentityStore.class.getMethod("load", null).invoke(objNewInstance, null);
            if (objInvoke == null && (objInvoke = m4932nxI(KeyPair.class)) != null) {
                IdentityStore.class.getMethod("save", KeyPair.class).invoke(objNewInstance, objInvoke);
            }
            if (objInvoke != null) {
                m4908Ucbh(objInvoke);
            }
            return objInvoke;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: SmIWf */
    public static void m4906SmIWf(int i, AdbPairing adbPairing) {
        AdbSession adbSession = null;
        try {
            m4938tQ(i, "正在打开 ADB 会话验证...");
            AdbSession adbSessionM4887GMIER = null;
            for (int i2 = 0; i2 < 2 && adbSessionM4887GMIER == null; i2++) {
                if (i2 > 0) {
                    try {
                        m4938tQ(i, "ADB 会话建立失败，2 秒后重试...");
                        try {
                            Thread.sleep(2000L);
                        } catch (InterruptedException unused) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        adbSession = adbSessionM4887GMIER;
                        try {
                            m4894JYgkl(i, "ADB 连接验证失败: " + th.getMessage());
                            if (adbSession != null) {
                                try {
                                    adbSession.close();
                                } catch (Exception unused2) {
                                }
                            }
                            synchronized (f4839mjFkc) {
                                try {
                                    if (i == f4834MiMN) {
                                        f4840qdMbNW = false;
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
                            synchronized (f4839mjFkc) {
                                try {
                                    if (i == f4834MiMN) {
                                        f4840qdMbNW = false;
                                    }
                                    throw th2;
                                } finally {
                                }
                            }
                        }
                    }
                }
                try {
                    adbSessionM4887GMIER = m4887GMIER(adbPairing);
                } catch (Exception e) {
                    if (i2 == 1) {
                        throw e;
                    }
                }
            }
            if (adbSessionM4887GMIER == null) {
                throw new IllegalStateException("无法建立 ADB 会话");
            }
            String str = (String) m4926huTpC(DurationKt.MILLIS_IN_MINUTE, "ADB Shell 验证", new qdMbNW(adbSessionM4887GMIER));
            if (!str.contains("uid=2000")) {
                throw new IllegalStateException("ADB Shell 未返回 uid=2000: " + str);
            }
            m4938tQ(i, "ADB Shell 已连接: " + str);
            m4948yfx(adbSessionM4887GMIER);
            m4896JrJO(i);
            m4918alEkx();
            synchronized (f4839mjFkc) {
                try {
                    if (i == f4834MiMN) {
                        f4840qdMbNW = false;
                    }
                } finally {
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: SwgkN */
    public static AdbShellResult m4907SwgkN(AdbSession adbSession, String str) {
        AdbShellResult adbShellResult = (AdbShellResult) BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new xJ(adbSession, str));
        if (adbShellResult != null) {
            return adbShellResult;
        }
        throw new IllegalStateException("ADB Shell 无返回");
    }

    /* renamed from: Ucbh */
    public static void m4908Ucbh(Object obj) {
        try {
            f4842xJ.getSharedPreferences("jc_adb_identity_backup", 0).edit().putString("priv", Base64.encodeToString(((PrivateKey) obj.getClass().getMethod("getPrivateKey", null).invoke(obj, null)).getEncoded(), 16)).putString("cert", Base64.encodeToString(((Certificate) obj.getClass().getMethod("getCertificate", null).invoke(obj, null)).getEncoded(), 16)).apply();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: Vdz */
    public static boolean m4910Vdz(Exception exc) {
        if (exc instanceof IOException) {
            return true;
        }
        String name = exc.getClass().getName();
        return name.contains("AdbStreamClosed") || name.contains("AdbTimeout") || name.contains("AdbAuthentication") || name.contains("AdbNotPaired");
    }

    /* renamed from: Vnb */
    public static boolean m4911Vnb(AdbSession adbSession) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objM4933oCFDzJ = m4933oCFDzJ(adbSession);
            return Boolean.TRUE.equals(objM4933oCFDzJ.getClass().getMethod("connectionCheck", null).invoke(objM4933oCFDzJ, null));
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: VocHEe */
    public static List m4912VocHEe() throws SocketException {
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

    /* renamed from: WGXroI */
    public static String m4913WGXroI(IEE iee, long j) {
        String str;
        synchronized (f4829AZxh) {
            Exception e = null;
            for (int i = 0; i < 2; i++) {
                try {
                    str = (String) m4926huTpC(j, "ADB 操作", new JHa(iee, (AdbSession) m4926huTpC(30000L, "ADB 会话建立", new KLFTb())));
                } catch (Exception e2) {
                    e = e2;
                    try {
                        m4928lB();
                        if (!m4910Vdz(e)) {
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

    /* renamed from: WrLQs */
    public static AdbSession m4914WrLQs(long j) {
        AdbPairing adbPairing;
        Object obj = f4839mjFkc;
        synchronized (obj) {
            try {
                AdbSession adbSession = f4832JHa;
                if (adbSession != null) {
                    return adbSession;
                }
                synchronized (obj) {
                    try {
                        if (f4833KLFTb == null) {
                            if (f4842xJ == null) {
                                throw new IllegalStateException("ADB 未初始化");
                            }
                            f4833KLFTb = AdbPairing.INSTANCE.m4356get(f4842xJ, f4838lgHUyS, m4888Gd(), GlobalScope.INSTANCE);
                        }
                        adbPairing = f4833KLFTb;
                    } finally {
                    }
                }
                AdbSession adbSessionM4887GMIER = m4887GMIER(adbPairing);
                if (adbSessionM4887GMIER == null) {
                    throw new IllegalStateException("无法建立 ADB 会话");
                }
                synchronized (obj) {
                    AdbSession adbSession2 = f4832JHa;
                    if (adbSession2 == null) {
                        f4832JHa = adbSessionM4887GMIER;
                        return adbSessionM4887GMIER;
                    }
                    if (adbSession2 != adbSessionM4887GMIER) {
                        try {
                            adbSessionM4887GMIER.close();
                        } catch (Exception unused) {
                        }
                    }
                    return adbSession2;
                }
            } finally {
            }
        }
    }

    /* renamed from: XV */
    public static void m4915XV(fehf fehfVar) {
        f4836YoKzxo = fehfVar;
    }

    /* renamed from: alEkx */
    public static void m4918alEkx() {
        new Thread(new rkYL(), "jc-local-adb").start();
    }

    /* renamed from: aqHPIZ */
    public static List m4919aqHPIZ() throws Throwable {
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

    /* renamed from: bbzow */
    public static String m4920bbzow(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("命令为空");
        }
        if (LocalAdbBridge.isReady()) {
            try {
                return LocalAdbBridge.execute(str, DurationKt.MILLIS_IN_MINUTE);
            } catch (LocalAdbBridge.mjFkc e) {
                LocalAdbBridge.resetReady();
                m4938tQ(f4834MiMN, "本地 ADB 通道失效，回退无线调试会话: " + e.getMessage());
            }
        }
        return m4892JBhc(str);
    }

    /* renamed from: cMLeY */
    public static void m4921cMLeY(Object obj, String str, Class[] clsArr, Object[] objArr) throws Exception {
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

    /* renamed from: dm */
    public static void m4923dm(int i, AdbPairing adbPairing) {
        synchronized (f4839mjFkc) {
            if (i == f4834MiMN && !f4831ETF && !f4835VA) {
                f4835VA = true;
                new Thread(new lgHUyS(i, adbPairing), "jc-adb-verify").start();
            }
        }
    }

    /* renamed from: huTpC */
    public static Object m4926huTpC(long j, String str, Callable callable) throws Exception {
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

    /* renamed from: jm */
    public static void m4927jm(String str) {
        fehf fehfVar = f4836YoKzxo;
        if (fehfVar != null) {
            fehfVar.mo4868mjFkc(str);
        } else {
            Log.i("AdbBridge", str);
        }
    }

    /* renamed from: lB */
    public static void m4928lB() {
        AdbSession adbSession;
        synchronized (f4839mjFkc) {
            adbSession = f4832JHa;
            f4832JHa = null;
        }
        if (adbSession != null) {
            try {
                adbSession.close();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: mByQ */
    public static void m4930mByQ(String str) {
        try {
            f4842xJ.getSharedPreferences("jc_adb_identity_backup", 0).edit().clear().apply();
        } catch (Throwable unused) {
        }
        try {
            f4842xJ.deleteSharedPreferences("adbeesh_identity_" + str);
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: nxI */
    public static Object m4932nxI(Class cls) {
        try {
            SharedPreferences sharedPreferences = f4842xJ.getSharedPreferences("jc_adb_identity_backup", 0);
            String string = sharedPreferences.getString("priv", null);
            String string2 = sharedPreferences.getString("cert", null);
            if (string != null && string2 != null) {
                return cls.getConstructor(PrivateKey.class, X509Certificate.class).newInstance(KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(string, 16))), CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(Base64.decode(string2, 16))));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: oCFDzJ */
    public static Object m4933oCFDzJ(AdbSession adbSession) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method method = adbSession.getClass().getMethod("getKadb", null);
        method.setAccessible(true);
        Object objInvoke = method.invoke(adbSession, null);
        if (objInvoke != null) {
            return objInvoke;
        }
        throw new IllegalStateException("ADB 会话为空");
    }

    /* renamed from: rWxwaT */
    public static boolean m4936rWxwaT(int i) {
        boolean z;
        synchronized (f4839mjFkc) {
            z = i == f4834MiMN;
        }
        return z;
    }

    /* renamed from: tQ */
    public static void m4938tQ(int i, String str) {
        m4927jm(str);
        synchronized (f4839mjFkc) {
            try {
                if (i != f4834MiMN) {
                    return;
                }
                qGY qgy = f4837ZfxDd;
                if (qgy != null) {
                    qgy.mo4872mjFkc(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: uHVRx */
    public static boolean m4939uHVRx() {
        if (LocalAdbBridge.isReady()) {
            try {
                String strExecute = LocalAdbBridge.execute("id", 5000L);
                if (strExecute != null) {
                    if (strExecute.contains("uid=2000")) {
                        return true;
                    }
                }
            } catch (LocalAdbBridge.mjFkc unused) {
                LocalAdbBridge.resetReady();
            } catch (Throwable unused2) {
            }
        }
        if (!LocalAdbBridge.isReady() && (f4830Dt || m4947xrEuO())) {
            m4918alEkx();
        }
        if (!f4830Dt && !m4947xrEuO()) {
            return false;
        }
        try {
            String str = (String) m4926huTpC(8000L, "ADB 通道探测", new AZxh());
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

    /* renamed from: vI */
    public static void m4940vI() {
        AdbPairing adbPairing;
        synchronized (f4839mjFkc) {
            f4840qdMbNW = false;
            f4831ETF = true;
            f4830Dt = false;
            f4834MiMN++;
            adbPairing = f4833KLFTb;
            f4833KLFTb = null;
        }
        f4841wA.clear();
        if (adbPairing != null) {
            try {
                adbPairing.close();
            } catch (Exception unused) {
            }
        }
        m4928lB();
    }

    /* renamed from: vadzgd */
    public static boolean m4941vadzgd() {
        return f4840qdMbNW;
    }

    /* renamed from: vjlshU */
    public static void m4942vjlshU(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        f4841wA.offer(str);
    }

    /* renamed from: wJVbdd */
    public static AdbSession m4944wJVbdd() {
        Object objM4904OjSQV;
        try {
        } catch (Throwable th) {
            m4938tQ(f4834MiMN, "ADB 直连异常: " + th.getMessage());
        }
        if (f4842xJ == null || (objM4904OjSQV = m4904OjSQV(f4838lgHUyS)) == null) {
            return null;
        }
        AdbClient.Companion companion = AdbClient.INSTANCE;
        Object objNewInstance = AdbClient.class.getConstructor(KeyPair.class, String.class).newInstance(objM4904OjSQV, "JC Code V3");
        Method methodM4903Ne = m4903Ne(AdbClient.class, "connect", 2);
        if (methodM4903Ne == null) {
            return null;
        }
        List listM4912VocHEe = m4912VocHEe();
        List listM4919aqHPIZ = m4919aqHPIZ();
        Integer numM4895JYn = m4895JYn("service.adb.tls.port");
        if (numM4895JYn != null && !listM4919aqHPIZ.contains(numM4895JYn)) {
            listM4919aqHPIZ.add(0, numM4895JYn);
        }
        Integer numM4895JYn2 = m4895JYn("service.adb.tcp.port");
        if (numM4895JYn2 != null && !listM4919aqHPIZ.contains(numM4895JYn2)) {
            listM4919aqHPIZ.add(numM4895JYn2);
        }
        Throwable th2 = null;
        for (int i = 0; i < listM4912VocHEe.size(); i++) {
            for (int i2 = 0; i2 < listM4919aqHPIZ.size(); i2++) {
                String str = (String) listM4912VocHEe.get(i);
                int iIntValue = ((Integer) listM4919aqHPIZ.get(i2)).intValue();
                if (m4946xROA(str, iIntValue)) {
                    try {
                        Object objM4926huTpC = m4926huTpC(8000L, "ADB 直连 " + str + ":" + iIntValue, new ETF(objNewInstance, methodM4903Ne, str, iIntValue));
                        if (objM4926huTpC != null) {
                            C0187Kadb.Companion companion2 = C0187Kadb.INSTANCE;
                            return (AdbSession) AdbSessionImpl.class.getConstructor(C0187Kadb.class).newInstance(objM4926huTpC);
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                    }
                }
            }
        }
        int i3 = f4834MiMN;
        StringBuilder sb = new StringBuilder();
        sb.append("ADB 直连未成功");
        sb.append(th2 != null ? "（" + th2.getMessage() + "）" : "（未发现可用 adbd 端口）");
        m4938tQ(i3, sb.toString());
        return null;
    }

    /* renamed from: xROA */
    public static boolean m4946xROA(String str, int i) throws IOException {
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

    /* renamed from: xrEuO */
    public static boolean m4947xrEuO() {
        boolean z;
        synchronized (f4839mjFkc) {
            z = f4832JHa != null;
        }
        return z;
    }

    /* renamed from: yfx */
    public static void m4948yfx(AdbSession adbSession) {
        AdbSession adbSession2;
        synchronized (f4839mjFkc) {
            adbSession2 = f4832JHa;
            f4832JHa = adbSession;
        }
        if (adbSession2 == null || adbSession2 == adbSession) {
            return;
        }
        try {
            adbSession2.close();
        } catch (Exception unused) {
        }
    }

    /* renamed from: zvd */
    public static String m4949zvd(File file, boolean z) {
        if (file == null || !file.exists()) {
            throw new IllegalStateException("安装包不存在");
        }
        String absolutePath = file.getAbsolutePath();
        boolean z2 = LocalAdbBridge.isReady() && (absolutePath.startsWith("/storage/") || absolutePath.startsWith("/sdcard/"));
        if (z2) {
            Context context = f4842xJ;
            String str = context != null ? context.getApplicationInfo().sourceDir : null;
            if (str != null) {
                m4927jm("安装通道①：app_process 安装代理（PackageInstaller 会话 API）");
                try {
                    String strM4920bbzow = m4920bbzow("CLASSPATH='" + str + "' app_process /system/bin com.jc.code.v3.InstallAgent '" + absolutePath + "' 2>&1");
                    if (strM4920bbzow != null && strM4920bbzow.contains("INSTALL_AGENT_OK")) {
                        m4927jm("安装代理成功: " + strM4920bbzow.trim().replace("\n", " | "));
                        return "Success";
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("安装代理未成功: ");
                    sb.append(strM4920bbzow != null ? strM4920bbzow.trim().replace("\n", " | ") : "(空)");
                    m4927jm(sb.toString());
                } catch (Throwable th) {
                    m4927jm("安装代理异常: " + th.getMessage() + "，走下一通道");
                }
            }
        }
        if (z2) {
            m4927jm("安装通道②：本地 ADB runner → pm install -r " + absolutePath);
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("pm install -r ");
                sb2.append(z ? "-d " : BuildConfig.f24315FLAVOR);
                sb2.append("'");
                sb2.append(absolutePath);
                sb2.append("' 2>&1");
                String strM4920bbzow2 = m4920bbzow(sb2.toString());
                if (strM4920bbzow2 != null && strM4920bbzow2.toLowerCase().contains("success")) {
                    m4927jm("本地 pm install 成功: " + strM4920bbzow2.trim());
                    return strM4920bbzow2.trim();
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("本地 pm install 未成功，输出: ");
                sb3.append(strM4920bbzow2 != null ? strM4920bbzow2.trim() : "(空)");
                sb3.append("，回退无线会话");
                m4927jm(sb3.toString());
            } catch (Throwable th2) {
                m4927jm("本地 pm install 异常: " + th2.getMessage() + "，回退无线会话");
            }
        } else {
            m4927jm("本地 runner 不可用(" + LocalAdbBridge.isReady() + ")，跳过本地通道");
        }
        m4927jm("安装通道③：无线调试会话 kadb install（本地回环推包）");
        return m4913WGXroI(new wA(z, file), 180000L);
    }
}
